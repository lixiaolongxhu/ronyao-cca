/**
 * controller:风速传感
 * author : tqd
 * date : 2013-4-9
 */
Ext.define('RYIVS.controller.control.AirVelocity', {
	extend : 'Ext.app.Controller',
	stores : ['control.Temp'],
	models : ['control.Temp'],
	views : ['control.AirVelocity'],

	init : function() {
		this.control({
			'airVel' : {
				avtShow : this.avtShow
			},
			'airVel tool[fun=1]' : {
				click : this.onRefresh
			}
		});
		avtPanel = null;
	},
	
	onRefresh : function(tool, e, options) {
		this.avtShow(avtPanel);
	},
	
	avtShow : function(pa) {
		avtPanel = pa;
		pa.setLoading(true, [true]);
		
		this.getControlTempStore().load({
			params : {
				resid : pa.resid
			},
			callback: function(records, operation, success) {
				var tipValue = false;//设备更新日期是否存在问题
				var tip = avtPanel.down('label[name=tip]');
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
					avtPanel.update(tplObject);
					
					var nowTime = new Date();
					if(nowTime.getTime()/1000-data.time/1000 >= 3600) {
						tipValue = true;
					}
				} else {
					avtPanel.update({});
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
