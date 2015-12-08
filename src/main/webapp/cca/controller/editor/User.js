/**
 * 用户管理
 */
Ext.define('RYIVS.controller.editor.User', {
	extend : 'Ext.app.Controller',
	models : [ 'editor.User' ],
	views : [ 'editor.User' ],
	init : function() {
		this.control({
			'gridEditUser' : {
				activate : this.onActivate
			}
		});
	},
	
	// 当标签激活时
	onActivate : function(pa, options) {
		pa.items.items[0].store.load();
	}
	
});