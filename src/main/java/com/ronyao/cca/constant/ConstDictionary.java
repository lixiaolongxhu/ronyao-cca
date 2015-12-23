package com.ronyao.cca.constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

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

/**系统数据库字典常量信息
 * 
 * @author user
 *
 */
@Component
public  class ConstDictionary {

	/**企业资质等级
	 * 
	 */
	private static   Map<Byte, AptitudeRankClassify>  aptitudeRankClassifyMap=null;
	
	/**企业基本信息
	 * 
	 */
	private static Map<Integer, Enterprise>  enterpriseMap=null;
	
	/**企业资质分类
	 * 
	 */
	private static Map<Byte, AptitudeClassify>  aptitudeClassifyMap=null;
	
	/**岗位分类
	 * 
	 */
	private static Map<Integer, PostClassify>  postClassifyMap=null;
	
	/**电压等级分类
	 * 
	 */
	private static Map<Integer, VoltageRankClassify>  voltageRankClassify=null;
	
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
	 * @return
	 */
	public   Map<Byte, AptitudeRankClassify>    getAptitudeRankClassifyMap(){
	
		if(aptitudeRankClassifyMap==null || aptitudeRankClassifyMap.isEmpty()){
			AptitudeRankClassifyExample example=new AptitudeRankClassifyExample();
			List<AptitudeRankClassify>   ac=aptitudeRankClassifyMapper.selectByExample(example);
			if(!ac.isEmpty()){
				aptitudeRankClassifyMap =new HashMap<Byte, AptitudeRankClassify>();
				for (AptitudeRankClassify aptitudeRankClassify : ac) {
					aptitudeRankClassifyMap.put(aptitudeRankClassify.getId(), aptitudeRankClassify);
				}
			}
			
		}
		return aptitudeRankClassifyMap;
	}
	
	public Map<Integer, Enterprise> getEnterpriseMap(){
		if(enterpriseMap==null || enterpriseMap.isEmpty()){
			EnterpriseExample example=new EnterpriseExample();
			List<Enterprise> enterpList=enterpriseMapper.selectByExample(example);
			if(!enterpList.isEmpty()){
				enterpriseMap=new HashMap<Integer, Enterprise>();
				for (Enterprise enterprise : enterpList) {
					enterpriseMap.put(enterprise.getId(), enterprise);
				}
			}
		}
		
		return enterpriseMap;
	}
	
	public Map<Byte, AptitudeClassify> getAptitudeClassifyMap(){
		if(aptitudeClassifyMap==null || aptitudeClassifyMap.isEmpty()){
			AptitudeClassifyExample example=new AptitudeClassifyExample();
			List<AptitudeClassify> enterpList=aptitudeClassifyMapper.selectByExample(example);
			if(!enterpList.isEmpty()){
				aptitudeClassifyMap=new HashMap<Byte, AptitudeClassify>();
				for (AptitudeClassify enterprise : enterpList) {
					aptitudeClassifyMap.put(enterprise.getId(), enterprise);
				}
			}
		}
		
		return aptitudeClassifyMap;
	}
	
	public Map<Integer, PostClassify> getPostClassifyMap(){
		if(postClassifyMap==null || postClassifyMap.isEmpty()){
			PostClassifyExample example=new PostClassifyExample();
			List<PostClassify> enterpList=postClassifyMapper.selectByExample(example);
			if(!enterpList.isEmpty()){
				postClassifyMap=new HashMap<Integer, PostClassify>();
				for (PostClassify enterprise : enterpList) {
					postClassifyMap.put(enterprise.getId(), enterprise);
				}
			}
		}
		
		return postClassifyMap;
	}
	
	public Map<Integer, VoltageRankClassify> getVoltageRankClassifyMap(){
		if(voltageRankClassify==null || voltageRankClassify.isEmpty()){
			VoltageRankClassifyExample example=new VoltageRankClassifyExample();
			List<VoltageRankClassify> enterpList=voltageRankClassifyMapper.selectByExample(example);
			if(!enterpList.isEmpty()){
				voltageRankClassify=new HashMap<Integer, VoltageRankClassify>();
				for (VoltageRankClassify enterprise : enterpList) {
					voltageRankClassify.put(enterprise.getId(), enterprise);
				}
			}
		}
		
		return voltageRankClassify;
	}
}
