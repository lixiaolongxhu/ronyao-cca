
Ext.define('RYIVS.view.editor.AnnualOutput', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.annualOutput',
	title : '施工项目年产值评估标准表配置',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.AnnualOutput',
	// 定义 autoload
	autoload : false,
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true, 
	// 定义 colums
	columns : [ {
		text : 'ID',
		width : 30,
		dataIndex : 'id'
		
	},
		
	{
		text : '电压等级',
		width : 200,
		sortable : true,
		dataIndex : 'voltagerankid',
		//flex : 1,
		
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
		//flex : 1,
		
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
			dataIndex : 'timllimit',
				
			flex : 1,
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
				
			flex : 1,
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
				
			flex : 1,
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
		width : 200,
		dataIndex : 'remark',
		editor : {
			xtype : 'textfield',
			allowBlank : true
		},
		flex : 1
	},

	{
		text : '记录创建时间',
		width : 100,
		dataIndex : 'createtime'
	}, {
		text : '修改时间',
		width : 100,
		dataIndex : 'updatetime'
	}
	
	
	]
});
