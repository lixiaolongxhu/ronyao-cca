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
import com.ronyao.cca.db.model.EnterpriseAptitudeWithBLOBs;
import com.ronyao.cca.tool.DateUtil;

/**企业资质标准分类表信息
 * 
 * @author user
 *
 */
@Service
public class ActionEnterpApt {
	
	@Autowired
	private EnterpriseAptitudeMapper enterprisAptitudeMaper;
	
	private List<EnterpriseAptitudeWithBLOBs> enterpriseAptitudeList=null;
	
	public List<EnterpriseAptitudeWithBLOBs> getEnterpriseAptitudeList(){
		if(enterpriseAptitudeList==null){
			EnterpriseAptitudeExample eExample = new EnterpriseAptitudeExample();
			enterpriseAptitudeList=enterprisAptitudeMaper.selectByExampleWithBLOBs(eExample);
		}
		return enterpriseAptitudeList;
	}
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EnterpriseAptitudeWithBLOBs> read(
			ExtDirectStoreReadRequest request) {
		EnterpriseAptitudeExample eExample = new EnterpriseAptitudeExample();
		enterpriseAptitudeList=enterprisAptitudeMaper.selectByExampleWithBLOBs(eExample);
		return new ExtDirectStoreReadResult<EnterpriseAptitudeWithBLOBs>(enterpriseAptitudeList);
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EnterpriseAptitude> create(List<EnterpriseAptitudeWithBLOBs> enterpriseAptList) {
		EnterpriseAptitudeWithBLOBs  ep = enterpriseAptList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		enterprisAptitudeMaper.insert(ep);
		return new ExtDirectStoreReadResult<EnterpriseAptitude>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<EnterpriseAptitudeWithBLOBs> enterpriseAptList) {
		
		EnterpriseAptitudeWithBLOBs  ep = enterpriseAptList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		return enterprisAptitudeMaper.updateByPrimaryKeyWithBLOBs(ep);
	}

	

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<EnterpriseAptitudeWithBLOBs> enterprisesAptitude) {
		return enterprisAptitudeMaper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
