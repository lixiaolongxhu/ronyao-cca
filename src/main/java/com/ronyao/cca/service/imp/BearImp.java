package com.ronyao.cca.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ronyao.cca.constant.ConstAnnualOutput;
import com.ronyao.cca.constant.ConstEnterprisePerMan;
import com.ronyao.cca.constant.ConstEquipmentBear;
import com.ronyao.cca.db.dao.AnnualOutputMapper;
import com.ronyao.cca.db.dao.EnterpriseEquipmentMapper;
import com.ronyao.cca.db.dao.EnterpriseMapper;
import com.ronyao.cca.db.dao.EnterprisePerManageMapper;
import com.ronyao.cca.db.dao.EnterprisePerStandardMapper;
import com.ronyao.cca.db.dao.EquipmentBearMapper;
import com.ronyao.cca.db.dao.PostClassifyMapper;
import com.ronyao.cca.db.dao.VoltageRankClassifyMapper;
import com.ronyao.cca.db.model.AnnualOutput;
import com.ronyao.cca.db.model.AnnualOutputExample;
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.EnterpriseEquipment;
import com.ronyao.cca.db.model.EnterpriseEquipmentExample;
import com.ronyao.cca.db.model.EnterpriseExample;
import com.ronyao.cca.db.model.EnterprisePerManage;
import com.ronyao.cca.db.model.EnterprisePerManageExample;
import com.ronyao.cca.db.model.EnterprisePerStandard;
import com.ronyao.cca.db.model.EnterprisePerStandardExample;
import com.ronyao.cca.db.model.EquipmentBear;
import com.ronyao.cca.db.model.EquipmentBearExample;
import com.ronyao.cca.db.model.VoltageRankClassify;
import com.ronyao.cca.db.model.VoltageRankClassifyExample;
import com.ronyao.cca.service.Bear;
import com.ronyao.cca.service.dto.BearResultDto;
import com.ronyao.cca.service.dto.EnterprisePerStaDto;
import com.ronyao.cca.service.dto.ProjectConfigDto;

/**施工企业承载力评估.
 * 
 * @author user
 *
 */
@Service
@Scope(value="prototype") //设置为多列模式,默认单例
public class BearImp implements Bear {
	
	private static final Logger  LOG=LoggerFactory.getLogger(BearImp.class);

	@Resource
	private EnterprisePerStandardMapper  enterprisePerStandardMapper;
	@Resource
	private EnterprisePerManageMapper  enterprisePerManageMapper;
	
	@Resource
	private PostClassifyMapper  postClassifyMapper;
	
	/**电压等级分类
	 * 
	 */
	@Resource
	private VoltageRankClassifyMapper  voltageRankClassifyMapper;
	
	
	@Resource
	private EnterpriseEquipmentMapper  enterpriseEquipmentMapper;
	
	@Resource
	private EquipmentBearMapper  equipementBearMapper;
	
	@Resource
	private AnnualOutputMapper annualOutputMapper;
	
	@Resource
	private EnterpriseMapper enterpriseMapper;
	
	//---------------------------变量-------------------------------
	

	/**电压等级分类key :value   value : voltageRankClassify
	 * 
	 */
	private static   Map<Integer, VoltageRankClassify> voltagetMapValue;
	
	/**电压等级分类  key : id  value : value 
	 * 
	 */
	private static   Map<Integer, Integer> voltagetMapId;
	
	/**企业施工人员必须配置
	 * 
	 */
	private static   EnterprisePerStaDto  enterPerStaDto;
	
	/**项目对应电压等级的产值配置
	 * 
	 */
	private static  Map<String, AnnualOutput> outputmap;
			
	
	
	

