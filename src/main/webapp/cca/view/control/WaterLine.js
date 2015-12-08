/**
 * view : 水位设备
 * author : tqd
 * date : 2013-4-9
 */
Ext.define('RYIVS.view.control.WaterLine', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.waterLine',
	title : '最新水位信息',
	height : 150,
	iconCls : 's_water',
	tpl : '更新日期：<br>{time}<hr>当前水位：{val1}cm',
	
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
		this.fireEvent('waterLineShow', this);
	},
	initComponent : function() {
		this.callParent(arguments);
		this.addEvents('waterLineShow');
	}
});
