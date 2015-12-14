package com.ronyao.cca.ui.extDirect;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;
import com.ronyao.cca.db.dao.EnterprisePersonMapper;
import com.ronyao.cca.db.model.EnterprisePerson;
import com.ronyao.cca.db.model.EnterprisePersonExample;
import com.ronyao.cca.tool.DateUtil;

/**企业人员信息
 * 
 * @author user
 *
 */
@Service
public class ActionEnterpPer {
	@Autowired
	EnterprisePersonMapper enterprisePersonMapper;
	
	/**统计人员合计信息.
	 * 
	 * @param ep
	 */
	private void setPersonTotal(EnterprisePerson ep) {
		
			//国家注册师合计
			Byte  constructortotal=(byte) (ep.getConstructorone()+ep.getConstructortwo());
			ep.setConstructortotal(constructortotal);
			//中级以上职称人员合计
			Byte stafftotal=(byte) (ep.getStaffmiddle()+ep.getStaffhigh());
			ep.setStafftotal(stafftotal);
			//中级工以上技术人员
			Byte  skilltotal=(byte) (ep.getSkillhigh()+ep.getSkillmiddle()+ep.getSkilltech()+ep.getSkilltechhigh());
			ep.setSkilltotal(skilltotal);
		
	}

	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EnterprisePerson> read(
			ExtDirectStoreReadRequest request) {
		EnterprisePersonExample eExample = new EnterprisePersonExample();
		return new ExtDirectStoreReadResult<EnterprisePerson>(enterprisePersonMapper.selectByExample(eExample));
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EnterprisePerson> create(List<EnterprisePerson> enterprisePerList) {
		EnterprisePerson  ep = enterprisePerList.get(0);
	
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		
		setPersonTotal(ep);
		enterprisePersonMapper.insert(ep);
		return new ExtDirectStoreReadResult<EnterprisePerson>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<EnterprisePerson> enterprisePerList) {
		
		EnterprisePerson  ep = enterprisePerList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		
		setPersonTotal(ep);
		
		return enterprisePersonMapper.updateByPrimaryKey(ep);
	}

	

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<EnterprisePerson> enterprises) {
		return enterprisePersonMapper.deleteByPrimaryKey(enterprises.get(0).getId());
	}
	

}
