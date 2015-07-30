package com.eastsoft.print;
/**
 * 编码修改为UTF-8
 */
import java.awt.print.PageFormat;
import java.awt.print.Paper;

import com.eastsoft.ui.MainUI;
import com.eastsoft.util.PrintFinal;

public class MyPaperFormat extends PageFormat {

	int orientation = PageFormat.PORTRAIT;

	/**
	 * 
	 * @param arg0
	 *            paper width cm
	 * @param arg1
	 *            paper height cm
	 * @param orientation
	 *            orientation PageFormat.PORTRAIT/PageFormat.LANDSCAPE
	 */
	public MyPaperFormat(double arg0, double arg1, int orientation,
			MainUI mainJUI) {
		super();
		Paper p = new Paper();
		p.setSize(arg0 * PrintFinal.INCH / 2.54, arg1 * PrintFinal.INCH / 2.54);// 纸张大小
		p.setImageableArea(0, 0, arg0 * PrintFinal.INCH / 2.54, arg1
				* PrintFinal.INCH / 2.54);
		setPaper(p);
		setOrientation(orientation);
	}

	/**
	 * 
	 * @param arg0
	 *            paper width cm
	 * @param arg1
	 *            paper height cm
	 * 
	 */
	public MyPaperFormat(double arg0, double arg1, MainUI mainJUI) {
		super();
		Paper p = new Paper();
		p.setSize(arg0 * PrintFinal.INCH / 2.54, arg1 * PrintFinal.INCH / 2.54);// 纸张大小
		p.setImageableArea(0, 0, arg0 * PrintFinal.INCH / 2.54, arg1
				* PrintFinal.INCH / 2.54);
		setPaper(p);
	}

	/**
	 * 根据打印样式来选取适当的打印尺寸
	 */
	public MyPaperFormat(MainUI mainJUI) {
		super();
		setPaper(mainJUI.getPageFormFormat());
	}
	public void setShowOrientation(int orientation) {
		setOrientation(orientation);
	}

	private Paper setPapeSize(double width, double height) {
		Paper p = new Paper();
		p.setSize(width, height);// 纸张大小
		p.setImageableArea(0, 0, width, height);
		return p;
	}

}
