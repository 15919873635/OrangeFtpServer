package com.orange.ftpserver.codec;

import java.util.List;

import com.orange.ftpserver.context.DefaultFtpRequest;
import com.orange.ftpserver.context.FtpRequest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class FtpRequestDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext context, ByteBuf byteBuf, List<Object> objects) throws Exception {
		FtpRequest ftpRequest = new DefaultFtpRequest();
		objects.add(ftpRequest);
	}
}
