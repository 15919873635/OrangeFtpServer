package com.orange.ftpserver.server;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.frame.LineBasedFrameDecoder;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import com.orange.ftpserver.context.IFtpContext;
import com.orange.ftpserver.handler.FtpServerCommandHandler;
import com.orange.ftpserver.handler.FtpServerDataHandler;

public abstract class AbstractFtpServer implements IFtpServer{
	
	private ExecutorService bossGroup;
	private ExecutorService workerGroup;
	private ServerBootstrap serverBootstrap;
	private ClientBootstrap clientBootstrap;
	private ChannelGroup serverChannelGroup;
	private ChannelGroup clientChannelGroup;
	private int serverPort;
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
		startServerPort(serverPort);
	}
	
	public void startServerPort(int serverPort){
		initServerPipeline(serverPort);
		Channel serverChannel = serverBootstrap.bind(new InetSocketAddress(serverPort)); 
        serverChannelGroup.add(serverChannel);
	}
	
	protected void initServerPipeline(int serverPort){
		if(serverBootstrap == null){
			serverBootstrap = new ServerBootstrap(); 
			serverBootstrap.setFactory(new NioServerSocketChannelFactory(bossGroup, workerGroup));  
	        // 设置管道的工厂  
			serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {  
	            @Override  
	            public ChannelPipeline getPipeline() throws Exception {  
	                ChannelPipeline pipeline = Channels.pipeline(); 
	                pipeline.addLast("lineBasedFrameDecoder", new LineBasedFrameDecoder(1024));
	                pipeline.addLast("stringDecoder", new StringDecoder());
	                pipeline.addLast("stringEncoder", new StringEncoder());
	                pipeline.addLast("ftpServerCommandHandler", new FtpServerCommandHandler(ftpContext));  
	                return pipeline;  
	            }  
	        });
	        addSSL(serverBootstrap.getPipeline());
		}
	}
	
	@Override
	public void startClientPort(int clientPort) {
		initClientPipeline(clientPort);
		clientBootstrap.bind(new InetSocketAddress(clientPort));
		ChannelFuture channelFuture = clientBootstrap.connect(new InetSocketAddress(clientPort));
		clientChannelGroup.add(channelFuture.getChannel());
	}
	
	protected void initClientPipeline(int clientPort){
		if(clientBootstrap == null){
			clientBootstrap = new ClientBootstrap();
			clientBootstrap.setFactory(new NioClientSocketChannelFactory(bossGroup, workerGroup));
			clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
				@Override
				public ChannelPipeline getPipeline() throws Exception {
					ChannelPipeline pipeline = Channels.pipeline();  
	                pipeline.addLast("lineBasedFrameDecoder", new LineBasedFrameDecoder(1024));
	                pipeline.addLast("stringDecoder", new StringDecoder());
	                pipeline.addLast("stringEncoder", new StringEncoder());
	                pipeline.addLast("ftpServerDataHandler", new FtpServerDataHandler(ftpContext));  
	                return pipeline;  
				}
			});
			addSSL(clientBootstrap.getPipeline());
		}
	}
	
	@Override
	public void close() {
		if(serverBootstrap != null && serverChannelGroup != null){
			serverChannelGroup.close().awaitUninterruptibly();
			serverBootstrap.releaseExternalResources();
		}
		if(clientBootstrap != null && clientChannelGroup != null){
			clientChannelGroup.close().awaitUninterruptibly();
			clientBootstrap.releaseExternalResources();
		} 
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
	
	public String getSafeMode(){
		return this.safeMode;
	}
	
	public ChannelGroup getServerGroup(){
		return this.serverChannelGroup;
	}
	
	public ChannelGroup getClientGroup(){
		return this.clientChannelGroup;
	}
}
