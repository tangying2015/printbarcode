package com.eastsoft.ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.apache.commons.lang.StringUtils;

import com.eastsoft.barcode.QRCode;
import com.eastsoft.print.MyPaperFormat;
import com.eastsoft.print.MyPrint;
import com.eastsoft.ui.MainUI.printInfo;
import com.eastsoft.util.LabelsUtil;
import com.eastsoft.util.PrintFinal;

public class PowerLineAdapterPanel extends JPanel{
	
	private JLabel jLabel_deviceName;		//设备名
	private JComboBox jComboBox_deviceName;
	
	private JLabel jLabel_deviceModel;		//设备型号
	private JComboBox jComboBox_deviceModel;
	
	private JLabel jLabel_deviceVersion;	//版本
	private JComboBox jComboBox_deviceVersion;
	
	private JLabel jLabel_DeviceID;			// 设备地址
	private JTextField jTextField_DeviceID;
	
	private JLabel jLabel_DeviceSN;			// S/N码
	private JTextField jTextField_DeviceSN;
	
	private JLabel jLabel_Power;			// 电源
	private JComboBox jComboBox_Power;
	
	private JLabel jLabel_OfficialWebsite;			// 官方网址
	private JTextField jTextField_OfficialWebsite;
	
	private JLabel jLabel_ManageIP;			// 管理IP
	private JTextField jTextField_ManageIP;
	
	private JLabel jLabel_PrintNum;			// 打印标签数量
	private JTextField jTextField_PrintNum;
	
	private JLabel jLabel_UserName;			// 用户名
	private JTextField jTextField_UserName;
	
	private JLabel jLabel_Password;			// 密码
	private JTextField jTextField_Password;

	private JButton jButton_repeatPrint_p;
	private JButton jButton_printPreview_p;
	private JCheckBox jCheckBox_Edit;	//启动编辑
	
	private String companyInit;
	private MainUI mainUi = null;
	private String str = null;
	private QRCode newQRCode;
	MyPrint myPrint;
	Head head;							//二维码每部分信息开头					
	
