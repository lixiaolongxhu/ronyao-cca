<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>国网四川电力输变电施工企业承载能力评估系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="lib/ext/resources/css/ext-all.css">
		<!-- 自定义图标样式  -->
		<link rel="stylesheet" type="text/css" href="css/ryivs.css">
	    <!-- 修正exjs 4  treepanel 背景设配置 -->
		<style>.x-grid-row .x-grid-cell{background-color:transparent}</style>
		
		<!--extjs 启动器-->
		<script type="text/javascript" src="lib/ext/bootstrap.js"></script>
		
		<!--全局静态变量，这里配置基本的常量和工具函数-->
		<script type="text/javascript" src="js/global.js"></script>
		
		<!--extjs-direct-spring 配制文件-->
		<script src="controllers/api-debug.js?group=store,form"></script>
		
		<!-- 中文化 -->
		<script type="text/javascript" src="lib/ext/locale/ext-lang-zh_CN.js"></script>
		
		

		<!--读取db中动态生成(同时检查是否用户已登录)-->
		<script type="text/javascript" src="controllers/app"></script>
		
		
		<!--读取db中的常量-->
		<script type="text/javascript" src="controllers/global"></script> 
		
		<!--读取db中动态生成配置信息 -->
		<script type="text/javascript" src="controllers/config"></script>
		
		
		<script type="text/javascript">
			var config = {
				contextPath: '${pageContext.request.contextPath}'
			};
    	</script>
			
	</head>
	<body>
		<div id="body"></div>
	</body>
</html>
