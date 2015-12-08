/*
 * 告警事件列表
 * 未处理的告警
 */
Ext.define('RYIVS.view.common.Alarms', {
	title : '告警消息',
	tools:[{
		xtype : 'button',
		action : 'dealAlarms',
		tooltip : '处理所有告警',
		icon : 'res/icon/tool.png'
	}],
	extend : 'Ext.panel.Panel',
	alias : 'widget.alarms',
	iconCls : 's_alarm',
	html : "<audio id='wave.alarm' src='res/audio/alarm.wav' loop=true></audio>",
	width : 255,
	hidden : true,
	layout : {
		type : 'vbox',
		align : 'stretch'
	},
	items : [ {
		// 这里是最新未处理告警消息的列表
		xtype : 'gridpanel',
		flex : 1,
		store : 'common.Alarms',
		columns : [ {
			header : '告警类型',
			dataIndex : 'type',
			flex : 1,
			renderer : function(val) {
				return ry.constant.trans(val, ry.constant.almtype);
			}
		}, {
			header : '告警时间',
			dataIndex : 'time',
			flex : 2,
			renderer : function(val) {
				var date = new Date(val*1000);
				return Ext.Date.format(date, 'Y-m-d G:i:s');
			}
		} ],

		bbar : {
			xtype : 'pagingtoolbar',
			store : 'common.Alarms'
		}

	}, {
		// 这里是告警消息的详细信息
		xtype : 'panel',
		title : '告警详细信息',
		height : 200,
		layout : {
			type : 'vbox',
			align : 'stretch'
		},

		items : [ {
			// 告警详细消息
			xtype : 'container',
			height : 55,
			tpl : '告警资源：{aResName}<br>告警时间：{aTime}<br>告警类型：{atName}<br>告警参数：{aValue}'
		}, {
			// 关联摄像机
			xtype : 'gridpanel',
			store : 'common.AlarmCamera',
			title : '关联摄像机',
			action : 'camera',
			flex : 1,
			columns : [ {
				header : '摄像机名称',
				dataIndex : 'target',
				flex : 2,
				renderer : function(value) {
					var res = controller.viewResGrid.getResStore().data.getByKey(value);
					if (res) {
						return res.data.name;
					} else {
						return '资源丢失！';
					}
				}
			} ]
		} ]

	} ],

	initComponent : function() {
		this.callParent(arguments);
//		debugger;
	}
});
