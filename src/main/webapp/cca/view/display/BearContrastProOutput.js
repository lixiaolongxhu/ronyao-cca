
Ext.define('RYIVS.view.display.BearContrastProOutput', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.bearContrastProOutput',
	title : '产值对比情况',
	iconCls : 's_equipment',
	// 定义 store
	store : 'display.BearContrastProOutput',
	// 定义 autoload
	autoload : false,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :false,
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
	}, {
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
		dataIndex : 'supervisorunit'
		
		
	},
	
		{
		text : '施工企业名称',
		width : 150,
		dataIndex : 'enterpriseName',
		
		
	},
	
	{
				text : '评估值(万元)',
				width : 150,
				dataIndex : 'outputSum',
				
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
				
			
	},{
				text : '近三年产值平均值(万元)',
				width : 150,
				dataIndex : 'treeYearOutputAverage',
				
				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			
			
	} ,{
				text : '差额(万元)',
				width : 150,
				dataIndex : 'constrast',
				
				
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
