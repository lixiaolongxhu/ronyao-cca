/**
 * 编码器管理
 */
Ext.define('RYIVS.controller.editor.Encoder', {
	extend : 'Ext.app.Controller',
	models : [ 'editor.Encoder', 'editor.EncChannel', 'common.ResGrid'],
	views : [ 'editor.Encoder', 'common.ResGrid' ],

	refs : [ {
		selector : 'gridEditEncoder > gridEditBase[master="master"]',
		ref : 'encChannelGrid'
	}, {
		selector : 'resGrid',
		ref : 'resGrid'
	} ],

	init : function() {
		this.control({
			'gridEditEncoder' : {
				activate : this.onActivate,
				afterrender : this.afterRender
			}
		});

		controller.encoder = this;

	},

	// 当标签激活时
	onActivate : function(pa, options) {
		pa.items.items[0].store.load();
	},

	// 只调用一次
	afterRender : function(panel, eOpts) {
		Ext.direct.Manager.on('event', this.onDirectEvent, this);
	},

	onDirectEvent : function(event, provider, eOpts) {
		// 编码器修改，刷新资源列表
		if ((event.action == "actionEncoder") && (event.method == "destroy")) {
			this.getResGrid().store.load();
		}
		// 编码器通道修改，刷新资源列表
		if ((event.action == "actionEncChannel") && (event.method != "read")) {
			this.getResGrid().store.load();
		}
	},

	// 外部接口
	slaverReload : function() {
		this.getEncChannelGrid().loadByMasterId();
	}

});
