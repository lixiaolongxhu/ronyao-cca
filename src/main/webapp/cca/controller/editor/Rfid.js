/**
 * 定位点设置
 */
Ext.define('RYIVS.controller.editor.Rfid', {
	extend : 'Ext.app.Controller',
	models : [ 'editor.Rfid' ],
	views : [ 'editor.Rfid' ],

	refs : [ {
		selector : 'gridEditRfid',
		ref : 'rfidGrid'
	} ],

	init : function() {
		this.control({
			'gridEditRfid' : {
				activate : this.onActivate
			}
		});
		controller.rfid = this;
	},

	refresh: function(){
		this.getRfidGrid().store.load();
	},
	
	// 当标签激活时
	onActivate : function(pa, options) {
		pa.items.items[0].store.load();
	}
});
