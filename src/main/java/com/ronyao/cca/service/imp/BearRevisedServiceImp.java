package com.ronyao.cca.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ronyao.cca.constant.ConstAnnualOutput;
import com.ronyao.cca.constant.ConstProjectBuild;
import com.ronyao.cca.db.dao.BehaviorMapper;
import com.ronyao.cca.db.dao.EnterpriseMapper;
import com.ronyao.cca.db.dao.ProjectBuildMapper;
import com.ronyao.cca.db.model.AnnualOutput;
import com.ronyao.cca.db.model.Behavior;
import com.ronyao.cca.db.model.BehaviorExample;
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.EnterpriseExample;
import com.ronyao.cca.db.model.ProjectBuild;
import com.ronyao.cca.db.model.ProjectBuildExample;
import com.ronyao.cca.service.Bear;
import com.ronyao.cca.service.BearRevisedService;
import com.ronyao.cca.service.dto.BearResultDto;
import com.ronyao.cca.tool.DateUtil;
import com.ronyao.cca.ui.vo.BearProjectBuildVo;
import com.ronyao.cca.ui.vo.OutputConstrastVo;
import com.ronyao.cca.ui.vo.ProjectConstrastVo;

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
	
	@Resource
	private ProjectBuildMapper  projectBuildMapper;
	
	
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

	public List<ProjectConstrastVo> getBearConstrastProjectNum() {
		List<ProjectConstrastVo>  projectConstratVoList=new ArrayList<ProjectConstrastVo>();
		List<BearResultDto>  brList=getBearBadBehaviorRevised() ;
		if(!brList.isEmpty()){
			for (BearResultDto bearResultDto : brList) {
				ProjectConstrastVo vo=new ProjectConstrastVo();
				
				vo.setEnterpriseName(bearResultDto.getEnterpriseName());
				vo.setSupervisorunit(bearResultDto.getSupervisorunit());
				
				vo.setProjectNumSum110kv(bearResultDto.getLine110kv()+bearResultDto.getPower110kv());
				vo.setProejctNumSum220kv(bearResultDto.getLine220kv()+bearResultDto.getPower220kv());
				vo.setProjectNumSum500kv(bearResultDto.getLine500kv()+bearResultDto.getPower500kv());
				vo.setProjectNumSum(vo.getProjectNumSum110kv()+vo.getProejctNumSum220kv()+vo.getProjectNumSum500kv());
				
				vo.setTreeYearProjectAverage(Math.round(bearResultDto.getTreeYearProject()/3));
				
				vo.setConstrast(vo.getProjectNumSum()-vo.getTreeYearProjectAverage());
				
				projectConstratVoList.add(vo);
			}
		}
		return projectConstratVoList;
	}

	public List<OutputConstrastVo> getBearConstrastOutput() {
		List<OutputConstrastVo>  ocList=new ArrayList<OutputConstrastVo>();
		List<BearResultDto>  brList=getBearBadBehaviorRevised() ;
		if(!brList.isEmpty()){
			for (BearResultDto bearResultDto : brList) {
				OutputConstrastVo vo=new OutputConstrastVo();
				
				vo.setEnterpriseName(bearResultDto.getEnterpriseName());
				vo.setSupervisorunit(bearResultDto.getSupervisorunit());
				
				vo.setOutputSum(bearResultDto.getOutputSum());
				vo.setTreeYearOutputAverage(Math.round(bearResultDto.getTreeYearOutput()/3));
				
				vo.setConstrast(vo.getOutputSum()-vo.getTreeYearOutputAverage());
				
				ocList.add(vo);
			}
		}
		return ocList;
				
		
	}

	public List<BearProjectBuildVo> getBearProjectBuild() {
		  List<BearProjectBuildVo> bearProjectBuildVoList=new ArrayList<BearProjectBuildVo>();
			
			//获取施工企业当年已中标项目
			ProjectBuildExample  bpExample=new ProjectBuildExample();
			String  yearStr=DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT4);
			bpExample.createCriteria().andYearEqualTo(Integer.parseInt(yearStr));
			List<ProjectBuild>  pbList=projectBuildMapper.selectByExample(bpExample);
			Map<String, ProjectBuild>  pbMap=new HashMap<String, ProjectBuild>();
		
			if(!pbList.isEmpty()){
				for (ProjectBuild projectBuild : pbList) {
					pbMap.put(projectBuild.getEnterpriseid()+""+projectBuild.getClassify(), projectBuild);	
				}
			}
			
			
			//获取当前年份修正后承载能力(施工企业修正后承载结果-当年在建工程数-当年中标还未开工的项目数)
			List<BearResultDto>  brList=getBearBadBehaviorRevised() ;
			if(!brList.isEmpty()){
				
				for (BearResultDto bearResultDto : brList) {
					BearProjectBuildVo vo=new BearProjectBuildVo();
					
					vo.setEnterpriseName(bearResultDto.getEnterpriseName());
					vo.setSupervisorunit(bearResultDto.getSupervisorunit());
					
					//当年仍未完成的中标项目
					Integer  line110kvbid=0;
					Integer  line220kvbid=0;
					Integer  line500kvbid=0;
					Integer  power110kvbid=0;
					Integer  power220kvbid=0;
					Integer  power500kvbid=0;
					ProjectBuild   pbBuilding=pbMap.get(bearResultDto.getEnterpriseid()+""+ConstProjectBuild.CLASSIFY_BUILDING);
					ProjectBuild   pbNoBuilding=pbMap.get(bearResultDto.getEnterpriseid()+""+ConstProjectBuild.CLASSIFY_NO_BUILD);
					if(pbBuilding!=null  ){
						line110kvbid=line110kvbid+pbBuilding.getLine110kv();
						line220kvbid=line220kvbid+pbBuilding.getLine220kv();
						line500kvbid=line500kvbid+pbBuilding.getLine500kv();
						power110kvbid=power110kvbid+pbBuilding.getPower110kv();
						power220kvbid=power220kvbid+pbBuilding.getPower220kv();
						power500kvbid=power500kvbid+pbBuilding.getPower500kv();
					}
					if(pbNoBuilding!=null){
						line110kvbid=line110kvbid+pbNoBuilding.getLine110kv();
						line220kvbid=line220kvbid+pbNoBuilding.getLine220kv();
						line500kvbid=line500kvbid+pbNoBuilding.getLine500kv();
						power110kvbid=power110kvbid+pbNoBuilding.getPower110kv();
						power220kvbid=power220kvbid+pbNoBuilding.getPower220kv();
						power500kvbid=power500kvbid+pbNoBuilding.getPower500kv();
					}
					
					//计算实际施工企业当年还可以承载的项目数(规则: 高电压可以完成低电压不足完成的项目,低电压无法完成高电压项目,当低电压还可承载数量负数时,可以由还可承载的高电压进行填补)
					//---------------------------------------线路工程--------------------------------
					Integer line500kv=bearResultDto.getLine500kv()-line500kvbid;
					if(line500kv<0){
						line500kv=0;
					}
					Integer line220kv=bearResultDto.getLine220kv()-line220kvbid;
					if(line220kv<0  ){
						line220kv=line220kv+line500kv;
						if(line220kv>0){
							line500kv=line220kv;
						}else{
							line500kv=0;
						}
						
						line220kv=0;
					}
					
					Integer line110kv=bearResultDto.getLine110kv()-line110kvbid;
					if(line110kv<0 ){
						
						if(line220kv>0 &&  (line110kv+line220kv)>0){
							
							line220kv=line110kv+line220kv;
						}else if(line220kv >0 && (line110kv+line220kv) <=0){
				
							line220kv=0;
						}else if(line500kv >0 &&  (line110kv+line500kv)>0){
						
							line500kv=line110kv+line500kv;
						}else if(line500kv >0 &&  (line110kv+line500kv)<=0){
							
							line500kv=0;
						}
						
						line110kv=0;
						
					}
//					
					//------------------------------------变电工程----------------------------------
					
					Integer power500kv=bearResultDto.getPower500kv()-power500kvbid;
					if(power500kv<0){
						power500kv=0;
					}
					
					Integer power220kv=bearResultDto.getPower220kv()-power220kvbid;
					if(power220kv<0  ){
						power220kv=power220kv+power500kv;
						if(power220kv>0){
							power500kv=power220kv;
						}else{
							power500kv=0;
						}
						
						power220kv=0;
					}
					
					Integer power110kv=bearResultDto.getPower110kv()-power110kvbid;
					if(power110kv<0){
						
						if(power220kv>0 &&  (power110kv+power220kv)>0){
							
							power220kv=power110kv+power220kv;
						}else if(power220kv >0 && (power110kv+power220kv) <=0){
				
							power220kv=0;
						}else if(power500kv >0 &&  (power110kv+power500kv)>0){
						
							power500kv=power110kv+power500kv;
						}else if(power500kv >0 &&  (power110kv+power500kv)<=0){
							
							power500kv=0;
						}
						
						power110kv=0;
						
					}
					

					
					
					vo.setLine110kv(line110kv);
					vo.setLine220kv(line220kv);
					vo.setLine500kv(line500kv);
					vo.setPower110kv(power110kv);
					vo.setPower220kv(power220kv);
					vo.setPower500kv(power500kv);	
					
					
					bearProjectBuildVoList.add(vo);
				}
			}
			
			return bearProjectBuildVoList;
	}

}
