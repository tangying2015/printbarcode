package com.eastsoft.comm.ptl.ssc;
/**
 * 编码修改为UTF-8
 */
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class Encoder extends ProtocolEncoderAdapter {

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {

		byte[] data = (byte[]) message;
		IoBuffer buf = IoBuffer.allocate(data.length).setAutoExpand(true);
		buf.put(data);
		buf.flip();
		out.write(buf);

	}

}
