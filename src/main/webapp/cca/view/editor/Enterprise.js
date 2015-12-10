/**企业(资质)基本信息管理.
 * 
 */
Ext.define('RYIVS.view.editor.Enterprise', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterprise',
	title : '企业(资质)基本信息',
	iconCls : 's_user',
	region : 'center',
	//定义 store
	store : 'editor.Enterprise',
	
	// 定义 autoload
	autoload : false,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
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
		text : '主管单位',
		width : 40,
		dataIndex : 'supervisorunit',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		flex : 1
	}, {
		text : '企业简称',
		width : 40,
		dataIndex : 'name',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		flex : 1
	}, {
		text : '企业全称',
		width : 40,
		dataIndex : 'fullname',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		flex : 1
	}, {
		text : '企业性质',
		width : 50,
		dataIndex : 'property',
		flex : 1,
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
		text : '注册资本金(万元)',
		width : 40,
		dataIndex : 'register',
		flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				autoStripChars : true,
				allowDecimals : false
		}
	}
	, {
		text : '企业净资产(万元)',
		width : 40,
		dataIndex : 'assets',
		flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				autoStripChars : true,
				allowDecimals : false
		}
	}, {
		text : '在职职工数',
		width : 40,
		dataIndex : 'workers',
		flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				maxValue : 100000,
				autoStripChars : true,
				allowDecimals : false
		}
	}
	,
	{
	 text :"资质 ",

	 columns: [
		 {
			text : '总承包(等级)',
			width : 60,
			dataIndex : 'overallrank',
			flex : 1,
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
			text : '专业承包(等级)',
			width : 60,
			dataIndex : 'professionrank',
			flex : 1,
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
		text : '近三年的产值(万元)',
		width : 40,
		dataIndex : 'output',
		
		flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				autoStripChars : true,
				allowDecimals : false
		}
	}, {
		text : '近三年工程数量',
		width : 40,
		dataIndex : 'project',
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
		text : '记录创建时间',
		width : 50,
		dataIndex : 'createtime'
	}, {
		text : '修改时间',
		width : 50,
		dataIndex : 'updatetime'
	}
 
	],
	

    
	initComponent : function() {
		this.callParent(arguments);
	}
	
});
