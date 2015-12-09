package com.ronyao.cca.ui;

/*
 * 登陆的用户管理
 */

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ronyao.cca.db.dao.EnterpriseMapper;
import com.ronyao.cca.db.dao.UserMapper;
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.EnterpriseExample;
import com.ronyao.cca.db.model.User;
import com.ronyao.cca.db.model.UserExample;


@Controller
@Scope("session")
public class SessionManager {

	private User user;

	@Autowired
	private UserMapper userMapper;
	
	@Resource
	private  EnterpriseMapper enterpriseMapper;


	@Value("#{systemProperties.getProperty('config.debug.level')}")
	private int debugLevel;
	
	static Logger log = org.slf4j.LoggerFactory.getLogger(SessionManager.class);

	/*
	 * 登陆过程
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(@RequestParam("username") String uName, @RequestParam("password") String uPass) {
		
		HttpServletRequest request =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		UserExample userExample = new UserExample();
		userExample.createCriteria().andLoginnameEqualTo(uName).andPasswordEqualTo(uPass);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() > 0) {
			user = users.get(0);
			log.info("用户：" + user.getLoginname() + " 登陆成功。");
			session.setAttribute("loginUser", this.user);
			return "";
		}

		return "0";
	}

	/*
	 * 注销过程
	 */
	@RequestMapping(value = "/logout")
	@ResponseBody
	public String logout() {
		this.user = null;
		return "";
	}

	/*
	 * 得到会话信息，当前用户的登陆状态
	 */
	@RequestMapping(value = "/userInfo")
	@ResponseBody
	public User session() {
		return this.user;
	}

	/*
	 * 界面配置所需要的 App 文件
	 */

	@RequestMapping(value = "/app")
	public String genApp(Model model) {
		if (this.user == null) {
			// 未登陆
			return "AppLogin";
		} else {
//			// 已经登陆，判断用户类型
//			if (this.user.getType() == 1) {
//				// 管理员登陆
//				return "AppAdmin";
//			} else {
//				// 监控人员登陆
//				return "AppUser";
//			}	
			// 管理员登陆
			return "AppAdmin";

		}
	};

	@RequestMapping(value = "/config")
	public String getInfo(Model model) {
		model.addAttribute("user", user);
		model.addAttribute("debugLevel", debugLevel);
		return "WebConfig";
	};
	
	
	//获取DB const 变量
	@RequestMapping(value = "/global")
	public String getGlobalConfig(Model model) {
		//enterprise 查询企业名称列表
		EnterpriseExample enterExample = new EnterpriseExample();
		enterExample.setDistinct(true);
		enterExample.setOrderByClause(" createTime desc  ");
		List<Enterprise> enterList = enterpriseMapper.selectByExample(enterExample);
		model.addAttribute("enterprise", enterList);
		return "DBConst";
	};
	
}
