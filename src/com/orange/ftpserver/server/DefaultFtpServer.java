package com.orange.ftpserver.server;

import java.net.InetSocketAddress;
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


public class DefaultFtpServer implements FtpServer {
	
	private ExecutorService bossGroup;
	private ExecutorService workerGroup;
	
	public DefaultFtpServer(){
		
	}
	
	@Override
	public void start() {
		ServerBootstrap bootstrap = new ServerBootstrap();  
		bossGroup = Executors.newCachedThreadPool();  
		workerGroup = Executors.newCachedThreadPool();  
        bootstrap.setFactory(new NioServerSocketChannelFactory(bossGroup, workerGroup));  
        // ���ùܵ��Ĺ���  
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
}