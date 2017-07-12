package com.orange.ftpserver.codec;

import java.io.Serializable;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class FtpResponseEncoder extends MessageToByteEncoder<Serializable> {

	@Override
	protected void encode(ChannelHandlerContext context, Serializable arg1, ByteBuf byteBuf) throws Exception {
		
	}
}
