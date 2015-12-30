
Ext.define('RYIVS.view.display.BearContrastProNum', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.bearContrastProNum',
	title : '工程数量对比情况',
	iconCls : 's_equipment',
	// 定义 store
	store : 'display.BearContrastProNum',
	// 定义 autoload
	autoload : false,
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true, 
	//引入grid 特征 - 列求和
	features: [{
        ftype: 'summary'
    }],
	// 工具条
	tbar : [{
		itemId : 'buttonRefresh',
		text : '刷新',
		icon : 'res/icon/sync.png',
		handler : function() {
			this.ownerCt.ownerCt.store.load();
		}
	} , {
		itemId : 'buttonExporterExcel',
		text : '导出Excel',
		icon : 'res/icon/export.gif'	
    }],
	
	// 定义 colums
	columns : [
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, 
	{
		text : '主管单位',
		width : 100,
		dataIndex : 'supervisorunit',
		flex : 1
		
	},
	
		{
		text : '施工企业名称',
		width : 100,
		dataIndex : 'enterpriseName',
		flex : 1
		
	},
	
	
	{
	 text :"项目评估个数",
   
	 columns: [{
				text : '500kV(个)',
				width : 100,
				dataIndex : 'projectNumSum500kv',
				
				flex : 1,
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
				
			 },{
				text : '220kV(个)',
				width : 100,
				dataIndex : 'proejctNumSum220kv',
				flex : 1,
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			
			
		  	 },
	 		{
				text : '110kV(个)',
				width : 100,
				dataIndex : 'projectNumSum110kv',
				flex : 1,
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
				
			
		  	 } ,
		  	 {
				text : '合计',
				width : 100,
				dataIndex : 'projectNumSum',
				flex : 1,
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
				
			
		  	 }
	
			
	  ]	
	}
	,{
				text : '近三年平均承载项目个数',
				width : 100,
				dataIndex : 'treeYearProjectAverage',
				flex : 1,
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
				
			
	 },
		 {
				text : '项目评估个数与<br/>' +
						'近三年平均承载<br/>' +
						'工程个数的差额',
				width : 100,
				dataIndex : 'constrast',
				flex : 1,
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			
	 }
	
	
	
	
	],
	//设置没有数据显示文本
	viewConfig: {
		emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
        deferEmptyText:false
    },
	initComponent : function() {
		this.callParent(arguments);
	}
	
	
});
