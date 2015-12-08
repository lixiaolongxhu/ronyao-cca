//播放器面板
Ext.define('RYIVS.controller.video.PlayerWin', {
	extend : 'Ext.app.Controller',
	views : [ 'video.PlayerWin' ],

	refs : [ {
		selector : 'winPlayer numberfield',
		ref : 'ptzPos'
	}, {
		selector : 'videoPanel',
		ref : 'player'
	}, {
		selector : 'winPlayer ptzPos',
		ref : 'ptzPosGrid'
	} ],

	init : function() {
		this.control({
			'button[fnc=2]' : {
				click : this.onPtzCall
			},
			'button[fnc=1]' : {
				click : this.onPtzSet
			},
			'numberfield[name=pos]' : {
				change : this.onPosChange
			}
		});
	},
	
	//动态修改预置点名称posName
	onPosChange : function(posNum, newValue, oldValue, eOpts) {
		var ptzStore =  this.getPtzPosGrid().store,
			posName = Ext.ComponentQuery.query('textfield[name=posName]')[0];
			
		ptzStore.each(function(rowData) {
			if(rowData.data.pos == newValue) {
				posName.setValue(rowData.data.name);
				return false;
			}else {
				posName.setValue("");
			}
		},this);
	},

	onPtzSet : function(button, e, eOpts) {
		var ptz = this.getPtzPos().getValue();
		var posName = Ext.ComponentQuery.query("winPlayer textfield")[1].getValue();
		
		var addPosToDB = {
			resid : button.ownerCt.ownerCt.resid,
			pos : ptz,
			name : posName
		};
		
		var parm = {
			cmd : 103,
			parm : {
				resid : button.ownerCt.ownerCt.resid.toString(),
				action : 9,
				value : ptz
			}
		};

		Ext.Ajax.request({
			url : '/srv/ptz',
			params : {
				action : Ext.JSON.encode(parm),
				urank : appCfg.urank,
				uid : appCfg.uid
			},
			timeout : 4000,
			success : function(response) {
				var resText = Ext.decode(response.responseText),
					res = resText.rst;
				
				switch(res) {
					case 0:
						//添加预置点到到数据库
						this.onAddPtzPos(addPosToDB);
						Ext.Msg.alert("提示", "预置点设置成功！");
					break;
					case 1:
						Ext.Msg.alert("错误提示", "未找到资源！");
					break;
					case 2:
						Ext.Msg.alert("错误提示", "前端不支持！");
					break;
					case 4:
						Ext.Msg.alert("错误提示", "前端通讯错误！");
					break;
					case 100:
						Ext.Msg.alert("错误提示", "命令不能识别！");
					break;
					case 101:
						Ext.Msg.alert("错误提示", "内部错误！");
					break;
				}
			},
			failure : function() {
//				this.onAddPtzPos(addPosToDB);
				Ext.Msg.alert("错误提示", "请检查设备连接是否正常！");
			},
			scope : this
		});
	},
	
	//添加预置点到数据库
	onAddPtzPos : function(params) {
		var me = this;
		Ext.Ajax.request({
			url : '/controller/addPtzPos',
			jsonData : Ext.JSON.encode(params),
			timeout : 4000,
			success : function(response) {
				//刷新该摄像机的资预置点列表
				me.getPtzPosGrid().store.load();
			},
			failure : function() {
				Ext.Msg.alert("错误提示", "数据库添加预置点失败！");
			},
			scope : this
		});
	},

	/**
	 * 预置点调用
	 * @param {} button
	 * @param {} e
	 * @param {} eOpts
	 */
	onPtzCall : function(button, e, eOpts) {
		var ptz = this.getPtzPos().getValue();
		var parm = {
			cmd : 103,
			parm : {
				resid : button.ownerCt.ownerCt.resid.toString(),
				action : 11,
				value : ptz
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
			},
			failure : function() {
//				debugger;
			}
		});
	}

});
