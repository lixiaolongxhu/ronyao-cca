/*
 * 告警和人员跟踪定位事件查询
 * 需要显示的告警内容
 * 1、告警类型
 * 2、告警资源
 * 3、告警时间
 * 4、告警参数
 * 
 * 5、告警处理意见
 * 6、告警处理人
 * 
 * 7、有无告警关联视频?
 */

//暂时没有使用
Ext.define('RYIVS.controller.common.Calendar', {
	extend : 'Ext.app.Controller',
	views : [ 'common.Calendar' ],

	refs : [ {
		selector : 'eventCalendar',
		ref : 'calendar'
	} ],

	init : function() {
		this.control({
			// 界面生成时调用一次
			'eventCalendar' : {
				afterrender : this.afterRender,
				eventclick : this.eventClick,
				eventover : this.eventOver,
				eventout : this.eventOut
			}
		});
	},

	// 只执行一次
	afterRender : function(panel, eOpts) {
	},

	eventClick : function(calendarPanel, rec, el) {
		debugger;

	},

	eventOver : function(calendarPanel, rec, el) {
		console.log('in');
	},

	eventOut : function(calendarPanel, rec, el) {
		console.log('out');
	}

});
