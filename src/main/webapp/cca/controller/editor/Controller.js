/**
 * 定位器管理
 */
Ext.define('RYIVS.controller.editor.Controller', {
	extend : 'Ext.app.Controller',
	models : [ 'editor.Controller', 'editor.CtlChannel', 'common.ResGrid' ],
	views : [ 'editor.Controller', 'common.ResGrid' ],

	refs : [ {
		selector : 'gridEditController > gridEditBase[master="master"]',
		ref : 'ctlChannelGrid'
	}, {
		selector : 'resGrid',
		ref : 'resGrid'
	} ],

	init : function() {
		this.control({
			'gridEditController' : {
				activate : this.onActivate,
				afterrender : this.afterRender
			}
		});
		controller.controller = this;
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
		/*// 编码器修改，刷新资源列表
		if ((event.action == "actionController") && (event.method == "destroy")) {
			this.getResGrid().store.load();
		}
		// 编码器通道修改，刷新资源列表
		if ((event.action == "actionCtlChannel") && (event.method == "destroyEqp")) {
			this.getResGrid().store.load();
		}*/
		
		// 编码器通道修改，刷新资源列表
		if ((event.action == "actionEquipment") && (event.method == "destroyEqpCha")) {
			this.getResGrid().store.load();
		}
		
		if ((event.action == "actionEquipment") && (event.method == "destroyEqp")) {
			this.getResGrid().store.load();
		}
	},

	//外部接口
	slaverReload : function() {
		this.getCtlChannelGrid().loadByMasterId();
	}
});
