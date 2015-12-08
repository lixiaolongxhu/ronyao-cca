//前端控制的工厂管理
Ext.define('RYIVS.controller.control.ControlFactory', {
	extend : 'Ext.app.Controller',
	views : [ 'control.Switch', 'control.Aircon', 'control.Temp'],

	init : function() {
		controller.control = this;
	},

	// 判断是否需要弹出控制窗口
	needPop : function(resid, type) {
		// 确定是否需要弹出气泡
		var rst = {
			popup : false,
			width : 0,
			height : 0
		};
		// 根据 restype 转换成 resCat
		var cat = Ext.getStore('common.ResourceTypeCat').data.getByKey(type).data.cat;
	//	alert(" cat= "+ cat);
		switch (cat) {
			case 1: // 开关量告警通道
				rst.popup = true;
				rst.width = 140;
				rst.height = 150;
			break;
			case 2: // 风速传感
				rst.popup = true;
				rst.width = 140;
				rst.height = 150;
				break;
			case 3: // 温湿度传感
				rst.popup = true;
				rst.width = 160;
				rst.height = 150;
				break;
			case 4: // SF6传感
				rst.popup = true;
				rst.width = 160;
				rst.height = 170;
				break;
			case 5: // 氧气传感
				rst.popup = true;
				rst.width = 160;
				rst.height = 170;
				break;
			case 11: // 开关控制
				rst.popup = true;
				rst.width = 120;
				rst.height = 140;
				break;
			case 12: // 空调控制
				rst.popup = true;
				rst.width = 170;
				rst.height = 195;
				break;
			
		}
		return rst;
	},

	switchPanel : null, //开关量
	airconPanel : null, //空调
	tempPanel : null, //温湿度
	avtPanel : null, //风速传感
	SF6Panel : null, //SF6传感
	oxSenPanel : null, //氧气传感

	// 弹出相应的控制界面
	onPopupShow : function(div, resid, type) {
	//	alert("resid= "+resid+"type="+type);
		switch (type) {
		// type：4风机，7灯光
		case 4:
		case 7:
		case 14:
			controller.control.switchPanel = Ext.create('RYIVS.view.control.Switch', {
				popup : true,
				resid : resid,
				renderTo : div
			});
			
			if(3 == appCfg.utype) {
				controller.control.switchPanel.query('button[fnc=2]')[0].setDisabled(true);
				controller.control.switchPanel.query('button[fnc=3]')[0].setDisabled(true);
			}
			controller.control.switchPanel.show();
			break;
		case 5: // 5空调
			controller.control.airconPanel = Ext.create('RYIVS.view.control.Aircon', {
				popup : true,
				resid : resid,
				renderTo : div
			});
			
			if(3 == appCfg.utype) {
				controller.control.airconPanel.query('button[fnc=4]')[0].setDisabled(true);
				controller.control.airconPanel.query('button[fnc=3]')[0].setDisabled(true);
			}
			controller.control.airconPanel.show();
			break;
		case 6: // 6温湿度
			controller.control.tempPanel = Ext.create('RYIVS.view.control.Temp', {
				popup : true,
				resid : resid,
				renderTo : div
			});
			controller.control.tempPanel.show();
			break;
		case 8: //8风速传感
			controller.control.avtPanel = Ext.create('RYIVS.view.control.AirVelocity', {
				popup : true,
				resid : resid,
				renderTo : div
			});
			controller.control.avtPanel.show();
			break;
		case 12: //12.SF6传感
			controller.control.SF6Panel = Ext.create('RYIVS.view.control.SF6Velocity', {
				popup : true,
				resid : resid,
				renderTo : div
			});
			controller.control.SF6Panel.show();
			break;
		case 13:
			controller.control.oxSenPanel = Ext.create('RYIVS.view.control.OxygenSensor', {
				popup : true,
				resid : resid,
				renderTo : div
			});
			controller.control.oxSenPanel.show();
			break;
		case 10: //10水浸
			controller.control.WaterLinePanel = Ext.create('RYIVS.view.control.WaterLine', {
				popup : true,
				resid : resid,
				renderTo : div
			});
			controller.control.WaterLinePanel.show();
			break;
		}
	},

	// 弹出
	onPopupClose : function(div) {
		var cpList = Ext.ComponentQuery.query("panel[popup=true]");
		for (i = 0; i < cpList.length; i++) {
			var cp = cpList[i];
			cp.close();
		}
	}

});
