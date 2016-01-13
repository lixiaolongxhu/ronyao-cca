

Ext.define('RYIVS.view.editor.ProjectNoBuild', {
	requires : [ 'RYIVS.lib.GridEditBaseDisNoToolbar' ],
	extend : 'RYIVS.lib.GridEditBaseDisNoToolbar',
	alias : 'widget.projectNoBuild',
	title : '中标未开工情况',
	iconCls : 's_equipment',
	store:'editor.ProjectNoBuild',
	
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
			this.down('#removeButton').setDisabled(!records.length);
		}
	},
    
	// 定义 colums
	columns : [
	//设置grid 行号
		{	xtype: 'rownumberer',
			align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
			minWidth :30,
			text :'序号'
		} ,
		 
		{
			text : '主管单位',
			align :'center', 
			width : 100,
			sortable : true,
			dataIndex : 'supervisorunit'
			
		},{
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
			align :'center', 
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
			align :'center', 
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
			align :'center', 
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
			align :'center', 
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
			align :'center', 
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
			align :'center', 
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
