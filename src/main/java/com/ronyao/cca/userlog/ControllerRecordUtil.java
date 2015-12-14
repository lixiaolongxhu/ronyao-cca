package com.ronyao.cca.userlog;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ronyao.cca.db.model.User;
import com.ronyao.cca.db.model.UserLog;
import com.ronyao.cca.tool.SystemUtil;

@Service
public class ControllerRecordUtil {

	
	@Autowired
	private UserLogUtil userLogUtil;

	// 鉴于云台的转动在一次单击时会发送多条协议，设置一个标志量,用以记录之前的用户操作行为
	private int preUserAction = 0;

//	// 根据资源ID查询对应的通道名称
//	public String getEqpChaNameByResId(int resId) {
//		EquipmentChannelExample equipmentChannelExample = new EquipmentChannelExample();
//		equipmentChannelExample.createCriteria().andResidEqualTo(resId);
//		String eqpChaName = equipmentChannelMapper
//				.selectByExample(equipmentChannelExample).get(0).getName();
//		return eqpChaName;
//	}

	// 获取用户IP,uid,构造协议的基本部分
	public  UserLog recordUserLog() {
		UserLog userLog = new UserLog();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String clientIp = SystemUtil.getIpAddr(request);
		String ipInfo = clientIp == null ? "无法获取登录客户端IP" : clientIp;
		HttpSession session = request.getSession();
		if (session == null) {
			return null;
		}
		User loginUser = (User) session.getAttribute("loginUser");
		int userId = -1;
		if (loginUser != null) {
			Integer loginUserId = loginUser.getId();
			userId = loginUserId;
		}

		userLog.setUid(userId);
		userLog.setOperateTime(new Date());
		userLog.setIpAddress(ipInfo);

		return userLog;
	}

	
	//构造前端控制的用户行为(开关量,空调控制)
	public String  getUserActionByNodeControl(JsonNode actionBean,JsonNode resultBean){

		String userAction = "尝试";
		// 控制命令ID

//		int cmd = actionBean.get("cmd").asInt();
//
//		// 节点ID，对应为实际资源的ID
//		int resId = actionBean.get("parm").get("node").asInt();
//		// 命令类型
//
//		int type = actionBean.get("parm").get("type").asInt();
//		//前端模式
//		int mod = actionBean.get("parm").get("parm").get("mod").asInt();
//
//		// 扩展数据
//		int ext = actionBean.get("parm").get("parm").get("ext").asInt();
		// 是一条控制命令
//		if (cmd == 1) {
//			String eqpChaName = this.getEqpChaNameByResId(resId);
//			switch (type) {
//			// 开关量输出
//			case 1:// 此情况下mod无效
//					// 关闭设备
//				if (ext == 0) {
//					userAction += "关闭[" + eqpChaName + "].";
//				}
//				// 开启设备
//				if (ext == 1) {
//					userAction += "打开[" + eqpChaName + "].";
//				}
//				break;
//			// 空调控制
//			case 2:// mod有效,表示不同的控制命令
//				switch (mod) {
//				// 关闭
//				case 0:
//					userAction += "关闭" + "[" + eqpChaName + "].";
//					break;
//				// 制冷
//				case 1:
//					userAction += "使用[" + eqpChaName + "]制冷,设定温度:" + ext + "℃.";
//					break;
//				// 制热
//				case 2:
//					userAction += "使用[" + eqpChaName + "]制热,设定温度:" + ext + "℃.";
//					break;
//				// 除湿
//				case 3:
//					userAction += "使用[" + eqpChaName + "]除湿.";
//					break;
//				default:
//					break;
//				}
//				break;
//			default:
//				break;
//			}
//		}
//		int rst = resultBean.get("rst").asInt();
//		switch (rst) {
//		case 0:
//			userAction += "操作成功.";
//			break;
//		case 1:
//			userAction += "操作失败,原因:资源不可控.";
//			break;
//		default:
//			userAction += "控制失败.";
//			break;
//		}
		return userAction;
	}

	
	//提供给用户操作逻辑调用的日志写入方法
	public void recordUserLogByNodeControl(JsonNode actionBean,JsonNode resultBean) {

		UserLog log = recordUserLog();
		String userAction = this.getUserActionByNodeControl(actionBean,
				resultBean);
		log.setUserAction(userAction);
		userLogUtil.addUserLogToDB(log);
	}

