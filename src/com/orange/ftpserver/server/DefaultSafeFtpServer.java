package com.orange.ftpserver.server;

import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManagerFactory;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.handler.ssl.SslHandler;

import com.orange.ftpserver.context.IFtpContext;

public final class DefaultSafeFtpServer extends AbstractFtpServer{	
	
	public DefaultSafeFtpServer(IFtpContext ftpContext){
		super(ftpContext);
		safeMode = "TLS";
	}
	
	public DefaultSafeFtpServer(IFtpContext ftpContext,int serverPort){
		super(ftpContext,serverPort);
		safeMode = "TLS";
	}

	@Override
	protected void addSSL(ChannelPipeline pipeline) {
		try{
			String keyStorePassword = "aerohive";  
			KeyStore ks = KeyStore.getInstance("JKS");  
	        ks.load(DefaultSafeFtpServer.class.getClassLoader().getResourceAsStream("cert\\server.keystore"), keyStorePassword.toCharArray());  
	
	        // Set up key manager factory to use our key store  
	        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());  
	        kmf.init(ks, keyStorePassword.toCharArray());  
	
	        // truststore  
	        KeyStore ts = KeyStore.getInstance("JKS");  
	        ts.load(DefaultSafeFtpServer.class.getClassLoader().getResourceAsStream("cert\\servertruststore.keystore"), keyStorePassword.toCharArray());  
	
	        // set up trust manager factory to use our trust store  
	        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());  
	        tmf.init(ts);  
	
	        // Initialize the SSLContext to work with our key managers.  
	        SSLContext serverContext = SSLContext.getInstance(safeMode);  
	        serverContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
	        SSLEngine sslEngine = serverContext.createSSLEngine();  
	        sslEngine.setUseClientMode(false);  
	        pipeline.addFirst("sslHandler", new SslHandler(sslEngine));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
