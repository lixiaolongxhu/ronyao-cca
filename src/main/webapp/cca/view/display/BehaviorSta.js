
Ext.define('RYIVS.view.display.BehaviorSta', {
	requires : [ 'RYIVS.lib.GridEditBaseDis' ],
	extend : 'RYIVS.lib.GridEditBaseDis',
	alias : 'widget.displayBehaviorSta',
	title : '施工企业不良行文分类标准',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.BehaviorSta',
	
	
	
	// 工具条
	tbar : [ {
		itemId : 'buttonRefresh',
		text : '刷新',
		icon : 'res/icon/sync.png',
		handler : function() {
			this.ownerCt.ownerCt.store.load();
		}
	}, {
		itemId : 'buttonLookOver',
		text : '查看详细',
		icon : 'res/icon/history.png',
		disabled : true
		
    }, {
		itemId : 'buttonExporterExcel',
		text : '导出Excel',
		icon : 'res/icon/export.gif'	
    }],
    
    //事件监听 ,判断按钮是否可用
    listeners : {
		'selectionchange' : function(view, records) {
	
			//选中某条记录后,查看按钮可用
			this.down('#buttonLookOver').setDisabled(!records.length);
		}
	},
	
	
	// 定义 colums
	columns : [ 
	//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	} 
	,{
		text : '不良行为等级',
		align :'center',
		width : 200,
		sortable : true,
		dataIndex : 'ranktype',
		
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.behavior_standard_rankType, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.behavior_standard_rankType);
		}
	},
	
	{
		text : '诚信',
		align :'center',
		width : 400,
		dataIndex : 'sincerity',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		},
		renderer : function (value, meta, record) {
			//自动换行渲染
			meta.style = 'white-space:normal;word-break:break-all;';
			return value;
		}
	
	},
		{
		text : '安全质量',
		align :'center',
		width : 400,
		dataIndex : 'save',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		},
		renderer : function (value, meta, record) {
			//自动换行渲染
			meta.style = 'white-space:normal;word-break:break-all;';
			return value;
		}
		
	},
	{
		text : '履约进度',
		align :'center',
		width : 400,
		dataIndex : 'progress',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		},
		renderer : function (value, meta, record) {
			//自动换行渲染
			meta.style = 'white-space:normal;word-break:break-all;';
			return value;
		}
		
	},
	{
		text : '服务',
		align :'center',
		width : 400,
		dataIndex : 'service',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		},
		renderer : function (value, meta, record) {
			//自动换行渲染
			meta.style = 'white-space:normal;word-break:break-all;';
			return value;
		}
		
	},
	{
		text : '其他',
		align :'center',
		width : 400,
		dataIndex : 'other',
		editor : {
			xtype : 'textarea',
			allowBlank : true
		},
		renderer : function (value, meta, record) {
			//自动换行渲染
			meta.style = 'white-space:normal;word-break:break-all;';
			return value;
		}
		
	},

	{
		text : '记录创建时间',
		align :'center',
		width : 200,
		dataIndex : 'createtime'
	}, {
		text : '记录修改时间',
		align :'center',
		width : 200,
		dataIndex : 'updatetime'
	}
	
	
	]
});
