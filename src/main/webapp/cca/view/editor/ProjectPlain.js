

Ext.define('RYIVS.view.editor.ProjectPlain', {
	extend : 'Ext.grid.Panel',
//		requires : [ 'RYIVS.lib.GridEditBase' ],
//	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.projectPlain',
	title : '下一年公司新开工项目情况',
	iconCls : 's_equipment',
	store:'editor.ProjectPlain',
	// 定义 autoload
	autoload : false,
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true,
	
	
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
	        itemId: 'addButton',
	        width:50,
	        icon : 'res/icon/add.png',
	        text:'添加',
	        iconCls:'add',
	        disabled: false
	    },{
	        itemId: 'removeButton',
	        width:50,
	        icon : 'res/icon/delete.png',
	        text:'删除',
	        tooltip:'删除所有选中的记录',
	        iconCls:'remove',
	        disabled: true
	    },'-',{
	        itemId: 'refreshButton',
	        width:50,
	        icon : 'res/icon/sync.png',
	        text:'刷新',
	        tooltip:'刷新'
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
			this.down('#removeButton').setDisabled(!records.length);
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
		text : '电压等级',
		width : 200,
		sortable : true,
		dataIndex : 'voltagerankclassifyid',
		flex : 1,
		
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
		width : 200,
		sortable : true,
		dataIndex : 'year',
		flex : 1,
		
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
			width : 200,
			dataIndex : 'projectnum',
			flex : 1,
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
			width : 100,
			dataIndex : 'lineproject',
			flex : 1,
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
			width : 100,
			dataIndex : 'powerproject',
			flex : 1,
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
			width : 100,
			dataIndex : 'assesslineproject',
			flex : 1,
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
			width : 100,
			dataIndex : 'assesspowerproject',
			flex : 1,
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
			width : 100,
			dataIndex : 'linelength',
			flex : 1,
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
			width : 100,
			dataIndex : 'volume',
			flex : 1,
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
			width : 100,
			dataIndex : 'investment',
			flex : 1,
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
		width : 100,
		dataIndex : 'createtime'
	}, {
		text : '修改时间',
		width : 100,
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
		// 1 编辑器插件
		this.rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
			// clicksToMoveEditor : 1, clicksToEdit : 2, autoCancel : true,
			errorSummary : false,

			/**
			 * 是否在取消编辑的时候自动删除添加的记录 if true, auto remove phantom record on
			 * cancel,default is true.
			 * 
			 * @cfg {Boolean}
			 */
			autoRecoverOnCancel : true,

			/**
			 * 取消编辑 1.fireEvent 'canceledit' 2.when autoRecoverOnCancel is true,
			 * if record is phantom then remove it
			 * 
			 * @private
			 * @override
			 */
			cancelEdit : function() {
				var me = this;
				if (me.editing) {
					me.getEditor().cancelEdit();
					me.editing = false;
					me.fireEvent('canceledit', me.context);
					//重新加载stores数据 刷新前端grid界面
					if (me.autoRecoverOnCancel) {
						me.grid.store.load();
					}
				}
			}
		});

		// 2 语言翻译
		if (Ext.grid.RowEditor) {
			Ext.apply(Ext.grid.RowEditor.prototype, {
				saveBtnText : '保存',
				cancelBtnText : '取消',
				errorsText : "<font color='red'>错误信息</font>",
				dirtyText : "已修改,你需要提交或取消变更"
			});
		}

		// 3 添加插件
		this.plugins = [ this.rowEditing ];

	
		this.callParent(arguments);
		
	}
});