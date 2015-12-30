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
		
		//document.documentElement.clientWidth：取得浏览器页面可视区域的宽度
		//document.documentElement.clientHeight：取得浏览器页面可视区域的高度
		//var clientHeight=document.documentElement.clientHeight;
		//var clientWidth=document.documentElement.clientWidth;
	    //alert("clientWidth:" +clientWidth+" clientHeight: "+clientHeight)
	    
 		// 建立主界面
		Ext.create('Ext.container.Viewport', {
			layout : 'border',
			minWidth : 800,
	
	    	//设置背景色或者图片( no -repeat 不重复平铺图片)
			style  : "background-image:url(res/img/background.jpg);background-position: center;background-repeat: no-repeat;background-attachment: fixed; background-size:cover;} ",
			
			items : [{
				//登录页面
				xtype : Ext.create('RYIVS.view.common.Login').show(),
				region:"west"
			}]
		});
 		
 		

	}
});