	public void loadInitConfig() {
		// TODO Auto-generated method stub
		//查询电压等级返回在500kv及其以下的电压
		VoltageRankClassifyExample  voltageExample=new VoltageRankClassifyExample();
		voltageExample.createCriteria().andValueLessThanOrEqualTo(500);
		List<VoltageRankClassify> voltagetList=voltageRankClassifyMapper.selectByExample(voltageExample);
		voltagetMapValue=new HashMap<Integer, VoltageRankClassify>();
		voltagetMapId=new HashMap<Integer, Integer>();
		if(voltagetList.isEmpty()){
			LOG.error("查询获取电压等级字典表信息失败:该信息必须存在");
		
		}else{
			for (VoltageRankClassify voltageRankClassify : voltagetList) {
				voltagetMapValue.put(voltageRankClassify.getValue(), voltageRankClassify);
				voltagetMapId.put(voltageRankClassify.getId(),voltageRankClassify.getValue());
			}
		}	
		
		//查询获取施工企业现场人员必备人员配置数
		enterPerStaDto=getEnterprisePerStand();
		if(enterPerStaDto==null){
			LOG.warn("查询获取施工企业现场人员必备人员配置数失败 : 用户未配置,用户必须配置该项");
			//return 0;
			
		}
		
		//获取项目产值配置信息表
		AnnualOutputExample   outputExample=new AnnualOutputExample();
		List<AnnualOutput>  outputList=annualOutputMapper.selectByExample(outputExample);
		if(outputList.isEmpty()){
			LOG.warn("施工项目团队年产值信息未配置  :: 用户未配置,用户必须配置该项.");
			//return 0;
				
		}
		outputmap=new HashMap<String, AnnualOutput>();
		for (AnnualOutput annualOutput : outputList) {
				outputmap.put(voltagetMapId.get(annualOutput.getVoltagerankid())+""+annualOutput.getProjecttype(), annualOutput);
		}
	
		
	}
	
	

