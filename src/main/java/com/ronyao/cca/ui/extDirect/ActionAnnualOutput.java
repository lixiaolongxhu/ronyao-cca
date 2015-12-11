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
import com.ronyao.cca.db.dao.AnnualOutputMapper;
import com.ronyao.cca.db.model.AnnualOutput;
import com.ronyao.cca.db.model.AnnualOutputExample;
import com.ronyao.cca.tool.DateUtil;


/**施工项目年产值评估标准表配置
 * 
 * @author user
 *
 */
@Service
public class ActionAnnualOutput {
	
	
	private static final  Logger  LOG=LoggerFactory.getLogger(ActionAnnualOutput.class);
	
	@Autowired
	private AnnualOutputMapper annulaOutputMapper;
	
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<AnnualOutput> read(
			ExtDirectStoreReadRequest request) {
		AnnualOutputExample eExample = new AnnualOutputExample();
		return new ExtDirectStoreReadResult<AnnualOutput>(annulaOutputMapper.selectByExample(eExample));
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<AnnualOutput> create(List<AnnualOutput> enterprisePerStaList) {
		AnnualOutput  ep = enterprisePerStaList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		try{
			annulaOutputMapper.insert(ep);	
		}catch (Exception e){
			LOG.warn("施工项目年产值评估标准表配置信息添加: 不允许添加重复的(电压等级,项目工程类别),添加失败!");
		}
		
		return new ExtDirectStoreReadResult<AnnualOutput>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<AnnualOutput> enterprisePerStaList) {
		
		AnnualOutput  ep = enterprisePerStaList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		try{
			return annulaOutputMapper.updateByPrimaryKey(ep);
		}catch (Exception e){
			LOG.warn("施工项目年产值评估标准表配置信息修改: 不允许修改为已有的(电压等级,项目工程类别),修改失败!");
			return 0;
		}
	}


	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<AnnualOutput> enterprisesAptitude) {
		return annulaOutputMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
