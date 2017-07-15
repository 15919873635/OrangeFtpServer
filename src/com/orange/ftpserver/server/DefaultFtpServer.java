package com.orange.ftpserver.server;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import com.orange.ftpserver.handler.FtpServerHandler;
import com.orange.ftpserver.listener.DefaultFtpServerListener;
import com.orange.ftpserver.listener.FtpServerListener;
import com.orange.ftpserver.user.UserManager;


public class DefaultFtpServer implements FtpServer {
	
	private Map<String,FtpServerListener> serverListenerMap =new HashMap<String,FtpServerListener>();
	private UserManager userManager;
	
	private ExecutorService bossGroup;
	private ExecutorService workerGroup;
	
	public DefaultFtpServer(){
		FtpServerListener defaultServerListener = new DefaultFtpServerListener();
		serverListenerMap.put("default", defaultServerListener);
	}
	
	@Override
	public void start() {
		ServerBootstrap bootstrap = new ServerBootstrap();  
		bossGroup = Executors.newCachedThreadPool();  
		workerGroup = Executors.newCachedThreadPool();  
        bootstrap.setFactory(new NioServerSocketChannelFactory(bossGroup, workerGroup));  
        // 设置管道的工厂  
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {  
            @Override  
            public ChannelPipeline getPipeline() throws Exception {  
                ChannelPipeline pipeline = Channels.pipeline();  
                pipeline.addLast("stringDecoder", new StringDecoder());
                pipeline.addLast("stringEncoder", new StringEncoder());
                pipeline.addLast("ftpServerHandler", new FtpServerHandler());  
                return pipeline;  
            }  
        });  
        bootstrap.bind(new InetSocketAddress(13100));  
	}

	@Override
	public void close() {
		if(workerGroup != null)
			workerGroup.shutdownNow();
		if(bossGroup != null)
			bossGroup.shutdownNow();
	}
	
	public void setServerListeners(Map<String, FtpServerListener> serverListenerMap){
		this.serverListenerMap = serverListenerMap;
	}
	
	@Override
	public Map<String, FtpServerListener> getServerListeners() {
		return serverListenerMap;
	}

	@Override
	public UserManager getUserManager() {
		return userManager;
	}
}