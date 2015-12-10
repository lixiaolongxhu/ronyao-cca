
Ext.define('RYIVS.view.editor.EnterprisePerSta', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterprisePerSta',
	title : '企业自身主要人员评估(施工项目部人员构成)',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.EnterprisePerSta',
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
	
	// 定义 colums
	columns : [ {
		text : 'ID',
		width : 30,
		dataIndex : 'id'
		
	}, {
		text : '岗位',
		width : 100,
		sortable : true,
		dataIndex : 'postclassifyid',
		//flex : 1,
		
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
		width : 300,
		dataIndex : 'holderrequire',
		editor : {
			xtype : 'textfield',
			allowBlank : true
		},
		flex : 1
	},
	{
	 text :"线路工程(人数)",
   
	 columns: [{
				text : '平地丘陵',
				width : 100,
				dataIndex : 'lineflatnum',
				
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false,
				
 				},
 			
 				summaryType: 'sum' , //引入grid 特征后 - 列求和: 详细见Ext.grid.feature.Summary的api
				summaryRenderer: function(value, summaryData, dataIndex) {
           			 return Ext.String.format('合计: {0} ', value, value !== 1 ? 's' : ''); 
       		    }
			},{
				text : '山区',
				width : 100,
				dataIndex : 'linemountainnum',
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
			
		  	 } 
	
			
	  ]	
	},{
		text : '变电工程(人数)',
		width : 100,
		dataIndex : 'powernum',
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
	},
	
	{
		text : '是否允许其他<br/>岗位人员兼职',
		width : 80,
		sortable : true,
		dataIndex : 'job',
		//flex : 1,
		
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
		width : 200,
		dataIndex : 'remark',
		editor : {
			xtype : 'textfield',
			allowBlank : true
		},
		flex : 1
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
	
	
	]
});
