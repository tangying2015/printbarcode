package test;
/**
 * 编码修改为UTF-8
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogDemo extends JFrame implements ItemListener {
	JRadioButton rbtnError, rbtnInterMess, rbtnWarn, rbtnSelect;
	JPanel pnlMain;
	ButtonGroup bgMain;

	public DialogDemo() {
		pnlMain = new JPanel(new GridLayout(5, 1));
		getContentPane().add(pnlMain);
		rbtnError = new JRadioButton("错误对话框");
		rbtnError.setSelected(true);
		rbtnInterMess = new JRadioButton("内部信息对话框");
		rbtnWarn = new JRadioButton("警告对话框");
		rbtnSelect = new JRadioButton("选择对话框");
		bgMain = new ButtonGroup();
		bgMain.add(rbtnError);
		bgMain.add(rbtnInterMess);
		bgMain.add(rbtnSelect);
		bgMain.add(rbtnWarn);
		rbtnError.addItemListener(this);
		rbtnInterMess.addItemListener(this);
		rbtnSelect.addItemListener(this);
		rbtnWarn.addItemListener(this);
		pnlMain.add(rbtnError);
		pnlMain.add(rbtnInterMess);
		pnlMain.add(rbtnSelect);
		pnlMain.add(rbtnWarn);
		setTitle("对话框演示");
		setSize(250, 150);
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) {
		if (rbtnError.isSelected())
			// 显示一个错误对话框
			JOptionPane.showMessageDialog(null, "程序错误", "错误",
					JOptionPane.ERROR_MESSAGE);
		if (rbtnInterMess.isSelected())
			// 显示一个信息面板
			JOptionPane.showConfirmDialog(null, "请选择一个", "选择",
					JOptionPane.YES_NO_CANCEL_OPTION);
		if (rbtnWarn.isSelected()) {
			// 显示一个警告对话框
			Object[] options = { "确定", "取消" };
			JOptionPane.showOptionDialog(null, "点击'确定'继续", "警告",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
		}
		if (rbtnSelect.isSelected()) {
			// 显示一个要求用户输入字符串的对话框
			Object[] possibleValues = { "金牌", "银牌", "铜牌" };
			Object selectedValue = JOptionPane.showInputDialog(null, "选择一个",
					"输入", JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			JOptionPane.showMessageDialog(null,
					"你的选择是：" + selectedValue.toString());
		}
	}

	public static void main(String[] args) {
		new DialogDemo();
	}

}