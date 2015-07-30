package com.eastsoft.ptl;
/**
 * 编码修改为UTF-8
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.eastsoft.util.ByteUtil;

public class Tssc1650 {

	private static final int[] CS_COMMAND1650 = { 2, 7 };
	public static final String CS_ID_NULL = "00000000";

	private String said, taid;
	private int prm, seq;

	int cmd; //0-010   读,1-111 写

	private String di;
	private String Data;
	private byte[] buf;

	public String getSaid() {
		return said;
	}

	public void setSaid(String said) {
		this.said = said;
	}

	public String getTaid() {
		return taid;
	}

	public void setTaid(String taid) {
		this.taid = taid;
	}

	public int getPrm() {
		return prm;
	}

	public void setPrm(int prm) {
		this.prm = prm;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public String getDi() {
		return di;
	}

	public void setDi(String di) {
		this.di = di;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public byte[] getBuf() {
		return buf;
	}

	public void setBuf(byte[] buf) {
		this.buf = buf;
	}

	public Tssc1650() {
		super();
		said = "";
		taid = "";
		prm = 0;
		seq = 1;
		cmd = 2;
		di = "";
		Data = "";
	}

	public static Tssc1650 makeSsc(String said, String taid, int prm, int seq, int cmd, String di, String data) throws IOException {
		Tssc1650 t = new Tssc1650();
		t.said = said;
		t.taid = taid;
		t.prm = prm;
		t.seq = seq;
		t.cmd = cmd;
		t.di = di;
		t.Data = data;
		t.build();
		return t;

	}

	public static Tssc1650 makeSsc(int seq, String di, String data) throws IOException {
		return makeSsc(CS_ID_NULL, CS_ID_NULL, 0, seq, 0, di, data);
	}

	public static Tssc1650 makeSsc(byte[] b) throws IOException {
		Tssc1650 t = new Tssc1650();
		t.setBuf(b);
		t.seperate();
		return t;
	}

	public void recalCs(byte[] p) {
		if (buf.length < 12) {
			return;
		}
		p[10] = (byte) (p.length - 12);
		byte ii = 0;
		for (int i = 0; i < p.length - 1; i++) {
			ii += p[i];
		}
		p[p.length - 1] = ii;
	}

	public void build16501(ByteArrayOutputStream baos) throws IOException {
		baos.write(Integer.parseInt(di, 16));
		baos.write(ByteUtil.byteSwap(ByteUtil.hexStringToByteArray(Data)));
	}

	public void build16502(ByteArrayOutputStream baos) throws IOException {
		//		baos.write(CS_COMMAND1650[cmd]);
		baos.write(cmd);

		baos.write(ByteUtil.byteSwap(ByteUtil.hexStringToByteArray(di)));

		if (cmd > 0) {
			byte[] b = ByteUtil.byteSwap(ByteUtil.hexStringToByteArray(Data));
			baos.write(b.length);
			baos.write(b);
		}
	}

	public void build() throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(SscCfg.CS_FRAME_HEADER);
		baos.write(ByteUtil.hexStringToByteArray(said));
		baos.write(ByteUtil.hexStringToByteArray(taid));
		baos.write(seq | (prm << 7));
		baos.write(0);
		if (CS_ID_NULL.equals(said) && CS_ID_NULL.equals(taid)) {
			build16501(baos);
		} else {
			build16502(baos);
		}
		baos.write(0);
		buf = baos.toByteArray();
		recalCs(buf);
	}

	public void seperate() {
		said = ByteUtil.byteArrayToHexStr(ByteUtil.byteSwap(ByteUtil.copyByteArray(buf, 1, 4)));
		taid = ByteUtil.byteArrayToHexStr(ByteUtil.byteSwap(ByteUtil.copyByteArray(buf, 5, 4)));
		prm = buf[9] >>> 7;
		seq = buf[9] & 0x7F;

		int datalen = buf[10] & 0xFF;
		if (CS_ID_NULL.equals(said) && CS_ID_NULL.equals(taid)) {
			if (datalen > 0) {
				di = ByteUtil.byteToHexStr(buf[11]);
				if (datalen > 1) {
					Data = ByteUtil.byteArrayToHexStr(ByteUtil.byteSwap(ByteUtil.copyByteArray(buf, 12, datalen - 1)));
				}

			}
		} else {

		}

	}

	public String asString() {

		return String.format("said = %1$s, taid = %2$s, prm = %3$d, seq = %4$d, cmd = %5$d, di = %6$s, Data = %7$s", said, taid, prm, seq, cmd, di, Data);
	}

}
