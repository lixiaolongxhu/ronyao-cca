package com.ronyao.cca.userlog;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ronyao.cca.db.model.User;
import com.ronyao.cca.db.model.UserLog;
import com.ronyao.cca.tool.SystemUtil;

@Aspect
public class UserLogAspect {
	
	@Autowired
	private UserLogUtil userLogUtil; 
	public static final Logger log = LoggerFactory.getLogger(UserLogAspect.class);
	
	@Pointcut("execution(* com.ronyao.cca.ui.ext.Action*.create*(..))")
	public void ActionCreate(){	
	}
	
	@Pointcut("execution(* com.ronyao.cca.ui.ext.Action*.destroy*(..))")
	public void ActionDestroy(){	
	}
	@Pointcut("execution(* com.ronyao.cca.ui.ext.Action*.update*(..))")
	public void ActionUpdate(){	
	}
	@Pointcut("execution(* com.ronyao.cca.ui.ext.Action*.remove*(..))")
	public void ActionRemove(){	
	}
	@Pointcut("execution(* com.ronyao.cca.ui.ext.Action*.upload*(..))")
	public void ActionUpload(){	
	}
	@Pointcut("execution(* com.ronyao.cca.ui.ext.Action*.add*(..))")
	public void ActionAdd(){	
	}
	
	@Pointcut("execution(* com.ronyao.cca.ui.SessionManager.log*(..))")
	public void doExecutionSession(){
	}
	
	@Pointcut("ActionCreate()|| ActionDestroy()|| ActionUpdate()|| ActionRemove()|| ActionUpload()|| ActionAdd() || doExecutionSession()")
	public void doExecution(){
	}
	

	@SuppressWarnings("unchecked")
	@Around("doExecution()")
	public Object userLogPersistence(ProceedingJoinPoint joinPoint) throws Throwable{
		Object object = joinPoint.proceed();
		UserLog userLog = new UserLog();
		//获取拦截到的方法签名,格式：访问控制关键字  详细的类名.方法名(参数类型列表)
		StringBuffer signature = new StringBuffer(joinPoint.getSignature().toString());
		
		HttpServletRequest request =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String clientIp = SystemUtil.getIpAddr(request);
		String ipInfo = clientIp==null?"无法获取登录客户端IP":clientIp;
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		int userId = -1;
		if(loginUser!=null){
			Integer loginUserId = loginUser.getId();
			userId = loginUserId;
		}else {
			log.info("无登陆用户...");
			return object;
		}
		
		List<Object> filterList = null;
		
		Object[] args= joinPoint.getArgs();
		if (args.length!=0 && args[0] instanceof java.util.List) {
			filterList = (List<Object>)args[0];
		}
		
		String userAction = SystemUtil.getUserAction(signature,filterList,object).toString();
		log.info("userAction:"+userAction);
		
		userLog.setUid(userId);
		userLog.setIpAddress(ipInfo);
		userLog.setUserAction(userAction);
		userLog.setOperateTime(new Date());
		userLog.setCommentInfo("");
		userLogUtil.addUserLogToDB(userLog);	

		return object;
	}
}
