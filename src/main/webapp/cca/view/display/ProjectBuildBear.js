
Ext.define('RYIVS.view.display.ProjectBuildBear', {
	requires : [ 'RYIVS.lib.GridEditBaseDis' ],
	extend : 'RYIVS.lib.GridEditBaseDis',
	alias : 'widget.projectBuildBear',
	title : '施工单位剩余承载能力',
	iconCls : 's_equipment',
	// 定义 store
	store : 'display.ProjectBuildBear',
	
	
	// 定义 colums
	columns : [
	//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	}
	,
	{
		text : '主管单位',
		align :'center',
		width : 100,
		sortable : true,
		dataIndex : 'supervisorunit'
	
	},
	{
		text : '施工企业名称',
		align :'center',
		width : 200,
		sortable : true,
		dataIndex : 'enterpriseName'
			
	},
	
	{
	 text :"还可以承担线路工程",
   
	 columns: [{
				text : '500kV(个)',
				align :'center',
				width : 100,
				dataIndex : 'line500kv',
				
				
				editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
				},
 			
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			},{
				text : '220kV(个)',
				align :'center',
				width : 100,
				dataIndex : 'line220kv',
			
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				},
 			
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			
		  	 } ,{
				text : '110kV(个)',
				align :'center',
				width : 100,
				dataIndex : 'line110kv',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				},
 			
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			 }]	
	}
	,
	
	
	
	{
	 text :"还可以承担变电工程",
   
	 columns: [{
				text : '500kV(个)',
				align :'center',
				width : 100,
				dataIndex : 'power500kv',
				
				
				editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
			},
 			
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			},{
				text : '220kV(个)',
				align :'center',
				width : 100,
				dataIndex : 'power220kv',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				},
 			
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			
		  	 },{
				text : '110kV(个)',
				align :'center',
				width : 100,
				dataIndex : 'power110kv',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				},
 			
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
		  	 } ]	
	}
	
	
	],
	
	initComponent : function() {
		this.callParent(arguments);
	}
	
	
});
