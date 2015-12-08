/**
 * controller:水位监控
 * author : tqd
 * date : 2013-4-9
 */
Ext.define('RYIVS.controller.control.WaterLine', {
	extend : 'Ext.app.Controller',
	stores : ['control.Temp'],
	models : ['control.Temp'],
	views : ['control.WaterLine'],

	init : function() {
		this.control({
			'waterLine' : {
				waterLineShow : this.waterLineShow
			},
			'waterLine tool[fun=1]' : {
				click : this.onRefresh
			},
			'waterLine tool[fun=2]' : {
				click : this.onHistory
			}
		});
		waterLinePanel = null;
	},
	
	onRefresh : function(tool, e, options) {
		this.waterLineShow(waterLinePanel);
	},
	
	onHistory : function(tool, e, options) {
		var id = waterLinePanel.resid;
		var win = Ext.create('RYIVS.view.common.WaterLineChart');
		win.resid = id;
		win.show();
	},
	
	waterLineShow : function(pa) {
		waterLinePanel = pa;
		pa.setLoading(true, [true]);
		
		this.getControlTempStore().load({
			params : {
				resid : pa.resid
			},
			callback: function(records, operation, success) {
				//alert(records);
				var tipValue = false;//设备更新日期是否存在问题
				var tip = waterLinePanel.down('label[name=tip]');
				tip.hidden = true;
				if(records.length > 0) {
					var data = records[0].data;
					var d_time = new Date(data.time);
					var s_time = d_time.getFullYear()+"年"+(d_time.getMonth()+1)+"月"+d_time.getDate()+"日 "
								 +d_time.getHours()+"点"+d_time.getMinutes()+"分"+d_time.getSeconds()+"秒";
					var tplObject = {
						time : s_time,
						val1 : data.val1
					}
					waterLinePanel.update(tplObject);
					
					var nowTime = new Date();
					if(nowTime.getTime()/1000-data.time/1000 >= 3600) {
						tipValue = true;
					}
				} else {
					waterLinePanel.update({});
				}
				
				if(tipValue) {
				
					tip.setText("信息错误,请检查设备！");
					tip.show();
				}
				pa.setLoading(false, [false]);
		    }
		});
	}
});
