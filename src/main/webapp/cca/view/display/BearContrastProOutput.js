
Ext.define('RYIVS.view.display.BearContrastProOutput', {
	requires : [ 'RYIVS.lib.GridEditBaseDis' ],
	extend : 'RYIVS.lib.GridEditBaseDis',
	alias : 'widget.bearContrastProOutput',
	title : '产值对比情况',
	iconCls : 's_equipment',
	// 定义 store
	store : 'display.BearContrastProOutput',
	
	
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
				text : '评估值(万元)',
				align :'center',
				width : 150,
				dataIndex : 'outputSum',
				
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
				
			
	},{
				text : '近三年产值平均值(万元)',
				align :'center',
				width : 150,
				dataIndex : 'treeYearOutputAverage',
				
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			
			
	} ,{
				text : '差额(万元)',
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
