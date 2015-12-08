package com.ronyao.cca.ui;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ronyao.cca.db.model.User;
import com.ronyao.cca.tool.SystemUtil;
import com.ronyao.cca.userlog.UserLogUtil;


public class SessionListener implements HttpSessionListener,ServletRequestListener  {

	static Logger log = org.slf4j.LoggerFactory
			.getLogger(SessionListener.class);
	
	private HttpServletRequest request;
	
	private UserLogUtil userLogUtil;
	
	
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
		User loginUser = (User) arg0.getSession().getAttribute("loginUser");
		if (null == loginUser) {
			log.info("loginUser is null!");
		} else {
			log.info("user id: " + loginUser.getLoginname() + "  timeout!!!!");
			String ip = SystemUtil.getIpAddr(request);
			userLogUtil.recordLog(loginUser.getId(), "会话超时，用户退出.", ip);
		}
		

	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		request = (HttpServletRequest)arg0.getServletRequest();
		ServletContext context = arg0.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		userLogUtil = (UserLogUtil)ctx.getBean("userLogUtil");
		
	}

}
