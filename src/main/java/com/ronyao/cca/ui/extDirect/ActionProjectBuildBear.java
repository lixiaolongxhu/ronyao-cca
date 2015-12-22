package com.ronyao.cca.ui.extDirect;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;
import com.ronyao.cca.constant.ConstProjectBuild;
import com.ronyao.cca.db.dao.ProjectBuildMapper;
import com.ronyao.cca.db.model.ProjectBuild;
import com.ronyao.cca.db.model.ProjectBuildExample;
import com.ronyao.cca.service.BearRevisedService;
import com.ronyao.cca.service.dto.BearResultDto;
import com.ronyao.cca.tool.DateUtil;
import com.ronyao.cca.ui.vo.BearProjectBuildVo;




/**施工企业还可以承载项目情况
 * 
 * @author user
 *
 */
@Service
public class ActionProjectBuildBear {
	
	
//	private static final  Logger  LOG=LoggerFactory.getLogger(ActionBear.class);
	
	@Resource
	private BearRevisedService bearRevisedService;
	
	@Resource
	private ProjectBuildMapper  projectBuildMapper;
	
	
	
	/**获取施工企业还可以承载的项目情况(计算范围: 系统当前年份)
	 * 
	 * @param request
	 * @return
	 */
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<BearProjectBuildVo> read(
			ExtDirectStoreReadRequest request) {
		List<BearProjectBuildVo>  pcList=new ArrayList<BearProjectBuildVo>();
		
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
		List<BearResultDto>  brList=bearRevisedService.getBearBadBehaviorRevised() ;
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
				
				
				pcList.add(vo);
			}
		}
		
		return new ExtDirectStoreReadResult<BearProjectBuildVo>(pcList);
		
	}
	
	

}
