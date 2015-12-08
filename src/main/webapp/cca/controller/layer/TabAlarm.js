/*
 * 历史数据界面
 */
Ext.define('RYIVS.controller.layer.TabAlarm', {
	extend : 'Ext.app.Controller',
	views : [ 'video.VideoPanel', 'common.Timeline', 'layer.TabAlarm', 'common.ResGrid', 'common.UserResPanel' ],
	stores : [ 'common.EventAndVideo','common.EventAndAlarmNote' ],
	models : [ 'common.EventAndVideo', 'common.ResGrid' ,'common.EventAndAlarmNote'],

	refs : [ {
		// 引用 videopanel
		selector : 'tabAlarm videoPanel',
		ref : 'videoPanel'
	}, {
		selector : 'tabAlarm',
		ref : 'tabAlarm'
	}, {
		selector : 'userResPanel',
		ref : 'resPanel'
	}, {
		selector : 'userResPanel resGrid',
		ref : 'resGrid'
	}, {
		selector : 'userResPanel datepicker',
		ref : 'datePicker'
	}, {
		selector : 'tabAlarm timeline',
		ref : 'timeline'
	}],

	init : function() {
		this.control({

			'tabAlarm' : {
				activate : this.onTabActivate,
				deactivate : this.onTabDeactivate,
				afterrender : this.onTabAfterRender
			},

			// 视频播放器
			'tabAlarm #videoPlayer' : {
				activate : this.onVideoActivate,
				deactivate : this.onVideoDeactivate
			},

			'userResPanel resGrid' : {
				itemclick : this.itemClick
			},

			'userResPanel datepicker' : {
				select : this.onDateSelect
			}
		});

		controller.tabHistory = this;
	},
	
	
	onTabActivate : function(panel, eOpts) {
		// 显示UserResPanel
		this.getResPanel().show();
		this.getDatePicker().show();

		// 设置播放模式
		this.onVideoActivate();
		
		//timeline重绘
		this.getTimeline().timeline.redraw();
		timelineSelectIndex = null;
		logMessage("tabalarm", 0, "index：" +  timelineSelectIndex);
	},

	onTabDeactivate : function(panel, eOpts) {
		// 隐藏UserResPanel
		this.getResPanel().hide();
		this.getDatePicker().hide();

		// 关闭播放
		this.onVideoDeactivate();
	},

	// 只调用一次
	onTabAfterRender : function(panel, eOpts) {
		// 选择一个事件的事件
		links.events.addListener(this.getTimeline().timeline, 'select', this.onEventSelect);
		// 托动时间条开始的事件
		links.events.addListener(this.getTimeline().timeline, 'timechange', this.onSeekStart);
		// 托动时间条完成的事件
		links.events.addListener(this.getTimeline().timeline, 'timechanged', this.onSeekEnd);

		// 设置资源的表现形式
		this.getResGrid().enableDelete(false);
		this.getResGrid().enableDrag(false);
	},

	updateCustomTime : true,
	
	seekFinished : true,

	// 开始拖动
	onSeekStart : function(time) {
		controller.tabHistory.updateCustomTime = false;

	},

	// 拖动完成
	onSeekEnd : function(time) {
		var event = controller.tabHistory.getTimeline().getSelected();

		controller.tabHistory.updateCustomTime = true;
		if (event) {
			if ((time.time > event.start) && (time.time < event.end))
				if(controller.tabHistory.seekFinished) {
					controller.tabHistory.seekFinished = false;
					var rst = -1;
					rst = controller.tabHistory.getVideoPanel().seekVodVideo(Date.parse(time.time) / 1000);
					if((-1 != rst)&&(0 != rst)&&(5 != rst)){
						controller.tabHistory.getTimeline().removeSelection();
						controller.tabHistory.seekFinished = true;
						logMessage("seekVideo", 0, "不是-1，不是0，不是5");
					} else if(5 == rst) {
						controller.tabHistory.seekFinished = true;
					}
				} else {
					logMessage("seekVideo", 0, "回调返回失败！");
				}	
				
		}

	},
	


	// 在Timeline上选择一个事件
	onEventSelect : function() {
		if(!controller.tabHistory.seekFinished){
			logMessage("selectVideo1", 0, "播放错误，返回！");
			controller.tabHistory.getTimeline().removeSelection();
			controller.tabHistory.getTimeline().timeline.setSelection([ {
			row : timelineSelectIndex
		} ]);
			return;
		}
		if (!controller.tabHistory.getTimeline().timeline.getSelection().length) {
			return;
		}

		var index = controller.tabHistory.getTimeline().timeline.getSelection()[0].row;
		var selectedItem = controller.tabHistory.getTimeline().timeline.data[index];

		switch (selectedItem.dtype) {
		case 1: // 告警
			var alarmid = selectedItem.alarmid;
			if(!alarmid){
				return;
			}
			controller.tabHistory.searchAlarmNote(alarmid);
			break;
		case 2: // 定位
			break;
		case 3: // 视频
			if(controller.tabHistory.seekFinished) {
				controller.tabHistory.seekFinished = false;
				var rst = -1;
				rst = controller.tabHistory.getVideoPanel().playVodVideo(selectedItem.resid, Date.parse(selectedItem.start) / 1000, Date.parse(selectedItem.end) / 1000);
				if(-1 != rst){
					controller.tabHistory.seekFinished = true;
				}
				if (!rst) {
					// 播放成功
					logMessage("selectVideo3", 0, "历史回放：" + rst);
					controller.tabHistory.getTimeline().showTimeBar(true);
					controller.tabHistory.getTimeline().setCustomTime(Date.parse(selectedItem.start) / 1000);
					timelineSelectIndex = index;
				} else if(5 == rst) {//保持原来状态
					controller.tabHistory.getTimeline().removeSelection();
					controller.tabHistory.getTimeline().timeline.setSelection([ {
					row : timelineSelectIndex
					} ]);
				} else {
					// 播放失败
					controller.tabHistory.getTimeline().removeSelection();
					logMessage("selectVideo4", 0, "历史回放：" + rst);
				}
			}

			break;
		}
	},
	
	// 查询报警意见
	searchAlarmNote : function(almid) {
		var store = this.getStore('common.EventAndAlarmNote');
		store.proxy.extraParams.alarmid = almid;
		store.load({
			scope : this,
			callback : this.afterAlarmNoteLoad
				
		});
		//this.getResPanel().setLoading(true);
		
	},
	
	//查询报警意见callback
	afterAlarmNoteLoad : function(records,success) {
		console.log(records);
		var alarmnote = "";
		var username = "";
		var dtime = "";
		for(var i = 0;i < records[0].raw.length;i++) {
			switch(records[0].raw[i].type) {
			case 1:
				alarmnote = records[0].raw[i].events[0].notes;
				var date = new Date((records[0].raw[i].events[0].time) * 1000);
				dtime = Ext.Date.format(date, 'Y-m-d G:i:s');
				break;
			case 2:
			    username = records[0].raw[i].events[0].rname;
			    break;
			 default:
			 	break;
			}
			
		}
		var form = Ext.create('Ext.form.Panel', {
        border: false,
        fieldDefaults: {
            labelWidth: 55
        },
        defaultType: 'textfield',
        bodyPadding: 5,

        items: [{
            fieldLabel: '处理人',
            name: 'user',
            value:username,
            readOnly:true,
            anchor:'100%'  // anchor width by percentage
        },{
            fieldLabel: '处理时间',
            name: 'dealtime',
            value:dtime,
            readOnly:true,
            anchor:'100%'  // anchor width by percentage
        },{
            xtype: 'textarea',
            //hideLabel: true,
            fieldLabel: '处理意见',
            labelAlign: 'top',
            name: 'msg',
            readOnly:true,
            value:alarmnote,
            anchor: '100% -47'  // anchor width by percentage and height by raw adjustment
        }]
    });

    var win = Ext.create('Ext.window.Window', {
        title: '报警处理意见',
        width: 500,
        height:300,
        minWidth: 300,
        minHeight: 200,
        layout: 'fit',
        plain: true,
        items: form,
        buttons: [{
            text: '确定',
            handler: function() {      
            	this.up('window').hide();
          }
        }]
    });

    win.show();
		
	},

	// 查询视频
	searchEvent : function() {
		//停止所有播放
		this.getVideoPanel().closeVodVideo();
		
		// 确定初始值
		if (!this.selectResource) {
			return;
		}

		if (!this.selectDay) {
			var currentDate = this.getDatePicker().getValue();
			this.selectDay = Date.parse(currentDate) / 1000;
		}

		// 查询
		var store = this.getStore('common.EventAndVideo');
		
		store.proxy.extraParams.resid = this.selectResource.id;
		store.proxy.extraParams.stime = this.selectDay;
		store.proxy.extraParams.etime = this.selectDay + 86400;
		store.proxy.extraParams.type = this.selectResource.type;

		store.load({
			scope : this,
			callback : this.afetVideoLoad
		});
		this.getResPanel().setLoading(true);

	},

	// 视频播放列表
	eventList : null,

	// 从返回中处理视频事件
	getVideoEvents : function(records) {
		// 返回的事件列表
		var result = new Array();
		var eventItem;
		for ( var i = 0; i < records.length; i++) {

			// 是否是第一个记录
			if (i == 0) {
				eventItem = new Object();
				eventItem.dtype = 3;
				eventItem.start = new Date(records[i].stime * 1000);
				eventItem.end = new Date(records[i].etime * 1000);

				// 是第一个记录，又是最后一个记录
				if (i == records.length - 1) {
					eventItem.content = ' ';
					eventItem.resid = records[i].resid;

					result.push(eventItem);
				}
				continue;
			}

			// 不是第一个数据
			// 判断时间是否连续。判断条件，时间相差不大于1秒
			if (Math.abs(Date.parse(eventItem.end) - records[i].stime * 1000) < 2000) {
				// 和上个数据是连续的，只改变结束时间
				eventItem.end = new Date(records[i].etime * 1000);
			} else {
				// 时间上不连续

				// 首先添加到数组

				eventItem.content = ' ';
				eventItem.resid = records[i].resid;
				result.push(eventItem);

				// 开始一个新的时间段
				eventItem = new Object();
				eventItem.dtype = 3;
				eventItem.start = new Date(records[i].stime * 1000);
				eventItem.end = new Date(records[i].etime * 1000);
			}

			// 判断是不是最后一个记录
			if (i == records.length - 1) {
				eventItem.content = ' ';
				eventItem.resid = records[i].resid;
				result.push(eventItem);
			}
		}

		// 对第一个记录和最后一个记录进行切取，以便满足所选定的时间
		if (result.length) {
			if (Date.parse(result[0].start) / 1000 < this.selectDay -3600) {
				result[0].start = new Date((this.selectDay - 3600) * 1000)
			}

			if (Date.parse(result[result.length - 1].end) / 1000 > this.selectDay + 86400 + 3600) {
				result[result.length - 1].end = new Date((this.selectDay + 86400 + 3600) * 1000)
			}
		}

		return result;
	},

	// 从返回中处理告警事件
	getAlarmEvents : function(records) {

		var result = new Array();
		var eventItem;

		for ( var i = 0; i < records.length; i++) {
			eventItem = new Object();
			eventItem.start = new Date(records[i].time * 1000);
			eventItem.resid = records[i].resid;
			//eventItem.dtype = records[i].type;
			eventItem.alarmid = records[i].id;
			eventItem.dtype = 1;
			if((records[i].type == 3) || (records[i].type == 5) || (records[i].type == 7))
			{
				var suffix = '℃';
				eventItem.content = '报警类型：' + ry.constant.trans(records[i].type,ry.constant.almtype) + ' 参数：' + records[i].parm + suffix;
			}
			else if((records[i].type == 4) || (records[i].type == 6) || (records[i].type == 8))
			{
				var suffix = '%RH';
				eventItem.content = '报警类型：' + ry.constant.trans(records[i].type,ry.constant.almtype) + ' 参数：' + records[i].parm + suffix;
			}
			else
			{
				eventItem.content = '报警类型：' + ry.constant.trans(records[i].type,ry.constant.almtype);
			}	

			/*if (records[i].vuser) {
				var date = new Date((records[i].vtime) * 1000);
				var s_date = Ext.Date.format(date, 'Y-m-d G:i:s');
				eventItem.content += '；处理人：' + records[i].vuser + '；处理时间：' + s_date + '；处理意见：' + records[i].vnote;
			}*/

			result.push(eventItem);
		}

		return result;
	},

	// 从返回中处理定位事件
	getLocatorEvents : function(records) {

		var result = new Array();
		var eventItem;

		for ( var i = 0; i < records.length; i++) {
			eventItem = new Object();
			eventItem.start = new Date(records[i].stime * 1000);
			eventItem.resid = records[i].rfid;
			eventItem.dtype = 2;
			eventItem.content = '定位';
			result.push(eventItem);
		}
		return result;
	},

	// 查询后的结果，对Timeline进行填充
	afetVideoLoad : function(records, operation, success) {
		if (!success) {
			this.getResPanel().setLoading(false);
			return;
		}

		// 得到事件列表
		var recordList = records[0].raw;

		// 类变量
		this.eventList = new Array();

		for ( var i = 0; i < recordList.length; i++) {
			var event = recordList[i];
			switch (event.type) {
			case 1: // 告警
				this.eventList = this.eventList.concat(this.getAlarmEvents(event.events));
				break;
			case 2: // 定位
				this.eventList = this.eventList.concat(this.getLocatorEvents(event.events));
				break;
			case 3: // 视频
				this.eventList = this.eventList.concat(this.getVideoEvents(event.events));
				break;
			}
		}

		/*
		 * { start : 0, end : 0, content : 0, group : 0, resource: 0, type:0}
		 */

		// 显示timeline
		var options = {
			width : "100%",
			height : "100%",
			showCurrentTime : false,
			showCustomTime : false,
			style : "box",
			intervalMax : 3600 * 24 * 1000,
			intervalMin : 20000,
			min : new Date((this.selectDay -3600) * 1000),
			max : new Date((this.selectDay + 86400 + 3600) * 1000)
		};

		this.getTimeline().timeline.draw(this.eventList, options);
		this.getTimeline().timeline.setAutoScale(true);
		this.getTimeline().timeline.setSelection([ {
			row : 0
		} ]);
		this.getTimeline().timeline.setSelection([]);
		this.getTimeline().timeline.setVisibleChartRangeAuto();
		//重新选择摄像机，timeline记录的index清空
		timelineSelectIndex = null;
		
		this.getResPanel().setLoading(false);
	},

	// 该面板激活的时候
	onVideoActivate : function(pa, options) {
		// 设置播放模式
		this.getVideoPanel().initPlayer(2, 3, 0);
		// 设置回调
		this.getVideoPanel().regPlayerTimeCallback(this.onVodTime);
		this.getVideoPanel().regPlayerStateCallback(this.onVodState);
	},

	onVodTime : function(time) {
		if (!controller.tabHistory.updateCustomTime) {
			return;
		}
		controller.tabHistory.getTimeline().setCustomTime(time);
		controller.tabHistory.seekFinished = true;
		//logMessage("VideoPanel", 0, "回调时间：" + Date.parse(new Date(time * 1000)));
	},

	onVodState : function(state, parm) {
		var msg = Ext.JSON.decode(parm);
		logMessage("Player", 0, "播放事件类型：" + state);
		switch (state) {
		case 1: // 所有窗口关闭
			break;
		case 2: // 当前焦点参数
			break;
		case 3: // 某个窗口播放停止或者是错误
			logMessage("Player", 0, "播放事件参数：" + msg.state);
			controller.tabHistory.getTimeline().removeSelection();
			controller.tabHistory.getTimeline().showTimeBar(false);
			break;
		}
	},

	// 该面板失去激活的时候
	onVideoDeactivate : function(pa, options) {
		// 关闭播放
		this.getVideoPanel().closeVodVideo();
	},

	// 当前选择的资源
	selectResource : null,
	// 当前选择的日期
	selectDay : 0,

	// 资源单击事件
	itemClick : function(view, record, item, index, e, eOpts) {
		
		var value = this.getTabAlarm().isVisible();
		if (value) {
			this.selectResource = record.data;
			this.searchEvent();
		}
	},

	// 日期选择
	onDateSelect : function(datePicker, date, eOpts) {
		// 得到选择日期的Timestamp
		this.selectDay = Date.parse(date) / 1000;
		this.searchEvent();
	}

});
