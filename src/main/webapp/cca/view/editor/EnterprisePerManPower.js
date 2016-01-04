
Ext.define('RYIVS.view.editor.EnterprisePerManPower', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterprisePerManPower',
	title : '施工企业现场管理人员(变电专业)',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.EnterprisePerManPower',
	// 定义 autoload
	autoload : false,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :false, 
	
	
	// 定义 colums
	columns : [
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, {
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
	 text :"变电专业",
   
	 columns: [{
				text : '500kv<br/>项目经理',
				width : 80,
				dataIndex : 'onemanager',
				
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false		
 				}
	
			},{
				text : '220kv及以下<br/>项目经理',
				width : 80,
				dataIndex : 'twomanager',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 } ,{
				text : '220kv及以上<br/>项目总工',
				width : 80,
				dataIndex : 'onechief',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '110kv<br/>项目总工',
				width : 80,
				dataIndex : 'twochief',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '安全员',
				width : 80,
				dataIndex : 'safetyofficer',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '质检员',
				width : 80,
				dataIndex : 'inspector',
			
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '技术员',
				width : 100,
				dataIndex : 'technician',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '造价员',
				width : 100,
				dataIndex : 'costmember',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '资料员',
				width : 80,
				dataIndex : 'documenter',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '综合管理员',
				width : 100,
				dataIndex : 'integrator',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '材料员',
				width : 100,
				dataIndex : 'material',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '协调员',
				width : 80,
				dataIndex : 'expeditor',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '施工队长',
				width : 100,
				dataIndex : 'constructionteam',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '施工队,技术员<br/>质检员,兼职安全员',
				width : 150,
				dataIndex : 'plurality',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 }
		  	 ,{
				text : '合计',
				width : 100,
				dataIndex : 'sum',
				
		  	 }
			
	  ]	
	},
	
	

	{
		text : '记录创建时间',
		width : 200,
		dataIndex : 'createtime'
	}, {
		text : '记录修改时间',
		width : 200,
		dataIndex : 'updatetime'
	}
	
	
	]
});
