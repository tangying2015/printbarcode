package com.eastsoft.ui;
/**
 * 编码修改为UTF-8
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.eastsoft.util.LabelsUtil;


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
public class DeleteTokensFrame extends javax.swing.JFrame {
	private JScrollPane jScrollPane_devices;
	private JScrollPane jScrollPane_products;
	private JButton jButton_deleteProduct;
	private JButton jButton_deletePower;
	private JButton jButton_deleteVoltage;
	private JButton jButton_deleteDevice;
	private JScrollPane jScrollPane_powers;
	private JScrollPane jScrollPane_voltages;
	JTable table_device;
	DefaultTableModel tm_device;
	private DefaultTableModel tm_product;
	private JTable table_product;
	private JTable table_voltage;
	private JButton jButton_deleteCurrent;
	private JTable table_current;
	private JScrollPane jScrollPane_Currents;
	private JLabel jLabel1;
	private DefaultTableModel tm_current;
	private DefaultTableModel tm_voltage;
	private JTable table_power;
	private DefaultTableModel tm_power;
	private MainUI mainGui;
	/**
	* Auto-generated main method to display this JFrame
	*//*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DeleteTokensFrame inst = new DeleteTokensFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public DeleteTokensFrame(MainUI mainGui) {
		super();
		this.mainGui = mainGui;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				Object[] columnNames = {"设备名称","选中"};  
				Object[][] devices = getObjectsFromfile("devices.txt");
				
				tm_device = new DefaultTableModel(devices, columnNames);
				table_device = new JTable(tm_device);
				table_device.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value,
							boolean isSelected, boolean hasFocus, int row, int column) {
								// TODO Auto-generated method stub
								// 创建用于返回的渲染组件
								JCheckBox ck = new JCheckBox();
								// 使具有焦点的行对应的复选框选中
								ck.setSelected(isSelected);
								// 设置背景颜色 这里是设置jcheckbox的背景颜色
								// 直接设置为透明，我这里是用了一种明暗交替的颜色转换，所以背景颜色设置了一下
								ck.setOpaque(false);
								// 设置单选box.setSelected(hasFocus);
								// 使复选框在单元格内居中显示
								ck.setHorizontalAlignment((int) 0.5f);
								return ck;
					}
				});
				
				jScrollPane_devices = new JScrollPane(table_device);
				getContentPane().add(jScrollPane_devices);
				jScrollPane_devices.setBounds(17, 17, 205, 241);
			}
			{
				
				Object[] columnNames = {"设备型号","选中"};  
				Object[][] products = getObjectsFromfile("products.txt");
				
				tm_product = new DefaultTableModel(products, columnNames);
				table_product = new JTable(tm_product);
				table_product.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value,
							boolean isSelected, boolean hasFocus, int row, int column) {
								// TODO Auto-generated method stub
								// 创建用于返回的渲染组件
								JCheckBox ck = new JCheckBox();
								// 使具有焦点的行对应的复选框选中
								ck.setSelected(isSelected);
								// 设置背景颜色 这里是设置jcheckbox的背景颜色
								// 直接设置为透明，我这里是用了一种明暗交替的颜色转换，所以背景颜色设置了一下
								ck.setOpaque(false);
								// 设置单选box.setSelected(hasFocus);
								// 使复选框在单元格内居中显示
								ck.setHorizontalAlignment((int) 0.5f);
								return ck;
					}
				});
				
				jScrollPane_products = new JScrollPane(table_product);
				getContentPane().add(jScrollPane_products);
				jScrollPane_products.setBounds(242, 17, 192, 241);
			}
			{
				
				Object[] columnNames = {"额定电压","选中"};  
				Object[][] voltages = getObjectsFromfile("voltages.txt");
				
				tm_voltage = new DefaultTableModel(voltages, columnNames);
				table_voltage = new JTable(tm_voltage);
				table_voltage.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value,
							boolean isSelected, boolean hasFocus, int row, int column) {
								// TODO Auto-generated method stub
								// 创建用于返回的渲染组件
								JCheckBox ck = new JCheckBox();
								// 使具有焦点的行对应的复选框选中
								ck.setSelected(isSelected);
								// 设置背景颜色 这里是设置jcheckbox的背景颜色
								// 直接设置为透明，我这里是用了一种明暗交替的颜色转换，所以背景颜色设置了一下
								ck.setOpaque(false);
								// 设置单选box.setSelected(hasFocus);
								// 使复选框在单元格内居中显示
								ck.setHorizontalAlignment((int) 0.5f);
								return ck;
					}
				});
				jScrollPane_voltages = new JScrollPane(table_voltage);
				getContentPane().add(jScrollPane_voltages);
				jScrollPane_voltages.setBounds(446, 17, 135, 241);
			}
			{

				
				Object[] columnNames = {"额定电流","选中"};  
				Object[][] currents = getObjectsFromfile("currents.txt");
				
				tm_current= new DefaultTableModel(currents, columnNames);
				table_current = new JTable(tm_current);
				table_current.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value,
							boolean isSelected, boolean hasFocus, int row, int column) {
								// TODO Auto-generated method stub
								// 创建用于返回的渲染组件
								JCheckBox ck = new JCheckBox();
								// 使具有焦点的行对应的复选框选中
								ck.setSelected(isSelected);
								// 设置背景颜色 这里是设置jcheckbox的背景颜色
								// 直接设置为透明，我这里是用了一种明暗交替的颜色转换，所以背景颜色设置了一下
								ck.setOpaque(false);
								// 设置单选box.setSelected(hasFocus);
								// 使复选框在单元格内居中显示
								ck.setHorizontalAlignment((int) 0.5f);
								return ck;
					}
				});
				jScrollPane_Currents = new JScrollPane(table_current);
				getContentPane().add(jScrollPane_Currents);
				jScrollPane_Currents.setBounds(602, 17, 123, 241);
			
			}
			{
				
				Object[] columnNames = {"额定功率","选中"};  
				Object[][] powers = getObjectsFromfile("powers.txt");
				
				tm_power = new DefaultTableModel(powers, columnNames);
				table_power = new JTable(tm_power);
				table_power.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value,
							boolean isSelected, boolean hasFocus, int row, int column) {
								// TODO Auto-generated method stub
								// 创建用于返回的渲染组件
								JCheckBox ck = new JCheckBox();
								// 使具有焦点的行对应的复选框选中
								ck.setSelected(isSelected);
								// 设置背景颜色 这里是设置jcheckbox的背景颜色
								// 直接设置为透明，我这里是用了一种明暗交替的颜色转换，所以背景颜色设置了一下
								ck.setOpaque(false);
								// 设置单选box.setSelected(hasFocus);
								// 使复选框在单元格内居中显示
								ck.setHorizontalAlignment((int) 0.5f);
								return ck;
					}
				});
				jScrollPane_powers = new JScrollPane(table_power);
				getContentPane().add(jScrollPane_powers);
				jScrollPane_powers.setBounds(737, 17, 175, 241);
			}
			{
				jButton_deleteDevice = new JButton();
				getContentPane().add(jButton_deleteDevice);
				jButton_deleteDevice.setText("\u5220\u9664\u8bbe\u5907");
				jButton_deleteDevice.setBounds(72, 275, 87, 24);
				jButton_deleteDevice.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton_deleteDeviceActionPerformed(evt);
					}
				});
			}
			{
				jButton_deleteProduct = new JButton();
				getContentPane().add(jButton_deleteProduct);
				jButton_deleteProduct.setText("\u5220\u9664\u578b\u53f7");
				jButton_deleteProduct.setBounds(289, 275, 92, 24);
				jButton_deleteProduct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton_deleteProductActionPerformed(evt);
					}
				});
			}
			{
				jButton_deleteVoltage = new JButton();
				getContentPane().add(jButton_deleteVoltage);
				jButton_deleteVoltage.setText("\u5220\u9664\u7535\u538b");
				jButton_deleteVoltage.setBounds(458, 275, 96, 24);
				jButton_deleteVoltage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton_deleteVoltageActionPerformed(evt);
					}
				});
			}
			{
				jButton_deleteCurrent = new JButton();
				getContentPane().add(jButton_deleteCurrent);
				jButton_deleteCurrent.setText("\u5220\u9664\u7535\u6d41");
				jButton_deleteCurrent.setBounds(622, 275, 94, 24);
				jButton_deleteCurrent.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton_deleteCurrentActionPerformed(evt);
					}
				});
			}
			{
				jButton_deletePower = new JButton();
				getContentPane().add(jButton_deletePower);
				jButton_deletePower.setText("\u5220\u9664\u529f\u7387");
				jButton_deletePower.setBounds(787, 275, 86, 24);
				jButton_deletePower.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton_deletePowerActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5907\u6ce8\uff1a\u6309\u4f4fCtrl\u952e\u591a\u9009\uff1b\u6309\u4f4f\u9f20\u6807\u5de6\u952e\u4e0a\u4e0b\u6ed1\u52a8\u8fde\u7eed\u9009\u4e2d");
				jLabel1.setBounds(17, 316, 383, 18);
			}
			
			
			pack();
			this.setSize(947, 378);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private Object[][] getObjectsFromfile(String path) {
		ArrayList<String> lines = LabelsUtil.readFile(path);
		Object[][] objects = new Object[lines.size()][2];
		for (int i = 0; i < lines.size(); i++) {
			objects[i][0] = lines.get(i);
			// System.out.println(lines.get(i));
		}
		return objects;
	}

	private void jButton_deleteDeviceActionPerformed(ActionEvent evt) {
		int[] SelectRows = table_device.getSelectedRows();
		//从后往前删
		for (int i = SelectRows.length-1; i >= 0; i--) {
			//System.out.print(SelectRows[i] + " "+table_device.getValueAt(SelectRows[i], 0));
			LabelsUtil.deleteString("devices.txt",(String)table_device.getValueAt(SelectRows[i], 0));
			mainGui.jComboBox_chooseDevice.removeItem(table_device.getValueAt(SelectRows[i], 0));
			tm_device.removeRow(SelectRows[i]);
			
		}
	//	mainGui.jComboBox_chooseDevice.repaint();
	}
	
	private void jButton_deleteProductActionPerformed(ActionEvent evt) {
		int[] SelectRows = table_product.getSelectedRows();
		//从后往前删
		for (int i = SelectRows.length-1; i >= 0; i--) {
		//	System.out.println(SelectRows[i] + " "+table_device.getValueAt(SelectRows[i], 0));
			LabelsUtil.deleteString("products.txt",(String)table_product.getValueAt(SelectRows[i], 0));
			mainGui.jComboBox_chooseProductType.removeItem(table_product.getValueAt(SelectRows[i], 0));
			tm_product.removeRow(SelectRows[i]);
		}
	}
	
	private void jButton_deleteVoltageActionPerformed(ActionEvent evt) {
		int[] SelectRows = table_voltage.getSelectedRows();
		//从后往前删
		for (int i = SelectRows.length-1; i >= 0; i--) {
		//	System.out.println(SelectRows[i] + " "+table_device.getValueAt(SelectRows[i], 0));
			LabelsUtil.deleteString("voltages.txt",(String)table_voltage.getValueAt(SelectRows[i], 0));
			mainGui.jComboBox_chooseVoltage.removeItem(table_voltage.getValueAt(SelectRows[i], 0));
			tm_voltage.removeRow(SelectRows[i]);
		}
	}
	private void jButton_deleteCurrentActionPerformed(ActionEvent evt) {
		int[] SelectRows = table_current.getSelectedRows();
		//从后往前删
		for (int i = SelectRows.length-1; i >= 0; i--) {
		//	System.out.println(SelectRows[i] + " "+table_device.getValueAt(SelectRows[i], 0));
			LabelsUtil.deleteString("currents.txt",(String)table_current.getValueAt(SelectRows[i], 0));
			mainGui.jComboBox_chooseCurrent.removeItem(table_current.getValueAt(SelectRows[i], 0));
			tm_current.removeRow(SelectRows[i]);
		}
	}
	private void jButton_deletePowerActionPerformed(ActionEvent evt) {
		int[] SelectRows = table_power.getSelectedRows();
		//从后往前删
		for (int i = SelectRows.length-1; i >= 0; i--) {
		//	System.out.println(SelectRows[i] + " "+table_device.getValueAt(SelectRows[i], 0));
			LabelsUtil.deleteString("powers.txt",(String)table_power.getValueAt(SelectRows[i], 0));
			mainGui.jComboBox_choosePower.removeItem(table_power.getValueAt(SelectRows[i], 0));
			tm_power.removeRow(SelectRows[i]);
		}
	}
	
	

}
