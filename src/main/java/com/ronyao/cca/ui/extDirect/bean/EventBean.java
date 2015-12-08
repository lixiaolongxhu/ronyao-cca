package com.ronyao.cca.ui.extDirect.bean;

/**
 * @author danny 历史查询的事件对象 type：类型 events：事件列表
 */
public class EventBean {
	private int type; // 类型
	private Object events; // 数据列表

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Object getEvents() {
		return events;
	}

	public void setEvents(Object events) {
		this.events = events;
	}
}
