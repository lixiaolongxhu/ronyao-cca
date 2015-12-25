
Ext.define('RYIVS.view.display.BearRevised', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.bearRevised',
	title : '不良行为影响修正结果',
	iconCls : 's_equipment',
	// 定义 store
	store : 'display.BearRevised',
	// 定义 autoload
	autoload : false,
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true, 
	
	// 工具条
	tbar : [{
		itemId : 'buttonRefresh',
		text : '刷新',
		icon : 'res/icon/sync.png',
		handler : function() {
			this.ownerCt.ownerCt.store.load();
		}
	} , {
		itemId : 'buttonExporterExcel',
		text : '导出Excel',
		icon : 'res/icon/export.gif'	
    }],
	
	// 定义 colums
	columns : [
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, 
	{
		text : '施工企业名称',
		width : 100,
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
	 text :"线路工程",
   
	 columns: [{
				text : '500kV(个)',
				width : 100,
				dataIndex : 'line500kv',
				
				flex : 1,
				editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
			}
			},{
				text : '220kV(个)',
				width : 100,
				dataIndex : 'line220kv',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				}
			
		  	 } ,{
				text : '110kV(个)',
				width : 100,
				dataIndex : 'line110kv',
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
				text : '产值(万元)',
				width : 100,
				dataIndex : 'lineOutput',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				}
			
		  	 }
	
			
	  ]	
	}
	,
	
	
	
	{
	 text :"变电工程",
   
	 columns: [{
				text : '500kV(个)',
				width : 100,
				dataIndex : 'power500kv',
				
				flex : 1,
				editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
			}
			},{
				text : '220kV(个)',
				width : 100,
				dataIndex : 'power220kv',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				}
			
		  	 } ,{
				text : '110kV(个)',
				width : 100,
				dataIndex : 'power110kv',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				}
			
		  	 }  ,{
				text : '产值(万元)',
				width : 100,
				dataIndex : 'powerOutput',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				}
			
		  	 }
	
			
	  ]	
	}
	
	
	,{
				text : '合计(万元)',
				width : 100,
				dataIndex : 'outputSum',
				flex : 1,
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				}
			
	 }
	
	
	
	
	],
	//设置没有数据显示文本
	viewConfig: {
		emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
        deferEmptyText:false
    },
	initComponent : function() {
		this.callParent(arguments);
	}
	
	
});
