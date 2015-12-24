package com.ronyao.cca.constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



import com.ronyao.cca.db.dao.AptitudeClassifyMapper;
import com.ronyao.cca.db.dao.AptitudeRankClassifyMapper;
import com.ronyao.cca.db.dao.EnterpriseMapper;
import com.ronyao.cca.db.dao.PostClassifyMapper;
import com.ronyao.cca.db.dao.VoltageRankClassifyMapper;
import com.ronyao.cca.db.model.AptitudeClassify;
import com.ronyao.cca.db.model.AptitudeClassifyExample;
import com.ronyao.cca.db.model.AptitudeRankClassify;
import com.ronyao.cca.db.model.AptitudeRankClassifyExample;
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.EnterpriseExample;
import com.ronyao.cca.db.model.PostClassify;
import com.ronyao.cca.db.model.PostClassifyExample;
import com.ronyao.cca.db.model.VoltageRankClassify;
import com.ronyao.cca.db.model.VoltageRankClassifyExample;

/**系统数据库字典常量信息(默认该类实例方式为单例模式)
 * 
 * @author user
 *
 */
@Component
public  class ConstDictionary {

	private static final  Logger  LOG=LoggerFactory.getLogger(ConstDictionary.class);
	
	@Resource
	private  AptitudeRankClassifyMapper  aptitudeRankClassifyMapper;
	
	@Resource
	private EnterpriseMapper  enterpriseMapper;
	
	@Resource
	private AptitudeClassifyMapper  aptitudeClassifyMapper;
	
	@Resource
	private PostClassifyMapper postClassifyMapper;
	
	@Resource
	private VoltageRankClassifyMapper voltageRankClassifyMapper;
	
	/**获取企业资质等级信息列表
	 * 
	 */
	public  Map<Byte, AptitudeRankClassify>  aptitudeRankClassifyMap=null;
	public  List<AptitudeRankClassify>  aptitudeRankClassifyList=null;
	/**企业基本信息
	 * 
	 */
	public  Map<Integer, Enterprise>  enterpriseMap=null;
	public  List<Enterprise>  enterpriseList=null;
	
	/**企业资质分类.
	 * 
	 */
	public  Map<Byte, AptitudeClassify>  aptitudeClassifyMap=null;
	public  List<AptitudeClassify>  aptitudeClassifyList=null;	
	
	/**岗位分类
	 * 
	 */
	public   Map<Integer, PostClassify>  postClassifyMap=null;
	public   List<PostClassify>  postClassifyList=null;

	
	/**电压等级分类
	 * 
	 */	
	public   Map<Integer, VoltageRankClassify>  voltageRankClassifyMap=null;
	public  List<VoltageRankClassify>  voltageRankClassifyList=null;
	
	
	/**初始载入基础数据配置.
	 * 
	 */
	public void  initLoadDictionay(){
		LOG.info("数据库基本字典数据初始载入...");
		
		//获取企业资质等级信息列表
		AptitudeRankClassifyExample example=new AptitudeRankClassifyExample();
		aptitudeRankClassifyList=aptitudeRankClassifyMapper.selectByExample(example);
		if(!aptitudeRankClassifyList.isEmpty()){
			aptitudeRankClassifyMap =new HashMap<Byte, AptitudeRankClassify>();
			for (AptitudeRankClassify aptitudeRankClassify : aptitudeRankClassifyList) {
				aptitudeRankClassifyMap.put(aptitudeRankClassify.getId(), aptitudeRankClassify);
			}
		}
		
		//企业基本信息
		EnterpriseExample enterpriseexample=new EnterpriseExample();
		enterpriseList=enterpriseMapper.selectByExample(enterpriseexample);
		if(!enterpriseList.isEmpty()){
			enterpriseMap=new HashMap<Integer, Enterprise>();
			for (Enterprise enterprise : enterpriseList) {
				enterpriseMap.put(enterprise.getId(), enterprise);
			}
		}
		
		//企业资质分类
		AptitudeClassifyExample apititudeClassifyexample=new AptitudeClassifyExample();
		aptitudeClassifyList=aptitudeClassifyMapper.selectByExample(apititudeClassifyexample);
		if(!aptitudeClassifyList.isEmpty()){
			aptitudeClassifyMap=new HashMap<Byte, AptitudeClassify>();
			for (AptitudeClassify enterprise : aptitudeClassifyList) {
				aptitudeClassifyMap.put(enterprise.getId(), enterprise);
			}
		}
		//岗位分类
		PostClassifyExample postclassifyexample=new PostClassifyExample();
		postClassifyList=postClassifyMapper.selectByExample(postclassifyexample);
		if(!postClassifyList.isEmpty()){
			postClassifyMap=new HashMap<Integer, PostClassify>();
			for (PostClassify enterprise : postClassifyList) {
				postClassifyMap.put(enterprise.getId(), enterprise);
			}
		}
		
		//电压等级分类
		VoltageRankClassifyExample  voltagerankclassifyexample=new VoltageRankClassifyExample();
		voltageRankClassifyList=voltageRankClassifyMapper.selectByExample(voltagerankclassifyexample);
		if(!voltageRankClassifyList.isEmpty()){
			voltageRankClassifyMap=new HashMap<Integer, VoltageRankClassify>();
			for (VoltageRankClassify enterprise : voltageRankClassifyList) {
				voltageRankClassifyMap.put(enterprise.getId(), enterprise);
			}
		}
	}
	
	

	
	
	
	
	

}
