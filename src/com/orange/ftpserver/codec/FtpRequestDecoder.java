package com.orange.ftpserver.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class FtpRequestDecoder extends LengthFieldBasedFrameDecoder {

	private static final int MAX_FRAME_LENGTH = 8192 * 2;
    private static final int LENGTH_FIELD_OFFSET = 1;
    private static final int LENGTH_FIELD_LENGTH = 1;
    private static final int LENGTH_FIELD_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;
	
    /** 
     *  
     * @param maxFrameLength 解码时，处理每个帧数据的最大长度 
     * @param lengthFieldOffset 该帧数据中，存放该帧数据的长度的数据的起始位置 
     * @param lengthFieldLength 记录该帧数据长度的字段本身的长度 
     * @param lengthAdjustment 修改帧数据长度字段中定义的值，可以为负数 
     * @param initialBytesToStrip 解析的时候需要跳过的字节数 
     * @param failFast 为true，当frame长度超过maxFrameLength时立即报TooLongFrameException异常，为false，读取完整个帧再报异常 
     */  
	public FtpRequestDecoder() {
		super(MAX_FRAME_LENGTH, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH, LENGTH_FIELD_ADJUSTMENT, INITIAL_BYTES_TO_STRIP);
	}

	@Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception 
    {
        return super.decode(ctx, in);
    }
}
