
Ext.define('RYIVS.view.display.BehaviorSta', {
	requires : [ 'RYIVS.lib.GridEditBaseDis' ],
	extend : 'RYIVS.lib.GridEditBaseDis',
	alias : 'widget.displayBehaviorSta',
	title : '施工企业不良行文分类标准',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.BehaviorSta',
	// 定义 autoload
	autoload : false,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :false, 
	
	
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
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, {
		text : '不良行为等级',
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
		width : 400,
		dataIndex : 'sincerity',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		}
	
	},
		{
		text : '安全质量',
		width : 400,
		dataIndex : 'save',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		}
		
	},
	{
		text : '履约进度',
		width : 400,
		dataIndex : 'progress',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		}
		
	},
	{
		text : '服务',
		width : 400,
		dataIndex : 'service',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		}
		
	},
	{
		text : '其他',
		width : 400,
		dataIndex : 'other',
		editor : {
			xtype : 'textarea',
			allowBlank : true
		}
		
	},

	{
		text : '记录创建时间',
		width : 200,
		dataIndex : 'createtime'
	}, {
		text : '记录修改时间',
		width : 200,
		dataIndex : 'updatetime'
	}
	
	
	]
});