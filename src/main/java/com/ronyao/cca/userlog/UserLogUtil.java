package com.ronyao.cca.userlog;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ronyao.cca.db.dao.UserLogMapper;
import com.ronyao.cca.db.model.UserLog;

@Service
public class UserLogUtil {
	
	@Autowired
	private  UserLogMapper userLogMapper;

	public void addUserLogToDB(UserLog userLog){
		userLogMapper.insert(userLog);
	}
	
	/**
	 * @param userId
	 * @param userAction
	 * @param commentInfo
	 */
	public  void recordLog(int userId,String userAction,String ip,String commentInfo){
		UserLog userLog = new UserLog();
		String ipInfo = ip ==null?"无法获取登录客户端IP":ip;
		userLog.setUid(userId);
		userLog.setIpAddress(ipInfo);
		userLog.setUserAction(userAction);
		userLog.setOperateTime(new Date());
		userLog.setCommentInfo(commentInfo);
		userLogMapper.insert(userLog);
		
	}
	
	/**
	 * @param userId      用户id
	 * @param userAction  用户操作
	 */
	public  void recordLog(int userId,String userAction,String ip){
		this.recordLog(userId,userAction,ip,"");
	}

}
