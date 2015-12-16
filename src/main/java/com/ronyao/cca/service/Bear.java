package com.ronyao.cca.service;

import java.util.Map;

import com.ronyao.cca.db.model.AnnualOutput;
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
	
	/**项目对应电压等级的产值配置.
	 * 
	 * @return
	 */
	public     Map<String, AnnualOutput>   getAnnualOutPutConfig();

}
