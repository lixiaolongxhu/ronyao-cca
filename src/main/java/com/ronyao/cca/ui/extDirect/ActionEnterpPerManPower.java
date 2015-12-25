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

import com.ronyao.cca.constant.ConstEnterprisePerMan;
import com.ronyao.cca.db.dao.EnterprisePerManageMapper;
import com.ronyao.cca.db.model.EnterprisePerManage;
import com.ronyao.cca.db.model.EnterprisePerManageExample;
import com.ronyao.cca.tool.DateUtil;


/**施工企业现场管理人员(变电专业)
 * 
 * @author user
 *
 */
@Service
public class ActionEnterpPerManPower {
	
	
	private static final  Logger  LOG=LoggerFactory.getLogger(ActionEnterpPerManPower.class);
	
	@Autowired
	private EnterprisePerManageMapper enterprisePerManageMapper;
	

	private List<EnterprisePerManage>  enterprisePerManageList;
	
	public List<EnterprisePerManage>  getEnterprisePerManageList(){
		if(enterprisePerManageList==null){
			EnterprisePerManageExample eExample = new EnterprisePerManageExample();
			eExample.createCriteria().andProfessiontypeEqualTo(ConstEnterprisePerMan.POWER_PROFESSION);
			enterprisePerManageList=enterprisePerManageMapper.selectByExample(eExample);
		}
		return enterprisePerManageList;
	}
 	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EnterprisePerManage> read(
			ExtDirectStoreReadRequest request) {
		EnterprisePerManageExample eExample = new EnterprisePerManageExample();
		eExample.createCriteria().andProfessiontypeEqualTo(ConstEnterprisePerMan.POWER_PROFESSION);
		enterprisePerManageList=enterprisePerManageMapper.selectByExample(eExample);
		return new ExtDirectStoreReadResult<EnterprisePerManage>(enterprisePerManageList);
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EnterprisePerManage> create(List<EnterprisePerManage> enterprisePerStaList) {
		EnterprisePerManage  ep = enterprisePerStaList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		ep.setProfessiontype(ConstEnterprisePerMan.POWER_PROFESSION);
		//人员合计
		ConstEnterprisePerMan.sum(ep);
		try{
			enterprisePerManageMapper.insert(ep);	
		}catch (Exception e){
			LOG.warn("施工企业现场人员添加: 不允许添加重复的(同一企业),添加失败!");
		}
		
		return new ExtDirectStoreReadResult<EnterprisePerManage>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<EnterprisePerManage> enterprisePerStaList) {
		
		EnterprisePerManage  ep = enterprisePerStaList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		ep.setProfessiontype(ConstEnterprisePerMan.POWER_PROFESSION);
		//人员合计
		ConstEnterprisePerMan.sum(ep);
		try{
			return enterprisePerManageMapper.updateByPrimaryKey(ep);
		}catch (Exception e){
			LOG.warn("施工企业现场人员修改: 不允许修改为已有的(同一企业),修改失败!");
			return 0;
		}
	}


	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<EnterprisePerManage> enterprisesAptitude) {
		return enterprisePerManageMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
