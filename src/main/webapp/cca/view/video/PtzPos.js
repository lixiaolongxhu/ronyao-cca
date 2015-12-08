/**
 * author : tqd
 * view:摄像头预置点列表
 */
Ext.define('RYIVS.view.video.PtzPos', {
	requires : ['RYIVS.lib.GridEditBase'],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.ptzPos',
//	title : '摄像头预置点',
	forceFit : true,
	model : 'RYIVS.model.video.PtzPos',
	columns : [ {
		header : 'ID',
		sortable : false,
		dataIndex : 'id'
	}, {
		header : '预置点名称',
		sortable : false,
		dataIndex : 'name',
		editor : {
			
		}
	}, {
		header : '预置点编号',
		sortable : false,
		dataIndex : 'pos'
	}],
	
	initComponent : function() {
		this.callParent(arguments);
		this.query('button[itemId="buttonAdd"]')[0].hide();
	}
});
