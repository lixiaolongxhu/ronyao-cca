package com.ronyao.cca.constant;

import java.util.HashMap;

public class AlarmType {
	/**
	 * 联动类型
	 */
	static final public HashMap<Integer, String> alarmTypes = new HashMap<Integer, String>();
	
	public HashMap<Integer, String> getLinkType() {
		alarmTypes.put(11, "温度过高联动开");
		alarmTypes.put(15, "湿度过高联动开");
		alarmTypes.put(32, "风速过高联动开");
		alarmTypes.put(33, "风速过高联动关");
		alarmTypes.put(42, "SF6过高联动开");
		alarmTypes.put(43, "SF6过高联动关");
		alarmTypes.put(52, "氧气过低联动开");
		alarmTypes.put(53, "氧气过低联动关");
		alarmTypes.put(0, "温度过低联动开");
		return alarmTypes;
	}
}
