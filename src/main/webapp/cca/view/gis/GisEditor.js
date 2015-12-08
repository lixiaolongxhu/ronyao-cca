//地理信息对象
Ext.define('RYIVS.view.gis.GisEditor', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.gisEditor',
	iconCls : 's_gis',
	title: 'GIS编辑',

	initComponent : function() {
		this.callParent(arguments);
		this.query('button[itemId="buttonAdd"]')[0].hide();
	},

	layout : 'border',
	dockedItems: [{
   	 	xtype: 'toolbar',
   	 	items: [{
        itemId: 'gisLayerManager',
        width:90,
        text:'Gis图层管理',
        iconCls:'s_control'
   	 	}]
    }],
	items : [ {
		xtype : 'gisView',
		region : 'center'
	}, {
		region : 'south',
		xtype : 'gridEditBase',
		title : 'GIS编辑',
		height : 250,
		//collapsed : true,
		collapsible : true,
		// 定义 Model
		model : 'RYIVS.model.gis.GisEditor',
		// 定义 autoload
		autoload : false,
		// 定义拖动后，添加到资源是那类
		dropClass : 2,
		// 是否为主表
		isMaster : false,
		// 定义 colums
		columns : [ {
			text : 'ID',
			dataIndex : 'id'
		}, {
			text : '资源ID',
			dataIndex : 'resid',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'numberfield'
			}
		}, {
			text : '图层',
			dataIndex : 'layer',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'numberfield'
			}
		}, {
			text : 'GIS-类型',
			dataIndex : 'type',
			flex : 2
		}, {
			text : 'GIS-样式',
			dataIndex : 'style',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'numberfield'
			}
		}, {
			text : '数据',
			dataIndex : 'data',
			flex : 8,
			editor : {
				allowBlank : false,
				xtype : 'textfield'
			}
		} ]
	} ]
});
