/*
 * 用于用户察看GIS的通用窗口
 * 可以用于察看
 * 可以用于编辑
 * 由相应Controller控制其行为  
 */


Ext.define('RYIVS.view.gis.GisView', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.gisView',

	
	//加载GIS现实
	afterLayout : function() {
		this.callParent();
		ronyao.gis.initGis(this.body.dom.id);
	},	
	
	onResize: function(){
		ronyao.gis.initGis(this.body.dom.id);
	},
	
	initComponent : function() {
		this.callParent(arguments);
		this.on('resize', this.onResize, this);
	}
});
