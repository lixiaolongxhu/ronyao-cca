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
		width : 300
		
	}, {
		region : 'center',
		xtype : 'tabpanel',
		activeTab : 0,			
		items : [ {
			xtype : 'centerPanel',
			html :'界面中部',
			title : '主界面'
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
