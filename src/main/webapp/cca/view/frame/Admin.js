/*
 * 管理员的界面框架
 */
Ext.define('RYIVS.view.frame.Admin', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.layerAdmin',
	region : 'center',
	layout : 'border',
	items : [ {
		xtype : 'resGrid',
		region : 'west',
		width : 300
	}, {
		region : 'center',
		xtype : 'tabpanel',
		activeTab : 0,
		items : [ {
			xtype : 'gridEditController'
		}
//			, {
//			xtype : 'gridEditEncoder'
//		}, {
//			xtype : 'streamServer'		
//		}, {
//			xtype : 'gridEditRfid'
//		}, {
//			xtype : 'gridEditAlarmRule'
//		}, /*{
//			xtype : 'eventRule'
//		},*/ {
//			xtype : 'gridEditLocator'
//		}, {
//			xtype : 'gisEditor'
//		}, {
//			xtype : 'gridEditUser'
//		}, {
//			xtype : 'gridEditUserAlarm'
//		} , {
//			xtype : 'gridEditUserLog'
//		} 
	]
	} ],

	bbar : [ {
		dock : 'bottom',
		border : 0,
		width : "100%",
		xtype : 'mainStateBar'
	} ],

	initComponent : function() {
		this.callParent(arguments);
	}

});
