package com.eastsoft.main;
/**
 * 编码修改为UTF-8
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.eastsoft.ui.MainUI;

public class Main {
	public static final String[] selectItem =  {"86盒生产工装","整机测试工装","不干了"};
	private static int response;
	
	private static int startDialog(){
		int response = JOptionPane.showOptionDialog(null, "您这是要使用哪种工装", "选择工装",
				0, JOptionPane.INFORMATION_MESSAGE,
				null, selectItem, selectItem[0]);
		System.out.print("you choose: "+ response);
		return response;
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				
				//tianbaolei 使用本地系统界面风格，这么做使用标签页时标题显示更清晰
				try{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					/*使用java的界面外观时将上面参数换为："javax.swing.plaf.metal.MetalLookAndFeel"*/
				}catch(Exception e){
					e.printStackTrace();
				}
				response = startDialog();
				if(response ==1 || response ==0){
					MainUI inst = MainUI.getInstance(response);
					inst.setLocationRelativeTo(null);
					//add EXIT_ON_CLOSE
					inst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					inst.setVisible(true);
				}
			}
		});

	}
	
}
