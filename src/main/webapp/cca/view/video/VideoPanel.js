//通用视频面板
Ext.define('RYIVS.view.video.VideoPanel', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.videoPanel',
	// title : '视频预览模式',
	html : '<embed type="ry-ivs-media-player" width=100% height=100% />',

	// 播放器的实例
	player : null,

	// 接口部分-------------------------------------

	/*
	 * 初始化播放器 mode = 1 实时，2 历史; layer= 1 横向,2 纵向,3、宫格; windows 窗口数量
	 */
	// layer, windows 可选缺省为宫格，一个窗口。
	initPlayer : function(mode, layer, windows) {

		if (this.body == undefined) {
			this.player = null;
		}

		this.player = this.body.dom.getElementsByTagName("embed")[0];

		if (this.player == null) {
			return;
		}

		var myLayer;
		var myWindows;

		if (layer == undefined) {
			myLayer = 3;
		} else {
			myLayer = layer;
		}

		if (windows == undefined) {
			myWindows = 0;
		} else {
			myWindows = windows;
		}

		var config = {
			mod : mode,
			layout : myLayer,
			windows : myWindows,
			max : 2,
			uid : 5,
			imgPath : localStorage.getItem('RYIVS.imagePath'),
			videoPath : localStorage.getItem('RYIVS.videoPath')
		}

		// 插件初始化
		this.player.Plugin_Interface(1, Ext.JSON.encode(config));

		// 注册事件
		this.player.ResgisterFunction(this._onPtzCtl, 1);// 云镜控制回调
		
		controller.videoPanel = this;
		
		var ss = window.location.host;
		var pos = ss.indexOf(":");
		var ss_ip = ss.substr(0,pos);
		appCfg.ss_ip = ss_ip;
		
	},

	//设置存储路径
	
	setPath : function(imgPath,videoPath) {
		var config = {
			imgPath : imgPath,
			videoPath : videoPath
		}
		var rst;

		try {
			rst = Ext.JSON.decode(this.player.Plugin_Interface(5, Ext.JSON.encode(config))).rst;
		} catch (err) {
			rst = 101; // 内部错误
		}

		logMessage("Player", 0, "设置存储路径：" + rst);
	},
	
	// 实时播放接口
	playRealVideo : function(resid) {
		freezeUI(true);
		var config = {
			id : 0,
			ip : appCfg.ss_ip,
			port : appCfg.ss_port,
			resid : resid.toString(),
			ms : 0
		}

		var rst;

		try {
			rst = Ext.JSON.decode(this.player.Plugin_Interface(11, Ext.JSON.encode(config))).rst;
		} catch (err) {
			rst = 101; // 内部错误
		}

		logMessage("Player", 0, "实时播放返回：" + rst);
		freezeUI(false);

		return rst;
	},

	// 历史播放接口
	playVodVideo : function(resid, stime, etime) {
		freezeUI(true);
		var config = {
			id : 0,
			resid : resid.toString(),
			type : 0,
			start : stime,
			end : etime,
			ip : appCfg.ss_ip,
			port : appCfg.ss_port
		}

		var rst;

		try {
			rst = Ext.JSON.decode(this.player.Plugin_Interface(21, Ext.JSON.encode(config))).rst;
		} catch (err) {
			rst = 101; // 内部错误
		}

		logMessage("Player", 0, "历史播放返回：" + rst);
		freezeUI(false);
		return rst;
	},

	// 历史播放跳转
	seekVodVideo : function(time) {
		freezeUI(true);
		var config = {
			stime : time
		}
		var rst = Ext.JSON.decode(this.player.Plugin_Interface(23, Ext.JSON.encode(config))).rst;
		logMessage("Player", 0, "拖动时间：" + time);
		logMessage("Player", 0, "历史跳转返回：" + rst);
		freezeUI(false);
		return rst;
	},

	// 关闭实时播放接口
	closeRealVideo : function() {
		var config = {};
		try {
			this.player.Plugin_Interface(12, Ext.JSON.encode(config));
		} catch (err) {
			// 在此处理错误
		}

	},

	// 关闭历史播放接口
	closeVodVideo : function() {
		var config = {};

		try {
			this.player.Plugin_Interface(22, Ext.JSON.encode(config));
		} catch (err) {
			// 在此处理错误
		}

	},

	// 插件控制通用接口
	pluginCtl : function(cmd, param) {
		this.player.Plugin_Interface(cmd, param);
	},

	// 选择目录接口
	selectFolder : function() {
		return this.player.SelectFolder();
	},

	// 事件部分--------------------------------------------------
	// 以下事件为内部使用，在插件初始化部分对外公布了事件

	// 云镜控制回调函数
	_onPtzCtl : function(cmd, resid, parm) {

		logMessage("player", 0, cmd + ':' + resid + ':' + parm);

		var parm = {
			cmd : 103,
			parm : {
				resid : resid.toString(),
				action : cmd,
				value : parm
			}
		};
		// 向服务器发送PTZ控制
		Ext.Ajax.request({
			url : '/srv/ptz',
			params : {
				action : Ext.JSON.encode(parm),
				urank : appCfg.urank,
				uid : appCfg.uid
			},
			timeout : 500,
			success : function(response) {
				var resText = Ext.decode(response.responseText),
					res = resText.res;
				if(res == 1) {
					Ext.Msg.alert("系统提示", "权限不足,暂时不能控制！");
				}
			}
		});
	},
	
	// 状态切换回调
	regPlayerStateCallback : function(fun) {
		this.player.ResgisterFunction(fun, 2);
	},

	// 播放器的时间回调
	regPlayerTimeCallback : function(fun) {
		this.player.ResgisterFunction(fun, 3);
	},

	// 对象初始化---------------------------
	initComponent : function() {
		this.callParent(arguments);
	}
});
