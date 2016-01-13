

Ext.define('RYIVS.view.display.ProjectPlain', {
	requires : [ 'RYIVS.lib.GridEditBaseDisNoToolbar' ],
	extend : 'RYIVS.lib.GridEditBaseDisNoToolbar',
	alias : 'widget.displayProjectPlain',
	title : '下一年公司新开工项目情况',
	iconCls : 's_equipment',
	store:'editor.ProjectPlain',
	
    
	dockedItems: [{
   	 	xtype: 'toolbar',
   	 	items: [{
	        itemId: 'refreshButton',
	        width:50,
	        icon : 'res/icon/sync.png',
	        text:'刷新',
	        tooltip:'刷新'
	    },'-',{
			itemId : 'buttonExporterExcel',
			text : '导出Excel',
			icon : 'res/icon/export.gif'	
    	},'-',{disabled:true},'项目年份:',{

         	xtype : 'combo',
			minValue : 1,
			value:  Ext.Date.format(new Date(),"Y"),
			editable : false,
			displayField : 'display',
			valueField : 'value',
			store : ry.constant.year, //调用外部js常量
			queryMode : 'local',
			emptyText : '请选择',	
			id :'searchYear'
	    },'-',{
	    	itemId: 'searchButton',
	    	icon : 'res/icon/query.png',
	        text:'查询',
	        tooltip:'search some rows',
	        iconCls:'add'
	    }]
    }],
 
    
    listeners : {
		'selectionchange' : function(view, records) {
//			this.down('#removeButton').setDisabled(!records.length);
		}
	},
    
	// 定义 colums
	columns : [

		{	
		xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
		} 
		,
		{
		text : '电压等级',
		align :'center', 
		width : 100,
		sortable : true,
		dataIndex : 'voltagerankclassifyid',
		
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.voltageRankClassify_name , //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.voltageRankClassify_name );
		}
	},
	
	 {
		text : '项目年份',
		align :'center', 
		width : 100,
		sortable : true,
		dataIndex : 'year',
		
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value:  1, //Ext.getCmp('searchYear').value,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.year, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				id:'addYear',
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.year);
		}
	},
	 {
			text : '项目个数(个)',
			align :'center', 
			width : 100,
			dataIndex : 'projectnum',
			
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
	},
	
	{
	 text :"标包数(个) ",
   
	 columns: [
		 	{
			text : '线路工程数(个)',
			align :'center', 
			width : 150,
			dataIndex : 'lineproject',
			
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
		  }, {
			text : '变电工程数(个)',
			align :'center', 
			width : 150,
			dataIndex : 'powerproject',
			
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
	
			
	  ]	
	},
	
	{
	 text :"评估可承担个数(个) ",
   
	 columns: [
		 	{
			text : '线路工程数(个)',
			align :'center', 
			width : 150,
			dataIndex : 'assesslineproject',
		
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
		  }, {
			text : '变电工程数(个)',
			align :'center', 
			width : 100,
			dataIndex : 'assesspowerproject',
			
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
	
			
	  ]	
	}
	, {
			text : '线路长度(公里)',
			align :'center', 
			width : 100,
			dataIndex : 'linelength',
			
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
	}, {
			text : '变电容量(万千伏安)',
			align :'center', 
			width : 150,
			dataIndex : 'volume',
			
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
	}, {
			text : '总投资(亿元)',
			align :'center', 
			width : 150,
			dataIndex : 'investment',
			
			editor : {
				allowBlank : false,
				xtype : 'textfield',
				minValue : 0,
				
				autoStripChars : true,
				allowDecimals : false
			},
 			
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
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
	
	
	],
	
	initComponent:function(){
		this.callParent(arguments);
	}
});
