//播放器的对象
Ext.define('RYIVS.view.control.Aircon', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.airconctl',
	title : '空调控制',
	autoWidth : true,
	layout: {
        type: 'vbox',
        align: 'stretch'
    },
	items : [{
		xtype : 'container',
		padding : '2 2 2 2',
		name : 'airconCon',
		html : '请先查询空调状态...',
		tpl : '工作模式：{mode}<br>当前状态：{state}<br>设定温度：{tmp}℃',
		height : 50
	}, {
		xtype : 'button',
		text : '查询状态',
		fnc : 1
	}, {
		xtype : 'button',
		text : '关闭',
		fnc : 3
	}, {
		xtype : 'form',
		margin : '2 2 2 2',
		layout : 'column',
		border : false,
		items : [{
			columnWidth : 1,
			xtype : 'combo',
			name : 'airCtlType',
			queryMode: 'local',
			store: ry.constant.airCtlType,
			editable: false,
			listeners: {
	          	beforerender : function(combo) {
	          		var firstValue = ry.constant.airCtlType[0][0];
	          		combo.setValue(firstValue);
	          	}
	      	}
		}, {
			columnWidth : 1,
			xtype : 'numberfield',
			margin : '2 0 0 0',
			name : 'tmp',
			maxValue : 31,
			minValue : 16,
			step : 1,
			repeatTriggerClick : false,
			editable : false,
			allowBlank : false,
			emptyText : '请输入温度值'
		}]
	}, {
		xtype : 'button',
		text : '发送控制',
		fnc : 4
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
