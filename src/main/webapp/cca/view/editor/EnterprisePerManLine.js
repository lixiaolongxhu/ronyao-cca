
Ext.define('RYIVS.view.editor.EnterprisePerManLine', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterprisePerManLine',
	title : '施工企业现场管理人员(线路专业人员)',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.EnterprisePerManLine',
	
	
	
	
	// 定义 colums
	columns : [ 
//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	}
	, {
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
	 text :"线路专业",
   
	 columns: [{
				text : '500kv<br/>项目经理',
				align :'center', 
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
				align :'center', 
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
				align :'center', 
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
				align :'center', 
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
				align :'center', 
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
				align :'center', 
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
				align :'center', 
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
				align :'center', 
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
				align :'center', 
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
				align :'center', 
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
				align :'center', 
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
				align :'center', 
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
				align :'center', 
				width : 100,
				dataIndex : 'constructionteam',
			
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue :0,
					autoStripChars : true,
					allowDecimals : false
					
				}
			
		  	 },{
				text : '施工队,技术员<br/>质检员,兼职安全员',
				align :'center', 
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
				align :'center', 
				width : 100,
				dataIndex : 'sum'
				
		  	 }
			
	  ]	
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
