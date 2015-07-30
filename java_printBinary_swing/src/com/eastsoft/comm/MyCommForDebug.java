package com.eastsoft.comm;
/**
 * 编码修改为UTF-8
 */
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.serial.SerialAddress;
import org.apache.mina.transport.serial.SerialConnector;

import com.eastsoft.comm.ptl.ssc.CodecFactory;
import com.eastsoft.comm.ptl.ssc.CodecFactory1;
import com.eastsoft.comm.ptl.ssc.CommHandler;
import com.eastsoft.commcfg.CommCfg;
import com.eastsoft.commcfg.CommUtil;

public class MyCommForDebug {
	private IoConnector connector;
	private IoSession sessin;
	private CommCfg commCfg;
	private IshowMsg ishowMsg;
	private Iresponse response;

	public void setIshowMsg(IshowMsg ishowMsg) {
		this.ishowMsg = ishowMsg;
	}

	public MyCommForDebug(IshowMsg ishowMsg) {
		super();
		this.ishowMsg = ishowMsg;
		init();
	}
	public MyCommForDebug(IshowMsg ishowMsg,Iresponse response) {
		this(ishowMsg);
		this.response = response;
	}

	public void init() {
		commCfg = new CommCfg();
		commCfg.loadFromFile();
	}

	public boolean open() {
		try {
			commCfg.loadFromFile();
			connector = new SerialConnector();
			//SerialAddress portAddress = new SerialAddress("COM31", 9600, DataBits.DATABITS_8, StopBits.BITS_1, Parity.EVEN, FlowControl.NONE);

			SerialAddress portAddress = getSerialAddress(commCfg);
			//connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CodecFactory()));
			connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CodecFactory1()));

			connector.setHandler(new CommHandler(ishowMsg,response));
			ConnectFuture future = connector.connect(portAddress);
			future.awaitUninterruptibly();
			sessin = future.getSession();
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public boolean send(byte[] b) {
		sessin.write(b);
		return true;
	}

	public boolean close() {
		try {
			sessin.close(true);//.getCloseFuture().awaitUninterruptibly();				
			
		} catch (Exception e) {
			return false;
		}
		try {
			connector.dispose();
		} catch (Exception e) {
			return false;
		}
		if(sessin.isClosing()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void finalize() throws Throwable {
		close();
		super.finalize();
	}

	private SerialAddress getSerialAddress(CommCfg commCfg) {
		return new SerialAddress(commCfg.getPortName(), commCfg.getBaudRate(),
				CommUtil.getDataBitsFromRXTX(commCfg.getDatabits()),
				CommUtil.getStopBitsFromRXTX(commCfg.getStopbits()),
				CommUtil.getParityFromRXTX(commCfg.getParity()),
				CommUtil.getFLowControlFromRXTX(commCfg.getFlowControlIn(), commCfg.getFlowControlOut()));

	}
	
	public void setCommCfg( CommCfg commCfg){
		this.commCfg = commCfg;
	}
}
