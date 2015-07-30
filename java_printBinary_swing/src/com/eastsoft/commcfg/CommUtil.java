package com.eastsoft.commcfg;
/**
 * ±àÂëÐÞ¸ÄÎªUTF-8
 */
import gnu.io.SerialPort;

import java.security.InvalidParameterException;

import org.apache.mina.transport.serial.SerialAddress.DataBits;
import org.apache.mina.transport.serial.SerialAddress.FlowControl;
import org.apache.mina.transport.serial.SerialAddress.Parity;
import org.apache.mina.transport.serial.SerialAddress.StopBits;

public class CommUtil {

	public static DataBits getDataBitsFromRXTX(int dataBits) {
		switch (dataBits) {
		case SerialPort.DATABITS_5:
			return DataBits.DATABITS_5;
		case SerialPort.DATABITS_6:
			return DataBits.DATABITS_6;
		case SerialPort.DATABITS_7:
			return DataBits.DATABITS_7;
		case SerialPort.DATABITS_8:
			return DataBits.DATABITS_8;
		}
		throw new InvalidParameterException("broken databits");
	}

	public static StopBits getStopBitsFromRXTX(int stopBits) {
		switch (stopBits) {
		case SerialPort.STOPBITS_1:
			return StopBits.BITS_1;
		case SerialPort.STOPBITS_1_5:
			return StopBits.BITS_1_5;
		case SerialPort.STOPBITS_2:
			return StopBits.BITS_2;
		}
		throw new InvalidParameterException("broken stopbits");
	}

	public static	Parity getParityFromRXTX(int parity) {
		switch (parity) {
		case SerialPort.PARITY_EVEN:
			return Parity.EVEN;
		case SerialPort.PARITY_MARK:
			return Parity.MARK;
		case SerialPort.PARITY_NONE:
			return Parity.NONE;
		case SerialPort.PARITY_ODD:
			return Parity.ODD;
		case SerialPort.PARITY_SPACE:
			return Parity.SPACE;
		}
		throw new InvalidParameterException("broken parity");
	}

	public static	FlowControl getFLowControlFromRXTX(int flowControl_in ,int  flowControl_out) {
		
		switch (flowControl_in | flowControl_out) {
		case SerialPort.FLOWCONTROL_NONE:
			return FlowControl.NONE;
		case SerialPort.FLOWCONTROL_RTSCTS_IN:
			return FlowControl.RTSCTS_IN;
		case SerialPort.FLOWCONTROL_RTSCTS_OUT:
			return FlowControl.RTSCTS_OUT;
		case SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT:
			return FlowControl.RTSCTS_IN_OUT;
		case SerialPort.FLOWCONTROL_XONXOFF_IN:
			return FlowControl.XONXOFF_IN;
		case SerialPort.FLOWCONTROL_XONXOFF_OUT:
			return FlowControl.XONXOFF_OUT;
		case SerialPort.FLOWCONTROL_XONXOFF_IN | SerialPort.FLOWCONTROL_XONXOFF_OUT:
			return FlowControl.XONXOFF_IN_OUT;
		}
		throw new InvalidParameterException("broken flow control");
	}
}
