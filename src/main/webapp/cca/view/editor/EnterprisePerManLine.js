
Ext.define('RYIVS.view.editor.EnterprisePerManLine', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterprisePerManLine',
	title : '施工企业现场管理人员(线路专业)',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.EnterprisePerManLine',
	// 定义 autoload
	autoload : false,
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true,
	
	
	
	// 定义 colums
	columns : [ 
{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, {
		text : '施工企业名称',
		width : 300,
		sortable : true,
		dataIndex : 'enterpriseid',
		flex : 1,
		
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
	 text :"线路专业",
   
	 columns: [{
				text : '500kv项目经理',
				width : 80,
				dataIndex : 'onemanager',
				
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false		
 				}
	
			},{
				text : '220kv及以下项目经理',
				width : 80,
				dataIndex : 'twomanager',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 } ,{
				text : '220kv及以上项目总工',
				width : 80,
				dataIndex : 'onechief',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '110kv项目总工',
				width : 80,
				dataIndex : 'twochief',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '安全员',
				width : 80,
				dataIndex : 'safetyofficer',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '质检员',
				width : 80,
				dataIndex : 'inspector',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '技术员',
				width : 100,
				dataIndex : 'technician',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '造价员',
				width : 100,
				dataIndex : 'costmember',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '资料员',
				width : 80,
				dataIndex : 'documenter',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '综合管理员',
				width : 100,
				dataIndex : 'integrator',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '材料员',
				width : 100,
				dataIndex : 'material',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '协调员',
				width : 80,
				dataIndex : 'expeditor',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '施工队长',
				width : 100,
				dataIndex : 'constructionteam',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '施工队,技术员<br/>质检员,兼职安全员',
				width : 100,
				dataIndex : 'plurality',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 }
		  	 ,{
				text : '合计',
				width : 100,
				dataIndex : 'sum',
				flex : 1
		  	 }
			
	  ]	
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
