package com.ronyao.cca.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ronyao.cca.constant.ConstAnnualOutput;
import com.ronyao.cca.db.dao.BehaviorMapper;
import com.ronyao.cca.db.dao.EnterpriseMapper;
import com.ronyao.cca.db.model.AnnualOutput;
import com.ronyao.cca.db.model.Behavior;
import com.ronyao.cca.db.model.BehaviorExample;
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.EnterpriseExample;
import com.ronyao.cca.service.Bear;
import com.ronyao.cca.service.BearRevisedService;
import com.ronyao.cca.service.dto.BearResultDto;
import com.ronyao.cca.tool.DateUtil;

/**不良行为修正
 * 
 * @author user
 *
 */
@Service
public class BearRevisedServiceImp implements BearRevisedService {
	
	@Resource
	private  Bear bear;
	
	@Resource
	private BehaviorMapper  behaviorMapper;
	
	@Resource
	
	private EnterpriseMapper  enterpriseMapper;
	
	/**获取施工企业修改后承载项目结果
	 * 
	 * @return
	 */
	public List<BearResultDto>  getBearBadBehaviorRevised(){
		
		List<BearResultDto>  resultList=new ArrayList<BearResultDto>();
		
		EnterpriseExample  enterExample=new EnterpriseExample();
		List<Enterprise>  enterList=enterpriseMapper.selectByExample(enterExample);
		
		if(!enterList.isEmpty()){
			bear.loadInitConfig();
			for (Enterprise enterprise : enterList) {
				BearResultDto result=bear.getEnterpriseBearResult(enterprise);
				if(result!=null){
					resultList.add(result);
				}
				
			}
		}
		
		//查询企业的修改系数
		BehaviorExample  bexample=new BehaviorExample();
		String yearStr=DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT4);
		Integer year=Integer.parseInt(yearStr)-1;
		bexample.createCriteria().andYearEqualTo(year);
		List<Behavior> bList=behaviorMapper.selectByExample(bexample);
		Map<Integer , Float>  bmap=new HashMap<Integer, Float>();
		if(bList.isEmpty()){
			return resultList;
		}else{
			for (Behavior behavior : bList) {
				bmap.put(behavior.getEnterpriseid(), behavior.getCorrection().floatValue());
			}
		}
		
		//重新设置承载项目数 ,  计算结果四舍五入
		 Map<String, AnnualOutput> outputmap=bear.getAnnualOutPutConfig();
		if(!resultList.isEmpty()){
			for (BearResultDto result : resultList) {
				Integer  eid=result.getEnterpriseid();
				
				//获取企业对应的不良系数,如果不存在,默认为1
				Float  bCorrect=bmap.get(eid);
				if(bCorrect==null){
					bCorrect=1f;
				}
				result.setLine110kv(Math.round(result.getLine110kv()*bCorrect));
				result.setLine220kv(Math.round(result.getLine220kv()*bCorrect));
				result.setLine500kv(Math.round(result.getLine500kv()*bCorrect));
				//线路工程年产值合计
				Integer lineProjectOutput=
								outputmap.get(500+""+ConstAnnualOutput.LINE_PROJECT).getAnnualoutput()*result.getLine500kv()
								+outputmap.get(220+""+ConstAnnualOutput.LINE_PROJECT).getAnnualoutput()*result.getLine220kv()
								+outputmap.get(110+""+ConstAnnualOutput.LINE_PROJECT).getAnnualoutput()*result.getLine110kv();	
				result.setLineOutput(lineProjectOutput);
				result.setLineProjectSum(result.getLine110kv()+result.getLine220kv()+result.getLine500kv());
				
				result.setPower110kv(Math.round(result.getPower110kv()*bCorrect));
				result.setPower220kv(Math.round(result.getPower220kv()*bCorrect));
				result.setPower500kv(Math.round(result.getPower500kv()*bCorrect));
				//变电工程年产值合计
				Integer powerProjectOutput=
										outputmap.get(500+""+ConstAnnualOutput.POWER_PROJECT).getAnnualoutput()*result.getPower500kv()
										+outputmap.get(220+""+ConstAnnualOutput.POWER_PROJECT).getAnnualoutput()*result.getPower220kv()
										+outputmap.get(110+""+ConstAnnualOutput.POWER_PROJECT).getAnnualoutput()*result.getPower110kv();
				result.setPowerProjectSum(result.getPower110kv()+result.getPower220kv()+result.getPower500kv());
			
				result.setPowerOutput(powerProjectOutput);
				
				result.setOutputSum(result.getLineOutput()+result.getPowerOutput());
				
				result.setProjectSum(result.getLineProjectSum()+result.getPowerProjectSum());
			}
		}
		
		
		return resultList;
	}

}
