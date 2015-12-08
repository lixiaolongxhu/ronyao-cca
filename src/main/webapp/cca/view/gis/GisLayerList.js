Ext.define('RYIVS.view.gis.GisLayerList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.gisLayerList',
	height : 380,
	store : 'gis.GisLayerList',
	tbar : [{
		xtype : 'button',
		text : '删除',
		itemId:'deleteButton',
		iconCls:'s_del',
		handler : function() {
			Ext.Msg.show({
				title : '删除警告',
				msg : '请确认删除',
				buttons : Ext.Msg.YESNO,
				fn : function(rst) {
					var temp = this.ownerCt.ownerCt;
					if (rst != 'no') {
						var sm = this.ownerCt.ownerCt.getSelectionModel();
						var selection = sm.getSelection();					
						actionLayerList.destroy(selection[0].data, function(obj) {
							if (obj == -1) {
								Ext.Msg.show({
									title : '失败',
									msg : '删除失败，请先删除该层上的设备！',
									buttons : Ext.Msg.OK,
									icon : Ext.Msg.ERROR,
									scope : this,
									fn : function(btn) {
										if (btn == 'ok') {
											return false;
										}
									}
								});
							}
						});
						
						//this.ownerCt.ownerCt.store.remove(selection[0]);
						if (this.ownerCt.ownerCt.store.getCount() > 0) {
							sm.select(0);
						}
						config = {
							callback:function(){
								controller.gisLayerEditor.reDrawGisLayers();
							}
						}
						temp.getStore().load(config);
					}
				},
				scope : this,
				icon : Ext.window.MessageBox.QUESTION
			});
		}
	},{
		xtype : 'button',
		text : '刷新',
		iconCls:'s_sync',
		handler : function() {
			this.ownerCt.ownerCt.store.load();
		}
	}],
	columns : [{
		text:'ID',
		sortable : true,
		dataIndex : "id",
		flex : 1
	},{
		text:'图层名称',
		sortable : false,
		dataIndex : "name",
		flex : 1,
		editor : {
		 	allowBlank : false
		}
	},{
		text:'图片路径',
		sortable : false,
		dataIndex : "fname",
		flex : 2
	}],
	frame:true,
	columnLines:true,
	
	listeners : {
		'selectionchange' : function(view, records) {
			this.down('#deleteButton').setDisabled(!records.length);
		}
	},
	
	
	initComponent : function() {
		this.callParent(arguments);
	}
});