/**
 * author:tqd
 * controller:预置点管理
 */
Ext.define('RYIVS.controller.video.PtzPosList', {
	extend : 'Ext.app.Controller',
	views : ['video.PtzPosList'],
	models : ['video.PtzPos'],

	init : function() {
		this.control({
			'ptzPosList' : {
				itemdblclick : this.onItemdblclick
			}
		});
	},
	
	onItemdblclick : function(grid, record, item, index, e, eOpts) {
		var da = record.data;
		var parm = {
			cmd : 103,
			parm : {
				resid : da.resid,
				action : 11,
				value : da.pos
			}
		};

		Ext.Ajax.request({
			url : '/srv/ptz',
			params : {
				action : Ext.JSON.encode(parm),
				urank : appCfg.urank,
				uid : appCfg.uid
			},
			timeout : 500,
			success : function(response) {
				//doSomething
				var resText = Ext.decode(response.responseText),
					res = resText.res;
				if(res == 1) {
					Ext.Msg.alert("系统提示", "权限不足,暂时不能控制！");
				}
			}
		});
	}
});
