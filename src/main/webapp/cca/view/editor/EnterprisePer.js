/**企业人员信息
 * 
 */
Ext.define('RYIVS.view.editor.EnterprisePer', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterprisePer',
	title : '企业人员信息管理',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.EnterprisePer',
	// 定义 autoload
	autoload : false,
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true, 
	// 定义 colums
	columns : [ {
		text : 'ID',
		width : 30,
		dataIndex : 'id'
		
	}, {
		text : '施工企业名称',
		width : 200,
		sortable : true,
		dataIndex : 'enterpriseid',
		//flex : 1,
		
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
	 text :"国家注册建造师 ",
   
	 columns: [
		 	{
			text : '一级',
			width : 60,
			dataIndex : 'constructorone',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				maxValue : 100000,
				autoStripChars : true,
				allowDecimals : false
			}
		  }, {
			text : '二级',
			width : 60,
			dataIndex : 'constructortwo',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				maxValue : 100000,
				autoStripChars : true,
				allowDecimals : false
			}
		  },
		  {
			text : '合计',
			width : 60,
			dataIndex : 'constructortotal',
			flex : 1
		  } 
	
			
	  ]	
	},

	{
	 text :"中級以上职称人员 ",

	 columns: [
		 	{
			text : '中级',
			width : 60,
			dataIndex : 'staffmiddle',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				maxValue : 100000,
				autoStripChars : true,
				allowDecimals : false
			}
		  }, {
			text : '高级',
			width : 60,
			dataIndex : 'staffhigh',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				maxValue : 100000,
				autoStripChars : true,
				allowDecimals : false
			}
		  },
		  {
			text : '合计',
			width : 60,
			dataIndex : 'stafftotal',
			flex : 1
		  } 
	
			
	  ]	
	},
	
	{
	 text :"中级工以上技术人员 ",

	 columns: [
		 	{
			text : '中级',
			width : 60,
			dataIndex : 'skillmiddle',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				maxValue : 100000,
				autoStripChars : true,
				allowDecimals : false
			}
		  }, {
			text : '高级',
			width : 60,
			dataIndex : 'skillhigh',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				maxValue : 100000,
				autoStripChars : true,
				allowDecimals : false
			}
		  },
		  {
			text : '技师',
			width : 60,
			dataIndex : 'skilltech',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				maxValue : 100000,
				autoStripChars : true,
				allowDecimals : false
			}
		  },
		  {
			text : '高级技师',
			width : 60,
			dataIndex : 'skilltechhigh',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				maxValue : 100000,
				autoStripChars : true,
				allowDecimals : false
			}
		  },
		  {
			text : '合计',
			width : 60,
			dataIndex : 'skilltotal',
			flex : 1
		  } 
	
			
	  ]	
	},{
		text : '记录创建时间',
		width : 200,
		dataIndex : 'createtime'
	}, {
		text : '修改时间',
		width : 200,
		dataIndex : 'updatetime'
	}
	
	
	
	
	]
});