	public BearResultDto getEnterpriseBearResult(Enterprise  enterprise) {
		
		Integer enterpriseId=enterprise.getId();
		
		//查询获取施工企业现场管理人员数
		Map<Integer, EnterprisePerManage>  perManMap=getEnterprisePerMan(enterpriseId);
		
		if(perManMap==null){
			LOG.warn("查询获取施工企业现场管理人员数失败: 用户未配置,用户必须配置该项");
			//return 0;	
			return new BearResultDto(enterpriseId);
		}
	
		//设置项目配置信息(线路工程)
		ProjectConfigDto  lineProjectDto=setProjectConfig(ConstEnterprisePerMan.LINE_PROFESSION,perManMap);
		if(lineProjectDto==null){
			LOG.warn("未配置该企业的线路专业的线程管理人员 ;  企业名称:"+enterprise.getFullname());
			return new BearResultDto(enterpriseId);
		}
		//设置项目配置信息(变电工程)
		ProjectConfigDto  powerProjectDto=setProjectConfig(ConstEnterprisePerMan.POWER_PROFESSION,perManMap);
		if(powerProjectDto==null){
			LOG.warn("未配置该企业的变电专业的线程管理人员 ;  企业名称:"+enterprise.getFullname());
			return new BearResultDto(enterpriseId);
		}
		
		
		Integer  linePersonProjectNum500kv=0;
		Integer  lineEquipmentProjectNum500kv=0;
		Integer  lineProjectNum500kv=0;
		ProjectConfigDto  lineProjectDto500kv=null;
		
		Integer  linePersonProjectNum220kv=0;
		Integer  lineEquipmentProjectNum220kv=0;
		Integer  lineProjectNum220kv=0;
		ProjectConfigDto  lineProjectDto220kv=null;
		
		Integer  linePersonProjectNum110kv=0;
		Integer  lineProjectNum110kv=0;
		Integer  lineProjectOutput=0;
		
		Integer  powerPersonProjectNum500kv=0;
		Integer powerProjectNum500kv=0;
		ProjectConfigDto  powerProjectDto500kv=null;
		
		Integer  powerPersonProjectNum220kv=0;
		Integer  powerProjectNum220kv=0;
		ProjectConfigDto powerProjectDto220kv=null;
				
		Integer  powerPersonProjectNum110kv=0;
		Integer  powerProjectNum110kv=0;
		Integer  powerProjectOutput=0;
		
		//获取当前企业的资质等级   
		Integer rank=-1;
		if(enterprise.getOverallrank()==1 ||  enterprise.getProfessionrank()==1){
			rank=1;
		} else if( enterprise.getOverallrank()==2 ||  enterprise.getProfessionrank()==2){
			rank=2;
		}else if( enterprise.getOverallrank()==3 ||  enterprise.getProfessionrank()==3){
			rank=3;
		}else{
			rank=3;
		}
		
		//计算不同电压等级可以组建项目情况
		switch (rank) {
		case 1:
			//----------------------------------线路工程----------------------------------
			
			//500kv计算时对应施工企业人员可以组建的项目个数
			  linePersonProjectNum500kv=getProject500kv(lineProjectDto,enterPerStaDto,ConstEnterprisePerMan.LINE_PROFESSION);
			
			//500kv查询企业的设备信息(获取企业大张牵设备数)已经设备可承载的项目数
			  lineEquipmentProjectNum500kv=getEquipmentBearProjectNum(enterpriseId,voltagetMapValue,500);
			  
			  //500kv 如果当张牵设备可以组建的项目数少于人员可以组建的项目部数时,人员分配已张牵设备组建的项目部数为准
			  if(lineEquipmentProjectNum500kv<linePersonProjectNum500kv){
				  linePersonProjectNum500kv=lineEquipmentProjectNum500kv;
			  }
			  
			
			//500kv获取人员可承载项目数与设备承载项目数的最小值,作为实际可以承载的项目数.
			  
			  lineProjectNum500kv=Math.min(lineEquipmentProjectNum500kv, linePersonProjectNum500kv);
			
			//500kv 设置组件项目后的人员信息配置(220kv可组建项目部人员=公司总人数 -500kv人员可组建项目部总人数)
			  lineProjectDto500kv=resetProjectConfig500kv(lineProjectDto,linePersonProjectNum500kv,enterPerStaDto,ConstEnterprisePerMan.LINE_PROFESSION);
			//----------------------------变电工程-----------------------------------------
				
				
			//500kv计算时对应施工企业人员可以组建的项目个数
			 powerPersonProjectNum500kv=getProject500kv(powerProjectDto,enterPerStaDto,ConstEnterprisePerMan.POWER_PROFESSION);
						
			//500kv获取人员可承载项目数与设备承载项目数的最小值,作为实际可以承载的项目数.
			 powerProjectNum500kv=powerPersonProjectNum500kv;
						
			//500kv 设置组件项目后的人员信息配置
			 powerProjectDto500kv=resetProjectConfig500kv(powerProjectDto,powerProjectNum500kv,enterPerStaDto,ConstEnterprisePerMan.POWER_PROFESSION);  
			  
		case 2:
			//----------------------------------线路工程----------------------------------
			 if(lineProjectDto500kv==null){
				lineProjectDto500kv=lineProjectDto;
			 }
			//220kv计算时对应施工企业人员可以组建的项目个数
			  linePersonProjectNum220kv=getProject220kv(lineProjectDto500kv,enterPerStaDto,ConstEnterprisePerMan.LINE_PROFESSION);
			
			//220kv查询企业的设备信息(获取企业大张牵设备数)已经设备可承载的项目数
			  lineEquipmentProjectNum220kv=getEquipmentBearProjectNum(enterpriseId,voltagetMapValue,220);
				
			 //220kv 如果当张牵设备可以组建的项目数少于人员可以组建的项目部数时,人员分配已张牵设备组建的项目部数为准
			  if(lineEquipmentProjectNum220kv<linePersonProjectNum220kv){
				  linePersonProjectNum220kv=lineEquipmentProjectNum220kv;
			  }
			  
			//220kv获取人员可承载项目数与设备承载项目数的最小值,作为实际可以承载的项目数.
			  lineProjectNum220kv=Math.min(linePersonProjectNum220kv, lineEquipmentProjectNum220kv);
			
			//220kv 重新设置组件项目后的人员信息配置
			  lineProjectDto220kv=resetProjectConfig220kv(lineProjectDto500kv,linePersonProjectNum220kv,enterPerStaDto,ConstEnterprisePerMan.LINE_PROFESSION);
			//----------------------------变电工程-----------------------------------------
			 if(powerProjectDto500kv==null){
				  powerProjectDto500kv=powerProjectDto;
			 }
			//220kv计算时对应施工企业人员可以组建的项目个数
			  powerPersonProjectNum220kv=getProject220kv(powerProjectDto500kv,enterPerStaDto,ConstEnterprisePerMan.POWER_PROFESSION);
		
			//220kv获取人员可承载项目数与设备承载项目数的最小值,作为实际可以承载的项目数.
			  powerProjectNum220kv=powerPersonProjectNum220kv;
					
			//220kv 重新设置组件项目后的人员信息配置
			  powerProjectDto220kv=resetProjectConfig220kv(powerProjectDto500kv,powerProjectNum220kv,enterPerStaDto,ConstEnterprisePerMan.POWER_PROFESSION);
					
		case 3:
			//----------------------------------线路工程----------------------------------
			 if(lineProjectDto220kv==null){
				 lineProjectDto220kv=lineProjectDto;
			 }
			//110kv计算时对应施工企业人员可以组建的项目个数
			  linePersonProjectNum110kv=getProject110kv(lineProjectDto220kv,enterPerStaDto,ConstEnterprisePerMan.LINE_PROFESSION);
			  lineProjectNum110kv=linePersonProjectNum110kv;

			//----------------------------变电工程-----------------------------------------
			  if(powerProjectDto220kv==null){
				  powerProjectDto220kv=powerProjectDto;
				 }
			//110kv计算时对应施工企业人员可以组建的项目个数
			  powerPersonProjectNum110kv=getProject110kv(powerProjectDto220kv,enterPerStaDto,ConstEnterprisePerMan.POWER_PROFESSION);
			  powerProjectNum110kv=powerPersonProjectNum110kv;
			  break;
		default:
			break;
		}
	
		
		
		//设置实际一年中施工企业可以承载完成的项目数(非经过不良行为修正)  
		BearResultDto result=new BearResultDto(enterpriseId);;
		result.setEnterpriseid(enterpriseId);
		result.setEnterpriseName(enterprise.getName());
		result.setSupervisorunit(enterprise.getSupervisorunit());
		result.setTreeYearOutput(enterprise.getOutput());
		result.setTreeYearProject(enterprise.getProject());
		//四舍五入  企业每年可以组建项目数=施工项目数*每年对应项目的完成量
		result.setLine110kv(Math.round(lineProjectNum110kv*outputmap.get(110+""+ConstAnnualOutput.LINE_PROJECT).getProjectnum().floatValue()));
		result.setLine220kv(Math.round(lineProjectNum220kv*outputmap.get(220+""+ConstAnnualOutput.LINE_PROJECT).getProjectnum().floatValue()));
		result.setLine500kv(Math.round(lineProjectNum500kv*outputmap.get(500+""+ConstAnnualOutput.LINE_PROJECT).getProjectnum().floatValue()));
		result.setLineProjectSum(result.getLine110kv()+result.getLine220kv()+result.getLine500kv());
		
		//线路工程年产值合计
		lineProjectOutput=
						outputmap.get(500+""+ConstAnnualOutput.LINE_PROJECT).getAnnualoutput()*result.getLine500kv()
						+outputmap.get(220+""+ConstAnnualOutput.LINE_PROJECT).getAnnualoutput()*result.getLine220kv()
						+outputmap.get(110+""+ConstAnnualOutput.LINE_PROJECT).getAnnualoutput()*result.getLine110kv();	
		result.setLineOutput(lineProjectOutput);
		
		
		result.setPower110kv(Math.round(powerProjectNum110kv*outputmap.get(110+""+ConstAnnualOutput.POWER_PROJECT).getProjectnum().floatValue()));
		result.setPower220kv(Math.round(powerProjectNum220kv*outputmap.get(220+""+ConstAnnualOutput.POWER_PROJECT).getProjectnum().floatValue()));
		result.setPower500kv(Math.round(powerProjectNum500kv*outputmap.get(500+""+ConstAnnualOutput.POWER_PROJECT).getProjectnum().floatValue()));
		result.setPowerProjectSum(result.getPower110kv()+result.getPower220kv()+result.getPower500kv());
		
		//变电工程年产值合计
		powerProjectOutput=
								outputmap.get(500+""+ConstAnnualOutput.POWER_PROJECT).getAnnualoutput()*result.getPower500kv()
								+outputmap.get(220+""+ConstAnnualOutput.POWER_PROJECT).getAnnualoutput()*result.getPower220kv()
								+outputmap.get(110+""+ConstAnnualOutput.POWER_PROJECT).getAnnualoutput()*result.getPower110kv();
		result.setPowerOutput(powerProjectOutput);
		
		
		result.setOutputSum(lineProjectOutput+powerProjectOutput);
		result.setProjectSum(result.getLineProjectSum()+result.getPowerProjectSum());
		
		return result;
		
	}

	
	


