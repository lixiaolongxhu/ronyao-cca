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
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.ProjectBuild;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionProjectBuild;






/**在建工程情况 与中标未开工情况.
 * 
 * @author user
 *
 */

@Controller

public class ProjectBuildAction {

	@Resource
	private  ActionProjectBuild actionProjectBuild;
	
	@Resource
	private ConstDictionary  constDictionary;

	/**配置excel导出对应列具体的值
	 * 
	 * @param enterpList
	 * @return
	 */
	private    List<Map<Integer , String>>    getProjectBuildMap(List<ProjectBuild> enterpList){
		 List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
	        Map<Integer, Enterprise>  enterpriseMap=constDictionary.getEnterpriseMap();
	       
	        Integer line110kvSum=0;
	        Integer line220kvSum=0;
	        Integer line500kvSum=0;
	        Integer power110kvSum=0;
	        Integer power220kvSum=0;
	        Integer power500kvSum=0;
	        for (int i=0;i<enterpList.size() ;i++) {
	        	ProjectBuild enter=enterpList.get(i);
	        	 Map<Integer , String>  map=new HashMap<Integer, String>();
	        	 
	        	 map.put(0, String.valueOf(i+1));
	        	 map.put(1,enter.getSupervisorunit() );
	        	 map.put(2,enterpriseMap.get(enter.getEnterpriseid()).getName()+"");
	        	 map.put(3, enter.getYear()+"年");  
	       
	        	 map.put(4, enter.getLine500kv()+"");
	        	 line500kvSum=line500kvSum+enter.getLine500kv();
	        	 map.put(5, enter.getLine220kv()+"");
	        	 line220kvSum=line220kvSum+enter.getLine220kv();
	        	 map.put(6, enter.getLine110kv()+"");
	        	 line110kvSum=line110kvSum+enter.getLine110kv();
	        	
	        	 map.put(7, enter.getPower500kv()+"");
	        	 power500kvSum=power500kvSum+enter.getPower500kv();	 
	        	 map.put(8, enter.getPower220kv()+"");
	        	 power220kvSum=power220kvSum+enter.getPower220kv();
	        	 map.put(9, enter.getPower110kv()+"");
	        	 power110kvSum=power110kvSum+enter.getPower110kv();
	        	 
	  
	        	 map.put(10, enter.getCreatetime());
	        	 
	        	 map.put(11,enter.getUpdatetime());
	        	
	        	 valueMap.add(map);
	       
			}
	        //指定列求和的值
	        Map<Integer , String>  map=new HashMap<Integer, String>();
	     
	        map.put(4, "合计 :  "+line500kvSum);
	        map.put(5, "合计 :  "+line220kvSum+"");
	        map.put(6, "合计 :  "+line110kvSum+"");
	       
	        map.put(7, "合计 :  "+power500kvSum);
	   
	        map.put(8, "合计 :  "+power220kvSum);
	        map.put(9, "合计 :  "+power110kvSum);
	  
	        valueMap.add(map);
	        
	        return valueMap;
	}
	
	/**中标 ,在建工程数
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/projectBuilding/excel")
	public void exportExcelBuilding(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("主管单位");	
		excelHeaderList.add("施工企业名称");
		excelHeaderList.add("项目年份");
		excelHeaderList.add("500kV(在建线路工程(个))");
		excelHeaderList.add("220kV(在建线路工程(个))");
		excelHeaderList.add("110kV(在建线路工程(个))");
		
		excelHeaderList.add("500kV(在建变电工程(个))");
		excelHeaderList.add("220kV(在建变电工程(个))");
		excelHeaderList.add("110kV(在建变电工程(个))");
		
		
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				

        List<ProjectBuild> enterpList = actionProjectBuild.getProjectBuildingList();
        if(enterpList==null  || enterpList.isEmpty()){
        	response.setHeader("content-type", "text/html;charset=UTF-8");
        	response.setCharacterEncoding("UTF-8");
        	response.getWriter().write("没有可以导出的内容:     <a href='javascript:history.go(-1)'><H2> 返回<H2></a> ");
        	return;
        }
        //导出
        ExcelUtil.excelExport("在建工程情况 ", excelHeaderList, getProjectBuildMap(enterpList), response);
    }
	
	/**中标,未开工项目情况
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/projectNoBuild/excel")
	public void exportExcelNoBuild(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("主管单位");	
		excelHeaderList.add("施工企业名称");
		excelHeaderList.add("项目年份");
		excelHeaderList.add("500kV(中标未开工线路工程(个))");
		excelHeaderList.add("220kV(中标未开工线路工程(个))");
		excelHeaderList.add("110kV(中标未开工线路工程(个))");
		excelHeaderList.add("500kV(中标未开工变电工程(个))");
		excelHeaderList.add("220kV(中标未开工变电工程(个))");
		excelHeaderList.add("110kV(中标未开工变电工程(个))");
		
		
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				

        List<ProjectBuild> enterpList = actionProjectBuild.getProjectNoBuildList();
        if(enterpList==null  || enterpList.isEmpty()){
        	return;
        }
        

        //导出
        ExcelUtil.excelExport("中标未开工情况 ", excelHeaderList, getProjectBuildMap(enterpList), response);
    }
}
