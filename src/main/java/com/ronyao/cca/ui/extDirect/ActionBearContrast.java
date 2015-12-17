package com.ronyao.cca.ui.extDirect;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;
import com.ronyao.cca.service.BearRevisedService;
import com.ronyao.cca.service.dto.BearResultDto;
import com.ronyao.cca.ui.vo.OutputConstrastVo;
import com.ronyao.cca.ui.vo.ProjectConstrastVo;



/**施工企业承载能力评估(修改后结果),与近三年的项目数以及产值对比
 * 
 * @author user
 *
 */
@Service
public class ActionBearContrast {
	
	
//	private static final  Logger  LOG=LoggerFactory.getLogger(ActionBear.class);
	
	@Resource
	private BearRevisedService bearRevisedService;
	
	
	
	/**读取近三年项目数对比.
	 * 
	 * @param request
	 * @return
	 */
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<ProjectConstrastVo> readProjectNumConstrast(
			ExtDirectStoreReadRequest request) {
		List<ProjectConstrastVo>  pcList=new ArrayList<ProjectConstrastVo>();
		List<BearResultDto>  brList=bearRevisedService.getBearBadBehaviorRevised() ;
		if(!brList.isEmpty()){
			for (BearResultDto bearResultDto : brList) {
				ProjectConstrastVo vo=new ProjectConstrastVo();
				
				vo.setEnterpriseName(bearResultDto.getEnterpriseName());
				vo.setSupervisorunit(bearResultDto.getSupervisorunit());
				
				vo.setProjectNumSum110kv(bearResultDto.getLine110kv()+bearResultDto.getPower110kv());
				vo.setProejctNumSum220kv(bearResultDto.getLine220kv()+bearResultDto.getPower220kv());
				vo.setProjectNumSum500kv(bearResultDto.getLine500kv()+bearResultDto.getPower500kv());
				vo.setProjectNumSum(vo.getProjectNumSum110kv()+vo.getProejctNumSum220kv()+vo.getProjectNumSum500kv());
				
				vo.setTreeYearProjectAverage(Math.round(bearResultDto.getTreeYearProject()/3));
				
				vo.setConstrast(vo.getProjectNumSum()-vo.getTreeYearProjectAverage());
				
				pcList.add(vo);
			}
		}
		
		return new ExtDirectStoreReadResult<ProjectConstrastVo>(pcList);
		
	}


	/**读取近三年项目产值对比.
	 * 
	 * @param request
	 * @return
	 */
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<OutputConstrastVo> readProjectOutputConstrast(
			ExtDirectStoreReadRequest request) {
		List<OutputConstrastVo>  ocList=new ArrayList<OutputConstrastVo>();
		List<BearResultDto>  brList=bearRevisedService.getBearBadBehaviorRevised() ;
		if(!brList.isEmpty()){
			for (BearResultDto bearResultDto : brList) {
				OutputConstrastVo vo=new OutputConstrastVo();
				
				vo.setEnterpriseName(bearResultDto.getEnterpriseName());
				vo.setSupervisorunit(bearResultDto.getSupervisorunit());
				
				vo.setOutputSum(bearResultDto.getOutputSum());
				vo.setTreeYearOutputAverage(Math.round(bearResultDto.getTreeYearOutput()/3));
				
				vo.setConstrast(vo.getOutputSum()-vo.getTreeYearOutputAverage());
				
				ocList.add(vo);
			}
		}
		
		return new ExtDirectStoreReadResult<OutputConstrastVo>(ocList);
		
	}

	

}
