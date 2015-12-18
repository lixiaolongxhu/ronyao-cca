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

import com.ronyao.cca.constant.ConstProjectBuild;
import com.ronyao.cca.db.dao.ProjectBuildMapper;
import com.ronyao.cca.db.model.ProjectBuild;
import com.ronyao.cca.db.model.ProjectBuildExample;
import com.ronyao.cca.tool.DateUtil;


/**施工企业中标开工项目情况,  
 * 
 * @author user
 *
 */
@Service
public class ActionProejctBuild {
	
	
	private static final  Logger  LOG=LoggerFactory.getLogger(ActionProejctBuild.class);
	
	@Autowired
	private ProjectBuildMapper projectBuildMapper;
	
	//-------------------------------------未开工项目情况-----------------------
	
	// 列表
		@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
		public ExtDirectStoreReadResult<ProjectBuild> readNoBuild(
				ExtDirectStoreReadRequest request) {
			//获得前段传回参数的容器
			Map<String, Object> params = request.getParams();	
			//获得该Map的key集合
//			Set<String> keySet = params.keySet();
			
			Object  searchYearObj=params.get("searchYear");
			if(searchYearObj==null){
				searchYearObj=DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT4);
			}
			
			ProjectBuildExample eExample = new ProjectBuildExample();
			eExample.createCriteria().andYearEqualTo(Integer.parseInt(searchYearObj.toString()));
			return new ExtDirectStoreReadResult<ProjectBuild>(projectBuildMapper.selectByExample(eExample));
		}

		// 插入
		@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
		public ExtDirectStoreReadResult<ProjectBuild> createNoBuild(List<ProjectBuild> enterprisePerStaList) {
			ProjectBuild  ep = enterprisePerStaList.get(0);
			ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
			ep.setClassify(ConstProjectBuild.CLASSIFY_NO_BUILD);
			try{
				projectBuildMapper.insert(ep);	
			}catch (Exception e){
				LOG.warn("施工企业中标开工项目情况添加: 不允许添加重复的(企业,年份),添加失败!");
			}
			
			return new ExtDirectStoreReadResult<ProjectBuild>(ep);
			
		}

		// 修改
		@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
		public int updateNoBuild(List<ProjectBuild> enterprisePerStaList) {
			
			ProjectBuild  ep = enterprisePerStaList.get(0);
			ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
			try{
				return projectBuildMapper.updateByPrimaryKey(ep);
			}catch (Exception e){
				LOG.warn("施工企业中标开工项目情况情况修改: 不允许修改为已有的(企业,年份),修改失败!");
				return 0;
			}
		}


		// 删除
		@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
		public int destroyNoBuild(List<ProjectBuild> enterprisesAptitude) {
			return projectBuildMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
		}
	
	//--------------------------------------已开工项目情况------------------------
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<ProjectBuild> readBuilding(
			ExtDirectStoreReadRequest request) {
		//获得前段传回参数的容器
		Map<String, Object> params = request.getParams();	
		//获得该Map的key集合
//		Set<String> keySet = params.keySet();
		
		Object  searchYearObj=params.get("searchYear");
		if(searchYearObj==null){
			searchYearObj=DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT4);
		}
		
		ProjectBuildExample eExample = new ProjectBuildExample();
		eExample.createCriteria().andYearEqualTo(Integer.parseInt(searchYearObj.toString()));
		return new ExtDirectStoreReadResult<ProjectBuild>(projectBuildMapper.selectByExample(eExample));
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<ProjectBuild> createBuilding(List<ProjectBuild> enterprisePerStaList) {
		ProjectBuild  ep = enterprisePerStaList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		ep.setClassify(ConstProjectBuild.CLASSIFY_NO_BUILD);
		try{
			projectBuildMapper.insert(ep);	
		}catch (Exception e){
			LOG.warn("施工企业中标开工项目情况添加: 不允许添加重复的(企业,年份),添加失败!");
		}
		
		return new ExtDirectStoreReadResult<ProjectBuild>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int updateBuilding(List<ProjectBuild> enterprisePerStaList) {
		
		ProjectBuild  ep = enterprisePerStaList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		try{
			return projectBuildMapper.updateByPrimaryKey(ep);
		}catch (Exception e){
			LOG.warn("施工企业中标开工项目情况情况修改: 不允许修改为已有的(企业,年份),修改失败!");
			return 0;
		}
	}


	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroyBuilding(List<ProjectBuild> enterprisesAptitude) {
		return projectBuildMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
