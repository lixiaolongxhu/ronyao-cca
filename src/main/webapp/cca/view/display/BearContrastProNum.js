
Ext.define('RYIVS.view.display.BearContrastProNum', {
	requires : [ 'RYIVS.lib.GridEditBaseDis' ],
	extend : 'RYIVS.lib.GridEditBaseDis',
	alias : 'widget.bearContrastProNum',
	title : '工程数量对比情况',
	iconCls : 's_equipment',
	// 定义 store
	store : 'display.BearContrastProNum',
	
	
	// 定义 colums
	columns : [
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
		dataIndex : 'supervisorunit'
		
		
	},
	
		{
		text : '施工企业名称',
		align :'center', 
		width : 150,
		dataIndex : 'enterpriseName'
		
		
	},
	
	
	{
	 text :"项目评估个数",
   
	 columns: [{
				text : '500kV(个)',
				align :'center', 
				width : 150,
				dataIndex : 'projectNumSum500kv',
				
				
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
				
			 },{
				text : '220kV(个)',
				align :'center', 
				width : 150,
				dataIndex : 'proejctNumSum220kv',
				
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			
			
		  	 },
	 		{
				text : '110kV(个)',
				align :'center', 
				width : 150,
				dataIndex : 'projectNumSum110kv',
			
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
				
			
		  	 } ,
		  	 {
				text : '合计',
				align :'center', 
				width : 150,
				dataIndex : 'projectNumSum',
				
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
				
			
		  	 }
	
			
	  ]	
	}
	,{
				text : '近三年平均承载项目个数',
				align :'center', 
				width : 150,
				dataIndex : 'treeYearProjectAverage',
				
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
				
			
	 },
		 {
				text : '项目评估个数与<br/>' +
						'近三年平均承载<br/>' +
						'工程个数的差额',
				align :'center', 
				width : 150,
				dataIndex : 'constrast',
				
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			
	 }
	
	
	
	
	],
	
	initComponent : function() {
		this.callParent(arguments);
	}
	
	
});
