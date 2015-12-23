
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
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true, 
	// 定义 colums
	columns : [
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, 
	{
		text : '张牵设备',
		width : 300,
		dataIndex : 'name',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		flex : 1
	},
		
	{
		text : '电压等级',
		width : 200,
		sortable : true,
		dataIndex : 'voltagerankid',
		//flex : 1,
		
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
		width : 200,
		sortable : true,
		dataIndex : 'linetype',
		//flex : 1,
		
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
				
				flex : 1,
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
	},
	
	
	{
		text : '说明',
		width : 200,
		dataIndex : 'explains',
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
