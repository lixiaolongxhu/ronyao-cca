package com.ronyao.cca.ui.controller;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ronyao.cca.constant.ConstDictionary;
import com.ronyao.cca.db.dao.BehaviorMapper;
import com.ronyao.cca.db.model.Behavior;
import com.ronyao.cca.db.model.BehaviorExample;
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.tool.ExcelUtil;





/**不良行为影响修正系数.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/behavior")
public class BehaviorAction {

	@Resource
	private BehaviorMapper  behaviorMapper;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("ID");
		excelHeaderList.add("施工企业名称");	
		excelHeaderList.add("不良行为发生年份");
		excelHeaderList.add("严重不良行为次数");
		excelHeaderList.add("一般不良行为次数");
		excelHeaderList.add("修正系数");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				
	
		BehaviorExample example=new BehaviorExample();
        List<Behavior> enterpList = behaviorMapper.selectByExample(example);
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        
        Map<Integer, Enterprise> enterpriseMap=constDictionary.getEnterpriseMap();
        for (int i=0;i<enterpList.size() ;i++) {
        	 Behavior enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enterpriseMap.get(enter.getEnterpriseid()).getName()+"");
        	 map.put(2,enter.getYear() +"年");
        	
        	 map.put(3,enter.getSeriousbadnum() +"");
        	
        	 map.put(4, enter.getGeneralbadnum()+"");  
        
        	 map.put(5, enter.getCorrection()+"");
        	
        	 map.put(6, enter.getCreatetime());
        
        	 map.put(7, enter.getUpdatetime()+"");
        	 
        	 valueMap.add(map);
       
		}
       
        //导出
        ExcelUtil.excelExport("不良行为影响修正系数", excelHeaderList, valueMap, response);
    }
}