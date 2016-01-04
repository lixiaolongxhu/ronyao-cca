
Ext.define('RYIVS.view.editor.AnnualOutput', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.annualOutput',
	title : '施工项目团队工程施工产值',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.AnnualOutput',
	// 定义 autoload
	autoload : false,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :false, 
	// 定义 colums
	columns : [ 
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	,{
		text : '电压等级',
		width : 200,
		sortable : true,
		dataIndex : 'voltagerankid',
		
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.voltageRankClassify_name , //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.voltageRankClassify_name );
		}
	},
	
	{
		text : '施工项目类型',
		width : 200,
		sortable : true,
		dataIndex : 'projecttype',
		
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.project_type , //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.project_type );
		}
	},
	
	{
			text : '合理工期(月)',
			width : 100,
			dataIndex : 'timelimit',
				
			
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				autoStripChars : true,
				allowDecimals : false
			}
	},
	

	{
			text : '单个项目部完成<br/>项目数量(个/年)',
			width : 100,
			dataIndex : 'projectnum',
				
			
			editor : {
				allowBlank : false,
				xtype : 'textfield',
				minValue : 0,
				autoStripChars : true,
				allowDecimals : false
			}
	},
	
	{
			text : '年产值(万元/年)',
			width : 100,
			dataIndex : 'annualoutput',
				
			
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				autoStripChars : true,
				allowDecimals : false
			}
	},
	
	{
		text : '备注',
		width : 400,
		dataIndex : 'remark',
		editor : {
			xtype : 'textfield',
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
