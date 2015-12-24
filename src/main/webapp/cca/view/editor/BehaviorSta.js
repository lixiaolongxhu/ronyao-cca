
Ext.define('RYIVS.view.editor.BehaviorSta', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.behaviorSta',
	title : '施工企业不良行文分类标准',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.BehaviorSta',
	// 定义 autoload
	autoload : false,
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :true, 
	
	autoScroll : true, //'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	
	
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
    }],
    
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
	{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, {
		text : '不良行为等级',
		width : 100,
		sortable : true,
		dataIndex : 'ranktype',
		//flex : 1,
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.behavior_standard_rankType, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.behavior_standard_rankType);
		}
	},
	
	{
		text : '诚信',
		width : 200,
		dataIndex : 'sincerity',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		},
		flex : 1
	},
		{
		text : '安全质量',
		width : 200,
		dataIndex : 'save',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		},
		flex : 1
	},
	{
		text : '履约进度',
		width : 200,
		dataIndex : 'progress',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		},
		flex : 1
	},
	{
		text : '服务',
		width : 200,
		dataIndex : 'service',
		editor : {
			xtype : 'textarea',
			allowBlank : false
		},
		flex : 1
	},
	{
		text : '其他',
		width : 100,
		dataIndex : 'other',
		editor : {
			xtype : 'textarea',
			allowBlank : true
		},
		flex : 1
	},

	{
		text : '记录创建时间',
		width : 100,
		dataIndex : 'createtime'
	}, {
		text : '记录修改时间',
		width : 100,
		dataIndex : 'updatetime'
	}
	
	
	]
});
