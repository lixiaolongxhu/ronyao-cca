<%@ page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

//登录界面UI配置
Ext.Loader.setConfig({
	enabled : true
});

appCfg.uname = "danny";

//初始化快速提示
Ext.QuickTips.init();

//配置 direct 调用
Ext.require('Ext.direct.*', function() {
	Ext.direct.Manager.addProvider(Ext.app.REMOTING_API);
});

//应用程序入口
Ext.application({
	name : 'RYIVS',

	appFolder : 'cca',

	controllers : ['common.Login'],
	
	launch : function() {

		Ext.Loader.setConfig({
			enabled : true
		});

		// 防止插件遮挡窗口
		Ext.useShims = true;

		// 全局屏蔽浏览器右键菜单
		Ext.getBody().on("contextmenu", Ext.emptyFn, null, {
			preventDefault : true
		});
 		
 		//登录页面
 		Ext.create('RYIVS.view.common.Login').show();

	}
});