	/**获取项目人员信息初始设定
	 * 
	 * @param lineProfession
	 * @param perManMap 
	 * @return
	 */
	private ProjectConfigDto setProjectConfig(Integer profession, Map<Integer, EnterprisePerManage> perManMap) {
		EnterprisePerManage   enterprisePerManage =perManMap.get(profession);
		ProjectConfigDto lineProjectDto=new ProjectConfigDto();
		lineProjectDto.setSurplusInspector(enterprisePerManage.getInspector());
		lineProjectDto.setSurplusOneChief(enterprisePerManage.getOnechief());
		lineProjectDto.setSurplusOneManager(enterprisePerManage.getOnemanager());
		lineProjectDto.setSurplusPersonTotal(enterprisePerManage.getSum());
		lineProjectDto.setSurplusSafetyOfficer(enterprisePerManage.getSafetyofficer());
		lineProjectDto.setSurplusTwoChief(enterprisePerManage.getTwochief());
		lineProjectDto.setSurplusTwoManager(enterprisePerManage.getTwomanager());
		return  lineProjectDto;

	}

	/**重新设置500kv组件项目后的人员信息配置.
	 * 
	 * @param projectDto
	 * @param projectNum  人员可以组建项目部数
	 * @param enterPerStaDto
	 * @param profession  专业类型
	 * @return
	 */
	private ProjectConfigDto resetProjectConfig500kv(ProjectConfigDto projectDto,Integer personProjectNum,
			EnterprisePerStaDto  enterPerStaDto,Integer profession) {
		
		Map<Integer, EnterprisePerStandard> perStaMap=enterPerStaDto.getPerStaMap();
		ProjectConfigDto projectDto500kv=new ProjectConfigDto();
		switch (profession) {
			case ConstEnterprisePerMan.LINE_PROFESSION:
				
				projectDto500kv.setSurplusOneManager(projectDto.getSurplusOneManager()-personProjectNum*perStaMap.get(1).getLineflatnum());
				projectDto500kv.setSurplusTwoManager(projectDto.getSurplusTwoManager());
			
				projectDto500kv.setSurplusOneChief(projectDto.getSurplusOneChief()-personProjectNum*perStaMap.get(2).getLineflatnum());
				projectDto500kv.setSurplusTwoChief(projectDto.getSurplusTwoChief());
			
				projectDto500kv.setSurplusSafetyOfficer(projectDto.getSurplusSafetyOfficer()-personProjectNum*perStaMap.get(3).getLineflatnum());
				projectDto500kv.setSurplusInspector(projectDto.getSurplusInspector()-personProjectNum*perStaMap.get(4).getLineflatnum());
			
			
			
				projectDto500kv.setSurplusPersonTotal(projectDto.getSurplusPersonTotal()-personProjectNum*enterPerStaDto.getLinePerStaSum());
			
				
				break;
			
			case ConstEnterprisePerMan.POWER_PROFESSION:
				projectDto500kv.setSurplusOneManager(projectDto.getSurplusOneManager()-personProjectNum*perStaMap.get(1).getPowernum());
				projectDto500kv.setSurplusTwoManager(projectDto.getSurplusTwoManager());
			
				projectDto500kv.setSurplusOneChief(projectDto.getSurplusOneChief()-personProjectNum*perStaMap.get(2).getPowernum());
				projectDto500kv.setSurplusTwoChief(projectDto.getSurplusTwoChief());
			
				projectDto500kv.setSurplusSafetyOfficer(projectDto.getSurplusSafetyOfficer()-personProjectNum*perStaMap.get(3).getPowernum());
				projectDto500kv.setSurplusInspector(projectDto.getSurplusInspector()-personProjectNum*perStaMap.get(4).getPowernum());
			
				projectDto500kv.setSurplusPersonTotal(projectDto.getSurplusPersonTotal()-personProjectNum*enterPerStaDto.getPowerPerStaSum());
			
				
				break;

			default:
				break;
		
		}
		
		return  projectDto500kv;
		
	}

	
	
