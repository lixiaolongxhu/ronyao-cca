
Ext.define('RYIVS.view.editor.EquipmentBear', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.equipmentBear',
	title : '机具设备对工程承载力的评估',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.EquipmentBear',
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
	, 
	{
		text : '张牵设备',
		width : 200,
		dataIndex : 'name',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	},
		
	{
		text : '电压等级',
		width : 100,
		sortable : true,
		dataIndex : 'voltagerankid',
		
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.voltageRankClassify_name , //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.voltageRankClassify_name );
		}
	},
	
	{
		text : '单回/双回',
		width : 100,
		sortable : true,
		dataIndex : 'linetype',
		
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.equipment_lineType, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.equipment_lineType);
		}
	},
	
	
	{
	 text :"导线展放效率(km/月.套)",
   
	 columns: [{
				text : '平地丘陵',
				width : 100,
				dataIndex : 'lineplain',
				
				
				editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
			}
			},{
				text : '山区',
				width : 100,
				dataIndex : 'linebrae',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 1,
					autoStripChars : true,
					allowDecimals : false
				}
			
		  	 } 
	
			
	  ]	
	},
	
	
	{
		text : '说明',
		width : 600,
		dataIndex : 'explains',
		editor : {
			xtype : 'textarea',
			allowBlank : true
		}
	
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
