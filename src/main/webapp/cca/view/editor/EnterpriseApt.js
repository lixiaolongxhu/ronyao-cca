/**企资质标准分类
 * 
 */
Ext.define('RYIVS.view.editor.EnterpriseApt', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterpriseApt',
	title : '企资质标准分类',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.EnterpriseApt',
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
		text : '企业资质',
		width : 50,
		sortable : true,
		dataIndex : 'aptitudeid',
		//flex : 1,
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.enterprise_aptitude_classify, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.enterprise_aptitude_classify);
		}
	},
	
	 {
		text : '等级',
		width : 50,
		sortable : true,
		dataIndex : 'aptituderank',
		//flex : 1,
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
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
	},{
		text : '资质要求',
		width : 40,
		dataIndex : 'qualifications',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		flex : 1
	},
	{
	 text :"企业人员",
   
	 columns: [{
				text : '执业资格',
				width : 200,
				dataIndex : 'practicing',
				editor : {
					xtype : 'textfield',
					allowBlank : true
				},
				flex : 1
			},{
				text : '技术负责人',
				width : 200,
				dataIndex : 'charge',
				editor : {
					xtype : 'textfield',
					allowBlank : false
				},
				flex : 1
			
		  	 } ,{
				text : '技术人员',
				width : 200,
				dataIndex : 'technical',
				editor : {
					xtype : 'textfield',
					allowBlank : false
				},
				flex : 1
			
		  	 } ,{
				text : '技能人员',
				width : 200,
				dataIndex : 'skills',
				editor : {
					xtype : 'textfield',
					allowBlank : false
				},
				flex : 1
			
		  	 }
	
			
	  ]	
	},{
		text : '承包范围',
		width : 300,
		dataIndex : 'jobrange',
		editor : {
			xtype : 'textfield',
			allowBlank : false
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
