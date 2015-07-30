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
import com.eastsoft.comm.ptl.ssc.CommHandler;
import com.eastsoft.commcfg.CommCfg;
import com.eastsoft.commcfg.CommUtil;

public class MyComm {
	private IoConnector connector;
	private IoSession sessin;
	private CommCfg commCfg;
	private IshowMsg ishowMsg;

	public void setIshowMsg(IshowMsg ishowMsg) {
		this.ishowMsg = ishowMsg;
	}

	public MyComm(IshowMsg ishowMsg) {
		super();
		this.ishowMsg = ishowMsg;
		init();
	}

	public void init() {
		commCfg = new CommCfg();
		commCfg.loadFromFile();
	}

	public boolean open() {
		try {

			commCfg.loadFromFile();

			connector = new SerialConnector();
			//			SerialAddress portAddress = new SerialAddress("COM31", 9600, DataBits.DATABITS_8, StopBits.BITS_1, Parity.EVEN, FlowControl.NONE);

			SerialAddress portAddress = getSerialAddress(commCfg);
			connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CodecFactory()));
			//connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CodecFactory1()));

			connector.setHandler(new CommHandler(ishowMsg));
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

	public void close() {
		try {
			sessin.close(true);//force close right now
		} catch (Exception e) {
		}
		try {
			connector.dispose();
		} catch (Exception e) {
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
}
