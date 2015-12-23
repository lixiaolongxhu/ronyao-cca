package com.ronyao.cca.constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;



import com.ronyao.cca.db.dao.AptitudeRankClassifyMapper;
import com.ronyao.cca.db.model.AptitudeRankClassify;
import com.ronyao.cca.db.model.AptitudeRankClassifyExample;

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
	
	@Resource
	private  AptitudeRankClassifyMapper  aptitudeRankClassifyMapper;
	
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
}
