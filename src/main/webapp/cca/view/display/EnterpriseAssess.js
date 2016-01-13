
Ext.define('RYIVS.view.display.EnterpriseAssess', {
	requires : [ 'RYIVS.lib.GridEditBaseDis' ],
	extend : 'RYIVS.lib.GridEditBaseDis',
	alias : 'widget.displayEnterpriseAssess',
	title : '施工企业评估分类',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.EnterpriseAssess',
	
	
	
	
	// 定义 colums
	columns : [
	//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	}
	, {
		text : '类别',
		align :'center',
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
		align :'center',
		width : 400,
		dataIndex : 'standard',
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
				text : '可承载项目<br/>最少个数(个)',
				align :'center',
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
				align :'center',
				width : 100,
				dataIndex : 'projectnumend',
				
				
				editor : {
					
					
					xtype : 'textfield',
					allowBlank : true
				
 				}
	},
	
		{
		text : '可承载工程<br/>最小产值(亿元)',
		align :'center',
		width : 100,
		dataIndex : 'outputstart',
		editor : {
			xtype : 'textfield',
			allowBlank : true
		}
		
	},
	
	{
		text : '可承载工程<br/>最大产值(亿元)',
		align :'center',
		width : 100,
		dataIndex : 'outputend',
		editor : {
			xtype : 'textfield',
			allowBlank : true
		}
	
	},
	
	{
		text : '施工企业',
		align :'center',
		width : 600,
		dataIndex : 'enterprise',
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
