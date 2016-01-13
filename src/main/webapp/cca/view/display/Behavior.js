
Ext.define('RYIVS.view.display.Behavior', {
	requires : [ 'RYIVS.lib.GridEditBaseDisNoToolbar' ],
	extend : 'RYIVS.lib.GridEditBaseDisNoToolbar',
	alias : 'widget.displayBehavior',
	title : '不良行为影响修正系数',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.Behavior',

	
	//工具条
	dockedItems: [{
   	 	xtype: 'toolbar',
   	 	items: [{
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
			value:  Ext.Date.format(new Date(),"Y")-1,
			editable : false,
			displayField : 'display',
			valueField : 'value',
			store : ry.constant.year, //调用外部js常量
			queryMode : 'local',
			emptyText : '请选择',	
			id :'behaviorSearchYear'
	    },'-',{
	    	itemId: 'searchButton',
	    	icon : 'res/icon/query.png',
	        text:'查询',
	        tooltip:'search some rows',
	        iconCls:'add'
	    }]
    }],
	
	// 定义 colums
	columns : [ 
	//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	}
	,{
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
		text : '不良行为发生年份',
		align :'center',
		width : 200,
		sortable : true,
		dataIndex : 'year',
		
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
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
	 text :"不良行为",
   
	 columns: [{
				text : '严重不良行为次数',
				align :'center',
				width : 200,
				dataIndex : 'seriousbadnum',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
				}
			},{
				text : '一般不良行为次数',
				align :'center',
				width : 200,
				dataIndex : 'generalbadnum',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
				}
		  	 } 
	
			
	  ]	
	},{
		text : '修正系数',
		align :'center',
		width : 100,
		dataIndex : 'correction'
		
		
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
	
	
	],
	
	initComponent:function(){
		

	
		this.callParent(arguments);
		
	}
});
