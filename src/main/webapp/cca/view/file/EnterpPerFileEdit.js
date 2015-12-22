/**企业持证人员图片编辑维护管理.
 * 
 */
Ext.define('RYIVS.view.file.EnterpPerFileEdit', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.enterpPerFileEdit',
	height : 380,
	store : 'file.EnterpPerFileEdit',
	tbar : [{
		xtype : 'button',
		text : '删除',
		itemId:'deleteButton',
		iconCls:'s_del',
		handler : function() {
			
			Ext.Msg.show({
				title : '删除警告',
				msg : '请再次确认删除，删除该数据将删除与之相关联的数据',
				buttons : Ext.Msg.YESNO,
				fn : function(rst) {
					
					var ctlType = this.ownerCt.ownerCt.ownerCt.xtype;
					var temp = this.ownerCt.ownerCt;
					if (rst != 'no') {
						var sm = this.ownerCt.ownerCt.getSelectionModel();
//						this.ownerCt.ownerCt.rowEditing.cancelEdit();
						this.ownerCt.ownerCt.store.remove(sm.getSelection());
						if (this.ownerCt.ownerCt.store.getCount() > 0) {
							sm.select(0);
						}
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
	columns : [{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, {
		text : '企业名称',
		width : 100,
		sortable : true,
		dataIndex : 'enterpriseid',
//		flex : 1,
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.enterprise_name, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.enterprise_name);
		}
	},{
		text : '持证人员分类',
		width : 100,
		sortable : true,
		dataIndex : 'classify'
		
	
	},{
			text : '等级',
			width : 100,
			dataIndex : 'rank'
	},{
		text:'文件图片',
		sortable : false,
		dataIndex : "path",
		flex : 2,
		renderer : function(val) {
			return '<image width="100%" height="50%" src="res/file/' + val + '">'
	}
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