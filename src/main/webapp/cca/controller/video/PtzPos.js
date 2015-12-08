/**
 * author:tqd
 * controller:预置点管理
 */
Ext.define('RYIVS.controller.video.PtzPos', {
	extend : 'Ext.app.Controller',
	views : ['video.PtzPos'],
	models : ['video.PtzPos'],

	init : function() {
		this.control({
			'ptzPos' : {
				itemclick : this.onItemclick
			}
		});
	},
	
	onItemclick : function(grid, record, item, index, e, eOpts){
		var posName = Ext.ComponentQuery.query('textfield[name=posName]')[0];
			pos = Ext.ComponentQuery.query('textfield[name=pos]')[0];
			
		posName.setValue(record.data.name);
		pos.setValue(record.data.pos);
	}
});
