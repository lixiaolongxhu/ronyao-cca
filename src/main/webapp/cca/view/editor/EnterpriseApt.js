/**企资质标准分类
 * 
 */
Ext.define('RYIVS.view.editor.EnterpriseApt', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.enterpriseApt',
	title : '企业资质对施工承载能力评估',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.EnterpriseApt',
	
	
	
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
			//选中记录后,删除按钮可用
			this.down('#buttonDelete').setDisabled(!records.length);
			//选中某条记录后,查看按钮可用
			this.down('#buttonLookOver').setDisabled(!records.length);
		}
	},
	
	
	// 定义 colums
	columns : [
	//设置grid 行号
	{	xtype: 'rownumberer',
		align :'center',  //设置列头及单元格的对齐方向。 可取值: 'left', 'center', and 'right'
		minWidth :30,
		text :'序号'
	} 
	, {
		text : '企业资质',
		align :'center', 
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
		align :'center', 
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
		align :'center', 
		width : 200,
		dataIndex : 'qualifications',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		renderer : function (value, meta, record) {
			//自动换行渲染
			meta.style = 'white-space:normal;word-break:break-all;';
			return value;
		}
		
	},
	{
	 text :"企业人员",
   
	 columns: [{
				text : '执业资格',
				align :'center', 
				width : 300,
				dataIndex : 'practicing',
				editor : {
					xtype : 'textarea',
					allowBlank : true
				},
				renderer : function (value, meta, record) {
					//自动换行渲染
					meta.style = 'white-space:normal;word-break:break-all;';
					return value;
				}
				
			},{
				text : '技术负责人',
				align :'center', 
				width : 300,
				dataIndex : 'charge',
				editor : {
					xtype : 'textarea',
					allowBlank : false
				},
				renderer : function (value, meta, record) {
					//自动换行渲染
					meta.style = 'white-space:normal;word-break:break-all;';
					return value;
				}
			
		  	 } ,{
				text : '技术人员',
				align :'center', 
				width : 300,
				dataIndex : 'technical',
				editor : {
					xtype : 'textarea',
					allowBlank : false
				},
				renderer : function (value, meta, record) {
					//自动换行渲染
					meta.style = 'white-space:normal;word-break:break-all;';
					return value;
				}
			
		  	 } ,{
				text : '技能人员',
				align :'center', 
				width : 300,
				dataIndex : 'skills',
				editor : {
					xtype : 'textarea',
					allowBlank : false
				},
				renderer : function (value, meta, record) {
					//自动换行渲染
					meta.style = 'white-space:normal;word-break:break-all;';
					return value;
				}
					
		  	 }
	
			
	  ]	
	},{
		text : '承包范围',
		align :'center', 
		width : 400,
		dataIndex : 'jobrange',
		editor : {
			xtype : 'textarea',
			allowBlank : false
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
