<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>施工承载能力评估系统----------成都荣耀科技有限公司</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="lib/ext/resources/css/ext-all.css">
		<link rel="stylesheet" type="text/css" href="css/ryivs.css">
		
		<!--extjs 启动器-->
		<script type="text/javascript" src="lib/ext/bootstrap.js"></script>
		
		<!--全局静态变量，这里配置基本的常量和工具函数-->
		<script type="text/javascript" src="js/global.js"></script>
		
		
		
		<!-- 自定义验证vtype 
		<script type="text/javascript" src="js/CusFieldVtypes.js"></script>
		-->
		
		
		<!--读取db中的常量-->
		<script type="text/javascript" src="controllers/global"></script> 
		
		<!--extjs-direct-spring 配制文件-->
		<script src="controllers/api-debug.js?group=store,form"></script>
		
		<!-- 中文化 -->
		<script type="text/javascript" src="lib/ext/locale/ext-lang-zh_CN.js"></script>
		
		
		<!-- Timeline
			<script type="text/javascript" src="js/timeline/timeline.js"></script>
			<link rel="stylesheet" type="text/css" href="js/timeline/timeline.css">
		 -->
		
		
		<!-- 动态生成配置信息 -->
		<script type="text/javascript" src="controllers/config"></script>
	
		<!--运行ExtJs程序，动态生成-->
		<script type="text/javascript" src="controllers/app"></script>
	
	
		
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
