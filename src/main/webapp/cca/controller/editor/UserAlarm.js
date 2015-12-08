Ext.define('RYIVS.controller.editor.UserAlarm', {
	extend : 'Ext.app.Controller',
	models : [ 'editor.UserAlarm' ],
	views : [ 'editor.UserAlarm' ],
	stores : ['common.UserSelect'], 
	init : function() {
		this.control({
			'gridEditUserAlarm' : {
				activate : this.onActivate
			},
			'gridEditUserAlarm combo' : {
				expand : this.onExpand
			}
		});
	},
	
	// 当标签激活时
	onActivate : function(pa, options) {
		pa.items.items[0].store.load();
		Ext.getStore('common.UserSelect').load();
	},
	onExpand : function(){
		
	}
	
});