/**企业人员信息
 * 
 */
Ext.define('RYIVS.view.editor.EnterprisePer', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterprisePer',
	title : '企业人员信息管理',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.EnterprisePer',
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
		itemId : 'buttonPerFileManager',
		text : '文件管理(持证人员附件)',
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
			this.down('#buttonPerFileManager').setDisabled(!records.length);
		}
	},
    
	// 定义 colums
	columns : [ 
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, {
		text : '施工企业名称',
		width : 200,
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
	 text :"国家注册建造师 ",
   
	 columns: [
		 	{
			text : '一级',
			width : 100,
			dataIndex : 'constructorone',
			//flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
		  }, {
			text : '二级',
			width : 100,
			dataIndex : 'constructortwo',
		//	flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
		  },
		  {
			text : '合计',
			width : 100,
			dataIndex : 'constructortotal'
			
		  } 
	
			
	  ]	
	},

	{
	 text :"中級以上职称人员 ",

	 columns: [
		 	{
			text : '中级',
			width : 100,
			dataIndex : 'staffmiddle',
		
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
		  }, {
			text : '高级',
			width : 100,
			dataIndex : 'staffhigh',
			
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				
				autoStripChars : true,
				allowDecimals : false
			}
		  },
		  {
			text : '合计',
			width : 60,
			dataIndex : 'stafftotal',
			
		  } 
	
			
	  ]	
	},
	
	{
	 text :"中级工以上技术人员 ",

	 columns: [
		 	{
			text : '中级',
			width : 100,
			dataIndex : 'skillmiddle',
			
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
				
				autoStripChars : true,
				allowDecimals : false
			}
		  }, {
			text : '高级',
			width : 100,
			dataIndex : 'skillhigh',
			
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
		  },
		  {
			text : '技师',
			width : 100,
			dataIndex : 'skilltech',
		
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
		  },
		  {
			text : '高级技师',
			width : 100,
			dataIndex : 'skilltechhigh',
			
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0,
			
				autoStripChars : true,
				allowDecimals : false
			}
		  },
		  {
			text : '合计',
			width : 100,
			dataIndex : 'skilltotal'
			
		  } 
	
			
	  ]	
	},{
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
