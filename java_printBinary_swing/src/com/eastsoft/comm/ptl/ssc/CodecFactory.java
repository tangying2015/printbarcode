package com.eastsoft.comm.ptl.ssc;
/**
 * 编码修改为UTF-8
 */
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class CodecFactory implements ProtocolCodecFactory {
	private final Decoder decoder;
	private final Encoder encoder;

	public CodecFactory() {
		encoder = new Encoder();
		decoder = new Decoder();
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return decoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return encoder;
	}

}
