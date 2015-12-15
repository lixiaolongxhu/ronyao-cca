package com.ronyao.cca.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ronyao.cca.constant.ConstAnnualOutput;
import com.ronyao.cca.constant.ConstEnterprisePerMan;
import com.ronyao.cca.constant.ConstEquipmentBear;
import com.ronyao.cca.db.dao.AnnualOutputMapper;
import com.ronyao.cca.db.dao.EnterpriseEquipmentMapper;
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
	private EnterpriseEquipmentMapper  enterpriseEnterpriseEquipmentMapper;
	
	@Resource
	private EquipmentBearMapper  equipementBearMapper;
	
	@Resource
	private AnnualOutputMapper annualOutputMapper;
	

	/**电压等级分类
	 * 
	 */
	private static   Map<Integer, VoltageRankClassify> voltagetMap;
	
	/**企业施工人员必须配置
	 * 
	 */
	private static   EnterprisePerStaDto  enterPerStaDto;
	
	/**项目对应电压等级的产值配置
	 * 
	 */
	private static  Map<String, Integer> outputmap;
			
	

	public void loadInitConfig() {
		// TODO Auto-generated method stub
		//查询电压等级返回在500kv及其以下的电压
		VoltageRankClassifyExample  voltageExample=new VoltageRankClassifyExample();
		voltageExample.createCriteria().andValueLessThanOrEqualTo(500);
		List<VoltageRankClassify> voltagetList=voltageRankClassifyMapper.selectByExample(voltageExample);
		voltagetMap=new HashMap<Integer, VoltageRankClassify>();
		if(voltagetList.isEmpty()){
			LOG.error("查询获取电压等级字典表信息失败:该信息必须存在");
		
		}else{
			for (VoltageRankClassify voltageRankClassify : voltagetList) {
				voltagetMap.put(voltageRankClassify.getValue(), voltageRankClassify);
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
		outputmap=new HashMap<String, Integer>();
		for (AnnualOutput annualOutput : outputList) {
					outputmap.put(annualOutput.getVoltagerankid()+""+annualOutput.getProjecttype(), annualOutput.getAnnualoutput());
		}
	
		
	}
	
	

	public BearResultDto getEnterpriseBearResult(Enterprise  enterprise) {
		
		Integer enterpriseId=enterprise.getId();
		
		//查询获取施工企业现场管理人员数
		Map<Integer, EnterprisePerManage>  perManMap=getEnterprisePerMan(enterpriseId);
		
		if(perManMap==null){
			LOG.warn("查询获取施工企业现场管理人员数失败: 用户未配置,用户必须配置该项");
			//return 0;	
			return new BearResultDto();
		}

			
		//设置项目配置信息(线路工程)
		ProjectConfigDto  lineProjectDto=setProjectConfig(ConstEnterprisePerMan.LINE_PROFESSION,perManMap);
		//设置项目配置信息(变电工程)
		ProjectConfigDto  powerProjectDto=setProjectConfig(ConstEnterprisePerMan.POWER_PROFESSION,perManMap);
		
		Integer  linePersonProjectNum500kv=0;
		Integer  lineEquipmentProjectNum500kv=0;
		Integer  lineProjectNum500kv=0;
		ProjectConfigDto  lineProjectDto500kv;
		
		Integer  linePersonProjectNum220kv=0;
		Integer  lineEquipmentProjectNum220kv=0;
		Integer  lineProjectNum220kv=0;
		ProjectConfigDto  lineProjectDto220kv;
		
		Integer  linePersonProjectNum110kv=0;
		Integer  lineProjectNum110kv=0;
		Integer  lineProjectOutput=0;
		
		Integer  powerPersonProjectNum500kv=0;
		Integer powerProjectNum500kv=0;
		ProjectConfigDto  powerProjectDto500kv;
		
		Integer  powerPersonProjectNum220kv=0;
		Integer  powerProjectNum220kv=0;
		ProjectConfigDto powerProjectDto220kv;
		
		
		
		Integer  powerPersonProjectNum110kv=0;
		Integer  powerProjectNum110kv=0;
		Integer  powerProjectOutput=0;
		
		
		if(enterprise.getOverallrank()==1 ||  enterprise.getProfessionrank()==1){
			
			//----------------------------------线路工程------------------------
			
			//500kv计算时对应施工企业人员可以组建的项目个数
			  linePersonProjectNum500kv=getLineProject500kv(lineProjectDto,enterPerStaDto);
			
			//500kv查询企业的设备信息(获取企业大张牵设备数)已经设备可承载的项目数
			  lineEquipmentProjectNum500kv=getEquipmentBearProjectNum(enterpriseId,voltagetMap,500);
			
			//500kv获取人员可承载项目数与设备承载项目数的最小值,作为实际可以承载的项目数.
			  lineProjectNum500kv=Math.min(lineEquipmentProjectNum500kv, linePersonProjectNum500kv);
			
			//500kv 设置组件项目后的人员信息配置
			  lineProjectDto500kv=resetProjectConfig500kv(lineProjectDto,lineProjectNum500kv,enterPerStaDto);
			
			
			
			//220kv计算时对应施工企业人员可以组建的项目个数
			  linePersonProjectNum220kv=getLineProject220kv(lineProjectDto500kv,enterPerStaDto);
			
			//220kv查询企业的设备信息(获取企业大张牵设备数)已经设备可承载的项目数
			  lineEquipmentProjectNum220kv=getEquipmentBearProjectNum(enterpriseId,voltagetMap,220);
				
			//220kv获取人员可承载项目数与设备承载项目数的最小值,作为实际可以承载的项目数.
			  lineProjectNum220kv=Math.min(linePersonProjectNum220kv, lineEquipmentProjectNum220kv);
			
			//220kv 重新设置组件项目后的人员信息配置
			  lineProjectDto220kv=resetProjectConfig220kv(lineProjectDto500kv,lineProjectNum220kv,enterPerStaDto);
			
			
			//110kv计算时对应施工企业人员可以组建的项目个数
			  linePersonProjectNum110kv=getLineProject110kv(lineProjectDto220kv,enterPerStaDto);
			  lineProjectNum110kv=linePersonProjectNum110kv;
			
			
			
			
			//----------------------------变电工程-----------------------------------------
			
					
			//500kv计算时对应施工企业人员可以组建的项目个数
			  powerPersonProjectNum500kv=getLineProject500kv(powerProjectDto,enterPerStaDto);
					
				
			//500kv获取人员可承载项目数与设备承载项目数的最小值,作为实际可以承载的项目数.
			 powerProjectNum500kv=powerPersonProjectNum500kv;
					
			//500kv 设置组件项目后的人员信息配置
			 powerProjectDto500kv=resetProjectConfig500kv(powerProjectDto,powerProjectNum500kv,enterPerStaDto);
							
					
			//220kv计算时对应施工企业人员可以组建的项目个数
			  powerPersonProjectNum220kv=getLineProject220kv(powerProjectDto500kv,enterPerStaDto);
		
			//220kv获取人员可承载项目数与设备承载项目数的最小值,作为实际可以承载的项目数.
			  powerProjectNum220kv=powerPersonProjectNum220kv;
					
			//220kv 重新设置组件项目后的人员信息配置
			 powerProjectDto220kv=resetProjectConfig220kv(powerProjectDto500kv,powerProjectNum220kv,enterPerStaDto);
					
					
			//110kv计算时对应施工企业人员可以组建的项目个数
			  powerPersonProjectNum110kv=getLineProject110kv(powerProjectDto220kv,enterPerStaDto);
			  powerProjectNum110kv=powerPersonProjectNum110kv;
					
	
			
		}else if( enterprise.getOverallrank()==2 ||  enterprise.getProfessionrank()==2){
			//----------------------------------线路工程------------------------
			//220kv计算时对应施工企业人员可以组建的项目个数
			  linePersonProjectNum220kv=getLineProject220kv(lineProjectDto,enterPerStaDto);
			
			//220kv查询企业的设备信息(获取企业大张牵设备数)已经设备可承载的项目数
			  lineEquipmentProjectNum220kv=getEquipmentBearProjectNum(enterpriseId,voltagetMap,220);
				
			//220kv获取人员可承载项目数与设备承载项目数的最小值,作为实际可以承载的项目数.
			  lineProjectNum220kv=Math.min(linePersonProjectNum220kv, lineEquipmentProjectNum220kv);
			
			//220kv 重新设置组件项目后的人员信息配置
			  lineProjectDto220kv=resetProjectConfig220kv(lineProjectDto,lineProjectNum220kv,enterPerStaDto);
			
			
			//110kv计算时对应施工企业人员可以组建的项目个数
			  linePersonProjectNum110kv=getLineProject110kv(lineProjectDto220kv,enterPerStaDto);
			  lineProjectNum110kv=linePersonProjectNum110kv;
			
			
			//----------------------------变电工程-----------------------------------------
			
					
			//220kv计算时对应施工企业人员可以组建的项目个数
			 powerPersonProjectNum220kv=getLineProject220kv(powerProjectDto,enterPerStaDto);
		
			//220kv获取人员可承载项目数与设备承载项目数的最小值,作为实际可以承载的项目数.
			 powerProjectNum220kv=powerPersonProjectNum220kv;
					
			//220kv 重新设置组件项目后的人员信息配置
			 powerProjectDto220kv=resetProjectConfig220kv(powerProjectDto,powerProjectNum220kv,enterPerStaDto);
					
					
			//110kv计算时对应施工企业人员可以组建的项目个数
			 powerPersonProjectNum110kv=getLineProject110kv(powerProjectDto220kv,enterPerStaDto);
			 powerProjectNum110kv=powerPersonProjectNum110kv;
					
					
		}else if( enterprise.getOverallrank()==3 ||  enterprise.getProfessionrank()==3){
			//----------------------------------线路工程------------------------
			
			//110kv计算时对应施工企业人员可以组建的项目个数
			  linePersonProjectNum110kv=getLineProject110kv(lineProjectDto,enterPerStaDto);
			  lineProjectNum110kv=linePersonProjectNum110kv;
			
			
			//----------------------------变电工程-----------------------------------------
					
			//110kv计算时对应施工企业人员可以组建的项目个数
			  powerPersonProjectNum110kv=getLineProject110kv(powerProjectDto,enterPerStaDto);
			  powerProjectNum110kv=powerPersonProjectNum110kv;
					
		}
		
	
		//线路工程年产值合计
		lineProjectOutput=
				outputmap.get(500+""+ConstAnnualOutput.LINE_PROJECT)*lineProjectNum500kv
				+outputmap.get(220+""+ConstAnnualOutput.LINE_PROJECT)*lineProjectNum220kv
				+outputmap.get(110+""+ConstAnnualOutput.LINE_PROJECT)*lineProjectNum110kv;
		  
		//线路工程年产值合计
		powerProjectOutput=
						outputmap.get(500+""+ConstAnnualOutput.LINE_PROJECT)*powerProjectNum500kv
						+outputmap.get(220+""+ConstAnnualOutput.LINE_PROJECT)*powerProjectNum220kv
						+outputmap.get(110+""+ConstAnnualOutput.LINE_PROJECT)*powerProjectNum110kv;
		  
		BearResultDto result=new BearResultDto();
		result.setEnterpriseId(enterpriseId);
		result.setLine110kv(lineProjectNum110kv);
		result.setLine220kv(lineProjectNum220kv);
		result.setLine500kv(lineProjectNum500kv);
		result.setLineOutput(lineProjectOutput);
		result.setPower110kv(powerProjectNum110kv);
		result.setPower220kv(powerProjectNum220kv);
		result.setPower500kv(powerProjectNum500kv);
		result.setPowerOutput(powerProjectOutput);
		result.setOutputSum(lineProjectOutput+powerProjectOutput);
		
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
		lineProjectDto.setProjectNum(0);
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
	 * @param lineProjectDto500kv
	 * @param perManMap
	 * @param lineProfession
	 */
	private ProjectConfigDto resetProjectConfig500kv(ProjectConfigDto lineProjectDto,Integer lineProjectNum,
			EnterprisePerStaDto  enterPerStaDto) {
		
		Map<Byte, EnterprisePerStandard> perStaMap=enterPerStaDto.getPerStaMap();
		
		ProjectConfigDto lineProjectDto500kv=new ProjectConfigDto();
		lineProjectDto500kv.setSurplusOneManager(lineProjectDto.getSurplusOneManager()-lineProjectNum*perStaMap.get(1).getLineflatnum());
		lineProjectDto500kv.setSurplusTwoManager(lineProjectDto.getSurplusTwoManager());
		lineProjectDto500kv.setSurplusOneChief(lineProjectDto.getSurplusOneChief()-lineProjectNum*perStaMap.get(2).getLineflatnum());
		lineProjectDto500kv.setSurplusTwoChief(lineProjectDto.getSurplusTwoChief());
		lineProjectDto500kv.setSurplusSafetyOfficer(lineProjectDto.getSurplusSafetyOfficer()-lineProjectNum*perStaMap.get(3).getLineflatnum());
		lineProjectDto500kv.setSurplusInspector(lineProjectDto.getSurplusInspector()-lineProjectNum*perStaMap.get(4).getLineflatnum());
		lineProjectDto500kv.setSurplusPersonTotal(lineProjectDto.getSurplusPersonTotal()-lineProjectNum*enterPerStaDto.getLinePerStaSum());
		
		return  lineProjectDto500kv;
	}

	
	
	/**220kv 重新设置组件项目后的人员信息配置
	 * 
	 * @param lineProjectDto500kv
	 * @param lineProjectNum220kv
	 * @param enterPerStaDto
	 * @return
	 */
	private ProjectConfigDto resetProjectConfig220kv(
			ProjectConfigDto lineProjectDto500kv, Integer lineProjectNum220kv,
			EnterprisePerStaDto enterPerStaDto) {
		Map<Byte, EnterprisePerStandard> perStaMap=enterPerStaDto.getPerStaMap();
		
		ProjectConfigDto lineProjectDto220kv=new ProjectConfigDto();
		Integer  oneManager=lineProjectDto500kv.getSurplusOneManager()-lineProjectNum220kv*perStaMap.get(1).getLineflatnum();
		if(oneManager<=0){
			lineProjectDto500kv.setSurplusOneManager(0);
			lineProjectDto500kv.setSurplusTwoManager(lineProjectDto500kv.getSurplusTwoManager()+oneManager);
		}else{
			lineProjectDto500kv.setSurplusOneManager(oneManager);
			lineProjectDto500kv.setSurplusTwoManager(lineProjectDto500kv.getSurplusTwoManager());
		}
		
		lineProjectDto500kv.setSurplusOneChief(lineProjectDto500kv.getSurplusOneChief()-lineProjectNum220kv*perStaMap.get(2).getLineflatnum());
		lineProjectDto500kv.setSurplusTwoChief(lineProjectDto500kv.getSurplusTwoChief());
		lineProjectDto500kv.setSurplusSafetyOfficer(lineProjectDto500kv.getSurplusSafetyOfficer()-lineProjectNum220kv*perStaMap.get(3).getLineflatnum());
		lineProjectDto500kv.setSurplusInspector(lineProjectDto500kv.getSurplusInspector()-lineProjectNum220kv*perStaMap.get(4).getLineflatnum());
		lineProjectDto500kv.setSurplusPersonTotal(lineProjectDto500kv.getSurplusPersonTotal()-lineProjectNum220kv*enterPerStaDto.getLinePerStaSum());
		
		return  lineProjectDto220kv;
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
		List<EnterpriseEquipment>  enterEquipment=enterpriseEnterpriseEquipmentMapper.selectByExample(enterEquipmentExample);
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
	private Integer getLineProject500kv(ProjectConfigDto lineProjectDto,
			EnterprisePerStaDto enterPerStaDto) {
		Map<Byte, EnterprisePerStandard>  perStaMap=enterPerStaDto.getPerStaMap();
		//取500kv项目经理 ,项目总工人员的最小值(1 项目经理  2 项目总工, 3 安全员   4 质检员  与数据库表postClassify一一对应)
		Integer  minOne=Math.min(lineProjectDto.getSurplusOneManager()/perStaMap.get(1).getLineflatnum(),lineProjectDto.getSurplusOneChief()/perStaMap.get(2).getLineflatnum());
		//取安全员, 质检员最小值
		Integer  minTwo=Math.min(lineProjectDto.getSurplusSafetyOfficer()/perStaMap.get(3).getLineflatnum(),lineProjectDto.getSurplusInspector()/perStaMap.get(4).getLineflatnum());
					
		//项目必备人员可以主键的项目数
		Integer minPersonProjectN=Math.min(minOne, minTwo);
				
		//线路专业计算
		while(true){
				//大于当前线路专业总人数T
				if(minPersonProjectN*enterPerStaDto.getLinePerStaSum() > lineProjectDto.getSurplusPersonTotal()){
					minPersonProjectN--;
				}else{
					break;
				}
		}
		//返回可以人员可以组建的项目数
	
		return minPersonProjectN;
		
	}
	
	/**220kv计算时对应施工企业人员可以组建的项目个数
	 * 
	 * @param lineProjectDto500kv
	 * @param enterPerStaDto
	 * @return
	 */
	private Integer getLineProject220kv(ProjectConfigDto lineProjectDto,EnterprisePerStaDto enterPerStaDto) {
		
		Map<Byte, EnterprisePerStandard>  perStaMap=enterPerStaDto.getPerStaMap();
		//取500kv项目经理 ,项目总工人员的最小值(1 项目经理  2 项目总工, 3 安全员   4 质检员  与数据库表postClassify一一对应)
		Integer  minOne=Math.min(lineProjectDto.getSurplusOneManager()+lineProjectDto.getSurplusTwoManager()/perStaMap.get(1).getLineflatnum(),lineProjectDto.getSurplusOneChief()/perStaMap.get(2).getLineflatnum());
		//取安全员, 质检员最小值
		Integer  minTwo=Math.min(lineProjectDto.getSurplusSafetyOfficer()/perStaMap.get(3).getLineflatnum(),lineProjectDto.getSurplusInspector()/perStaMap.get(4).getLineflatnum());
					
		//项目必备人员可以主键的项目数
		Integer minPersonProjectN=Math.min(minOne, minTwo);
				
		//线路专业计算
		while(true){
				//大于当前线路专业总人数T
				if(minPersonProjectN*enterPerStaDto.getLinePerStaSum() > lineProjectDto.getSurplusPersonTotal()){
					minPersonProjectN--;
				}else{
					break;
				}
		}
		//返回可以人员可以组建的项目数
		return minPersonProjectN;
	}
	
	/**110kv计算时对应施工企业人员可以组建的项目个数
	 * 
	 * @param lineProjectDto220kv
	 * @param enterPerStaDto
	 * @return
	 */
	private Integer getLineProject110kv(ProjectConfigDto lineProjectDto220kv,
			EnterprisePerStaDto enterPerStaDto) {
		Map<Byte, EnterprisePerStandard>  perStaMap=enterPerStaDto.getPerStaMap();
		//取500kv项目经理 ,项目总工人员的最小值(1 项目经理  2 项目总工, 3 安全员   4 质检员  与数据库表postClassify一一对应)
		Integer  minOne=Math.min(lineProjectDto220kv.getSurplusOneManager()+lineProjectDto220kv.getSurplusTwoManager()/perStaMap.get(1).getLineflatnum(),lineProjectDto220kv.getSurplusOneChief()+lineProjectDto220kv.getSurplusTwoChief()/perStaMap.get(2).getLineflatnum());
		//取安全员, 质检员最小值
		Integer  minTwo=Math.min(lineProjectDto220kv.getSurplusSafetyOfficer()/perStaMap.get(3).getLineflatnum(),lineProjectDto220kv.getSurplusInspector()/perStaMap.get(4).getLineflatnum());
					
		//项目必备人员可以主键的项目数
		Integer minPersonProjectN=Math.min(minOne, minTwo);
				
		//线路专业计算
		while(true){
				//大于当前线路专业总人数T
				if(minPersonProjectN*enterPerStaDto.getLinePerStaSum() > lineProjectDto220kv.getSurplusPersonTotal()){
					minPersonProjectN--;
				}else{
					break;
				}
		}
		//返回可以人员可以组建的项目数
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
		Map<Byte, EnterprisePerStandard>  perStaMap=new HashMap<Byte, EnterprisePerStandard>();
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







}
