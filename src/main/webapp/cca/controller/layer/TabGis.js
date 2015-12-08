Ext.define('RYIVS.controller.layer.TabGis', {
	extend : 'Ext.app.Controller',
	views : [ 'layer.TabGis', 'video.VideoPanel', 'gis.GisView', 'video.GisVideoPanel' ],
	models : ['video.PtzPos'],
	stores : ['video.PtzPos'],

	refs : [/* {
		// 引用 videopanel
		selector : 'tabgis > videoPanel',
		ref : 'gisVideoPanel'
	}, */{
		selector : 'gisVideo',
		ref : 'gisVideoPanel'
	} ],

	init : function() {
		this.control({
			'tabgis' : {
				activate : this.onActivate,
				deactivate : this.onDeactivate
			},
			'tabgis > videoPanel' : {
				show : this.onShow,
				hide : this.onHide
			}
		});

		// 注册到全局的变量，方便其他模块引用
		controller.gisVideo = this;
	},

	onShow : function(pa, options) {
		// 初始化播放器, 设置插件的播放模式
		this.getGisVideoPanel().initPlayer(1, 2, 4);
		//注册状态回调函数
		this.getGisVideoPanel().regPlayerStateCallback(this.onSelectedVideoWin);
	},
	
	/**
	 * 动态加载预置点
	 * @param {} state 状态回调函数
	 * @param {} parm
	 */
	onSelectedVideoWin : function(state, parm) {
		var das = Ext.JSON.decode(parm);
		var ptzPosObj = Ext.ComponentQuery.query('gisVideo combo')[0];
		if(state == 2) {//切换播放窗口
			ptzPosObj.resid = das.resid;
			ptzPosObj.store.proxy.setExtraParam("resid",das.resid);
			ptzPosObj.store.load();
		}else if(state == 3) {//停止播放
			ptzPosObj.store.removeAll();
		}
		ptzPosObj.clearValue();
	},

	onHide : function(pa, options) {
		// 隐藏的时候，关闭所有的播放
		this.getGisVideoPanel().closeRealVideo();
	},

	// 该面板激活的时候
	onActivate : function(pa, options) {
		this.getGisVideoPanel().hide();
	},

	// 该面板失去激活的时候
	onDeactivate : function(pa, options) {
		this.getGisVideoPanel().hide();
	},

	// 当GIS上一个资源被选择的回调
	onResourceSelect : function(resid, type) {
		// 根据资源类型进行相应的操作
		switch (type) {
		case 1:
			// 是视频资源
			controller.gisVideo.playVideo(resid);
			break;
		default:
			// 其他类型的资源
		}
	},

	playVideo : function(resid) {
//		debugger;
		var panel = this.getGisVideoPanel();
		// 如果没有显示，首先显示
		if (panel.isHidden()) {
			panel.show();
		}
		
		var ptzPosObj = Ext.ComponentQuery.query('gisVideo combo')[0];
		ptzPosObj.resid = resid;
		ptzPosObj.store.proxy.setExtraParam("resid",resid);
		ptzPosObj.store.load();
		ptzPosObj.clearValue();

		panel.playRealVideo(resid);
	}

});
