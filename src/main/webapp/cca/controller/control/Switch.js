//视频控制
Ext.define('RYIVS.controller.control.Switch', {
	extend : 'Ext.app.Controller',
	views : ['control.Switch'],

	init : function() {
		this.control({
			'controlSwitch > button' : {
				click : this.onClick
			},
			'controlSwitch' : {
				onShow : this.onShow
			}
		});
	},
	
	//初始化
	onShow : function(pa) {
		this.switchPanel = pa;
		this.resid = pa.resid;
		this.ajaxSearch();
	},
	
	// 控制成功返回
	reqSuccess : function(response) {
		var res = Ext.JSON.decode(response.responseText);
		this.switchPanel.setLoading(false, [false]);
		var rstValue = res.rst;
		switch(rstValue) {
			case 0: //控制操作成功->执行查询重新渲染界面
				var tplData = {};
				if(this.reqType == 2) {//开启
					tplData = {mode : '远程控制', state : '开启'};
				}else if(this.reqType == 3) {//关闭
					tplData = {mode : '远程控制', state : '关闭'};
				}
				//刷新container内容
				var sw = this.switchPanel.down('container[name=switchCon]');
				sw.update(tplData);
				break;
			case 1:
				Ext.Msg.alert("错误提示", "前端通讯失败！")
				break;
			case 2:
				Ext.Msg.alert("错误提示", "未找到资源！")
				break;
			case 3:
				Ext.Msg.alert("错误提示", "资源不可用！")
				break;
			case 4:
				Ext.Msg.alert("错误提示", "就地控制,远程不可控！")
				break;
			case 5:
				Ext.Msg.alert("错误提示", "控制失败！")
				break;
		}
	},

	// 控制失败返回
	reqFailure : function(response) {
		this.switchPanel.setLoading(false, [false]);
		Ext.Msg.alert("错误提示", "控制请求超时！");
	},

	//ajax前端控制
	ajaxReq : function(data) {
		this.switchPanel.setLoading(true, [true]);
		Ext.Ajax.request({
			url : 'controller/manager',
			method : 'POST',
			timeout : 5000,
			// 控制器请求参数
			jsonData : data,
			success : this.reqSuccess,
			failure : this.reqFailure,
			scope : this
		});
	},
	
	//前端查询成功
	serachSuccess : function(response) {
		var res = Ext.JSON.decode(response.responseText);
		
		//关闭loadMask
		this.switchPanel.setLoading(false, [false]);
		
		if(res.rst == 0) {
			var mode, state;
			var modValue = res.parm.mod;//控制模式
			var stateValue = res.parm.ext;//当前状态
			if(modValue == 0) {
				mode = '远程控制';
			}else {
				mode = '就地控制';
			}
			
			if(stateValue == 0) {
				state = '关闭';
			}else {
				state = '开启';
			}
			
			//构建模板
			var tplData = {mode : mode, state : state};
			
		}else if(res.rst == 1) {
			Ext.Msg.alert("错误提示", "前端通讯失败！");		
		}else if(res.rst == 2) {
			Ext.Msg.alert("错误提示", "未找到资源！");
		}else if(res.rst == 3) {
			Ext.Msg.alert("错误提示", "资源不可用！");
		}
		
		//刷新container内容
		var sw = this.switchPanel.down('container[name=switchCon]');
		sw.update(tplData);
	},
	
	//前端查询失败
	serachFailure : function(response) {
		this.switchPanel.setLoading(false, [false]);
		Ext.Msg.alert("错误提示", "查询状态超时！");
	},
	
	//ajax前端查询
	ajaxSearch : function() {
		this.switchPanel.setLoading(true, [true]);
		data = {
			"cmd" : 2,
			"parm" : {
				"node" : this.resid,
				"type" : 1
			}
		};
		Ext.Ajax.request({
			url : 'controller/manager',
			method : 'POST',
			// 控制器请求参数
			jsonData : data,
			timeout : 5000,
			success : this.serachSuccess,
			failure : this.serachFailure,
			scope : this
		});
	},

	onClick : function(bt, e, options) {
		this.reqType = bt.fnc;
		
		switch (bt.fnc) {
			case 1:
				// 查询
				this.ajaxSearch();
				break;
			case 2:
				// 开启
				data = {
					"cmd" : 1,
					"parm" : {
						"node" : this.resid,
						"type" : 1,
						"parm" : {
							"mod" : 0,
							"ext" : 1
						}
					}
				};
				this.ajaxReq(data);
				break;
			case 3:
				// 关闭
				data = {
					"cmd" : 1,
					"parm" : {
						"node" : this.resid,
						"type" : 1,
						"parm" : {
							"mod" : 0,
							"ext" : 0
						}
					}
				};
				Ext.Msg.show({
					title : '提示',
					msg : '确定要关闭此设备吗？',
					buttons : Ext.Msg.YESNO,
					icon : Ext.Msg.QUESTION,
					scope : this,
					fn : function(btn) {
						if (btn == 'yes') {
							this.ajaxReq(data);
						} else {
							return false;
						}
					}
				});
				break;
		}
	}
});
