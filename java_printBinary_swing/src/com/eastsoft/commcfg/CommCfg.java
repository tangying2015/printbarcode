package com.eastsoft.commcfg;
/**
 * ±àÂëĞŞ¸ÄÎªUTF-8
 */
/* @(#)SerialParameters.java	1.5 98/07/17 SMI
 *
 * Copyright (c) 1998 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license
 * to use, modify and redistribute this software in source and binary
 * code form, provided that i) this copyright notice and license appear
 * on all copies of the software; and ii) Licensee does not utilize the
 * software in a manner which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any kind.
 * ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND
 * ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THE
 * SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS
 * BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES,
 * HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING
 * OUT OF THE USE OF OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control
 * of aircraft, air traffic, aircraft navigation or aircraft
 * communications; or in the design, construction, operation or
 * maintenance of any nuclear facility. Licensee represents and
 * warrants that it will not use or redistribute the Software for such
 * purposes.
 */

import gnu.io.SerialPort;

public class CommCfg extends MyCfg {

	private static final String CS_FILENAME = "commCfg.cfg";

	public static final String[] CS_DATABIT = { "5", "6", "7", "8" };
	public static final String[] CS_STOPBIT = { "1", "2", "1.5" };
	public static final String[] CS_PARITY = { "None", "Even", "Odd" };

	private String portName;
	private int baudRate;
	private int flowControlIn;
	private int flowControlOut;
	private int databits;
	private int stopbits;
	private int parity;

	public CommCfg() {
		this("",
				9600,
				SerialPort.FLOWCONTROL_NONE,
				SerialPort.FLOWCONTROL_NONE,
				SerialPort.DATABITS_8,
				SerialPort.STOPBITS_1,
				SerialPort.PARITY_NONE);

	}

