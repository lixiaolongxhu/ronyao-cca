package com.ronyao.cca.service;

import java.util.List;

import com.ronyao.cca.service.dto.BearResultDto;

/**不良行为修正
 * 
 * @author user
 *
 */
public interface BearRevisedService {

	

	/**获取施工企业不良行为修改后承载项目结果
	 * 
	 * @return
	 */
	public List<BearResultDto>  getBearBadBehaviorRevised();
	
}
