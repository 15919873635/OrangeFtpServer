package com.orange.ftpserver.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class FtpRequestDecoder extends LengthFieldBasedFrameDecoder {

	private static final int MAX_PACKET_LENGTH = 8192 * 2;
    private static final int LENGTH_FIELD_OFFSET = 1;
    private static final int LENGTH_FIELD_LENGTH = 1;
    private static final int LENGTH_FIELD_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;
	
	public FtpRequestDecoder() {
		super(MAX_PACKET_LENGTH, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH, LENGTH_FIELD_ADJUSTMENT, INITIAL_BYTES_TO_STRIP);
	}

	@Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception 
    {
        return super.decode(ctx, in);
    }
}
