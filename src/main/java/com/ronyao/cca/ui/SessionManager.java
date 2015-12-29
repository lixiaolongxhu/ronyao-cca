package com.ronyao.cca.ui;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ronyao.cca.constant.ConstDictionary;
import com.ronyao.cca.db.dao.UserMapper;

import com.ronyao.cca.db.model.User;
import com.ronyao.cca.db.model.UserExample;

import com.ronyao.cca.tool.DateUtil;
import com.ronyao.cca.ui.vo.YearVo;

/**登陆的用户管理.
 * 
 */

@Controller
@Scope("session")
public class SessionManager {
	
	private static  final Logger LOG = LoggerFactory.getLogger(SessionManager.class);

	private User user;

	@Autowired
	private UserMapper userMapper;
	

	
	
	@Resource
	private ConstDictionary constDictionary;
	
	@Value("#{systemProperties.getProperty('config.debug.level')}")
	private int debugLevel;
	
	
	

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
			LOG.info("用户：" + user.getLoginname() + " 登陆成功。");
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
	public String logout(HttpSession session) {
		LOG.debug("用户注销登录");
		session.removeAttribute("loginUser");
		session.removeAttribute("permissionMenuParentIdMap");
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

	

	/**界面跳转:界面配置所需要的 App 文件(字符串自动转换为对应的名称jsp文件).
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/app")
	public String genApp(Model model) {
		
		if (this.user == null) {
			// 未登陆
			LOG.info("用户未登录,跳转到登录界面");
			return "AppLogin";
		} else {
//			// 已经登陆
			LOG.info("用户已登录,跳转到主界面");	
			return "AppAdmin";

		}
	};

	@RequestMapping(value = "/config")
	public String getInfo(Model model) {
		if(user!=null){
			model.addAttribute("user", user);
			
		}else{
			User emptyUser=new User();
			emptyUser.setId(0);
			emptyUser.setLoginname("未登陆用户");
			model.addAttribute("user", emptyUser);
		}
			
		model.addAttribute("debugLevel", debugLevel);
		return "WebConfig";
	};
	
	
	//获取DB const 字典常量或者变量

	@RequestMapping(value = "/global")
	public String getGlobalConfig(Model model) {
		//用户登录后才返回常量
		if(this.user!=null){
			//读取数据库初始配置
			constDictionary.initLoadDictionay();
			
			//enterprise 查询企业名称列表
			model.addAttribute("enterprise", constDictionary.getEnterpriseList());
			
			//查询企业资质分类
			model.addAttribute("aptitudeClassify",constDictionary.getAptitudeClassifyList());
			
			//查询企业资质等级
			
			model.addAttribute("aptitudeRankClassify",constDictionary.getAptitudeRankClassifyList());
			
			//施工企业岗位名称分类列表
			
			model.addAttribute("postClassify",constDictionary.getPostClassifyList());
			
			//电压等级分类
		
			model.addAttribute("voltageRankClassify",constDictionary.getVoltageRankClassifyList());
			
			//获取当前时间到前10年的列表
			String yearStr=DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT4);
			Integer yearInt=Integer.valueOf(yearStr);
			List<YearVo> yearList=new ArrayList<YearVo>();
			for(int i=0;i<10;i++){
				YearVo   year=new YearVo();
				year.setId(yearInt-i);
				year.setName(year.getId()+"年");
				yearList.add(year);
			}
			model.addAttribute("year",yearList);
		
			
			
		}
		return "DBConst";
	};
	
}
