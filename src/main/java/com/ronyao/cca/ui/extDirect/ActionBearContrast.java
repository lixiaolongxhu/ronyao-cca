package com.ronyao.cca.ui.extDirect;




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
import com.ronyao.cca.ui.vo.OutputConstrastVo;
import com.ronyao.cca.ui.vo.ProjectConstrastVo;



/**施工企业承载能力评估(修改后结果),与近三年的项目数以及产值的平均值对比
 * 
 * @author user
 *
 */
@Service
public class ActionBearContrast {
	
	
//	private static final  Logger  LOG=LoggerFactory.getLogger(ActionBear.class);
	
	@Resource
	private BearRevisedService bearRevisedService;
	
	private  List<ProjectConstrastVo>  projectConstratVoList;
	
	private  List<OutputConstrastVo>   outputConstrastVoList;
	
	
	
	public List<ProjectConstrastVo>  getProjectConstratVoList(){
		if(projectConstratVoList==null){
			projectConstratVoList=bearRevisedService.getBearConstrastProjectNum();
		}
		return projectConstratVoList;
	}
	
	/**读取近三年项目数对比.
	 * 
	 * @param request
	 * @return
	 */
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<ProjectConstrastVo> readProjectNumConstrast(
			ExtDirectStoreReadRequest request) {
		projectConstratVoList=bearRevisedService.getBearConstrastProjectNum();
		return new ExtDirectStoreReadResult<ProjectConstrastVo>(projectConstratVoList);
		
	}
	
	public List<OutputConstrastVo>  getOutputConstrastVoList(){
		if(outputConstrastVoList==null){
			outputConstrastVoList=bearRevisedService.getBearConstrastOutput();
		}
		return outputConstrastVoList;
	}


	/**读取近三年项目产值对比.
	 * 
	 * @param request
	 * @return
	 */
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<OutputConstrastVo> readProjectOutputConstrast(
			ExtDirectStoreReadRequest request) {
		
		outputConstrastVoList=bearRevisedService.getBearConstrastOutput();
		return new ExtDirectStoreReadResult<OutputConstrastVo>(outputConstrastVoList);
		
	}

	

}
