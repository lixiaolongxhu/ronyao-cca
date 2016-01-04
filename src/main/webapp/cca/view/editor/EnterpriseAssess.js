
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
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :false,
	
	
	
	// 定义 colums
	columns : [
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, {
		text : '类别',
		width : 100,
		sortable : true,
		dataIndex : 'category',
		
		
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
		width : 600,
		dataIndex : 'standard',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		}
	
	},
	
	{
				text : '可承载项目<br/>最少个数(个)',
				width : 100,
				dataIndex : 'projectnumstart',
				
				
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
		}
		
	},
	
	{
		text : '可承载工程<br/>最大产值(亿元)',
		width : 100,
		dataIndex : 'outputend',
		editor : {
			xtype : 'textfield',
			allowBlank : true
		}
	
	},
	
	{
		text : '施工企业',
		width : 2000,
		dataIndex : 'enterprise'
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