	public PowerLineAdapterPanel(){
			super();
			this.setBounds(10, 10, 300, 546);
			this.setLayout(null);
			this.setBackground(new java.awt.Color(236, 233, 216));
			this.setBorder(BorderFactory.createTitledBorder(null,
					"电力线适配器二维码项目", TitledBorder.LEADING,
					TitledBorder.DEFAULT_POSITION));
			
			ArrayList<String> list = LabelsUtil.readFile("companys.txt");
			companyInit = list.get(0);
			{	//选择设备
				jLabel_deviceName = new JLabel();
				jLabel_deviceName.setBounds(12, 30, 90, 18);
				jLabel_deviceName.setText("选择设备：");
				this.add(jLabel_deviceName);
				
				jComboBox_deviceName = new JComboBox();
				this.add(jComboBox_deviceName);
				jComboBox_deviceName.setBounds(120, 26, 180, 25);
				Map map = LabelsUtil.readFileForMap("PowerLineDevice.txt");
				Set set = map.keySet();
				Iterator t=set.iterator();
				jComboBox_deviceName.addItem("选择设备");
				while(t.hasNext()){
					Object k = t.next();
					jComboBox_deviceName.addItem(k);
				}
				jComboBox_deviceName
						.addItemListener(new ItemListener() {

							@Override
							public void itemStateChanged(ItemEvent evt) {
								jComboBox_new_chooseDeviceItemStateChanged(evt);

							}
						});
			}
			{	//用户名
				jLabel_UserName = new JLabel("用户名：");
				this.add(jLabel_UserName);
				jLabel_UserName.setBounds(320, 25, 60, 18);
				jLabel_UserName.setVisible(false);
				
				jTextField_UserName = new JTextField();
				this.add(jTextField_UserName);
				jTextField_UserName.setBounds(370, 25, 90, 25);
				jTextField_UserName.setText("root");
				jTextField_UserName.setVisible(false);
				
				//密码
				jLabel_Password = new JLabel("密码：");
				this.add(jLabel_Password);
				jLabel_Password.setBounds(320, 70, 60, 18);
				jLabel_Password.setVisible(false);
				
				jTextField_Password = new JTextField();
				this.add(jTextField_Password);
				jTextField_Password.setBounds(370, 70, 90, 25);
				jTextField_Password.setText("admin");
				jTextField_Password.setVisible(false);
			}
			{
				jLabel_deviceModel = new JLabel();
				this.add(jLabel_deviceModel);
				jLabel_deviceModel.setText("设备型号：");
				jLabel_deviceModel.setBounds(12, 70, 90, 18);

				jComboBox_deviceModel = new JComboBox();
				this.add(jComboBox_deviceModel);
				jComboBox_deviceModel.setBounds(120, 66, 180, 25);
				
				//String str[] = {"请选择","ES-A61500"};
				Map map = LabelsUtil.readFileForMap("deviceStyle.txt");
				Set set = map.keySet();
				Iterator t=set.iterator();
				jComboBox_deviceModel.addItem("");
				while(t.hasNext()){
					Object k = t.next();
					jComboBox_deviceModel.addItem(k);
				}
				jComboBox_deviceModel
				.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent evt) {
						jComboBox_chooseDeviceStyleChanged(evt);

					}
				});
			}
			{	//版本	
				jLabel_deviceVersion = new JLabel();
				this.add(jLabel_deviceVersion);
				jLabel_deviceVersion.setText("	版本：");
				jLabel_deviceVersion.setBounds(12, 110, 90, 18);

				jComboBox_deviceVersion = new JComboBox();
				this.add(jComboBox_deviceVersion);
				jComboBox_deviceVersion.setBounds(120, 106, 180, 25);
				ArrayList<String> version = LabelsUtil.readFile("deviceVersion.txt");
				jComboBox_deviceVersion.addItem("");
				for(String t : version){
					jComboBox_deviceVersion.addItem(t);
				}
			}
			{	//MAC地址
				jLabel_DeviceID = new JLabel();
				this.add(jLabel_DeviceID);
				jLabel_DeviceID.setText("MAC地址：");
				jLabel_DeviceID.setBounds(12, 150, 90, 18);
				
				String deviceID = LabelsUtil
						.readLastLine("mac.txt");
				jTextField_DeviceID = new JTextField();
				this.add(jTextField_DeviceID);
				jTextField_DeviceID.setBounds(120, 146, 180, 25);
				jTextField_DeviceID.setText(deviceID);
				jTextField_DeviceID.setEditable(false);
			}
			{	//S/N码
				jLabel_DeviceSN = new JLabel();
				this.add(jLabel_DeviceSN);
				jLabel_DeviceSN.setText("S/N：");
				jLabel_DeviceSN.setBounds(12, 190, 90, 18);
				
				jTextField_DeviceSN = new JTextField();
				this.add(jTextField_DeviceSN);
				jTextField_DeviceSN.setBounds(120, 186, 180, 25);
				jTextField_DeviceSN.setEditable(false);
			}
			{	//电源	
				jLabel_Power = new JLabel();
				this.add(jLabel_Power);
				jLabel_Power.setText("电源：");
				jLabel_Power.setBounds(12, 230, 90, 18);

				jComboBox_Power = new JComboBox();
				this.add(jComboBox_Power);
				jComboBox_Power.setBounds(120, 226, 180, 25);
				
				ArrayList<String> voltages = LabelsUtil.readFile("voltages.txt");
				jComboBox_Power.addItem("");
				for(String t : voltages){
					jComboBox_Power.addItem(t);
				}
			}
			
			{	//官方网址
				jLabel_OfficialWebsite = new JLabel();
				this.add(jLabel_OfficialWebsite);
				jLabel_OfficialWebsite.setText("官方网址：");
				jLabel_OfficialWebsite.setBounds(12, 310, 90, 18);
				
				jTextField_OfficialWebsite = new JTextField();
				this.add(jTextField_OfficialWebsite);
				jTextField_OfficialWebsite.setBounds(120, 306, 180, 25);
				ArrayList<String> officalurl = LabelsUtil.readFile("officalWebSite.txt");
				if(officalurl==null){
					jTextField_OfficialWebsite.setText("www.eastsoft.com.cn");
				}else{
					jTextField_OfficialWebsite.setText(officalurl.get(0));
				}
				
			}
			{	//管理IP
				jLabel_ManageIP = new JLabel();
				this.add(jLabel_ManageIP);
				jLabel_ManageIP.setText("管理IP：");
				jLabel_ManageIP.setBounds(12, 270, 90, 18);
				jLabel_ManageIP.setHorizontalTextPosition(JLabel.RIGHT);
				
				jTextField_ManageIP = new JTextField();
				this.add(jTextField_ManageIP);
				jTextField_ManageIP.setBounds(120, 266, 180, 25);
				jTextField_ManageIP.setEditable(false);
				/*ArrayList<String> manageip = LabelsUtil.readFile("manageIP.txt");
				if(manageip==null){
					jTextField_ManageIP.setText("192.168.1.1");
				}else{
					jTextField_ManageIP.setText(manageip.get(0));
				}*/
			}
			{	//打印标签数量
				jLabel_PrintNum = new JLabel();
				this.add(jLabel_PrintNum);
				jLabel_PrintNum.setText("打印标签数量：");
				jLabel_PrintNum.setBounds(12, 350, 90, 18);
				
				jTextField_PrintNum = new JTextField();
				this.add(jTextField_PrintNum);
				jTextField_PrintNum.setBounds(120, 346, 180, 25);
				jTextField_PrintNum.setText("1");
			}
			{
				jCheckBox_Edit = new JCheckBox("编辑：MAC、S/N、管理IP");
				this.add(jCheckBox_Edit);
				jCheckBox_Edit.setBounds(120, 386, 180, 25);
				//jTextField_ManageIP
				jCheckBox_Edit.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent evt) {
						JCheckBox box = (JCheckBox) evt.getItemSelectable();
						if (box.isSelected()) {
							jTextField_ManageIP.setEditable(true);
							jTextField_DeviceID.setEditable(true);
							jTextField_DeviceSN.setEditable(true);
						} else {
							jTextField_ManageIP.setEditable(false);
							jTextField_DeviceID.setEditable(false);
							jTextField_DeviceSN.setEditable(false);
						}
					}
				});
			}
			{
				jButton_printPreview_p = new JButton();
				this.add(jButton_printPreview_p);
				jButton_printPreview_p.setText("打印预览");
				jButton_printPreview_p.setBounds(40, 460, 100, 50);
				jButton_printPreview_p
						.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent evt) {
								jButton_new_printPreviewformed(evt);

							}
						});
			}
			{
				jButton_repeatPrint_p = new JButton();
				this.add(jButton_repeatPrint_p);
				jButton_repeatPrint_p.setBounds(160, 460, 100, 50);
				jButton_repeatPrint_p.setText("打印");
				jButton_repeatPrint_p
						.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent evt) {
								jButton_new_printBinaryPerformed(evt);

							}
						});
			}
	}
	/**
	 * jComboBox_chooseDeviceStyleChanged当改变设备型号时重新设置SN码
	 * @param evt
	 */
	private void jComboBox_chooseDeviceStyleChanged(ItemEvent evt) {
		Map mapStyle = LabelsUtil.readFileForMap("deviceStyle.txt");
		String styleCode = (String) mapStyle.get(jComboBox_deviceModel.getSelectedItem());
		String mac = jTextField_DeviceID.getText();
		jTextField_DeviceSN.setText(styleCode+StringFilter(mac));
		
	}
	/**
	 * 当选择设备后做一些初始化
	 * @param evt
	 */
	private void jComboBox_new_chooseDeviceItemStateChanged(ItemEvent evt) {
		if(mainUi==null){
			mainUi = MainUI.getInstance(1);
		}
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			mainUi.appendTextareaText(mainUi.jTextArea_status,
					'\n' + "选择设备：" + (String) evt.getItem());
			String item = (String)jComboBox_deviceName.getSelectedItem();
			Map manageip = LabelsUtil.readFileForMap("manageIP.txt");
			switch(item){
				case "电力线适配器":
					jLabel_UserName.setVisible(false);
					jTextField_UserName.setVisible(false);
					jLabel_Password.setVisible(false);
					jTextField_Password.setVisible(false);
					
					Map map = LabelsUtil.readFileForMap("PowerLineDevice.txt");
					Map mapStyle = LabelsUtil.readFileForMap("deviceStyle.txt");
					String style = (String) map.get(jComboBox_deviceName.getSelectedItem());
					String styleCode = (String) mapStyle.get(style);
					String manageiIP = (String)manageip.get(style);
					
					jComboBox_deviceModel.setSelectedItem(style);
					jComboBox_deviceVersion.setSelectedIndex(0);
					jComboBox_deviceVersion.setEnabled(false);
					jComboBox_Power.setSelectedIndex(4);
					
					String mac = jTextField_DeviceID.getText();
					jTextField_DeviceSN.setText(styleCode+StringFilter(mac));
					jTextField_ManageIP.setText(manageiIP);
					
					head = new Head();	//设置head
					head.ip = "IP:";
					head.mac = "MAC:";
					head.sn = "S/N:";
					break;
				case "电力线无线路由器":
					jLabel_UserName.setVisible(true);
					jTextField_UserName.setVisible(true);
					jLabel_Password.setVisible(true);
					jTextField_Password.setVisible(true);
					Map map2 = LabelsUtil.readFileForMap("PowerLineDevice.txt");
					Map mapStyle2 = LabelsUtil.readFileForMap("deviceStyle.txt");
					String style2 = (String) map2.get(jComboBox_deviceName.getSelectedItem());
					String styleCode2 = (String) mapStyle2.get(style2);
					String manageiIP2 = (String)manageip.get(style2);
					
					jComboBox_deviceModel.setSelectedItem(style2);
					jComboBox_deviceVersion.setSelectedIndex(0);
					jComboBox_deviceVersion.setEnabled(false);
					jComboBox_Power.setSelectedIndex(5);
					
					String mac2 = jTextField_DeviceID.getText();
					jTextField_DeviceSN.setText(styleCode2+StringFilter(mac2));
					jTextField_ManageIP.setText(manageiIP2);
					
					head = new Head();	//设置head
					head.ip = "IP:";
					head.mac = "PLC MAC:";
					head.sn = "S/N:";
					break;
				default:
					jLabel_UserName.setVisible(false);
					jTextField_UserName.setVisible(false);
					jLabel_Password.setVisible(false);
					jTextField_Password.setVisible(false);
					jComboBox_deviceModel.setSelectedIndex(0);
					jComboBox_deviceVersion.setEnabled(true);
					jComboBox_deviceVersion.setSelectedIndex(0);
					jComboBox_Power.setSelectedIndex(0);
					break;
			}
		}
	}
	private void jButton_new_printBinaryPerformed(ActionEvent evt) {
		if(mainUi==null){
			mainUi = MainUI.getInstance(1);
		}
		if(jComboBox_deviceName.getSelectedIndex()>0){
			
			String deviceID = toFormedMAC(StringFilter(getDeviceID()));
			if(!chechMAC(deviceID)){
				JOptionPane.showMessageDialog(getParent(), "MAC地址格式错误！",
						 "错误",JOptionPane.WARNING_MESSAGE);
				return ;
			}
			if(StringUtils.isEmpty(jTextField_PrintNum.getText())){
				JOptionPane.showMessageDialog(getParent(), "请输入打印数量！",
						 "错误",JOptionPane.WARNING_MESSAGE);
				return ;
			}
			String deviceSN = getDeviceSN().substring(0,6)+StringFilter(deviceID);
			jTextField_DeviceSN.setText(deviceSN);
			printNewBinaryPicture();
		}else{
			JOptionPane.showMessageDialog(getParent(), "请选择设备！",
					 "错误",JOptionPane.WARNING_MESSAGE);
			return ;
		}
	}
	
	private void jButton_new_printPreviewformed(ActionEvent evt) {
		
		if(mainUi==null){
			mainUi=MainUI.getInstance(1);
		}
		if(jComboBox_deviceName.getSelectedIndex()>0){
			String deviceID = getDeviceID();
			
			deviceID = toFormedMAC(StringFilter(getDeviceID()));
			if(!chechMAC(deviceID)){
				JOptionPane.showMessageDialog(getParent(), "MAC地址格式错误！",
						 "错误",JOptionPane.WARNING_MESSAGE);
				return ;
			}
			jTextField_DeviceID.setText(deviceID);
			

			String deviceSN = getDeviceSN().substring(0,6)+StringFilter(deviceID);
			jTextField_DeviceSN.setText(deviceSN);
			String manageIP = getManageIP();
			productPowerLineQRCode(head,deviceID,deviceSN,manageIP);
			jButton_new_printPreviewActionPerformed(evt);
		}
		else{
			//mainUi.appendTextareaText(mainUi.jTextArea_status,"\n请选择设备");
			JOptionPane.showMessageDialog(getParent(), "请选择设备！",
					 "错误",JOptionPane.WARNING_MESSAGE);
			return ;
		}
	}
	
	public void productPowerLineQRCode(Head head,String deviceID,String deviceSN,String manageIP) {
		
		newQRCode = new QRCode();
		
		//电力线二维码内容：MAC,S/N,IP
		str = head.ip+manageIP + "\n" + head.mac +deviceID + "\n" + head.sn + deviceSN;
		
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
		
		mainUi.jLabel_binaryPic.setIcon(new ImageIcon(barCodePic));
		mainUi.appendTextareaText(mainUi.jTextArea_status, "\n二维码已生成: " + str);
	}
	
	private void jButton_new_printPreviewActionPerformed(ActionEvent evt) {
		String deviceName = getDeviceName();
		String deviceType = getDeviceModel();
		String deviceID = getDeviceID();		//MAC
		String manageIP = getManageIP();
		String deviceSN = getDeviceSN();
		//String deviceVresion = getDeviceVersion();
		String power = getPower();
		String officialWebsite = getOfficialWebsite();
		int index = jComboBox_deviceName.getSelectedIndex();
		
		printInfo printinfo = mainUi.new printInfo();
		
		printinfo.setdeviceName(deviceName);
		printinfo.setdeviceType(deviceType);
		printinfo.setdeviceID(deviceID);
		printinfo.setManageIP(manageIP);
		printinfo.setDeviceSN(deviceSN);
		//printinfo.setDeviceVresion(deviceVresion);
		printinfo.setPower(power);
		printinfo.setOfficialWebsite(officialWebsite);
		printinfo.setPowerLineIndex(index);
		printinfo.setCompany(companyInit);
		printinfo.setUserName(jTextField_UserName.getText());
		printinfo.setPasswd(jTextField_Password.getText());
		
		
		(new PrintPowerLinePreviewDialog(mainUi, mainUi, "打印预览", true,
				new MyPrint(printinfo))).setVisible(true);
	}
	
	// 执行打印
	public void printNewBinaryPicture() {
			Runnable runnable = new Runnable() {
	            @Override
	            public void run() {
	    			int number = Integer.parseInt(getBinaryPrintNum());
	    			
	    			int index = jComboBox_deviceName.getSelectedIndex();
	    			String deviceName = getDeviceName();
	    			String deviceType = getDeviceModel();
	    			String deviceID = getDeviceID();		//MAC
	    			String manageIP = getManageIP();
	    			String deviceSN = getDeviceSN();
	    			//String deviceVresion = getDeviceVersion();
	    			String power = getPower();
	    			String officialWebsite = getOfficialWebsite();
	    			Long mac = Long.valueOf(StringFilter(deviceID), 16);
	    			printInfo printinfo = mainUi.new printInfo();
	    			printinfo.setUserName(jTextField_UserName.getText());
	    			printinfo.setPasswd(jTextField_Password.getText());
	    			for (int i = 0; i < number; i++) {
	    				Book book = new Book();
	    				PageFormat pf = new MyPaperFormat(mainUi);
	    				
	    				//生成二维码
	    				productPowerLineQRCode(head,deviceID,deviceSN,manageIP);
	    				
	    				printinfo.setdeviceID(deviceID);
	    				printinfo.setManageIP(manageIP);
	    				printinfo.setDeviceSN(deviceSN);
	    				
	    				printinfo.setdeviceName(deviceName);
	    				printinfo.setdeviceType(deviceType);
	    				//printinfo.setDeviceVresion(deviceVresion);
	    				printinfo.setPower(power);
	    				printinfo.setOfficialWebsite(officialWebsite);
	    				printinfo.setCompany(companyInit);
	    				printinfo.setPowerLineIndex(index);
	    				
	    				myPrint = new MyPrint(printinfo);
	    				book.append(myPrint, pf);
	    				PrinterJob job = PrinterJob.getPrinterJob();
	    				job.setPageable(book);
	    				try {
	    					if (true) {
	    						job.print();
	    						mac++;
	    						deviceID = toFormedMAC(Long.toHexString(mac));	//长整型数转换成标准格式MAC地址
	    						mainUi.appendTextareaText(mainUi.jTextArea_status, "\n执行打印");
	    						jTextField_DeviceID.setText(deviceID);
	
	    						deviceSN = deviceSN.substring(0, 6)+macToString(mac);
	    						jTextField_DeviceSN.setText(deviceSN);
	    						LabelsUtil.appendString("mac.txt", deviceID);
	    					}
	    				} catch (Exception e) {
	    					e.printStackTrace();
	    				}
	    				
	    				//每隔1.5秒发送一次打印请求？
	    				try {
	    		        Thread.sleep(1600);
	    				} catch (InterruptedException e) {
	    				        e.printStackTrace();
	    				}
	    			}
	            }
	        };
	        new Thread(runnable).start();
		}
		//从预览中点击打印按钮时执行此函数打印
		public void printBinaryPicture() {
	
			int formatIndex = jComboBox_deviceName.getSelectedIndex();
			int number = Integer.parseInt(getBinaryPrintNum());
			
			int index = jComboBox_deviceName.getSelectedIndex();
			String deviceName = getDeviceName();
			String deviceType = getDeviceModel();
			String deviceID = getDeviceID();		//MAC
			String manageIP = getManageIP();
			String deviceSN = getDeviceSN();
			//String deviceVresion = getDeviceVersion();
			String power = getPower();
			String officialWebsite = getOfficialWebsite();

			Book book = new Book();
			PageFormat pf = new MyPaperFormat(mainUi);
			
			//生成二维码
			productPowerLineQRCode(head,deviceID,deviceSN,manageIP);

			printInfo printinfo = mainUi.new printInfo();
			
			printinfo.setdeviceID(deviceID);
			printinfo.setManageIP(manageIP);
			printinfo.setDeviceSN(deviceSN);
			
			printinfo.setdeviceName(deviceName);
			printinfo.setdeviceType(deviceType);
			//printinfo.setDeviceVresion(deviceVresion);
			printinfo.setPower(power);
			printinfo.setOfficialWebsite(officialWebsite);
			printinfo.setCompany(companyInit);
			printinfo.setPowerLineIndex(index);
			
			myPrint = new MyPrint(printinfo);
			book.append(myPrint, pf);
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPageable(book);
			try {
				if (true) {
					job.print();
					mainUi.appendTextareaText(mainUi.jTextArea_status, "\n执行打印");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		public String StringFilter(String str) throws  PatternSyntaxException   {	//清除MAC地址的':'以使能和整数间转换
		  String regEx="[:]";
		  Pattern p = Pattern.compile(regEx);
		  Matcher m = p.matcher(str);
		  return   m.replaceAll("").trim();
		}
		public String macToString(Long mac){
			String deviceID = Long.toHexString(mac);
			if(deviceID.length()<12){
				String tem = "";
				for(int i=0;i<12-deviceID.length();i++){
					tem +="0";
				}
				deviceID = tem+deviceID;
			}
			
			return deviceID.toUpperCase();
		}
		public String dealContinuePrint(String deviceID){
			if(deviceID.length()<12){
				String tem = "";
				for(int i=0;i<12-deviceID.length();i++){
					tem +="0";
				}
				deviceID = tem+deviceID;
			}
			return deviceID;
		}
		public String toFormedMAC(String deviceID){
			if(deviceID.length()<12){
				String tem = "";
				for(int i=0;i<12-deviceID.length();i++){
					tem +="0";
				}
				deviceID = tem+deviceID;
			}
			StringBuffer sb = new StringBuffer(deviceID);
			for(int i=0;i<5;i++){
				sb.insert(2*(i+1)+i,":");
			}
			return sb.toString().toUpperCase();
		}
		
		public boolean chechMAC(String mac){
			String regex1 = "^([0-9a-fA-F]{2})(([/\\s:-][0-9a-fA-F]{2}){5})$";
			String regex2 = "^([0-9a-fA-F]{2})(([0-9a-fA-F]{2}){5})$";
			String regex3 = "^([0-9a-fA-F]{2})(([/\\s--][0-9a-fA-F]{2}){5})$";
			if(!mac.matches(regex1)&&!mac.matches(regex2)&&!mac.matches(regex3)){
				/*JOptionPane.showMessageDialog(getParent(), "请选择设备！",
						 "错误",JOptionPane.WARNING_MESSAGE);*/
				return false;
			}
			return true;
		}
		/**
		 *设置打印样式
		 * @param width
		 * @param height
		 * @return
		 */
		private Paper setPapeSize(double width, double height) {
			Paper p = new Paper();
			p.setSize(width, height);// 纸张大小
			p.setImageableArea(0, 0, width, height);
			return p;
		}
		public Paper getPageFormFormat() {
			Paper p = new Paper();
			switch(this.getjComboBox_deviceNameSelectedIndex()){
			case 1:
				p = setPapeSize(4 * PrintFinal.INCH / 2.54,
						2.9 * PrintFinal.INCH / 2.54);
				break;
			default:
				break;
		}
			return p;
		}
		//打印数量
		public String getBinaryPrintNum() {
			return jTextField_PrintNum.getText();
		}
		
		public int getjComboBox_deviceNameSelectedIndex()	//获取设备名选择索引
		{
			return jComboBox_deviceName.getSelectedIndex();
		}
		public String getDeviceName(){
			return jComboBox_deviceName.getSelectedItem().toString();
		}
		public String getDeviceModel(){		//获取设备型号
			return jComboBox_deviceModel.getSelectedItem().toString();
		}
		public String getDeviceVersion(){	//获取版本号
			return jComboBox_deviceVersion.getSelectedItem().toString();
		}
		public String getDeviceID(){		//获取设备地址
			return jTextField_DeviceID.getText();
		}
		public String getDeviceSN(){		//获取S/N码
			return jTextField_DeviceSN.getText();
		}
		public String getPower(){			//获取电源信息
			return jComboBox_Power.getSelectedItem().toString();
		}
		public String getOfficialWebsite(){		//获取官方网址
			return jTextField_OfficialWebsite.getText();
		}
		public String getManageIP(){			//获取管理IP
			return jTextField_ManageIP.getText();
		}
}

class Head{	//二维码信息开头，如 “IP:”
	public String ip;
	public String mac;
	public String sn;
}