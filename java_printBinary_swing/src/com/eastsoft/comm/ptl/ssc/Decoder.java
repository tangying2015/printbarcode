package com.eastsoft.comm.ptl.ssc;
/**
 * 编码修改为UTF-8
 */
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import com.eastsoft.ptl.SscCfg;

public class Decoder extends CumulativeProtocolDecoder {

	private int minLineLength = 12;

	private int maxLineLength = 255;

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
//		System.out.println("in.pos = " + String.valueOf(in.position()));
		while (in.remaining() >= minLineLength) {
			while (in.hasRemaining()) {
				if (in.get() == SscCfg.CS_FRAME_HEADER) {
					break;
				}
			}

			if (in.remaining() >= minLineLength - 1) {
				in.mark();
				in.position(in.position() + 8);
				int length = in.get();//0x80 = 128 ,如果超过了128，则就会成为负数。
				in.reset();
				if (length>maxLineLength || in.remaining() < length + 11 ) {
					continue;
				}

				byte cs = SscCfg.CS_FRAME_HEADER;
				for (int i = 0; i < length + 10; i++) {
					cs += in.get();
				}
				if (cs != in.get()) {
					in.reset();
					continue;
				}

				in.reset();
				in.position(in.position() - 1);

				byte[] data = new byte[length + 12];
				in.get(data, 0, length + 12);
				out.write(data);

				if (in.hasRemaining()) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

}
