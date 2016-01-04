/**企业持证人员图片编辑维护管理.
 * 
 */
Ext.define('RYIVS.view.file.EnterpPerFileEditDis', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.enterpPerFileEditDis',
	height : 600,
	store : 'file.EnterpPerFileEdit',
	tbar : [{
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
	    minWidth :800,
		flex :2,
		renderer : function(val) {
			return '<image width="100%" height="50%" src="res/file/' + val + '">'
	}
	}],
	frame:true,
	columnLines:true,
	
	listeners : {
//		'selectionchange' : function(view, records) {
//			this.down('#deleteButton').setDisabled(!records.length);
//		}
	},
	
	
	initComponent : function() {
		this.callParent(arguments);
	}
});