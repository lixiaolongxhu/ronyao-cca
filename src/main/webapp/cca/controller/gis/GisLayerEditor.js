Ext.define('RYIVS.controller.gis.GisLayerEditor', {
	extend : 'Ext.app.Controller',
	init:function(){
		this.initGisLayers();
		controller.gisLayerEditor = this;
	},
	
	initGisLayers:function(){
		//包含所有layers信息的数组
		var gisLayersInfo;
		Ext.Ajax.request({ 
			url : 'controller/getGeoLayerJson',
			method : 'POST',
			async : false,
			timeout : 2000,
			success : function(response,options) {
				var rtValue = Ext.decode(response.responseText);
				if(rtValue != undefined){
					gisLayersInfo = rtValue['GeoLayers'];
				}
			}
		});
		ronyao.gis.initGisLayers(gisLayersInfo);
	},
	
	reDrawGisLayers:function(){
		var length = ronyao.gis.currentLayers.length;
		for(var i=0;i<length;i++){
			var layer = ronyao.gis.currentLayers[i];
			if(layer){
				ronyao.gis.map.removeLayer(layer);
			}
		}
		this.initGisLayers();
		ronyao.gis.map.zoomToMaxExtent();
	}
});