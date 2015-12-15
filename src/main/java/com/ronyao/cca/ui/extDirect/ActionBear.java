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
import com.ronyao.cca.db.dao.EnterpriseMapper;
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.EnterpriseExample;
import com.ronyao.cca.service.Bear;
import com.ronyao.cca.service.dto.BearResultDto;



/**施工企业承载能力评估
 * 
 * @author user
 *
 */
@Service
public class ActionBear {
	
	
//	private static final  Logger  LOG=LoggerFactory.getLogger(ActionBear.class);
	
	@Resource
	private Bear bear;
	
	@Resource
	
	private EnterpriseMapper  enterpriseMapper;
	
	
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<BearResultDto> read(
			ExtDirectStoreReadRequest request) {
		
		List<BearResultDto>  resultList=new ArrayList<BearResultDto>();
		
		EnterpriseExample  enterExample=new EnterpriseExample();
		List<Enterprise>  enterList=enterpriseMapper.selectByExample(enterExample);
		
		if(!enterList.isEmpty()){
			bear.loadInitConfig();
			for (Enterprise enterprise : enterList) {
				BearResultDto result=bear.getEnterpriseBearResult(enterprise);
				resultList.add(result);
			}
		}
		return new ExtDirectStoreReadResult<BearResultDto>(resultList);
		
	}

	
	

}
