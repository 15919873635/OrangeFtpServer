package com.orange.ftpserver.codec;

import com.orange.ftpserver.context.FtpResponse;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class FtpResponseEncoder extends MessageToByteEncoder<FtpResponse> {

	@Override
	protected void encode(ChannelHandlerContext context, FtpResponse ftpResponse, ByteBuf byteBuf) throws Exception {
		byteBuf.writableBytes();
	}
}
