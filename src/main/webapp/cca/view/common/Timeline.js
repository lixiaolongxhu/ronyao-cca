//播放器的对象
Ext.define('RYIVS.view.common.Timeline', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.timeline',
	bodyCls : 'timeline-background',

	height : 150,

	// 重载方法
	afterRender : function() {
		this.callParent();
		var options = {
			width : "100%",
			height : "100%",
			showCurrentTime : false,
			showCustomTime : false,
			style : "dot",
			intervalMax : 3600 * 24 * 1000,
			intervalMin : 3600 * 1000
		};

		this.timeline = new links.Timeline(this.body.dom);
		this.timeline.draw(null, options);

	},

	// 取消所有的选择
	removeSelection : function() {
		this.timeline.setSelection(null);
	},

	// 是否显示播放时的时间
	showTimeBar : function(show) {
		this.timeline.options.showCustomTime = show;
		if (!show) {
			this.timeline.redraw();
		}

	},

	// 设置当前播放时间
	setCustomTime : function(time) {
		this.timeline.setCustomTime(new Date(time * 1000));
	},

	// 得到当前的选择时间数据
	getSelected : function() {
		var eList = this.timeline.getSelection();
		if (eList.length) {
			var index = eList[0].row;
			return this.timeline.data[index];
		} else {
			return null;
		}
	},

	// 改变窗口大小
	afterLayout : function() {
		this.timeline.redraw();
		this.timeline.setSelection([ {
			row : timelineSelectIndex
		} ]);
	},

	initComponent : function() {
		this.callParent(arguments);
		this.on('afterlayout', this.afterLayout, this);
	}
});
