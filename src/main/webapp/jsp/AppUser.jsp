<%@ page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

//管理人员UI配置

Ext.Loader.setConfig({
	enabled : true
});

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

	controllers : [ 'frame.User','frame.LeftMenu','frame.BottomBar','frame.Center','frame.TopPanel',
					
					'common.EditPassword',
	
					
					'editor.Enterprise','editor.EnterprisePer','editor.EnterpriseApt','editor.User','editor.EnterprisePerSta',
					'editor.EquipmentBear','editor.AnnualOutput','editor.BehaviorSta','editor.EnterprisePerMan','editor.EnterpriseEquip',
					'editor.Behavior','editor.EnterpriseAssess','editor.ProjectPlain','editor.ProjectNoBuild','editor.ProjectBuilding',
					
				 	
				 	'display.EnterpriseAptLookover','display.BehaviorStaLookover','display.Bear','display.BearRevised','display.BearContrastProNum',
				 	'display.BearContrastProOutput','display.ProjectBuildBear',
				 	
				 	'file.EnterpAptFileDis','file.EnterpPerFileDis'
				  ],


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

		// 建立主界面
		Ext.create('Ext.container.Viewport', {
			layout : 'border',
			minWidth : 800,
			
			items : [{
				xtype : 'layerUser'
			}]
		});

		// socket = new InitSocket();
	}
});

