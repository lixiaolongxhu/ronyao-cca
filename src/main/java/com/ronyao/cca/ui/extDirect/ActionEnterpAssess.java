package com.ronyao.cca.ui.extDirect;



import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;
import com.ronyao.cca.db.dao.EnterpriseAssessMapper;
import com.ronyao.cca.db.model.EnterpriseAssess;
import com.ronyao.cca.db.model.EnterpriseAssessExample;
import com.ronyao.cca.service.BearRevisedService;
import com.ronyao.cca.service.dto.BearResultDto;
import com.ronyao.cca.tool.DateUtil;


/**施工企业评估分类
 * 
 * @author user
 *
 */
@Service
public class ActionEnterpAssess {
	
	
	private static final  Logger  LOG=LoggerFactory.getLogger(ActionEnterpAssess.class);
	
	@Autowired
	private  EnterpriseAssessMapper  enterpriseAssessMapper ;
	
	@Resource
	private BearRevisedService  bearRevisedService;
	
	private List<EnterpriseAssess>  enerpriseAssessList=null;
	
	public List<EnterpriseAssess> getEnterpriseAssessList(){
		if(enerpriseAssessList==null){
			setEntepriseAssessList();
		}
		return enerpriseAssessList;
	}
	
	public void setEntepriseAssessList(){
		EnterpriseAssessExample eExample = new EnterpriseAssessExample();
		enerpriseAssessList=enterpriseAssessMapper.selectByExample(eExample);
		List<BearResultDto>    bearResultDtoList=bearRevisedService.getBearBadBehaviorRevised();
		if(!enerpriseAssessList.isEmpty()  &&  !bearResultDtoList.isEmpty()  ){
			for (EnterpriseAssess ea : enerpriseAssessList) {
				//将亿元单位的产值转化为万元
				Float  outputstart=0f;
				if(ea.getOutputstart()!= null){
					outputstart=ea.getOutputstart().floatValue();
				}
				Float  outputStartMillion=10000*outputstart.floatValue();
				Float  outputend=0f;
				if(ea.getOutputend()!=null){
					outputend=ea.getOutputend().floatValue();
				}
				Float  outputEndMillion=10000*outputend;
				Integer  projectnumend=0;
				if(ea.getProjectnumend()!=null){
					projectnumend=ea.getProjectnumend();
				}
				StringBuilder  enterprise=new StringBuilder("");
				for (BearResultDto bearResultDto : bearResultDtoList) {
					
					if(bearResultDto.getProjectSum() <ea.getProjectnumstart()){
						continue;
					}
					if(  projectnumend!=0  &&  bearResultDto.getProjectSum()>ea.getProjectnumend()){
						continue;
					}
					if(bearResultDto.getOutputSum() < outputStartMillion){
						continue;
					}
					if( outputEndMillion!=0 &&  bearResultDto.getOutputSum()  > outputEndMillion){
						continue;
					}
					enterprise.append(bearResultDto.getEnterpriseName()+",");
				}
				ea.setEnterprise(enterprise.toString());
			}
		}
	}
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EnterpriseAssess> read(
			ExtDirectStoreReadRequest request) {
		setEntepriseAssessList();
		return new ExtDirectStoreReadResult<EnterpriseAssess>(enerpriseAssessList);
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EnterpriseAssess> create(List<EnterpriseAssess> enterprisePerStaList) {
		EnterpriseAssess  ep = enterprisePerStaList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		
		try{
			enterpriseAssessMapper.insert(ep);	
		}catch (Exception e){
			LOG.warn("施施工企业评估分类添加: 不允许添加重复的(类别),添加失败!");
		}
		
		return new ExtDirectStoreReadResult<EnterpriseAssess>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<EnterpriseAssess> enterprisePerStaList) {
		
		EnterpriseAssess  ep = enterprisePerStaList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));

		try{
			return enterpriseAssessMapper.updateByPrimaryKey(ep);
		}catch (Exception e){
			LOG.warn("施工企业评估分类修改: 不允许修改为已有的(类别),修改失败!");
			return 0;
		}
	}


	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<EnterpriseAssess> enterprisesAptitude) {
		return enterpriseAssessMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
