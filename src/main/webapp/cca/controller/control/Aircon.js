// 视频控制
Ext.define('RYIVS.controller.control.Aircon', {
	extend : 'Ext.app.Controller',
	views : ['control.Aircon'],

	init : function() {
		this.control({
			'airconctl button' : {
				click : this.onClick
			},
			'airconctl' : {
				onShow : this.onShow
			}
		});
	},
	
	//初始化
	onShow : function(pa) {
		this.aircon =  pa;
		this.resid = pa.resid;
		this.ajaxSearch();
	},
	
	// 控制成功返回
	reqSuccess : function(response) {
		var res = Ext.JSON.decode(response.responseText);
		this.aircon.setLoading(false, [false]); // 关闭LoadMask
		var rstValue = res.rst;
		switch(rstValue) {
			case 0: //控制操作成功->执行查询重新渲染界面
				var tplData = {};// 构建模板数据
				if(this.airType == 0) {
					tplData = {mode : '关闭', state : '', tmp : ''};
				}else if(this.airType == 1) {
					tplData = {mode : '开启', state : '制冷', tmp : this.res_tmp};
				}else if(this.airType == 2) {
					tplData = {mode : '开启', state : '制热', tmp : this.res_tmp};
				}else if(this.airType == 3) {
					tplData = {mode : '开启', state : '除湿', tmp : ''};
				}
				//刷新container内容
				var air = this.aircon.down('container[name=airconCon]');
				air.update(tplData);
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
		this.aircon.setLoading(false, [false]); // 关闭LoadMask
		Ext.Msg.alert("错误提示", "控制请求超时！");
	},

	// ajax前端控制
	ajaxReq : function(data) {
		this.aircon.setLoading(true, [true]); // 开启LoadMask
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

	// 前端查询成功
	serachSuccess : function(response) {
		var res = Ext.JSON.decode(response.responseText);
		this.aircon.setLoading(false, [false]); // 关闭loadMask
		if (res.rst == 0) {
			var modValue = res.parm.mod;// 空调当前模式
			var mode, state, tmp;
			mode = '开启';// 默认为开
			switch (modValue) {
				case 0 : // 关闭
					mode = '关闭';
					break;
				case 1 : // 制冷
					state = '制冷';
					break;
				case 2 : // 制热
					state = '制热';
					break;
				case 3 : // 除湿
					state = '除湿';
					break;
			}
			// 获取温度值
			tmp = res.parm.ext;

			// 构建模板数据
			var tplData = {
				mode : mode,
				state : state,
				tmp : tmp
			};
		} else if (res.rst == 1) {
			Ext.Msg.alert("错误提示", "前端通讯失败！");
		} else if (res.rst == 2) {
			Ext.Msg.alert("错误提示", "未找到资源！");
		} else if (res.rst == 3) {
			Ext.Msg.alert("错误提示", "资源不可用！");
		}
		//刷新container内容
		var air = this.aircon.down('container[name=airconCon]');
		air.update(tplData);
	},

	// 前端查询失败
	serachFailure : function(response) {
		this.aircon.setLoading(false, [false]);
		Ext.Msg.alert("错误提示", "查询状态超时！");
	},

	// ajax前端查询
	ajaxSearch : function() {
		this.aircon.setLoading(true, [true]);
		data = {
			"cmd" : 2,
			"parm" : {
				"node" : this.resid,
				"type" : 2
			}
		};
		Ext.Ajax.request({
			url : 'controller/manager',
			method : 'POST',
			timeout : 5000,
			// 控制器请求参数
			jsonData : data,
			success : this.serachSuccess,
			failure : this.serachFailure,
			scope : this
		});
	},

	onClick : function(bt, e, options) {
		this.airType = 0;//默认记录为关闭
		
		switch (bt.fnc) {
			case 1 :
				// 查询
				this.ajaxSearch();
				break;
			case 3 :
				// 关闭
				data = {
					"cmd" : 1,
					"parm" : {
						"node" : this.resid,
						"type" : 2,
						"parm" : {
							"mod" : 0,
							"ext" : 0
						}
					}
				};
				Ext.Msg.show({
					title : '提示',
					msg : '确定要关闭此空调？',
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
			case 4 :
				// airCtlType:1制冷，2制热，3除湿
				var airCtlType = this.aircon.down('combo[name=airCtlType]').value;
				this.airType = airCtlType;
				var stmp = this.aircon.down('textfield[name=tmp]').value;
				if (airCtlType == 1) { //1制冷
					if (stmp == undefined || stmp == "") {
						Ext.Msg.alert("输入提示", "请输入制冷温度！");
						return false;
					}
					var tmp = parseInt(stmp);
					this.res_tmp = tmp;
					data = {
						"cmd" : 1,
						"parm" : {
							"node" : this.resid,
							"type" : 2,
							"parm" : {
								"mod" : 1,
								"ext" : tmp
							}
						}
					};
				} else if (airCtlType == 2) { //2制热
					if (stmp == undefined || stmp == "") {
						Ext.Msg.alert("输入提示", "请输入制热温度！");
						return false;
					}
					var tmp = parseInt(stmp);
					this.res_tmp = tmp;
					data = {
						"cmd" : 1,
						"parm" : {
							"node" : this.resid,
							"type" : 2,
							"parm" : {
								"mod" : 2,
								"ext" : tmp
							}
						}
					};
				} else if (airCtlType == 3) { //除湿
					data = {
						"cmd" : 1,
						"parm" : {
							"node" : this.resid,
							"type" : 2,
							"parm" : {
								"mod" : 3,
								"ext" : 10
							}
						}
					};
				}
				this.ajaxReq(data);
				break;
		}	
	}
});
