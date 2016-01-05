/**企资质标准分类
 * 
 */
Ext.define('RYIVS.view.display.EnterpriseApt', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.displayEnterpriseApt',
	title : '企业资质对施工承载能力评估',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.EnterpriseApt',
	// 定义 autoload
	autoload : false,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :false, 
	
	
	// 工具条
	tbar : [ {
		itemId : 'buttonRefresh',
		text : '刷新',
		icon : 'res/icon/sync.png',
		handler : function() {
			this.ownerCt.ownerCt.store.load();
		}
	}, {
		itemId : 'buttonLookOver',
		text : '查看详细',
		icon : 'res/icon/history.png',
		disabled : true
		
    }, {
		itemId : 'buttonExporterExcel',
		text : '导出Excel',
		icon : 'res/icon/export.gif'	
    } 
    
    ],
    
    //事件监听 ,判断按钮是否可用
    listeners : {
		'selectionchange' : function(view, records) {

			//选中某条记录后,查看按钮可用
			this.down('#buttonLookOver').setDisabled(!records.length);
		}
	},
	
	
	// 定义 colums
	columns : [
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号	
	, {
		text : '企业资质',
		width : 100,
		sortable : true,
		dataIndex : 'aptitudeid',
		
		
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
		width : 100,
		sortable : true,
		dataIndex : 'aptituderank',
		
		
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
		width : 200,
		dataIndex : 'qualifications',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
		
	},
	{
	 text :"企业人员",
   
	 columns: [{
				text : '执业资格',
				width : 300,
				dataIndex : 'practicing',
				editor : {
					xtype : 'textarea',
					allowBlank : true
				}
				
			},{
				text : '技术负责人',
				width : 300,
				dataIndex : 'charge',
				editor : {
					xtype : 'textarea',
					allowBlank : false
				}
			
		  	 } ,{
				text : '技术人员',
				width : 300,
				dataIndex : 'technical',
				editor : {
					xtype : 'textarea',
					allowBlank : false
				}
			
		  	 } ,{
				text : '技能人员',
				width : 300,
				dataIndex : 'skills',
				editor : {
					xtype : 'textarea',
					allowBlank : false
				}
			
		  	 }
	
			
	  ]	
	},{
		text : '承包范围',
		width : 400,
		dataIndex : 'jobrange',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		},
		
	},

	{
		text : '记录创建时间',
		width : 200,
		dataIndex : 'createtime'
	}, {
		text : '修改时间',
		width : 200,
		dataIndex : 'updatetime'
	}
	
	
	]
});
