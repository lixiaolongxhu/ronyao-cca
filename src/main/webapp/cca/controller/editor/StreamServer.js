/**
 * 流媒体服务器
 */
Ext.define('RYIVS.controller.editor.StreamServer', {
	extend : 'Ext.app.Controller',
	models : [ 'editor.StreamServer' ],
	views : [ 'editor.StreamServer' ],
	init : function() {
		this.control({
			'streamServer' : {
				activate : this.onActivate
			}
		});
	},
	
	// 当标签激活时
	onActivate : function(pa, options) {
		pa.store.load();
	}
});
