package com.orange.ftpserver.server;

import java.util.HashMap;
import java.util.Map;

import com.orange.ftpserver.codec.FtpRequestDecoder;
import com.orange.ftpserver.handler.FtpServerHandler;
import com.orange.ftpserver.listener.DefaultFtpServerListener;
import com.orange.ftpserver.listener.FtpServerListener;
import com.orange.ftpserver.user.UserManager;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;

public class DefaultFtpServer implements FtpServer {
	
	private Map<String,FtpServerListener> serverListenerMap =new HashMap<String,FtpServerListener>();
	private UserManager userManager;
	
	private EventLoopGroup bossGroup;
	private EventLoopGroup workerGroup;
	
	public DefaultFtpServer(){
		FtpServerListener defaultServerListener = new DefaultFtpServerListener();
		serverListenerMap.put("default", defaultServerListener);
	}
	
	@Override
	public void start() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();  
		EventLoopGroup workerGroup = new NioEventLoopGroup();  
        try {  
        	ServerBootstrap serverBootstrap = new ServerBootstrap();  
        	serverBootstrap.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)  
             .childHandler(new ChannelInitializer<SocketChannel>() {  
                        @Override  
                        public void initChannel(SocketChannel ch)  
                                throws Exception {
                        	ch.pipeline().addLast(new FtpRequestDecoder());
                        	ch.pipeline().addLast(new StringDecoder());
                        	ch.pipeline().addLast(new ObjectEncoder());
                            ch.pipeline().addLast(new FtpServerHandler());  
                        }  
              })
              .option(ChannelOption.SO_BACKLOG, 128)  
              .childOption(ChannelOption.SO_KEEPALIVE, true);  
  
            ChannelFuture f = serverBootstrap.bind(13100).sync();  
            f.channel().closeFuture().sync();  
        } catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
            workerGroup.shutdownGracefully();  
            bossGroup.shutdownGracefully();  
        }
	}

	@Override
	public void close() {
		if(workerGroup != null)
			workerGroup.shutdownGracefully();
		if(bossGroup != null)
			bossGroup.shutdownGracefully();
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