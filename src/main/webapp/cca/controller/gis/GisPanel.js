//播放器面板
Ext.define('RYIVS.controller.gis.GisPanel', {
	extend : 'Ext.app.Controller',
	models : [ 'gis.GisEdit' ],
	views : [ 'gis.GisPanel' ],
	stores : [ 'gis.GisEdit' ],

	refs : [ {
		selector : 'editbase[name=GisEdit]',
		ref : 'gisEdit'
	}, {
		selector : 'pagingtoolbar[text=bbar_GisEdit]',
		ref : 'pagingToolbar'
	}, {
		selector : 'panel[name=GisEdit]',
		ref : 'gisEditPanel'
	} ],

	init : function() {
		this.control({
			'gispanel' : {
				activate : this.onActivate
			},
			'editbase[name=GisEdit]' : {
				selectionchange : this.onSelectionChangeGis
			},
			'editbase[name=GisEdit] button[text=Add]' : {
				click : this.onAddGis
			},				
			'editbase[name=GisEdit] button[text=Sync]' : {
				click : this.onSync
			}
		});
		// 把GisPanel的Controller注册到全局中。
		controller.gis = this;
	},
	onActivate : function(pa, options) {
		ronyao.gis.resLayer.refresh();
	},

	// 选中Gis表格中的一行数据时, 调用此方法
	onSelectionChangeGis : function(view, selections, eOpts) {
		// Gis对象
		var me = this;

		// 配置对象.
		var conf = {
			me : me,
			isCtrl : true,
			grid : me.getGisEdit(),
			selections : selections
		};
		// 调用公共方法
		controller.editBase.onSelectionChange(conf);
		
		//高亮gis面板的元素
		if(selections[0])
		ronyao.gis.highLight(selections[0].data.id,'id');
	},

	// 添加Gis
	onAddGis : function(self) {
		var me = this;
		var mgr = {
			id : 0,
			resid : 1,
			layer : 1,
			type : 1,
			style : 1,
			data : '[]'
		};
		var conf = {
			me : me,
			self : self,
			mgr : mgr,
			isCtrl : true,
			otherEdits : [ me.getGisEdit() ],
			mgrPrefix : 'gis.' // 为GIS界面添加特殊的前缀
		};
		
		controller.editBase.onAdd(conf);
	},
	/**
	 * 点击 同步按钮 的事件
	 * 
	 * <pre>
	 * self: 点击的button对象
	 * </pre>
	 */
	onSync : function(self) {
		//刷新资源图层
		ronyao.gis.resLayer.refresh();
		//消除高亮圖層
		ronyao.gis.lightLayer.destroyFeatures();
	}
});
