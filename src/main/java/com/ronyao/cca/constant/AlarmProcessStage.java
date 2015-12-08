/*
 * 告警处理中器各个不同的阶段常量
 */
package com.ronyao.cca.constant;

public interface AlarmProcessStage {
	

	public int ALM_CREATED = 1;	 	// 新建立告警对象，查找联动数据，、存储、转发, 并进行联动
	public int ALM_ACTION = 2; 		// 告警联动正在处理当中
	public int ALM_RUNING = 3; 		// 告警联动处理完成，正在延时等待反向动作的操作
	public int ALM_REACTION = 4; 	// 告警联动反向动作处理当中
	public int ALM_END = 5; 			// 告警处理完成

}
