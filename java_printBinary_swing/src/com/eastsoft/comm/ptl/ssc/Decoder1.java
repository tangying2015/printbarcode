package com.eastsoft.comm.ptl.ssc;
/**
 * 编码修改为UTF-8
 */
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import com.eastsoft.ptl.SscCfg;

public class Decoder1 extends CumulativeProtocolDecoder {

	public static byte [] ioBufferToByte(Object message)  
    {  
          if (!(message instanceof IoBuffer))  
          {  
              return null;  
          }  
          IoBuffer ioBuffer = (IoBuffer)message;  
          byte[] b = new byte[ioBuffer.limit()];  
          ioBuffer.get(b);  
          return b;  
    }
	
	
	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		
		out.write(ioBufferToByte(in));
		return false;
	}

}
