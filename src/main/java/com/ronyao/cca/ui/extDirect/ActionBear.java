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
import com.ronyao.cca.db.dao.EnterpriseMapper;
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
	
	/**施工企业承载结果
	 * 
	 */
	private static  List<BearResultDto>  bearResultList=null;
	
	/**获取承载结果集
	 * 
	 * @return
	 */
	public    List<BearResultDto>  getBearResultList(){
		if(bearResultList==null){
			bearResultList=bear.getEnterpriseBearResult();
		}
		return  bearResultList;
	}
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<BearResultDto> read(
			ExtDirectStoreReadRequest request) {
		
		bearResultList=bear.getEnterpriseBearResult();
		return new ExtDirectStoreReadResult<BearResultDto>(bearResultList);
		
	}

	
	
	
	

}
