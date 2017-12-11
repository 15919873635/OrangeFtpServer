package com.orange.ftpserver.server;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import com.orange.ftpserver.context.IFtpContext;
import com.orange.ftpserver.handler.FtpServerCommandHandler;

public abstract class AbstractFtpServer implements IFtpServer{
	
	protected ExecutorService bossGroup;
	protected ExecutorService workerGroup;
	protected ServerBootstrap serverBootstrap;
	protected ClientBootstrap clientBootstrap;
	protected int serverPort;
	protected String safeMode = "";
	private IFtpContext ftpContext;
	
	public AbstractFtpServer(IFtpContext ftpContext){
		this.ftpContext = ftpContext;
		serverPort = 21;
	}
	
	public AbstractFtpServer(IFtpContext ftpContext,int serverPort){
		this.ftpContext = ftpContext;
		this.serverPort = serverPort;
	}
	
	public AbstractFtpServer(IFtpContext ftpContext,int serverPort,String safeMode){
		this.ftpContext = ftpContext;
		this.serverPort = serverPort;
		this.safeMode = safeMode;
	}
	protected abstract void addSSL(ChannelPipeline pipeline);
	
	@Override
	public void start() {
		bossGroup = Executors.newCachedThreadPool();  
		workerGroup = Executors.newCachedThreadPool(); 
		serverBootstrap = new ServerBootstrap(); 
		clientBootstrap = new ClientBootstrap();
		clientBootstrap.setFactory(new NioClientSocketChannelFactory(bossGroup, workerGroup));
		serverBootstrap.setFactory(new NioServerSocketChannelFactory(bossGroup, workerGroup));  
        // 设置管道的工厂  
		serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {  
            @Override  
            public ChannelPipeline getPipeline() throws Exception {  
                ChannelPipeline pipeline = Channels.pipeline();  
                pipeline.addLast("stringDecoder", new StringDecoder());
                pipeline.addLast("stringEncoder", new StringEncoder());
                pipeline.addLast("ftpServerCommandHandler", new FtpServerCommandHandler(ftpContext));  
                return pipeline;  
            }  
        });
		clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				ChannelPipeline pipeline = Channels.pipeline();  
                pipeline.addLast("stringDecoder", new StringDecoder());
                pipeline.addLast("stringEncoder", new StringEncoder());
                pipeline.addLast("ftpServerHandler", new FtpServerCommandHandler(ftpContext));  
                return pipeline;  
			}
		});
        addSSL(serverBootstrap.getPipeline());
        serverBootstrap.bind(new InetSocketAddress(serverPort));  
        clientBootstrap.bind(new InetSocketAddress(20));
	}

	@Override
	public void close() {
		if(workerGroup != null)
			workerGroup.shutdownNow();
		if(bossGroup != null)
			bossGroup.shutdownNow();
	}
	
	public void setServerPort(int serverPort){
		this.serverPort = serverPort;
	}

	@Override
	public int getServerPort() {
		return this.serverPort;
	}
	
	public void setSafeMode(String safeMode){
		this.safeMode = safeMode;
	}
	
	public String getMode(){
		return this.safeMode;
	}
}
