package com.ronyao.cca.ui.extDirect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;

import com.ronyao.cca.db.dao.UserLogMapper;
import com.ronyao.cca.db.model.UserLog;
import com.ronyao.cca.db.model.UserLogExample;

/**
 * 用户日志的读取和删除
 * 
 * @author wx@RY
 * 
 */
@Service
public class ActionUserLog {
	@Autowired
	UserLogMapper userLogMapper;

	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<UserLog> read(
			ExtDirectStoreReadRequest request) throws Exception {
		//初始化一个封装条件的工具类
		UserLogExample userLogExample = new UserLogExample();
		//获得前段传回参数的容器
		Map<String, Object> params = request.getParams();
		//声明两个对象。接受参数
		Object btObject=null,etObject=null;
		//获得该Map的key集合
		Set<String> keySet = params.keySet();
		
		int start = request.getStart();
		int limit = request.getLimit();
		RowBounds rowBounds = new RowBounds(start, limit);
		
		//判断期望参数的情况
		int flag=-1;
		if(keySet.contains("beginTime")&&keySet.contains("endTime")){
			//开始时间和终止时间都存在
			flag=1;
		}else if(keySet.contains("beginTime")&&!keySet.contains("endTime")){
			//
			flag=2;
		}else if(!keySet.contains("beginTime")&&keySet.contains("endTime")){
			//
			flag=3;
		}else{
			flag=4;
		}
		
		switch (flag) {
		case 1:{
			btObject = params.get("beginTime");
			etObject = params.get("endTime");
			if (!btObject.equals(null) && !etObject.equals(null)) {
				String beginTime = btObject.toString();
				String endTime = etObject.toString();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date beginDate = sdf.parse(beginTime);
				Date endDate = sdf.parse(endTime);
				userLogExample.createCriteria().andOperateTimeBetween(beginDate, endDate);	
			}
			break;
		}
		case 2:{
			btObject = params.get("beginTime");
			if (!btObject.equals(null)) {
				String beginTime = btObject.toString();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date beginDate = sdf.parse(beginTime);
				userLogExample.createCriteria().andOperateTimeGreaterThanOrEqualTo(beginDate);
			}
			break;
		}case 3:{
			etObject = params.get("endTime");
			if (!etObject.equals(null)) {
				String endTime = etObject.toString();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date endDate = sdf.parse(endTime);
				userLogExample.createCriteria().andOperateTimeLessThanOrEqualTo(endDate);
			}
			break;
		}case 4: {
			break;
		}
		}
		int total = userLogMapper.countByExample(userLogExample);
		return new ExtDirectStoreReadResult<UserLog>(total,userLogMapper.selectByExampleWithRowbounds(userLogExample, rowBounds));
	}

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int removeUserLog(List<UserLog> userLogs) {
		Iterator<UserLog> iterator = userLogs.iterator();
		while (iterator.hasNext()) {
			UserLog userLog = iterator.next();
			int logId = userLog.getId();
			userLogMapper.deleteByPrimaryKey(logId);
		}
		return userLogs.size();
	}

}
