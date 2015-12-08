/**
 * controller : user界面gisVideo
 * author : tqd
 */
Ext.define('RYIVS.controller.video.GisVideoPanel', {
	extend : 'Ext.app.Controller',
	views : ['video.GisVideoPanel'],
	models : ['video.PtzPos'],
	stores : ['video.PtzPos'],
	
	init : function() {
		this.control({
			'gisVideo combo' : {
				change : this.onInvokePtzPos
			}
		});
	},
	
	/**
	 * 调用预置点
	 * @param {} btn
	 */
	onInvokePtzPos : function(btn) {
		var ptzPosObj = Ext.ComponentQuery.query('gisVideo combo')[0],
			ptzValue = ptzPosObj.value,
			resid = ptzPosObj.resid;

		if(!ptzPosObj.value) {
			ptzPosObj.validate();
		}else {
			var parm = {
				cmd : 103,
				parm : {
					resid : resid.toString(),
					action : 11,
					value : ptzValue
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
					var resText = Ext.decode(response.responseText),
					res = resText.res;
					if(res == 1) {
						Ext.Msg.alert("系统提示", "权限不足,暂时不能控制！");
					}
				}
			});
		}
	}
});