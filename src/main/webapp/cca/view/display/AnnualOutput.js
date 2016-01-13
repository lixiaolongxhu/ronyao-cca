
Ext.define('RYIVS.view.display.AnnualOutput', {
	requires : [ 'RYIVS.lib.GridEditBaseDis' ],
	extend : 'RYIVS.lib.GridEditBaseDis',
	alias : 'widget.displayAnnualOutput',
	title : '施工项目团队工程施工产值',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.AnnualOutput',
	
	// 定义 colums
	columns : [ 
	//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	} 
	,{
		text : '电压等级',
		align :'center',
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
		align :'center',
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
			align :'center',
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
			align :'center',
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
			align :'center',
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
		align :'center',
		width : 400,
		dataIndex : 'remark',
		editor : {
			xtype : 'textfield',
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
