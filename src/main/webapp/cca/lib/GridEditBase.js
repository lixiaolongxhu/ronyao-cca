/* 通用编辑器
 * 初始化需要
 * 1 columns 配置对象，显示列和验证条件
 * 2 model 字符串
 * 3 autoload 布尔，是否自动装载
 * *********************
 * 4 itemid 自身的ID （可选，主表设置）
 * 5 master 主表的ID（可选，从表设置） 
 * 6 fkey 外键名称（可选，从表设置）
 * ******************************
 * 7 defaultRec 需要插入的缺省值
 */

/*
 * 主子表关系
 * 1 子向上级寻找主表
 * 2 说明主表的ID
 * 3 当主表的行未选中时，子表的所有功能按钮应该失效
 * 4 当添加的时候，应该读取主表的id
 */

 

Ext.define('RYIVS.lib.GridEditBase', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.gridEditBase',
	
	//居中布局
	region : 'center',
	// 定义 autoload
	autoload : false,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :false, 
	//是否显示列分割线，默认为false
	columnLines : true, 
	
	//设置没有数据显示文本
	viewConfig: {
		emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
        deferEmptyText:false,
        //ExtJS如果设置表格行高，不要改公用样式只是针对当前表格
        getRowClass:function(){
             // 在这里添加自定样式 改变这个表格的行高
        	
             return 'x-grid-row custom-grid-row';
         }
    },

    //引入grid 特征 - 列求和
	features: [{
        ftype: 'summary'
    }],
    
    
	// 默认工具条
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
	} 
	, {
		itemId : 'buttonExporterExcel',
		text : '导出Excel',
		icon : 'res/icon/export.gif'	
    }],

	listeners : {
		'selectionchange' : function(view, records) {
			this.down('#buttonDelete').setDisabled(!records.length);
		}
	},

	// 通过主表的id进行装载
	loadByMasterId : function(resid, type) {

		if (resid) {
			this.store.proxy.extraParams.masterId = resid;
		}
		if (type) {
			this.store.proxy.extraParams.type = type;
		}
		if(this.store.proxy.extraParams.type == "resid"){
			if (this.store.proxy.extraParams.masterId && this.store.proxy.extraParams.type) {
				this.store.load();
			}
		}else{
			if (this.store.proxy.extraParams.masterId) {
				this.store.load();
			}
		}
	},

	initComponent : function() {
		
		//保存数据后，自动刷新列表
		/*this.on('edit', function(editor, e) {
			editor.grid.store.load();
		});*/

		// 1 编辑器插件
		this.rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
			// clicksToMoveEditor : 1, clicksToEdit : 2, autoCancel : true,
			errorSummary : false,

			/**
			 * 是否在取消编辑的时候自动删除添加的记录 if true, auto remove phantom record on
			 * cancel,default is true.
			 * 
			 * @cfg {Boolean}
			 */
			autoRecoverOnCancel : true,

			/**
			 * 取消编辑 1.fireEvent 'canceledit' 2.when autoRecoverOnCancel is true,
			 * if record is phantom then remove it
			 * 
			 * @private
			 * @override
			 */
			cancelEdit : function() {
				var me = this;
				if (me.editing) {
					me.getEditor().cancelEdit();
					me.editing = false;
					me.fireEvent('canceledit', me.context);
					//重新加载stores数据 刷新前端grid界面
					if (me.autoRecoverOnCancel) {
						me.grid.store.load();
					}
				}
			}
		});

		// 2 语言翻译
		if (Ext.grid.RowEditor) {
			Ext.apply(Ext.grid.RowEditor.prototype, {
				saveBtnText : '保存',
				cancelBtnText : '取消',
				errorsText : "<font color='red'>错误信息</font>",
				dirtyText : "已修改,你需要提交或取消变更"
			});
		}

		// 3 添加插件
		this.plugins = [ this.rowEditing ];

//		// 4 model 和 store 配置
//		this.store = new Ext.data.Store({
//			// Store所对应的模型
//			model : this.model,
//			autoSync : true,
//			// 是否自动加载
//			autoLoad : this.autoload
//
//		});

		// 5 配置主子表关系
		if (this.master) {
			this.on('afterrender', this.onAfterRender, this);
		}

		// 6 需要新增加的记录对象
		if (!this.newRecord) {
			this.newRecord = {};
		};

		this.callParent(arguments);
		this.addEvents('onDragDrop');
	},

	// 界面建立时只调用一次
	onAfterRender : function(me, eOpts) {
		var master = this.ownerCt.queryById(this.master);
		master.on('selectionchange', this.onMasterSelectChange, this);
		this.down('#buttonAdd').setDisabled(true);
		this.down('#buttonRefresh').setDisabled(true);
	},

	// 主表选择变化
	onMasterSelectChange : function(view, selections, options) {

		// 主表
		var master = this.ownerCt.queryById(this.master);

		// 设置子表添新字段时的初始值，主要是外键
		if ((selections[0]) && (selections[0].data.id != undefined)) {
			this.newRecord[this.fkey] = selections[0].data.id;
		}

		var select = selections[0];
		if (selections.length && selections[0].data.id) {
			this.loadByMasterId(selections[0].data.id);
			this.down('#buttonAdd').setDisabled(false);
			this.down('#buttonRefresh').setDisabled(false);
		} else {
			this.store.removeAll();
			this.down('#buttonAdd').setDisabled(true);
			this.down('#buttonRefresh').setDisabled(true);
		}

	}
});
