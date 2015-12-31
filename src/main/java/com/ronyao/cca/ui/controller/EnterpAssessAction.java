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
import com.ronyao.cca.db.model.EnterpriseAssess;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionEnterpAssess;





/**施工企业评估分类.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/enterpriseAssess")
public class EnterpAssessAction {

	@Resource
	private ActionEnterpAssess  actionEnterpAssess;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("类别");	
		excelHeaderList.add("标准");
		excelHeaderList.add("可承载项目最少个数(个)");
		excelHeaderList.add("可承载项目最多个数(个)");
		excelHeaderList.add("可承载工程最小产值(亿元)");
		excelHeaderList.add("可承载工程最大产值(亿元)");
		excelHeaderList.add("施工企业");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				

        List<EnterpriseAssess> enterpList = actionEnterpAssess.getEnterpriseAssessList();
        if(enterpList==null  || enterpList.isEmpty()){
        	response.setHeader("content-type", "text/html;charset=UTF-8");
        	response.setCharacterEncoding("UTF-8");
        	response.getWriter().write("没有可以导出的内容:     <a href='javascript:history.go(-1)'><H2> 返回<H2></a> ");
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        
        for (int i=0;i<enterpList.size() ;i++) {
        	EnterpriseAssess enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enter.getCategory());
        	 map.put(2, enter.getStandard());
        	 if(enter.getProjectnumstart()==null){
        		 map.put(3, "");
        	 }else{
        		 map.put(3, enter.getProjectnumstart()+"");
        	 }
        	 
        	
        	 if(enter.getProjectnumend()==null){
        		 map.put(4, "");  
        	 }else{
        		 map.put(4, enter.getProjectnumend()+"");  
        	 }
        	
        	 
        	 if(enter.getOutputstart()==null){
        		 map.put(5, "");
        	 }else{
        		 map.put(5, enter.getOutputstart()+""); 
        	 }
        	
        	
        	 if(enter.getOutputend()==null){
        		 map.put(6, "");
        	 }else {
        		 map.put(6, enter.getOutputend()+"");
        	 }
        
        
        	 map.put(7, enter.getEnterprise()+"");
  
        	 map.put(8, enter.getCreatetime());
        	 
        	 map.put(9,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
       
        //导出
        ExcelUtil.excelExport("施工企业评估分类", excelHeaderList, valueMap, response);
    }
}
