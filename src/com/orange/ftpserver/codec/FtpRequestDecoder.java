package com.orange.ftpserver.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LineBasedFrameDecoder;

public class FtpRequestDecoder extends LineBasedFrameDecoder {
	 
	public FtpRequestDecoder() {
		super(1024);
	}

	@Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception 
    {
        return super.decode(ctx, in);
    }
}
