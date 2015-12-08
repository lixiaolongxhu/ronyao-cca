/**
 * view : user界面gisVideo
 * author : tqd
 */
Ext.define('RYIVS.view.video.GisVideoPanel', {
	extend : 'RYIVS.view.video.VideoPanel',
	alias : 'widget.gisVideo',
	title : '视频播放',
	closable : true,
	closeAction : 'hide',
	region : 'west',
	width : 300,
	hidden : true,
	tbar : [{
		xtype : 'combo',
		fieldLabel: '预置点调用',
		labelWidth : 70,
		emptyText : '请选择预置点',
		editable : false,
		allowBlank : false,
	    store: 'video.PtzPos',
	    queryMode: 'local',
	    displayField: 'name',
	    valueField: 'pos'
	}]
});