
Ext.define('RYIVS.view.display.ProjectBuildBear', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.projectBuildBear',
	title : '施工单位剩余承载能力',
	iconCls : 's_equipment',
	// 定义 store
	store : 'display.ProjectBuildBear',
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
	} ],
	
	// 定义 colums
	columns : [
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, 
	{
		text : '主管单位',
		width : 100,
		sortable : true,
		dataIndex : 'supervisorunit',
		flex : 1
		
		
		
	},
	{
		text : '施工企业名称',
		width : 100,
		sortable : true,
		dataIndex : 'enterpriseName',
		flex : 1
		
		
		
	},
	
	
	
	{
	 text :"还可以承担线路工程",
   
	 columns: [{
				text : '110kV(个)',
				width : 100,
				dataIndex : 'line110kv',
				flex : 1,
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
				width : 100,
				dataIndex : 'line220kv',
				flex : 1,
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
				text : '500kV(个)',
				width : 100,
				dataIndex : 'line500kv',
				
				flex : 1,
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
				text : '110kV(个)',
				width : 100,
				dataIndex : 'power110kv',
				flex : 1,
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
				width : 100,
				dataIndex : 'power220kv',
				flex : 1,
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
			
		  	 }, {
				text : '500kV(个)',
				width : 100,
				dataIndex : 'power500kv',
				
				flex : 1,
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
