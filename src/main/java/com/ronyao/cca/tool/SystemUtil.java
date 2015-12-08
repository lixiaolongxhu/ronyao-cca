package com.ronyao.cca.tool;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class SystemUtil {
//	public static final Logger log = LoggerFactory.getLogger(SystemUtil.class);
	
	public static String getIpAddr(HttpServletRequest request) {  
		 String ip = request.getHeader("x-forwarded-for");  
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		  ip = request.getHeader("Proxy-Client-IP");  
		 }  
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		  ip = request.getHeader("WL-Proxy-Client-IP");  
		 }  
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		  ip = request.getRemoteAddr();  
		 }  
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		  ip = request.getHeader("http_client_ip");  
		 }  
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		  ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
		 }  
		 // 如果是多级代理，那么取第一个ip为客户ip  
		 if (ip != null && ip.indexOf(",") != -1) {  
		  ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();  
		 }  
		 return ip;  
		}
	
	public static StringBuffer getUserAction(StringBuffer signature,List<Object> list,Object object) {

		
		StringBuffer signBuffer = signature;
		List<Object> tempList = list;
		int blankIndex =signBuffer.indexOf(" ");
		String sign = signBuffer.substring(blankIndex+1, signBuffer.length());
		int lastDotIndex = sign.lastIndexOf(".");
		String className = sign.substring(0, lastDotIndex);
		String functionName = sign.substring(lastDotIndex+1,sign.length());
//		log.info("className:"+className+",functionName:"+functionName);
		String result = parseClassName(className)+","+ parseFunctionName(functionName);
		if (tempList!=null) {
			result+=parseArgs(tempList);
		}
		
		return new StringBuffer(result);
	}
	
	public static String parseClassName(String className) {
		String tempClassName =className;
		String classResult="操作模块:";
		if (tempClassName.contains("ActionAlarm")) {
			classResult+="告警信息";
		}else if(tempClassName.contains("ActionAlarmRule")) {
			classResult+="规则(告警,事件)";
		}else if(tempClassName.contains("ActionEquipment")) {
			classResult+="设备控制器";
		}else if(tempClassName.contains("ActionFileUpload")) {
			classResult+="文件";
		}else if(tempClassName.contains("ActionGisRes")) {
			classResult+="Gis编辑";
		}else if(tempClassName.contains("ActionLocator")) {
			classResult+="定位器";
		}else if(tempClassName.contains("ActionPtzPos")) {
			classResult+="预置点";
		}else if(tempClassName.contains("ActionResource")) {
			classResult+="资源";
		}else if(tempClassName.contains("ActionRuleAction")) {
			classResult+="规则联动动作";
		}else if(tempClassName.contains("ActionUserAlarm")) {
			classResult+="用户告警";
		}else if(tempClassName.contains("ActionUserLog")) {
			classResult+="用户日志管理";
		}else if(tempClassName.contains("ActionUser")) {
			classResult+="用户管理";
		}else if(tempClassName.contains("SessionManager")) {
			classResult+="会话管理";
		}else if(tempClassName.contains("ActionLayerList")) {
			classResult+="图层管理";
		}
		return classResult;
	}
	
	public static String parseFunctionName(String functionName) {
		String tempFunctionName = functionName;
		String functionResult="";
		
		if (tempFunctionName.contains("create")) {
			functionResult+="新增数据";
		}else if(tempFunctionName.contains("update")){
			functionResult+="修改数据";
		}else if(tempFunctionName.contains("destroy")){
			functionResult+="删除数据";
		}else if(tempFunctionName.contains("removeUserLog")){
			functionResult+="删除用户日志";
		}else if(tempFunctionName.contains("add")){
			functionResult+="新增";
		}else if(tempFunctionName.contains("login")){
			functionResult+="用户登陆.";
		}else if(tempFunctionName.contains("logout")){
			functionResult+="用户注销.";
		}else if(tempFunctionName.contains("uploadFile")){
			functionResult+="上传图片文件.";
		}else if(tempFunctionName.contains("uploadPicture")){
			functionResult+="修改图片文件.";
		}	
		return functionResult;
	}
	
	public static String  parseArgs(List<Object> list) {
		String argsResult = "";
		int size = list.size();
		if(size !=0){
			argsResult+=size+"条";
		}		
		return argsResult;
	}

}
