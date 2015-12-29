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

import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionProjectBuildBear;
import com.ronyao.cca.ui.vo.BearProjectBuildVo;





/**施工企业还可以承载项目情况(施工单位剩余承载力).
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/projectBuildBear")
public class ProjectBuildBearAction {

	@Resource
	private  ActionProjectBuildBear  actionProjectBuildBear; 
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("主管单位");	
		excelHeaderList.add("施工企业名称");
		excelHeaderList.add("500kV(还可以承担线路工程)");
		excelHeaderList.add("220kV(还可以承担线路工程)");
		excelHeaderList.add("110kV(还可以承担线路工程)");
		excelHeaderList.add("500kV(还可以承担变电工程)");
		excelHeaderList.add("220kV(还可以承担变电工程)");
		excelHeaderList.add("110kV(还可以承担变电工程)");
				

        List<BearProjectBuildVo> enterpList = actionProjectBuildBear.getBearProjectBuildVoList();
        if(enterpList==null  || enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
     
        Integer line110kvSum=0;
        Integer line220kvSum=0;
        Integer line500kvSum=0;
        Integer power110kvSum=0;
        Integer power220kvSum=0;
        Integer power500kvSum=0;
        for (int i=0;i<enterpList.size() ;i++) {
        	BearProjectBuildVo enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enter.getSupervisorunit());
        	 map.put(2, enter.getEnterpriseName());
        	
        	 map.put(3, enter.getLine500kv()+"");
        	 line500kvSum=line500kvSum+enter.getLine500kv();
        	 map.put(4, enter.getLine220kv()+""); 
        	 line220kvSum=line220kvSum+enter.getLine220kv();
        	 map.put(5, enter.getLine110kv()+"");
        	 line110kvSum=line110kvSum+enter.getLine110kv();
        	
        	 map.put(6,enter.getPower500kv()+"");
        	 power500kvSum=power500kvSum+enter.getPower500kv();
        	 map.put(7, enter.getPower220kv()+"");
        	 power220kvSum=power220kvSum+enter.getPower220kv();
        	 map.put(8, enter.getPower110kv()+"");
        	 power110kvSum=power110kvSum+enter.getPower110kv();
        	 
        	 valueMap.add(map);
       
		}
      //指定列求和的值
        Map<Integer , String>  map=new HashMap<Integer, String>();
     
        map.put(3, "合计 :  "+line500kvSum+"");
        map.put(4, "合计 :  "+line220kvSum+"");
        map.put(5, "合计 :  "+line110kvSum+"");
        map.put(6, "合计 :  "+power500kvSum);
        map.put(7, "合计 :  "+power220kvSum);
        map.put(8, "合计 :  "+power110kvSum);
     
        valueMap.add(map);
       
        //导出
        ExcelUtil.excelExport("施工单位剩余承载力", excelHeaderList, valueMap, response);
    }
}
