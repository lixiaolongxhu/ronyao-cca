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
import com.ronyao.cca.ui.vo.BearProjectBuildVo;




/**施工企业还可以承载项目情况
 * 
 * @author user
 *
 */
@Service
public class ActionProjectBuildBear {
	
	
//	private static final  Logger  LOG=LoggerFactory.getLogger(ActionBear.class);
	
	@Resource
	private BearRevisedService bearRevisedService;
	

	
	private List<BearProjectBuildVo>  bearProjectBuildVoList;
	
	public List<BearProjectBuildVo>  getBearProjectBuildVoList(){
		if(bearProjectBuildVoList==null){
			bearProjectBuildVoList=bearRevisedService.getBearProjectBuild();
		}
		
		return bearProjectBuildVoList;
	}
	 
	/**获取施工企业还可以承载的项目情况(计算范围: 系统当前年份)
	 * 
	 * @param request
	 * @return
	 */
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<BearProjectBuildVo> read(
			ExtDirectStoreReadRequest request) {
		bearProjectBuildVoList=bearRevisedService.getBearProjectBuild();
		return new ExtDirectStoreReadResult<BearProjectBuildVo>(bearProjectBuildVoList);
		
	}
	
	

}
