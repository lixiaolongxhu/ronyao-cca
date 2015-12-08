/**
 * 传统浏览界面
 */
Ext.define('RYIVS.controller.layer.TabVideo', {
	extend : 'Ext.app.Controller',
	views : [ 'layer.TabVideo', 'video.VideoPanel', 'common.ResGrid', 'common.UserResPanel', 'common.Alarms', 'video.PtzPosList' ],
	stores : [ 'common.Alarms' ],
	models : [ 'common.ResGrid', 'common.Alarms', 'video.PtzPos' ],

	refs : [ {
		selector : 'userResPanel resGrid',
		ref : 'resGrid'
	}, {
		selector : 'userResPanel > airconctl',
		ref : 'airCtl'
	}, {
		selector : 'userResPanel > controlSwitch',
		ref : 'switchCtl'
	}, {
		selector : 'userResPanel > tempctl',
		ref : 'tempCtl'
	}, {
		selector : 'userResPanel > ptzPosList',
		ref : 'ptzPosList'
	}, {
		selector : 'userResPanel > airVel',
		ref : 'airVel'
	}, {
		selector : 'userResPanel > oxSensor',
		ref : 'oxSensor'
	}, {
		selector : 'userResPanel > SF6Vel',
		ref : 'SF6Vel'
	}, {
		selector : 'userResPanel',
		ref : 'resPanel'
	}, {
		// 引用 videopanel
		selector : 'tabVideo videoPanel',
		ref : 'videoPanel'
	}, {
		selector : 'tabVideo',
		ref : 'tvideo'
	} ],

	init : function() {
		this.control({
			'tabVideo' : {
				activate : this.onActivate,
				deactivate : this.onDeactivate,
				afterrender : this.afterRender
			},
			'userResPanel resGrid' : {
				itemdblclick : this.itemdblClick
			}
		});
		controller.tabVideo = this;
	},

	// 只调用一次
	afterRender : function(panel, eOpts) {
		this.getResGrid().enableDelete(false);
		this.getResGrid().enableDrag(false);
	},

	// 该面板激活的时候
	onActivate : function(pa, options) {
		// 显示UserResPanel
		this.getResPanel().show();
		// 设置播放模式
		var currentCount = localStorage.getItem('winCount');
		var winCount = currentCount!='undefined'?currentCount:2;
		this.getVideoPanel().initPlayer(1, 3, winCount);
		this.getVideoPanel().regPlayerStateCallback(this.onSelectedVideoWin);
	},
	//单击播放窗口，显示预置点
	onSelectedVideoWin : function(state, parm) {
		var das = Ext.JSON.decode(parm);
		var ptzPosList = controller.tabVideo.getPtzPosList();
		if(state == 2) {//切换播放窗口
			var resName = controller.viewResGrid.getResStore().data.getByKey(das.resid).data.name;
			ptzPosList.setTitle(resName + ":预置点列表");
			ptzPosList.store.proxy.setExtraParam("resid",das.resid);	
			ptzPosList.store.load();
			if(!controller.tabVideo.isHide){
				controller.tabVideo.onHide();//隐藏控制面板
				controller.tabVideo.isHide = true;	
			}
			ptzPosList.show();
		}else if(state == 3) {//停止播放
			ptzPosList.hide();
		}
	},
	// 该面板失去激活的时候
	onDeactivate : function(pa, options) {
		// 隐藏UserResPanel
		this.getResPanel().hide();
		// 隐藏控制面板
		this.onHide();

		// 关闭播放
		this.getVideoPanel().closeRealVideo();
	},
	
	isHide : false,
	
	// 隐藏控制设备
	onHide : function() {
		var ctlPanels = Ext.ComponentQuery.query('userResPanel > panel[displayed = true]');
		for ( var i = 0; i < ctlPanels.length; i++) {
			ctlPanels[i].hide();
		}
	},

	// 资源双击事件
	itemdblClick : function(view, record, item, index, e, eOpts) {
		this.onHide();//隐藏控制面板
		this.isHide = true;
		var value = this.getTvideo().isVisible();
		
		if (value) {
			// 根据 restype 转换成 resCat
			var cat = Ext.getStore('common.ResourceTypeCat').data.getByKey(record.data.type).data.cat;
			
			switch (cat) {
				case 2:// 风速传感器
					var airVel = this.getAirVel();
					airVel.resid = record.data.id;
					airVel.displayed = true;
					airVel.show();
					this.isHide = false;
					break;
				case 3:// 温湿度传感
					var tempPanle = this.getTempCtl();
					tempPanle.resid = record.data.id;
					tempPanle.displayed = true;
					tempPanle.show();
					this.isHide = false;
					break;
				case 4:// SF6传感器
					var SF6Vel = this.getSF6Vel();
					SF6Vel.resid = record.data.id;
					SF6Vel.displayed = true;
					SF6Vel.show();
					this.isHide = false;
					break;
				case 5:// 氧气传感器
					var oxSensor = this.getOxSensor();
					oxSensor.resid = record.data.id;
					oxSensor.displayed = true;
					oxSensor.show();
					this.isHide = false;
					break;
				case 11://开关控制
					var switchPanle = this.getSwitchCtl();
					switchPanle.resid = record.data.id;
					switchPanle.displayed = true;
					
					if(3 == appCfg.utype) {
						switchPanle.query('button[fnc=2]')[0].setDisabled(true);
						switchPanle.query('button[fnc=3]')[0].setDisabled(true);
					}
					switchPanle.show();
					this.isHide = false;
					break;
				case 12:// 空调控制
					var airconPanel = this.getAirCtl();
					airconPanel.resid = record.data.id;
					airconPanel.displayed = true;
					
					if(3 == appCfg.utype) {
						airconPanel.query('button[fnc=4]')[0].setDisabled(true);
						airconPanel.query('button[fnc=3]')[0].setDisabled(true);
					}
					airconPanel.show();
					this.isHide = false;
					break;
				case 21:// 摄像机
					// 根据资源的类型来进行查找
					this.getVideoPanel().playRealVideo(record.data.id);
					//显示该摄像机对应的预置点列表
					var ptzPosListName = record.data.name+":预置点列表";
					var ptzPosList = this.getPtzPosList();
					ptzPosList.setTitle(ptzPosListName);
					ptzPosList.store.proxy.setExtraParam("resid",record.data.id)
					ptzPosList.show();
					ptzPosList.displayed = true;
					ptzPosList.store.load();
					this.isHide = false;
					break;
			}
			
		}
	}
});
