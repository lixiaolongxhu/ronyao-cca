/**企业(资质)基本信息管理.
 * 
 */
Ext.define('RYIVS.view.display.Enterprise', {
	requires : [ 'RYIVS.lib.GridEditBaseDis' ],
	extend : 'RYIVS.lib.GridEditBaseDis',
	alias : 'widget.displayEnterprise',
	title : '资质信息',
	iconCls : 's_equipment',
	//定义 store
	store : 'editor.Enterprise',
	
	
	// 工具条
	tbar : [ {
		itemId : 'buttonRefresh',
		text : '刷新',
		icon : 'res/icon/sync.png',
		handler : function() {
			this.ownerCt.ownerCt.store.load();
		}
	}, {
		itemId : 'buttonAptFileManager',
		text : '文件管理(企业资质附件)',
		icon : 'res/icon/control.png',
		disabled : true
    }, {
		itemId : 'buttonExporterExcel',
		text : '导出Excel',
		icon : 'res/icon/export.gif'	
    } 
    
    ],
    
    listeners : {
		'selectionchange' : function(view, records) {
			
			this.down('#buttonAptFileManager').setDisabled(!records.length);
		}
	},
	
	// 定义 colums
	columns : [ 

	//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	} 
	
	, {
		text : '主管单位',
		align :'center', 
		width : 100,
		dataIndex : 'supervisorunit',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
		
	}, 
	{
		text : '企业全称',
		align :'center', 
		width : 250,
		dataIndex : 'fullname',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	
	},{
		text : '企业简称',
		align :'center', 
		width : 100,
		dataIndex : 'name',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	
	}, {
		text : '企业性质',
		align :'center', 
		width : 100,
		dataIndex : 'property',
	
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value:1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.enterprise_property, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.enterprise_property);
		}
	}, {
		text : '注册资本金<br/>(万元)',
		align :'center', 
		width : 100,
		dataIndex : 'register',
		//flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				autoStripChars : true,
				allowDecimals : false
		}
	}
	, {
		text : '企业净资产<br/>(万元)',
		align :'center', 
		width : 100,
		dataIndex : 'assets',
	//	flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				autoStripChars : true,
				allowDecimals : false
		}
	}, {
		text : '在职<br/>职工数',
		align :'center', 
		width : 100,
		dataIndex : 'workers',
	//	flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
		}
	}
	,
	{
	 text :"资质 ",

	 columns: [
		 {
			text : '总承包<br/>(等级)',
			align :'center', 
			width : 100,
			dataIndex : 'overallrank',
		//	flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'combo',
				value:1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.enterprise_aptitude_rank, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
			},
			renderer : function(val) {
				return  ry.constant.trans(val,ry.constant.enterprise_aptitude_rank);
			}
		}, {
			text : '专业承包<br/>(等级)',
			align :'center', 
			width : 100,
			dataIndex : 'professionrank',
			//flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'combo',
				value:1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.enterprise_aptitude_rank, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
			},
			renderer : function(val) {
				return  ry.constant.trans(val,ry.constant.enterprise_aptitude_rank);
			}
			
	  }]	
	},
	
	{
	 text :"近三年工程数量 ",

	 columns: [
		 {
			text : '去年<br/>工程<br/>数量',
			align :'center', 
			width : 100,
			dataIndex : 'projectlast',
			//flex : 2,
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
			text : '前年<br/>工程<br/>数量',
			align :'center', 
			width : 100,
			dataIndex : 'projectbefore',
			//flex : 2,
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
			text : '上前年<br/>工程<br/>数量',
			align :'center', 
			width : 100,
			dataIndex : 'projectbeforelast',
			//flex : 2,
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
			text : '合计',
			align :'center', 
			width : 100,
			dataIndex : 'project',
		//	flex : 2,
 			
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
		 }
			
	  ]	
	},
	
		
	{
	 text :"近三年产值 ",

	 columns: [
		 {
			text : '去年<br/>产值 ',
			align :'center', 
			width : 200,
			dataIndex : 'outputlast',
			//flex : 2,
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
			text : '前年<br/>产值 ',
			align :'center', 
			width : 200,
			dataIndex : 'outputbefore',
			//flex : 2,
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
			text : '上前年<br/>产值 ',
			align :'center', 
			width : 200,
			dataIndex : 'outputbeforelast',
		//	flex : 2,
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
			,{
			text : '合计 ',
			align :'center', 
			width : 200,
			dataIndex : 'output',
			//flex : 2,
 			
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			
		 }
			
	  ]	
	}, {
		text : '记录创建时间',
		align :'center', 
		width : 200,
		//flex : 1,
		dataIndex : 'createtime'
	}, {
		text : '记录修改时间',
		align :'center', 
		width : 200,
		//flex : 1,
		dataIndex : 'updatetime'
		
	}
 
	],
	

    
	initComponent : function() {
		this.callParent(arguments);
	}
	
});
