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
import com.ronyao.cca.db.dao.EnterpriseMapper;
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.EnterpriseExample;
import com.ronyao.cca.tool.DateUtil;

/**企业基本信息.
 * 
 * @author user
 *
 */
@Service
public class ActionEnterp {
	
	private static final  Logger  LOG=LoggerFactory.getLogger(ActionEnterp.class);
	
	@Autowired
	EnterpriseMapper enterpriseMapper;
	
	/**查询信息列表
	 * 
	 */
	private  List<Enterprise> enterpriseList=null;
	 
	/**近三年项目数与产值求和
	 * 
	 * @param enterpirse
	 * @return
	 */
	private void sumProjectAndOutput(Enterprise enterprise){
		Integer sumProject=enterprise.getProjectlast()+enterprise.getProjectbefore()+enterprise.getProjectbeforelast();
		enterprise.setProject(sumProject);
		
		Integer sumOutput=enterprise.getOutputlast()+enterprise.getOutputbefore()+enterprise.getOutputbeforelast();
	
		enterprise.setOutput(sumOutput);
	}
	
	public List<Enterprise>  getEnterpriseList(){
		if(enterpriseList==null){
			EnterpriseExample eExample = new EnterpriseExample();
			enterpriseList=enterpriseMapper.selectByExample(eExample);
		}
		return enterpriseList;
	}
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<Enterprise> read(
			ExtDirectStoreReadRequest request) {
		LOG.debug("查询企业基本信息调用");
		EnterpriseExample eExample = new EnterpriseExample();
		enterpriseList=enterpriseMapper.selectByExample(eExample);
		return new ExtDirectStoreReadResult<Enterprise>(enterpriseList);
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<Enterprise> create(List<Enterprise> enterprise) {
		enterprise.get(0).setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		sumProjectAndOutput(enterprise.get(0));
		enterpriseMapper.insert(enterprise.get(0));
		return new ExtDirectStoreReadResult<Enterprise>(enterprise.get(0));
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<Enterprise> enterprise) {
		enterprise.get(0).setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		sumProjectAndOutput(enterprise.get(0));
		return enterpriseMapper.updateByPrimaryKey(enterprise.get(0));
	}

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<Enterprise> enterprises) {
		return enterpriseMapper.deleteByPrimaryKey(enterprises.get(0).getId());
	}
	

}
