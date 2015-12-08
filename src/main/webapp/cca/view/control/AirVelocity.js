/**
 * view : 风速传感
 * author : tqd
 * date : 2013-4-9
 */
Ext.define('RYIVS.view.control.AirVelocity', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.airVel',
	title : '最新风速信息',
	height : 150,
	iconCls : 's_wind',
	tpl : '更新日期：<br>{time}<hr>当前风速：{val1}m/s',
	
	tools : [{
		type : 'refresh',
		fun : 1,
		tooltip : '刷新当前数据'
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
		this.fireEvent('avtShow', this);
	},
	initComponent : function() {
		this.callParent(arguments);
		this.addEvents('avtShow');
	}
});
