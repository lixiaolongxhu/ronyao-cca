
Ext.define('RYIVS.view.editor.Behavior', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.behavior',
	title : '不良行为影响修正系数',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.Behavior',
	// 定义 autoload
	autoload : false,
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true,
	
	
	
	// 定义 colums
	columns : [ 
{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	,{
		text : '施工企业名称',
		width : 100,
		sortable : true,
		dataIndex : 'enterpriseid',
		//flex : 1,
		
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
	},
	
	 {
		text : '不良行为发生年份',
		width : 100,
		sortable : true,
		dataIndex : 'year',
		//flex : 1,
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.year, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.year);
		}
	},
	
	{
	 text :"不良行为",
   
	 columns: [{
				text : '严重不良行为次数',
				width : 100,
				dataIndex : 'seriousbadnum',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
				}
			},{
				text : '一般不良行为次数',
				width : 100,
				dataIndex : 'generalbadnum',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
				}
		  	 } 
	
			
	  ]	
	},{
		text : '修正系数',
		width : 100,
		dataIndex : 'correction',
		flex : 1
		
	},
	{
		text : '记录创建时间',
		width : 100,
		dataIndex : 'createtime'
	}, {
		text : '记录修改时间',
		width : 100,
		dataIndex : 'updatetime'
	}
	
	
	]
});
