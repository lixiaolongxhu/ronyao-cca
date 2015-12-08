Ext.define('RYIVS.controller.gis.GisLayerList', {
	extend : 'Ext.app.Controller',
	models : ['gis.GisLayerList'],
	stores : ['gis.GisLayerList'],
	views : [ 'gis.GisLayerList'],
	init : function(){
		this.control({
			'gisLayerList':{
				afterrender:this.onAfterrender
			}
		});
	},
	
	onAfterrender:function(){
		var store = this.getGisGisLayerListStore();
		store.load();
	}
});