	/**220kv 重新设置组件项目后的人员信息配置.
	 * 
	 * @param projectDto500kv
	 * @param personProjectNum220kv
	 * @param enterPerStaDto
	 * @param profession
	 * @return
	 */
	private ProjectConfigDto resetProjectConfig220kv(
			ProjectConfigDto projectDto500kv, Integer personProjectNum220kv,
			EnterprisePerStaDto enterPerStaDto,Integer profession) {
		Map<Integer, EnterprisePerStandard> perStaMap=enterPerStaDto.getPerStaMap();
		
		ProjectConfigDto projectDto220kv=new ProjectConfigDto();
		switch (profession) {
		case ConstEnterprisePerMan.LINE_PROFESSION:
			Integer  lineOneManager=projectDto500kv.getSurplusOneManager()-personProjectNum220kv*perStaMap.get(1).getLineflatnum();
			if(lineOneManager<=0){
				projectDto220kv.setSurplusOneManager(0);
				projectDto220kv.setSurplusTwoManager(projectDto500kv.getSurplusTwoManager()+lineOneManager);
			}else{
				projectDto220kv.setSurplusOneManager(lineOneManager);
				projectDto220kv.setSurplusTwoManager(projectDto500kv.getSurplusTwoManager());
			}
			
			projectDto220kv.setSurplusOneChief(projectDto500kv.getSurplusOneChief()-personProjectNum220kv*perStaMap.get(2).getLineflatnum());
			projectDto220kv.setSurplusTwoChief(projectDto500kv.getSurplusTwoChief());
			projectDto220kv.setSurplusSafetyOfficer(projectDto500kv.getSurplusSafetyOfficer()-personProjectNum220kv*perStaMap.get(3).getLineflatnum());
			projectDto220kv.setSurplusInspector(projectDto500kv.getSurplusInspector()-personProjectNum220kv*perStaMap.get(4).getLineflatnum());
			projectDto220kv.setSurplusPersonTotal(projectDto500kv.getSurplusPersonTotal()-personProjectNum220kv*enterPerStaDto.getLinePerStaSum());
			
			break;
		case  ConstEnterprisePerMan.POWER_PROFESSION:
			
			Integer  powerOneManager=projectDto500kv.getSurplusOneManager()-personProjectNum220kv*perStaMap.get(1).getPowernum();
			if(powerOneManager<=0){
				projectDto220kv.setSurplusOneManager(0);
				projectDto220kv.setSurplusTwoManager(projectDto500kv.getSurplusTwoManager()+powerOneManager);
			}else{
				projectDto220kv.setSurplusOneManager(powerOneManager);
				projectDto220kv.setSurplusTwoManager(projectDto500kv.getSurplusTwoManager());
			}
			
			projectDto220kv.setSurplusOneChief(projectDto500kv.getSurplusOneChief()-personProjectNum220kv*perStaMap.get(2).getPowernum());
			projectDto220kv.setSurplusTwoChief(projectDto500kv.getSurplusTwoChief());
			projectDto220kv.setSurplusSafetyOfficer(projectDto500kv.getSurplusSafetyOfficer()-personProjectNum220kv*perStaMap.get(3).getPowernum());
			projectDto220kv.setSurplusInspector(projectDto500kv.getSurplusInspector()-personProjectNum220kv*perStaMap.get(4).getPowernum());
			projectDto220kv.setSurplusPersonTotal(projectDto500kv.getSurplusPersonTotal()-personProjectNum220kv*enterPerStaDto.getPowerPerStaSum());
		
			break;

		default:
			break;
		}
		
		
		return  projectDto220kv;
	}
	
	
	/**查询企业的设备信息(获取企业大张牵设备数)
	 * 
	 * @param enterpriseId
	 * @return
	 */
	private Integer getEquipmentBearProjectNum(Integer enterpriseId,Map<Integer, VoltageRankClassify> voltagetMap,Integer voltageValue) {
		//获取企业的大张牵设备数
		EnterpriseEquipmentExample  enterEquipmentExample=new EnterpriseEquipmentExample();
		enterEquipmentExample.createCriteria().andEnterpriseidEqualTo(enterpriseId);
		List<EnterpriseEquipment>  enterEquipment=enterpriseEquipmentMapper.selectByExample(enterEquipmentExample);
		Integer bigEnterpriseEquip=0;
		if(!enterEquipment.isEmpty()){
			bigEnterpriseEquip= enterEquipment.get(0).getBigequipment();
		}
		
		VoltageRankClassify  vrc=	voltagetMap.get(voltageValue);
		
		//查询线路专业牵张设备承载力
		EquipmentBearExample  equipBearExample=new EquipmentBearExample();
		equipBearExample.createCriteria().
			andVoltagerankidEqualTo(vrc.getId()).
			andLinetypeEqualTo(ConstEquipmentBear.LINE_TYPE_DOUBLE);
		List<EquipmentBear> equipBearList=equipementBearMapper.selectByExample(equipBearExample);
		Byte lineplain=0;
		if(!equipBearList.isEmpty()){
			lineplain=equipBearList.get(0).getLineplain();
		}
		
		Integer lineEquipmentProjectNum = (bigEnterpriseEquip* lineplain	* ConstEquipmentBear.CONST)/ConstEquipmentBear.PROJECT_LENGTH;
		
		return  lineEquipmentProjectNum;
	}

