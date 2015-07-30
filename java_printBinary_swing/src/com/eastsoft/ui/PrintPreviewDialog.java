package com.eastsoft.ui;
/**
 * 编码修改为UTF-8
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.eastsoft.print.MyPaperFormat;
import com.eastsoft.print.MyPrint;
import com.eastsoft.util.PrintFinal;
import com.eastsoft.util.SystemProperties;

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
public class PrintPreviewDialog extends JDialog implements ActionListener {
	private JButton jButton_printPreviewCloseButton = new JButton("Close");
	private JPanel buttonPanel = new JPanel();
	private PreviewCanvas canvas;
	private JButton jButton_printPreviewPrintLabel;
	private MainUI mainJUI;
	public PrintPreviewDialog(MainUI mainJUI,Frame parent, String title, boolean modal,
			MyPrint mp) {
		super(parent, title, modal);
		canvas = new PreviewCanvas(mp);
		this.mainJUI = mainJUI;
		setLayout();
	}

	
	private void setLayout() {
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(canvas, BorderLayout.CENTER);

		jButton_printPreviewCloseButton.addActionListener(this);
		jButton_printPreviewCloseButton.setText("\u5173\u95ed");		//关闭
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setPreferredSize(new java.awt.Dimension(392, 67));
		buttonPanel.setLayout(null);
		buttonPanel.add(jButton_printPreviewCloseButton);
		jButton_printPreviewCloseButton.setBounds(58, 9, 98, 44);
		jButton_printPreviewCloseButton.setSize(100, 45);
		{
			jButton_printPreviewPrintLabel = new JButton();
			jButton_printPreviewPrintLabel.addActionListener(this);
			buttonPanel.add(jButton_printPreviewPrintLabel);
			jButton_printPreviewPrintLabel.setText("\u6253\u5370");		//打印
			jButton_printPreviewPrintLabel.setBounds(282, 10, 100, 43);
			jButton_printPreviewPrintLabel.setSize(100, 45);
		}
		this.setBounds((int)((SystemProperties.SCREEN_WIDTH - 463) / 2), (int)((SystemProperties.SCREEN_HEIGHT - 463) / 2), 463, 463);
	
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	
	}

	class PreviewCanvas extends JPanel {
		private int currentPage = 0;
		private MyPrint myPrint;

		public PreviewCanvas(MyPrint mp) {
			myPrint = mp;
		}

		
		
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;		
			MyPaperFormat pf = new MyPaperFormat(mainJUI);			
			double xoff;
			double yoff;
			double scale;
			double px = pf.getWidth();
			double py = pf.getHeight();
			double sx = this.getWidth() - 1;
			double sy = this.getHeight() - 1;	
			if (px / py < sx / sy) {
				scale = sy / py;
				xoff = 0.5 * (sx - scale * px);
				yoff = 0;
			} else {
				scale = sx / px;
				xoff = 0;
				yoff = 0.5 * (sy - scale * py);
			}
			g2.translate((float) xoff, (float) yoff);
			g2.scale((float) scale, (float) scale);
			Rectangle2D page = new Rectangle2D.Double(0, 0, px, py);
			g2.setPaint(Color.white);
			g2.fill(page);
			g2.setPaint(Color.blue);
			g2.draw(page);
			try {
				mainJUI.productQRCode();
				myPrint.print(g2, pf, currentPage);
			} catch (PrinterException pe) {
				System.out.println("print is wrong");
			}

		}

	}

	private void closeAction() {
		this.setVisible(false);
		this.setEnabled(false);
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		Object src = evt.getSource();
		if (src == jButton_printPreviewCloseButton) {
			closeAction();
		}else if(src == jButton_printPreviewPrintLabel){
			mainJUI.productQRCode();
			mainJUI.printBinaryPicture();
		}
	}
}
