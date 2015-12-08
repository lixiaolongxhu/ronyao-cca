/**
 * author : tqd
 * view:摄像头预置点列表
 */
Ext.define('RYIVS.view.video.PtzPosList', {
	requires : ['RYIVS.lib.GridEditBase'],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.ptzPosList',
	title : '预置点列表',
	forceFit : true,
	model : 'RYIVS.model.video.PtzPos',
	columns : [ {
		header : 'ID',
		sortable : false,
		dataIndex : 'id',
		hidden : true
	}, {
		header : '资源ID',
		sortable : false,
		dataIndex : 'resid',
		hidden : true
	}, {
		header : '预置点编号',
		sortable : false,
		dataIndex : 'pos'
	}, {
		header : '预置点名称',
		sortable : false,
		dataIndex : 'name'
	}],
	
	plugins : [],
	
	initComponent : function() {
		this.callParent(arguments);
		this.plugins = null;//注销plugins
		this.query('button[itemId="buttonAdd"]')[0].hide();
		this.query('button[itemId="buttonDelete"]')[0].hide();
	}
});
