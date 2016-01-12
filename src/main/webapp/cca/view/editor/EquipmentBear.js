
Ext.define('RYIVS.view.editor.EquipmentBear', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.equipmentBear',
	title : '机具设备对工程承载力的评估',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.EquipmentBear',
	
	// 定义 colums
	columns : [//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	} 
	, 
	{
		text : '张牵设备',
		align :'center',
		width : 200,
		dataIndex : 'name',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	},
		
	{
		text : '电压等级',
		align :'center',
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
		align :'center',
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
				align :'center',
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
				align :'center',
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
		align :'center',
		width : 600,
		dataIndex : 'explains',
		editor : {
			xtype : 'textarea',
			allowBlank : true
		},
		renderer : function (value, meta, record) {
				//自动换行渲染
				meta.style = 'white-space:normal;word-break:break-all;';
				return value;
		}
	
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
