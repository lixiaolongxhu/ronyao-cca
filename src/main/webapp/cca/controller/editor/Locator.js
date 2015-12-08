/**
 * 定位器管理
 */
Ext.define('RYIVS.controller.editor.Locator', {
	extend : 'Ext.app.Controller',
	models : [ 'editor.Locator' ],
	views : [ 'editor.Locator' ],
	init : function() {
		this.control({
			'gridEditLocator' : {
				activate : this.onActivate
			}
		});
	},
	
	// 当标签激活时
	onActivate : function(pa, options) {
		pa.store.load();
	}
});
