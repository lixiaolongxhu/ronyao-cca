
Ext.define('RYIVS.view.editor.EnterpriseAssess', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterpriseAssess',
	title : '施工企业评估分类',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.EnterpriseAssess',
	// 定义 autoload
	autoload : false,
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true,
	
	
	
	// 定义 colums
	columns : [
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, {
		text : '类别',
		width : 100,
		sortable : true,
		dataIndex : 'category',
		flex : 1,
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.enterprise_assess_category, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.enterprise_assess_category);
		}
	},
	
	
	{
		text : '标准',
		width : 400,
		dataIndex : 'standard',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		},
		flex : 1
	},
	
	{
				text : '可承载项目<br/>最少个数(个)',
				width : 100,
				dataIndex : 'projectnumstart',
				
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'textfield',
					allowBlank : false
				
 				}
	},
		
	{
				text : '可承载项目<br/>最多个数(个)',
				width : 100,
				dataIndex : 'projectnumend',
				
				flex : 1,
				editor : {
					
					
					xtype : 'textfield',
					allowBlank : true
				
 				}
	},
	
		{
		text : '可承载工程<br/>最小产值(亿元)',
		width : 100,
		dataIndex : 'outputstart',
		editor : {
			xtype : 'textfield',
			allowBlank : true
		},
		flex : 1
	},
	
	{
		text : '可承载工程<br/>最大产值(亿元)',
		width : 100,
		dataIndex : 'outputend',
		editor : {
			xtype : 'textfield',
			allowBlank : true
		},
		flex : 1
	},
	
	{
		text : '施工企业',
		width : 400,
		dataIndex : 'enterprise'
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
