package com.ronyao.cca.service;

import java.util.List;

import com.ronyao.cca.service.dto.BearResultDto;
import com.ronyao.cca.ui.vo.BearProjectBuildVo;
import com.ronyao.cca.ui.vo.OutputConstrastVo;
import com.ronyao.cca.ui.vo.ProjectConstrastVo;

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
	
	/**施工企业承载能力评估(修改后结果),与近三年的项目平均数对比
	 * 
	 * @return
	 */
	public  List<ProjectConstrastVo>  getBearConstrastProjectNum();
	
	/**施工企业承载能力评估(修改后结果),与近三年的产值平均数对比
	 * 
	 * @return
	 */
	public List<OutputConstrastVo>  getBearConstrastOutput();
	
	
	/**获取施工企业还可以承载项目情况
	 * 
	 * @return
	 */
	public List<BearProjectBuildVo>  getBearProjectBuild();
}
