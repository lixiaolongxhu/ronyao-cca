

Ext.define('RYIVS.view.display.ProjectNoBuild', {
	extend : 'Ext.grid.Panel',
//		requires : [ 'RYIVS.lib.GridEditBase' ],
//	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.displayProjectNoBuild',
	title : '中标未开工情况',
	iconCls : 's_equipment',
	store:'editor.ProjectNoBuild',
	// 定义 autoload
	autoload : false,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :false,
	
	
	viewConfig: {
		emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
        deferEmptyText:false
    },
    
    //引入grid 特征 - 列求和
	features: [{
        ftype: 'summary'
    }],
    
    dockedItems: [{
   	 	xtype: 'toolbar',
   	 	items: [{
	        itemId: 'refreshButton',
	        width:50,
	        icon : 'res/icon/sync.png',
	        text:'刷新',
	        tooltip:'刷新'
	    },'-', {
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
			id :'projectNoBuildSearchYear'
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
//		{
//		text : 'ID',
//		sortable : true,
//		dataIndex : 'id',
//		flex : 1
//		},
		{xtype: 'rownumberer',minWidth :30,text :'序号'}, //设置grid 行号	
		 
		{
			text : '主管单位',
			width : 100,
			sortable : true,
			dataIndex : 'supervisorunit'
			
		},{
		text : '施工企业名称',
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
		text : '项目年份',
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
				
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.year);
		}
	},
	 
	
	{
	 text :"中标未开工线程工程(个) ",
   
	 columns: [ {
			text : '500kV(个)',
			width : 100,
			dataIndex : 'line500kv',
			
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
		 	, {
			text : '220kV(个)',
			width : 100,
			dataIndex : 'line220kv',
			
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
			text : '110kV(个)',
			width : 100,
			dataIndex : 'line110kv',
			
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
	 text :"中标未开工变电工程(个) ",
   
	 columns: [ {
			text : '500kV(个)',
			width : 100,
			dataIndex : 'power500kv',
			
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
		 	, {
			text : '220kV(个)',
			width : 100,
			dataIndex : 'power220kv',
			
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
			text : '110kV(个)',
			width : 100,
			dataIndex : 'power110kv',
			
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
	,

	{
		text : '记录创建时间',
		width : 200,
		dataIndex : 'createtime'
	}, {
		text : '记录修改时间',
		width : 200,
		dataIndex : 'updatetime'
	}
	
	
	],
	
	//分页栏
//	bbar : {
//		xtype : 'pagingtoolbar',
//		id:'pagingtool',
//		store : 'editor.UserLog',
//		displayerInfo : true
//	},
//	
//	frame:true,
//	columnLines: true,
//	selModel: selModel,
	
	
	
	initComponent:function(){

		this.callParent(arguments);
		
	}
});
