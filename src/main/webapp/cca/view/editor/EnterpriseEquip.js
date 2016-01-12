
Ext.define('RYIVS.view.editor.EnterpriseEquip', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterpriseEquip',
	title : '施工装备信息',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.EnterpriseEquip',
	
	
	
	
	// 定义 colums
	columns : [
//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	}
	, {
		text : '施工企业名称',
		align :'center',
		width : 200,
		sortable : true,
		dataIndex : 'enterpriseid',
		
		
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
				align :'center',
				width : 200,
				dataIndex : 'bigequipment',
				
			
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false		
 				},
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
	
			},{
				text : '小张牵设备(套)',
				align :'center',
				width : 200,
				dataIndex : 'smallequipment',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				},
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			
		  	 }
		  	 ,{
				text : '合计',
				align :'center',
				width : 300,
				dataIndex : 'sum',
				
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('小计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
		  	 }
			
	  ]	
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
