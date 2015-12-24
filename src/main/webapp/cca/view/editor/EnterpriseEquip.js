
Ext.define('RYIVS.view.editor.EnterpriseEquip', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterpriseEquip',
	title : '施工装备信息',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.EnterpriseEquip',
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
		text : '施工企业名称',
		width : 200,
		sortable : true,
		dataIndex : 'enterpriseid',
		flex : 1,
		
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
	 text :"施工装备",
   
	 columns: [{
				text : '大张牵设备(套)',
				width : 200,
				dataIndex : 'bigequipment',
				
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false		
 				}
	
			},{
				text : '小张牵设备(套)',
				width : 200,
				dataIndex : 'smallequipment',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 }
		  	 ,{
				text : '合计',
				width : 300,
				dataIndex : 'sum',
				flex : 1
		  	 }
			
	  ]	
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
