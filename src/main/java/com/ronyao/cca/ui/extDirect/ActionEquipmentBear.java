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
import com.ronyao.cca.db.dao.EquipmentBearMapper;
import com.ronyao.cca.db.model.EquipmentBear;
import com.ronyao.cca.db.model.EquipmentBearExample;
import com.ronyao.cca.tool.DateUtil;


/**张牵设备承载力配置信息.
 * 
 * @author user
 *
 */
@Service
public class ActionEquipmentBear {
	
	
	private static final  Logger  LOG=LoggerFactory.getLogger(ActionEquipmentBear.class);
	
	@Autowired
	private EquipmentBearMapper equipmentBearMapper;
	
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EquipmentBear> read(
			ExtDirectStoreReadRequest request) {
		EquipmentBearExample eExample = new EquipmentBearExample();
		return new ExtDirectStoreReadResult<EquipmentBear>(equipmentBearMapper.selectByExample(eExample));
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EquipmentBear> create(List<EquipmentBear> enterprisePerStaList) {
		EquipmentBear  ep = enterprisePerStaList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		try{
			equipmentBearMapper.insert(ep);	
		}catch (Exception e){
			LOG.warn("张牵设备承载力配置信息添加: 不允许添加重复的(电压等级,线路方式),添加失败!");
		}
		
		return new ExtDirectStoreReadResult<EquipmentBear>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<EquipmentBear> enterprisePerStaList) {
		
		EquipmentBear  ep = enterprisePerStaList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		try{
			return equipmentBearMapper.updateByPrimaryKey(ep);
		}catch (Exception e){
			LOG.warn("张牵设备承载力配置信息修改: 不允许修改为已有的(电压等级,线路方式),修改失败!");
			return 0;
		}
	}


	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<EquipmentBear> enterprisesAptitude) {
		return equipmentBearMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
