//对历史视频与告警事件的统一查询
Ext.define('RYIVS.view.common.UserResPanel', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.userResPanel',
	layout : 'border',

	items : [{
		xtype : 'resGrid',
		region : 'center'
	}, {//日期控件
		xtype : 'datepicker',
		height : 200,
		region : 'south',
		hidden : true
	},  {//空调
		xtype : 'airconctl',
		height : 190,
		region : 'south',
		hidden : true
	}, {//开关量
		xtype : 'controlSwitch',
		height : 130,
		region : 'south',
		hidden : true
	}, {//温湿度
		xtype : 'tempctl',
		height : 160,
		region : 'south',
		hidden : true
	}, {//预置点列表
		xtype : 'ptzPosList',
		height : 220,
		region : 'south',
		hidden : true
	}, {//风速
		xtype : 'airVel',
		height : 150,
		region : 'south',
		hidden : true
	}, {//氧气
		xtype : 'oxSensor',
		height : 170,
		region : 'south',
		hidden : true
	}, {//SF6
		xtype : 'SF6Vel',
		height : 170,
		region : 'south',
		hidden : true
	}],

	initComponent : function() {
		this.callParent(arguments);
	}
});
