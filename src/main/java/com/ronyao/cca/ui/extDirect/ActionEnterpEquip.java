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
import com.ronyao.cca.db.dao.EnterpriseEquipmentMapper;
import com.ronyao.cca.db.model.EnterpriseEquipment;
import com.ronyao.cca.db.model.EnterpriseEquipmentExample;
import com.ronyao.cca.tool.DateUtil;


/**施工企业装备
 * 
 * @author user
 *
 */
@Service
public class ActionEnterpEquip {
	
	
	private static final  Logger  LOG=LoggerFactory.getLogger(ActionEnterpEquip.class);
	
	@Autowired
	private EnterpriseEquipmentMapper enterpriseEquipmentMapper;
	
	private List<EnterpriseEquipment>  enterpriseEquipmentList=null;

	
	/**现场施工人员合计
	 * 
	 * @param ep
	 */
	private  void sum(EnterpriseEquipment ep){
		Integer sum=ep.getBigequipment()+ep.getSmallequipment();
				
		ep.setSum(sum);
	}
	
	
	public List<EnterpriseEquipment>  getEnterpriseEquipmentList(){
		if(enterpriseEquipmentList==null){
			EnterpriseEquipmentExample eExample = new EnterpriseEquipmentExample();
			enterpriseEquipmentList=enterpriseEquipmentMapper.selectByExample(eExample);
		}
		return enterpriseEquipmentList;
	}
	 
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EnterpriseEquipment> read(
			ExtDirectStoreReadRequest request) {
		EnterpriseEquipmentExample eExample = new EnterpriseEquipmentExample();
		enterpriseEquipmentList=enterpriseEquipmentMapper.selectByExample(eExample);
		return new ExtDirectStoreReadResult<EnterpriseEquipment>(enterpriseEquipmentList);
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EnterpriseEquipment> create(List<EnterpriseEquipment> enterprisePerStaList) {
		EnterpriseEquipment  ep = enterprisePerStaList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		//人员合计
		sum(ep);
		try{
			enterpriseEquipmentMapper.insert(ep);	
		}catch (Exception e){
			e.printStackTrace();
			LOG.warn("施工企业装备添加: 不允许添加重复的(同一企业),添加失败!");
		}
		
		return new ExtDirectStoreReadResult<EnterpriseEquipment>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<EnterpriseEquipment> enterprisePerStaList) {
		
		EnterpriseEquipment  ep = enterprisePerStaList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		//人员合计
		sum(ep);
		try{
			return enterpriseEquipmentMapper.updateByPrimaryKey(ep);
		}catch (Exception e){
			e.printStackTrace();
			LOG.warn("施工企业装备修改: 不允许修改为已有的(同一企业),修改失败!");
			return 0;
		}
	}


	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<EnterpriseEquipment> enterprisesAptitude) {
		return enterpriseEquipmentMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
