package com.eastsoft.commcfg;
/**
 * ±àÂëÐÞ¸ÄÎªUTF-8
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public abstract class MyCfg {
	Properties p = new Properties();
	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public MyCfg() {

	}

	public MyCfg(String filename) {
		this.filename = filename;
	}

	public void writeString(String key, String value) {
		p.put(key, value);
	}

	public void writeInteger(String key, int value) {
		writeString(key,String.valueOf(value));
	}

	public void writeBool(String key, Boolean value) {
		writeString(key,String.valueOf(value));
	}

	public abstract void writeDetail();

	public void saveToFile(String filename) {
		try {
			p.clear();
			writeDetail();
			p.store(new FileOutputStream(filename), "a");
		} catch (IOException ex) {
		}

	}

	public String readString(String key, String defaultValue) {
		String s = p.getProperty(key);
		return StringUtils.isEmpty(s) ? defaultValue : s;
	}

	public int readInteger(String key, int defaultValue) {
		String s = p.getProperty(key);
		return StringUtils.isEmpty(s) ? defaultValue : Integer.valueOf(s);
	}

	public boolean readBool(String key, Boolean defaultValue) {
		String s = p.getProperty(key);
		return StringUtils.isEmpty(s) ? defaultValue : Boolean.valueOf(s);
	}

	public abstract void readDetail();

	public void loadFromFile(String filename) {
		try {
			p.clear();
			p.load(new FileInputStream(filename));
			readDetail();
		} catch (IOException ex) {
		}
	}

	public void saveToFile() {
		saveToFile(filename);

	}

	public void loadFromFile() {
		loadFromFile(filename);
	}

}