	/**计算500kv时对应施工企业人员可以组建的项目个数.
	 * 
	 * @param lineProjectDto
	 * @param enterPerStaDto
	 * @return
	 */
	private Integer getProject500kv(ProjectConfigDto lineProjectDto,
			EnterprisePerStaDto enterPerStaDto,Integer  profession) {
		Map<Integer, EnterprisePerStandard>  perStaMap=enterPerStaDto.getPerStaMap();
		//取500kv项目经理 ,项目总工人员的最小值(1 项目经理  2 项目总工, 3 安全员   4 质检员  与数据库表postClassify一一对应)
		Byte   manager=perStaMap.get(1).getLineflatnum();
		Byte   chief=perStaMap.get(2).getLineflatnum();
		Byte   safeOfficer=perStaMap.get(3).getLineflatnum();
		Byte   inspector=perStaMap.get(4).getLineflatnum();
		Integer  minOne=Math.min(lineProjectDto.getSurplusOneManager()/manager,lineProjectDto.getSurplusOneChief()/chief);
		//取安全员, 质检员最小值
		Integer minTwo=Math.min(lineProjectDto.getSurplusSafetyOfficer()/safeOfficer,lineProjectDto.getSurplusInspector()/inspector);
					
		//项目必备人员可以主键的项目数
		Integer minPersonProjectN=Math.min(minOne, minTwo);
				
		//返回可以人员可以组建的项目数
		return getPersonProjectNum(minPersonProjectN,lineProjectDto.getSurplusPersonTotal(),profession);
		
	}
	