	public CommCfg(String portName,
			int baudRate,
			int flowControlIn,
			int flowControlOut,
			int databits,
			int stopbits,
			int parity) {

		setFilename(CS_FILENAME);
		this.portName = portName;
		this.baudRate = baudRate;
		this.flowControlIn = flowControlIn;
		this.flowControlOut = flowControlOut;
		this.databits = databits;
		this.stopbits = stopbits;
		this.parity = parity;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public String getPortName() {
		return portName;
	}

	public void setBaudRate(int baudRate) {
		this.baudRate = getBaudCode(baudRate);
	}

	public void setBaudRate(String baudRate) {
		this.baudRate = Integer.parseInt(baudRate);
	}

	public int getBaudRate() {
		return baudRate;
	}

	public String getBaudRateString() {
		return Integer.toString(baudRate);
	}

	public void setFlowControlIn(int flowControlIn) {
		this.flowControlIn = flowControlIn;
	}

	public void setFlowControlIn(String flowControlIn) {
		this.flowControlIn = stringToFlow(flowControlIn);
	}

	public int getFlowControlIn() {
		return flowControlIn;
	}

	public String getFlowControlInString() {
		return flowToString(flowControlIn);
	}

	public void setFlowControlOut(int flowControlOut) {
		this.flowControlOut = flowControlOut;
	}

	public void setFlowControlOut(String flowControlOut) {
		this.flowControlOut = stringToFlow(flowControlOut);
	}

	public int getFlowControlOut() {
		return flowControlOut;
	}

	public String getFlowControlOutString() {
		return flowToString(flowControlOut);
	}

	public void setDatabits(int databits) {
		this.databits = databits;
	}

	public void setDatabits(String databits) {
		if (databits.equals("5")) {
			this.databits = SerialPort.DATABITS_5;
		}
		if (databits.equals("6")) {
			this.databits = SerialPort.DATABITS_6;
		}
		if (databits.equals("7")) {
			this.databits = SerialPort.DATABITS_7;
		}
		if (databits.equals("8")) {
			this.databits = SerialPort.DATABITS_8;
		}
	}

	public int getDatabits() {
		return databits;
	}

	public String getDatabitsString() {
		switch (databits) {
		case SerialPort.DATABITS_5:
			return "5";
		case SerialPort.DATABITS_6:
			return "6";
		case SerialPort.DATABITS_7:
			return "7";
		case SerialPort.DATABITS_8:
			return "8";
		default:
			return "8";
		}
	}

	public void setStopbits(int stopbits) {
		this.stopbits = stopbits;
	}

	public void setStopbits(String stopbits) {
		if (stopbits.equals("1")) {
			this.stopbits = SerialPort.STOPBITS_1;
		}
		if (stopbits.equals("1.5")) {
			this.stopbits = SerialPort.STOPBITS_1_5;
		}
		if (stopbits.equals("2")) {
			this.stopbits = SerialPort.STOPBITS_2;
		}
	}

	public int getStopbits() {
		return stopbits;
	}

	public String getStopbitsString() {
		switch (stopbits) {
		case SerialPort.STOPBITS_1:
			return "1";
		case SerialPort.STOPBITS_1_5:
			return "1.5";
		case SerialPort.STOPBITS_2:
			return "2";
		default:
			return "1";
		}
	}

	public void setParity(int parity) {
		this.parity = parity;
	}

	public void setParity(String parity) {
		if (parity.equals("None")) {
			this.parity = SerialPort.PARITY_NONE;
		}
		if (parity.equals("Even")) {
			this.parity = SerialPort.PARITY_EVEN;
		}
		if (parity.equals("Odd")) {
			this.parity = SerialPort.PARITY_ODD;
		}
	}

	public int getParity() {
		return parity;
	}

	public String getParityString() {
		switch (parity) {
		case SerialPort.PARITY_NONE:
			return "None";
		case SerialPort.PARITY_EVEN:
			return "Even";
		case SerialPort.PARITY_ODD:
			return "Odd";
		default:
			return "None";
		}
	}

	private int stringToFlow(String flowControl) {
		if (flowControl.equals("None")) {
			return SerialPort.FLOWCONTROL_NONE;
		}
		if (flowControl.equals("Xon/Xoff Out")) {
			return SerialPort.FLOWCONTROL_XONXOFF_OUT;
		}
		if (flowControl.equals("Xon/Xoff In")) {
			return SerialPort.FLOWCONTROL_XONXOFF_IN;
		}
		if (flowControl.equals("RTS/CTS In")) {
			return SerialPort.FLOWCONTROL_RTSCTS_IN;
		}
		if (flowControl.equals("RTS/CTS Out")) {
			return SerialPort.FLOWCONTROL_RTSCTS_OUT;
		}
		return SerialPort.FLOWCONTROL_NONE;
	}

	String flowToString(int flowControl) {
		switch (flowControl) {
		case SerialPort.FLOWCONTROL_NONE:
			return "None";
		case SerialPort.FLOWCONTROL_XONXOFF_OUT:
			return "Xon/Xoff Out";
		case SerialPort.FLOWCONTROL_XONXOFF_IN:
			return "Xon/Xoff In";
		case SerialPort.FLOWCONTROL_RTSCTS_IN:
			return "RTS/CTS In";
		case SerialPort.FLOWCONTROL_RTSCTS_OUT:
			return "RTS/CTS Out";
		default:
			return "None";
		}
	}

	@Override
	public void writeDetail() {
		writeString("portName", portName);
		writeInteger("baudRate", baudRate);
		writeInteger("flowControlIn", flowControlIn);
		writeInteger("flowControlOut", flowControlOut);
		writeInteger("databits", databits);
		writeInteger("stopbits", stopbits);
		writeInteger("parity", parity);

	}

	@Override
	public void readDetail() {
		portName=readString("portName", "");
		baudRate=readInteger("baudRate", 9600);
		flowControlIn=readInteger("flowControlIn", SerialPort.FLOWCONTROL_NONE);
		flowControlOut=readInteger("flowControlOut", SerialPort.FLOWCONTROL_NONE);
		databits=readInteger("databits", SerialPort.DATABITS_8);
		stopbits=readInteger("stopbits", SerialPort.STOPBITS_1);
		parity=readInteger("parity", SerialPort.PARITY_NONE);

	}

	private int getBaudCode(int Baud) {

		if (Baud > 460800) {

			if (Baud >= 3000001 && Baud <= 3500000) {
				return 3500000;
			} else if (Baud >= 2500001 && Baud <= 3000000) {
				return 3000000;
			} else if (Baud >= 2000001 && Baud <= 2500000) {
				return 2500000;
			} else if (Baud >= 1500001 && Baud <= 2000000) {
				return 2000000;
			} else if (Baud >= 1152001 && Baud <= 1500000) {
				return 1500000;
			} else if (Baud >= 1000001 && Baud <= 1152000) {
				return 1152000;
			} else if (Baud >= 921601 && Baud <= 1000000) {
				return 1000000;
			} else if (Baud >= 576001 && Baud <= 921600) {
				return 921600;
			} else if (Baud >= 500001 && Baud <= 576000) {
				return 576000;
			} else if (Baud >= 460801 && Baud <= 500000) {
				return 500000;
			} else {
				return 4000000;
			}

		} else {
			if (Baud > 9600) {
				if (Baud >= 230401 && Baud <= 460800) {
					return 460800;
				} else if (Baud >= 115201 && Baud <= 230400) {
					return 230400;
				} else if (Baud >= 57601 && Baud <= 115200) {
					return 115200;
				} else if (Baud >= 38401 && Baud <= 57600) {
					return 57600;
				} else {
					return 19201;
				}

			} else {
				if (Baud >= 4801 && Baud <= 9600) {
					return 9600;
				} else if (Baud >= 2401 && Baud <= 4800) {
					return 4800;
				} else if (Baud >= 1801 && Baud <= 2400) {
					return 2400;
				} else if (Baud >= 1201 && Baud <= 1800) {
					return 1800;
				} else if (Baud >= 601 && Baud <= 1200) {
					return 1200;
				} else if (Baud >= 301 && Baud <= 600) {
					return 600;
				} else if (Baud >= 201 && Baud <= 300) {
					return 300;
				} else if (Baud >= 151 && Baud <= 200) {
					return 200;
				} else if (Baud >= 135 && Baud <= 150) {
					return 150;
				} else if (Baud >= 111 && Baud <= 134) {
					return 134;
				} else if (Baud >= 76 && Baud <= 110) {
					return 110;
				} else if (Baud >= 51 && Baud <= 75) {
					return 500000;
				} else if (Baud >= 1 && Baud <= 50) {
					return 50;
				} else {
					return 0;
				}
			}
		}
	}
}
