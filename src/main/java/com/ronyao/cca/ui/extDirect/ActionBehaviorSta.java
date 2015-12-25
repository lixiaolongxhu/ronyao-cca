package com.ronyao.cca.ui.extDirect;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;
import com.ronyao.cca.db.dao.BehaviorStandardMapper;
import com.ronyao.cca.db.model.BehaviorStandardExample;
import com.ronyao.cca.db.model.BehaviorStandardWithBLOBs;
import com.ronyao.cca.tool.DateUtil;

/**施工企业不良行为分类标准
 * 
 * @author user
 *
 */
@Service
public class ActionBehaviorSta {
	
	@Autowired
	private BehaviorStandardMapper behaviorStandardMapper;
	
	
	private List<BehaviorStandardWithBLOBs>  behaviorStandardsList;
	
	public List<BehaviorStandardWithBLOBs>  getBehaviorStandardsList(){
		if(behaviorStandardsList==null){
			BehaviorStandardExample eExample = new BehaviorStandardExample();
			behaviorStandardsList=behaviorStandardMapper.selectByExampleWithBLOBs(eExample);
		}
		return behaviorStandardsList;
	}
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<BehaviorStandardWithBLOBs> read(
			ExtDirectStoreReadRequest request) {
		BehaviorStandardExample eExample = new BehaviorStandardExample();
		behaviorStandardsList=behaviorStandardMapper.selectByExampleWithBLOBs(eExample);
		return new ExtDirectStoreReadResult<BehaviorStandardWithBLOBs>(behaviorStandardsList);
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<BehaviorStandardWithBLOBs> create(List<BehaviorStandardWithBLOBs> enterpriseAptList) {
		BehaviorStandardWithBLOBs  ep = enterpriseAptList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		behaviorStandardMapper.insert(ep);
		return new ExtDirectStoreReadResult<BehaviorStandardWithBLOBs>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<BehaviorStandardWithBLOBs> enterpriseAptList) {
		
		BehaviorStandardWithBLOBs  ep = enterpriseAptList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		return  behaviorStandardMapper.updateByPrimaryKeyWithBLOBs(ep);
	}

	

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<BehaviorStandardWithBLOBs> enterprisesAptitude) {
		return behaviorStandardMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
