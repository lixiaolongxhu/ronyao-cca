package com.ronyao.cca.service;

import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.service.dto.BearResultDto;

/**施工企业承载力评估.
 * 
 * @author user
 *
 */
public interface Bear {

	/**计算企业承载能力分析,首先调用该方法进行初始配置
	 * 
	 */
	public  void loadInitConfig();



	/**获取施工企业人员承载最大项目数.
	 * 
	 * @param enterprise  企业id
	 * @return
	 */
	public  BearResultDto getEnterpriseBearResult(Enterprise  enterprise);
	
//	/**获取施工企业设备承载最大项目数.
//	 * 
//	 * @param enterpriseId  企业id
//	 * @return
//	 */
//	public Integer getEquipBearProjectNum(Integer  enterpriseId);

}
