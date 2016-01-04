
Ext.define('RYIVS.view.editor.Behavior', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.behavior',
	title : '不良行为影响修正系数',
	iconCls : 's_equipment',
	// 定义 store
	store : 'editor.Behavior',
	// 定义 autoload
	autoload : false,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :false,
	
	   dockedItems: [{
   	 	xtype: 'toolbar',
   	 	items: [{
	        itemId: 'addButton',
	        width:50,
	        icon : 'res/icon/add.png',
	        text:'添加',
	        iconCls:'add',
	        disabled: false
	    },{
	        itemId: 'removeButton',
	        width:50,
	        icon : 'res/icon/delete.png',
	        text:'删除',
	        tooltip:'删除所有选中的记录',
	        iconCls:'remove',
	        disabled: true
	    },'-',{
	        itemId: 'refreshButton',
	        width:50,
	        icon : 'res/icon/sync.png',
	        text:'刷新',
	        tooltip:'刷新'
	    },'-', {
		itemId : 'buttonExporterExcel',
		text : '导出Excel',
		icon : 'res/icon/export.gif'	
    	},'-',{disabled:true},'项目年份:',{

         	xtype : 'combo',
			minValue : 1,
			value:  Ext.Date.format(new Date(),"Y")-1,
			editable : false,
			displayField : 'display',
			valueField : 'value',
			store : ry.constant.year, //调用外部js常量
			queryMode : 'local',
			emptyText : '请选择',	
			id :'behaviorSearchYear'
	    },'-',{
	    	itemId: 'searchButton',
	    	icon : 'res/icon/query.png',
	        text:'查询',
	        tooltip:'search some rows',
	        iconCls:'add'
	    }]
    }],
	
	// 定义 colums
	columns : [ 
{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	,{
		text : '施工企业名称',
		width : 200,
		sortable : true,
		dataIndex : 'enterpriseid',
		
		
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
		text : '不良行为发生年份',
		width : 200,
		sortable : true,
		dataIndex : 'year',
		
		
		editor : {
				allowBlank : false,
				xtype : 'combo',
				value: 0,
				minValue : 1,
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.year, //调用外部js常量
				queryMode : 'local',
				emptyText : '请选择',	
				forceSelection : true //必须选择一项
		},
		renderer : function(val) {
			return  ry.constant.trans(val,ry.constant.year);
		}
	},
	
	{
	 text :"不良行为",
   
	 columns: [{
				text : '严重不良行为次数',
				width : 200,
				dataIndex : 'seriousbadnum',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
				}
			},{
				text : '一般不良行为次数',
				width : 200,
				dataIndex : 'generalbadnum',
				
				editor : {
					allowBlank : false,
					xtype : 'numberfield',
					minValue : 0,
					autoStripChars : true,
					allowDecimals : false
				}
		  	 } 
	
			
	  ]	
	},{
		text : '修正系数',
		width : 100,
		dataIndex : 'correction'
		
		
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
	
	
	],
	
	initComponent:function(){
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

	
		this.callParent(arguments);
		
	}
});
