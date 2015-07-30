package com.eastsoft.ui;
/**
 * 编码修改为UTF-8
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.eastsoft.barcode.QRCode;
import com.eastsoft.print.MyPaperFormat;
import com.eastsoft.print.MyPrint;
import com.eastsoft.sqlitedb.SqliteDb;
import com.eastsoft.ui.MainUI.printInfo;
import com.eastsoft.ui.MainUI.recordInfo;
import com.eastsoft.util.PrintFinal;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ContinuousPrintAidsDialog extends javax.swing.JDialog {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton jButton_repeatPrint;
	private JTextField jTextField_AidEnd;
	private JTextField jTextField_AidStart;
	private MainUI mainGui;
	
	private JTextField jTextField_gid_base;
	private JTextField jTextField_gateway_label_nums;
	private JButton jButton_gid_repeat_print;
	
	private SqliteDb db ;
	private JLabel jLabel_gid_base;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JPanel jPanel1;

	Paper p ;
	PageFormat pf;
	public ContinuousPrintAidsDialog(JFrame frame) {
		super(frame);
		this.mainGui  = (MainUI)frame;
		db = mainGui.getDB();
		initGUI();
		
		/*p= new Paper();
		p.setSize(6 * PrintFinal.INCH / 2.54,
				4 * PrintFinal.INCH / 2.54);// 纸张大小
		p.setImageableArea(0, 0, 6 * PrintFinal.INCH / 2.54,
				4 * PrintFinal.INCH / 2.54);
		
		pf = new PageFormat();*/
		pf = new MyPaperFormat(mainGui);
	
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("\u8d77\u59cbAID:");
					jLabel1.setBounds(18, 26, 63, 18);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("\u6700\u7ec8AID:");
					jLabel2.setBounds(18, 63, 63, 18);
				}
				{
					jTextField_AidStart = new JTextField();
					getContentPane().add(jTextField_AidStart);
					jTextField_AidStart.setBounds(79, 23, 180, 25);
				}
				{
					jTextField_AidEnd = new JTextField();
					getContentPane().add(jTextField_AidEnd);
					jTextField_AidEnd.setBounds(79, 60, 180, 25);
				}
				{
					jButton_repeatPrint = new JButton();
					getContentPane().add(jButton_repeatPrint);
					jButton_repeatPrint.setText("连续打印");
					jButton_repeatPrint.setBounds(290, 23, 107, 62);
					jButton_repeatPrint.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButton_ContinuousPrintActionPerformed(evt);
						}
					});
				}
				{
					jPanel1 = new JPanel();
					getContentPane().add(jPanel1);
					jPanel1.setBounds(12, 106, 404, 115);
					jPanel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jPanel1.setLayout(null);
					{
						jLabel_gid_base = new JLabel();
						jPanel1.add(jLabel_gid_base);
						jLabel_gid_base.setText("\u7f51\u5173Gid\u57fa\u6570\uff1a");
						jLabel_gid_base.setBounds(6, 28, 88, 17);
					}
					{
						jTextField_gid_base = new JTextField();
						jPanel1.add(jTextField_gid_base);
						jTextField_gid_base.setBounds(112, 25, 134, 25);
					}
					{
						jLabel3 = new JLabel();
						jPanel1.add(jLabel3);
						jLabel3.setText("(\u5341\u8fdb\u5236)");
						jLabel3.setBounds(251, 28, 72, 17);
					}
					{
						jLabel4 = new JLabel();
						jPanel1.add(jLabel4);
						jLabel4.setText("\u7f51\u5173\u6807\u7b7e\u4e2a\u6570\uff1a");
						jLabel4.setBounds(6, 72, 88, 17);
					}
					{
						jTextField_gateway_label_nums = new JTextField();
						jPanel1.add(jTextField_gateway_label_nums);
						jTextField_gateway_label_nums.setBounds(112, 69, 134, 25);
					}
					{
						jButton_gid_repeat_print = new JButton();
						jPanel1.add(jButton_gid_repeat_print);
						jButton_gid_repeat_print.setText("连续打印");	//网关
						jButton_gid_repeat_print.setBounds(274, 51, 112, 44);
						jButton_gid_repeat_print.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButton_gid_repeat_printActionPerformed(evt);
							}
						});
					}
				}
			}
			this.setSize(435, 271);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton_ContinuousPrintActionPerformed(ActionEvent evt) {
		int formatIndex = MainUI.GetDeviceFormatIndex();
		if(formatIndex == 0){
			formatIndex = mainGui.jComboBox_choosePrintFormat.getSelectedIndex();
		}
		if(formatIndex == 0){
			mainGui.appendTextareaText(mainGui.jTextArea_status, "\n请选择打印样式或设备名称");
		}else{
			String device = mainGui.getDevice();
			String product = mainGui.getProduct();
			String voltage = mainGui.getVoltage();
			String current = mainGui.getCurrent();
			String power = mainGui.getPower();
			String frequency  = mainGui.getFrequency();
			String tester = mainGui.getTester();
			boolean showHexFlg = mainGui.getShowHexAidFlag();
			//mainGui.ProductPasswd();
			String passwd = mainGui.getPasswd();
			
			printInfo printinfo = mainGui.new printInfo();
			printinfo.setDevice(device);
			printinfo.setProduct(product);
			printinfo.setVoltage(voltage);
			printinfo.setCurrent(current);
			printinfo.setPower(power);
			printinfo.setFrequency(frequency);
			printinfo.setTester(tester);
			printinfo.setPasswd(passwd);
			printinfo.setShowHexAidFlag(showHexFlg);
			printinfo.setFormatIndex(formatIndex);
			
			ContinuousPrint(printinfo, pf);
		}
	}
	
	private void ContinuousPrint(printInfo printinfo,PageFormat pf){
		String aidStart = jTextField_AidStart.getText();
		String aidEnd = jTextField_AidEnd.getText();
		if(!aidStart.equals("")&&!aidEnd.equals("")){
			
			long startAid = Long.parseLong(aidStart);
			long endAid = Long.parseLong(aidEnd);
			
			String passwd = null;
			while(startAid <= endAid){
				printinfo.setAid(String.valueOf(startAid));
				try {
					passwd = getPasswdFromDB(String.valueOf(startAid));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(passwd != null ){
					printinfo.setPasswd(passwd);
					productQRCodeHO(String.valueOf(startAid),passwd);
					printBinaryPicture(pf,printinfo);
				}else{
					mainGui.appendTextareaText(mainGui.jTextArea_status,"\n该设备的AID："+startAid+" 数据库中没有对应密码，无法打印");
				}
				startAid++;
			}
		}
		
	}
	
	private String getPasswdFromDB(String aid) throws SQLException {
		
		String passwd  = null;
		if(db.isAidExist(aid)){
			passwd = db.getPasswdFromAid(aid);
		}
		return passwd;
	}

	QRCode mQRCode;
	private String str;
	public void productQRCode(String aid,String passwd){
			if(aid==null||"".equals(aid)){
				mainGui.appendTextareaText(mainGui.jTextArea_status,"\n二维码已生成: "+str);
				return ;
			}
			mQRCode = new QRCode();
			mainGui.jTextField_readAIDresult.setText(aid);
			mainGui.jTextField_writePasswd.setText(passwd);
			str = "A"+aid+"P"+passwd;
			File filePath = new File("test_QR_CODE.png");
			String path = filePath.getAbsolutePath();
			int width,height;
			width =height = 100;
			mQRCode.encode(str, path, width, height);
			mQRCode.decode(filePath);

			Image barCodePic = null;
			try {
				barCodePic = ImageIO.read(filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			mainGui.jLabel_binaryPic.setIcon(new ImageIcon(barCodePic));
			
			mainGui.appendTextareaText(mainGui.jTextArea_status,"\n二维码已生成: "+str);
	}
	
	//昊想智能
	public void productQRCodeHO(String aid,String passwd){
		mQRCode = new QRCode();
		mainGui.jTextField_readAIDresult.setText(aid);
		mainGui.jTextField_writePasswd.setText(passwd);
		str = aid;
		File filePath = new File("test_QR_CODE.png");
		String path = filePath.getAbsolutePath();
		int width,height;
		width =height = 100;
		mQRCode.encode(str, path, width, height);
		mQRCode.decode(filePath);

		Image barCodePic = null;
		try {
			barCodePic = ImageIO.read(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mainGui.jLabel_binaryPic.setIcon(new ImageIcon(barCodePic));
		
		mainGui.appendTextareaText(mainGui.jTextArea_status,"\n二维码已生成: "+str);
}
	
	public void printBinaryPicture(PageFormat pf,printInfo printinfo) {
			
			recordInfo recordinfor  = mainGui.new recordInfo();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
			//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			recordinfor.setDate(df.format(new Date()));
			recordinfor.setProductSerialNO(printinfo.getTester());
			recordinfor.setDevice(printinfo.getDevice());
			recordinfor.setProduct(printinfo.getProduct());
			recordinfor.setAid(printinfo.getAid());
			recordinfor.setPasswd(printinfo.getPasswd());
			
			Book book = new Book();
			MyPrint myPrint = new MyPrint(printinfo);
			
			book.append(myPrint, pf);

			// 获取打印服务对象
			PrinterJob job = PrinterJob.getPrinterJob();
			// 设置打印类
			job.setPageable(book);
			//记录打印信息
			mainGui.savePrintInfoToExcel(recordinfor,mainGui.jComboBox_choosePrintFormat.getSelectedIndex());
			try {
				job.print();
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mainGui.appendTextareaText(mainGui.jTextArea_status, "\n打印完毕");
		
		}
	//昊想智能
	public void printBinaryPictureHO(PageFormat pf,printInfo printinfo) {
		
		recordInfo recordinfor  = mainGui.new recordInfo();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
		//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		recordinfor.setDate(df.format(new Date()));
		recordinfor.setProductSerialNO(printinfo.getTester());
		recordinfor.setDevice(printinfo.getDevice());
		recordinfor.setProduct(printinfo.getProduct());
		recordinfor.setAid(printinfo.getAid());
		recordinfor.setPasswd(printinfo.getPasswd());
		
		Book book = new Book();
		MyPrint myPrint = new MyPrint(printinfo);
		
		book.append(myPrint, pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);
		//记录打印信息
		mainGui.savePrintInfoToExcel(recordinfor,mainGui.jComboBox_choosePrintFormat.getSelectedIndex());
		try {
			job.print();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainGui.appendTextareaText(mainGui.jTextArea_status, "\n打印完毕");
	
	}
	
	private void jButton_gid_repeat_printActionPerformed(ActionEvent evt) {

		int formatIndex = MainUI.GetDeviceFormatIndex();
		if(formatIndex == 0){
			formatIndex = mainGui.jComboBox_choosePrintFormat.getSelectedIndex();
		}
		if(formatIndex == 0){
			mainGui.appendTextareaText(mainGui.jTextArea_status, "\n请选择打印样式或设备名称");
		}else{
			String device = mainGui.getDevice();
			String product = mainGui.getProduct();
			String voltage = mainGui.getVoltage();
			//add by wangrichao获取电流
			String current = mainGui.getCurrent();
			String power = mainGui.getPower();
			String company = mainGui.getCompany();
			
			String productSerialNO = mainGui.getTester();
			
			
			printInfo printinfo = mainGui.new printInfo();
			printinfo.setCurrent(current);
			printinfo.setDevice(device);
			printinfo.setProduct(product);
			printinfo.setVoltage(voltage);
			printinfo.setTester(productSerialNO);
			printinfo.setFormatIndex(formatIndex);
			printinfo.setCompany(mainGui.getCompany());
			
			//打印功率，连续打时 tbianbaolei 2015-1-16
			printinfo.setPower(power);
			System.out.println("power"+power);
			
			GatewayLabelContinuousPrint(printinfo, pf);
		}

	
		
	
	}

	private void GatewayLabelContinuousPrint(printInfo printinfo, PageFormat pf) {
		
		String gidbase = jTextField_gid_base.getText();
		String gidnums = jTextField_gateway_label_nums.getText();
		long num_print = 0;
		if(!gidbase.equals("")&&!gidnums.equals("")){
			
			long gid_base = Long.parseLong(gidbase);
			long gid_nums = Long.parseLong(gidnums);
			
			while(num_print < gid_nums){
				printinfo.setGid(""+gid_base++);
				printGatewayPicture(pf,printinfo);
				num_print++;
			}
		}
		
	
		
	}

	private void printGatewayPicture(PageFormat pf, printInfo printinfo) {
		Book book = new Book();
		MyPrint myPrint = new MyPrint(printinfo);
		
		book.append(myPrint, pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);
		//记录打印信息
		try {
			job.print();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainGui.appendTextareaText(mainGui.jTextArea_status, "\n打印完毕");
	}

}