	/**220kv计算时对应施工企业人员可以组建的项目个数
	 * 
	 * @param lineProjectDto500kv
	 * @param enterPerStaDto
	 * @return
	 */
	private Integer getProject220kv(ProjectConfigDto lineProjectDto,EnterprisePerStaDto enterPerStaDto,Integer profession) {
		
		Map<Integer, EnterprisePerStandard>  perStaMap=enterPerStaDto.getPerStaMap();
		//取500kv项目经理 ,项目总工人员的最小值(1 项目经理  2 项目总工, 3 安全员   4 质检员  与数据库表postClassify一一对应)
		Integer  minOne=Math.min(lineProjectDto.getSurplusOneManager()+lineProjectDto.getSurplusTwoManager()/perStaMap.get(1).getLineflatnum(),lineProjectDto.getSurplusOneChief()/perStaMap.get(2).getLineflatnum());
		//取安全员, 质检员最小值
		Integer  minTwo=Math.min(lineProjectDto.getSurplusSafetyOfficer()/perStaMap.get(3).getLineflatnum(),lineProjectDto.getSurplusInspector()/perStaMap.get(4).getLineflatnum());
					
		//项目必备人员可以主键的项目数
		Integer minPersonProjectN=Math.min(minOne, minTwo);
				
		
		//返回可以人员可以组建的项目数
		return getPersonProjectNum(minPersonProjectN,lineProjectDto.getSurplusPersonTotal(),profession);
	}
	
	/**110kv计算时对应施工企业人员可以组建的项目个数
	 * 
	 * @param lineProjectDto220kv
	 * @param enterPerStaDto
	 * @return
	 */
	
	private Integer getProject110kv(ProjectConfigDto lineProjectDto220kv,
			EnterprisePerStaDto enterPerStaDto,Integer  profession ) {
		Map<Integer, EnterprisePerStandard>  perStaMap=enterPerStaDto.getPerStaMap();
		//取500kv项目经理 ,项目总工人员的最小值(1 项目经理  2 项目总工, 3 安全员   4 质检员  与数据库表postClassify一一对应)
		Byte   manager=perStaMap.get(1).getLineflatnum();
		Byte   chief=perStaMap.get(2).getLineflatnum();
		Byte   safeOfficer=perStaMap.get(3).getLineflatnum();
		Byte   inspector=perStaMap.get(4).getLineflatnum();
		Integer  minOne=Math.min(lineProjectDto220kv.getSurplusOneManager()+lineProjectDto220kv.getSurplusTwoManager()/manager,lineProjectDto220kv.getSurplusOneChief()+lineProjectDto220kv.getSurplusTwoChief()/chief);
		//取安全员, 质检员最小值
		Integer  minTwo=Math.min(lineProjectDto220kv.getSurplusSafetyOfficer()/safeOfficer,lineProjectDto220kv.getSurplusInspector()/inspector);
					
		//项目必备人员可以主键的项目数
		Integer minPersonProjectN=Math.min(minOne, minTwo);
			
		
		//返回可以人员可以组建的项目数
		return getPersonProjectNum(minPersonProjectN,lineProjectDto220kv.getSurplusPersonTotal(),profession);
	}
	

