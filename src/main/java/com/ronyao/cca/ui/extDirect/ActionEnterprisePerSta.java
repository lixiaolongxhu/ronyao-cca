package com.ronyao.cca.ui.extDirect;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;
import com.ronyao.cca.db.dao.EnterprisePerStandardMapper;
import com.ronyao.cca.db.model.EnterprisePerStandard;
import com.ronyao.cca.db.model.EnterprisePerStandardExample;
import com.ronyao.cca.tool.DateUtil;

/**企业自身主要人员评估(施工项目部人员构成).
 * 
 * @author user
 *
 */
@Service
public class ActionEnterprisePerSta {
	
	
	private static final  Logger  LOG=LoggerFactory.getLogger(ActionEnterprisePerSta.class);
	
	@Autowired
	private EnterprisePerStandardMapper enterprisePerStandardMapper;
	
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EnterprisePerStandard> read(
			ExtDirectStoreReadRequest request) {
		EnterprisePerStandardExample eExample = new EnterprisePerStandardExample();
		return new ExtDirectStoreReadResult<EnterprisePerStandard>(enterprisePerStandardMapper.selectByExample(eExample));
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EnterprisePerStandard> create(List<EnterprisePerStandard> enterprisePerStaList) {
		EnterprisePerStandard  ep = enterprisePerStaList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		try{
			enterprisePerStandardMapper.insert(ep);	
		}catch (Exception e){
			LOG.warn("企业自身主要人员评估(施工项目部人员构成)添加: 不允许添加重复的岗位,添加失败!");
		}
		
		return new ExtDirectStoreReadResult<EnterprisePerStandard>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<EnterprisePerStandard> enterprisePerStaList) {
		
		EnterprisePerStandard  ep = enterprisePerStaList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		try{
			return enterprisePerStandardMapper.updateByPrimaryKey(ep);
		}catch (Exception e){
			LOG.warn("企业自身主要人员评估(施工项目部人员构成)修改: 不允许修改为已有的岗位,修改失败!");
			return 0;
		}
	}

	

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<EnterprisePerStandard> enterprisesAptitude) {
		return enterprisePerStandardMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