	// 提供给云台控制调用的日志写入方法
	public void recordUserLogByPtzControl(JsonNode jsonNode, JsonNode resultNode) {
		UserLog log = recordUserLog();
		String userAction = this
				.getUserActionByPtzControl(jsonNode, resultNode);
		log.setUserAction(userAction);
		// 获得下发协议的用户行为
		int action = jsonNode.get("parm").get("action").asInt();
		// preUserAction默认为0，action字段恒大于0,判断用户行为为转动云台并且跟上一次接收到的行为不一致时将该条数据写入数据库
		if (action != preUserAction || action >= 9) {
			userLogUtil.addUserLogToDB(log);
		}
		// 记录最近一次的用户行为
		preUserAction = action;
	}

	// 生成云台控制的行为
	private String getUserActionByPtzControl(JsonNode jsonNode,
			JsonNode resultNode) {
		String userAction = "尝试";
//		// 获得命令标识字段
//		int cmd = jsonNode.get("cmd").asInt();
//		// 获得实际资源的ID
//		int resid = jsonNode.get("parm").get("resid").asInt();
//		// 获得行为的ID
//		int action = jsonNode.get("parm").get("action").asInt();
//		// 获得其中的value字段
//		int value = jsonNode.get("parm").get("value").asInt();
//
//		int rst = resultNode.get("rst").asInt();

		// 判断这是一条合法的云台控制命令
//		if (cmd == 103) {
//			String eqpChaName = this.getEqpChaNameByResId(resid);
//			switch (action) {// action的不同意味着不同的控制操作
//			// 转动，方向：上
//			case 1:
//				userAction += "向上转动设备[" + eqpChaName + "].";
//				break;
//			// 转动，方向：下
//			case 2:
//				userAction += "向下转动设备[" + eqpChaName + "].";
//				break;
//			// 转动，方向：左
//			case 3:
//				userAction += "向左转动设备[" + eqpChaName + "].";
//				break;
//			// 转动，方向：右
//			case 4:
//				userAction += "向右转动设备[" + eqpChaName + "].";
//				break;
//			// 转动，方向：左上
//			case 5:
//				userAction += "向左上方转动设备[" + eqpChaName + "].";
//				break;
//			// 转动，方向：右上
//			case 6:
//				userAction += "向右上方转动设备[" + eqpChaName + "].";
//				break;
//			// 转动，方向：左下
//			case 7:
//				userAction += "向左下方转动设备[" + eqpChaName + "].";
//				break;
//			// 转动，方向：右下
//			case 8:
//				userAction += "向右下方转动设备[" + eqpChaName + "].";
//				break;
//			// 预置点设定
//			case 9:
//				userAction += "设定设备[" + eqpChaName + "]" + value + "号预置点.";
//				break;
//			// 预置点清除
//			case 10:
//				userAction += "清除设备[" + eqpChaName + "]" + value + "号预置点.";
//				break;
//			// 预置点调用
//			case 11:
//				userAction += "调用设备[" + eqpChaName + "]" + value + "号预置点.";
//				break;
//			// 放大
//			case 12:
//				userAction += "放大设备[" + eqpChaName + "]图像.";
//				break;
//			// 缩小
//			case 13:
//				userAction += "缩小设备[" + eqpChaName + "]图像.";
//				break;
//			default:
//				break;
//			}
//			switch (rst) {
//			case 0:
//				userAction += "操作成功.";
//				break;
//			case 1:
//				userAction += "操作失败,原因:未找到设备.";
//				break;
//			default:
//				userAction += "控制失败.";
//				break;
//			}
//		}

		return userAction;
	}
	
	public void callRecordUserLog(String request,String response){
		request = request.trim();
		response = response.trim();
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode requestJsonNode = objectMapper.readValue(request, JsonNode.class);
			JsonNode responseJsonNode = objectMapper.readValue(response, JsonNode.class);
			int cmd = requestJsonNode.get("cmd").asInt();
			switch (cmd) {
				case 1://灯光，风机开关,空调控制
					this.recordUserLogByNodeControl(requestJsonNode, responseJsonNode);
					break;
				case 103://云台控制
					this.recordUserLogByPtzControl(requestJsonNode, responseJsonNode);
					break;
	
				default:
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
