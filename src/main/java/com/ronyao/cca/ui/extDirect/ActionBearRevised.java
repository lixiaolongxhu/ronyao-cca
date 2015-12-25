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
import com.ronyao.cca.service.dto.BearResultDto;



/**施工企业承载能力评估(修改后结果).
 * 
 * @author user
 *
 */
@Service
public class ActionBearRevised {
	
	
//	private static final  Logger  LOG=LoggerFactory.getLogger(ActionBear.class);
	
	@Resource
	private BearRevisedService bearRevisedService;
	
	
	private  List<BearResultDto>  bearRevisedList=null;
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<BearResultDto> read(
			ExtDirectStoreReadRequest request) {
		bearRevisedList=bearRevisedService.getBearBadBehaviorRevised();
		return new ExtDirectStoreReadResult<BearResultDto>(bearRevisedList);
		
	}



	public List<BearResultDto> getBearRevisedList() {
		if(bearRevisedList==null){
			bearRevisedList=bearRevisedService.getBearBadBehaviorRevised();
		}
		return bearRevisedList;
	}

	
	

}
