package com.ronyao.cca.ui.extDirect;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;
import com.ronyao.cca.db.dao.ProjectPlainMapper;
import com.ronyao.cca.db.model.ProjectPlain;
import com.ronyao.cca.db.model.ProjectPlainExample;
import com.ronyao.cca.tool.DateUtil;


/**下一年新将要开工的项目情况.
 * 
 * @author user
 *
 */
@Service
public class ActionProjectPlain {
	
	
	private static final  Logger  LOG=LoggerFactory.getLogger(ActionProjectPlain.class);
	
	@Autowired
	private ProjectPlainMapper projectPlainMapper;
	
	private List<ProjectPlain> projectPlainList=null;
	
	public List<ProjectPlain>  getProjectPlainList(){
		return projectPlainList;
	}
	
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<ProjectPlain> read(
			ExtDirectStoreReadRequest request) {
		//获得前段传回参数的容器
		Map<String, Object> params = request.getParams();	
		//获得该Map的key集合
//		Set<String> keySet = params.keySet();
		
		Object  searchYearObj=params.get("searchYear");
		if(searchYearObj==null){
			searchYearObj=DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT4);
		}
		
		ProjectPlainExample eExample = new ProjectPlainExample();
		eExample.createCriteria().andYearEqualTo(Integer.parseInt(searchYearObj.toString()));
		projectPlainList=projectPlainMapper.selectByExample(eExample);
		return new ExtDirectStoreReadResult<ProjectPlain>(projectPlainList);
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<ProjectPlain> create(List<ProjectPlain> enterprisePerStaList) {
		ProjectPlain  ep = enterprisePerStaList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		try{
			projectPlainMapper.insert(ep);	
		}catch (Exception e){
			LOG.warn("下一年新将要开工的项目情况添加: 不允许添加重复的(电压等级,年份),添加失败!");
		}
		
		return new ExtDirectStoreReadResult<ProjectPlain>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<ProjectPlain> enterprisePerStaList) {
		
		ProjectPlain  ep = enterprisePerStaList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		try{
			return projectPlainMapper.updateByPrimaryKey(ep);
		}catch (Exception e){
			LOG.warn("下一年新将要开工的项目情况修改: 不允许修改为已有的(电压等级,年份),修改失败!");
			return 0;
		}
	}


	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<ProjectPlain> enterprisesAptitude) {
		return projectPlainMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
