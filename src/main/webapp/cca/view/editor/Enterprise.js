/**企业(资质)基本信息管理.
 * 
 */
Ext.define('RYIVS.view.editor.Enterprise', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterprise',
	title : '企业(资质)基本信息',
	iconCls : 's_equipment',
	region : 'center',
	//定义 store
	store : 'editor.Enterprise',
	
	// 定义 autoload
	autoload : true,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true, 
	

	// 工具条
	tbar : [ {
		text : '添加',
		icon : 'res/icon/add.png',
		itemId : 'buttonAdd',
		handler : function() {
			// this.ownerCt.ownerCt.rowEditing.cancelEdit();
			var editGrid = this.ownerCt.ownerCt;

			// 如果是子表需要按需把外键进行添加

			var insertRecord = {};

			if (editGrid.newRecord != undefined) {
				insertRecord = editGrid.newRecord;
			}

			editGrid.store.insert(0, insertRecord);
			this.ownerCt.ownerCt.rowEditing.startEdit(0, 0);
		}
	}, {
		itemId : 'buttonDelete',
		text : '删除',
		icon : 'res/icon/delete.png',
		handler : function() {
			Ext.Msg.show({
				title : '删除警告',
				msg : '请再次确认删除，删除该数据将删除与之相关联的数据',
				buttons : Ext.Msg.YESNO,
				fn : function(rst) {
					
					var ctlType = this.ownerCt.ownerCt.ownerCt.xtype;
					var temp = this.ownerCt.ownerCt;
					if (rst != 'no') {
						var sm = this.ownerCt.ownerCt.getSelectionModel();
						this.ownerCt.ownerCt.rowEditing.cancelEdit();
						this.ownerCt.ownerCt.store.remove(sm.getSelection());
						if (this.ownerCt.ownerCt.store.getCount() > 0) {
							sm.select(0);
						}
					}
					
				},
				scope : this,
				icon : Ext.window.MessageBox.QUESTION
			});

		},
		disabled : true
	}, {
		itemId : 'buttonRefresh',
		text : '刷新',
		icon : 'res/icon/sync.png',
		handler : function() {
			this.ownerCt.ownerCt.store.load();
		}
	}, {
		itemId : 'buttonAptFileManager',
		text : '文件管理(企业资质附件)',
		icon : 'res/icon/control.png',
		disabled : true
    }, {
		itemId : 'buttonExporterExcel',
		text : '导出Excel',
		icon : 'res/icon/export.gif'	
    } 
    
    ],
    
    listeners : {
		'selectionchange' : function(view, records) {
			this.down('#buttonDelete').setDisabled(!records.length);
			this.down('#buttonAptFileManager').setDisabled(!records.length);
		}
	},
	
	// 定义 colums
	columns : [ 
//		{
//		text : 'ID',
//		width : 30,
//		dataIndex : 'id'
//		
//	},
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, {
		text : '主管单位',
		width : 30,
		dataIndex : 'supervisorunit',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		flex : 1
	}, 
	{
		text : '企业全称',
		width : 200,
		dataIndex : 'fullname',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		flex : 3
	},{
		text : '企业简称',
		width : 60,
		dataIndex : 'name',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		flex : 1
	}, {
		text : '企业性质',
		width : 30,
		dataIndex : 'property',
		flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value:1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.enterprise_property, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.enterprise_property);
		}
	}, {
		text : '注册资本金<br/>(万元)',
		width : 30,
		dataIndex : 'register',
		flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				autoStripChars : true,
				allowDecimals : false
		}
	}
	, {
		text : '企业净资产<br/>(万元)',
		width : 30,
		dataIndex : 'assets',
		flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				autoStripChars : true,
				allowDecimals : false
		}
	}, {
		text : '在职<br/>职工数',
		width : 30,
		dataIndex : 'workers',
		flex : 1,
		editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
		}
	}
	,
	{
	 text :"资质 ",

	 columns: [
		 {
			text : '总承包<br/>(等级)',
			width : 60,
			dataIndex : 'overallrank',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'combo',
				value:1,
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
		}, {
			text : '专业承包<br/>(等级)',
			width : 60,
			dataIndex : 'professionrank',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'combo',
				value:1,
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
			
	  }]	
	},
	
	{
	 text :"近三年工程数量 ",

	 columns: [
		 {
			text : '去年<br/>工程<br/>数量',
			width : 50,
			dataIndex : 'projectlast',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
		 },{
			text : '前年<br/>工程<br/>数量',
			width : 50,
			dataIndex : 'projectbefore',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
		 },{
			text : '上前年<br/>工程<br/>数量',
			width : 50,
			dataIndex : 'projectbeforelast',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				
				autoStripChars : true,
				allowDecimals : false
			}
		 },{
			text : '合计',
			width : 50,
			dataIndex : 'project',
			flex : 2
		 }
			
	  ]	
	},
	
		
	{
	 text :"近三年产值 ",

	 columns: [
		 {
			text : '去年<br/>产值 ',
			width : 80,
			dataIndex : 'outputlast',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
		 },{
			text : '前年<br/>产值 ',
			width : 80,
			dataIndex : 'outputbefore',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
		 },{
			text : '上前年<br/>产值 ',
			width : 80,
			dataIndex : 'outputbeforelast',
			flex : 2,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
			
		}
			,{
			text : '合计 ',
			width : 80,
			dataIndex : 'output',
			flex : 2
			
		 }
			
	  ]	
	}, {
		text : '记录创建<br/>时间',
		width : 50,
		flex : 1,
		dataIndex : 'createtime'
	}, {
		text : '记录修改时间',
		width : 50,
		flex : 1,
		dataIndex : 'updatetime'
		
	}
 
	],
	

    
	initComponent : function() {
		this.callParent(arguments);
	}
	
});
