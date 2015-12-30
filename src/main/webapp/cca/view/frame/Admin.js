/*
 * 管理员的界面框架
 */
Ext.define('RYIVS.view.frame.Admin', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.layerAdmin',
	region : 'center',
	layout : 'border',
	items : [ {
		xtype : 'leftMenu',
		region : 'west',
		width : 300//,
//		collapsible :true,
		
	}, {
		region : 'center',
		xtype : 'centerPanel',
		activeTab : 0,
		items : [ {
			xtype : 'enterprise',  //管理员用户默认打开企业基本信息
			 closable : true // 通过html载入目标页  ,显示关闭按钮	
		}
		
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
