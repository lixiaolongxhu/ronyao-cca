/**
 * 实时视频播放窗口，对
 */
Ext.define('RYIVS.view.video.PlayerWin', {
	requires : [ 'RYIVS.view.video.VideoPanel', 'RYIVS.view.video.PtzPos' +
			'' ],
	extend : 'Ext.window.Window',
	alias : 'widget.winPlayer',
	width : 800,
	height : 400,
	layout : 'border',
	title : '实时视频播放',
	iconCls : 's_alarm',
	modal : true,
	items : [ {
		xtype : 'videoPanel',
		region : 'center',
		id : 'player'
	}, {
		xtype : 'ptzPos',
		region : 'west',
		width : 250
	} ],

	buttons : [ {
		xtype : 'numberfield',
		fieldLabel: '预置点编号',
		name : 'pos',
		allowDecimals : false,
//		value : 1,
		width : 170,
		labelAlign : 'right',
		maxValue : 255,
		minValue : 1
	}, {
		xtype : 'textfield',
		fieldLabel : '预置位名称',
		labelAlign : 'right',
		name : 'posName',
		allowBlank : false
	}, {
		xtype : 'button',
		text : '设置预置点',
		itemId : 'btn_set_pos',
		//disabled : true,
		fnc : 1
	}, {
		xtype : 'button',
		text : '调用预置点',
		fnc : 2
	} ],

	show : function() {
		this.callParent(arguments);
		var player = this.queryById('player');
		player.initPlayer(1);
		player.playRealVideo(this.resid);
	},

	initComponent : function() {
		this.callParent(arguments);
	}
});
