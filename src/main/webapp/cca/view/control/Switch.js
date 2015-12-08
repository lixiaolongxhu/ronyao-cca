//播放器的对象

Ext.define('RYIVS.view.control.Switch', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.controlSwitch',
	title : '开关控制',
	layout : {
		type : 'vbox',
		align : 'stretch'
	},
	items : [{
		xtype : 'container',
		name : 'switchCon',
		html : '请先查询开关状态...',
		tpl : '控制模式：{mode}<br>当前状态：{state}',
		height: 30
	}, {
		xtype : 'button',
		text : '查询状态',
		fnc: 1
	}, {
		xtype : 'button',
		text : '开启',
		fnc: 2
	}, {
		xtype : 'button',
		text : '关闭',
		fnc: 3
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
