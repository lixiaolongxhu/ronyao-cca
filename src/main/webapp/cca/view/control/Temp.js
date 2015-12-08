//播放器的对象

Ext.define('RYIVS.view.control.Temp', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.tempctl',
	title : '最新温湿度',
	height : 150,
	iconCls : 's_temp',
	tpl : '更新日期：<br>{time}<hr>当前温度：{val1}℃<hr>当前湿度：{val2}%',
	
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
