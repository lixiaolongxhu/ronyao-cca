/**
 * controller : 氧气传感器控制面板
 * author : tqd
 * date : 2013-4-15
 */
Ext.define('RYIVS.view.control.OxygenSensor', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.oxSensor',
	title : '最新氧气浓度',
	height : 150,
	iconCls : 's_oxySen',
	tpl : '更新日期：<br>{time}<hr>当前氧气浓度：{val1}(%)',
	
	tools : [{
		type : 'refresh',
		fun : 1,
		tooltip : '刷新当前数据'
	}, {
		type : 'search',
		fun : 2,
		tooltip : '查看历史数据'
	}],
	bbar: [{
		xtype: 'label',
		name : 'tip',
		text: '系统提示',
		style:'color:red;',
		hidden : true
	}],
	
	show : function() {
		this.callParent(arguments);
		this.fireEvent('onShow', this);
	},
	initComponent : function() {
		this.callParent(arguments);
		this.addEvents('onShow');
	}
});
