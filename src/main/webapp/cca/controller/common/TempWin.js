//温湿度曲线
Ext.define('RYIVS.controller.common.TempWin', {
	extend : 'Ext.app.Controller',
	models : ['common.TempWin'],
	stores : ['common.TempWin'],
	views : ['common.TempWin'],

	init : function() {
		this.control({
			//日期选择
			'tempwin datefield' : {
				change : this.onDateChange
			},
			'tempwin' : {
				onShow : this.onShow
			},
			'tempwin button[fun=1]' : {
				click : this.onLastDay
			},
			'tempwin button[fun=2]' : {
				click : this.nextDay
			}
		});

		this.getCommonTempWinStore().on('load', this.onLoad);
	},
	onLoad : function(store, records, successful, operation, options) {
		
	},
	
	onLastDay : function() {
		var datefield = Ext.ComponentQuery.query('tempwin datefield')[0];
		var lastDay = new Date(datefield.getValue().getTime() - 3600*24);
		datefield.setValue(lastDay);
	},
	
	nextDay : function() {
		var datefield = Ext.ComponentQuery.query('tempwin datefield')[0];
		var currentDay = datefield.getValue();
		var nowDay = new Date();
		
		var reg = /^\w+\s\w+\s\d{1,2}\s\d{4}/;
		var s_nowDay = reg.exec(nowDay+"")[0];
		var s_currentDay = reg.exec(currentDay+"")[0];
		if(s_nowDay==s_currentDay) {
			Ext.Msg.alert('系统提示', '已到最后一天记录！');
			return false;
		}
		var nextDay = new Date(currentDay.getTime() + 3600*1000*24);
		datefield.setValue(nextDay);
	},
	
	//日期变更后的查询
	onDateChange : function() {
		var pa = Ext.ComponentQuery.query('tempwin')[0];
		this.getCommonTempWinStore().load({
			params : {
				resid : pa.resid,
				day : pa.down('datefield').getValue().getTime()/1000
			}
		});
	},
	onShow : function(pa) {
		this.getCommonTempWinStore().load({
			params : {
				resid : pa.resid,
				day : pa.down('datefield').getValue().getTime()/1000
			}
		});
	}
});
