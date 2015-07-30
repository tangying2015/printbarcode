package com.eastsoft.ui;
/**
 * 编码修改为UTF-8
 */
import gnu.io.CommPortIdentifier;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import org.apache.poi.hssf.record.formula.functions.Value;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.eastsoft.barcode.QRCode;
import com.eastsoft.comm.IshowMsg;
import com.eastsoft.comm.MyCommForDebug;
import com.eastsoft.comm.Iresponse;
import com.eastsoft.commcfg.CommCfg;
import com.eastsoft.print.MyPaperFormat;
import com.eastsoft.print.MyPrint;
import com.eastsoft.ptl.Tssc1650;
import com.eastsoft.sqlitedb.SqliteDb;
import com.eastsoft.util.DeviceTypesID;
import com.eastsoft.util.DevicesName;
import com.eastsoft.util.LabelsUtil;
import com.eastsoft.util.PrintFinal;
import com.eastsoft.util.StringUtil;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MainUI extends JFrame implements IshowMsg, Iresponse {
	private static final String PASSWD_PREFIX = "password ";
	private static final String DEV_TYPE_PREFIX = "type ";
	private JPanel jPanel1;
	private JLabel jLabel_chooseDatabit;
	private JTextField jTextField_insertCurrent;
	public JComboBox jComboBox_chooseCurrent;
	private JButton jButton_delete;
	private JButton jButton_repeatPrint;
	private JButton jButton_printLabel;
	private JButton jButton_insertInfor;
	private JComboBox jComboBox_chooseDatabit;
	private JLabel jLabel_chooseStopBit;
	private JTextArea jTextArea_sendTest;
	private JComboBox jComboBox_choosePorityBit;
	private JLabel jLabel_choosePorityBit;
	private JComboBox jComboBox_chooseStopBit;
	public JComboBox jComboBox_choosePrintFormat;
	private JLabel jLabel4;
	private JTextField jTextField_insertPower;
	private JTextField jTextField_insertVoltage;
	private JTextField jTextField_insertCompany;
	private JTextField jTextField_insertProductType;
	private JTextField jTextField_insertdevice;
	private JPanel jPanel5;
	private JTextField jTextField_tester;
	private JLabel jLabel1;
	private JTextField jTextField_frequency;
	public JComboBox jComboBox_choosePower;
	public JComboBox jComboBox_chooseVoltage;
	//公司名称下拉框 add by wangrichao
	public JComboBox jComboBox_chooseCompany;
	public JComboBox jComboBox_chooseProductType;
	static public JComboBox jComboBox_chooseDevice;
	private JLabel jLabel_productSerialNO;
	private JLabel jLabel_frequency;
	private JLabel jLabel_eDingPower;
	private JLabel jLabel_eDingVoltage;
	//公司名称 add by wangrichao 
	private JLabel jLabel_companyName;
	private JLabel jLabel_chooseProductType;
	private JLabel jLabel_chooseDevice;
	private JButton jButton_productBinary;
	private JPanel jPanel4;
	private JPanel jPanel3;
	public JTextField jTextField_writePasswd;
	private JLabel jLabel_writePasswd;
	private JLabel jLabel_readaid;
	private JPanel jPanel2;
	private JButton jButton_openPort;
	private JButton jButton_sendTest;
	private JComboBox jComboBox_chooseBoundrate;
	private JLabel jLabel_chooseBoundrate;
	private JLabel jLabel_choosePorts;
	private JComboBox jCombox_choosePorts;

	private JButton jButton_writeaddress;
	private JTextField jTextField_address;
	private JLabel jLabel5;
	public JTextArea jTextArea_status;
	private JPanel jPanel7;
	private QRCode mQRCode;
	private QRCode newQRCode;
	static CommPortIdentifier portId;
	static Enumeration portList;

	private JPanel jPanel9;// 新添加项目
	private JLabel jLabel_chooseDevice_9;// 新项目选择设备
	private JComboBox jComboBox_chooseDevice_9;
	private JLabel jLabel_DeviceID_9;// 设备地址
	private JTextField jTextField_DeviceID_9;
	private JLabel jLabel_DeviceSSID_9;// 设备ssid
	private JComboBox jComboBox_chooseDeviceSSID_Head_9;
	private JTextField jTextField_DeviceSSID_Tail_9;
	private JLabel jLabel_DevicePassword_9;// 设备密码
	private JTextField jTextField_DevicePassword_9;
	private JLabel jLabel_checkBox_DevicePassword_9;
	private JCheckBox jCheckBox_DevicePassword_9;
	private JLabel jLabel_BinaryNum_9;// 打印标签数量
	private JTextField jTextField_BinaryNum_9;
	private JButton jButton_DevicePdAndSSID_9;
	private JButton jButton_repeatPrint_9;
	private JButton jButton_printPreview_9;
	
	public PowerLineAdapterPanel powerLineAdapterPanel;		//电力线适配器

	private static String str;
	static HashPrintRequestAttributeSet attributeSet;
	private JLabel jLabel3;
	private JTextField jTextField_devicesTypeInsert;
	private JCheckBox jCheckBox_radom;
	private JLabel jLabel2;
	private JCheckBox jCheckBox_debug;
	private JLabel jLabel7;
	private JButton jButton_clearAdd;
	private JLabel jLabel6;
	public JTextField jTextField_readAIDresult;
	private JButton jButton_printPreview;
	public JLabel jLabel_binaryPic;
	private static String device;
	private static String product;	
	private static String voltage;
	private static String company;
	private static String current;
	private static String power;
	private static Properties p;
	private static File file;
	PrintRequestAttributeSet pras;
	PrintService[] services;
	PrintService defaultService;
	PrintRequestAttributeSet printRequestAttributeSet;
	PrintService selectedService;
	DocPrintJob job;
	MyPrint myPrint;
	static boolean flag = false;

	// PageFormat pf = new PageFormat();
	private static int printFormatIndex;

	private CommCfg commCfg;
	private MyCommForDebug myCommForDebug;
	private printInfo printinfo;
	protected boolean showHexFlag;
	private JTextField jTextField_readAIDresult_hex;
	protected boolean isNeedWrite;
	private String Passwd;
	private SqliteDb db;
	private static int response;
	public static int times;
	// 单例模式实现
	private static MainUI instance = null;
	public JTabbedPane jTabbedPane;		//标签页

	public static MainUI getInstance(int response) {
		MainUI.response = response;
		if (instance == null) {
			instance = new MainUI();
			return instance;
		}
		return instance;
	}

	public SqliteDb getDB() {
		return db;
	}

	public static int getResponseNum() {
		return response;
	}

	public MainUI() {
		super();
		initGUI();
	}

	private void initPortsList() {
		ArrayList<String> ports = new ArrayList<>();
		ports.add("请选择");
		for (int i = 0; i <= 20; i++) {
			ports.add("COM" + i);
		}
		for (String port : ports) {
			this.jCombox_choosePorts.addItem(port);
		}
		jCombox_choosePorts.setSelectedItem(commCfg.getPortName());
	}

	public boolean listPortChoices() {

		portList = CommPortIdentifier.getPortIdentifiers();
		if (!portList.hasMoreElements()) {
			appendTextareaText(jTextArea_status, "您的电脑没有可用串口\n");
			return false;
		} else {
			while (portList.hasMoreElements()) {
				portId = (CommPortIdentifier) portList.nextElement();
				if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
					String infor = "\n发现可用串口:  " + portId.getName();
					System.out.println(infor);
					jTextArea_status.append(infor);
				}
			}

			return true;
		}
	}

	public String getNewDeviceName() {
		return (String) jComboBox_chooseDevice_9.getSelectedItem();
	}

	public String getNewDeviceID() {
		String newDeviceID = jTextField_DeviceID_9.getText();
		return newDeviceID;
	}

	public String getNewDevicePassword() {
		String newDevicePassword = jTextField_DevicePassword_9.getText();
		return newDevicePassword;
	}

	public String getBinaryNum() {
		return jTextField_BinaryNum_9.getText();
	}

	public String getNewDeviceSSID() {
		return jComboBox_chooseDeviceSSID_Head_9.getSelectedItem()
				+ jTextField_DeviceSSID_Tail_9.getText();
	}

	public void setNewDevicePassword(String password) {
		String id = getNewDeviceID();
		int len = id.length();
		String[] str = new String[len / 2];
		byte[] b = new byte[len / 2];
		byte b1 = 0;
		for (int i = 0; i < len / 2; i++) {
			str[i] = id.substring(len - i * 2 - 2, len - i * 2);
			b[i] = hexStringToByte(str[i]);
			b1 = (byte) (b1 + b[i]);
		}
		String str1 = id.subSequence(6, len) + Integer.toHexString(b1);
		char[] c = new char[str1.length()];
		String str2 = "";
		for (int i = 0; i < str1.length(); i++) {
			c[i] = str1.charAt(i);
			if (Character.isLowerCase(c[i])) {
				c[i] = Character.toUpperCase(c[i]);
			}
			str2 = str2 + String.valueOf(c[i]);
		}
		if (str2.length() > 8)
			str2 = str2.substring(0, 6) + str2.substring(12);
		jTextField_DevicePassword_9.setText(str2);

	}

	private static byte hexStringToByte(String value) {
		byte b = 0;
		char c1 = value.charAt(0);
		char c2 = value.charAt(1);
		if ((c1 >= '0') && (c1 <= '9'))
			b += ((c1 - '0') * 16);
		else if ((c1 >= 'a') && (c1 <= 'f'))
			b += ((c1 - 'a' + 10) * 16);
		else if ((c1 >= 'A') && (c1 <= 'F'))
			b += ((c1 - 'A' + 10) * 16);
		else
			throw new IllegalArgumentException("hexUtil.bad");

		if ((c2 >= '0') && (c2 <= '9'))
			b += (c2 - '0');
		else if ((c2 >= 'a') && (c2 <= 'f'))
			b += (c2 - 'a' + 10);
		else if ((c2 >= 'A') && (c2 <= 'F'))
			b += (c2 - 'A' + 10);
		else
			throw new IllegalArgumentException("hexUtil.bad");

		return b;

	}

	public void setNewDeviceSSIDTail(String ssidTail) {
		jTextField_DeviceSSID_Tail_9.setText(ssidTail);
	}

	public String getAid() {
		String aid = jTextField_readAIDresult.getText();
		if (aid == null || aid.equals("")) {
			String hexaid = jTextField_readAIDresult_hex.getText();
			if (hexaid != null && !hexaid.equals("")) {
				aid = String.valueOf(Long.parseLong(hexaid, 16));
			}
		}
		return aid;
	}

	public String getPasswd() {
		if (isNeedWrite) {
			return jTextField_writePasswd.getText();
		}
		return Passwd;
	}
	//获取选择的设备名称
	public String getDeviceName() {
			return jComboBox_chooseDevice.getSelectedItem().toString();
	}
	
	public void ProductPasswd() {
		if (!isNeedWrite) {
			int n = 0;
			int m = 65535;
			int r = (int) (Math.random() * (m - n)) + n;
			System.out.println(String.valueOf(r));
			Passwd = String.valueOf(r);

		} else {
			System.out.println(jTextField_writePasswd.getText());
			Passwd = jTextField_writePasswd.getText();
		}

		jTextField_writePasswd.setText(Passwd);
	}

	public String getDevice() {
		device = (String) jComboBox_chooseDevice.getSelectedItem();
		if (device.equals("")) {
			device = jTextField_insertdevice.getText();
		}
		return device;
	}

	public String getProduct() {
		product = (String) jComboBox_chooseProductType.getSelectedItem();
		if (product.equals("")) {
			product = jTextField_insertProductType.getText();
		}
		return product;
	}

	public String getVoltage() {
		voltage = (String) jComboBox_chooseVoltage.getSelectedItem();
		if (voltage.equals("")) {
			voltage = jTextField_insertVoltage.getText();
		}
		return voltage;
	}
	//获取公司名称
	public String getCompany(){
		company = (String)jComboBox_chooseCompany.getSelectedItem();
		if(company.equals("")){
			company = "";
		}
		return company;
	}
	public String getCurrent() {
		current = (String) jComboBox_chooseCurrent.getSelectedItem();
		if (current.equals("")) {
			current = jTextField_insertCurrent.getText();
		}
		return current;
	}

	public String getPower() {
		power = (String) jComboBox_choosePower.getSelectedItem();
		if (power.equals("")) {
			power = jTextField_insertPower.getText();
		}
		return power;
	}

	public String getFrequency() {
		return jTextField_frequency.getText();
	}

	public String getTester() {
		return jTextField_tester.getText();
	}

	public boolean getShowHexAidFlag() {
		return showHexFlag;
	}

	public String getPruductSer_gqtszj() {
		// String str = "F811610M0929001FH";
		// String str = "F811610M0929002FH";
		// String str = "F811610M0929003FH";
		String str = "F811610M0929004FH";
		return str;
	}

	private boolean openDB() {
		try {
			db = new SqliteDb();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (db.connect()) {
			return true;
		} else {
			return false;
		}

	}

	private void initGUI() {

		openDB();
		commCfg = new CommCfg();
		commCfg.loadFromFile();

		new StringBuffer(1000);
		myCommForDebug = new MyCommForDebug(this, this);
		
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		try {
			{
				getContentPane().setLayout(null);
				getContentPane().add(jTabbedPane);		//tianbaolei
				jTabbedPane.setBounds(460, 0, 500, 555);
				
				this.setIconImage(new ImageIcon(getClass().getClassLoader()
						.getResource("icon.png")).getImage());
				this.setLocale(new java.util.Locale("zh"));
				this.setTitle("\u4e8c\u7ef4\u7801\u6807\u7b7e\u6253\u5370\u5de5\u5177 for EastSoft v3.0");
				getContentPane().setBackground(
						new java.awt.Color(236, 233, 216));
				{
					jPanel1 = new JPanel();
					getContentPane().add(jPanel1);
					
					jPanel1.setBounds(12, 12, 441, 259);
					// add
					jPanel1.setBorder(BorderFactory
							.createTitledBorder("1.设置串口"));

					jPanel1.setLayout(null);
					jPanel1.setBackground(new java.awt.Color(236, 233, 216));
					{
						jCombox_choosePorts = new JComboBox();
						jPanel1.add(jCombox_choosePorts);
						jCombox_choosePorts.setBounds(97, 24, 112, 25);
						initPortsList();
						jCombox_choosePorts.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								jCombox_choosePortsItemStateChanged(evt);
							}
						});
					}
					{
						jLabel_choosePorts = new JLabel();
						jPanel1.add(jLabel_choosePorts);
						jLabel_choosePorts.setText("\u7aef  \u53e3:");
						jLabel_choosePorts.setBounds(17, 28, 46, 18);
					}
					{
						jLabel_chooseBoundrate = new JLabel();
						jPanel1.add(jLabel_chooseBoundrate);
						jLabel_chooseBoundrate.setText("\u6ce2\u7279\u7387:");
						jLabel_chooseBoundrate.setBounds(17, 65, 54, 18);
					}
					{
						jComboBox_chooseBoundrate = new JComboBox();
						jPanel1.add(jComboBox_chooseBoundrate);
						jComboBox_chooseBoundrate.setBounds(97, 61, 111, 25);

						jComboBox_chooseBoundrate.addItem("");
						jComboBox_chooseBoundrate.addItem("2400");
						jComboBox_chooseBoundrate.addItem("4800");
						jComboBox_chooseBoundrate.addItem("9600");
						jComboBox_chooseBoundrate.addItem("57600");
						jComboBox_chooseBoundrate.addItem("115200");

						jComboBox_chooseBoundrate.setSelectedItem(commCfg
								.getBaudRateString());
						// set baudrate...

						jComboBox_chooseBoundrate
								.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent evt) {
										jComboBox_chooseBoundrateItemStateChanged(evt);
									}
								});
					}
					{
						jLabel_chooseDatabit = new JLabel();
						jPanel1.add(jLabel_chooseDatabit);
						jLabel_chooseDatabit.setText("\u6570\u636e\u4f4d:");
						jLabel_chooseDatabit.setBounds(17, 100, 54, 18);
					}
					{
						jComboBox_chooseDatabit = new JComboBox();
						jPanel1.add(jComboBox_chooseDatabit);
						jComboBox_chooseDatabit.setBounds(96, 96, 112, 25);
						jComboBox_chooseDatabit.addItem("");
						jComboBox_chooseDatabit.addItem("8");
						jComboBox_chooseDatabit.addItem("7");
						jComboBox_chooseDatabit.addItem("6");
						jComboBox_chooseDatabit.addItem("5");

						jComboBox_chooseDatabit.setSelectedItem(commCfg
								.getDatabitsString());
						// set databit...

						jComboBox_chooseDatabit
								.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent evt) {
										jComboBox_chooseDatabitItemStateChanged(evt);
									}
								});
					}
					{
						jLabel_chooseStopBit = new JLabel();
						jPanel1.add(jLabel_chooseStopBit);
						jLabel_chooseStopBit.setText("\u505c\u6b62\u4f4d:");
						jLabel_chooseStopBit.setBounds(17, 135, 46, 18);
					}
					{
						jComboBox_chooseStopBit = new JComboBox();
						jPanel1.add(jComboBox_chooseStopBit);
						jComboBox_chooseStopBit.setBounds(96, 131, 112, 25);
						jComboBox_chooseStopBit.addItem("");
						jComboBox_chooseStopBit.addItem("1");
						jComboBox_chooseStopBit.addItem("1.5");
						jComboBox_chooseStopBit.addItem("2");

						jComboBox_chooseStopBit.setSelectedItem(commCfg
								.getStopbitsString());
						// set stopbit ...

						jComboBox_chooseStopBit
								.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent evt) {
										jComboBox_chooseStopBitItemStateChanged(evt);
									}
								});
					}
					{
						jLabel_choosePorityBit = new JLabel();
						jPanel1.add(jLabel_choosePorityBit);
						jLabel_choosePorityBit.setText("\u5947\u5076\u4f4d:");
						jLabel_choosePorityBit.setBounds(17, 174, 46, 18);
					}
					{
						jComboBox_choosePorityBit = new JComboBox();
						jPanel1.add(jComboBox_choosePorityBit);
						jComboBox_choosePorityBit.setBounds(96, 170, 112, 25);
						jComboBox_choosePorityBit.addItem("");
						jComboBox_choosePorityBit.addItem("None");
						jComboBox_choosePorityBit.addItem("Even");
						jComboBox_choosePorityBit.addItem("Odd");

						jComboBox_choosePorityBit.setSelectedItem(commCfg
								.getParityString());
						// set poritybit ...

						jComboBox_choosePorityBit
								.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent evt) {
										jComboBox_choosePorityBitItemStateChanged(evt);
									}
								});
					}
					{
						jTextArea_sendTest = new JTextArea();
						jPanel1.add(jTextArea_sendTest);
						jTextArea_sendTest.setBounds(5, 207, 289, 44);
					}
					{
						jButton_sendTest = new JButton();
						jPanel1.add(jButton_sendTest);
						jButton_sendTest.setText("\u53d1\u9001" + "Test");
						jButton_sendTest.setBounds(313, 213, 112, 38);
						jButton_sendTest
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButton_sendTestActionPerformed(evt);
									}
								});
					}
					{
						jButton_openPort = new JButton();
						jPanel1.add(jButton_openPort);
						// jPanel1.add(getJButton_saveTofile());
						jButton_openPort.setText("\u6253\u5f00");
						jButton_openPort.setBounds(313, 136, 112, 60);
						jButton_openPort
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButton_openPortActionPerformed(evt);
									}
								});
					}
				}
				{
					jPanel2 = new JPanel();
					getContentPane().add(jPanel2);
					
					jPanel2.setBounds(12, 283, 441, 156);
					jPanel2.setBorder(BorderFactory
							.createTitledBorder(
									null,
									"2.\u8f7d\u6ce2\u901a\u8baf\uff08\u8bfb\u53d6AID+\u5199\u5165\u5bc6\u7801\uff09",
									TitledBorder.LEADING,
									TitledBorder.DEFAULT_POSITION));
					jPanel2.setLayout(null);
					jPanel2.setBackground(new java.awt.Color(236, 233, 216));
					{
						jLabel_readaid = new JLabel();
						jPanel2.add(jLabel_readaid);
						jLabel_readaid.setText("AID:");
						jLabel_readaid.setBounds(28, 35, 39, 18);
					}
					{
						jTextField_writePasswd = new JTextField();
						jPanel2.add(jTextField_writePasswd);
						jTextField_writePasswd.setEnabled(false);
						jTextField_writePasswd.setBounds(65, 74, 192, 25);

					}
					{
						jLabel_writePasswd = new JLabel();
						jPanel2.add(getJLabel5());
						jPanel2.add(getJTextField_address());
						jPanel2.add(getJButton_writeaddress());
						jPanel2.add(getJTextField_readAIDresult());
						jPanel2.add(getJTextField_readAIDresult_Hex());
						jPanel2.add(getJLabel6());
						jPanel2.add(getJLabel2());
						jPanel2.add(getJCheckBox_radom());
						jLabel_writePasswd.setText("\u5bc6\u7801:");
						jLabel_writePasswd.setBounds(26, 77, 33, 18);
					}
				}
				{
					jPanel3 = new JPanel();
					getContentPane().add(jPanel3);
					jPanel3.setBounds(12, 439, 441, 119);
					jPanel3.setLayout(null);
					jPanel3.setBorder(BorderFactory
							.createTitledBorder("3.\u751f\u6210\u4e8c\u7ef4\u7801"));
					jPanel3.setBackground(new java.awt.Color(236, 233, 216));
					{
						jButton_productBinary = new JButton();
						jPanel3.add(jButton_productBinary);
						jPanel3.add(getJLabel_binaryPic());
						jButton_productBinary
								.setText("\u751f\u6210\u4e8c\u7ef4\u7801");	//生成二维码
						jButton_productBinary.setBounds(319, 38, 106, 50);
						jButton_productBinary
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButton_productBinaryActionPerformed(evt);
									}
								});
					}
				}
				{
					jPanel4 = new JPanel();
					//getContentPane().add(jPanel4);
					jTabbedPane.add("4.打印标签",jPanel4);
					
					jPanel4.setBounds(12, 12, 498, 546);
					jPanel4.setLayout(null);
					jPanel4.setBackground(new java.awt.Color(236, 233, 216));
					jPanel4.setBorder(BorderFactory.createTitledBorder(null,
							"打印标签", TitledBorder.LEADING,
							TitledBorder.DEFAULT_POSITION));
					{
						jLabel_chooseDevice = new JLabel();
						jPanel4.add(jLabel_chooseDevice);
						jLabel_chooseDevice
								.setText("\u9009\u62e9\u8bbe\u5907:");
						jLabel_chooseDevice.setBounds(17, 53, 64, 18);
					}
					{
						jLabel_chooseProductType = new JLabel();
						jPanel4.add(jLabel_chooseProductType);
						jLabel_chooseProductType
								.setText("\u4ea7\u54c1\u578b\u53f7:");
						jLabel_chooseProductType.setBounds(17, 95, 64, 18);
					}
					{
						jLabel_eDingVoltage = new JLabel();
						jPanel4.add(jLabel_eDingVoltage);
						jLabel_eDingVoltage
								.setText("\u989d\u5b9a\u7535\u538b:");
						jLabel_eDingVoltage.setBounds(17, 136, 64, 18);
					}
					//公司名称
					{
						jLabel_companyName = new JLabel();
						jPanel4.add(jLabel_companyName);
						jLabel_companyName
								.setText("公司名称:");
						jLabel_companyName.setBounds(17,420, 64, 18);
					}
					{
						jLabel_eDingPower = new JLabel();
						jPanel4.add(jLabel_eDingPower);
						jLabel_eDingPower.setText("\u989d\u5b9a\u529f\u7387:");
						jLabel_eDingPower.setBounds(17, 224, 64, 18);
					}
					{
						jLabel_frequency = new JLabel();
						jPanel4.add(jLabel_frequency);
						jLabel_frequency.setText("\u9891\u7387:");
						jLabel_frequency.setBounds(17, 266, 38, 18);
					}
					{
						jLabel_productSerialNO = new JLabel();
						jPanel4.add(jLabel_productSerialNO);
						jLabel_productSerialNO.setText("测试人员: ");
						jLabel_productSerialNO.setBounds(17, 301, 64, 18);
					}
					{
						jComboBox_chooseDevice = new JComboBox();
						jPanel4.add(jComboBox_chooseDevice);
						jComboBox_chooseDevice.setBounds(80, 46, 150, 25);
						// initChooseMenu();

						ArrayList<String> devices = LabelsUtil
								.readFile("devices.txt");
						jComboBox_chooseDevice.addItem("");
						for (String device : devices) {
							jComboBox_chooseDevice.addItem(device);
							System.out.println(device);
						}
						jComboBox_chooseDevice
								.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent evt) {
										jComboBox_chooseDeviceItemStateChanged(evt);
									}

								});
					}
					{
						jComboBox_chooseProductType = new JComboBox();
						jPanel4.add(jComboBox_chooseProductType);
						jComboBox_chooseProductType.setBounds(80, 92, 150, 25);

						ArrayList<String> products = LabelsUtil
								.readFile("products.txt");
						jComboBox_chooseProductType.addItem("");
						for (String product : products) {
							jComboBox_chooseProductType.addItem(product);
							System.out.println(product);
						}
					}
					// 电压
					{
						jComboBox_chooseVoltage = new JComboBox();
						jPanel4.add(jComboBox_chooseVoltage);
						jComboBox_chooseVoltage.setBounds(80, 136, 150, 25);

						ArrayList<String> voltages = LabelsUtil
								.readFile("voltages.txt");
						jComboBox_chooseVoltage.addItem("");
						for (String voltage : voltages) {
							jComboBox_chooseVoltage.addItem(voltage);
							System.out.println(voltage);
						}

					}
					//公司名称
					{
						jComboBox_chooseCompany = new JComboBox();
						jComboBox_chooseCompany.setEditable(true);
						jPanel4.add(jComboBox_chooseCompany);
						jComboBox_chooseCompany.setBounds(80, 420, 150, 25);

						ArrayList<String> companys = LabelsUtil
								.readFile("companys.txt");
						jComboBox_chooseCompany.addItem("");
						for (String company : companys) {
							jComboBox_chooseCompany.addItem(company);
							System.out.println(company);
						}
					}
					//功率
					{
						jComboBox_choosePower = new JComboBox();
						jPanel4.add(jComboBox_choosePower);
						jComboBox_choosePower.setBounds(80, 224, 150, 25);

						ArrayList<String> powers = LabelsUtil
								.readFile("powers.txt");
						jComboBox_choosePower.addItem("");
						for (String power : powers) {
							jComboBox_choosePower.addItem(power);
							System.out.println(power);
						}
						jComboBox_choosePower
								.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent evt) {
										jComboBox_choosePowerItemStateChanged(evt);
									}
								});

					}
					{
						jTextField_frequency = new JTextField();
						jPanel4.add(jTextField_frequency);
						jTextField_frequency.setText("50/60");
						jTextField_frequency.setBounds(80, 263, 150, 25);

					}
					{
						jLabel1 = new JLabel();
						jPanel4.add(jLabel1);
						jLabel1.setText("Hz");
						jLabel1.setBounds(199, 270, 23, 18);
					}
					{
						Calendar calendar = Calendar.getInstance();
						calendar.add(Calendar.DATE, 0);

						SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
						System.out.println(f.format(calendar.getTime()));

						jTextField_tester = new JTextField();
						jPanel4.add(jTextField_tester);
						jTextField_tester.setText("");
						jTextField_tester.setBounds(80, 298, 150, 25);

					}
					{
						jPanel5 = new JPanel();
						jPanel4.add(jPanel5);
						jPanel5.setBounds(244, 20, 244, 243);
						jPanel5.setLayout(null);
						jPanel5.setBorder(BorderFactory
								.createTitledBorder("\u6dfb\u52a0\u65b0\u9879\u76ee"));
						jPanel5.setBackground(new java.awt.Color(236, 233, 216));
						{
							jTextField_insertdevice = new JTextField();
							jPanel5.add(jTextField_insertdevice);
							jTextField_insertdevice.setBounds(5, 27, 125, 25);
						}
						{
							jTextField_insertProductType = new JTextField();
							jPanel5.add(jTextField_insertProductType);
							jTextField_insertProductType.setBounds(5, 72, 125,
									25);
						}
						{
							jTextField_insertVoltage = new JTextField();
							jPanel5.add(jTextField_insertVoltage);
							jTextField_insertVoltage.setBounds(5, 119, 125, 25);
						}
						{
							jTextField_insertPower = new JTextField();
							jPanel5.add(jTextField_insertPower);
							jTextField_insertPower.setBounds(5, 206, 125, 25);
						}
						{
							jButton_insertInfor = new JButton();
							jPanel5.add(jButton_insertInfor);
							/*
							 * JCheckBox debugCheck = new JCheckBox();
							 * debugCheck.setBounds(5, 300, 25, 25);
							 * jPanel5.add(debugCheck);
							 */
							jPanel5.add(getJButton_delete());
							jPanel5.add(getJButton_clearAdd());
							jPanel5.add(getJTextField_insertCurrent());
							jButton_insertInfor.setText("\u6dfb\u52a0");
							jButton_insertInfor.setBounds(153, 94, 86, 25);
							jButton_insertInfor
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jButton_insertInforActionPerformed(evt);
										}
									});
						}
					}
					{
						jButton_printLabel = new JButton();
						jPanel4.add(jButton_printLabel);
						jPanel4.add(getJButton_printPreview());	//打印预览
						{
							jComboBox_choosePrintFormat = new JComboBox();
							jPanel4.add(jComboBox_choosePrintFormat);
							jComboBox_choosePrintFormat.setBounds(80, 345, 200,
									25);
							jComboBox_choosePrintFormat.addItem("");
							jComboBox_choosePrintFormat
									.addItem("样式-1--电源控制模块等");
							jComboBox_choosePrintFormat
									.addItem("样式-2--LCD触摸开关等");
							jComboBox_choosePrintFormat
									.addItem("样式-3--电容触摸开关等");
							jComboBox_choosePrintFormat.addItem("样式-4--窗帘控制器等");
							jComboBox_choosePrintFormat.addItem("样式-5--灯光控制器等");
							jComboBox_choosePrintFormat.addItem("样式-6--调光控制器等");
							jComboBox_choosePrintFormat.addItem("样式-7--红外转发器等");
							jComboBox_choosePrintFormat.addItem("样式-8--智能网关等");
							jComboBox_choosePrintFormat
									.addItem("样式-9--RGB调光控制器等");
							jComboBox_choosePrintFormat.addItem("样式-10--智能插座等");
							jComboBox_choosePrintFormat
									.addItem("样式-11--双轨窗帘控制器等");
							jComboBox_choosePrintFormat
									.addItem("样式-12--人体红外感应器等");
							jComboBox_choosePrintFormat
									.addItem("样式-13--平板网关适配器等");
							jComboBox_choosePrintFormat
									.addItem("样式-14--RGB调光控制器正等");
							jComboBox_choosePrintFormat
									.addItem("样式-15--RGB调光控制器反等");
							jComboBox_choosePrintFormat
									.addItem("样式-16--窗帘控制器正等");
							jComboBox_choosePrintFormat
									.addItem("样式-17--窗帘控制器反等");
							jComboBox_choosePrintFormat
									.addItem("样式-18--灯光控制器正等");
							jComboBox_choosePrintFormat
									.addItem("样式-19--灯光控制器反等");
							jComboBox_choosePrintFormat
									.addItem("样式-20--调光控制器正等");
							jComboBox_choosePrintFormat
									.addItem("样式-21--调光控制器反等");
							jComboBox_choosePrintFormat
									.addItem("样式-22--人体红外感应器新等");
							jComboBox_choosePrintFormat
									.addItem("样式-23--电源控制模块新等");
							jComboBox_choosePrintFormat
									.addItem("样式-24--红外转发器新等");
							jComboBox_choosePrintFormat
									.addItem("样式-25--智能插座新等");
							jComboBox_choosePrintFormat
									.addItem("样式-26--智能网关新等");
							jComboBox_choosePrintFormat
									.addItem("样式-27--双轨窗帘控制器正等");
							jComboBox_choosePrintFormat
									.addItem("样式-28--双轨窗帘控制器反等");
							jComboBox_choosePrintFormat
									.addItem("样式-29--电能监测器等");
							// Added by 唐鹰
							// Add 2014-11-11 Start：
							jComboBox_choosePrintFormat
									.addItem("样式-30--用电监控器等");
							// End：
							
							jComboBox_choosePrintFormat.addItem("样式-31--昊想智能卫士底座等");
							jComboBox_choosePrintFormat.addItem("样式-32--智能漏电保护器");
							
							// added by wzj 2015-7-23 start
							jComboBox_choosePrintFormat
									.addItem("样式-33--开关控制模块");
							// end
							
							//Added by wzj
							//Add 2015-07-14 Start:
							jComboBox_choosePrintFormat
									.addItem("样式-35--PLC-485转换器");
							
							jComboBox_choosePrintFormat
							.addItem("样式-37--四路开关执行器");
							
							jComboBox_choosePrintFormat
							.addItem("样式-38--PLC-Sub1G转换器（白）");
							jComboBox_choosePrintFormat
							.addItem("样式-39--PLC-Sub1G转换器（黑）");
							// End;
							jComboBox_choosePrintFormat
									.addItemListener(new ItemListener() {
										public void itemStateChanged(
												ItemEvent evt) {
											jComboBox_choosePrintFormatItemStateChanged(evt);
										}
									});
						}
						{
							jLabel4 = new JLabel();
							jPanel4.add(jLabel4);
							jPanel4.add(getJButton_repeatPrint());
							jPanel4.add(getJLabel7());
							jPanel4.add(getJComboBox_chooseEdingCurrent());
							jPanel4.add(getJCheckBox_debug());
							jPanel4.add(getJTextField_devicesTypeInsert());
							jPanel4.add(getJLabel3());

							jLabel4.setText("\u6253\u5370\u6837\u5f0f:");
							jLabel4.setBounds(17, 348, 64, 18);
						}
						//打印标签按钮
						jButton_printLabel.setText("\u6253\u5370\u6807\u7b7e");
						jButton_printLabel.setBounds(217, 457, 98, 56);
						jButton_printLabel
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButton_printLabelActionPerformed(evt);
									}
								});
					}
				}
				{

					jPanel7 = new JPanel();
					getContentPane().add(jPanel7);

					jPanel7.setBounds(4, 564, 970, 133);
					jPanel7.setLayout(null);
					{
						jTextArea_status = new JTextArea();

					}
					{
						JScrollPane scroll = new JScrollPane(jTextArea_status,
								ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
								ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						jPanel7.add(scroll);
						scroll.setBounds(12, 0, 950, 133);
					}

				}
				
				{	//电力线适配器
					powerLineAdapterPanel = new PowerLineAdapterPanel();
					jTabbedPane.add("5.电力线***二维码打印",powerLineAdapterPanel);
				}

				listPortChoices();
				ProductPasswd();
				EnableOrDisableTextType(false);
				{
					jPanel9 = new JPanel();
					//getContentPane().add(jPanel9);
					jTabbedPane.add("6.互动适配器二维码项目",jPanel9);
					
					jPanel9.setBounds(12, 12, 300, 546);
					jPanel9.setLayout(null);
					jPanel9.setBackground(new java.awt.Color(236, 233, 216));
					jPanel9.setBorder(BorderFactory.createTitledBorder(null,
							"互动适配器二维码项目", TitledBorder.LEADING,
							TitledBorder.DEFAULT_POSITION));
					{
						jLabel_chooseDevice_9 = new JLabel();
						jLabel_chooseDevice_9.setBounds(12, 40, 70, 18);
						jLabel_chooseDevice_9.setText("选择设备：");
						jPanel9.add(jLabel_chooseDevice_9);
					}
					{
						jComboBox_chooseDevice_9 = new JComboBox();
						jPanel9.add(jComboBox_chooseDevice_9);
						jComboBox_chooseDevice_9.setBounds(100, 36, 180, 25);
						ArrayList<String> voltages = LabelsUtil
								.readFile("newdevices.txt");
						jComboBox_chooseDevice_9.addItem("");
						for (String voltage : voltages) {
							jComboBox_chooseDevice_9.addItem(voltage);
							System.out.println(voltage);
						}
						jComboBox_chooseDevice_9
								.addItemListener(new ItemListener() {

									@Override
									public void itemStateChanged(ItemEvent evt) {
										jComboBox_new_chooseDeviceItemStateChanged(evt);

									}
								});
					}
					{
						jLabel_DeviceID_9 = new JLabel();
						jPanel9.add(jLabel_DeviceID_9);
						jLabel_DeviceID_9.setText("设备地址：");
						jLabel_DeviceID_9.setBounds(12, 100, 70, 18);
					}
					{
						jTextField_DeviceID_9 = new JTextField();
						jPanel9.add(jTextField_DeviceID_9);
						jTextField_DeviceID_9.setBounds(100, 96, 180, 25);
					}
					{
						jLabel_DevicePassword_9 = new JLabel();
						jPanel9.add(jLabel_DevicePassword_9);
						jLabel_DevicePassword_9.setText("设备密码：");
						jLabel_DevicePassword_9.setBounds(12, 220, 70, 18);
					}
					{
						jTextField_DevicePassword_9 = new JTextField();
						jPanel9.add(jTextField_DevicePassword_9);
						jTextField_DevicePassword_9
								.setBounds(100, 216, 180, 25);
					}
					{
						jCheckBox_DevicePassword_9 = new JCheckBox();
						jPanel9.add(jCheckBox_DevicePassword_9);
						jCheckBox_DevicePassword_9.setBounds(100, 250, 20, 20);
						jCheckBox_DevicePassword_9
								.addItemListener(new ItemListener() {

									@Override
									public void itemStateChanged(ItemEvent evt) {
										jCheckBox_DevicePasswordItemStateChange(evt);
									}
								});
					}
					{
						jLabel_checkBox_DevicePassword_9 = new JLabel();
						jPanel9.add(jLabel_checkBox_DevicePassword_9);
						jLabel_checkBox_DevicePassword_9.setText("是否使用默认密码");
						jLabel_checkBox_DevicePassword_9.setBounds(130, 250,
								110, 18);
					}
					{
						jLabel_BinaryNum_9 = new JLabel();
						jPanel9.add(jLabel_BinaryNum_9);
						jLabel_BinaryNum_9.setText("打印标签数量：");
						jLabel_BinaryNum_9.setBounds(12, 160, 100, 18);
					}
					{
						jTextField_BinaryNum_9 = new JTextField();
						jPanel9.add(jTextField_BinaryNum_9);
						jTextField_BinaryNum_9.setBounds(100, 156, 180, 25);
						jTextField_BinaryNum_9.setText("1");
					}
					{
						jLabel_DeviceSSID_9 = new JLabel();
						jPanel9.add(jLabel_DeviceSSID_9);
						jLabel_DeviceSSID_9.setText("网络名：");
						jLabel_DeviceSSID_9.setBounds(12, 280, 80, 18);
					}
					{
						jComboBox_chooseDeviceSSID_Head_9 = new JComboBox();
						jPanel9.add(jComboBox_chooseDeviceSSID_Head_9);
						jComboBox_chooseDeviceSSID_Head_9.setBounds(100, 276,
								60, 25);
						ArrayList<String> voltages = LabelsUtil
								.readFile("newSSIDhead.txt");
						jComboBox_chooseDeviceSSID_Head_9.addItem("");
						for (String voltage : voltages) {
							jComboBox_chooseDeviceSSID_Head_9.addItem(voltage);
							System.out.println(voltage);
						}
					}
					

					{
						jTextField_DeviceSSID_Tail_9 = new JTextField();
						jPanel9.add(jTextField_DeviceSSID_Tail_9);
						jTextField_DeviceSSID_Tail_9.setBounds(170, 276, 110,
								25);
					}
					{
						jButton_DevicePdAndSSID_9 = new JButton();
						jPanel9.add(jButton_DevicePdAndSSID_9);
						jButton_DevicePdAndSSID_9.setText("生成网络名及密码");
						jButton_DevicePdAndSSID_9.setBounds(50, 360, 200, 70);
						jButton_DevicePdAndSSID_9
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent evt) {
										jButton_new_produceDevicePdAndSSID(evt);

									}
								});
					}
					{
						jButton_repeatPrint_9 = new JButton();
						jPanel9.add(jButton_repeatPrint_9);
						jButton_repeatPrint_9.setBounds(160, 460, 100, 50);
						jButton_repeatPrint_9.setText("打印");
						jButton_repeatPrint_9
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent evt) {
										jButton_new_printBinaryPerformed(evt);

									}
								});
					}
					{
						jButton_printPreview_9 = new JButton();
						jPanel9.add(jButton_printPreview_9);
						jButton_printPreview_9.setText("打印预览");
						jButton_printPreview_9.setBounds(40, 460, 100, 50);
						jButton_printPreview_9
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent evt) {
										jButton_new_printPreviewformed(evt);

									}
								});
					}

				}
			}
			this.setSize(1000, 749);
			// this.setAlwaysOnTop(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jComboBox_new_chooseDeviceItemStateChanged(ItemEvent evt) {
		int index = 0;
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			appendTextareaText(jTextArea_status,
					'\n' + "选择设备：" + (String) evt.getItem());
			index = jComboBox_chooseDevice_9.getSelectedIndex();
			switch (index) {
			case 1:
				jTextField_DevicePassword_9.setEnabled(true);
				jComboBox_chooseDeviceSSID_Head_9.setEnabled(true);
				jTextField_DeviceSSID_Tail_9.setEnabled(true);
				jCheckBox_DevicePassword_9.setEnabled(true);
				jButton_DevicePdAndSSID_9.setEnabled(true);
				break;
			case 2:
				jTextField_DevicePassword_9.setEnabled(false);
				jComboBox_chooseDeviceSSID_Head_9.setEnabled(false);
				jTextField_DeviceSSID_Tail_9.setEnabled(false);
				jCheckBox_DevicePassword_9.setEnabled(false);
				jButton_DevicePdAndSSID_9.setEnabled(false);
				jTextField_DevicePassword_9.setText("");
				jTextField_DeviceSSID_Tail_9.setText("");
				jComboBox_chooseDeviceSSID_Head_9.setSelectedIndex(0);

				break;
			case 3:
				jTextField_DevicePassword_9.setEnabled(true);
				jComboBox_chooseDeviceSSID_Head_9.setEnabled(true);
				jTextField_DeviceSSID_Tail_9.setEnabled(true);
				jCheckBox_DevicePassword_9.setEnabled(true);
				jButton_DevicePdAndSSID_9.setEnabled(true);
				break;

			default:
				break;
			}
		}
	}

	private void jCheckBox_DevicePasswordItemStateChange(ItemEvent evt) {
		JCheckBox box = (JCheckBox) evt.getItemSelectable();
		if (box.isSelected()) {
			jTextField_DevicePassword_9.setText("300183");
			jTextField_DevicePassword_9.setEditable(false);
		} else {
			jTextField_DevicePassword_9.setText("");
			jTextField_DevicePassword_9.setEditable(true);
		}
	}

	private void jButton_new_produceDevicePdAndSSID(ActionEvent evt) {
		String newDeviceID = getNewDeviceID();
		appendTextareaText(jTextArea_status, '\n' + "设备地址：" + newDeviceID);
		setNewDevicePassword(newDeviceID);
		setNewDeviceSSIDTail(newDeviceID);
		flag = true;
	}

	private void jButton_new_printBinaryPerformed(ActionEvent evt) {
		printNewBinaryPicture();
	}

	private void jComboBox_chooseDeviceItemStateChanged(ItemEvent evt) {
		String device = getDevice();
		int index = 0;
		
		//1Comboxs_setSelectedItem中最后一个参数改为设置显示制定索引的值，公司在配置文件中
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			appendTextareaText(jTextArea_status,
					'\n' + "选择设备：" + (String) evt.getItem());
			index = jComboBox_chooseDevice.getSelectedIndex();
			switch (index) {
			case 1:
				/*Comboxs_setSelectedItem("ESPC-86-1S", "220V～", "7A/2A", "",
						"样式-1--电源控制模块等",1);*/
				Comboxs_setSelectedItem("ESPC-86-1S", "AC85V-265V", "7A/2A", "小于200w",
						"样式-1--电源控制模块等",1);
				break;
			case 2:
				Comboxs_setSelectedItem("ESSW-L-NUV", "220V～", "", "",
						"样式-2--LCD触摸开关等",1);
				break;
			case 3:
				Comboxs_setSelectedItem("ESIR", "220V～", "", "", "样式-7--红外转发器等",1);
				break;
			case 4:
				Comboxs_setSelectedItem("ESCC-AC", "220V～", "", "100W",
						"样式-4--窗帘控制器等",1);
				break;
			case 5:
				Comboxs_setSelectedItem("ESLC-2S", "220V～", "", "",
						"样式-5--灯光控制器等",1);
				break;
			case 6:
				Comboxs_setSelectedItem("ESLC-1D1S", "220V～", "2A", "<0.5W",
						"样式-6--调光控制器等",1);
				break;
			case 7:
				Comboxs_setSelectedItem("ESSW-G-IV", "220V～", "", "",
						"样式-3--电容触摸开关等",1);
				break;
			case 8:
				Comboxs_setSelectedItem("ESLC-2C-1S", "220V～", "", "<0.5W",
						"样式-9--RGB调光控制器等",1);
				break;
			case 9:
				Comboxs_setSelectedItem("ESHG-WJ-V", "220V～", "2A", "",
						"样式-8--智能网关等",1);
				break;
			case 10:
				Comboxs_setSelectedItem("ESCS-G-II", "220V～", "<3A", "100W",
						"样式-4--窗帘控制器等",1);
				break;
			case 11:
				Comboxs_setSelectedItem("ESSP-10-M", "220V～", "", "",
						"样式-10--智能插座等",1);
				break;
			case 12:
				Comboxs_setSelectedItem("ESCC-AC-II", "220V～", "2A", "100W",
						"样式-11--双轨窗帘控制器等",1);
				break;
			case 13:
				Comboxs_setSelectedItem("ESIR-H", "220V～", "", "",
						"样式-12--人体红外感应器等",1);
				break;
			case 14:
				Comboxs_setSelectedItem("ESPG-WM", "220V～", "500mA", "",
						"样式-13--平板网关适配器等",1);
				break;
			case 15:
				Comboxs_setSelectedItem("ESLC-1C1S", "220V～", "", "100W",
						"样式-14--RGB调光控制器正等",1);
				break;
			case 16:
				Comboxs_setSelectedItem("ESLC-1C1S", "220V～", "", "100W",
						"样式-15--RGB调光控制器反等",1);
				break;
			case 17:
				Comboxs_setSelectedItem("ESCC-AC", "220V～", "", "100W",
						"样式-16--窗帘控制器正等",1);
				break;
			case 18:
				Comboxs_setSelectedItem("ESCC-AC", "220V～", "", "100W",
						"样式-17--窗帘控制器反等",1);
				break;
			case 19:
				Comboxs_setSelectedItem("ESLC-2S", "220V～", "500mA", "",
						"样式-18--灯光控制器正等",1);
				break;
			case 20:
				Comboxs_setSelectedItem("ESLC-2S", "220V～", "500mA", "",
						"样式-19--灯光控制器反等",1);
				break;
			case 21:
				Comboxs_setSelectedItem("ESLC-1D1S", "220V～", "", "1000W",
						"样式-20--调光控制器正等",1);
				break;
			case 22:
				Comboxs_setSelectedItem("ESLC-1D1S", "220V～", "", "1000W",
						"样式-21--调光控制器反等",1);
				break;
			case 23:
				Comboxs_setSelectedItem("ESIR-H", "220V～", "", "",
						"样式-22--人体红外感应器新等",1);
				break;
			case 24:
				Comboxs_setSelectedItem("ESPC-1", "220V～", "", "",
						"样式-23--电源控制模块新等",1);
				break;
			case 25:
				Comboxs_setSelectedItem("ESIR", "220V～", "", "",
						"样式-24--红外转发器新等",1);
				break;
			case 26:
				Comboxs_setSelectedItem("ESSP-10-M", "220V～", "", "",
						"样式-25--智能插座新等",1);
				break;
			case 27:
				Comboxs_setSelectedItem("ESHG-WJ-V", "220V～", "", "",
						"样式-26--智能网关新等",1);
				break;

			case 28:
				Comboxs_setSelectedItem("ESCC-AC-II", "220V～", "", "300W",
						"样式-27--双轨窗帘控制器正等",1);
				break;
			case 29:
				Comboxs_setSelectedItem("ESCC-AC-II", "220V～", "", "300W",
						"样式-28--双轨窗帘控制器反等",1);
				break;
			case 30:
				Comboxs_setSelectedItem("ESEM-DIN35", "220VAC", "0.02A～60A", "",
						"样式-29--电能监测器等",1);
				break;
				
			//Added by 唐鹰
				//Add 2014-11-11 Start：
			case 31:
				Comboxs_setSelectedItem("ESLM-DIN35", "220VAC", "0～32A", "",
						"样式-30--用电监控器等",1);
				break;
			//End： 
			case 32:
				Comboxs_setSelectedItem("昊想智能卫士底座", "", "", "",
						"样式-31--昊想智能卫士底座等",3);
				break;
			case 33:
				Comboxs_setSelectedItem("ES47LE-63", "220V～", "<3A", "100W",
						"样式-32--智能漏电保护器",1);
			case 34:
				Comboxs_setSelectedItem("ESIMDTD", "86-265VAC", "", "",
						"样式-34--红外微波双鉴探测器",1);
				
				//Added by wzj
				//Add 2015-07-14 Start：
			case 35:
				Comboxs_setSelectedItem("ESCV-485PL", "AC 86V-265V", "", "",
						"样式-35--PLC-485转换器",1);
				break;
			//End： 
			// added by wzj
			// add 2015-4-20 start
			case 36:
				Comboxs_setSelectedItem("ESACT-1S1A", "AC 85V-265V", "1A","", 
						"样式-33--开关控制模块", 1);
				break;
			// end
				
			//Added by wzj
			//Add 2015-07-14 Start：
			case 37:
				Comboxs_setSelectedItem("ESACT-4S16A", "AC 86V-265V", "0～16A", "",
						"样式-37--四路开关执行器",1);
			break;
			
			case 38:
				Comboxs_setSelectedItem("ESCV-Sub1GPL", "AC 86V-265V", "", "",
						"样式-38--PLC-Sub1G转换器（白）",1);
			break;
			
			case 39:
				Comboxs_setSelectedItem("ESCV-Sub1GPL", "AC 86V-265V", "", "",
						"样式-39--PLC-Sub1G转换器（黑）",1);
			break;
			//End： 
			
			default:
				break;
			}

		}
	}

	public void Comboxs_setSelectedItem(String productNo, String voltage,
			String current, String power, String printFormat,int company) {
		jComboBox_chooseProductType.setSelectedItem(productNo);
		jComboBox_chooseProductType.repaint();
		jComboBox_chooseVoltage.setSelectedItem(voltage);
		jComboBox_chooseVoltage.repaint();
		//公司名称
		//jComboBox_chooseCompany.setSelectedItem(company); //tianbaolei
		jComboBox_chooseCompany.setSelectedIndex(company);
		jComboBox_chooseCompany.repaint();
		jComboBox_chooseCurrent.setSelectedItem(current);
		jComboBox_chooseCurrent.repaint();
		jComboBox_choosePower.setSelectedItem(power);
		jComboBox_choosePower.repaint();
		jComboBox_choosePrintFormat.setSelectedItem(printFormat);
		jComboBox_choosePrintFormat.repaint();
	}

	private void jComboBox_choosePowerItemStateChanged(ItemEvent evt) {
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			appendTextareaText(jTextArea_status,
					'\n' + "选择功率：" + (String) evt.getItem());
		}
	}

	private void jButton_sendTestActionPerformed(ActionEvent evt) {
		String str = jTextArea_sendTest.getText();
		delayWriteComm(str);

	}

	void delayWriteComm(String str) {
		byte[] send_byte = str.getBytes();

		for (int i = 0; i < send_byte.length; i++) {
			byte[] temp = { send_byte[i] };
			writeComm(temp);
			delay(50);
		}
	}

	public static void delay(int a) {
		int i;
		while (--a != 0) {
			for (i = 0; i < 100000; i++)
				;
		}
	}

	public void writeSsc(int seq, String di, String data) {
		try {
			writeComm(Tssc1650.makeSsc(seq, di, data).getBuf());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeComm(byte[] b) {
		myCommForDebug.send(b);
	}

	private void jButton_openPortActionPerformed(ActionEvent evt) {
		if (listPortChoices()) {

			if (times % 2 == 0) {
				if (myCommForDebug.open()) {
					jButton_openPort.setText("关闭");
					appendTextareaText(jTextArea_status, "\n串口打开");
				}
			} else {
				if (myCommForDebug.close()) {

					jButton_openPort.setText("打开");
					appendTextareaText(jTextArea_status, "\n串口关闭");

				}

			}
			times++;
		}

	}

	public void appendTextareaText(JTextArea jTextArea, String str) {
		jTextArea.append(str);
		// jTextArea.selectAll();
		jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
		// jTextArea.setSelectionStart(jTextArea.getText().length());
	}

	private void jButton_productBinaryActionPerformed(ActionEvent evt) {

	}

	private void jButton_new_printPreviewformed(ActionEvent evt) {
		String deviceID=getNewDeviceID();
		String devicePassword=getNewDevicePassword();
		String deviceSSID=getNewDeviceSSID();
		productNewQRCode(deviceID, devicePassword, deviceSSID);
		jButton_new_printPreviewActionPerformed(evt);
	}

	public void productNewQRCode(String deviceID,String devicePassword,String deviceSSID) {
		newQRCode = new QRCode();

		String deviceType = null;
		int index = jComboBox_chooseDevice_9.getSelectedIndex();
		switch (index) {
		case 1:
			deviceType = "01";
			str = deviceType + "," + deviceSSID + "," + devicePassword + ","
					+ deviceID;
			break;
		case 2:
			deviceType = "02";
			str = deviceType + "," + deviceID;
			break;
		case 3:
			deviceType = "11";
			str = deviceType + "," + deviceSSID + "," + devicePassword + ","
					+ deviceID;
			break;
		default:
			break;
		}
		File filePath = new File("new_test_QR_CODE.png");
		String path = filePath.getAbsolutePath();
		int width, height;
		width = height = 120;
		newQRCode.encode(str, path, width, height);
		newQRCode.decode(filePath);

		Image barCodePic = null;
		try {
			barCodePic = ImageIO.read(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		jLabel_binaryPic.setIcon(new ImageIcon(barCodePic));

		appendTextareaText(jTextArea_status, "\n(互动适配)二维码已生成: " + str);

	}

	public void productQRCode() {
		mQRCode = new QRCode();
		String passwd = getPasswd();
		String deviceName=null;
		if(getDeviceName()!=null){
		 deviceName=getDeviceName();
		}
		if (passwd != null) {
			if(deviceName.equals("昊想智能卫士底座")){
			str =""+getAid();
			}else{
			str = "A" + getAid() + "\n" + "P" + passwd;
			}
			
		}

		File filePath = new File("test_QR_CODE.png");
		String path = filePath.getAbsolutePath();
		int width, height;
		width = height = 120;
		mQRCode.encode(str, path, width, height);
		mQRCode.decode(filePath);

		Image barCodePic = null;
		try {
			barCodePic = ImageIO.read(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		jLabel_binaryPic.setIcon(new ImageIcon(barCodePic));
		System.out.println("MainUI::productQRCode()");
		appendTextareaText(jTextArea_status, "\n二维码已生成: " + str);
	}

	private void jButton_printLabelActionPerformed(ActionEvent evt) {
		// System.out.println("jButton_printLabel.actionPerformed, event="+evt);
		// ProductPasswd();
		//tianbaolei 2015-1-19
		if("昊想智能卫士底座".equals(getDeviceName())&&"".equals(getAid())){
			JOptionPane.showMessageDialog(getParent(), "设备的AID不存在！",
					 "AID错误",JOptionPane.WARNING_MESSAGE);
			return ;
		}
		//end
		
		productQRCode();
		printBinaryPicture();
	}

	public class printInfo {
		String device;
		String product;
		String voltage;
		String company;
		String current;
		String power;
		String frequency;
		String productSerialNO;
		String str_product;
		String passwd;
		String aid;
		String gid;
		String userName;

		boolean showHexAidFlag;
		int formatIndex;

		public String getUserName() {
			if(userName==null){
				return "null";
			}
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getGid() {
			return gid;
		}

		public void setGid(String gid) {
			this.gid = gid;
		}

		public int getFormatIndex() {
			return formatIndex;
		}

		public void setFormatIndex(int formatIndex) {
			this.formatIndex = formatIndex;
		}

		public boolean getShowHexAidFlag() {
			return showHexAidFlag;
		}

		public void setShowHexAidFlag(boolean showHexAidFlag) {
			this.showHexAidFlag = showHexAidFlag;
		}

		public String getDevice() {
			if (device == null) {
				return "null";
			}
			return device;
		}

		public void setDevice(String device) {
			this.device = device;
		}

		public String getProduct() {
			if (product == null) {
				return "null";
			}
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

		public String getTester() {
			if (productSerialNO == null) {
				return "null";
			}
			return productSerialNO;
		}

		public void setTester(String productSerialNO) {
			this.productSerialNO = productSerialNO;
		}

		public String getVoltage() {
			if (voltage == null) {
				return "null";
			}
			return voltage;
		}
		public void setVoltage(String voltage) {
			this.voltage = voltage;
		}
		public String getCompany() {
			if (company == null) {
				return "";
			}
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}

		public String getCurrent() {
			return current;
		}

		public void setCurrent(String current) {
			this.current = current;
		}

		public String getPower() {
			if (power == null) {
				return "null";
			}
			return power;
		}

		public void setPower(String power) {
			this.power = power;
		}

		public String getFrequency() {
			if (frequency == null) {
				return "null";
			}
			return frequency;
		}

		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}

		public String getStr_product() {
			if (str_product == null) {
				return "null";
			}
			return str_product;
		}

		public void setStr_product(String str_product) {
			this.str_product = str_product;
		}

		public String getPasswd() {
			if (passwd == null) {
				return "null";
			}
			return passwd;
		}

		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}

		public String getAid() {
			if (aid == null) {
				return "null";
			}
			return aid;
		}

		public void setAid(String aid) {
			this.aid = aid;
		}

		// new print item
		String deviceType;
		String deviceID;
		String devicePassword;
		String deviceSSID;
		String deviceName;
		int formatNewIndex;
		
		/**
		 * 2015-1-20 tianbaolei 
		 * @return
		 */
		//String deviceName;
		//String deviceType;
		//String deviceID;		//MAC地址
		String manageIP;
		String deviceSN;
		String deviceVresion;
		//String power;
		String officialWebsite;		//官方网址
		int powerLineIndex;
		
		public int getPowerLineIndex() {
			return powerLineIndex;
		}

		public void setPowerLineIndex(int powerLineIndex) {
			this.powerLineIndex = powerLineIndex;
		}

		public String getManageIP() {
			return manageIP;
		}
		public void setManageIP(String manageIP) {
			this.manageIP = manageIP;
		}
		public String getDeviceSN() {
			return deviceSN;
		}
		public void setDeviceSN(String deviceSN) {
			this.deviceSN = deviceSN;
		}
		public String getDeviceVresion() {
			return deviceVresion;
		}
		public void setDeviceVresion(String deviceVresion) {
			this.deviceVresion = deviceVresion;
		}
		public String getOfficialWebsite() {
			return officialWebsite;
		}
		public void setOfficialWebsite(String officialWebsite) {
			this.officialWebsite = officialWebsite;
		}
		//end

		public int getformatNewIndex() {
			return formatNewIndex;
		}

		public void setformatNewIndex(int index) {
			this.formatNewIndex = index;
		}

		public String getdeviceName() {
			if (deviceName == null) {
				return "null";
			}
			return deviceName;
		}

		public void setdeviceName(String name) {
			this.deviceName = name;
		}

		public String getdeviceID() {
			if (deviceID == null) {
				return "null";
			}
			return deviceID;
		}

		public void setdeviceID(String id) {
			this.deviceID = id;
		}

		public String getdeviceType() {
			if (deviceType == null) {
				return "null";
			}
			return deviceType;
		}

		public void setdeviceType(String type) {
			this.deviceType = type;
		}

		public String getdevicePassword() {
			if (devicePassword == null) {
				return "null";
			}
			return devicePassword;
		}

		public void setdevicePassword(String password) {
			this.devicePassword = password;
		}

		public String getdeviceSSID() {
			if (deviceSSID == null) {
				return "null";
			}
			return deviceSSID;
		}

		public void setdeviceSSID(String ssid) {
			this.deviceSSID = ssid;
		}
	}

	public class recordInfo {
		String passwd;
		String aid;
		String device;
		String product;
		String productSerialNO;
		String date;

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getPasswd() {
			if (passwd == null) {
				return "null";
			}
			return passwd;
		}

		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}

		public String getAid() {
			if (aid == null) {
				return "null";
			}
			return aid;
		}

		public void setAid(String aid) {
			this.aid = aid;
		}

		public String getDevice() {
			if (device == null) {
				return "null";
			}
			return device;
		}

		public void setDevice(String device) {
			this.device = device;
		}

		public String getProduct() {
			if (product == null) {
				return "null";
			}
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

		public String getProductSerialNO() {
			if (productSerialNO == null) {
				return "null";
			}
			return productSerialNO;
		}

		public void setProductSerialNO(String productSerialNO) {
			this.productSerialNO = productSerialNO;
		}
	}

	private Paper setPapeSize(double width, double height) {
		Paper p = new Paper();
		p.setSize(width, height);// 纸张大小
		p.setImageableArea(0, 0, width, height);
		return p;
	}

	public Paper getPageFormFormat() {
		Paper p = new Paper();
		
		/**
		 * tianboalei 2015-1-21
		 * 添加电力线样式设置，修改之前不同标签打印时纸张设置相互影响问题
		 * 用jTabbedPane标识当前所在的打印项目
		 */
		if(jTabbedPane.getSelectedIndex()==0){
			///System.out.println("设置打印页时-选中页："+jTabbedPane.getSelectedIndex());
			int formatIndex = MainUI.GetDeviceFormatIndex();
			if (formatIndex == 0) {
				formatIndex = jComboBox_choosePrintFormat.getSelectedIndex();
			}
			switch (formatIndex) {
			case 1:
				// 53 * 41
				///暂时把电源控制模块的标签尺寸改为40*29
				/*p = setPapeSize(5.3 * PrintFinal.INCH / 2.54,
						4.1 * PrintFinal.INCH / 2.54);
				break;*/
			case 2:
			case 3:
			case 34:
				// 40 × 29
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;
			case 4:
			case 5:
			case 6:
			case 11:
				// 87×29
				p = setPapeSize(8.7 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;
			case 7:
				// 31×26
				p = setPapeSize(3.1 * PrintFinal.INCH / 2.54,
						2.6 * PrintFinal.INCH / 2.54);
				break;
			case 8:
			case 12:
				// 47.5×29.5
				p = setPapeSize(4.75 * PrintFinal.INCH / 2.54,
						2.95 * PrintFinal.INCH / 2.54);
				break;
			case 9:
				// 69×61
				/*
				 * p = setPapeSize(6.9 * PrintFinal.INCH / 2.54, 6.1 *
				 * PrintFinal.INCH / 2.54);
				 */
				// 70*50
				p = setPapeSize(7.0 * PrintFinal.INCH / 2.54,
						5.0 * PrintFinal.INCH / 2.54);
				break;
			case 10:
				// 37.5×23.5
				p = setPapeSize(3.75 * PrintFinal.INCH / 2.54,
						2.35 * PrintFinal.INCH / 2.54);
				break;
			case 13:
				// 40 × 29
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;
			case 14:
				// 40 × 29
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
			case 21:
			case 22:
			case 23:
			case 24:
			case 25:
			case 26:
			case 27:
			case 28:
			case 29:
				// 40 × 29
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;
			//Added by 唐鹰
			//Add 2014-11-11 Start：	
			case 30:
				// 40 × 29
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;
		    //End
			case 32:	//和下面用一样的尺寸
			case 31:
				// 40 × 29
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;
			
			// added by wzj 2015-7-23 start
			case 33:
//								p = setPapeSize(25 * PrintFinal.INCH / 6,
//										25 * PrintFinal.INCH / 18);

				p = setPapeSize(11 * PrintFinal.INCH / 2.54,
						4 * PrintFinal.INCH / 2.54);

				break;
						// end
				
			//Added by wzj
			//Add 2015-07-14 Start：	
			case 35:
				// 40 × 29
				p = setPapeSize(11 * PrintFinal.INCH / 2.54,
						4 * PrintFinal.INCH / 2.54);
				break;
				
			case 37:
				// 40 × 29
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;
				
			case 38:
				// 40 × 29
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;	
			case 39:
				// 40 × 29
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;	
			//End
			default:
				break;
			}
		}else if(jTabbedPane.getSelectedIndex()==1){	//电力线类的纸张尺寸使用同一个设置 
			//System.out.println("");
			p = setPapeSize(4 * PrintFinal.INCH / 2.54,
					2.9 * PrintFinal.INCH / 2.54);
		}else if(jTabbedPane.getSelectedIndex()==2){
			//System.out.println("设置打印页时-选中页："+jTabbedPane.getSelectedIndex());
			int formatNewIndex = jComboBox_chooseDevice_9.getSelectedIndex();	//当选择互动双向
			switch (formatNewIndex) {
			case 1:
			case 2:
			case 3:
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;
			default:
				break;
			}
		}
		return p;
	}

	// 执行打印
	public void printNewBinaryPicture() {

		int formatIndex = jComboBox_chooseDevice_9.getSelectedIndex();
		int number = Integer.parseInt(getBinaryNum());
		String id=getNewDeviceID().substring(0, 8);
		String id_=getNewDeviceID().substring(8);
		ArrayList<String> companyList = LabelsUtil.readFile("companys.txt");
		String company = companyList!=null?companyList.get(0):"";
		ArrayList<String> officalWebSite = LabelsUtil.readFile("officalWebSite.txt");
		String url = officalWebSite==null?"null":officalWebSite.get(0);
		for (int i = 0; i < number; i++) {
			Book book = new Book();
			PageFormat pf = new MyPaperFormat(this);
			String deviceName = getNewDeviceName();
			String deviceType = getNewDeviceType();
			
			String ID=String.valueOf(Integer.parseInt(id_)+i);
			if(ID.length()==1){
				ID="000"+ID;
			}
			else if(ID.length()==2){
				ID="00"+ID;
			}
			else if(ID.length()==3){
				ID="0"+ID;
			}
			String deviceID=id+ID;
			int len = deviceID.length();
			String[] str = new String[len / 2];
			byte[] b = new byte[len / 2];
			byte b1 = 0;
			for (int j = 0; j < len / 2; j++) {
				str[j] = deviceID.substring(len - j * 2 - 2, len - j * 2);
				b[j] = hexStringToByte(str[j]);
				b1 = (byte) (b1 + b[j]);
			}
			String str1 = deviceID.subSequence(6, len) + Integer.toHexString(b1);
			char[] c = new char[str1.length()];
			String str2 = "";
			for (int k = 0; k < str1.length(); k++) {
				c[k] = str1.charAt(k);
				if (Character.isLowerCase(c[k])) {
					c[k] = Character.toUpperCase(c[k]);
				}
				str2 = str2 + String.valueOf(c[k]);
			}
			if (str2.length() > 8)
				str2 = str2.substring(0, 6) + str2.substring(12);
			
			String devicePassword = str2;
			String deviceSSID =jComboBox_chooseDeviceSSID_Head_9.getSelectedItem()+deviceID;
			productNewQRCode(deviceID, devicePassword, deviceSSID);

			printinfo = new printInfo();
			printinfo.setformatNewIndex(formatIndex);
			printinfo.setdeviceName(deviceName);
			printinfo.setdeviceType(deviceType);
			printinfo.setdeviceID(deviceID);
			printinfo.setdevicePassword(devicePassword);
			printinfo.setdeviceSSID(deviceSSID);
			printinfo.setCompany(company);
			printinfo.setOfficialWebsite(url);
			myPrint = new MyPrint(printinfo);
			book.append(myPrint, pf);
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPageable(book);
			try {
				if (true) {
					job.print();
					appendTextareaText(jTextArea_status, "\n执行打印");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	public void printBinaryPicture() {
		// System.out.println(stringBuffer);
		int formatIndex = GetDeviceFormatIndex();
		if (formatIndex == 0) {
			formatIndex = jComboBox_choosePrintFormat.getSelectedIndex();
		}
		if (formatIndex == 0) {
			appendTextareaText(jTextArea_status, "\n请选择打印样式或设备名称");
		} else {

			// 通俗理解就是书、文档
			Book book = new Book();
			// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
			/*
			 * Paper p = getPageFromFormat(); pf.setPaper(p);
			 */
			PageFormat pf = new MyPaperFormat(this);

			String device = getDevice();
			String product = getProduct();
			String voltage = getVoltage();
			String company = getCompany();
			String current = getCurrent();
			String power = getPower();
			String frequency = getFrequency();
			String productSerialNO = getTester();
			boolean showHexFlg = getShowHexAidFlag();
			String aid = getAid();
			String passwd = getPasswd();

			printinfo = new printInfo();
			printinfo.setDevice(device);
			printinfo.setProduct(product);
			printinfo.setVoltage(voltage);
			printinfo.setCompany(company);
			printinfo.setCurrent(current);
			printinfo.setPower(power);
			printinfo.setFrequency(frequency);
			printinfo.setTester(productSerialNO);
			printinfo.setAid(aid);
			printinfo.setPasswd(passwd);
			printinfo.setShowHexAidFlag(showHexFlg);
			printinfo.setFormatIndex(formatIndex);

			recordInfo recordinfor = new recordInfo();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
			recordinfor.setDate(df.format(new Date()));
			recordinfor.setProductSerialNO(productSerialNO);
			recordinfor.setDevice(device);
			recordinfor.setProduct(product);
			recordinfor.setAid(aid);
			recordinfor.setPasswd(passwd);

			myPrint = new MyPrint(printinfo);

			book.append(myPrint, pf);

			// 获取打印服务对象
			PrinterJob job = PrinterJob.getPrinterJob();
			// 设置打印类
			job.setPageable(book);

			try {
				// if (job.printDialog()) {
				if (true) {
					// 记录打印信息
					savePrintInfoToExcel(recordinfor, formatIndex);
					job.print();
					appendTextareaText(jTextArea_status, "\n执行打印");
				}
			} catch (PrinterException e) {
				e.printStackTrace();
			}

		}

	}

	public static int GetDeviceFormatIndex() {
		int index = 0;
		String deviceName = (String) jComboBox_chooseDevice.getSelectedItem();
		switch (deviceName) {
		case DevicesName.POWER_CTRL_NAME:
		case DevicesName.SMART_CTRL_NAME:
			index = 1;
			break;
		case DevicesName.LCD_TOUCH_SWITCHER_NAME:
		case DevicesName.CURTAIN_CTRL_SWITCHER_NAME:
			index = 2;
			break;
		case DevicesName.CAP_TOUCH_SWITCHER_NAME:
			index = 3;
			break;
		case DevicesName.ONE_WAY_CURTAIN_CTRLER_NAME:
			index = 4;
			break;
		case DevicesName.LIGHT_CTRLER_NAME:
			index = 5;
			break;
		case DevicesName.ADJUST_LIGHT_CTRLER_NAME:
			index = 6;
			break;
		case DevicesName.IR_TRANSFER_NAME:
			index = 7;
			break;
		case DevicesName.SMART_GATEWAW_NAME:
			index = 8;
			break;
		case DevicesName.RGB_CTRLER_NAME:
			index = 9;
			break;
		case DevicesName.SMART_PLUG_NAME:
			index = 10;
			break;
		case DevicesName.TWO_WAY_CURTAIN_CTRLER_NAME:
			index = 11;
			break;
		case DevicesName.BODY_IR_SENSOR:
			index = 12;
			break;
		case DevicesName.NET_POWER_MONITOR:
			index = 13;
			break;
		//昊想智能
		case DevicesName.HO_THINK_NAME:
			index = 31;
			break;

		//智能漏电保护
		case DevicesName.SMART_PROTECT:
			index = 32;
			break;
		
		// 开关控制模块 -wzj-2015-7-23
		case DevicesName.SWITCH_CTRL:
			index = 33;
			break;	
		//红外微波双鉴探测器
		case DevicesName.INFRARED_DOUBLE:
			index = 34;
			break;
		//PLC-485转换器 
		//Added by wzj
		case DevicesName.PLC_485_CONVERT:
			index = 35;
			break;
		case DevicesName.Switch_Actuator_4f:
			index = 37;
			break;
//		case DevicesName.PLC_Sub1GHz:
//			index = 38;
//			break;
		case DevicesName.PLC_Sub1G_WHITE:
			index = 38;
			break;
		case DevicesName.PLC_Sub1G_BLACK:
			index = 39;
			break;
			
		default:
			break;
		}
		return index;
	}

	public String GetDeviceTypeId() {
		String typeId = null;
		String deviceName = (String) jComboBox_chooseDevice.getSelectedItem();
		switch (deviceName) {
		case DevicesName.POWER_CTRL_NAME:
		case DevicesName.POWER_CTRL_NAME_1:
		case DevicesName.SMART_CTRL_NAME:
			typeId = DeviceTypesID.POWER_CTRLER_HEX_ID;
			break;
		case DevicesName.LCD_TOUCH_SWITCHER_NAME:
			typeId = DeviceTypesID.LCD_TOUCH_SWITCHER_HEX_ID;
			break;
		case DevicesName.CURTAIN_CTRL_SWITCHER_NAME:
			typeId = DeviceTypesID.CURTAIN_CTRL_SWITCHER_HEX_ID;
			break;
		case DevicesName.CAP_TOUCH_SWITCHER_NAME:
			typeId = DeviceTypesID.CAP_TOUCH_SWITCHER_HEX_ID;
			break;
		case DevicesName.ONE_WAY_CURTAIN_CTRLER_NAME:
		case DevicesName.ONE_WAY_CURTAIN_CTRLER_NAME_1:
		case DevicesName.ONE_WAY_CURTAIN_CTRLER_NAME_2:
			typeId = DeviceTypesID.ONE_WAY_CURTAIN_CTRLER_HEX_ID;
			break;
		case DevicesName.LIGHT_CTRLER_NAME:
		case DevicesName.LIGHT_CTRLER_NAME_1:
		case DevicesName.LIGHT_CTRLER_NAME_2:
			typeId = DeviceTypesID.LIGHT_CTRLER_HEX_ID;
			break;
		case DevicesName.ADJUST_LIGHT_CTRLER_NAME:
		case DevicesName.ADJUST_LIGHT_CTRLER_NAME_1:
		case DevicesName.ADJUST_LIGHT_CTRLER_NAME_2:

			typeId = DeviceTypesID.ADJUST_LIGHT_CTRLER_HEX_ID;
			break;
		case DevicesName.IR_TRANSFER_NAME:
		case DevicesName.IR_TRANSFER_NAME_1:
			typeId = DeviceTypesID.IR_TRANSFER_HEX_ID;
			break;
		case DevicesName.SMART_GATEWAW_NAME:
		case DevicesName.SMART_GATEWAW_NAME_1:
			typeId = DeviceTypesID.SMART_GATEWAW_HEX_ID;
			break;
		case DevicesName.RGB_CTRLER_NAME:
		case DevicesName.RGB_CTRLER_NAME_1:
		case DevicesName.RGB_CTRLER_NAME_2:
			typeId = DeviceTypesID.RGB_CTRLER_HEX_ID;
			break;
		case DevicesName.SMART_PLUG_NAME:
		case DevicesName.SMART_PLUG_NAME_1:
			typeId = DeviceTypesID.SMART_PLUG_HEX_ID;
			break;
		case DevicesName.TWO_WAY_CURTAIN_CTRLER_NAME:
		case DevicesName.TWO_WAY_CURTAIN_CTRLER_NAME_1:
		case DevicesName.TWO_WAY_CURTAIN_CTRLER_NAME_2:
			typeId = DeviceTypesID.TWO_WAY_CURTAIN_CTRLER_HEX_ID;
			break;
		case DevicesName.BODY_IR_SENSOR:
		case DevicesName.BODY_IR_SENSOR_1:
			typeId = DeviceTypesID.BODY_IR_SENSOR_HEX_ID;
			break;
		case DevicesName.NET_POWER_MONITOR:
			typeId = DeviceTypesID.NET_POWER_MONITOR_HEX_ID;
			break;
		case DevicesName.NET_POWER_MONITOR_HEX_ID:
			typeId = DeviceTypesID.NET_POWER_MONITOR_HEX_ID;
			break;
		case DevicesName.PAD_GATEWAW_NAME:
			typeId = DeviceTypesID.PAD_GATEWAW_NAME_ID;
			break;
		//Added by 唐鹰
		//Add 2014-11-11 Start：
		case DevicesName.NET_POWER_MONITOR_CTRLER:
		typeId = DeviceTypesID.NET_POWER_MONITOR_CTRLER;
		break;
		//End： 
		case DevicesName.HO_THINK_NAME:
			typeId = DeviceTypesID.HO_THINK_ID;
		case DevicesName.SMART_PROTECT:
			typeId = DeviceTypesID.SMART_PROTECT_TYPE;
			break;
		case DevicesName.INFRARED_DOUBLE:
			typeId = DeviceTypesID.INFRARED_DOUBLE_ID;
		//Added by wzj
		//Add 2015-07-14 Start：
		case DevicesName.PLC_485_CONVERT:
			typeId = DeviceTypesID.PLC_485_CONVERT;
			break;
		case DevicesName.Switch_Actuator_4f:
			typeId = DeviceTypesID.Switch_Actuator_4f;
			break;
//		case DevicesName.PLC_Sub1GHz:
//			typeId = DeviceTypesID.PLC_Sub1GHz;
//			break;
		case DevicesName.PLC_Sub1G_WHITE:
		case DevicesName.PLC_Sub1G_BLACK:
			typeId = DeviceTypesID.PLC_Sub1G;
			break;
		//	2015-07-23
		case DevicesName.SWITCH_CTRL:
			typeId = DeviceTypesID.SWITCH_CTRL;
			break;
		//End： 
		default:
			break;
		}
		return typeId;
	}

	void savePrintInfoToExcel(recordInfo recordinfor, int printFormat) {
		if (printFormat != 0) {
			HSSFWorkbook wb = null;
			File printRecord = new File("打印记录.xls");
			if (!printRecord.exists()) {

				wb = new HSSFWorkbook();
				HSSFSheet sheet1 = wb.createSheet("sheet1");
				HSSFRow row = sheet1.createRow(0);
				row.createCell((short) 0).setCellValue("打印日期           ");
				row.createCell((short) 1).setCellValue("测试人员           ");
				row.createCell((short) 2).setCellValue("设备名称           ");
				row.createCell((short) 3).setCellValue("产品型号           ");
				row.createCell((short) 4).setCellValue("设备Aid     ");
				row.createCell((short) 5).setCellValue("设备密码            ");

				HSSFRow row1 = sheet1.createRow(sheet1.getLastRowNum() + 1);
				row1.createCell((short) 0).setCellValue(recordinfor.getDate());
				row1.createCell((short) 1).setCellValue(
						recordinfor.getProductSerialNO());
				row1.createCell((short) 2)
						.setCellValue(recordinfor.getDevice());
				row1.createCell((short) 3).setCellValue(
						recordinfor.getProduct());
				row1.createCell((short) 4).setCellValue(recordinfor.getAid());
				row1.createCell((short) 5)
						.setCellValue(recordinfor.getPasswd());

			} else {
				FileInputStream fs = null;
				try {
					fs = new FileInputStream(printRecord);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				POIFSFileSystem ps = null;
				try {
					ps = new POIFSFileSystem(fs);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					wb = new HSSFWorkbook(ps);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				HSSFSheet sheet = wb.getSheetAt(0);
				// 创建一行并向其中添加一些cell,Rows 下标从0开始(Create a row and put some cells
				// in
				// it. Rows are 0 based.)
				HSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);
				row.createCell((short) 0).setCellValue(recordinfor.getDate());
				row.createCell((short) 1).setCellValue(
						recordinfor.getProductSerialNO());
				row.createCell((short) 2).setCellValue(recordinfor.getDevice());
				row.createCell((short) 3)
						.setCellValue(recordinfor.getProduct());
				row.createCell((short) 4).setCellValue(recordinfor.getAid());
				row.createCell((short) 5).setCellValue(recordinfor.getPasswd());

			}

			FileOutputStream fileOut = null;
			try {
				fileOut = new FileOutputStream(printRecord);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				appendTextareaText(jTextArea_status,
						"\n打印记录.xls 另一个程序正在使用此文件，请关闭");
				JOptionPane.showMessageDialog(getParent(),
						"打印记录.xls 另一个程序正在使用此文件，请关闭", "打印记录.xls文件错误",
						JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
			try {
				wb.write(fileOut);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fileOut.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void jButton_insertInforActionPerformed(ActionEvent evt) {
		// System.out.println("jButton_insertInfor.actionPerformed, event="+evt);
		String add_device = jTextField_insertdevice.getText();
		String add_product = jTextField_insertProductType.getText();
		String add_voltage = jTextField_insertVoltage.getText();
		//获取公司名
		String add_company = jTextField_insertCompany.getText();
		String add_current = jTextField_insertCurrent.getText();
		String add_power = jTextField_insertPower.getText();

		if (!add_device.equals("")) {
			LabelsUtil.appendString("devices.txt", add_device);
			jComboBox_chooseDevice.addItem(add_device);
		}

		if (!add_product.equals("")) {
			LabelsUtil.appendString("products.txt", add_product);
			jComboBox_chooseProductType.addItem(add_product);
		}
		if (!add_voltage.equals("")) {
			LabelsUtil.appendString("voltages.txt", add_voltage);
			jComboBox_chooseVoltage.addItem(add_voltage);
		}
		//公司名称
		if (!add_company.equals("")) {
			LabelsUtil.appendString("companys.txt", add_company);
			jComboBox_chooseCompany.addItem(add_company);
		}
		if (!add_current.equals("")) {
			LabelsUtil.appendString("currents.txt", add_current);
			jComboBox_chooseCurrent.addItem(add_current);
		}

		if (!add_power.equals("")) {
			LabelsUtil.appendString("powers.txt", add_power);
			jComboBox_choosePower.addItem(add_power);
		}

		/*
		 * if(add_device.equals("") && add_product.equals("") &&
		 * add_voltage.equals("") && add_power.equals("")){
		 * 
		 * }else{
		 * 
		 * device = jTextField_insertdevice.getText(); product =
		 * jTextField_insertProductType.getText(); voltage =
		 * jTextField_insertVoltage.getText(); power =
		 * jTextField_insertPower.getText(); try { p.store(new
		 * OutputStreamWriter(new FileOutputStream(file),"UTF-8"), null);
		 * 
		 * } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
		 * catch (FileNotFoundException e) { e.printStackTrace(); } catch
		 * (IOException e) { e.printStackTrace(); } }
		 */
	}

	private void jCombox_choosePortsItemStateChanged(ItemEvent evt) {
		// System.out.println("jCombox_choosePorts.itemStateChanged, event="+evt);
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			this.jCombox_choosePorts.getSelectedIndex();
			// commCfg.setPortName(Ports[index-1]);
			// System.out.println("choose Port: "+Ports[index-1]);
			saveCommCfg();

		}
	}

	private void jComboBox_chooseBoundrateItemStateChanged(ItemEvent evt) {
		// System.out.println("jComboBox_chooseBoundrate.itemStateChanged, event="+evt);
		if (evt.getStateChange() == ItemEvent.SELECTED) {

			this.jComboBox_chooseBoundrate.getSelectedIndex();
			// commCfg.setBaudRate(Baudrates[index-1]);
			// System.out.println("choose Baudrate: "+Baudrates[index-1]);
			saveCommCfg();
		}
	}

	private void jComboBox_chooseDatabitItemStateChanged(ItemEvent evt) {
		// System.out.println("jComboBox_chooseDatabit.itemStateChanged, event="+evt);
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			this.jComboBox_chooseDatabit.getSelectedIndex();
			// commCfg.setDatabits(DataBits[index-1]);
			// System.out.println("choose DataBit: "+DataBits[index-1]);
			saveCommCfg();

		}
	}

	private void jComboBox_chooseStopBitItemStateChanged(ItemEvent evt) {
		// System.out.println("jComboBox_chooseStopBit.itemStateChanged, event="+evt);
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			this.jComboBox_chooseStopBit.getSelectedIndex();
			// commCfg.setStopbits(StopBits[index-1]);
			// System.out.println("choose StopBits: "+StopBits[index-1]);
			saveCommCfg();
		}
	}

	private void jComboBox_choosePorityBitItemStateChanged(ItemEvent evt) {
		// System.out.println("jComboBox_choosePorityBit.itemStateChanged, event="+evt);
		if (evt.getStateChange() == ItemEvent.SELECTED) {

			this.jComboBox_choosePorityBit.getSelectedIndex();
			// commCfg.setParity(Paritys[index-1]);
			// System.out.println("choose Paritys: "+Paritys[index-1]);
			saveCommCfg();
		}

	}

	private void jComboBox_choosePrintFormatItemStateChanged(ItemEvent evt) {
		// System.out.println("jComboBox_choosePrintFormat.itemStateChanged, event="+evt);
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			printFormatIndex = jComboBox_choosePrintFormat.getSelectedIndex();
			System.out.println("getSelectedIndex():  "
					+ jComboBox_choosePrintFormat.getSelectedIndex());
			/*
			 * switch (printFormatIndex) { case 3:
			 * pf.setOrientation(PageFormat.LANDSCAPE); break; default:
			 * pf.setOrientation(PageFormat.PORTRAIT); break; }
			 */
			switch (printFormatIndex) {
			case 0:
				appendTextareaText(jTextArea_status, "\n--请选择打印样式--");
				break;
			case 1:
				appendTextareaText(jTextArea_status, "\n--53×41mm--支持设备：电源控制模块");

				break;
			case 2:
				appendTextareaText(jTextArea_status,
						"\n--40×29mm--支持设备：LCD触摸开关");
				break;
			case 3:
				appendTextareaText(jTextArea_status,
						"\n--40×29mm--支持设备：电容触摸开关、窗帘控制开关");
				break;
			case 4:
				appendTextareaText(jTextArea_status, "\n--87×29mm--支持设备：窗帘控制器");
				break;
			case 5:
				appendTextareaText(jTextArea_status, "\n--87×29mm--支持设备：灯光控制器");
				break;
			case 6:
				appendTextareaText(jTextArea_status, "\n--87×29mm--支持设备：调光控制器");
				break;
			case 7:
				appendTextareaText(jTextArea_status, "\n--31×26mm--支持设备：红外转发器等");
				break;
			case 8:
				appendTextareaText(jTextArea_status,
						"\n--47.5×29.5mm--支持设备：智能网关等");
				break;
			case 9:
				appendTextareaText(jTextArea_status,
						"\n--69×61mm--支持设备：RGB调光控制器");
				break;
			case 10:
				appendTextareaText(jTextArea_status,
						"\n--37.5×23.5mm--支持设备：智能插座");
				break;
			case 11:
				appendTextareaText(jTextArea_status,
						"\n--87×29mm--支持设备：双轨窗帘控制器");
				break;
			default:
				break;
			}

			if (printFormatIndex != 0) {
				EnableOrDisableTextType(true);
			} else {
				EnableOrDisableTextType(false);
			}
		}
	}

	/**
	 * able_flag ==true enable ,false ==disable
	 */
	private void EnableOrDisableTextType(boolean able_flag) {
		// TODO Auto-generated method stub
		if (response == 0) {
			jTextField_devicesTypeInsert.setVisible(false);
			jLabel3.setVisible(false);
		} else {

			if (able_flag) {
				jLabel3.setEnabled(true);
				jTextField_devicesTypeInsert.setEnabled(true);
			} else {
				jLabel3.setEnabled(false);
				jTextField_devicesTypeInsert.setEnabled(false);
			}
		}

	}

	public static int getInsertedPrintFormat() {
		return printFormatIndex;
	}

	private JLabel getJLabel_binaryPic() {
		if (jLabel_binaryPic == null) {
			jLabel_binaryPic = new JLabel();
			jLabel_binaryPic.setBounds(94, 15, 100, 100);
		}
		return jLabel_binaryPic;
	}

	private JButton getJButton_printPreview() {
		if (jButton_printPreview == null) {
			jButton_printPreview = new JButton();
			jButton_printPreview.setText("\u6253\u5370\u9884\u89c8");	//打印预览
			jButton_printPreview.setBounds(55, 457, 98, 56);
			jButton_printPreview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton_printPreviewActionPerformed(evt);
				}
			});
		}
		return jButton_printPreview;
	}

	private void jButton_new_printPreviewActionPerformed(ActionEvent evt) {
		int formatIndex = jComboBox_chooseDevice_9.getSelectedIndex();

		String deviceName = getNewDeviceName();
		String deviceType = getNewDeviceType();
		String deviceID = getNewDeviceID();
		String devicePassword = getNewDevicePassword();
		String deviceSSID = getNewDeviceSSID();
		
		ArrayList<String> companyList = LabelsUtil.readFile("companys.txt");
		String company = companyList!=null?companyList.get(0):"";
		ArrayList<String> officalWebSite = LabelsUtil.readFile("officalWebSite.txt");
		String url = officalWebSite==null?"null":officalWebSite.get(0);
		printInfo printinfo = new printInfo();
		printinfo.setformatNewIndex(formatIndex);
		printinfo.setdeviceName(deviceName);
		printinfo.setdeviceType(deviceType);
		printinfo.setdeviceID(deviceID);
		printinfo.setdevicePassword(devicePassword);
		printinfo.setdeviceSSID(deviceSSID);
		printinfo.setCompany(company);
		printinfo.setOfficialWebsite(url);
		(new PrintNewPreviewDialog(this, this, "打印预览", true,
				new MyPrint(printinfo))).setVisible(true);
	}
	
	

	private void jButton_printPreviewActionPerformed(ActionEvent evt) {
		// System.out.println("jButton_printPreview.actionPerformed, event="+evt);
		if("昊想智能卫士底座".equals(getDeviceName())&&"".equals(getAid())){
			JOptionPane.showMessageDialog(getParent(), "设备的AID不存在！",
					 "AID错误",JOptionPane.WARNING_MESSAGE);
			return ;
		}
		int formatIndex = GetDeviceFormatIndex();
		if (formatIndex == 0) {
			formatIndex = jComboBox_choosePrintFormat.getSelectedIndex();
		}
		if (formatIndex == 0) {
			appendTextareaText(jTextArea_status, "\n请选择打印样式或设备名称");
		} else {
			String device = getDevice();
			String product = getProduct();
			String voltage = getVoltage();
			String company = getCompany();
			String current = getCurrent();
			String power = getPower();
			String frequency = getFrequency();
			String productSerialNO = getTester();
			String aid = getAid();
			// ProductPasswd();
			String passwd = getPasswd();
			boolean showHexAidFlag = getShowHexAidFlag();

			printInfo printinfo = new printInfo();
			printinfo.setDevice(device);
			printinfo.setProduct(product);
			printinfo.setVoltage(voltage);
			printinfo.setCompany(company);
			printinfo.setCurrent(current);
			printinfo.setPower(power);
			printinfo.setFrequency(frequency);
			printinfo.setTester(productSerialNO);
			printinfo.setAid(aid);
			printinfo.setPasswd(passwd);
			printinfo.setShowHexAidFlag(showHexAidFlag);
			printinfo.setFormatIndex(formatIndex);
			(new PrintPreviewDialog(this, this, "打印预览", true, new MyPrint(
					printinfo))).setVisible(true);
		}

	}

	/*
	 * private JButton getJButton_saveTofile() { if(jButton_saveTofile == null)
	 * { jButton_saveTofile = new JButton();
	 * jButton_saveTofile.setText("\u4fdd\u5b58\u914d\u7f6e");
	 * jButton_saveTofile.setBounds(313, 23, 112, 38);
	 * jButton_saveTofile.setFont(new java.awt.Font("MS UI Gothic",0,14));
	 * jButton_saveTofile.addActionListener(new ActionListener() { public void
	 * actionPerformed(ActionEvent evt) {
	 * jButton_saveTofileActionPerformed(evt); } }); } return
	 * jButton_saveTofile; }
	 */

	private void saveCommCfg() {
		commCfg.setPortName((String) jCombox_choosePorts.getSelectedItem());
		commCfg.setBaudRate(StringUtil.strToInt(
				(String) jComboBox_chooseBoundrate.getSelectedItem(), 9600));
		commCfg.setDatabits((String) jComboBox_chooseDatabit.getSelectedItem());
		commCfg.setStopbits((String) jComboBox_chooseStopBit.getSelectedItem());
		commCfg.setParity((String) jComboBox_choosePorityBit.getSelectedItem());
		commCfg.saveToFile();
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("\u5730\u5740:");
			jLabel5.setBounds(24, 115, 30, 18);
		}
		return jLabel5;
	}

	private JTextField getJTextField_address() {
		if (jTextField_address == null) {
			jTextField_address = new JTextField();
			jTextField_address.setText("112233");
			jTextField_address.setBounds(65, 112, 192, 25);
		}
		return jTextField_address;
	}

	private JButton getJButton_writeaddress() {
		if (jButton_writeaddress == null) {
			jButton_writeaddress = new JButton();
			jButton_writeaddress.setText("\u5199\u5165\u5730\u5740");
			jButton_writeaddress.setBounds(304, 110, 98, 28);
			jButton_writeaddress.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton_writeaddressActionPerformed(evt);
				}
			});
		}
		return jButton_writeaddress;
	}

	@Override
	public void showAllReceive(String msg) {
		appendTextareaText(jTextArea_status, msg);
	}

	void StartPrint(String msg) {
		// TODO Auto-generated method stub
		// System.out.println("\n接收:"+msg);
		if (msg.length() != 0) {
			jTextField_readAIDresult.setText(msg);
			jTextField_readAIDresult_hex.setText(Long.toHexString(Long
					.parseLong(msg)));
			insertPasswd(msg);
			productQRCode();
			System.out.println("MainUI::StartPrint(String msg)::productQRCode();");
			printBinaryPicture();
		} else {
			JOptionPane.showMessageDialog(getParent(), "设备的AID不存在！", "AID错误",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	private void insertPasswd(String aid) {
		try {
			if (!db.isAidExist(aid)) {
				InsertAidAndPasswd(aid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			db.close();
			e.printStackTrace();
		}
	}

	private void InsertAidAndPasswd(String msg) {
		// TODO Auto-generated method stub
		try {
			db.insert(msg, getPasswd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void responsePassword() {
		// TODO Auto-generated method stub
		ProductPasswd();
		String passwd = PASSWD_PREFIX + getPasswd();

		delayWriteComm(passwd + '\n');
		appendTextareaText(jTextArea_status, '\n' + "发送密码：" + passwd + '\n');
	}

	@Override
	public void responsePassword(String msg) {
		// TODO Auto-generated method stub
		// 判断aid是否存在
		String aid = msg;
		String passwd = null;
		/*
		 * jTextField_readAIDresult.setText(msg);
		 * jTextField_readAIDresult_hex.setText
		 * (Long.toHexString(Long.parseLong(msg)));
		 */

		try {
			if (db.isAidExist(aid)) {
				passwd = db.getPasswdFromAid(aid);
				responseDBPasswd(passwd);
				jTextField_writePasswd.setText(passwd);
				Passwd = passwd;
			} else {
				ProductPasswd();
				// InsertAidAndPasswd(aid);
				responseTextPasswd();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			db.close();
			e.printStackTrace();
		}
	}

	@Override
	public void startPrint(String msg) {
		// TODO Auto-generated method stub
		StartPrint(msg);
	}

	public void responseTextPasswd() {
		// TODO Auto-generated method stub

		String passwd = PASSWD_PREFIX + getPasswd();
		String deviceTypeId = DEV_TYPE_PREFIX + GetDeviceTypeId();

		delayWriteComm(passwd + " " + deviceTypeId + '\n');
		appendTextareaText(jTextArea_status, '\n' + "发送密码+标识码：" + passwd + " "
				+ deviceTypeId + '\n');

	}

	public void responseDBPasswd(String passwdInDb) {
		// TODO Auto-generated method stub
		String passwd = PASSWD_PREFIX + passwdInDb;
		String deviceTypeId = DEV_TYPE_PREFIX + GetDeviceTypeId();

		delayWriteComm(passwd + " " + deviceTypeId + '\n');
		appendTextareaText(jTextArea_status, '\n' + "发送密码+标识码：" + passwd + " "
				+ deviceTypeId + '\n');
	}

	private void jButton_writeaddressActionPerformed(ActionEvent evt) {
		String address = "address " + jTextField_address.getText() + '\n';
		delayWriteComm(address);
	}

	private JTextField getJTextField_readAIDresult() {
		if (jTextField_readAIDresult == null) {
			jTextField_readAIDresult = new JTextField();
			jTextField_readAIDresult.setText("1122334455");
			jTextField_readAIDresult.setBounds(65, 32, 191, 25);
			jTextField_readAIDresult.setSize(192, 25);
			jTextField_readAIDresult.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jTextField_readAIDresult_hex.setText("");
					jTextField_readAIDresult.setText("");
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
			/*
			 * jTextField_readAIDresult.getDocument().addDocumentListener(new
			 * DocumentListener() {
			 * 
			 * @Override public void removeUpdate(DocumentEvent arg0) { // TODO
			 * Auto-generated method stub EventQueue.invokeLater(new Runnable()
			 * { public void run() { String Aid =
			 * jTextField_readAIDresult.getText().trim(); if(Aid != null &&
			 * !Aid.equals("")){ long aid = Long.parseLong(Aid); String hexaid =
			 * Long.toHexString(aid).toUpperCase();
			 * jTextField_readAIDresult_hex.setText(hexaid); }else{
			 * jTextField_readAIDresult_hex.setText(""); }
			 * 
			 * 
			 * } }); }
			 * 
			 * @Override public void insertUpdate(DocumentEvent arg0) { // TODO
			 * Auto-generated method stub EventQueue.invokeLater(new Runnable()
			 * { public void run() { String Aid =
			 * jTextField_readAIDresult.getText().trim(); if(Aid != null &&
			 * !Aid.equals("")){ long aid = Long.parseLong(Aid); String hexaid =
			 * Long.toHexString(aid).toUpperCase();
			 * jTextField_readAIDresult_hex.setText(hexaid); }else{
			 * jTextField_readAIDresult_hex.setText(""); }
			 * 
			 * 
			 * } }); }
			 * 
			 * @Override public void changedUpdate(DocumentEvent arg0) { // TODO
			 * Auto-generated method stub EventQueue.invokeLater(new Runnable()
			 * { public void run() { String Aid =
			 * jTextField_readAIDresult.getText().trim(); if(Aid != null &&
			 * !Aid.equals("")){ long aid = Long.parseLong(Aid); String hexaid =
			 * Long.toHexString(aid).toUpperCase();
			 * jTextField_readAIDresult_hex.setText(hexaid); }else{
			 * jTextField_readAIDresult_hex.setText(""); }
			 * 
			 * 
			 * } }); } });
			 */
		}
		return jTextField_readAIDresult;
	}

	private JTextField getJTextField_readAIDresult_Hex() {
		if (jTextField_readAIDresult_hex == null) {
			jTextField_readAIDresult_hex = new JTextField();
			jTextField_readAIDresult_hex.setText(Long.toHexString(0x42E576F7)
					.toUpperCase());
			jTextField_readAIDresult_hex.setBounds(304, 32, 120, 25);
			jTextField_readAIDresult_hex.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jTextField_readAIDresult_hex.setText("");
					jTextField_readAIDresult.setText("");
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
			/*
			 * jTextField_readAIDresult_hex.getDocument().addDocumentListener(new
			 * DocumentListener() {
			 * 
			 * @Override public void removeUpdate(DocumentEvent arg0) {
			 * 
			 * // TODO Auto-generated method stub EventQueue.invokeLater(new
			 * Runnable() { public void run() { String HexAid =
			 * jTextField_readAIDresult_hex.getText().trim(); if(HexAid != null
			 * && !HexAid.equals("")){ long aid = Long.parseLong(HexAid,16);
			 * jTextField_readAIDresult.setText(aid+""); }else{
			 * jTextField_readAIDresult.setText(""); }
			 * 
			 * 
			 * } });
			 * 
			 * 
			 * // TODO Auto-generated method stub // long aid =
			 * Long.parseLong(jTextField_readAIDresult_hex.getText().trim(),16);
			 * // jTextField_readAIDresult.setText(aid+""); }
			 * 
			 * @Override public void insertUpdate(DocumentEvent arg0) {
			 * EventQueue.invokeLater(new Runnable() { public void run() {
			 * String HexAid = jTextField_readAIDresult_hex.getText().trim();
			 * if(HexAid != null && !HexAid.equals("")){ long aid =
			 * Long.parseLong(HexAid,16);
			 * jTextField_readAIDresult.setText(aid+""); }else{
			 * jTextField_readAIDresult.setText(""); }
			 * 
			 * 
			 * } }); }
			 * 
			 * @Override public void changedUpdate(DocumentEvent arg0) { // TODO
			 * Auto-generated method stub EventQueue.invokeLater(new Runnable()
			 * { public void run() { String HexAid =
			 * jTextField_readAIDresult_hex.getText().trim(); if(HexAid != null
			 * && !HexAid.equals("")){ long aid = Long.parseLong(HexAid,16);
			 * jTextField_readAIDresult.setText(aid+""); }else{
			 * jTextField_readAIDresult.setText(""); }
			 * 
			 * 
			 * } }); } });
			 */
		}
		return jTextField_readAIDresult_hex;
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("\u5bc6\u7801:");
			jLabel6.setBounds(23, 77, 30, 18);
		}
		return jLabel6;
	}

	private JButton getJButton_repeatPrint() {
		if (jButton_repeatPrint == null) {
			jButton_repeatPrint = new JButton();
			jButton_repeatPrint.setText("\u8fde\u7eed\u6253\u5370");
			jButton_repeatPrint.setBounds(375, 454, 99, 61);
			jButton_repeatPrint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton_repeatPrintActionPerformed(evt);
				}
			});
		}
		return jButton_repeatPrint;
	}

	private void jButton_repeatPrintActionPerformed(ActionEvent evt) {
		new ContinuousPrintAidsDialog(this).setVisible(true);

	}

	private JButton getJButton_delete() {
		if (jButton_delete == null) {
			jButton_delete = new JButton();
			jButton_delete.setText("\u5220\u9664");
			jButton_delete.setBounds(153, 144, 86, 25);
			jButton_delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton_deleteActionPerformed(evt);
				}
			});
		}
		return jButton_delete;
	}

	private void jButton_deleteActionPerformed(ActionEvent evt) {
		new DeleteTokensFrame(this).setVisible(true);

	}

	private JButton getJButton_clearAdd() {
		if (jButton_clearAdd == null) {
			jButton_clearAdd = new JButton();
			jButton_clearAdd.setText("\u6e05\u9664");
			jButton_clearAdd.setBounds(153, 48, 86, 24);
			jButton_clearAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton_clearAddActionPerformed(evt);
				}
			});
		}
		return jButton_clearAdd;
	}

	private void jButton_clearAddActionPerformed(ActionEvent evt) {
		// System.out.println("jButton_clearAdd.actionPerformed, event="+evt);

		jTextField_insertdevice.setText("");
		jTextField_insertProductType.setText("");
		jTextField_insertVoltage.setText("");
		//公司
		jTextField_insertCompany.setText("");
		jTextField_insertCurrent.setText("");
		jTextField_insertPower.setText("");
	}

	private JLabel getJLabel7() {
		if (jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("\u989d\u5b9a\u7535\u6d41:");
			jLabel7.setBounds(17, 185, 64, 17);
		}
		return jLabel7;
	}

	private JComboBox getJComboBox_chooseEdingCurrent() {
		if (jComboBox_chooseCurrent == null) {

			jComboBox_chooseCurrent = new JComboBox();
			ArrayList<String> currents = LabelsUtil.readFile("currents.txt");
			jComboBox_chooseCurrent.addItem("");
			for (String current : currents) {
				jComboBox_chooseCurrent.addItem(current);
				System.out.println(current);
			}
			jComboBox_chooseCurrent.setBounds(80, 181, 150, 24);
		}
		return jComboBox_chooseCurrent;
	}

	private JTextField getJTextField_insertCurrent() {
		if (jTextField_insertCurrent == null) {
			jTextField_insertCurrent = new JTextField();
			jTextField_insertCurrent.setBounds(5, 164, 125, 24);
		}
		return jTextField_insertCurrent;
	}

	private JCheckBox getJCheckBox_debug() {
		if (jCheckBox_debug == null) {
			jCheckBox_debug = new JCheckBox();
			jCheckBox_debug.setText("\u663e\u793a16\u8fdb\u5236AID");
			jCheckBox_debug.setBounds(375, 275, 115, 21);
			jCheckBox_debug.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					JCheckBox box = (JCheckBox) arg0.getItemSelectable();// 返回事件的产生程序
					if (box.isSelected()) {
						showHexFlag = true;
						System.out.println("true");
					} else {
						showHexFlag = false;
						System.out.println("false");
					}

				}
			});
		}
		return jCheckBox_debug;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Hex:");
			jLabel2.setBounds(262, 35, 34, 17);
		}
		return jLabel2;
	}

	private JCheckBox getJCheckBox_radom() {
		if (jCheckBox_radom == null) {
			jCheckBox_radom = new JCheckBox();
			jCheckBox_radom.setText("\u5bc6\u7801\u624b\u52a8\u8f93\u5165");
			jCheckBox_radom.setBounds(304, 71, 121, 25);
			jCheckBox_radom.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					JCheckBox box = (JCheckBox) e.getItemSelectable();// 返回事件的产生程序
					if (box.isSelected()) {
						isNeedWrite = true;
						jTextField_writePasswd.setEnabled(true);
					} else {
						isNeedWrite = false;
						jTextField_writePasswd.setEnabled(false);
					}
				}
			});
		}
		return jCheckBox_radom;
	}

	private JTextField getJTextField_devicesTypeInsert() {
		if (jTextField_devicesTypeInsert == null) {
			jTextField_devicesTypeInsert = new JTextField();
			jTextField_devicesTypeInsert.setText("FFFF");
			jTextField_devicesTypeInsert.setBounds(80, 382, 150, 24);
		}
		return jTextField_devicesTypeInsert;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("\u6807\u8bc6\u7801\uff1a");
			jLabel3.setBounds(17, 385, 58, 17);
		}
		return jLabel3;
	}

	private String getNewDeviceType() {
		String str1 = null;
		int index = jComboBox_chooseDevice_9.getSelectedIndex();
		switch (index) {
		case 1:
			str1 = "01";
			break;
		case 2:
			str1 = "02";
			break;
		case 3:
			str1 = "11";
			break;

		default:
			break;
		}
		return str1;
	}

}
