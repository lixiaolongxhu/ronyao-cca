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
import com.ronyao.cca.db.model.BehaviorStandardWithBLOBs;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionBehaviorSta;





/**施工企业不良行文分类标准.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/behaviorSta")
public class BehaviorStaAction {

	@Resource
	private ActionBehaviorSta  actionBehaviorSta  ;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("不良行为等级");	
		excelHeaderList.add("诚信");
		excelHeaderList.add("安全质量");
		excelHeaderList.add("履约进度");
		excelHeaderList.add("服务");
		excelHeaderList.add("其他");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				

        List<BehaviorStandardWithBLOBs> enterpList = actionBehaviorSta.getBehaviorStandardsList();
        if(enterpList==null  || enterpList.isEmpty()){
        	response.setHeader("content-type", "text/html;charset=UTF-8");
        	response.setCharacterEncoding("UTF-8");
        	response.getWriter().write("没有可以导出的内容:     <a href='javascript:history.go(-1)'><H2> 返回<H2></a> ");
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
      
        for (int i=0;i<enterpList.size() ;i++) {
        	BehaviorStandardWithBLOBs enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
//        	 [[1,'严重不良行为'],[2,'一般不良行为']]
        	 if(enter.getRanktype()==1){
        		 map.put(1, "严重不良行为");
        	 }else{
        		 map.put(1, "一般不良行为");
        	 }
        	 
        	 map.put(2, enter.getSincerity());
        	 map.put(3, enter.getSave()+"");
        	
        	
        	
        	 map.put(4, enter.getProgress()+"");  
     
        	 map.put(5, enter.getService()+"");
        	
        
        	 map.put(6, enter.getOther()+"");
        	 
  
        	 map.put(7, enter.getCreatetime());
        	 
        	 map.put(8,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
       
        //导出
        ExcelUtil.excelExport("施工企业不良行文分类标准", excelHeaderList, valueMap, response);
    }
}