	/**获取人员组建项目数
	 * 
	 * @param surplusPersonTotal
	 * @param profession
	 */
	private Integer getPersonProjectNum(Integer minPersonProjectN,Integer surplusPersonTotal,
			Integer profession) {
		Integer  perStaSum=0;
		if(ConstEnterprisePerMan.LINE_PROFESSION==profession){
			perStaSum=enterPerStaDto.getLinePerStaSum();
			
		}else if (ConstEnterprisePerMan.POWER_PROFESSION==profession){
			perStaSum=enterPerStaDto.getPowerPerStaSum();
		}else{
			perStaSum=0;
		}
			
		//线路专业计算
		while(true){
				//大于当前线路专业总人数T
				
				if(minPersonProjectN*perStaSum > surplusPersonTotal){
					minPersonProjectN--;
				}else{
					break;
				}
		}
		return minPersonProjectN;
		
	}



	/**获取施工企业现场管理人员数
	 * 
	 * @return
	 */
	private Map<Integer, EnterprisePerManage>   getEnterprisePerMan(Integer enterpriseId) {
		EnterprisePerManageExample  perManExample=new EnterprisePerManageExample();		
		perManExample.createCriteria().andEnterpriseidEqualTo(enterpriseId);
		List<EnterprisePerManage>  perManList=enterprisePerManageMapper.selectByExample(perManExample);
		if(perManList.isEmpty()){
			return null;
		}
		Map<Integer, EnterprisePerManage>  perManMap =new HashMap<Integer, EnterprisePerManage>();
		for (EnterprisePerManage enterprisePerManage : perManList) {
			perManMap.put(enterprisePerManage.getProfessiontype(), enterprisePerManage);
		}
		return perManMap;
	}

	/**获取施工企业现场人员必备人员配置数.
	 * 
	 * @return
	 */
	private EnterprisePerStaDto getEnterprisePerStand() {
		EnterprisePerStandardExample  perStaExample=new EnterprisePerStandardExample();
		List<EnterprisePerStandard>   perStaList=enterprisePerStandardMapper.selectByExample(perStaExample);
		if(perStaList.isEmpty()){
			return null;
		}
		Map<Integer, EnterprisePerStandard>  perStaMap=new HashMap<Integer, EnterprisePerStandard>();
		Integer  linePerStaSum=0; //线路工程要求(平地丘陵)配置总人数
		Integer  powerPerStaSum=0; //变电工程要求配置总人数
		for (EnterprisePerStandard enterprisePerStandard : perStaList) {
			linePerStaSum=linePerStaSum+enterprisePerStandard.getLineflatnum();
			powerPerStaSum=powerPerStaSum+enterprisePerStandard.getPowernum();
			perStaMap.put(enterprisePerStandard.getPostclassifyid(), enterprisePerStandard);
		}
		EnterprisePerStaDto dto=new EnterprisePerStaDto();
		dto.setLinePerStaSum(linePerStaSum);
		dto.setPowerPerStaSum(powerPerStaSum);
		dto.setPerStaMap(perStaMap);
		return dto;
	}



	public Map<String, AnnualOutput> getAnnualOutPutConfig() {
		if(outputmap.isEmpty()){
			loadInitConfig();
		}
		return outputmap;
	}



	public List<BearResultDto> getEnterpriseBearResult() {
		List<BearResultDto> resultList=new ArrayList<BearResultDto>();
		EnterpriseExample  enterExample=new EnterpriseExample();
		List<Enterprise>  enterList=enterpriseMapper.selectByExample(enterExample);
		
		if(!enterList.isEmpty()){
			loadInitConfig();
			for (Enterprise enterprise : enterList) {
				BearResultDto result=getEnterpriseBearResult(enterprise);
				if(result!=null){
					resultList.add(result);
				}
				
			}
		}
		return  resultList;
	}







}
