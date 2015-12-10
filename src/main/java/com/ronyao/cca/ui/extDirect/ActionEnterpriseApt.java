package com.ronyao.cca.ui.extDirect;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;
import com.ronyao.cca.db.dao.EnterpriseAptitudeMapper;
import com.ronyao.cca.db.model.EnterpriseAptitude;
import com.ronyao.cca.db.model.EnterpriseAptitudeExample;
import com.ronyao.cca.tool.DateUtil;

/**企业资质标准分类表信息
 * 
 * @author user
 *
 */
@Service
public class ActionEnterpriseApt {
	
	@Autowired
	private EnterpriseAptitudeMapper enterprisAptitudeMaper;
	
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EnterpriseAptitude> read(
			ExtDirectStoreReadRequest request) {
		EnterpriseAptitudeExample eExample = new EnterpriseAptitudeExample();
		eExample.setOrderByClause(" createTime desc ");
		return new ExtDirectStoreReadResult<EnterpriseAptitude>(enterprisAptitudeMaper.selectByExample(eExample));
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EnterpriseAptitude> create(List<EnterpriseAptitude> enterpriseAptList) {
		EnterpriseAptitude  ep = enterpriseAptList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		enterprisAptitudeMaper.insert(ep);
		return new ExtDirectStoreReadResult<EnterpriseAptitude>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<EnterpriseAptitude> enterpriseAptList) {
		
		EnterpriseAptitude  ep = enterpriseAptList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		return enterprisAptitudeMaper.updateByPrimaryKey(ep);
	}

	

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<EnterpriseAptitude> enterprisesAptitude) {
		return enterprisAptitudeMaper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
