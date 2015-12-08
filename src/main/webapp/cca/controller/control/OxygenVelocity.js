/**
 * controller : 氧气传感控制面板
 * author : tqd
 * date : 2013-4-9
 */
Ext.define('RYIVS.controller.control.OxygenVelocity', {
	extend : 'Ext.app.Controller',
	stores : ['control.Temp'],
	models : ['control.Temp'],
	views : ['control.OxygenSensor', 'common.OxygenSensorChart'],

	init : function() {
		this.control({
			'oxSensor' : {
				onShow : this.onShow
			},
			'oxSensor tool[fun=1]' : {
				click : this.onRefresh
			},
			'oxSensor tool[fun=2]' : {
				click : this.onHistory
			}
		});
		tempPanel = null;
	},
	
	onHistory : function(tool, e, options) {
		var id = tempPanel.resid;
		var win = Ext.create('RYIVS.view.common.OxygenSensorChart');
		win.resid = id;
		win.show();
	},
	
	onRefresh : function(tool, e, options) {
		this.onShow(tempPanel);
	},
	
	onShow : function(pa) {
		tempPanel = pa;
		pa.setLoading(true, [true]);
		
		this.getControlTempStore().load({
			params : {
				resid : pa.resid
			},
			callback: function(records, operation, success) {
				var tipValue = false;//设备更新日期是否存在问题
				var tip = tempPanel.down('label[name=tip]');
				tip.hidden = true;
				if (records.length > 0) {
					var o = records[0].data;
					var d_time = new Date(o.time);
					var s_time = d_time.getFullYear()+"年"+(d_time.getMonth()+1)+"月"+d_time.getDate()+"日 "
								 +d_time.getHours()+"点"+d_time.getMinutes()+"分"+d_time.getSeconds()+"秒";
					var tplObject = {
						time : s_time,
						val1 : o.val1,
						val2 : o.val2
					}
					tempPanel.update(tplObject);
					
					var nowTime = new Date();
					if(nowTime.getTime()/1000-o.time/1000 >= 3600) {
						tipValue = true;
					}
				} else {
					tipValue = true;
					tempPanel.update({});
				}
				
				if(tipValue) {
					tip.setText("更新日期有误，请检查设备！");
					tip.show();
				}
				pa.setLoading(false, [false]);
		    }
		});
	}
});
