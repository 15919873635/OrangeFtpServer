package com.orange.ftpserver.handler;

import io.netty.channel.ChannelHandlerContext;

public class FtpServerHandler extends AbstractFtpHandler {
	
	/**
	 * �յ�����Ϣû��ָ���Ľ�����ǡ� 
	 * ����ָ����lineBasedFrameDecoder��û�л��б�־���ǲ������channelRead�����ģ�
	 * ����������
	 */
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  
            throws Exception {
		System.out.println(ctx.name());
	}
}
