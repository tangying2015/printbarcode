package com.eastsoft.util;
/**
 * 编码修改为UTF-8
 */

/**
 * 单片机网关只检测设备标识码的前6个字节，发的时候不能超过6个字节，多了报错。
 * @author Administrator
 *
 */
public class DeviceTypesID {
	
	
	/**
	 * LCD触摸开关  	√	FFFF1700000（281471067619328）
	 */
	//public static final String LCD_TOUCH_SWITCHER_HEX_ID = "FFFF17000000";
	/**
	 * LCD触摸开关胶州  	√	FFFF17000100
	 */
	public static final String LCD_TOUCH_SWITCHER_HEX_ID = "FFFF17000100";
	
	
	
	/**
	 * （窗帘控制开关）	√	FFFF02000200（281470715298304）
	 */
	public static final String CURTAIN_CTRL_SWITCHER_HEX_ID = "FFFF02000200";
	
	
	/**
	 * 电容触摸开关	√	FFFF02000100
	 */
	public static final String CAP_TOUCH_SWITCHER_HEX_ID = "FFFF02000100";
	
	
	
	/**
	 * RGB调光控制器		FFFF15000000
	 */
	public static final String RGB_CTRLER_HEX_ID = "FFFF15000000";
	//public static final String RGB_CTRLER_HEX_ID = "FFFF150000000200";//两路
	
	
	
	/**
	 * 窗帘控制器		√	FFFF04000100（281470748852224）
	 *//*
	public static final String CURTAIN_CTRLER_HEX_ID = "FFFF02000200";*/
	
	
	
	/**
	 * 	灯光控制器		    FFFF13000000
	 */
	//public static final String LIGHT_CTRLER_HEX_ID = "FFFF130000000200";
	public static final String LIGHT_CTRLER_HEX_ID = "FFFF13000000";//两路
	

	/**
	 * 	调光控制器		    FFFF14000000（281471017287680）
	 */
	//public static final String ADJUST_LIGHT_CTRLER_HEX_ID = "FFFF140000000100";//1路
	public static final String ADJUST_LIGHT_CTRLER_HEX_ID = "FFFF14000000";
	
	
	
	/**
	 * 	电源控制器	    √   FFFF18000100（281471084396800）
	 */
	public static final String POWER_CTRLER_HEX_ID = "FFFF18000100";
	
	
	
	/**
	 * 	红外转发器    	√	FFFF09000100（281470832738560 ）
	 */
	public static final String IR_TRANSFER_HEX_ID = "FFFF09000100";
	
	
	
	/**
	 * 	智能网关	    √	FFFF01000000(281470698520576)
	 */
	public static final String SMART_GATEWAW_HEX_ID = "FFFF01000000";
	/**
	 * 	智能插座		    FFFF0C000100（281470883070208）
	 */
	public static final String SMART_PLUG_HEX_ID = "FFFF0C000100";
	
	
	
	/**
	 * 	双轨窗帘控制器		FFFF04000200（281470748852736）
	 */
	public static final String TWO_WAY_CURTAIN_CTRLER_HEX_ID = "FFFF04000200";
	
	/**
	 * 	单轨窗帘控制器                    FFFF04000100(281470748852480)
	 */
	public static final String ONE_WAY_CURTAIN_CTRLER_HEX_ID = "FFFF04000100";
	
	/**
	 * 人体红外感应器
	 */
	public static final String BODY_IR_SENSOR_HEX_ID = "FFFF16000000";
	/**
	 * 电能检测器
	 */
	public static final String NET_POWER_MONITOR_HEX_ID="FFFF0d000000";
	/**
	 * 平板网关适配器
	 */
	public static final String PAD_GATEWAW_NAME_ID = "FFFF010000";

	/**
	 * @author  唐鹰
	 * Add 2014-11-11 ：
	 * 用电监控器
	 */
	public static final String NET_POWER_MONITOR_CTRLER="FFFF1d000000";
	
	/**
	 * @author wzj
	 * Add 2015-07-14:
	 * PCL-485转换器
	*/
	public static final String PLC_485_CONVERT="FFFF29000000";
	
	/**
	 * 四路开关
	 */
	public static final String Switch_Actuator_4f="FFFF300004000400";
	
	
	/**
	 * PLC_Sub1GHz
	 */
	public static final String PLC_Sub1G="FFFF2A0000000000";
	/**
	 * 昊想智能卫士底座
	 *
	 */
	public static final String HO_THINK_ID="FFFF000000000000";
	public static final String SMART_PROTECT_TYPE = "FFFF190001000000";
	/**
	 * 红外微波双鉴探测器
	 */
	public static final String INFRARED_DOUBLE_ID = "FFFF160000000200";
	/**
	 * 开关控制模块
	 */
	public static final String SWITCH_CTRL = "FFFF18000100";

	
}
