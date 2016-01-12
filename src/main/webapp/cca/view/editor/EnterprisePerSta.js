
Ext.define('RYIVS.view.editor.EnterprisePerSta', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterprisePerSta',
	title : '企业自身主要人员评估(施工项目部人员构成)',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.EnterprisePerSta',
	
	

	
	// 定义 colums
	columns : [ 
	//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	} 
	, {
		text : '岗位',
		align :'center', 
		width : 300,
		sortable : true,
		dataIndex : 'postclassifyid',
	
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.post_classify_name, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.post_classify_name);
		}
	},
	
	{
		text : '持证要求',
		align :'center', 
		width : 300,
		dataIndex : 'holderrequire',
		editor : {
			xtype : 'textfield',
			allowBlank : true
		}
		
	},
	{
	 text :"线路工程(人数)",
   
	 columns: [{
				text : '平地丘陵',
				align :'center', 
				width : 100,
				dataIndex : 'lineflatnum',
				
			
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
				text : '山区',
				align :'center', 
				width : 100,
				dataIndex : 'linemountainnum',
				
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
			
		  	 } 
	
			
	  ]	
	},{
		text : '变电工程(人数)',
		align :'center', 
		width : 100,
		dataIndex : 'powernum',
		
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
	},
	
	{
		text : '是否允许<br/>其他岗位<br/>人员兼职',
		align :'center', 
		width : 100,
		sortable : true,
		dataIndex : 'job',
		
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.post_classify_job, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.post_classify_job);
		}
	},
	
	{
		text : '备注',
		align :'center', 
		width : 400,
		dataIndex : 'remark',
		editor : {
			xtype : 'textfield',
			allowBlank : true
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
	
	
	]
});
