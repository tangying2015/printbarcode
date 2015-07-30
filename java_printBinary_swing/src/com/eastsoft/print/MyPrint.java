package com.eastsoft.print;
/**
 * 编码修改为UTF-8
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;

import sun.java2d.loops.DrawLine;

import com.eastsoft.ui.MainUI;
import com.eastsoft.ui.MainUI.printInfo;
import com.eastsoft.util.PrintFinal;
// 公司logo 设备名 、电压、电量等等之间的间距
public class MyPrint implements Printable {

	public static final int LINE_TO_PIC_MARGIN_S = 4;
	public static final int LINE_TO_PIC_MARGIN_H = 4;
	public static final int LINE_LENGTH = 9;
	public static final int FOUR_CORNERS_WIDTH = 70;
	public static final int FOUR_CORNERS_HEIGHT = 80;
	public static final int BAR_SHOW_WIDTH = 62;
	public static final int BAR_SHOW_HEIGHT = 62;

	static final int margin_LogoToName_1 = 23;
	static final int margin_NameToItem_1 = 22;
	static final int margin_ItemToItem_1 = 10;

	static final int margin_LogoToName_2 = 23;
	static final int margin_NameToItem_2 = 14;
	static final int margin_ItemToItem_2 = 9;

	static final int margin_LogoToName_3 = 21;
	static final int margin_NameToItem_3 = 13;
	static final int margin_ItemToItem_3 = 7;

	static final int margin_LogoToName_4 = 20;
	static final int margin_NameToItem_4 = 13;
	static final int margin_ItemToItem_4 = 10;

	static final int margin_LeftToItem_4 = 50;
	static final int margin_ItemToBarCode_4 = 75;
	static final int margin_BarCodeToRight_4 = 98;

	static final int margin_LogoToName_5 = 17;
	static final int margin_NameToItem_5 = 11;
	static final int margin_ItemToItem_5 = 9;

	static final int margin_LeftToItem_5 = 42;
	static final int margin_ItemToBarCode_5 = 86;
	static final int margin_BarCodeToRight_5 = 95;

	static final int margin_LogoToName_6 = 16;
	static final int margin_NameToItem_6 = 11;
	static final int margin_ItemToItem_6 = 9;

	static final int margin_LeftToItem_6 = 44;
	static final int margin_ItemToBarCode_6 = 84;
	static final int margin_BarCodeToRight_6 = 95;

	static final int margin_LogoToName_7 = 17;
	static final int margin_NameToItem_7 = 15;
	static final int margin_ItemToItem_7 = 10;

	static final int margin_LogoToName_8 = 18;
	static final int margin_NameToItem_8 = 14;
	static final int margin_ItemToItem_8 = 9;

	static final int margin_LogoToName_9 = 20;
	static final int margin_NameToItem_9 = 17;
	static final int margin_ItemToItem_9 = 9;

	static final int margin_LogoToName_10 = 14;
	static final int margin_NameToItem_10 = 11;
	static final int margin_ItemToItem_10 = 7;

	static final int margin_LogoToName_11 = 20;
	static final int margin_NameToItem_11 = 13;
	static final int margin_ItemToItem_11 = 10;
	static final int margin_LeftToItem_11 = 50;
	static final int margin_ItemToBarCode_11 = 80;
	static final int margin_BarCodeToRight_11 = 93;

	private static final int margin_LogoToName_12 = 12;
	private static final int margin_NameToItem_12 = 15;
	private static final int margin_ItemToItem_12 = 4;
	static final int margin_LogoToName_13 = 18;
	static final int margin_NameToItem_13 = 14;
	static final int margin_ItemToItem_13 = 10;
	static final int margin_LeftToItem_14 = 50;
	static final int margin_ItemToBarCode_14 = 80;
	static final int margin_LogoToName_14 = 8;
	static final int margin_NameToItem_14 = 10;
	static final int margin_ItemToItem_14 = 11;
	static final int margin_LogoToName_15 = 12;
	static final int margin_NameToItem_15 = 10;
	static final int margin_ItemToItem_15 = 8;
	static final int margin_LeftToItem_16 = 50;
	static final int margin_ItemToBarCode_16 = 80;
	static final int margin_LogoToName_16 = 8;
	static final int margin_NameToItem_16 = 10;
	static final int margin_ItemToItem_16 = 11;
	static final int margin_LogoToName_17 = 12;
	static final int margin_NameToItem_17 = 10;
	static final int margin_ItemToItem_17 = 8;
	static final int margin_LeftToItem_18 = 50;
	static final int margin_ItemToBarCode_18 = 80;
	static final int margin_LogoToName_18 = 8;
	static final int margin_NameToItem_18 = 10;
	static final int margin_ItemToItem_18 = 11;
	static final int margin_LogoToName_19 = 12;
	static final int margin_NameToItem_19 = 10;
	static final int margin_ItemToItem_19 = 8;
	static final int margin_LeftToItem_20 = 50;
	static final int margin_ItemToBarCode_20 = 80;
	static final int margin_LogoToName_20 = 8;
	static final int margin_NameToItem_20 = 10;
	static final int margin_ItemToItem_20 = 11;
	static final int margin_LogoToName_21 = 12;
	static final int margin_NameToItem_21 = 10;
	static final int margin_ItemToItem_21 = 8;
	static final int margin_LogoToName_22 = 23;
	static final int margin_NameToItem_22 = 14;
	static final int margin_ItemToItem_22 = 9;
	static final int margin_LogoToName_23 = 23;
	static final int margin_NameToItem_23 = 14;
	static final int margin_ItemToItem_23 = 9;
	static final int margin_LogoToName_24 = 23;
	static final int margin_NameToItem_24 = 14;
	static final int margin_ItemToItem_24 = 9;
	static final int margin_LogoToName_25 = 23;
	static final int margin_NameToItem_25 = 14;
	static final int margin_ItemToItem_25 = 9;
	static final int margin_LogoToName_26 = 18;
	static final int margin_NameToItem_26 = 14;
	static final int margin_ItemToItem_26 = 10;
	static final int margin_LeftToItem_27 = 50;
	static final int margin_ItemToBarCode_27 = 80;
	static final int margin_LogoToName_27 = 8;
	static final int margin_NameToItem_27 = 10;
	static final int margin_ItemToItem_27 = 11;
	static final int margin_LogoToName_28 = 12;
	static final int margin_NameToItem_28 = 10;
	static final int margin_ItemToItem_28 = 8;
	static final int margin_LogoToName_29 = 11;
	static final int margin_NameToItem_29 = 17;
	static final int margin_ItemToItem_29 = 9;
	//Added by 唐鹰
	//Add 2014-11-11 Start：
	static final int margin_LogoToName_30 = 11;
	static final int margin_NameToItem_30 = 17;
	static final int margin_ItemToItem_30 = 9;
	//End
	
	//Added by wzj
	//Add 2015-07-15 Start:
	static final int margin_LogoToName_35 = 22;
	static final int margin_NameToItem_35 = 22;
	static final int margin_ItemToItem_35 = 15;
	
	static final int margin_LogoToName_37 = 14;
	static final int margin_NameToItem_37 = 19;
	static final int margin_ItemToItem_37 = 9;
	
	static final int margin_LogoToName_38 = 11;
	static final int margin_NameToItem_38 = 7;
	static final int margin_ItemToItem_38 = 7;
	//End
	
	static final int margin_LogoToName_31 = 11;
	static final int margin_NameToItem_31 = 17;
	static final int margin_ItemToItem_31 = 9;
	
	static final int new_margin_LogoToName_1 = 15;
	static final int new_margin_NameToItem_1 = 8;
	static final int new_margin_ItemToItem_1 = 10;
	static final int new_margin_NameToLogo_1 = 60;
	static final int new_margin_ItemToName_1 = 22;
	static final int new_margin_NameToLogo_2 = 16;
	static final int new_margin_NameToLeft_2 = 12;
	static final int new_margin_NameToName_2 = 9;
	static final int new_margin_ItemToName_2 = 15;
	Image logoEastSoft;
	private printInfo info;
	File logofile = new File("logo.png");
//	private Font font_logo_35;
	
	public MyPrint(printInfo printinfo) {
		
		this.info = printinfo;
		if (logofile.exists()) {
			try {
				logoEastSoft = ImageIO.read(new FileInputStream(logofile));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param Graphic指明打印的图形环
	 *            �?
	 * @param PageFormat指明打印页格
	 *            �? （页面大小以点为计量单位�?点为1英才�?/72�?英寸�?5.4毫米。A4纸大致为595×842点）
	 * @param pageIndex指明页号
	 **/
	
	public int print(Graphics gra, PageFormat pf, int pageIndex)
			throws PrinterException {
		
		
		
		Graphics2D g2 = (Graphics2D) gra;
		Graphics2D g1 = (Graphics2D) gra;
		
//		double px = pf.getWidth();
//		double py = pf.getHeight();
//		Rectangle2D page = new Rectangle2D.Double(0, 0, px, py);
//		g2.setPaint(Color.white);
//		g2.fill(page);
//		g2.setPaint(Color.blue);
//		g2.draw(page);
		
		g1.setColor(Color.WHITE);
		g2.setColor(Color.BLACK);
		//
		
		Paper paper = pf.getPaper();// 得到页面格式的纸�?
		System.out.println("默认宽度" + paper.getWidth());
		System.out.println("默认高度" + paper.getHeight());
		System.out.println("x:" + pf.getImageableX() + "   Y:"
				+ pf.getImageableY());

		// g2.translate(pf.getImageableX(), pf.getImageableY());// 转换坐标，确定打印边�?
		System.out.println(pf.getOrientation());

		// 准备打印内容
		String passwd = info.getPasswd();
		String aid = info.getAid();
		String device = info.getDevice();
		String product = info.getProduct();
		//String product = product1;
		String voltage_str = info.getVoltage();
		String voltage = "额定电压:" + voltage_str;
		String current = "额定电流:" + info.getCurrent();
		String company = info.getCompany();
		String power = info.getPower();
		String voltage_1 = voltage_str;
		String current_1 = info.getCurrent();
		/*
		 * String power = info.getPower();
		 */
		String frequency = "频率：" + info.getFrequency() + "Hz";
		String productSerialNO1 = info.getTester();
		String productSerialNO = "生产批号：" + productSerialNO1;
		String str_product = info.getStr_product();
		boolean showHexAidFlag = info.getShowHexAidFlag();
		String gid = info.getGid();
		String deviceName = info.getdeviceName();
		String deviceType = info.getdeviceType();
		String deviceID = info.getdeviceID();
		String devicePasswd = info.getdevicePassword();
		String deviceSSID = info.getdeviceSSID();

		if (passwd.equals("")) {
			passwd = "null";
		}
		if (aid.equals("")) {
			aid = "null";
		}
		if (device == null) {
			device = "null";
		}
		if (product == null) {
			product = "null";
		}

		if (str_product == null) {
			str_product = "null";
		}
		if (gid == null)
			gid = "null";

		// real print

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		// BasicStroke bs_3=new BasicStroke(0.5f);
		float[] dash1 = { 4.0f, 0 };
		g2.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
		/*
		 * //print hexAid if(showHexAidFlag){ Font font_hex = new Font("黑体",
		 * Font.PLAIN, 8); g2.setFont(font_hex);// 设置字体 String hexAid =
		 * Long.toHexString(Long.parseLong(aid));
		 * g2.drawString("hexAid:"+hexAid.toUpperCase(), 10, 10); }
		 */

		Font font = new Font("黑体", Font.PLAIN, 10);
		// System.out.println(fontSize);
		g2.setFont(font);// 设置字体
		if (pageIndex < 1) {

			MainUI mainUi = MainUI.getInstance(1);
			if(mainUi.jTabbedPane.getSelectedIndex()==0){	//打印标签页
				int formatIndex = info.getFormatIndex();
				switch (formatIndex) {
				case 1:
					// 电源控制模块
					//int left__2 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 9);
					//int top__2 = (int) ((0.8 * PrintFinal.INCH / 2.54)-1);
					
					int left__1 = (int) ((0.5 * PrintFinal.INCH / 2.54)-9)-2;
					int top__1 = (int) (0.8 * PrintFinal.INCH / 2.54 -1);
					// draw logo_eastsoft
					PointCoordinate PointLogo_1 = new PointCoordinate(left__1,
							top__1);
					//new MyLogo(g2, PointLogo_1).drawLogo(5.2f);
					
					String houzhui = "®";
					Font font1 = new Font("微软雅黑", Font.BOLD, 12);
					drawString(g2, company, PointLogo_1, font1);
					drawString(g2, houzhui, 
							new PointCoordinate(
									left__1+(int) (font1.getSize() * (5.2-1)),
									top__1),
							new Font("微软雅黑", Font.BOLD, 4));
	
					// draw device
					PointCoordinate Point_device_1 = new PointCoordinate(left__1,
							PointLogo_1.y + 15);
					drawString(g2, device, Point_device_1, Font.BOLD, 9);
	
					// draw product
					PointCoordinate Point_p_1 = new PointCoordinate(left__1,
							Point_device_1.y + 12);
					Font font_p_1 = new Font("黑体", Font.BOLD, 5);
					drawString(g2, "产品型号:", Point_p_1, font_p_1);
	
					drawString(g2, "负载功耗:"+power, new PointCoordinate(left__1,
							Point_device_1.y+22)
							, font_p_1);
					PointCoordinate Point_product_1 = new PointCoordinate(
							Point_p_1.x + (int) (font_p_1.getSize() * 4.3)+2,
							Point_device_1.y + 12);
					switch (product.length()) {
	
					case 12:
						drawString(g2, product, Point_product_1, Font.PLAIN, 5);
						break;
					case 11:
						drawString(g2, product, Point_product_1, Font.PLAIN, 5);
						break;
					case 10:
						drawString(g2, product, Point_product_1, Font.PLAIN, 5);
						break;
					case 9:
						drawString(g2, product, Point_product_1, Font.PLAIN, 7);
						break;
					default:
						drawString(g2, product, Point_product_1, Font.PLAIN, 7);
						break;
					}
					
					// draw voltage
					PointCoordinate Point_voltate_1 = new PointCoordinate(left__1,
							Point_device_1.y + 32);
					drawString(g2, "额定电压:"+voltage_1, Point_voltate_1,font_p_1);
	
					// draw binaryCode
					File barCode_1 = new File("test_QR_CODE.png");
					Image src_1 = null;
					if (barCode_1.exists()) {
						try {
							src_1 = ImageIO.read(new FileInputStream(barCode_1));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					/*PointCoordinate left_top_1 = new PointCoordinate(left__1
							+ (int) (2.4 * PrintFinal.INCH / 2.54 + 15), top__1
							+ (int) (0.1 * PrintFinal.INCH / 2.54)-8);
					FourCornorsShowSize showSize_1 = new FourCornorsShowSize(60, 75);
					PicShowSet picShowset_1 = new PicShowSet(55, 55, 5, 3);
					new MyBarCodeAll(font_p_1, g2, left_top_1, src_1, aid, passwd,
							showSize_1, picShowset_1)
							.drawAll(LINE_LENGTH + 2, 0, 0);
	
					// print hexAid
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 70, 10);
					}*/
					PointCoordinate left_top_1 = new PointCoordinate(
							(int) ((left__1 + 2 * PrintFinal.INCH / 2.54)),
							top__1 - 10);
					FourCornorsShowSize showSize_1 = new FourCornorsShowSize(50, 60);//下面两个拐线
					PicShowSet picShowset_1 = new PicShowSet(45, 47, 4, 2);
					Font font_1 = new Font("黑体", Font.BOLD, 5);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_1, g2, left_top_1, src_1, aid, passwd,
							showSize_1, picShowset_1)
							.drawAll(LINE_LENGTH - 2, 3, 0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					break;
				case 2:
				case 3:
				case 32:
				case 34:
					// LCD 触摸开关、窗帘控制开关,智能漏电保护，红外微波双鉴探测器
					Font font_es = new Font("微软雅黑", Font.BOLD, 9);
					Font font_r = new Font("微软雅黑", Font.BOLD, 7);
					int left__2 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 9);
					int top__2 = (int) ((0.8 * PrintFinal.INCH / 2.54)-1);
					//end
					// draw logo_eastsoft
					PointCoordinate PointLogo_2 = new PointCoordinate(left__2-2,
							top__2);
					new MyLogo(g2, PointLogo_2, font_es, font_r).drawLogo(5.2f);
	
					// draw device
					PointCoordinate Point_device_2 = new PointCoordinate(left__2-2,
							PointLogo_2.y + margin_LogoToName_2);
					switch(formatIndex){
					case 34:drawString(g2, device, Point_device_2, Font.BOLD, 6);break;
					default:drawString(g2, device, Point_device_2, Font.BOLD, 8);break;
					}
					
	
					// draw product
					PointCoordinate Point_p_2 = new PointCoordinate(left__2-2,
							Point_device_2.y + margin_NameToItem_2);
					Font fontX = new Font("黑体", Font.BOLD, 5);
					Font font_p_2 = new Font("黑体", Font.BOLD, 6);
					drawString(g2, "产品型号:", Point_p_2, font_p_2);
	
					PointCoordinate Point_product_2 = new PointCoordinate(
							Point_p_2.x+2 + (int) (font_p_2.getSize() * 4.4),
							Point_device_2.y + margin_NameToItem_2);
					switch (product.length()) {
					case 12:
						drawString(g2, product, Point_product_2, Font.PLAIN, 5);
						break;
					case 11:
						drawString(g2, product, Point_product_2, Font.PLAIN, 5);
						break;
					case 10:
						drawString(g2, product, Point_product_2, Font.PLAIN, 5);
						break;
					case 9:
						drawString(g2, product, Point_product_2,fontX);
						break;
					default:
						drawString(g2, product, Point_product_2,font_p_2);
						break;
					}
					// draw voltage
					PointCoordinate Point_voltate_2 = new PointCoordinate(left__2-2,
							Point_product_2.y + margin_ItemToItem_2);
					if(formatIndex==32){
						int y=Calendar.getInstance().get(Calendar.YEAR);
						int m=Calendar.getInstance().get(Calendar.MONTH)+1;
						int d=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
						String produceNum=Integer.toString(y)+Integer.toString(m)+Integer.toString(d);
						drawString(g2, "生产批号:"+produceNum, Point_voltate_2, font_p_2);
					}else{
						switch(formatIndex){
						case 34:
						drawString(g2, "工作电压:"+info.getVoltage(), Point_voltate_2, font_p_2);
						break;
						default:
						drawString(g2, voltage, Point_voltate_2, font_p_2);
						}
						
						
					}
					//end
	
					// draw binaryCode
					File barCode_2 = new File("test_QR_CODE.png");
					Image src_2 = null;
					if (barCode_2.exists()) {
						try {
							src_2 = ImageIO.read(new FileInputStream(barCode_2));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// draw 二维码整体
					PointCoordinate left_top_2 = new PointCoordinate(
							(int) ((left__2 + 2 * PrintFinal.INCH / 2.54)+1),
							top__2 - 10);
					FourCornorsShowSize showSize_2 = new FourCornorsShowSize(50, 60);
					PicShowSet picShowset_2 = new PicShowSet(45, 47, 2, 3);
					Font font_2 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_2, g2, left_top_2, src_2, aid, passwd,
							showSize_2, picShowset_2)
							.drawAll(LINE_LENGTH - 2, 3, 0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
	
					break;
	
				/*
				 * case 3: //电容触摸开关....胶州未用 g2.setStroke(new BasicStroke(1.0f,
				 * BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, dash1,
				 * 0.0f));
				 * 
				 * Font font_es_3 = new Font("微软雅黑", Font.BOLD, 9); Font font_r_3 =
				 * new Font("微软雅黑", Font.BOLD, 5); int left__3 = (int) ((0.5 *
				 * PrintFinal.INCH / 2.54)-6); int top__3 = (int) (0.5 *
				 * PrintFinal.INCH / 2.54+7); //draw logo_eastsoft PointCoordinate
				 * PointLogo_3 = new PointCoordinate(left__3,top__3); new
				 * MyLogo(g2,PointLogo_3,font_es_3,font_r_3).drawLogo(5.1f);
				 * 
				 * 
				 * //draw device PointCoordinate Point_device_3 = new
				 * PointCoordinate(left__3, PointLogo_3.y+margin_LogoToName_3);
				 * drawString(g2, device, Point_device_3, Font.BOLD,8);
				 * 
				 * 
				 * //draw voltage PointCoordinate Point_voltate_3 = new
				 * PointCoordinate(left__3, Point_device_3.y+margin_NameToItem_3);
				 * drawString(g2, voltage,Point_voltate_3, Font.PLAIN,6);
				 * 
				 * 
				 * //draw current PointCoordinate Point_Current_3 = new
				 * PointCoordinate(left__3, Point_voltate_3.y+margin_ItemToItem_3);
				 * drawString(g2, current,Point_Current_3, Font.PLAIN,6);
				 * 
				 * 
				 * 
				 * //draw product PointCoordinate Point_p_3 = new
				 * PointCoordinate(left__3, Point_voltate_3.y+margin_ItemToItem_3);
				 * Font font_p_3 = new Font("黑体", Font.PLAIN,6); drawString(g2,
				 * "产品型号:",Point_p_3, font_p_3);
				 * 
				 * PointCoordinate Point_product_3 = new PointCoordinate(Point_p_3.x
				 * + (int)(font_p_3.getSize() * 4.5),
				 * Point_voltate_3.y+margin_ItemToItem_3); switch (product.length())
				 * {
				 * 
				 * case 12: drawString(g2, product,Point_product_3, Font.PLAIN,5);
				 * break; case 11: drawString(g2, product,Point_product_3,
				 * Font.PLAIN,6); break; case 10: drawString(g2,
				 * product,Point_product_3, Font.PLAIN,6); break; case 9:
				 * drawString(g2, product,Point_product_3, Font.PLAIN,6); break;
				 * default: drawString(g2, product,Point_product_3, Font.PLAIN,6);
				 * break; }
				 * 
				 * 
				 * 
				 * 
				 * //draw serial no PointCoordinate Point_Serialno_3 = new
				 * PointCoordinate(left__3, Point_product_3.y+margin_ItemToItem_3);
				 * drawString(g2,productSerialNO,Point_Serialno_3, Font.PLAIN,6);
				 * 
				 * 
				 * //draw binaryCode File barCode_3 = new File("test_QR_CODE.png");
				 * Image src_3 = null; if(barCode_3.exists()){ try { src_3 =
				 * ImageIO.read(new FileInputStream(barCode_3)); } catch
				 * (FileNotFoundException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); } }
				 * 
				 * 
				 * 
				 * 
				 * //draw 二维码整体 PointCoordinate bar_left_top_3 = new
				 * PointCoordinate(left__3+(int) (2.0 * PrintFinal.INCH / 2.54),
				 * top__3 -2); FourCornorsShowSize showSize_3 = new
				 * FourCornorsShowSize(49, 57); PicShowSet picShowset_3 = new
				 * PicShowSet(41, 41, 4, 4); Font font_3 = new Font("黑体", Font.BOLD,
				 * 6); g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
				 * BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f)); new
				 * MyBarCodeAll(font_3, g2,bar_left_top_3, src_3, aid,
				 * passwd,showSize_3,picShowset_3).drawAll(LINE_LENGTH-3,3,0);
				 * 
				 * if(showHexAidFlag){ Font font_hex = new Font("黑体", Font.PLAIN,
				 * 8); g2.setFont(font_hex);// 设置字体 String hexAid =
				 * Long.toHexString(Long.parseLong(aid));
				 * g2.drawString("Aid:"+hexAid.toUpperCase(), 40, 12); }
				 * 
				 * break;
				 */
				case 4:
					// 窗帘控制器
					int left_4 = (int) (0.5 * PrintFinal.INCH / 2.54);
					int top__4 = (int) (0.7 * PrintFinal.INCH / 2.54);
					Font font_4 = new Font("微软雅黑", Font.PLAIN, 6);
					// draw left
					int r_4 = 6;
					int left_right_margin_4 = 20;
	
					PointCoordinate pointCircle_4_1 = new PointCoordinate(left_4,
							top__4);
					new MyCircle(g2, pointCircle_4_1, r_4, "输出端开", font_4)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_4_2 = new PointCoordinate(left_4,
							pointCircle_4_1.y + left_right_margin_4);
					new MyCircle(g2, pointCircle_4_2, r_4, "输出端合", font_4)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_4_3 = new PointCoordinate(left_4,
							pointCircle_4_2.y + left_right_margin_4);
					new MyCircle(g2, pointCircle_4_3, r_4, "公共端", font_4)
							.drawCircle(true, 0);
	
					// draw logo_eastsoft
					PointCoordinate PointLogo_4 = new PointCoordinate(left_4
							+ margin_LeftToItem_4,
							(int) (0.6 * PrintFinal.INCH / 2.54));
					new MyLogo(g2, PointLogo_4).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_4 = new PointCoordinate(left_4
							+ margin_LeftToItem_4, PointLogo_4.y
							+ margin_LogoToName_4);
					drawString(g2, device, Point_device_4, Font.BOLD, 11);
	
					// draw product
					PointCoordinate Point_p_4 = new PointCoordinate(left_4
							+ margin_LeftToItem_4, Point_device_4.y
							+ margin_NameToItem_4);
					Font font_p_4 = new Font("微软雅黑", Font.PLAIN, 7);
					drawString(g2, "产品型号:", Point_p_4, font_p_4);
	
					PointCoordinate Point_product_4 = new PointCoordinate(
							Point_p_4.x + (int) (font_p_4.getSize() * 4.5),
							Point_device_4.y + margin_NameToItem_4);
					switch (product.length()) {
	
					case 12:
						drawString(g2, product, Point_product_4, Font.PLAIN, 5);
						break;
					case 11:
						drawString(g2, product, Point_product_4, Font.PLAIN, 6);
						break;
					case 10:
						drawString(g2, product, Point_product_4, Font.PLAIN, 6);
						break;
					case 9:
						drawString(g2, product, Point_product_4, Font.PLAIN, 7);
						break;
					default:
						drawString(g2, product, Point_product_4, Font.PLAIN, 7);
						break;
					}
	
					// draw voltage
					PointCoordinate Point_voltate_4 = new PointCoordinate(left_4
							+ margin_LeftToItem_4, Point_product_4.y
							+ margin_ItemToItem_4);
					drawString(g2, voltage, Point_voltate_4, Font.PLAIN, 7);
	
					// draw power
					PointCoordinate Point_power_4 = new PointCoordinate(left_4
							+ margin_LeftToItem_4, Point_voltate_4.y
							+ margin_ItemToItem_4);
					drawString(g2, power, Point_power_4, Font.PLAIN, 7);
	
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_4 = new PointCoordinate(left_4
					 * + margin_LeftToItem_4, Point_power_4.y+margin_ItemToItem_4);
					 * drawString(g2,productSerialNO,Point_Serialno_4,
					 * Font.PLAIN,7);
					 */
	
					// draw binaryCode
					File barCode_4 = new File("test_QR_CODE.png");
					Image src_4 = null;
					if (barCode_4.exists()) {
						try {
							src_4 = ImageIO.read(new FileInputStream(barCode_4));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate bar_left_top_4 = new PointCoordinate(left_4
							+ margin_LeftToItem_4 + margin_ItemToBarCode_4,
							PointLogo_4.y - 7);
					FourCornorsShowSize showSize_4 = new FourCornorsShowSize(60, 68);
					PicShowSet picShowset_4 = new PicShowSet(50, 50, 5, 5);
					g2.setStroke(new BasicStroke(1.1f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_p_4, g2, bar_left_top_4, src_4, aid,
							passwd, showSize_4, picShowset_4).drawAll(LINE_LENGTH,
							-4, 0);
	
					PointCoordinate pointCircle_4_4 = new PointCoordinate(
							bar_left_top_4.x + margin_BarCodeToRight_4,
							(int) (2.2 * PrintFinal.INCH / 2.54) - 10);
					new MyCircle(g2, pointCircle_4_4, r_4, "输入 N", font_4)
							.drawCircle(false, 0);
	
					PointCoordinate pointCircle_4_5 = new PointCoordinate(
							pointCircle_4_4.x, pointCircle_4_4.y + 20);
					new MyCircle(g2, pointCircle_4_5, r_4, "输入 L", font_4)
							.drawCircle(false, 0);
	
					// print hexAid
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 12, 12);
					}
	
					break;
	
				case 5:
					// 灯光控制器
					int left_5 = (int) (0.5 * PrintFinal.INCH / 2.54);
					int top__5 = (int) (0.6 * PrintFinal.INCH / 2.54);
					Font font_5 = new Font("微软雅黑", Font.BOLD, 6);
					// draw left
					int r_5 = 6;
					int left_right_margin_5_d = 14;
					int left_right_margin_5_x = 8;
	
					PointCoordinate pointCircle_5_1 = new PointCoordinate(left_5,
							top__5);
					// new MyCircle(g2, pointCircle_5_1, r_5,"灯1 L",
					// font_5).drawCircle(true,0);
	
					PointCoordinate pointCircle_5_2 = new PointCoordinate(left_5,
							pointCircle_5_1.y + left_right_margin_5_x);
					new MyCircle(g2, pointCircle_5_2, r_5, "公共N", font_5)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_5_3 = new PointCoordinate(left_5,
							pointCircle_5_2.y + left_right_margin_5_d);
					// new MyCircle(g2, pointCircle_5_3,
					// r_5,"灯2 L",font_5).drawCircle(true,0);
	
					PointCoordinate pointCircle_5_4 = new PointCoordinate(left_5,
							pointCircle_5_3.y + left_right_margin_5_x);
					new MyCircle(g2, pointCircle_5_4, r_5, "灯1L", font_5)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_5_5 = new PointCoordinate(left_5,
							pointCircle_5_4.y + left_right_margin_5_d);
					// new MyCircle(g2, pointCircle_5_5, r_5,"灯3 L",
					// font_5).drawCircle(true,0);
	
					PointCoordinate pointCircle_5_6 = new PointCoordinate(left_5,
							pointCircle_5_5.y + left_right_margin_5_x);
					new MyCircle(g2, pointCircle_5_6, r_5, "灯2L", font_5)
							.drawCircle(true, 0);
	
					// draw logo_eastsoft
					PointCoordinate PointLogo_5 = new PointCoordinate(left_5
							+ margin_LeftToItem_5, pointCircle_5_1.y+3);
					new MyLogo(g2, PointLogo_5).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_5 = new PointCoordinate(left_5
							+ margin_LeftToItem_5, PointLogo_5.y
							+ margin_LogoToName_5);
					drawString(g2, device, Point_device_5, Font.BOLD, 11);
	
					// draw product
					PointCoordinate Point_p_5 = new PointCoordinate(left_5
							+ margin_LeftToItem_5, Point_device_5.y
							+ margin_NameToItem_5);
					Font font_p_5 = new Font("微软雅黑", Font.BOLD, 7);
					drawString(g2, "产品型号:", Point_p_5, font_p_5);
	
					PointCoordinate Point_product_5 = new PointCoordinate(
							Point_p_5.x + (int) (font_p_5.getSize() * 4.5),
							Point_device_5.y + margin_NameToItem_5);
					switch (product.length()) {
	
					case 12:
						drawString(g2, product, Point_product_5, Font.PLAIN, 5);
						break;
					case 11:
						drawString(g2, product, Point_product_5, Font.PLAIN, 6);
						break;
					case 10:
						drawString(g2, product, Point_product_5, Font.PLAIN, 6);
						break;
					case 9:
						drawString(g2, product, Point_product_5, Font.PLAIN, 7);
						break;
					default:
						drawString(g2, product, Point_product_5, Font.PLAIN, 7);
						break;
					}
	
					// draw voltage
					PointCoordinate Point_voltate_5 = new PointCoordinate(left_5
							+ margin_LeftToItem_5, Point_product_5.y
							+ margin_ItemToItem_5);
					drawString(g2, "额定电压", Point_voltate_5, Font.BOLD, 7);
					PointCoordinate Point_voltate_5_1 = new PointCoordinate(
							Point_voltate_5.x + 30, Point_product_5.y
									+ margin_ItemToItem_5);
	
					drawString(g2, voltage_str, Point_voltate_5_1, Font.PLAIN, 7);
	
					// draw power
					PointCoordinate Point_power_5 = new PointCoordinate(left_5
							+ margin_LeftToItem_5, Point_voltate_5.y
							+ margin_ItemToItem_5 + 4);
					// drawString(g2, power,Point_power_5, Font.PLAIN,7);
					drawString(g2, "额定功率: ", Point_power_5, Font.BOLD, 7);
	
					PointCoordinate Point_power_5_e = new PointCoordinate(
							Point_power_5.x + 30, Point_voltate_5.y
									+ margin_ItemToItem_5 + 4);
					// drawString(g2, power,Point_power_5, Font.PLAIN,7);
					drawString(g2, "单路", Point_power_5_e, Font.PLAIN, 7);
	
					PointCoordinate Point_power_5_1 = new PointCoordinate(left_5
							+ margin_LeftToItem_5 + 43, Point_voltate_5.y
							+ margin_ItemToItem_5 + 6);
					drawString(g2, "[", Point_power_5_1, Font.PLAIN, 14);
	
					PointCoordinate Point_power_5_2 = new PointCoordinate(
							Point_power_5_1.x + 5, Point_voltate_5.y
									+ margin_ItemToItem_5 - 3);
					drawString(g2, "日光灯<200W", Point_power_5_2, Font.BOLD, 5);
	
					PointCoordinate Point_power_5_3 = new PointCoordinate(
							Point_power_5_2.x, Point_power_5_2.y + 12);
					drawString(g2, "LED灯<1000W", Point_power_5_3, Font.BOLD, 5);
	
					// draw "生产批号"
					/*
					 * PointCoordinate Point_Serialno_5 = new PointCoordinate(left_5
					 * + margin_LeftToItem_5, Point_power_5.y+margin_ItemToItem_5 +
					 * 4); drawString(g2,"生产批号：",Point_Serialno_5, Font.BOLD,7);
					 */
	
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_5_1 = new
					 * PointCoordinate(Point_Serialno_5.x+35,
					 * Point_power_5.y+margin_ItemToItem_5 + 4);
					 * drawString(g2,productSerialNO1,Point_Serialno_5_1,
					 * Font.PLAIN,7);
					 */
	
					// draw binaryCode
					File barCode_5 = new File("test_QR_CODE.png");
					Image src_5 = null;
					if (barCode_5.exists()) {
						try {
							src_5 = ImageIO.read(new FileInputStream(barCode_5));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate bar_left_top_5 = new PointCoordinate(left_5
							+ margin_LeftToItem_5 + margin_ItemToBarCode_5,
							PointLogo_5.y - 10);
					FourCornorsShowSize showSize_5 = new FourCornorsShowSize(60, 68);
					PicShowSet picShowset_5 = new PicShowSet(50, 50, 5, 5);
					g2.setStroke(new BasicStroke(1.1f, BasicStroke.CAP_BUTT,
							BasicStroke.CAP_ROUND, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_p_5, g2, bar_left_top_5, src_5, aid,
							passwd, showSize_5, picShowset_5).drawAll(LINE_LENGTH,
							-4, 0);
	
					PointCoordinate pointCircle_5_7 = new PointCoordinate(
							bar_left_top_5.x + margin_BarCodeToRight_5,
							(int) (1.5 * PrintFinal.INCH / 2.54));
					new MyCircle(g2, pointCircle_5_7, r_5, "输入 L", font_5)
							.drawCircle(false, 0);
	
					PointCoordinate pointCircle_5_8 = new PointCoordinate(
							pointCircle_5_7.x, pointCircle_5_7.y + 24);
					new MyCircle(g2, pointCircle_5_8, r_5, "输入 N", font_5)
							.drawCircle(false, 0);
	
					// print hexAid
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 12, 12);
					}
					break;
	
				case 6:
					// 调光控制器
					int left_6 = (int) (0.5 * PrintFinal.INCH / 2.54);
					int top__6 = (int) (0.9 * PrintFinal.INCH / 2.54);
					Font font_6 = new Font("微软雅黑", Font.PLAIN, 6);
					Font font_6_1 = new Font("微软雅黑", Font.BOLD, 6);
					// draw left
					int r_6 = 6;
					int left_right_margin_6_d = 20;
					int left_right_margin_6_x = 9;
	
					PointCoordinate pointCircle_6_1 = new PointCoordinate(left_6,
							top__6 + 25);
					new MyCircle(g2, pointCircle_6_1, r_6, "输入L", font_6_1)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_6_2 = new PointCoordinate(left_6,
							pointCircle_6_1.y + left_right_margin_6_x + 10);
					new MyCircle(g2, pointCircle_6_2, r_6, "输入N", font_6_1)
							.drawCircle(true, 0);
	
					// PointCoordinate pointCircle_6_3 = new
					// PointCoordinate(left_6,pointCircle_6_2.y+left_right_margin_6_d);
					// new MyCircle(g2, pointCircle_6_3,
					// r_6,"输出 N",font_6).drawCircle(true,0);
	
					// PointCoordinate pointCircle_6_4 = new
					// PointCoordinate(left_6,pointCircle_6_3.y+left_right_margin_6_x);
					// new MyCircle(g2, pointCircle_6_4,
					// r_6,"输出 L",font_6).drawCircle(true,0);
	
					// draw logo_eastsoft
					PointCoordinate PointLogo_6 = new PointCoordinate(left_6
							+ margin_LeftToItem_6, top__6 - 6);
					new MyLogo(g2, PointLogo_6).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_6 = new PointCoordinate(left_6
							+ margin_LeftToItem_6, PointLogo_6.y
							+ margin_LogoToName_6);
					drawString(g2, device, Point_device_6, Font.BOLD, 11);
	
					// draw product
					PointCoordinate Point_p_6 = new PointCoordinate(left_6
							+ margin_LeftToItem_6, Point_device_6.y
							+ margin_NameToItem_6);
					Font font_p_6 = new Font("微软雅黑", Font.PLAIN, 7);
					drawString(g2, "产品型号:", Point_p_6, font_p_6);
	
					PointCoordinate Point_product_6 = new PointCoordinate(
							Point_p_6.x + (int) (font_p_6.getSize() * 4.5),
							Point_device_6.y + margin_NameToItem_6);
					switch (product.length()) {
	
					case 12:
						drawString(g2, product, Point_product_6, Font.PLAIN, 5);
						break;
					case 11:
						drawString(g2, product, Point_product_6, Font.PLAIN, 6);
						break;
					case 10:
						drawString(g2, product, Point_product_6, Font.PLAIN, 6);
						break;
					case 9:
						drawString(g2, product, Point_product_6, Font.PLAIN, 7);
						break;
					default:
						drawString(g2, product, Point_product_6, Font.PLAIN, 7);
						break;
					}
	
					// draw voltage
					PointCoordinate Point_voltate_6 = new PointCoordinate(left_6
							+ margin_LeftToItem_6, Point_product_6.y
							+ margin_ItemToItem_6);
					drawString(g2, voltage, Point_voltate_6, Font.PLAIN, 7);
	
					// draw fre
					PointCoordinate Point_fre_6 = new PointCoordinate(left_6
							+ margin_LeftToItem_6, Point_voltate_6.y
							+ margin_ItemToItem_6);
					drawString(g2, frequency, Point_fre_6, Font.PLAIN, 7);
	
					// draw power
					PointCoordinate Point_power_6 = new PointCoordinate(left_6
							+ margin_LeftToItem_6, Point_fre_6.y
							+ margin_ItemToItem_6);
					drawString(g2, power, Point_power_6, Font.PLAIN, 7);
	
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_6 = new PointCoordinate(left_6
					 * + margin_LeftToItem_6, Point_power_6.y+margin_ItemToItem_6);
					 * drawString(g2,productSerialNO,Point_Serialno_6,
					 * Font.PLAIN,7);
					 */
	
					// draw binaryCode
					File barCode_6 = new File("test_QR_CODE.png");
					Image src_6 = null;
					if (barCode_6.exists()) {
						try {
							src_6 = ImageIO.read(new FileInputStream(barCode_6));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate bar_left_top_6 = new PointCoordinate(left_6
							+ margin_LeftToItem_6 + margin_ItemToBarCode_6,
							PointLogo_6.y - 11);
					FourCornorsShowSize showSize_6 = new FourCornorsShowSize(60, 68);
					PicShowSet picShowset_6 = new PicShowSet(50, 50, 5, 5);
					g2.setStroke(new BasicStroke(1.1f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_p_6, g2, bar_left_top_6, src_6, aid,
							passwd, showSize_6, picShowset_6).drawAll(LINE_LENGTH,
							-4, 0);
	
					PointCoordinate pointCircle_6_6 = new PointCoordinate(
							bar_left_top_6.x + margin_BarCodeToRight_6,
							(int) (1.5 * PrintFinal.INCH / 2.54));
					new MyCircle(g2, pointCircle_6_6, 4, "输出-", font_6_1)
							.drawCircle(false, 0);
	
					PointCoordinate pointCircle_6_5 = new PointCoordinate(
							pointCircle_6_6.x, pointCircle_6_6.y + 23);
					new MyCircle(g2, pointCircle_6_5, 4, "输出+", font_6_1)
							.drawCircle(false, 0);
	
					// print hexAid
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 12, 12);
					}
	
					break;
	
				case 7:
					// 红外转发器
					//红外转发器整体位置调整
					/*
					 * int left_7 = (int) (0.1 * PrintFinal.INCH / 2.54 - 4); int
					 * top__7 = (int) (0.5 * PrintFinal.INCH / 2.54 - 4);
					 */
					int left_7 = 5;
					int top__7 = (int) (0.33 * PrintFinal.INCH / 2.54)+8;
					// draw logo_eastsoft
					PointCoordinate PointLogo_7 = new PointCoordinate(left_7,
							top__7);
					new MyLogo(g2, PointLogo_7).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_7 = new PointCoordinate(left_7,
							PointLogo_7.y + margin_LogoToName_7);
					drawString(g2, device, Point_device_7, Font.BOLD, 8);
	
					// draw product
					PointCoordinate Point_p_7 = new PointCoordinate(left_7,
							Point_device_7.y + margin_NameToItem_7);
					Font font_p_7 = new Font("微软雅黑", Font.PLAIN, 5);
					drawString(g2, "产品型号:", Point_p_7, font_p_7);
	
					PointCoordinate Point_product_7 = new PointCoordinate(
							Point_p_7.x + (int) (font_p_7.getSize() * 4.5),
							Point_device_7.y + margin_NameToItem_7);
					switch (product.length()) {
	
					case 12:
						drawString(g2, product, Point_product_7, Font.PLAIN, 5);
						break;
					case 11:
						drawString(g2, product, Point_product_7, Font.PLAIN, 5);
						break;
					case 10:
						drawString(g2, product, Point_product_7, Font.PLAIN, 5);
						break;
					case 9:
						drawString(g2, product, Point_product_7, Font.PLAIN, 5);
						break;
					default:
						drawString(g2, product, Point_product_7, Font.PLAIN, 5);
						break;
					}
	
					// draw voltage
					PointCoordinate Point_voltate_7 = new PointCoordinate(left_7,
							Point_product_7.y + margin_ItemToItem_7);
					drawString(g2, voltage, Point_voltate_7, Font.PLAIN, 5);
	
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_7 = new PointCoordinate(left_7
					 * , Point_voltate_7.y+margin_ItemToItem_7);
					 * drawString(g2,productSerialNO,Point_Serialno_7,
					 * Font.PLAIN,5);
					 */
	
					// draw binaryCode
					File barCode_7 = new File("test_QR_CODE.png");
					Image src_7 = null;
					if (barCode_7.exists()) {
						try {
							src_7 = ImageIO.read(new FileInputStream(barCode_7));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_7 = new PointCoordinate(
							(int) (1.6 * PrintFinal.INCH / 2.54 + 1), PointLogo_7.y
									+ (int) (0.2 * PrintFinal.INCH / 2.54)-2);
					Font font_7 = new Font("黑体", Font.PLAIN, 5);
					FourCornorsShowSize cornersSize_7 = new FourCornorsShowSize(36,
							47);
					PicShowSet picShowset_7 = new PicShowSet(34, 35, 2, 1);
					g2.setStroke(new BasicStroke(0.6f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_7, g2, left_top_7, src_7, aid, passwd,
							cornersSize_7, picShowset_7).drawAll(LINE_LENGTH - 4,
							2, 0);
	
					// print hexAid
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 7);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("aid:" + hexAid.toUpperCase(), 1, 18);
					}
	
					break;
				case 8:
					// 智能网关
					int left_8 = (int) (0.8 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft
					PointCoordinate PointLogo_8 = new PointCoordinate(left_8 + 1,
							(int) (0.8 * PrintFinal.INCH / 2.54));
					new MyLogo(g2, PointLogo_8).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_8 = new PointCoordinate(left_8,
							PointLogo_8.y + margin_LogoToName_8);
					drawString(g2, device, Point_device_8, Font.BOLD, 12);
	
					// draw product
					PointCoordinate Point_p_8 = new PointCoordinate(left_8,
							Point_device_8.y + margin_NameToItem_8);
					Font font_p_8 = new Font("微软雅黑", Font.PLAIN, 8);
					drawString(g2, "产品型号:", Point_p_8, font_p_8);
	
					PointCoordinate Point_product_8 = new PointCoordinate(
							Point_p_8.x + (int) (font_p_8.getSize() * 4.3),
							Point_device_8.y + margin_NameToItem_8);
					drawString(g2, product, Point_product_8, Font.PLAIN, 8);
	
					// draw voltage
					PointCoordinate Point_voltate_8 = new PointCoordinate(left_8,
							Point_product_8.y + margin_ItemToItem_8);
					drawString(g2, voltage, Point_voltate_8, Font.PLAIN, 8);
	
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_8 = new PointCoordinate(left_8
					 * , Point_voltate_8.y+margin_ItemToItem_8);
					 * drawString(g2,productSerialNO,Point_Serialno_8,
					 * Font.PLAIN,8);/*
					 * 
					 * //draw serial no PointCoordinate Point_gid_8 = new
					 * PointCoordinate(left_8 ,
					 * Point_Serialno_8.y+margin_ItemToItem_8);
					 * 
					 * drawString(g2,"网关号   :" + ""+gid,Point_gid_8, Font.PLAIN,8);
					 * 
					 * /*draw http PointCoordinate Point_http = new
					 * PointCoordinate(left_8 ,
					 * Point_Serialno_8.y+margin_ItemToItem_8); Font font_8 = new
					 * Font("Verdana", Font.PLAIN,8);
					 * drawString(g2,"www.ehomeclouds.com",Point_http,font_8);
					 */
					break;
				case 9:
					// RGB调光控制
					g2.rotate(Math.PI * 0.5, 0.5 * (7.0 * PrintFinal.INCH / 2.54),
							0.5 * (5.0 * PrintFinal.INCH / 2.54));
					int move_x_9 = 5;
					int s = 27;
					int c = 30;
					int left_9 = (int) (0.3 * PrintFinal.INCH / 2.54 - move_x_9)
							+ s;
					Font font_9 = new Font("黑体", Font.PLAIN, 7);
					// draw left
					int r_9 = 6;
					boolean v = true;
					// int left_right_margin_9_d = 19;
					int left_right_margin_9_d = 22;
					int left_right_margin_9_x = 12;
					double scale = 1;
					PointCoordinate pointCircle_9_1 = new PointCoordinate(left_9,
							(int) (((0.4 * PrintFinal.INCH / 2.54) - c) * scale));
					new MyCircle(g2, pointCircle_9_1, r_9, "R", font_9).drawCircle(
							true, 0);
	
					PointCoordinate pointCircle_9_2 = new PointCoordinate(
							left_9,
							(int) ((pointCircle_9_1.y + left_right_margin_9_d) * scale));
					new MyCircle(g2, pointCircle_9_2, r_9, "G", font_9).drawCircle(
							true, 0);
	
					PointCoordinate pointCircle_9_3 = new PointCoordinate(
							left_9,
							(int) ((pointCircle_9_2.y + left_right_margin_9_d) * scale));
					new MyCircle(g2, pointCircle_9_3, r_9, "B", font_9).drawCircle(
							true, 0);
	
					PointCoordinate pointCircle_9_4 = new PointCoordinate(
							left_9,
							(int) ((pointCircle_9_3.y + left_right_margin_9_d) * scale));
					new MyCircle(g2, pointCircle_9_4, r_9, "12V", font_9)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_9_5 = new PointCoordinate(
							left_9,
							(int) ((pointCircle_9_4.y + left_right_margin_9_d) * scale));
					new MyCircle(g2, pointCircle_9_5, r_9, "NC", font_9)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_9_6 = new PointCoordinate(
							left_9,
							(int) ((pointCircle_9_5.y + left_right_margin_9_d) * scale));
					new MyCircle(g2, pointCircle_9_6, r_9, "R", font_9).drawCircle(
							true, 0);
	
					PointCoordinate pointCircle_9_7 = new PointCoordinate(
							left_9,
							(int) ((pointCircle_9_6.y + left_right_margin_9_d) * scale));
					new MyCircle(g2, pointCircle_9_7, r_9, "G", font_9).drawCircle(
							true, 0);
	
					PointCoordinate pointCircle_9_8 = new PointCoordinate(
							left_9,
							(int) ((pointCircle_9_7.y + left_right_margin_9_d) * scale));
					new MyCircle(g2, pointCircle_9_8, r_9, "B", font_9).drawCircle(
							true, 0);
	
					PointCoordinate pointCircle_9_9 = new PointCoordinate(
							left_9,
							(int) ((pointCircle_9_8.y + left_right_margin_9_d) * scale));
					new MyCircle(g2, pointCircle_9_9, r_9, "12V", font_9)
							.drawCircle(true, 0);
	
					double pfWidth = pf.getHeight();
					double pfHeight = pf.getWidth();
					int margin = 12;
					int margin_LineToLine = 20;
					int lineLength = 2;
					float[] dash2 = { 2.0f, 0 };
					g2.setStroke(new BasicStroke(0.6f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 2.0f, dash2, 0.0f));
					// draw 左边两条竖实线
					int leftLine_9_1_x = (int) (pfWidth / 3 - margin
							- margin_LineToLine - move_x_9 + 8)
							+ s;
					int leftLine_9_1_y = (int) (0.4 * PrintFinal.INCH / 2.54) + 2
							- c;
					g2.drawLine(leftLine_9_1_x, leftLine_9_1_y, leftLine_9_1_x,
							pointCircle_9_3.y + left_right_margin_9_d);
					g2.drawLine(leftLine_9_1_x, leftLine_9_1_y
							+ left_right_margin_9_d * 5, leftLine_9_1_x,
							pointCircle_9_3.y + left_right_margin_9_d * 6);
	
					// draw 左边八条短横线
					int leftLine_9_2_x = (int) pfWidth / 3 - margin
							- margin_LineToLine - lineLength - move_x_9 + 8 + s;
					int leftLine_9_2_y = (int) (0.4 * PrintFinal.INCH / 2.54) + 2
							- c;
					g2.drawLine(leftLine_9_2_x, leftLine_9_2_y, leftLine_9_2_x
							+ lineLength, leftLine_9_2_y);
					g2.drawLine(leftLine_9_2_x, leftLine_9_2_y
							+ left_right_margin_9_d, leftLine_9_2_x + lineLength,
							leftLine_9_2_y + left_right_margin_9_d);
					g2.drawLine(leftLine_9_2_x, leftLine_9_2_y
							+ left_right_margin_9_d * 2, leftLine_9_2_x
							+ lineLength, leftLine_9_2_y + left_right_margin_9_d
							* 2);
					/*
					 * g2.drawLine(leftLine_9_2_x,leftLine_9_2_y+
					 * left_right_margin_9_d*3,
					 * leftLine_9_2_x+lineLength,leftLine_9_2_y
					 * +left_right_margin_9_d*3);
					 */
					/*
					 * g2.drawLine(leftLine_9_2_x,leftLine_9_2_y+
					 * left_right_margin_9_d*4,
					 * leftLine_9_2_x+lineLength,leftLine_9_2_y
					 * +left_right_margin_9_d*4);
					 */
					g2.drawLine(leftLine_9_2_x, leftLine_9_2_y
							+ left_right_margin_9_d * 5, leftLine_9_2_x
							+ lineLength, leftLine_9_2_y + left_right_margin_9_d
							* 5);
					g2.drawLine(leftLine_9_2_x, leftLine_9_2_y
							+ left_right_margin_9_d * 6, leftLine_9_2_x
							+ lineLength, leftLine_9_2_y + left_right_margin_9_d
							* 6);
					g2.drawLine(leftLine_9_2_x, leftLine_9_2_y
							+ left_right_margin_9_d * 7, leftLine_9_2_x
							+ lineLength, leftLine_9_2_y + left_right_margin_9_d
							* 7);
					/*
					 * g2.drawLine(leftLine_9_2_x,leftLine_9_2_y+
					 * left_right_margin_9_d*8,
					 * leftLine_9_2_x+lineLength,leftLine_9_2_y
					 * +left_right_margin_9_d*8);
					 */
	
					PointCoordinate PointlightA_1 = new PointCoordinate(
							(int) pfWidth / 3 - margin - margin_LineToLine
									- lineLength + 12 - move_x_9 + s,
							(int) (0.4 * PrintFinal.INCH / 2.54)
									+ left_right_margin_9_d + 10 - c);
					drawString(g2, "灯", PointlightA_1, Font.PLAIN, 8);
					PointCoordinate PointlightA_2 = new PointCoordinate(
							PointlightA_1.x, PointlightA_1.y + 10);
					drawString(g2, "A", PointlightA_2, Font.PLAIN, 8);
	
					PointCoordinate PointlightB_1 = new PointCoordinate(
							PointlightA_1.x, (int) (0.4 * PrintFinal.INCH / 2.54)
									+ left_right_margin_9_d * 6 + 10 - c);
					drawString(g2, "灯", PointlightB_1, Font.PLAIN, 8);
					PointCoordinate PointlightB_2 = new PointCoordinate(
							PointlightA_1.x, PointlightB_1.y + 10);
					drawString(g2, "B", PointlightB_2, Font.PLAIN, 8);
	
					/*
					 * int left__9 = (int) (left_9 + pfWidth/2) - 32-move_x_9; int
					 * move_9_y=12;
					 */
					int left__9 = (int) (left_9 + pfWidth / 2) - 31 - move_x_9;
					int move_9_y = 12;
					// draw middle
					// draw logo_eastsoft
					PointCoordinate PointLogo_9 = new PointCoordinate(left__9 - 4,
							(int) (0.9 * PrintFinal.INCH / 2.54 - c));
					new MyLogo(g2, PointLogo_9).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_9 = new PointCoordinate(
							left__9 - 5, PointLogo_9.y + margin_LogoToName_9);
					drawString(g2, device, Point_device_9, Font.BOLD, 9);
	
					// draw product
					PointCoordinate Point_p_9 = new PointCoordinate(left__9,
							Point_device_9.y + margin_NameToItem_9);
					Font font_p_9 = new Font("微软雅黑", Font.PLAIN, 7);
					drawString(g2, "型号:", Point_p_9, font_p_9);
	
					PointCoordinate Point_product_9 = new PointCoordinate(
							Point_p_9.x + (int) (font_p_9.getSize() * 2.8),
							Point_device_9.y + margin_NameToItem_9);
					switch (product.length()) {
	
					case 12:
						drawString(g2, product, Point_product_9, Font.PLAIN, 5);
						break;
					case 11:
						drawString(g2, product, Point_product_9, Font.PLAIN, 6);
						break;
					case 10:
						drawString(g2, product, Point_product_9, Font.PLAIN, 7);
						break;
					case 9:
						drawString(g2, product, Point_product_9, Font.PLAIN, 7);
						break;
					default:
						drawString(g2, product, Point_product_9, Font.PLAIN, 7);
						break;
					}
	
					// draw voltage
					PointCoordinate Point_voltate_9 = new PointCoordinate(left__9,
							Point_product_9.y + margin_ItemToItem_9);
					drawString(g2, voltage, Point_voltate_9, Font.PLAIN, 7);
					/*
					 * PointCoordinate Point_voltate_9 = new
					 * PointCoordinate(left__9,
					 * Point_product_9.y+margin_ItemToItem_9); drawString(g2,
					 * voltage,Point_voltate_9, Font.PLAIN,7,true);
					 */
					// draw power
					PointCoordinate Point_power_9 = new PointCoordinate(left__9,
							Point_voltate_9.y + margin_ItemToItem_9);
					drawString(g2, power, Point_power_9, Font.PLAIN, 7);
					/*
					 * PointCoordinate Point_power_9 = new PointCoordinate(left__9,
					 * Point_voltate_9.y+margin_ItemToItem_9); drawString(g2,
					 * power,Point_power_9, Font.PLAIN,7,true);
					 */
					// draw serial no
					PointCoordinate Point_Serialno_9 = new PointCoordinate(left__9,
							Point_power_9.y + margin_ItemToItem_9);
					// drawString(g2,productSerialNO,Point_Serialno_9,
					// Font.PLAIN,7);
	
					// draw binaryCode
					File barCode_9 = new File("test_QR_CODE.png");
					Image src_9 = null;
					if (barCode_9.exists()) {
						try {
							src_9 = ImageIO.read(new FileInputStream(barCode_9));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate bar_left_top_9 = new PointCoordinate(
							left__9 + 3, Point_Serialno_9.y + 6);
					// FourCornorsShowSize showSize_9 = new FourCornorsShowSize(60,
					// 68);
					// PicShowSet picShowset_9 = new PicShowSet(50, 50, 5, 5);
					FourCornorsShowSize showSize_9 = new FourCornorsShowSize(52, 59);
					PicShowSet picShowset_9 = new PicShowSet(40, 40, 5, 5);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_p_9, g2, bar_left_top_9, src_9, aid,
							passwd, showSize_9, picShowset_9).drawAll(LINE_LENGTH,
							0, 0);
	
					// PointCoordinate pointCircle_9_10 = new
					// PointCoordinate((int)(2*pfWidth/3) + 53,(int) (0.8 *
					// PrintFinal.INCH / 2.54)-2);
					PointCoordinate pointCircle_9_10 = new PointCoordinate(
							(int) (2 * pfWidth / 3) + 48 - move_x_9 + s + 1,
							(int) (0.4 * PrintFinal.INCH / 2.54) - c);
					new MyCircle(g2, pointCircle_9_10, r_9, "输出N", font_9)
							.drawCircle(false, 0);
					// PointCoordinate pointCircle_9_11= new
					// PointCoordinate(pointCircle_9_10.x,pointCircle_9_10.y+left_right_margin_9_x);
					PointCoordinate pointCircle_9_11 = new PointCoordinate(
							pointCircle_9_10.x, pointCircle_9_1.y
									+ left_right_margin_9_d);
					new MyCircle(g2, pointCircle_9_11, r_9, "输出L", font_9)
							.drawCircle(false, 0);
					// PointCoordinate pointCircle_9_12 = new
					// PointCoordinate(pointCircle_9_11.x,pointCircle_9_11.y+left_right_margin_9_d*2);
					PointCoordinate pointCircle_9_12 = new PointCoordinate(
							pointCircle_9_10.x, pointCircle_9_2.y
									+ left_right_margin_9_d);
					new MyCircle(g2, pointCircle_9_12, r_9, "NC", font_9)
							.drawCircle(false, -1);
					// PointCoordinate pointCircle_9_13= new
					// PointCoordinate(pointCircle_9_12.x,pointCircle_9_12.y+left_right_margin_9_x);
					PointCoordinate pointCircle_9_13 = new PointCoordinate(
							pointCircle_9_10.x, pointCircle_9_3.y
									+ left_right_margin_9_d);
					new MyCircle(g2, pointCircle_9_13, r_9, "输入L", font_9)
							.drawCircle(false, 0);
					PointCoordinate pointCircle_9_14 = new PointCoordinate(
							pointCircle_9_13.x, pointCircle_9_13.y
									+ left_right_margin_9_d);
					new MyCircle(g2, pointCircle_9_14, r_9, "输入N", font_9)
							.drawCircle(false, 0);
					PointCoordinate pointCircle_9_15 = new PointCoordinate(
							pointCircle_9_14.x, pointCircle_9_14.y
									+ left_right_margin_9_d);
					new MyCircle(g2, pointCircle_9_15, r_9, "输入L", font_9)
							.drawCircle(false, 0);
					PointCoordinate pointCircle_9_16 = new PointCoordinate(
							pointCircle_9_15.x, pointCircle_9_15.y
									+ left_right_margin_9_d);
					new MyCircle(g2, pointCircle_9_16, r_9, "输入B:12V", font_9)
							.drawCircle(false, 2);
					PointCoordinate pointCircle_9_17 = new PointCoordinate(
							pointCircle_9_16.x, pointCircle_9_16.y
									+ left_right_margin_9_d);
					new MyCircle(g2, pointCircle_9_17, r_9, "公共地", font_9)
							.drawCircle(false, 1);
					PointCoordinate pointCircle_9_18 = new PointCoordinate(
							pointCircle_9_17.x, pointCircle_9_17.y
									+ left_right_margin_9_d);
					new MyCircle(g2, pointCircle_9_18, r_9, "输入A:12V", font_9)
							.drawCircle(false, 2);
					// draw 两条虚线
					float[] dash3 = { 4.0f, 4.0f };
					g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash3, 0.0f));
					g2.drawLine((int) pfWidth / 3 - margin - move_x_9 + s, 0 - c,
							(int) pfWidth / 3 - margin - move_x_9 + s,
							(int) pfHeight);
					g2.drawLine(
							2 * ((int) pfWidth / 3) + margin - move_x_9 + s - 4,
							0 - c, 2 * ((int) pfWidth / 3) + margin - move_x_9 + s
									- 4, (int) pfHeight);
					/*
					 * g2.drawLine(0, (int)pfHeight/3, (int)pfWidth, (int)pfHeight/3
					 * ); g2.drawLine(0, (int)(pfHeight/3*2), (int)pfWidth,
					 * (int)(pfHeight/3*2) );
					 */
	
					// print hexAid
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						// g2.rotate(Math.PI*0.5);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("16a:" + hexAid.toUpperCase(), 1, 7);
					}
	
					break;
	
				case 10:
					// 智能插座
					int left_10 = (int) (0.2 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft
	
					PointCoordinate PointLogo_10 = new PointCoordinate(left_10,
							(int) (0.5 * PrintFinal.INCH / 2.54)+3);
					Font font_es_10 = new Font("微软雅黑", Font.BOLD, 9);
					Font font_r_10 = new Font("微软雅黑", Font.BOLD, 7);
					new MyLogo(g2, PointLogo_10, font_es_10, font_r_10)
							.drawLogo(5.2f);
	
					// draw device
					PointCoordinate Point_device_10 = new PointCoordinate(left_10,
							PointLogo_10.y + margin_LogoToName_10);
					drawString(g2, device, Point_device_10, Font.BOLD, 9);
	
					// draw product
					PointCoordinate Point_p_10 = new PointCoordinate(left_10,
							Point_device_10.y + margin_NameToItem_10);
					Font font_p_10 = new Font("微软雅黑", Font.PLAIN, 6);
					drawString(g2, "产品型号:", Point_p_10, font_p_10);
	
					PointCoordinate Point_product_10 = new PointCoordinate(
							Point_p_10.x + (int) (font_p_10.getSize() * 4.5),
							Point_device_10.y + margin_NameToItem_10);
					drawString(g2, product, Point_product_10, Font.PLAIN, 6);
	
					// draw voltage
					PointCoordinate Point_voltate_10 = new PointCoordinate(left_10,
							Point_product_10.y + margin_ItemToItem_10);
					drawString(g2, voltage, Point_voltate_10, Font.PLAIN, 6);
					// draw current
					PointCoordinate Point_current_10 = new PointCoordinate(left_10,
							Point_voltate_10.y + margin_ItemToItem_10);
					drawString(g2, current, Point_current_10, Font.PLAIN, 6);
	
					// draw productNO
					/*
					 * PointCoordinate Point_productSno_10 = new
					 * PointCoordinate(left_10 ,
					 * Point_current_10.y+margin_ItemToItem_10); drawString(g2,
					 * productSerialNO,Point_productSno_10, Font.PLAIN,6);
					 */
	
					// draw binaryCode
					File barCode_10 = new File("test_QR_CODE.png");
					Image src_10 = null;
					if (barCode_10.exists()) {
						try {
							src_10 = ImageIO.read(new FileInputStream(barCode_10));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_10 = new PointCoordinate(
							(int) (2.2 * PrintFinal.INCH / 2.54),
							(int) (0.35 * PrintFinal.INCH / 2.54));
					Font font_10 = new Font("黑体", Font.PLAIN, 5);
					FourCornorsShowSize cornersSize_10 = new FourCornorsShowSize(
							40, 50);
					PicShowSet picShowset_10 = new PicShowSet(36, 38, 2, 2);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_10, g2, left_top_10, src_10, aid, passwd,
							cornersSize_10, picShowset_10).drawAll(LINE_LENGTH - 1,
							0, 0);
	
					// print hexAid
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 7);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("16a:" + hexAid.toUpperCase(), 50, 7);
					}
	
					break;
	
				case 11:// 双轨窗帘控制器
					int left_11 = (int) (0.5 * PrintFinal.INCH / 2.54);
					int top__11 = (int) (0.5 * PrintFinal.INCH / 2.54);
					Font font_11 = new Font("微软雅黑", Font.BOLD, 6);
					// draw left
					int r_11 = 6;
					int left_right_margin_11 = 15;
	
					PointCoordinate pointCircle_11_1 = new PointCoordinate(left_11,
							top__11);
					new MyCircle(g2, pointCircle_11_1, r_11, "电机1正向", font_11)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_11_2 = new PointCoordinate(left_11,
							pointCircle_11_1.y + left_right_margin_11);
					new MyCircle(g2, pointCircle_11_2, r_11, "电机1反向", font_11)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_11_3 = new PointCoordinate(left_11,
							pointCircle_11_2.y + left_right_margin_11);
					new MyCircle(g2, pointCircle_11_3, r_11, "电机2正向", font_11)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_11_4 = new PointCoordinate(left_11,
							pointCircle_11_3.y + left_right_margin_11);
					new MyCircle(g2, pointCircle_11_4, r_11, "电机2反向", font_11)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_11_5 = new PointCoordinate(left_11,
							pointCircle_11_4.y + left_right_margin_11);
					new MyCircle(g2, pointCircle_11_5, r_11, "电机公共端", font_11)
							.drawCircle(true, 0);
	
					// draw logo_eastsoft
					PointCoordinate PointLogo_11 = new PointCoordinate(left_11
							+ margin_LeftToItem_11,
							(int) (0.6 * PrintFinal.INCH / 2.54));
					new MyLogo(g2, PointLogo_11).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_11 = new PointCoordinate(left_11
							+ margin_LeftToItem_11, PointLogo_11.y
							+ margin_LogoToName_11);
					drawString(g2, device, Point_device_11, Font.BOLD, 11);
	
					// draw product
					PointCoordinate Point_p_11 = new PointCoordinate(left_11
							+ margin_LeftToItem_11, Point_device_11.y
							+ margin_NameToItem_11);
					Font font_p_11 = new Font("微软雅黑", Font.BOLD, 7);
					drawString(g2, "产品型号:", Point_p_11, font_p_11);
	
					PointCoordinate Point_product_11 = new PointCoordinate(
							Point_p_11.x + (int) (font_p_11.getSize() * 4.5),
							Point_device_11.y + margin_NameToItem_11);
					switch (product.length()) {
	
					case 12:
						drawString(g2, product, Point_product_11, Font.BOLD, 5);
						break;
					case 11:
						drawString(g2, product, Point_product_11, Font.BOLD, 6);
						break;
					case 10:
						drawString(g2, product, Point_product_11, Font.BOLD, 6);
						break;
					case 9:
						drawString(g2, product, Point_product_11, Font.BOLD, 7);
						break;
					default:
						drawString(g2, product, Point_product_11, Font.BOLD, 7);
						break;
					}
	
					// draw voltage
					PointCoordinate Point_voltate_11 = new PointCoordinate(left_11
							+ margin_LeftToItem_11, Point_product_11.y
							+ margin_ItemToItem_11);
					drawString(g2, voltage, Point_voltate_11, Font.BOLD, 7);
	
					// draw power
					PointCoordinate Point_power_11 = new PointCoordinate(left_11
							+ margin_LeftToItem_11, Point_voltate_11.y
							+ margin_ItemToItem_11);
					drawString(g2, power, Point_power_11, Font.BOLD, 7);
	
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_11 = new
					 * PointCoordinate(left_11 + margin_LeftToItem_11,
					 * Point_power_11.y+margin_ItemToItem_11);
					 * drawString(g2,productSerialNO,Point_Serialno_11,
					 * Font.BOLD,7);
					 */
	
					// draw binaryCode
					File barCode_11 = new File("test_QR_CODE.png");
					Image src_11 = null;
					if (barCode_11.exists()) {
						try {
							src_11 = ImageIO.read(new FileInputStream(barCode_11));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate bar_left_top_11 = new PointCoordinate(left_11
							+ margin_LeftToItem_11 + margin_ItemToBarCode_11,
							PointLogo_11.y - 7);
					FourCornorsShowSize showSize_11 = new FourCornorsShowSize(60,
							68);
					PicShowSet picShowset_11 = new PicShowSet(50, 50, 5, 5);
					g2.setStroke(new BasicStroke(1.1f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_p_11, g2, bar_left_top_11, src_11, aid,
							passwd, showSize_11, picShowset_11).drawAll(
							LINE_LENGTH, -4, 0);
	
					PointCoordinate pointCircle_11_6 = new PointCoordinate(
							bar_left_top_11.x + margin_BarCodeToRight_11,
							(int) (2.2 * PrintFinal.INCH / 2.54) - 10);
					new MyCircle(g2, pointCircle_11_6, r_11, "输入L", font_11)
							.drawCircle(false, 0);
	
					PointCoordinate pointCircle_11_7 = new PointCoordinate(
							pointCircle_11_6.x, pointCircle_11_6.y + 20);
					new MyCircle(g2, pointCircle_11_7, r_11, "输入 N", font_11)
							.drawCircle(false, 0);
	
					// print hexAid
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 12, 10);
					}
					g2.rotate(Math.PI * 0.5);
					break;
	
				case 12:// 人体红外感应器
					int left__12 = (int) ((0 * PrintFinal.INCH / 2.54));
					int top__12 = (int) (0.3 * PrintFinal.INCH / 2.54 + 3);
					// draw logo_eastsoft
					PointCoordinate PointLogo_12 = new PointCoordinate(left__12+7,
							top__12+11);
					new MyLogo(g2, PointLogo_12).drawLogo(5f);
	
					// draw device
					PointCoordinate Point_device_12 = new PointCoordinate(left__12+7,
							PointLogo_12.y + margin_LogoToName_12);
					drawString(g2, device, Point_device_12, Font.BOLD, 10);
	
					// draw product
					PointCoordinate Point_p_12 = new PointCoordinate(left__12+7,
							Point_device_12.y + margin_NameToItem_12);
					Font font_p_12 = new Font("黑体", Font.PLAIN, 7);
					drawString(g2, "产品型号:", Point_p_12, font_p_12);
	
					PointCoordinate Point_product_12 = new PointCoordinate(
							Point_p_12.x + (int) (font_p_12.getSize() * 4.3),
							Point_device_12.y + margin_NameToItem_12);
					switch (product.length()) {
	
					case 12:
						drawString(g2, product, Point_product_12, Font.PLAIN, 6);
						break;
					case 11:
						drawString(g2, product, Point_product_12, Font.PLAIN, 7);
						break;
					case 10:
						drawString(g2, product, Point_product_12, Font.PLAIN, 7);
						break;
					case 9:
						drawString(g2, product, Point_product_12, Font.PLAIN, 7);
						break;
					default:
						drawString(g2, product, Point_product_12, Font.PLAIN, 7);
						break;
					}
	
					// draw voltage
					PointCoordinate Point_voltate_12 = new PointCoordinate(
							left__12+7, Point_product_12.y + margin_ItemToItem_12
									+ margin_ItemToItem_12);
					drawString(g2, voltage, Point_voltate_12,font_p_12);
	
					// draw 功耗。。。
					PointCoordinate Point_powerConsumption_12 = new PointCoordinate(
							left__12+7, Point_voltate_12.y + margin_ItemToItem_12
									+ margin_ItemToItem_12);
					drawString(g2, "功耗：<0.5W", Point_powerConsumption_12,
							font_p_12);
	
					/*
					 * //draw serialno PointCoordinate Point_Serialno_12 = new
					 * PointCoordinate(left__12,
					 * Point_powerConsumption_12.y+margin_ItemToItem_12
					 * +margin_ItemToItem_12);
					 * drawString(g2,productSerialNO,Point_Serialno_12,
					 * Font.PLAIN,7);
					 * 
					 * // draw 工作环境温度 PointCoordinate Point_temperature_12 = new
					 * PointCoordinate(left__12,
					 * Point_Serialno_12.y+margin_ItemToItem_12
					 * +margin_ItemToItem_12); drawString(g2,
					 * "工作环境温度：-10 ~ 40℃",Point_temperature_12, Font.PLAIN,7);
					 */
					// draw 工作环境温度
					PointCoordinate Point_temperature_12 = new PointCoordinate(
							left__12+7, Point_powerConsumption_12.y
									+ margin_ItemToItem_12 + margin_ItemToItem_12);
					drawString(g2, "工作环境温度：-10 ~ 40℃", Point_temperature_12,
							font_p_12);
	
					// draw serialno
					/*
					 * PointCoordinate Point_Serialno_12 = new
					 * PointCoordinate(left__12,
					 * Point_temperature_12.y+margin_ItemToItem_12
					 * +margin_ItemToItem_12);
					 * drawString(g2,productSerialNO,Point_Serialno_12,
					 * Font.PLAIN,7);
					 */
	
					// draw binaryCode
					File barCode_12 = new File("test_QR_CODE.png");
					Image src_12 = null;
					if (barCode_12.exists()) {
						try {
							src_12 = ImageIO.read(new FileInputStream(barCode_12));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_12 = new PointCoordinate(left__12
							+ (int) (2.2 * PrintFinal.INCH / 2.54 + 15),
							(int) (0.05 * PrintFinal.INCH / 2.54)+9);
					FourCornorsShowSize showSize_12 = new FourCornorsShowSize(47,
							55);
					PicShowSet picShowset_12 = new PicShowSet(40, 40, 2, 3);
					new MyBarCodeAll(new Font("微软雅黑", Font.BOLD, 6), g2,
							left_top_12, src_12, aid, passwd, showSize_12,
							picShowset_12).drawAll(LINE_LENGTH - 3, 0 - 1, 0);
	
					// print hexAid
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 70, 70);
					}
					break;
				case 13:
					// 平板网关适配器
					int left_13 = (int) (0.5 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft
					PointCoordinate PointLogo_13 = new PointCoordinate(left_13,
							(int) (0.5 * PrintFinal.INCH / 2.54)+6);
					new MyLogo(g2, PointLogo_13).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_13 = new PointCoordinate(
							left_13 - 2, PointLogo_13.y + margin_LogoToName_13);
					drawString_1(g2, device, Point_device_13, Font.BOLD, 10);
	
					// draw product
					PointCoordinate Point_p_13 = new PointCoordinate(left_13,
							Point_device_13.y + margin_NameToItem_13);
					Font font_p_13 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "产品型号： ", Point_p_13, font_p_13);
	
					PointCoordinate Point_product_13 = new PointCoordinate(
							Point_p_13.x + (int) (font_p_13.getSize() * 4.3 + 6),
							Point_device_13.y + margin_NameToItem_13);
					drawString_1(g2, product, Point_product_13, Font.BOLD, 7);
	
					// draw voltage
					PointCoordinate Point_voltate_13 = new PointCoordinate(left_13,
							Point_product_13.y + margin_ItemToItem_13);
					drawString_1(g2, voltage, Point_voltate_13, Font.BOLD, 7);
					// draw current
					PointCoordinate Point_current_13 = new PointCoordinate(left_13,
							Point_voltate_13.y + margin_ItemToItem_13);
					drawString_1(g2, current, Point_current_13, Font.BOLD, 7);
	
					break;
				case 14:
					// RGB调光控制器_正
					int left_14 = (int) (0.5 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft
					PointCoordinate PointLogo_14 = new PointCoordinate(left_14 + 3,
							(int) (0.4 * PrintFinal.INCH / 2.54)+7);
					new MyLogo(g2, PointLogo_14).drawLogo(5.1f);
					int top_14 = (int) (0.3 * PrintFinal.INCH / 2.54);
					Font font_14 = new Font("黑体", Font.BOLD, 7);
					Font font_14_1 = new Font("黑体", Font.BOLD, 6);
					// draw left
					int left_14_1 = left_14 - 12;
					int r_14 = 5;
					int left_right_margin_14 = 7;
	
					PointCoordinate pointCircle_14_1 = new PointCoordinate(
							left_14_1+4, PointLogo_14.y + margin_LogoToName_14);
					new MyCircle(g2, pointCircle_14_1, r_14, "5：公共端", font_14)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_14_2 = new PointCoordinate(
							left_14_1+4, pointCircle_14_1.y + margin_ItemToItem_14);
					new MyCircle(g2, pointCircle_14_2, r_14, "4：+12V", font_14)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_14_3 = new PointCoordinate(
							left_14_1+4, pointCircle_14_2.y + margin_ItemToItem_14);
					new MyCircle(g2, pointCircle_14_3, r_14, "3：B", font_14)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_14_4 = new PointCoordinate(
							left_14_1+4, pointCircle_14_3.y + margin_ItemToItem_14);
					new MyCircle(g2, pointCircle_14_4, r_14, "2：G", font_14)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_14_5 = new PointCoordinate(
							left_14_1+4, pointCircle_14_4.y + margin_ItemToItem_14);
					new MyCircle(g2, pointCircle_14_5, r_14, "1：R", font_14)
							.drawCircle(true, 0);
	
					// draw binaryCode
					File barCode_14 = new File("test_QR_CODE.png");
					Image src_14 = null;
					if (barCode_14.exists()) {
						try {
							src_14 = ImageIO.read(new FileInputStream(barCode_14));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_14 = new PointCoordinate(
							(int) (left_14 + PrintFinal.INCH / 2.54 + 15),
							PointLogo_14.y + margin_LogoToName_14);
					FourCornorsShowSize showSize_14 = new FourCornorsShowSize(44,
							50);
					PicShowSet picShowset_14 = new PicShowSet(35, 35, 2, 4);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_14_1, g2, left_top_14, src_14, aid,
							passwd, showSize_14, picShowset_14).drawAll(
							LINE_LENGTH - 2, 3, 0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 6);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					break;
				case 15:
					// RGB调光控制器_反面
					int left_15 = (int) (0.8 * PrintFinal.INCH / 2.54);
					int left_15_1 = left_15 - 17;
					Font font_15 = new Font("黑体", Font.BOLD, 7);
					int top_15 = (int) (0.6 * PrintFinal.INCH / 2.54);
					// // draw logo_eastsoft
					// PointCoordinate PointLogo_15 = new PointCoordinate(left_13 +
					// 1,
					// (int) (0.8 * PrintFinal.INCH / 2.54));
					// new MyLogo(g2, PointLogo_13).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_15 = new PointCoordinate(
							left_15 - 2, (int) (0.4 * PrintFinal.INCH / 2.54)+7);
					;
					drawString_1(g2, device.substring(0, 8), Point_device_15,
							Font.BOLD, 10);
	
					// draw product
					PointCoordinate Point_p_15 = new PointCoordinate(left_15_1+3,
							Point_device_15.y + margin_LogoToName_15);
					Font font_p_15 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "产品型号： ", Point_p_15, font_p_15);
	
					PointCoordinate Point_product_15 = new PointCoordinate(
							left_15_1+3, Point_p_15.y + margin_ItemToItem_15);
					drawString_1(g2, product, Point_product_15, Font.BOLD, 7);
	
					// draw voltage
					PointCoordinate Point_v_15 = new PointCoordinate(left_15_1+3,
							Point_product_15.y + margin_NameToItem_15);
					Font font_v_15 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定电压： ", Point_v_15, font_v_15);
	
					PointCoordinate Point_voltage_15 = new PointCoordinate(
							left_15_1+3, Point_v_15.y + margin_ItemToItem_15);
					drawString_1(g2, voltage_1, Point_voltage_15, Font.BOLD, 7);
					// // draw current
					// PointCoordinate Point_current_13 = new
					// PointCoordinate(left_13,
					// Point_voltate_13.y + margin_ItemToItem_13);
					// drawString(g2, current, Point_current_13, Font.PLAIN, 7);
					// draw power
					PointCoordinate Point_w_15 = new PointCoordinate(left_15_1+3,
							Point_voltage_15.y + margin_NameToItem_15);
					Font font_w_15 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定功率： ", Point_w_15, font_w_15);
	
					PointCoordinate Point_power_15 = new PointCoordinate(left_15_1+3,
							Point_w_15.y + margin_ItemToItem_15);
					drawString_1(g2, power, Point_power_15, Font.BOLD, 7);
					// draw right
					int left_15_2 = left_15 + 22;
					int r_15 = 4;
					int left_right_margin_15 = 12;
					int right_item_margin_15 = 14;
	
					PointCoordinate pointCircle_15_1 = new PointCoordinate(
							left_15_2 + Point_w_15.x
									+ (int) (font_w_15.getSize() * 4.3),
							Point_device_15.y + margin_ItemToItem_15);
					new MyCircle(g2, pointCircle_15_1, r_15, "L ：输入L", font_15)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_15_2 = new PointCoordinate(
							left_15_2 + Point_w_15.x
									+ (int) (font_w_15.getSize() * 4.3),
							pointCircle_15_1.y + right_item_margin_15);
					new MyCircle(g2, pointCircle_15_2, r_15, "N ：输入N", font_15)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_15_3 = new PointCoordinate(
							left_15_2 + Point_w_15.x
									+ (int) (font_w_15.getSize() * 4.3),
							pointCircle_15_2.y + right_item_margin_15);
					new MyCircle(g2, pointCircle_15_3, r_15, "I ：输出L", font_15)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_15_4 = new PointCoordinate(
							left_15_2 + Point_w_15.x
									+ (int) (font_w_15.getSize() * 4.3),
							pointCircle_15_3.y + right_item_margin_15);
					new MyCircle(g2, pointCircle_15_4, r_15, "II：输出N", font_15)
							.drawCircle_1(false, 0);
	
					// PointCoordinate pointCircle_15_5 = new
					// PointCoordinate(left_15_2+Point_w_15.x + (int)
					// (font_w_15.getSize() * 4.3),
					// pointCircle_15_4.y + left_right_margin_15);
					// new MyCircle(g2, pointCircle_15_5, r_15, "1:R", font_15)
					// .drawCircle(false, 0);
	
					break;
				case 16:
					// 窗帘控制器_正
					int left_16 = (int) (0.5 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft
					PointCoordinate PointLogo_16 = new PointCoordinate(left_16 + 3,
							(int) (0.4 * PrintFinal.INCH / 2.54+8));
					new MyLogo(g2, PointLogo_16).drawLogo(5.1f);
					int top_16 = (int) (0.3 * PrintFinal.INCH / 2.54);
					Font font_16 = new Font("黑体", Font.BOLD, 7);
					Font font_16_1 = new Font("黑体", Font.BOLD, 6);
					// draw left
					int left_16_1 = left_16 - 12;
					int r_16 = 5;
					int left_right_margin_16 = 7;
	
					PointCoordinate pointCircle_16_1 = new PointCoordinate(
							left_16_1+3, PointLogo_16.y + margin_LogoToName_16);
					new MyCircle(g2, pointCircle_16_1, r_16, "5：公共端", font_16)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_16_2 = new PointCoordinate(
							left_16_1+3, pointCircle_16_1.y + margin_ItemToItem_16);
					new MyCircle(g2, pointCircle_16_2, r_16, "4：NC", font_16)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_16_3 = new PointCoordinate(
							left_16_1+3, pointCircle_16_2.y + margin_ItemToItem_16);
					new MyCircle(g2, pointCircle_16_3, r_16, "3：输出端合", font_16)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_16_4 = new PointCoordinate(
							left_16_1+3, pointCircle_16_3.y + margin_ItemToItem_16);
					new MyCircle(g2, pointCircle_16_4, r_16, "2：NC", font_16)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_16_5 = new PointCoordinate(
							left_16_1+3, pointCircle_16_4.y + margin_ItemToItem_16);
					new MyCircle(g2, pointCircle_16_5, r_16, "1：输出端开", font_16)
							.drawCircle(true, 0);
	
					// draw binaryCode
					File barCode_16 = new File("test_QR_CODE.png");
					Image src_16 = null;
					if (barCode_16.exists()) {
						try {
							src_16 = ImageIO.read(new FileInputStream(barCode_16));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_16 = new PointCoordinate(
							(int) (left_16 + PrintFinal.INCH / 2.54 + 15),
							PointLogo_16.y + margin_LogoToName_16);
					FourCornorsShowSize showSize_16 = new FourCornorsShowSize(44,
							50);
					PicShowSet picShowset_16 = new PicShowSet(35, 35, 2, 4);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_16_1, g2, left_top_16, src_16, aid,
							passwd, showSize_16, picShowset_16).drawAll(
							LINE_LENGTH - 2, 3, 0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 6);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					break;
				case 17:
					// 窗帘控制器_反面
					int left_17 = (int) (0.8 * PrintFinal.INCH / 2.54);
					int left_17_1 = left_17 - 17;
					Font font_17 = new Font("黑体", Font.BOLD, 7);
					int top_17 = (int) (0.6 * PrintFinal.INCH / 2.54);
					// // draw logo_eastsoft
					// PointCoordinate PointLogo_15 = new PointCoordinate(left_13 +
					// 1,
					// (int) (0.8 * PrintFinal.INCH / 2.54));
					// new MyLogo(g2, PointLogo_13).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_17 = new PointCoordinate(
							left_17 + 3, (int) (0.4 * PrintFinal.INCH / 2.54)+6);
					;
					drawString_1(g2, device.substring(0, 5), Point_device_17,
							Font.BOLD, 10);
	
					// draw product
					PointCoordinate Point_p_17 = new PointCoordinate(left_17_1+3,
							Point_device_17.y + margin_LogoToName_17);
					Font font_p_17 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "产品型号： ", Point_p_17, font_p_17);
	
					PointCoordinate Point_product_17 = new PointCoordinate(
							left_17_1+3, Point_p_17.y + margin_ItemToItem_17);
					drawString_1(g2, product, Point_product_17, Font.BOLD, 7);
	
					// draw voltage
					PointCoordinate Point_v_17 = new PointCoordinate(left_17_1+3,
							Point_product_17.y + margin_NameToItem_17);
					Font font_v_17 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定电压： ", Point_v_17, font_v_17);
	
					PointCoordinate Point_voltage_17 = new PointCoordinate(
							left_17_1+3, Point_v_17.y + margin_ItemToItem_17);
					drawString_1(g2, voltage_1, Point_voltage_17, Font.BOLD, 7);
					// // draw current
					// PointCoordinate Point_current_13 = new
					// PointCoordinate(left_13,
					// Point_voltate_13.y + margin_ItemToItem_13);
					// drawString(g2, current, Point_current_13, Font.PLAIN, 7);
					// draw power
					PointCoordinate Point_w_17 = new PointCoordinate(left_17_1+3,
							Point_voltage_17.y + margin_NameToItem_17);
					Font font_w_17 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定功率： ", Point_w_17, font_w_17);
	
					PointCoordinate Point_power_17 = new PointCoordinate(left_17_1+3,
							Point_w_17.y + margin_ItemToItem_17);
					drawString_1(g2, power, Point_power_17, Font.BOLD, 7);
					// draw right
					int left_17_2 = left_17 + 22;
					int r_17 = 4;
					int left_right_margin_17 = 12;
					int right_item_margin_17 = 14;
	
					PointCoordinate pointCircle_17_1 = new PointCoordinate(
							left_17_2 + Point_w_17.x
									+ (int) (font_w_17.getSize() * 4.3),
							Point_device_17.y + margin_ItemToItem_17);
					new MyCircle(g2, pointCircle_17_1, r_17, "L ：输入L", font_17)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_17_2 = new PointCoordinate(
							left_17_2 + Point_w_17.x
									+ (int) (font_w_17.getSize() * 4.3),
							pointCircle_17_1.y + right_item_margin_17);
					new MyCircle(g2, pointCircle_17_2, r_17, "N ：输入N", font_17)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_17_3 = new PointCoordinate(
							left_17_2 + Point_w_17.x
									+ (int) (font_w_17.getSize() * 4.3),
							pointCircle_17_2.y + right_item_margin_17);
					new MyCircle(g2, pointCircle_17_3, r_17, "I ：NC", font_17)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_17_4 = new PointCoordinate(
							left_17_2 + Point_w_17.x
									+ (int) (font_w_17.getSize() * 4.3),
							pointCircle_17_3.y + right_item_margin_17);
					new MyCircle(g2, pointCircle_17_4, r_17, "II：NC", font_17)
							.drawCircle_1(false, 0);
	
					// PointCoordinate pointCircle_15_5 = new
					// PointCoordinate(left_15_2+Point_w_15.x + (int)
					// (font_w_15.getSize() * 4.3),
					// pointCircle_15_4.y + left_right_margin_15);
					// new MyCircle(g2, pointCircle_15_5, r_15, "1:R", font_15)
					// .drawCircle(false, 0);
	
					break;
				case 18:
					// 灯光控制器_正
					//灯光控制器位置调整
					int left_18 = (int) (0.5 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft
					PointCoordinate PointLogo_18 = new PointCoordinate(left_18 + 3,
							(int) (0.4 * PrintFinal.INCH / 2.54)+7);
					new MyLogo(g2, PointLogo_18).drawLogo(5.1f);
					int top_18 = (int) (0.3 * PrintFinal.INCH / 2.54);
					Font font_18 = new Font("黑体", Font.BOLD, 7);
					Font font_18_1 = new Font("黑体", Font.BOLD, 6);
					// draw left
					int left_18_1 = left_18 - 12;
					int r_18 = 5;
					int left_right_margin_18 = 7;
	
					PointCoordinate pointCircle_18_1 = new PointCoordinate(
							left_18_1+4, PointLogo_18.y + margin_LogoToName_18);
					new MyCircle(g2, pointCircle_18_1, r_18, "5：灯2L", font_18)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_18_2 = new PointCoordinate(
							left_18_1+4, pointCircle_18_1.y + margin_ItemToItem_18);
					new MyCircle(g2, pointCircle_18_2, r_18, "4：NC", font_18)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_18_3 = new PointCoordinate(
							left_18_1+4, pointCircle_18_2.y + margin_ItemToItem_18);
					new MyCircle(g2, pointCircle_18_3, r_18, "3：灯1L", font_18)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_18_4 = new PointCoordinate(
							left_18_1+4, pointCircle_18_3.y + margin_ItemToItem_18);
					new MyCircle(g2, pointCircle_18_4, r_18, "2：NC", font_18)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_18_5 = new PointCoordinate(
							left_18_1+4, pointCircle_18_4.y + margin_ItemToItem_18);
					new MyCircle(g2, pointCircle_18_5, r_18, "1：公共端N", font_18)
							.drawCircle(true, 0);
	
					// draw binaryCode
					File barCode_18 = new File("test_QR_CODE.png");
					Image src_18 = null;
					if (barCode_18.exists()) {
						try {
							src_18 = ImageIO.read(new FileInputStream(barCode_18));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_18 = new PointCoordinate(
							(int) (left_18 + PrintFinal.INCH / 2.54 + 15),
							PointLogo_18.y + margin_LogoToName_18);
					FourCornorsShowSize showSize_18 = new FourCornorsShowSize(44,
							50);
					PicShowSet picShowset_18 = new PicShowSet(35, 35, 2, 4);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_18_1, g2, left_top_18, src_18, aid,
							passwd, showSize_18, picShowset_18).drawAll(
							LINE_LENGTH - 2, 3, 0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.BOLD, 7);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					break;
				case 19:
					// 灯光控制器_反面
					int left_19 = (int) (0.8 * PrintFinal.INCH / 2.54);
					int left_19_1 = left_19 - 17;
					Font font_19 = new Font("黑体", Font.BOLD, 7);
					int top_19 = (int) (0.6 * PrintFinal.INCH / 2.54);
					// // draw logo_eastsoft
					// PointCoordinate PointLogo_15 = new PointCoordinate(left_13 +
					// 1,
					// (int) (0.8 * PrintFinal.INCH / 2.54));
					// new MyLogo(g2, PointLogo_13).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_19 = new PointCoordinate(
							left_19 + 3, (int) (0.4 * PrintFinal.INCH / 2.54)+7);
					;
					drawString_1(g2, device.substring(0, 5), Point_device_19,
							Font.BOLD, 10);
	
					// draw product
					PointCoordinate Point_p_19 = new PointCoordinate(left_19_1+3,
							Point_device_19.y + margin_LogoToName_19);
					Font font_p_19 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "产品型号： ", Point_p_19, font_p_19);
	
					PointCoordinate Point_product_19 = new PointCoordinate(
							left_19_1+3, Point_p_19.y + margin_ItemToItem_19);
					drawString_1(g2, product, Point_product_19, Font.BOLD, 7);
	
					// draw voltage
					PointCoordinate Point_v_19 = new PointCoordinate(left_19_1+3,
							Point_product_19.y + margin_NameToItem_19);
					Font font_v_19 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定电压： ", Point_v_19, font_v_19);
	
					PointCoordinate Point_voltage_19 = new PointCoordinate(
							left_19_1+3, Point_v_19.y + margin_ItemToItem_19);
					drawString_1(g2, voltage_1, Point_voltage_19, Font.BOLD, 7);
					// // draw current
					PointCoordinate Point_c_19 = new PointCoordinate(left_19_1+3,
							Point_voltage_19.y + margin_NameToItem_19);
					Font font_c_19 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定电流： ", Point_c_19, font_c_19);
	
					PointCoordinate Point_cuttent_19 = new PointCoordinate(
							left_19_1+3, Point_c_19.y + margin_ItemToItem_19);
					drawString_1(g2, current_1, Point_cuttent_19, Font.BOLD, 7);
					// // draw power
					// PointCoordinate Point_w_19 = new PointCoordinate(left_19_1,
					// Point_voltage_19.y + margin_NameToItem_19);
					// Font font_w_19 = new Font("微软雅黑", Font.PLAIN, 7);
					// drawString(g2, "额定功率： ", Point_w_19, font_w_19);
					//
					// PointCoordinate Point_power_19 = new PointCoordinate(
					// left_19_1,
					// Point_w_19.y + margin_ItemToItem_19);
					// drawString(g2, power, Point_power_19, Font.PLAIN, 7);
					// draw right
					int left_19_2 = left_19 + 22;
					int r_19 = 4;
					int left_right_margin_19 = 12;
					int right_item_margin_19 = 14;
	
					PointCoordinate pointCircle_19_1 = new PointCoordinate(
							left_19_2 + Point_v_19.x
									+ (int) (font_v_19.getSize() * 4.3),
							Point_device_19.y + margin_ItemToItem_19);
					new MyCircle(g2, pointCircle_19_1, r_19, "L ：输入L", font_19)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_19_2 = new PointCoordinate(
							left_19_2 + Point_v_19.x
									+ (int) (font_v_19.getSize() * 4.3),
							pointCircle_19_1.y + right_item_margin_19);
					new MyCircle(g2, pointCircle_19_2, r_19, "N ：输入N", font_19)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_19_3 = new PointCoordinate(
							left_19_2 + Point_v_19.x
									+ (int) (font_v_19.getSize() * 4.3),
							pointCircle_19_2.y + right_item_margin_19);
					new MyCircle(g2, pointCircle_19_3, r_19, "I ：NC", font_19)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_19_4 = new PointCoordinate(
							left_19_2 + Point_v_19.x
									+ (int) (font_v_19.getSize() * 4.3),
							pointCircle_19_3.y + right_item_margin_19);
					new MyCircle(g2, pointCircle_19_4, r_19, "II：NC", font_19)
							.drawCircle_1(false, 0);
	
					// PointCoordinate pointCircle_15_5 = new
					// PointCoordinate(left_15_2+Point_w_15.x + (int)
					// (font_w_15.getSize() * 4.3),
					// pointCircle_15_4.y + left_right_margin_15);
					// new MyCircle(g2, pointCircle_15_5, r_15, "1:R", font_15)
					// .drawCircle(false, 0);
	
					break;
				case 20:
					// 调光控制器_正
					int left_20 = (int) (0.5 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft
					PointCoordinate PointLogo_20 = new PointCoordinate(left_20 + 3,
							(int) (0.4 * PrintFinal.INCH / 2.54)+4);
					new MyLogo(g2, PointLogo_20).drawLogo(5.1f);
					int top_20 = (int) (0.3 * PrintFinal.INCH / 2.54);
					Font font_20 = new Font("黑体", Font.BOLD, 7);
					Font font_20_1 = new Font("黑体", Font.BOLD, 6);
					// draw left
					int left_20_1 = left_20 - 12;
					int r_20 = 5;
					int left_right_margin_20 = 7;
					PointCoordinate pointCircle_20_1 = new PointCoordinate(
							left_20_1+2, PointLogo_20.y + margin_LogoToName_20);
					new MyCircle(g2, pointCircle_20_1, r_20, "5：PWM(0-10V)",
							font_20).drawCircle_1(true, 0);
	
					PointCoordinate pointCircle_20_2 = new PointCoordinate(
							left_20_1+2, pointCircle_20_1.y + margin_ItemToItem_20);
					new MyCircle(g2, pointCircle_20_2, r_20, "4：GND/公共端", font_20)
							.drawCircle_1(true, 0);
	
					PointCoordinate pointCircle_20_3 = new PointCoordinate(
							left_20_1+2, pointCircle_20_2.y + margin_ItemToItem_20);
					new MyCircle(g2, pointCircle_20_3, r_20, "3：NC", font_20)
							.drawCircle_1(true, 0);
	
					PointCoordinate pointCircle_20_4 = new PointCoordinate(
							left_20_1+2, pointCircle_20_3.y + margin_ItemToItem_20);
					new MyCircle(g2, pointCircle_20_4, r_20, "2：NC", font_20)
							.drawCircle_1(true, 0);
	
					PointCoordinate pointCircle_20_5 = new PointCoordinate(
							left_20_1+2, pointCircle_20_4.y + margin_ItemToItem_20);
					new MyCircle(g2, pointCircle_20_5, r_20, "1：NC", font_20)
							.drawCircle_1(true, 0);
	
					// draw binaryCode
					File barCode_20 = new File("test_QR_CODE.png");
					Image src_20 = null;
					if (barCode_20.exists()) {
						try {
							src_20 = ImageIO.read(new FileInputStream(barCode_20));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					//wangrichoa 二维码位置调整
					PointCoordinate left_top_20 = new PointCoordinate(
							(int) (left_20 + PrintFinal.INCH / 2.54 + 21),
							PointLogo_20.y + margin_LogoToName_20);
					FourCornorsShowSize showSize_20 = new FourCornorsShowSize(44,
							50);
					PicShowSet picShowset_20 = new PicShowSet(35, 35, 2, 4);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_20_1, g2, left_top_20, src_20, aid,
							passwd, showSize_20, picShowset_20).drawAll(
							LINE_LENGTH - 2, 3, 0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 6);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					break;
				case 21:
					// 调光控制器_反面
					int left_21 = (int) (0.8 * PrintFinal.INCH / 2.54);
					int left_21_1 = left_21 - 17;
					Font font_21 = new Font("黑体", Font.BOLD, 7);
					int top_21 = (int) (0.6 * PrintFinal.INCH / 2.54);
					// // draw logo_eastsoft
					// PointCoordinate PointLogo_15 = new PointCoordinate(left_13 +
					// 1,
					// (int) (0.8 * PrintFinal.INCH / 2.54));
					// new MyLogo(g2, PointLogo_13).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_21 = new PointCoordinate(
							left_21 + 3, (int) (0.4 * PrintFinal.INCH / 2.54)+4);
					;
					drawString_1(g2, device.substring(0, 5), Point_device_21,
							Font.BOLD, 10);
	
					// draw product
					PointCoordinate Point_p_21 = new PointCoordinate(left_21_1+2,
							Point_device_21.y + margin_LogoToName_21);
					Font font_p_21 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "产品型号： ", Point_p_21, font_p_21);
	
					PointCoordinate Point_product_21 = new PointCoordinate(
							left_21_1+2, Point_p_21.y + margin_ItemToItem_21);
					drawString_1(g2, product, Point_product_21, Font.BOLD, 6);
	
					// draw voltage
					PointCoordinate Point_v_21 = new PointCoordinate(left_21_1+2,
							Point_product_21.y + margin_NameToItem_21);
					Font font_v_21 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定电压： ", Point_v_21, font_v_21);
	
					PointCoordinate Point_voltage_21 = new PointCoordinate(
							left_21_1+2, Point_v_21.y + margin_ItemToItem_21);
					drawString_1(g2, voltage_1, Point_voltage_21, Font.BOLD, 7);
					// // // draw current
					// PointCoordinate Point_c_21 = new PointCoordinate(left_21_1,
					// Point_voltage_21.y + margin_NameToItem_21);
					// Font font_c_21 = new Font("微软雅黑", Font.PLAIN, 7);
					// drawString(g2, "额定电流： ", Point_c_21, font_c_21);
					//
					// PointCoordinate Point_cuttent_21 = new PointCoordinate(
					// left_21_1,
					// Point_c_21.y + margin_ItemToItem_21);
					// drawString(g2, current_1, Point_cuttent_21, Font.PLAIN, 7);
					// // draw power
					PointCoordinate Point_w_21 = new PointCoordinate(left_21_1+2,
							Point_voltage_21.y + margin_NameToItem_21);
					Font font_w_21 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定功率： ", Point_w_21, font_w_21);
	
					PointCoordinate Point_power_21 = new PointCoordinate(left_21_1+2,
							Point_w_21.y + margin_ItemToItem_21);
					drawString_1(g2, power, Point_power_21, Font.BOLD, 7);
					// draw right
					int left_21_2 = left_21 + 22;
					int r_21 = 4;
					int left_right_margin_21 = 12;
					int right_item_margin_21 = 14;
	
					PointCoordinate pointCircle_21_1 = new PointCoordinate(
							left_21_2 + Point_v_21.x
									+ (int) (font_v_21.getSize() * 4.3),
							Point_device_21.y + margin_ItemToItem_21);
					new MyCircle(g2, pointCircle_21_1, r_21, "L ：输入L", font_21)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_21_2 = new PointCoordinate(
							left_21_2 + Point_v_21.x
									+ (int) (font_v_21.getSize() * 4.3),
							pointCircle_21_1.y + right_item_margin_21);
					new MyCircle(g2, pointCircle_21_2, r_21, "N ：输入N", font_21)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_21_3 = new PointCoordinate(
							left_21_2 + Point_v_21.x
									+ (int) (font_v_21.getSize() * 4.3),
							pointCircle_21_2.y + right_item_margin_21);
					new MyCircle(g2, pointCircle_21_3, r_21, "I ：输出L", font_21)
							.drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_21_4 = new PointCoordinate(
							left_21_2 + Point_v_21.x
									+ (int) (font_v_21.getSize() * 4.3),
							pointCircle_21_3.y + right_item_margin_21);
					new MyCircle(g2, pointCircle_21_4, r_21, "II：输出N", font_21)
							.drawCircle_1(false, 0);
	
					// PointCoordinate pointCircle_15_5 = new
					// PointCoordinate(left_15_2+Point_w_15.x + (int)
					// (font_w_15.getSize() * 4.3),
					// pointCircle_15_4.y + left_right_margin_15);
					// new MyCircle(g2, pointCircle_15_5, r_15, "1:R", font_15)
					// .drawCircle(false, 0);
	
					break;
				case 22:
					// 人体红外感应器新
					Font font_es22 = new Font("黑体", Font.BOLD, 8);
					Font font_r22 = new Font("黑体", Font.BOLD, 8);
	
					int left_22 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 12);
					int top_22 = (int) (0.6 * PrintFinal.INCH / 2.54)+5;
					// draw logo_eastsoft
					PointCoordinate PointLogo_22 = new PointCoordinate(left_22+3,
							top_22);
					// new MyLogo(g2, PointLogo_22, font_es22,
					// font_r22).drawLogo(5.1f);
					new MyLogo(g2, PointLogo_22).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_22 = new PointCoordinate(left_22+3,
							PointLogo_22.y + margin_LogoToName_22);
					drawString_1(g2, device.substring(0, 7), Point_device_22,
							font_es22);
	
					// draw product
					PointCoordinate Point_p_22 = new PointCoordinate(left_22+3,
							Point_device_22.y + margin_NameToItem_22);
					Font font_p_22 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "产品型号：", Point_p_22, font_p_22);
	
					PointCoordinate Point_product_22 = new PointCoordinate(
							Point_p_22.x + (int) (font_p_22.getSize() * 4.4) + 3,
							Point_device_22.y + margin_NameToItem_22);
					drawString_1(g2, product, Point_product_22, Font.BOLD, 7);
					// switch (product.length()) {
					//
					// case 12:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 11:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 10:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 9:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 6);
					// break;
					// default:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 6);
					// break;
					// }
	
					// draw voltage
					PointCoordinate Point_v_22 = new PointCoordinate(left_22+3,
							Point_product_22.y + margin_ItemToItem_22);
					Font font_v_22 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定电压：", Point_v_22, font_v_22);
					PointCoordinate Point_voltate_22 = new PointCoordinate(
							Point_v_22.x + (int) (font_p_22.getSize() * 4.4) + 3,
							Point_product_22.y + margin_ItemToItem_22);
					drawString_1(g2, voltage_1, Point_voltate_22, Font.BOLD, 7);
	
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_2 = new
					 * PointCoordinate(left__2,
					 * Point_voltate_2.y+margin_ItemToItem_2);
					 * drawString(g2,productSerialNO,Point_Serialno_2,
					 * Font.PLAIN,6);
					 */
	
					// draw binaryCode
					File barCode_22 = new File("test_QR_CODE.png");
					Image src_22 = null;
					if (barCode_22.exists()) {
						try {
							src_22 = ImageIO.read(new FileInputStream(barCode_22));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_22 = new PointCoordinate(
							(int) (left_22 + 2 * PrintFinal.INCH / 2.54) + 10,
							top_22 - 5);
					FourCornorsShowSize showSize_22 = new FourCornorsShowSize(40,
							50);
					PicShowSet picShowset_22 = new PicShowSet(35, 35, 2, 2);
					Font font_22 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_22, g2, left_top_22, src_22, aid, passwd,
							showSize_22, picShowset_22).drawAll(LINE_LENGTH - 2, 3,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
	
					break;
				case 23:
					// 电源控制模块新
					Font font_es23 = new Font("微软雅黑", Font.BOLD, 10);
					Font font_r23 = new Font("黑体", Font.BOLD, 8);
	
					int left_23 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 12);
					int top_23 = (int) (0.6 * PrintFinal.INCH / 2.54)+2;
					// draw logo_eastsoft
					PointCoordinate PointLogo_23 = new PointCoordinate(left_23+3,
							top_23+5);
					// new MyLogo(g2, PointLogo_22, font_es22,
					// font_r22).drawLogo(5.1f);
					new MyLogo(g2, PointLogo_23).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_23 = new PointCoordinate(left_23+3,
							PointLogo_23.y + margin_LogoToName_23);
					drawString_1(g2, device.substring(0, 6), Point_device_23,
							Font.BOLD, 9);
	
					// draw product
					PointCoordinate Point_p_23 = new PointCoordinate(left_23+3,
							Point_device_23.y + margin_NameToItem_23);
					Font font_p_23 = new Font("黑体", Font.BOLD, 8);
					drawString_1(g2, "产品型号：", Point_p_23, font_p_23);
	
					PointCoordinate Point_product_23 = new PointCoordinate(
							Point_p_23.x + (int) (font_p_23.getSize() * 4.4) + 3,
							Point_device_23.y + margin_NameToItem_23);
					drawString_1(g2, product, Point_product_23, Font.BOLD, 7);
					// switch (product.length()) {
					//
					// case 12:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 11:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 10:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 9:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 6);
					// break;
					// default:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 6);
					// break;
					// }
	
					// draw voltage
					PointCoordinate Point_v_23 = new PointCoordinate(left_23+3,
							Point_product_23.y + margin_ItemToItem_23);
					Font font_v_23 = new Font("黑体", Font.BOLD, 8);
					drawString_1(g2, "额定电压：", Point_v_23, font_v_23);
					PointCoordinate Point_voltate_23 = new PointCoordinate(
							Point_v_23.x + (int) (font_p_23.getSize() * 4.4) + 3,
							Point_product_23.y + margin_ItemToItem_23);
					drawString_1(g2, voltage_1, Point_voltate_23, Font.BOLD, 7);
	
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_2 = new
					 * PointCoordinate(left__2,
					 * Point_voltate_2.y+margin_ItemToItem_2);
					 * drawString(g2,productSerialNO,Point_Serialno_2,
					 * Font.PLAIN,6);
					 */
	
					// draw binaryCode
					File barCode_23 = new File("test_QR_CODE.png");
					Image src_23 = null;
					if (barCode_23.exists()) {
						try {
							src_23 = ImageIO.read(new FileInputStream(barCode_23));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_23 = new PointCoordinate(
							(int) (left_23 + 2 * PrintFinal.INCH / 2.54) + 9,
							top_23 - 3);
					FourCornorsShowSize showSize_23 = new FourCornorsShowSize(40,
							50);
					PicShowSet picShowset_23 = new PicShowSet(35, 35, 2, 2);
					Font font_23 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_23, g2, left_top_23, src_23, aid, passwd,
							showSize_23, picShowset_23).drawAll(LINE_LENGTH - 2, 3,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
	
					break;
				case 24:
					// 红外转发器新
					Font font_es24 = new Font("微软雅黑", Font.BOLD, 10);
					Font font_r24 = new Font("黑体", Font.BOLD, 8);
	
					int left_24 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 12);
					int top_24 = (int) (0.6 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft
					PointCoordinate PointLogo_24 = new PointCoordinate(left_24+3,
							top_24+6);
					// new MyLogo(g2, PointLogo_22, font_es22,
					// font_r22).drawLogo(5.1f);
					new MyLogo(g2, PointLogo_24).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_24 = new PointCoordinate(left_24+3,
							PointLogo_24.y + margin_LogoToName_24);
					drawString_1(g2, device.substring(0, 5), Point_device_24,
							Font.BOLD, 8);
	
					// draw product
					PointCoordinate Point_p_24 = new PointCoordinate(left_24+3,
							Point_device_24.y + margin_NameToItem_24);
					Font font_p_24 = new Font("黑体", Font.PLAIN, 7);
					drawString_1(g2, "产品型号：", Point_p_24, font_p_24);
	
					PointCoordinate Point_product_24 = new PointCoordinate(
							Point_p_24.x + (int) (font_p_24.getSize() * 4.4) + 6,
							Point_device_24.y + margin_NameToItem_24);
					drawString_1(g2, product, Point_product_24, Font.PLAIN, 7);
					// switch (product.length()) {
					//
					// case 12:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 11:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 10:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 9:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 6);
					// break;
					// default:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 6);
					// break;
					// }
	
					// draw voltage
					PointCoordinate Point_v_24 = new PointCoordinate(left_24+3,
							Point_product_24.y + margin_ItemToItem_24);
					Font font_v_24 = new Font("黑体", Font.PLAIN, 7);
					drawString_1(g2, "额定电压：", Point_v_24, font_v_24);
					PointCoordinate Point_voltate_24 = new PointCoordinate(
							Point_v_24.x + (int) (font_p_24.getSize() * 4.4) + 6,
							Point_product_24.y + margin_ItemToItem_24);
					drawString_1(g2, voltage_1, Point_voltate_24, Font.PLAIN, 7);
	
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_2 = new
					 * PointCoordinate(left__2,
					 * Point_voltate_2.y+margin_ItemToItem_2);
					 * drawString(g2,productSerialNO,Point_Serialno_2,
					 * Font.PLAIN,6);
					 */
	
					// draw binaryCode
					File barCode_24 = new File("test_QR_CODE.png");
					Image src_24 = null;
					if (barCode_24.exists()) {
						try {
							src_24 = ImageIO.read(new FileInputStream(barCode_24));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_24 = new PointCoordinate(
							(int) (left_24 + 2 * PrintFinal.INCH / 2.54) + 8,
							top_24 - 5+2);
					FourCornorsShowSize showSize_24 = new FourCornorsShowSize(40,
							50);
					PicShowSet picShowset_24 = new PicShowSet(35, 35, 2, 2);
					Font font_24 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_24, g2, left_top_24, src_24, aid, passwd,
							showSize_24, picShowset_24).drawAll(LINE_LENGTH - 2, 3,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
	
					break;
				case 25:
					// 智能插座新
					Font font_es25 = new Font("微软雅黑", Font.BOLD, 10);
					Font font_r25 = new Font("黑体", Font.BOLD, 8);
	
					int left_25 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 12);
					int top_25 = (int) (0.6 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft
					PointCoordinate PointLogo_25 = new PointCoordinate(left_25+2,
							top_25+5);
					// new MyLogo(g2, PointLogo_22, font_es22,
					// font_r22).drawLogo(5.1f);
					new MyLogo(g2, PointLogo_25).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_25 = new PointCoordinate(left_25+2,
							PointLogo_25.y + margin_LogoToName_25);
					drawString_1(g2, device.substring(0, 4), Point_device_25,
							Font.BOLD, 8);
	
					// draw product
					PointCoordinate Point_p_25 = new PointCoordinate(left_25+2,
							Point_device_25.y + margin_NameToItem_25);
					Font font_p_25 = new Font("黑体", Font.PLAIN, 7);
					drawString_1(g2, "产品型号：", Point_p_25, font_p_25);
	
					PointCoordinate Point_product_25 = new PointCoordinate(
							Point_p_25.x + (int) (font_p_25.getSize() * 4.4) + 3,
							Point_device_25.y + margin_NameToItem_25);
					drawString_1(g2, product, Point_product_25, Font.PLAIN, 7);
					// switch (product.length()) {
					//
					// case 12:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 11:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 10:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 9:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 6);
					// break;
					// default:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 6);
					// break;
					// }
	
					// draw voltage
					PointCoordinate Point_v_25 = new PointCoordinate(left_25+2,
							Point_product_25.y + margin_ItemToItem_25);
					Font font_v_25 = new Font("黑体", Font.PLAIN, 7);
					drawString_1(g2, "额定电压：", Point_v_25, font_v_25);
					PointCoordinate Point_voltate_25 = new PointCoordinate(
							Point_v_25.x + (int) (font_p_25.getSize() * 4.4) + 3,
							Point_product_25.y + margin_ItemToItem_25);
					drawString_1(g2, voltage_1, Point_voltate_25, Font.PLAIN, 7);
	
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_2 = new
					 * PointCoordinate(left__2,
					 * Point_voltate_2.y+margin_ItemToItem_2);
					 * drawString(g2,productSerialNO,Point_Serialno_2,
					 * Font.PLAIN,6);
					 */
	
					// draw binaryCode
					File barCode_25 = new File("test_QR_CODE.png");
					Image src_25 = null;
					if (barCode_25.exists()) {
						try {
							src_25 = ImageIO.read(new FileInputStream(barCode_25));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_25 = new PointCoordinate(
							(int) (left_25 + 2 * PrintFinal.INCH / 2.54) + 11,
							top_25);
					FourCornorsShowSize showSize_25 = new FourCornorsShowSize(39,
							50);
					PicShowSet picShowset_25 = new PicShowSet(35, 35, 2, 2);
					Font font_25 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_25, g2, left_top_25, src_25, aid, passwd,
							showSize_25, picShowset_25).drawAll(LINE_LENGTH - 2, 3,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
	
					break;
				case 26:
					// 智能网关新
					int offset = 6;
					if(StringUtils.isEmpty(company)){
						offset = -8;
					}
					int left_26 = (int) (0.5 * PrintFinal.INCH / 2.54)+5;
					// draw logo_eastsoft
					PointCoordinate PointLogo_26 = new PointCoordinate(left_26,
							(int) (0.5 * PrintFinal.INCH / 2.54)+offset);
					if("EASTSOFT".equals(company)){
						new MyLogo(g2, PointLogo_26).drawLogo(6f);
					}else{
						new MyLogo(g2, PointLogo_26).drawLogo(5.1f);
					}
					/***************/
	
					// draw device
					PointCoordinate Point_device_26 = new PointCoordinate(
							left_26+1, PointLogo_26.y + margin_LogoToName_26);
					drawString_1(g2, device.substring(0, 4), Point_device_26,
							Font.BOLD, 10);
	
					// draw product
					PointCoordinate Point_p_26 = new PointCoordinate(left_26,
							Point_device_26.y + margin_NameToItem_26);
					Font font_p_26 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "产品型号： ", Point_p_26, font_p_26);
	
					PointCoordinate Point_product_26 = new PointCoordinate(
							Point_p_26.x + (int) (font_p_26.getSize() * 4.3 + 6),
							Point_device_26.y + margin_NameToItem_26);
					drawString_1(g2, product, Point_product_26, Font.BOLD, 7);
	
					// draw voltage
					PointCoordinate Point_voltate_26 = new PointCoordinate(left_26,
							Point_product_26.y + margin_ItemToItem_26);
					drawString_1(g2, voltage, Point_voltate_26, Font.BOLD, 7);
					// draw numbgateway
					PointCoordinate Point_numbgateway_26 = new PointCoordinate(
							left_26, Point_voltate_26.y + margin_ItemToItem_26);
					
					if(StringUtils.isEmpty(gid)||"null".equals(gid)){
						gid = aid;
					}
					drawString_1(g2, "网关号码：" + gid, Point_numbgateway_26,
							Font.BOLD, 7);
	
					break;
				case 27:
					// 双轨窗帘控制器_正
					int left_27 = (int) (0.5 * PrintFinal.INCH / 2.54+5);
					// draw logo_eastsoft
					PointCoordinate PointLogo_27 = new PointCoordinate(left_27 + 3,
							(int) (0.4 * PrintFinal.INCH / 2.54)+6);
					new MyLogo(g2, PointLogo_27).drawLogo(5.1f);
					int top_27 = (int) (0.3 * PrintFinal.INCH / 2.54);
					Font font_27 = new Font("黑体", Font.BOLD, 7);
					Font font_27_1 = new Font("黑体", Font.BOLD, 6);
					// draw left
					int left_27_1 = left_27 - 12;
					int r_27 = 5;
					int left_right_margin_27 = 7;
	
					PointCoordinate pointCircle_27_1 = new PointCoordinate(
							left_27_1, PointLogo_27.y + margin_LogoToName_27);
					new MyCircle(g2, pointCircle_27_1, r_27, "电机1正向", font_27)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_27_2 = new PointCoordinate(
							left_27_1, pointCircle_27_1.y + margin_ItemToItem_27);
					new MyCircle(g2, pointCircle_27_2, r_27, "电机1反向", font_27)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_27_3 = new PointCoordinate(
							left_27_1, pointCircle_27_2.y + margin_ItemToItem_27);
					new MyCircle(g2, pointCircle_27_3, r_27, "电机2正向", font_27)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_27_4 = new PointCoordinate(
							left_27_1, pointCircle_27_3.y + margin_ItemToItem_27);
					new MyCircle(g2, pointCircle_27_4, r_27, "电机2反向", font_27)
							.drawCircle(true, 0);
	
					PointCoordinate pointCircle_27_5 = new PointCoordinate(
							left_27_1, pointCircle_27_4.y + margin_ItemToItem_27);
					new MyCircle(g2, pointCircle_27_5, r_27, "电机公共端", font_27)
							.drawCircle(true, 0);
	
					// draw binaryCode
					File barCode_27 = new File("test_QR_CODE.png");
					Image src_27 = null;
					if (barCode_27.exists()) {
						try {
							src_27 = ImageIO.read(new FileInputStream(barCode_27));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体
					PointCoordinate left_top_27 = new PointCoordinate(
							(int) (left_27 + PrintFinal.INCH / 2.54 + 15),
							PointLogo_27.y + margin_LogoToName_27);
					FourCornorsShowSize showSize_27 = new FourCornorsShowSize(44,
							50);
					PicShowSet picShowset_27 = new PicShowSet(35, 35, 2, 4);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_27_1, g2, left_top_27, src_27, aid,
							passwd, showSize_27, picShowset_27).drawAll(
							LINE_LENGTH - 2, 3, 0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 6);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					break;
				case 28:
					// 双轨窗帘控制器_反面
					int left_28 = (int) (0.8 * PrintFinal.INCH / 2.54);
					int left_28_1 = left_28 - 17;
					Font font_28 = new Font("黑体", Font.BOLD, 7);
					int top_28 = (int) (0.6 * PrintFinal.INCH / 2.54);
					// // draw logo_eastsoft
					// PointCoordinate PointLogo_15 = new PointCoordinate(left_13 +
					// 1,
					// (int) (0.8 * PrintFinal.INCH / 2.54));
					// new MyLogo(g2, PointLogo_13).drawLogo(5.1f);
	
					// draw device
					PointCoordinate Point_device_28 = new PointCoordinate(
							left_28 + 3, (int) (0.4 * PrintFinal.INCH / 2.54)+6);
					;
					drawString_1(g2, device.substring(0, 7), Point_device_28,
							Font.BOLD, 10);
	
					// draw product
					PointCoordinate Point_p_28 = new PointCoordinate(left_28_1+4,
							Point_device_28.y + margin_LogoToName_28+2);
					Font font_p_28 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "产品型号： ", Point_p_28, font_p_28);
	
					PointCoordinate Point_product_28 = new PointCoordinate(
							left_28_1+4, Point_p_28.y + margin_ItemToItem_28);
					drawString_1(g2, product, Point_product_28, Font.BOLD, 7);
	
					// draw voltage
					PointCoordinate Point_v_28 = new PointCoordinate(left_28_1+4,
							Point_product_28.y + margin_NameToItem_28);
					Font font_v_28 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定电压： ", Point_v_28, font_v_28);
	
					PointCoordinate Point_voltage_28 = new PointCoordinate(
							left_28_1+4, Point_v_28.y + margin_ItemToItem_28);
					drawString_1(g2, voltage_1, Point_voltage_28, Font.BOLD, 7);
					// // draw current
					// PointCoordinate Point_current_13 = new
					// PointCoordinate(left_13,
					// Point_voltate_13.y + margin_ItemToItem_13);
					// drawString(g2, current, Point_current_13, Font.PLAIN, 7);
					// draw power
					PointCoordinate Point_w_28 = new PointCoordinate(left_28_1+4,
							Point_voltage_28.y + margin_NameToItem_28);
					Font font_w_28 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定功率： ", Point_w_28, font_w_28);
	
					PointCoordinate Point_power_28 = new PointCoordinate(left_28_1+4,
							Point_w_28.y + margin_ItemToItem_28);
					drawString_1(g2, power, Point_power_28, Font.BOLD, 7);
					// draw right
					int left_28_2 = left_28 + 22;
					int r_28 = 4;
					int left_right_margin_28 = 12;
					int right_item_margin_28 = 14;
	
					PointCoordinate pointCircle_28_1 = new PointCoordinate(
							left_28_2 + Point_w_28.x
									+ (int) (font_w_28.getSize() * 4.3),
							Point_device_28.y + margin_ItemToItem_17);
					// new MyCircle(g2, pointCircle_28_1, r_28, "L ：输入L", font_28)
					// .drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_28_2 = new PointCoordinate(
							left_28_2 + Point_w_28.x
									+ (int) (font_w_28.getSize() * 4.3),
							pointCircle_28_1.y + right_item_margin_28);
					// // new MyCircle(g2, pointCircle_28_2, r_28, "N ：输入N",
					// font_28)
					// .drawCircle_1(false, 0);
	
					PointCoordinate pointCircle_28_3 = new PointCoordinate(
							left_28_2 + Point_w_28.x
									+ (int) (font_w_28.getSize() * 4.3) + 4,
							pointCircle_28_2.y + right_item_margin_28);
					new MyCircle(g2, pointCircle_28_3, r_28, "输入L", font_28)
							.drawCircle_2(false, 0);
	
					PointCoordinate pointCircle_28_4 = new PointCoordinate(
							left_28_2 + Point_w_28.x
									+ (int) (font_w_28.getSize() * 4.3) + 4,
							pointCircle_28_3.y + right_item_margin_28);
					new MyCircle(g2, pointCircle_28_4, r_28, "输入N", font_28)
							.drawCircle_2(false, 0);
	
					// PointCoordinate pointCircle_15_5 = new
					// PointCoordinate(left_15_2+Point_w_15.x + (int)
					// (font_w_15.getSize() * 4.3),
					// pointCircle_15_4.y + left_right_margin_15);
					// new MyCircle(g2, pointCircle_15_5, r_15, "1:R", font_15)
					// .drawCircle(false, 0);
	
					break;
				case 29:
					// 电能检测器
					int left_29 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 14);
					int top_29 = (int) (0.6 * PrintFinal.INCH / 2.54+4)+2;
					// draw logo_eastsoft
					// new MyLogo(g2, PointLogo_22, font_es22,
					// font_r22).drawLogo(5.1f);
					// new MyLogo(g2, PointLogo_29).drawLogo(5.1f);
					Font font_logo_29 = new Font("微软雅黑", Font.BOLD, 10);
					PointCoordinate PointLogo_29 = new PointCoordinate(left_29+6,
							top_29);
					// draw logo
					new MyLogo(g2, PointLogo_29).drawLogo(5.1f);
	
					// draw device
					Font font_device_29 = new Font("微软雅黑", Font.BOLD, 8);
					PointCoordinate Point_device_29 = new PointCoordinate(left_29+8,
							PointLogo_29.y + margin_LogoToName_29);
					drawString_1(g2, device, Point_device_29, font_device_29);
	
					// draw product
					PointCoordinate Point_p_29 = new PointCoordinate(left_29+5,
							Point_device_29.y + margin_NameToItem_29);
					Font font_p_29 = new Font("黑体", Font.BOLD, 6);
					drawString_1(g2, "产品型号：", Point_p_29, font_p_29);
	
					PointCoordinate Point_product_29 = new PointCoordinate(
							Point_p_29.x + (int) (font_p_29.getSize() * 4.4) + 3,
							Point_device_29.y + margin_NameToItem_29);
					drawString_1(g2, product, Point_product_29, Font.BOLD, 6);
	
					// draw voltage
					PointCoordinate Point_v_29 = new PointCoordinate(left_29+5,
							Point_product_29.y + margin_ItemToItem_29);
	
					Font font_v_29 = new Font("黑体", Font.BOLD, 6);
					drawString_1(g2, "额定电压：", Point_v_29, font_v_29);
					PointCoordinate Point_voltate_29 = new PointCoordinate(
							Point_v_29.x + (int) (font_p_29.getSize() * 4.4) + 3,
							Point_product_29.y + margin_ItemToItem_29);
					drawString_1(g2, voltage_1, Point_voltate_29, Font.BOLD, 6);
	
					// draw current
					PointCoordinate Point_c_29 = new PointCoordinate(left_29+5,
							Point_voltate_29.y + margin_ItemToItem_29);
	
					Font font_c_29 = new Font("黑体", Font.BOLD, 6);
					drawString_1(g2, "工作电流：", Point_c_29, font_c_29);
					PointCoordinate Point_current_29 = new PointCoordinate(
							Point_v_29.x + (int) (font_p_29.getSize() * 4.4) + 3,
							Point_voltate_29.y + margin_ItemToItem_29);
					drawString_1(g2, current_1, Point_current_29, Font.BOLD, 6);
	
					// draw binaryCode
					File barCode_29 = new File("test_QR_CODE.png");
					Image src_29 = null;
					if (barCode_29.exists()) {
						try {
							src_29 = ImageIO.read(new FileInputStream(barCode_29));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// // draw 二维码整体
					PointCoordinate left_top_29 = new PointCoordinate(
							(int) (left_29 + 2 * PrintFinal.INCH / 2.54) + 12,
							top_29 - 5);
					FourCornorsShowSize showSize_29 = new FourCornorsShowSize(39,
							50);
					PicShowSet picShowset_29 = new PicShowSet(35, 35, 2, 2);
					Font font_29 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_29, g2, left_top_29, src_29, aid, passwd,
							showSize_29, picShowset_29).drawAll(LINE_LENGTH - 2, 3,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					break;
					
				//Added by 唐鹰
				//Add 2014-11-11 Start：			
				case 30:
					// 用电监控器
					int left_30 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 14);
					int top_30 = (int) (0.6 * PrintFinal.INCH / 2.54);
					
					Font font_logo_30 = new Font("微软雅黑", Font.BOLD, 10);
					PointCoordinate PointLogo_30 = new PointCoordinate(left_30+5,
							top_30);
					//drawString_1(g2, company, PointLogo_30, font_logo_30);
	
					// draw ®
					new MyLogo(g2, PointLogo_30).drawLogo(5.1f);
	
					// draw device
					Font font_device_30 = new Font("微软雅黑", Font.BOLD, 8);
					PointCoordinate Point_device_30 = new PointCoordinate(left_30+5,
							PointLogo_30.y + margin_LogoToName_30);
					drawString_1(g2, device, Point_device_30, font_device_30);
	
					// draw product
					PointCoordinate Point_p_30 = new PointCoordinate(left_30+5,
							Point_device_30.y + margin_NameToItem_30);
					Font font_p_30 = new Font("黑体", Font.BOLD, 6);
					drawString_1(g2, "产品型号：", Point_p_30, font_p_30);
	
					PointCoordinate Point_product_30 = new PointCoordinate(
							Point_p_30.x + (int) (font_p_30.getSize() * 4.4) + 3,
							Point_device_30.y + margin_NameToItem_30);
					drawString_1(g2, product, Point_product_30, Font.BOLD, 6);
	
					// draw voltage
					PointCoordinate Point_v_30 = new PointCoordinate(left_30+5,
							Point_product_30.y + margin_ItemToItem_30);
	
					Font font_v_30 = new Font("黑体", Font.BOLD, 6);
					drawString_1(g2, "额定电压：", Point_v_30, font_v_30);
					PointCoordinate Point_voltate_30 = new PointCoordinate(
							Point_v_30.x + (int) (font_p_30.getSize() * 4.4) + 3,
							Point_product_30.y + margin_ItemToItem_30);
					drawString_1(g2, voltage_1, Point_voltate_30, Font.BOLD, 6);
	
					// draw current
					PointCoordinate Point_c_30 = new PointCoordinate(left_30+5,
							Point_voltate_30.y + margin_ItemToItem_30);
	
					Font font_c_30 = new Font("黑体", Font.BOLD, 6);
					drawString_1(g2, "工作电流：", Point_c_30, font_c_30);
					PointCoordinate Point_current_30 = new PointCoordinate(
							Point_v_30.x + (int) (font_p_30.getSize() * 4.4) + 3,
							Point_voltate_30.y + margin_ItemToItem_30);
					drawString_1(g2, current_1, Point_current_30, Font.BOLD, 6);
	
					// draw binaryCode
					File barCode_30 = new File("test_QR_CODE.png");
					Image src_30 = null;
					if (barCode_30.exists()) {
						try {
							src_30 = ImageIO.read(new FileInputStream(barCode_30));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// // draw 二维码整体
					PointCoordinate left_top_30 = new PointCoordinate(
							(int) (left_30 + 2 * PrintFinal.INCH / 2.54) + 11,
							top_30 - 5);
					FourCornorsShowSize showSize_30 = new FourCornorsShowSize(39,
							50);
					PicShowSet picShowset_30 = new PicShowSet(35, 35, 2, 2);
					Font font_30 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_30, g2, left_top_30, src_30, aid, passwd,
							showSize_30, picShowset_30).drawAll(LINE_LENGTH - 2, 3,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					break;
					//End： 
				case 31:
					//昊想智能卫士底座
					int left_31 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 14);
					int top_31 = (int) (0.6 * PrintFinal.INCH / 2.54)+5;
					
					// draw binaryCode
					File barCode_31 = new File("test_QR_CODE.png");
					Image src_31 = null;
					if (barCode_31.exists()) {
						try {
							src_31 = ImageIO.read(new FileInputStream(barCode_31));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// draw 二维码整体 第一次右边
					PointCoordinate left_top_31 = new PointCoordinate(
							(int) (left_31 + 2 * PrintFinal.INCH / 2.54)+10,
							top_31 - 5);
					FourCornorsShowSize showSize_31 = new FourCornorsShowSize(39,50);
					PicShowSet picShowset_31 = new PicShowSet(35,35, 2, 2);
					Font font_31 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_31, g2, left_top_31, src_31, aid, passwd,showSize_31, picShowset_31).drawAllHO(LINE_LENGTH - 2, 3,
							0);
					
					// draw 二维码整体第二次左边
					PointCoordinate left_top_32 = new PointCoordinate(
							(int) (left_31 + 2 * PrintFinal.INCH / 2.54)-45,
							top_31 - 5);
					FourCornorsShowSize showSize_32 = new FourCornorsShowSize(39,50);
					PicShowSet picShowset_32 = new PicShowSet(35,35, 2, 2);
					Font font_32 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_32, g2, left_top_32, src_31, aid, passwd,showSize_32, picShowset_32).drawAllHO(LINE_LENGTH - 2, 3,
							0);
					break;
				
				/**
				 * @author wzj
				 */
				case 33:
					
					int left_33 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 12);
					int top_33 = (int) (0.6 * PrintFinal.INCH / 2.54);
					
					Font font_logo_33 = new Font("微软雅黑", Font.BOLD, 16);
					PointCoordinate PointLogo_33 = new PointCoordinate(left_33 + 5,
							top_33+5);
					drawString_1(g2, company, PointLogo_33, font_logo_33);
					// draw ® 				
					String houzhui33 = "®";
					drawString(g2, houzhui33, 
							new PointCoordinate(left_33+(int) (font_logo_33.getSize() * ((8/2)+0.2)) + 5,top_33 + 5),
							new Font("微软雅黑", Font.BOLD, 4));

					// draw device
					Font font_device_33 = new Font("微软雅黑", Font.BOLD, 8);
					PointCoordinate Point_device_33 = new PointCoordinate(
							left_33 + 5, PointLogo_33.y + margin_LogoToName_23);
					drawString_1(g2, device, Point_device_33, font_device_33);
					
					// draw product
					PointCoordinate Point_p_33 = new PointCoordinate(
							left_33 + 5, Point_device_33.y
									+ margin_NameToItem_23+4);
					Font font_p_33 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "产品型号：", Point_p_33, font_p_33);

					PointCoordinate Point_product_33 = new PointCoordinate(
							Point_p_33.x + (int) (font_p_33.getSize() * 4.4)
									+ 5, Point_device_33.y
									+ margin_NameToItem_23+4);
					drawString_1(g2, product, Point_product_33, Font.BOLD, 7);
					// switch (product.length()) {
					//
					// case 12:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 11:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 10:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 5);
					// break;
					// case 9:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 6);
					// break;
					// default:
					// drawString(g2, product, Point_product_22, Font.PLAIN, 6);
					// break;
					// }

					// draw current
					PointCoordinate Point_c_33 = new PointCoordinate(left_33 + 5,
							Point_product_33.y + margin_ItemToItem_23+8);
					Font font_c_33 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "额定电流：", Point_c_33, font_c_33);
					PointCoordinate Point_current_33 = new PointCoordinate(
							Point_c_33.x + (int) (font_p_33.getSize() * 4.4) + 5,
							Point_product_33.y + margin_ItemToItem_23+8);
					drawString_1(g2, current_1, Point_current_33, Font.BOLD, 7);
					
					// draw voltage
					PointCoordinate Point_v_33 = new PointCoordinate(
							left_33 + 5, Point_c_33.y
									+ margin_ItemToItem_23+8);
					Font font_v_33 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "工作电压：", Point_v_33, font_v_33);
					PointCoordinate Point_voltate_33 = new PointCoordinate(
							Point_v_33.x + (int) (font_p_33.getSize() * 4.4)
									+ 5, Point_c_33.y
									+ margin_ItemToItem_23+8);
					drawString_1(g2, voltage_1, Point_voltate_33, Font.BOLD, 7);
					
					// draw serial no
					/*
					 * PointCoordinate Point_Serialno_2 = new
					 * PointCoordinate(left__2,
					 * Point_voltate_2.y+margin_ItemToItem_2);
					 * drawString(g2,productSerialNO,Point_Serialno_2,
					 * Font.PLAIN,6);
					 */

					// draw binaryCode
					File barCode_33 = new File("test_QR_CODE.png");
					Image src_33 = null;
					if (barCode_33.exists()) {
						try {
							src_33 = ImageIO.read(new FileInputStream(
									barCode_33));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					// draw 二维码整体
					PointCoordinate left_top_33 = new PointCoordinate(
							(int) (left_33 + 2 * PrintFinal.INCH / 2.54) + 29,
							top_33 - 3);
					FourCornorsShowSize showSize_33 = new FourCornorsShowSize(
							55, 65);
					PicShowSet picShowset_33 = new PicShowSet(50, 50, 2, 2);
					Font font_33 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_33, g2, left_top_33, src_33, aid,
							passwd, showSize_33, picShowset_33).drawAll(
							LINE_LENGTH - 2, 0, 0);

					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 15, 20);
					}

					break;
					
				//Added by wzj
				//Add 2015-07-14 Start：	
				case 35:
					// PLC-485转换器
					int left_35 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 10);
					int top_35 = (int) (0.6 * PrintFinal.INCH / 2.54 + 10);
					
					Font font_logo_35 = new Font("微软雅黑", Font.BOLD, 18);
					PointCoordinate PointLogo_35 = new PointCoordinate(left_35 + 3,
							top_35 + 5);
					drawString_1(g2, company, PointLogo_35, font_logo_35);
					// draw ® 				
					String houzhui35 = "®";
					drawString(g2, houzhui35, 
							new PointCoordinate(left_35+(int) (font_logo_35.getSize() * ((8/2)+0.2)) + 3,top_35 + 5),
							new Font("微软雅黑", Font.BOLD, 4));
	
					// draw device
					Font font_device_35 = new Font("微软雅黑", Font.BOLD, 10);
					PointCoordinate Point_device_35 = new PointCoordinate(left_35 + 3,
							PointLogo_35.y + margin_LogoToName_35);
					drawString_1(g2, device, Point_device_35, font_device_35);
	
					// draw product
					PointCoordinate Point_p_35 = new PointCoordinate(left_35 + 3,
							Point_device_35.y + margin_NameToItem_35 );
					Font font_p_35 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "产品型号：", Point_p_35, font_p_35);
	
					PointCoordinate Point_product_35 = new PointCoordinate(
							Point_p_35.x + (int) (font_p_35.getSize() * 4.4) + 3,
							Point_device_35.y + margin_NameToItem_35);
					drawString_1(g2, product, Point_product_35, Font.BOLD, 7);
	
					// draw voltage
					PointCoordinate Point_v_35 = new PointCoordinate(left_35 + 3,
							Point_product_35.y + margin_ItemToItem_35);
	
					Font font_v_35 = new Font("黑体", Font.BOLD, 7);
					drawString_1(g2, "工作电压：", Point_v_35, font_v_35);
					PointCoordinate Point_voltate_35 = new PointCoordinate(
							Point_v_35.x + (int) (font_p_35.getSize() * 4.4) + 3,
							Point_product_35.y + margin_ItemToItem_35);
					drawString_1(g2, voltage_1, Point_voltate_35, Font.BOLD, 7);
	
					// draw binaryCode
					File barCode_35 = new File("test_QR_CODE.png");
					Image src_35 = null;
					if (barCode_35.exists()) {
						try {
							src_35 = ImageIO.read(new FileInputStream(barCode_35));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// // draw 二维码整体
					PointCoordinate left_top_35 = new PointCoordinate(
							(int) (left_35 + 2 * PrintFinal.INCH / 2.54) + 30,
							top_35 - 8);
					FourCornorsShowSize showSize_35 = new FourCornorsShowSize(50,
							60);
					PicShowSet picShowset_35 = new PicShowSet(45, 45, 2, 2);
					Font font_35 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_35, g2, left_top_35, src_35, aid, passwd,
							showSize_35, picShowset_35).drawAll(LINE_LENGTH - 2, 0,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					break;
//					End： 	
					
//				Added by wzj
//				Add 2015-7-15 Start：			
				case 37:
					// 四路开关执行器
					int left_37 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 14);
					int top_37 = (int) (0.6 * PrintFinal.INCH / 2.54);
					
					Font font_logo_37 = new Font("微软雅黑", Font.BOLD, 13);
					PointCoordinate PointLogo_37 = new PointCoordinate(left_37+5,
							top_37 + 5);
					drawString_1(g2, company, PointLogo_37, font_logo_37);
					// draw ®
					String houzhui37 = "®";
					drawString(g2, houzhui37, 
							new PointCoordinate(left_37+(int) (font_logo_37.getSize() * (5.2-1)) + 5,top_37 + 5),
							new Font("微软雅黑", Font.BOLD, 4));
					// draw device
					Font font_device_37 = new Font("微软雅黑", Font.BOLD, 7);
					PointCoordinate Point_device_37 = new PointCoordinate(left_37+5,
							PointLogo_37.y  + margin_LogoToName_37);
					drawString_1(g2, device, Point_device_37, font_device_37);
	
					// draw product
					PointCoordinate Point_p_37 = new PointCoordinate(left_37+5,
							Point_device_37.y + margin_NameToItem_37 - 9);
					Font font_p_37 = new Font("黑体", Font.BOLD, 5);
					drawString_1(g2, "产品型号：", Point_p_37, font_p_37);
	
					PointCoordinate Point_product_37 = new PointCoordinate(
							Point_p_37.x,
//							+ (int) (font_p_37.getSize() * 4.4) + 3
							Point_device_37.y + margin_NameToItem_37);
					drawString_1(g2, product, Point_product_37, Font.BOLD, 5);
	
					// draw voltage
					PointCoordinate Point_v_37 = new PointCoordinate(left_37+5,
							Point_product_37.y + margin_ItemToItem_37);
	
					Font font_v_37 = new Font("黑体", Font.BOLD, 5);
					drawString_1(g2, "工作电压：", Point_v_37, font_v_37);
					PointCoordinate Point_voltate_37 = new PointCoordinate(
							Point_v_37.x + (int) (font_p_37.getSize() * 4.4) + 3,
							Point_product_37.y + margin_ItemToItem_37);
					drawString_1(g2, voltage_1, Point_voltate_37, Font.BOLD, 5);
	
					// draw current
					PointCoordinate Point_c_37 = new PointCoordinate(left_37+5,
							Point_voltate_37.y + margin_ItemToItem_37);
	
					Font font_c_37 = new Font("黑体", Font.BOLD, 5);
					drawString_1(g2, "工作电流：", Point_c_37, font_c_37);
					PointCoordinate Point_current_37 = new PointCoordinate(
							Point_v_37.x + (int) (font_p_37.getSize() * 4.4) + 3,
							Point_voltate_37.y + margin_ItemToItem_37);
					drawString_1(g2, current_1, Point_current_37, Font.BOLD, 5);
	
					// draw binaryCode
					File barCode_37 = new File("test_QR_CODE.png");
					Image src_37 = null;
					if (barCode_37.exists()) {
						try {
							src_37 = ImageIO.read(new FileInputStream(barCode_37));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	
					// // draw 二维码整体
					PointCoordinate left_top_37 = new PointCoordinate(
							(int) (left_37 + 2 * PrintFinal.INCH / 2.54) + 11,
							top_37 - 5);
					FourCornorsShowSize showSize_37 = new FourCornorsShowSize(39,
							50);
					PicShowSet picShowset_37 = new PicShowSet(35, 35, 2, 2);
					Font font_37 = new Font("黑体", Font.BOLD, 6);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_37, g2, left_top_37, src_37, aid, passwd,
							showSize_37, picShowset_37).drawAll(LINE_LENGTH - 2, 3,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					break;
					//End： 
					
				//Added by wzj
				//Add 2015-07-14 Start：	
				// PLC-Sub1GHz适配器
				case 38:
					// draw logo
//					int left_38 = (int) ((0.5 * PrintFinal.INCH / 2.54));
//					int top_38 = (int) (0.6 * PrintFinal.INCH / 2.54);
					int left_38 = (int) (0.4 * PrintFinal.INCH);
					int top_38 = (int) (0.1 * PrintFinal.INCH);
					Font font_logo_38 = new Font("微软雅黑", Font.BOLD, 11);
					PointCoordinate PointLogo_38 = new PointCoordinate(left_38+5,
							top_38+5);
					drawString_1(g2, company, PointLogo_38, font_logo_38);
					// draw ® 				
					String houzhui38 = "®";
					drawString(g2, houzhui38, 
							new PointCoordinate(left_38+(int) (font_logo_38.getSize() * ((8/2)+0.2)) + 5,top_38 + 5),
							new Font("微软雅黑", Font.BOLD, 4));
					
					// draw line
					Font font_line_38 = new Font("黑体", Font.BOLD, 4);
					PointCoordinate Point_line_38_1 = new  PointCoordinate(left_38 - 5,
							PointLogo_38.y + 4);
					PointCoordinate Point_line_38_2 = new  PointCoordinate(left_38 + 65,
							PointLogo_38.y + 4);
					drawLine1(g2, Point_line_38_1, Point_line_38_2, font_line_38);
	
					// draw device
					Font font_device_38 = new Font("黑体", Font.BOLD, 6);
					PointCoordinate Point_device_38 = new PointCoordinate(left_38 - 3,
							PointLogo_38.y + margin_LogoToName_38);
					drawString_1(g2, device.substring(0,12), Point_device_38, font_device_38);
	
					// draw product
					PointCoordinate Point_p_38 = new PointCoordinate(left_38 - 3,
							Point_device_38.y + margin_NameToItem_38);
					Font font_p_38 = new Font("黑体", Font.BOLD, 6);
					drawString_1(g2, "产品型号：", Point_p_38, font_p_38);
	
					PointCoordinate Point_product_38 = new PointCoordinate(
							Point_p_38.x + (int) (font_p_38.getSize() * 4.4) + 3,
							Point_device_38.y + margin_NameToItem_38);
					drawString_1(g2, product, Point_product_38, Font.BOLD, 6);
	
					// draw voltage
					PointCoordinate Point_v_38 = new PointCoordinate(left_38 - 3,
							Point_product_38.y + margin_ItemToItem_38);
					Font font_v_38 = new Font("黑体", Font.BOLD, 6);
					drawString_1(g2, "工作电压：", Point_v_38, font_v_38);
					
					PointCoordinate Point_voltate_38 = new PointCoordinate(
							Point_v_38.x + (int) (font_p_38.getSize() * 4.4) + 3,
							Point_product_38.y + margin_ItemToItem_38);
					drawString_1(g2, voltage_1, Point_voltate_38, Font.BOLD, 6);
//	
					// draw binaryCode
					File barCode_38 = new File("test_QR_CODE.png");
					Image src1_38 = null;
					if (barCode_38.exists()) {
						try {
							src1_38 = ImageIO.read(new FileInputStream(barCode_38));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
//	
					// draw 二维码整体
					PointCoordinate left_top_38 = new PointCoordinate(
							(int) (left_38), (int)(0.6 * PrintFinal.INCH - 3));
					FourCornorsShowSize showSize_38 = new FourCornorsShowSize(32,
							38);
					PicShowSet picShowset_38 = new PicShowSet(28, 28, 2, 2);
					Font font_38 = new Font("黑体", Font.BOLD, 4);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_38, g2, left_top_38, src1_38, aid, passwd,
							showSize_38, picShowset_38).drawAll(LINE_LENGTH - 2, 4,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					
					//draw other picture
					File otherImage_38 = new File("PLC-Sub1G转换器_黑.png");
					Image src2_38 = null;
					if (barCode_38.exists()) {
						try {
							src2_38 = ImageIO.read(new FileInputStream(otherImage_38));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					PointCoordinate left_top2_38 = new PointCoordinate(
							(int) (left_38 +40), (int)(0.6 * PrintFinal.INCH - 3));
					
					PicShowSet picShowset2_38 = new PicShowSet(15, 35, 2, 2);
					Font font2_38 = new Font("黑体", Font.BOLD, 4);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new OtherImage(font2_38, g2, left_top2_38, src2_38, picShowset2_38).drawAll(LINE_LENGTH - 2, 4,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					
					break;
//						End： 
				// wzj
				case 39:
					// 设置页面背景为黑色
					double px39 = pf.getWidth();
					double py39 = pf.getHeight();
					Rectangle2D page39 = new Rectangle2D.Double(0, 0, px39, py39);
					g2.setPaint(Color.black);
					g2.fill(page39);
					g2.setPaint(Color.blue);
					g2.draw(page39);
					// draw logo
//					int left_38 = (int) ((0.5 * PrintFinal.INCH / 2.54));
//					int top_38 = (int) (0.6 * PrintFinal.INCH / 2.54);
					int left_39 = (int) (0.4 * PrintFinal.INCH);
					int top_39 = (int) (0.1 * PrintFinal.INCH);
					Font font_logo_39 = new Font("微软雅黑", Font.BOLD, 11);
					PointCoordinate PointLogo_39 = new PointCoordinate(left_39+5,
							top_39+5);
					drawString_2(g2, company, PointLogo_39, font_logo_39);
					// draw ® 				
					String houzhui39 = "®";
					drawString(g2, houzhui39, 
							new PointCoordinate(left_39+(int) (font_logo_39.getSize() * ((8/2)+0.2)) + 5,top_39 + 5),
							new Font("微软雅黑", Font.BOLD, 4));
					
					// draw line
					Font font_line_39 = new Font("黑体", Font.BOLD, 4);
					PointCoordinate Point_line_39_1 = new  PointCoordinate(left_39 - 5,
							PointLogo_39.y + 4);
					PointCoordinate Point_line_39_2 = new  PointCoordinate(left_39 + 65,
							PointLogo_39.y + 4);
					drawLine1(g2, Point_line_39_1, Point_line_39_2, font_line_39);
	
					// draw device
					Font font_device_39 = new Font("黑体", Font.BOLD, 6);
					PointCoordinate Point_device_39 = new PointCoordinate(left_39 - 3,
							PointLogo_39.y + margin_LogoToName_38);
					drawString_1(g2, device.substring(0,12), Point_device_39, font_device_39);
	
					// draw product
					PointCoordinate Point_p_39 = new PointCoordinate(left_39 - 3,
							Point_device_39.y + margin_NameToItem_38);
					Font font_p_39 = new Font("黑体", Font.BOLD, 6);
					drawString_1(g2, "产品型号：", Point_p_39, font_p_39);
	
					PointCoordinate Point_product_39 = new PointCoordinate(
							Point_p_39.x + (int) (font_p_39.getSize() * 4.4) + 3,
							Point_device_39.y + margin_NameToItem_38);
					drawString_1(g2, product, Point_product_39, Font.BOLD, 6);
	
					// draw voltage
					PointCoordinate Point_v_39 = new PointCoordinate(left_39 - 3,
							Point_product_39.y + margin_ItemToItem_38);
					Font font_v_39 = new Font("黑体", Font.BOLD, 6);
					drawString_1(g2, "工作电压：", Point_v_39, font_v_39);
					
					PointCoordinate Point_voltate_39 = new PointCoordinate(
							Point_v_39.x + (int) (font_p_39.getSize() * 4.4) + 3,
							Point_product_39.y + margin_ItemToItem_38);
					drawString_1(g2, voltage_1, Point_voltate_39, Font.BOLD, 6);
//	
					// draw binaryCode
					File barCode_39 = new File("test_QR_CODE.png");
					Image src1_39 = null;
					if (barCode_39.exists()) {
						try {
							src1_39 = ImageIO.read(new FileInputStream(barCode_39));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
//	
					// draw 二维码整体
					PointCoordinate left_top_39 = new PointCoordinate(
							(int) (left_39), (int)(0.6 * PrintFinal.INCH - 3));
					FourCornorsShowSize showSize_39 = new FourCornorsShowSize(32,
							38);
					PicShowSet picShowset_39 = new PicShowSet(28, 28, 2, 2);
					g1.drawRect((int) (left_39) + 2, (int)(0.6 * PrintFinal.INCH - 3) + 2,
							28, 28);	//drawRect
					Font font_39 = new Font("黑体", Font.BOLD, 4);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_39, g2, left_top_39, src1_39, aid, passwd,
							showSize_39, picShowset_39).drawAll(LINE_LENGTH - 2, 4,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					
					//draw other picture
					File otherImage_39 = new File("PLC-Sub1G转换器_白.png");
					Image src2_39 = null;
					if (barCode_39.exists()) {
						try {
							src2_39 = ImageIO.read(new FileInputStream(otherImage_39));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					PointCoordinate left_top2_39 = new PointCoordinate(
							(int) (left_39 +40), (int)(0.6 * PrintFinal.INCH - 3));
					
					PicShowSet picShowset2_39 = new PicShowSet(15, 35, 2, 2);
					Font font2_39 = new Font("黑体", Font.BOLD, 4);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new OtherImage(font2_39, g2, left_top2_39, src2_39, picShowset2_39).drawAll(LINE_LENGTH - 2, 4,
							0);
	
					if (showHexAidFlag) {
						Font font_hex = new Font("黑体", Font.PLAIN, 8);
						g2.setFont(font_hex);// 设置字体
						String hexAid = Long.toHexString(Long.parseLong(aid));
						g2.drawString("Aid:" + hexAid.toUpperCase(), 10, 12);
					}
					
					break;
//						End： 
				default:
					break;
	
				}
			}else if(mainUi.jTabbedPane.getSelectedIndex()==2){		//双向互动适配器页面
				int index = info.getformatNewIndex();
				if(index==3){	//如果是双向互动适配器（QCA4004方案）则和（STM8S+8-600串口WIFI方案）的使用同一个打印方案
					index = 1;
				}
				Font font_es = new Font("微软雅黑", Font.BOLD, 13);
				Font font_r = new Font("微软雅黑", Font.BOLD, 6);
				switch (index) {	//互动适配器 hudong
				case 1:

					int left_1 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 16);
					int top_1 = (int) (0.5 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft

					PointCoordinate PointLogo_1 = new PointCoordinate(left_1 + 4,
							top_1);
					Font font_logo_1 = new Font("微软雅黑", Font.BOLD, 10);
					new MyLogo(g2, PointLogo_1, font_es, font_r).drawLogo(5f);

					// new MyLogo(g2, PointLogo_1).drawLogo(5.0f);
					// draw东软载波
					PointCoordinate Point_logo_1 = new PointCoordinate(
							PointLogo_1.x + new_margin_NameToLogo_1, top_1);
					Font font_eastsoft_1 = new Font("微软雅黑", Font.BOLD, 10);
					drawString_1(g2, "东软载波", Point_logo_1, font_eastsoft_1);

					// draw device
					PointCoordinate Point_device_1 = new PointCoordinate(
							left_1 + 4, PointLogo_1.y + new_margin_LogoToName_1);
					drawString_1(g2, deviceName.substring(0,7), Point_device_1, Font.BOLD, 7);

					// draw device_id
					PointCoordinate Point_id_1 = new PointCoordinate(left_1 + 4,
							Point_device_1.y + new_margin_NameToItem_1);
					Font font_pid_1 = new Font("黑体", Font.BOLD, 5);
					drawString_1(g2, "设备地址：", Point_id_1, font_pid_1);

					PointCoordinate Point_deviceid_1 = new PointCoordinate(
							left_1 + 4, Point_id_1.y + new_margin_NameToItem_1);
					drawString_1(g2, deviceID, Point_deviceid_1, Font.BOLD, 5);

					PointCoordinate Point_ssid_1 = new PointCoordinate(left_1 + 4,
							Point_deviceid_1.y + new_margin_NameToItem_1);
					Font font_pssid_1 = new Font("黑体", Font.BOLD, 5);
					drawString_1(g2, "网络名：", Point_ssid_1, font_pssid_1);

					PointCoordinate Point_devicessid_1 = new PointCoordinate(
							left_1 + 4, Point_ssid_1.y + new_margin_NameToItem_1);
					drawString_1(g2, deviceSSID, Point_devicessid_1, Font.BOLD, 5);

					PointCoordinate Point_password_1 = new PointCoordinate(
							left_1 + 4, Point_devicessid_1.y +new_margin_NameToItem_1);
					Font font_ppassword_1 = new Font("黑体", Font.BOLD, 5);
					drawString_1(g2, "密  码：", Point_password_1, font_ppassword_1);

					PointCoordinate Point_devicepassword_1 = new PointCoordinate(
							Point_password_1.x + new_margin_ItemToName_1,
							Point_devicessid_1.y + new_margin_NameToItem_1);
					drawString_1(g2, devicePasswd, Point_devicepassword_1,
							Font.BOLD, 5);

					// draw binaryCode
					File barCode_1 = new File("new_test_QR_CODE.png");
					Image src_1 = null;
					if (barCode_1.exists()) {
						try {
							src_1 = ImageIO.read(new FileInputStream(barCode_1));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					// draw 二维码整体
					PointCoordinate left_top_1 = new PointCoordinate(
							(int) (left_1 + 2 * PrintFinal.INCH / 2.54) -6,
							top_1 +3);
					FourCornorsShowSize showSize_1 = new FourCornorsShowSize(39, 40);
					PicShowSet picShowset_1 = new PicShowSet(52, 52, 2, 8);
					Font font_1 = new Font("黑体", Font.BOLD, 3);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_1, g2 ,left_top_1, src_1, "", "",showSize_1,picShowset_1).drawNewAll(LINE_LENGTH - 2, 3,
							0);
					break;
				case 2:
					int left_2 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 16);
					int top_2 = (int) (0.5 * PrintFinal.INCH / 2.54);
					// draw logo_eastsoft
					PointCoordinate PointLogo_2 = new PointCoordinate(left_2 + 6,top_2);
					Font font_logo_2 = new Font("微软雅黑", Font.BOLD, 10);
					drawString_1(g2,company, PointLogo_2, font_logo_2);
	
					PointCoordinate PointLogo2_1 = new PointCoordinate(
							PointLogo_2.x + (int) (font_logo_2.getSize() * 4),top_2);
					Font font_logo2_1 = new Font("微软雅黑", Font.BOLD, 5);
					drawString_1(g2, "®", PointLogo2_1, font_logo2_1);
					// new MyLogo(g2, PointLogo_1).drawLogo(5.0f);
					// draw东软载波
					PointCoordinate Point_logo_2 = new PointCoordinate(
							PointLogo_2.x + new_margin_NameToLogo_1, top_2);
					Font font_eastsoft_2 = new Font("微软雅黑", Font.BOLD, 10);
					drawString_1(g2, "东软载波", Point_logo_2, font_eastsoft_2);
	
					// draw “户内载波”
					PointCoordinate PointDevice2_1 = new PointCoordinate(left_2
							+ new_margin_NameToLeft_2, Point_logo_2.y
							+ new_margin_NameToLogo_2);
					Font font_device2_1 = new Font("微软雅黑", Font.BOLD, 8);
					drawString_1(g2, deviceName.substring(0, 4), PointDevice2_1,
							font_device2_1);
	
					// draw "MBUS转换器"
					PointCoordinate PointDevice2_2 = new PointCoordinate(
							left_2 + 4, PointDevice2_1.y + new_margin_NameToName_2);
					Font font_device2_2 = new Font("微软雅黑", Font.BOLD, 8);
					drawString_1(g2, deviceName.substring(4, 11), PointDevice2_2,
							font_device2_2);
					// draw "设备地址"
					PointCoordinate PointDeviceID2_1 = new PointCoordinate(
							left_2 + 4, PointDevice2_2.y + new_margin_ItemToName_2);
					Font font_deviceid2_1 = new Font("微软雅黑", Font.BOLD, 6);
					drawString_1(g2, "设备地址:", PointDeviceID2_1, font_deviceid2_1);
					// draw deviceid
					PointCoordinate PointDeviceID2_2 = new PointCoordinate(
							left_2 + 4, PointDeviceID2_1.y + new_margin_NameToName_2);
					Font font_deviceid2_2 = new Font("微软雅黑", Font.BOLD, 6);
					drawString_1(g2, deviceID, PointDeviceID2_2, font_deviceid2_2);
	
					// draw binaryCode
					File barCode_2 = new File("new_test_QR_CODE.png");
					Image src_2 = null;
					if (barCode_2.exists()) {
						try {
							src_2 = ImageIO.read(new FileInputStream(barCode_2));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// draw 二维码
					PointCoordinate left_top_2 = new PointCoordinate(
							(int) (left_2 + 2 * PrintFinal.INCH / 2.54)-5,
							top_2 + 3);
					//FourCornorsShowSize showSize_2 = new FourCornorsShowSize(39, 40);
					PicShowSet picShowset_2 = new PicShowSet(50, 50, 2, 6);
					Font font_2 = new Font("黑体", Font.BOLD, 3);
					g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
							BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
					new MyBarCodeAll(font_2, g2 ,left_top_2, src_2, "", "",picShowset_2)
							.drawNewAll(LINE_LENGTH - 2, 3, 0);
					break;
				default:
					break;
				}
			}else if(mainUi.jTabbedPane.getSelectedIndex()==1){		//电力线标签页
				int left_1 = (int) ((0.5 * PrintFinal.INCH / 2.54) - 16);
				int top_1 = (int) (0.5 * PrintFinal.INCH / 2.54);
				switch (deviceName) {		//电力线适配器
					case "电力线适配器":
					{
						//电源、设备名、设备型号、设备地址在上面已经获取
						String deviceSN = info.getDeviceSN();
						String manageIP = info.getManageIP();
						String deviceVersion = info.getDeviceVresion();
						String officalWebsite = info.getOfficialWebsite();
						
						//int chuizhi = -1;		//垂直方向的偏移
						int shuiping = 0;
						
						//公司Eastsoft
						PointCoordinate PointLogo_1 = new PointCoordinate(left_1 + 4,top_1+2);
						Font font_es = new Font("微软雅黑", Font.BOLD, 12);
						Font font_r = new Font("微软雅黑", Font.BOLD, 7);
						new MyLogo(g2, PointLogo_1, font_es, font_r).drawLogo(5.2f);
						
						PointCoordinate Point_device_1 = new PointCoordinate(left_1 + 1, PointLogo_1.y + 16);
						int c[] = {-8,2,12,22,30,38,46};
						
						Font font_eastsoft_1 = new Font("黑体", Font.PLAIN, 7);
						//设备类型
						drawString_1(g2, info.getdeviceType()+" Adapter", 
								new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[0]), font_eastsoft_1);
						
						//设备名
						Font font_pid_deviceName = new Font("微软雅黑", Font.BOLD, 7);
						PointCoordinate Point_id_1 = new PointCoordinate(left_1 + 4+shuiping,
								Point_device_1.y+c[1]);
						drawString_1(g2, deviceName, Point_id_1, font_pid_deviceName);
						
						g2.setStroke(new BasicStroke(0.5f));
						g2.drawLine(left_1 + 4+shuiping, Point_device_1.y+c[2]-7, left_1 + 64+shuiping, 
								Point_device_1.y+c[2]-7);
						//官网
						drawString_1(g2, officalWebsite, new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[2]), 
								new Font("微软雅黑", Font.PLAIN, 6));
						//下半部分
						Font font_pid_1 = new Font("微软雅黑", Font.BOLD, 5);
						drawString_1(g2, "电源: "+power, new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[3]), 
								font_pid_1);
						drawString_1(g2, "IP: "+manageIP, new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[4]), 
								font_pid_1);
						drawString_1(g2, "MAC: "+deviceID, new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[5]), 
								font_pid_1);
						drawString_1(g2, "S/N: "+deviceSN, new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[6]), 
								font_pid_1);
						/*Font font_pid_o = new Font("黑体", Font.BOLD, 6);
						drawString_1(g2, officalWebsite, new PointCoordinate(left_1+18+shuiping,Point_device_1.y+c[5]), 
								font_pid_o);*/
						break;
					}
					case "电力线无线路由器":
					{
						//电源、设备名、设备型号、设备地址在上面已经获取
						String deviceSN = info.getDeviceSN();
						String manageIP = info.getManageIP();
						String deviceVersion = info.getDeviceVresion();
						String officalWebsite = info.getOfficialWebsite();
						
						//int chuizhi = -1;		//垂直方向的偏移
						int shuiping = 0;
	
						//公司Eastsoft
						PointCoordinate PointLogo_1 = new PointCoordinate(left_1 + 4,top_1+2);
						Font font_es = new Font("微软雅黑", Font.BOLD, 12);
						Font font_r = new Font("微软雅黑", Font.BOLD, 7);
						new MyLogo(g2, PointLogo_1, font_es, font_r).drawLogo(5.2f);
						
						PointCoordinate Point_device_1 = new PointCoordinate(left_1 + 1, PointLogo_1.y + 16);
						int c[] = {-8,2,12,22,30,38,46};
						
						//设备类型
						Font font_eastsoft_1 = new Font("微软雅黑", Font.PLAIN, 6);
						drawString_1(g2, info.getdeviceType()+" Router", 
								new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[0]), font_eastsoft_1);
						
						//设备名
						Font font_pid_deviceName = new Font("微软雅黑", Font.BOLD, 7);
						PointCoordinate Point_id_1 = new PointCoordinate(left_1 + 4+shuiping,
								Point_device_1.y+c[1]);
						drawString_1(g2, deviceName, Point_id_1, font_pid_deviceName);
						
						g2.setStroke(new BasicStroke(0.5f));
						g2.drawLine(left_1 + 4+shuiping, Point_device_1.y+c[2]-7, left_1 + 64+shuiping, 
								Point_device_1.y+c[2]-7);
						//官网
						drawString_1(g2, officalWebsite, new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[2]), 
								new Font("微软雅黑", Font.PLAIN, 6));
						//下半部分
						Font font_pid_1 = new Font("微软雅黑", Font.BOLD, 5);
						drawString_1(g2, "电源: "+power, new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[3]), 
								font_pid_1);
						drawString_1(g2, "用户名: "+info.getUserName(), new PointCoordinate(left_1 + 48+shuiping,Point_device_1.y+c[4]), 
								font_pid_1);
						drawString_1(g2, "IP: "+manageIP, new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[4]), 
								font_pid_1);
						drawString_1(g2, "密码: "+info.getPasswd(), new PointCoordinate(left_1 + 80+shuiping,Point_device_1.y+c[4]), 
								font_pid_1);
						drawString_1(g2, "PLC MAC: "+deviceID, new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[5]), 
								font_pid_1);
						drawString_1(g2, "S/N: "+deviceSN, new PointCoordinate(left_1 + 4+shuiping,Point_device_1.y+c[6]), 
								font_pid_1);
						/*Font font_pid_o = new Font("黑体", Font.BOLD, 6);
						drawString_1(g2, officalWebsite, new PointCoordinate(left_1+18+shuiping,Point_device_1.y+c[5]), 
								font_pid_o);*/
						break;
					}
				}
				// draw binaryCode 二维码使用同一个打印
				File barCode_1 = new File("new_test_QR_CODE.png");
				Image src_1 = null;
				if (barCode_1.exists()) {
					try {
						src_1 = ImageIO.read(new FileInputStream(barCode_1));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// draw 二维码整体
				PointCoordinate left_top_1 = new PointCoordinate(
						(int) (left_1 + 2 * PrintFinal.INCH / 2.54) -6,
						top_1 +3);
				FourCornorsShowSize showSize_1 = new FourCornorsShowSize(39, 40);
				PicShowSet picShowset_1 = new PicShowSet(42, 42, -11, 17);
				Font font_1 = new Font("黑体", Font.BOLD, 3);
				g2.setStroke(new BasicStroke(0.8f, BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));
				new MyBarCodeAll(font_1, g2 ,left_top_1, src_1, "", "",showSize_1,picShowset_1).drawNewAll(LINE_LENGTH - 2, 3,
						0);
			}
			return PAGE_EXISTS;

		} else {
			return NO_SUCH_PAGE;
		}
	}
	
	// 两点之间画一条线
	private void drawLine1(Graphics2D g2, PointCoordinate point1, PointCoordinate point2,
			Font font) {
		g2.setFont(font);
		g2.drawLine(point1.x, point1.y, point2.x, point2.y);
	}
	
	private void drawString_2(Graphics2D g2, String str, PointCoordinate point,
			Font font) {
		g2.setColor(Color.WHITE);
		g2.setFont(font);// 设置字体
		g2.drawString(str, point.x, point.y);
	}

	
	private void drawString_1(Graphics2D g2, String str, PointCoordinate point,
			int fontstyle, int fontSize) {
		Font font = new Font("黑体", fontstyle, fontSize);
		g2.setFont(font);// 设置字体
		g2.drawString(str, point.x, point.y);
	}

	private void drawString_1(Graphics2D g2, String str, PointCoordinate point,
			int fontstyle, int fontSize, boolean vertical) {
		Font font = new Font("黑体", fontstyle, fontSize);
		g2.setFont(font);// 设置字体
		if (vertical) {
			g2.rotate(Math.PI * 0.5);
		}
		g2.drawString(str, point.x, point.y);
	}

	private void drawString_1(Graphics2D g2, String str, PointCoordinate point,
			Font font) {
		g2.setFont(font);// 设置字体
		g2.drawString(str, point.x, point.y);
	}

	private void drawString_1(Graphics2D g2, String str, PointCoordinate point,
			Font font, boolean vertical) {
		g2.setFont(font);// 设置字体
		if (vertical) {
			g2.rotate(Math.PI * 0.5);
		}
		g2.drawString(str, point.x, point.y);
	}

	private void drawString(Graphics2D g2, String str, PointCoordinate point,
			int fontstyle, int fontSize) {
		Font font = new Font("微软雅黑", fontstyle, fontSize);
		g2.setFont(font);// 设置字体
		g2.drawString(str, point.x, point.y);
	}

	private void drawString(Graphics2D g2, String str, PointCoordinate point,
			int fontstyle, int fontSize, boolean vertical) {
		Font font = new Font("微软雅黑", fontstyle, fontSize);
		g2.setFont(font);// 设置字体
		if (vertical) {
			g2.rotate(Math.PI * 0.5);
		}
		g2.drawString(str, point.x, point.y);
	}

	private void drawString(Graphics2D g2, String str, PointCoordinate point,
			Font font) {
		g2.setFont(font);// 设置字体
		g2.drawString(str, point.x, point.y);
	}

	private void drawString(Graphics2D g2, String str, PointCoordinate point,
			Font font, boolean vertical) {
		g2.setFont(font);// 设置字体
		if (vertical) {
			g2.rotate(Math.PI * 0.5);
		}
		g2.drawString(str, point.x, point.y);
	}

	class PointCoordinate {

		public PointCoordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int x;
		public int y;
	}

	class FourLineCorners {
		private Graphics2D g2;
		private PointCoordinate left_top;
		private int lineLength, width, height;

		public FourLineCorners(Graphics2D g2, PointCoordinate left_top,
				int lineLength, int width, int height) {
			this.g2 = g2;
			this.left_top = left_top;
			this.lineLength = lineLength;
			this.width = width;
			this.height = height;
		}

		/**
		 * 画二维码图片周围四个角的横线和竖线 left_top--left_bottom--right_top--right_bottom
		 * ------先横后竖
		 */
		public void drawFourCorners() {
			// left_top--left_bottom--right_top--right_bottom ------先横后竖
			// left_top
			g2.drawLine(left_top.x, left_top.y, left_top.x + lineLength,
					left_top.y);

			g2.drawLine(left_top.x, left_top.y, left_top.x, left_top.y
					+ lineLength);
			// left_bottom
			g2.drawLine(left_top.x, left_top.y + height, left_top.x
					+ lineLength, left_top.y + height);

			g2.drawLine(left_top.x, left_top.y + height, left_top.x, left_top.y
					+ height - lineLength);
			// right_top
			g2.drawLine(left_top.x + width, left_top.y, left_top.x + width
					- lineLength, left_top.y);

			g2.drawLine(left_top.x + width, left_top.y, left_top.x + width,
					left_top.y + lineLength);

			// right_bottom
			g2.drawLine(left_top.x + width, left_top.y + height, left_top.x
					+ width - lineLength, left_top.y + height);

			g2.drawLine(left_top.x + width, left_top.y + height, left_top.x
					+ width, left_top.y + height - lineLength);

		}

	}

	class MyBarPic {
		private Graphics2D g2;
		private PointCoordinate left_top;
		private Image img;
		private int showWidth;
		private int showHeigth;

		public MyBarPic(Graphics2D g2, Image img, PointCoordinate left_top,
				int showWidth, int showHeigth) {
			this.g2 = g2;
			this.img = img;
			this.left_top = left_top;
			this.showWidth = showWidth;
			this.showHeigth = showHeigth;
		}

		public void drawImage() {
			g2.drawImage(img, left_top.x, left_top.y, left_top.x + showWidth,
					left_top.y + showHeigth, 0, 0, img.getWidth(null),
					img.getHeight(null), null);
		}
	}

	class MyLogo {
		private PointCoordinate left_top;
		private Graphics2D g2;
		private Font font_es;
		private Font font_r;

		public MyLogo(Graphics2D g2, PointCoordinate left_top) {
			this.g2 = g2;
			this.left_top = left_top;
		}

		public MyLogo(Graphics2D g2, PointCoordinate left_top, Font font_es,
				Font font_r) {
			this.g2 = g2;
			this.left_top = left_top;
			this.font_es = font_es;
			this.font_r = font_r;
		}

		public void drawLogo(float moveR) {
			String company = info.getCompany();
			String houzhui = "®";
			if(StringUtils.isEmpty(company)){
				houzhui = "";
			}
			if (font_es == null && font_r == null) {
				Font font1 = new Font("微软雅黑", Font.BOLD, 11);
				drawString(g2, company, left_top.x, left_top.y, font1);
				drawString(g2, houzhui, left_top.x
						+ (int) (font1.getSize() * (moveR-1)), left_top.y,
						new Font("微软雅黑", Font.BOLD, 4));
			} else {
				drawString(g2, company, left_top.x, left_top.y, font_es);
				drawString(g2, houzhui, left_top.x
						+ (int) (font_es.getSize() * (moveR-1)), left_top.y, font_r);
			}
		}

		private void drawString(Graphics2D g2, String str, int x, int y,
				Font font) {
			g2.setFont(font);// 设置字体
			g2.drawString(str, x, y);
		}
	}

	class MyAidPasswd {
		private Graphics2D g2;
		private PointCoordinate Middle;
		private String aid;
		private String passwd;
		private Font font;

		public MyAidPasswd(Graphics2D g2, PointCoordinate Middle, Font font,
				String aid, String passwd) {
			this.g2 = g2;
			this.Middle = Middle;
			this.font = font;
			this.aid = aid;
			this.passwd = passwd;
		}

		public void drawAidPasswd() {
			g2.setFont(font);
			g2.drawString("A" + aid, Middle.x
					- (int) (((aid.length() + 1) / 2) * (font.getSize() / 2))
					- 2, Middle.y);
			g2.drawString(
					"P" + passwd,
					Middle.x
							- (int) (((passwd.length() + 1) / 2) * (font
									.getSize() / 2)) + 1,
					Middle.y + font.getSize());
		}
		
		//昊想智能
		public void drawAidPasswdHO() {
			g2.setFont(font);
			g2.drawString(aid, Middle.x
					- (int) (((aid.length() + 1) / 2) * (font.getSize() / 2))+1, Middle.y);
			/*g2.drawString(
					"P" + passwd,
					Middle.x
							- (int) (((passwd.length() + 1) / 2) * (font
									.getSize() / 2)) + 1,
					Middle.y + font.getSize());*/
		}
	}

	class MyBarCodeAll {

		private Graphics2D g2;
		private PointCoordinate left_top;
		private Image img;
		private String aid;
		private String passwd;
		private String devicetype;
		private String deviceid;
		private String devicessid;
		private String devicepassword;

		private int margin_s = LINE_TO_PIC_MARGIN_S;
		private int margin_h = LINE_TO_PIC_MARGIN_H;
		private Font font;
		private int showHeigth = BAR_SHOW_HEIGHT;
		private int showWidth = BAR_SHOW_WIDTH;
		private int width = FOUR_CORNERS_WIDTH;
		private int height = FOUR_CORNERS_HEIGHT;

		/**
		 * 画二维码边框+图片+aid等
		 * 
		 * @param font
		 * @param g2
		 * @param left_top
		 *            边框左上角的点坐标
		 * @param img
		 *            图片
		 * @param aid
		 * @param passwd
		 */
		public MyBarCodeAll(Font font, Graphics2D g2, PointCoordinate left_top,
				Image img, String aid, String passwd) {
			this.font = font;
			this.g2 = g2;
			this.g2.setFont(font);
			this.left_top = left_top;
			this.img = img;
			this.aid = aid;
			this.passwd = passwd;

		}

		/**
		 * 自定义二维码边框的大小
		 * 
		 * @param font
		 * @param g2
		 * @param left_top
		 * @param img
		 * @param aid
		 * @param passwd
		 * @param cornersSize
		 */
		public MyBarCodeAll(Font font, Graphics2D g2, PointCoordinate left_top,
				Image img, String aid, String passwd,
				FourCornorsShowSize cornersSize) {
			this(font, g2, left_top, img, aid, passwd);
			this.width = cornersSize.fourCornors_show_width;
			this.height = cornersSize.fourCornors_show_height;
		}

		/**
		 * 自定义二维码图片的位置和显示大小
		 * 
		 * @param font
		 * @param g2
		 * @param left_top
		 * @param img
		 * @param aid
		 * @param passwd
		 * @param picShowset
		 * 
		 */
		public MyBarCodeAll(Font font, Graphics2D g2, PointCoordinate left_top,
				Image img, String aid, String passwd, PicShowSet picShowset) {
			this(font, g2, left_top, img, aid, passwd);

			this.margin_s = picShowset.margin_s;
			this.margin_h = picShowset.margin_h;
			this.showWidth = picShowset.pic_show_width;
			this.showHeigth = picShowset.pic_show_height;
		}

		/**
		 * 自定义二维码边框及图片的位置和显示大小
		 * 
		 * @param font
		 * @param g2
		 * @param left_top
		 * @param img
		 * @param aid
		 * @param passwd
		 * @param cornersSize
		 * @param picShowset
		 */
		public MyBarCodeAll(Font font, Graphics2D g2, PointCoordinate left_top,
				Image img, String aid, String passwd,
				FourCornorsShowSize cornersSize, PicShowSet picShowset) {
			this(font, g2, left_top, img, aid, passwd, cornersSize);

			this.margin_s = picShowset.margin_s;
			this.margin_h = picShowset.margin_h;
			this.showWidth = picShowset.pic_show_width;
			this.showHeigth = picShowset.pic_show_height;
		}
		

		private void drawAll(int line_length, int xMove, int yMove) {
			// TODO Auto-generated method stub
			new FourLineCorners(g2, left_top, line_length, width, height)
					.drawFourCorners();
			PointCoordinate pic_left_top = new PointCoordinate(left_top.x
					+ margin_h, left_top.y + margin_s);
			new MyBarPic(g2, img, pic_left_top, showWidth, showHeigth)
					.drawImage();
			PointCoordinate middle = new PointCoordinate(pic_left_top.x
					+ showWidth / 2 - 5 + xMove, pic_left_top.y + showHeigth
					+ font.getSize() + yMove);
			new MyAidPasswd(g2, middle, font, aid, passwd).drawAidPasswd();

		}
		//昊想
		
		private void drawAllHO(int line_length, int xMove, int yMove) {
			// TODO Auto-generated method stub
			//new FourLineCorners(g2, left_top, line_length, width, height)
					//.drawFourCorners();
			PointCoordinate pic_left_top = new PointCoordinate(left_top.x
					+ margin_h, left_top.y + margin_s);
			new MyBarPic(g2, img, pic_left_top, showWidth, showHeigth)
					.drawImage();
			PointCoordinate middle = new PointCoordinate(pic_left_top.x
					+ showWidth / 2 - 5 + xMove, pic_left_top.y + showHeigth
					+ font.getSize() + yMove);
			new MyAidPasswd(g2, middle, font, aid, passwd).drawAidPasswdHO();

		}
		private void drawNewAll(int line_length, int xMove, int yMove) {
			// TODO Auto-generated method stub
//			new FourLineCorners(g2, left_top, line_length, width, height)
//					.drawFourCorners();
			PointCoordinate pic_left_top = new PointCoordinate(left_top.x
					+ margin_h, left_top.y + margin_s);
			new MyBarPic(g2, img, pic_left_top, showWidth, showHeigth)
					.drawImage();
			PointCoordinate middle = new PointCoordinate(pic_left_top.x
					+ showWidth / 2 - 5 + xMove, pic_left_top.y + showHeigth
					+ font.getSize() + yMove);
		}
		
	}
	//	wzj	
	//	画另一张图片 用于PLC_Sub1G
	class OtherImage {
		private Font font;
		private Graphics2D g2;
		private PointCoordinate left_top;
		private Image img;
		
		private int margin_s = LINE_TO_PIC_MARGIN_S;
		private int margin_h = LINE_TO_PIC_MARGIN_H;
		private int showHeigth = BAR_SHOW_HEIGHT;
		private int showWidth = BAR_SHOW_WIDTH;
		
		public OtherImage(Font font, Graphics2D g2, PointCoordinate left_top,
				Image img, PicShowSet picShowset) {
			this.font = font;
			this.g2 = g2;
			this.left_top = left_top;
			this.img = img;
			
			this.margin_s = picShowset.margin_s;
			this.margin_h = picShowset.margin_h;
			this.showWidth = picShowset.pic_show_width;
			this.showHeigth = picShowset.pic_show_height;
		}

		private void drawAll(int line_length, int xMove, int yMove) {
			// TODO Auto-generated method stub
			PointCoordinate pic_left_top = new PointCoordinate(left_top.x
					+ margin_h, left_top.y + margin_s);
			new MyBarPic(g2, img, pic_left_top, showWidth, showHeigth)
					.drawImage();
			PointCoordinate middle = new PointCoordinate(pic_left_top.x
					+ showWidth / 2 - 5 + xMove, pic_left_top.y + showHeigth
					+ font.getSize() + yMove);
		}
		
	}

	class PicShowSet {
		private int pic_show_width;
		private int pic_show_height;
		private int margin_s;
		private int margin_h;

		public PicShowSet(int pic_show_width, int pic_show_height,
				int margin_s, int margin_h) {
			this.pic_show_width = pic_show_width;
			this.pic_show_height = pic_show_height;
			this.margin_s = margin_s;
			this.margin_h = margin_h;
		}
	}

	class FourCornorsShowSize {
		private int fourCornors_show_width;
		private int fourCornors_show_height;

		public FourCornorsShowSize(int fourCornors_show_width,
				int fourCornors_show_height) {
			this.fourCornors_show_width = fourCornors_show_width;
			this.fourCornors_show_height = fourCornors_show_height;
		}
	}

	class MyCircle {

		private Graphics g2;
		private PointCoordinate left_top;
		private int r;
		private Font font;
		private String content;

		public MyCircle(Graphics2D g2, PointCoordinate left_top, int r,
				String content, Font font) {
			this.g2 = g2;
			this.left_top = left_top;
			this.r = r;
			this.font = font;
			this.content = content;

		}

		public void drawCircle(boolean normal, int zinum) {
			g2.setFont(font);
			if (normal) {
				g2.drawOval(left_top.x, left_top.y, r, r);
				g2.drawString(content, left_top.x + (int) (r * 1.5), left_top.y
						+ r);
			} else {
				g2.drawOval(left_top.x - 7, left_top.y, r, r);
				g2.drawString(content, left_top.x - (int) (r * 4) - zinum
						* font.getSize() - 2, left_top.y + r);
			}
		}// 正反模式下的画圈函数

		public void drawCircle_1(boolean normal, int zinum) {
			g2.setFont(font);
			if (normal) {
				g2.drawOval(left_top.x, left_top.y, r, r);
				g2.drawString(content, left_top.x + (int) (r * 1.5), left_top.y
						+ r);
			} else {
				g2.drawOval(left_top.x + 15, left_top.y, r, r);
				g2.drawString(content, left_top.x - (int) (r * 5) - zinum
						* font.getSize() - 2, left_top.y + r);
			}
		}

		//
		public void drawCircle_2(boolean normal, int zinum) {
			g2.setFont(font);
			if (normal) {
				g2.drawOval(left_top.x, left_top.y, r, r);
				g2.drawString(content, left_top.x + (int) (r * 1.5), left_top.y
						+ r);
			} else {
				g2.drawOval(left_top.x + 10, left_top.y, r, r);
				g2.drawString(content, left_top.x - (int) (r * 3) - zinum
						* font.getSize() - 2, left_top.y + r);
			}
		}

		public void drawCircle(boolean normal, int zinum, boolean v) {
			g2.setFont(font);

			if (normal) {
				g2.drawOval(left_top.x, left_top.y, r, r);
				g2.drawString(content, left_top.x + (int) (r * 1.5), left_top.y
						+ r);
			} else {
				g2.drawOval(left_top.x, left_top.y, r, r);
				g2.drawString(content, left_top.x - (int) (r * 4) - zinum
						* font.getSize(), left_top.y + r);
			}
		}
	}
//	class DrawLine {
//		private int x1;
//		private int x2;
//		private int y1;
//		private int y2;
//		private void drawLine(Graphics2D g2, PointCoordinate point, Font font) {
//			g2.drawLine(x1, y1, x2, y2);
//			
//		}
//	}
}
