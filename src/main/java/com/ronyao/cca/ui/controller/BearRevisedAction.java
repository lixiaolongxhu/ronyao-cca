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
import com.ronyao.cca.service.dto.BearResultDto;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionBearRevised;






/**不良行为影响修正结果.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/bearRevised")
public class BearRevisedAction {

	@Resource
	private ActionBearRevised  actionBearRevised;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("施工企业名称");	
		excelHeaderList.add("500kV(个)(线路工程)");
		excelHeaderList.add("220kV(个)(线路工程)");
		excelHeaderList.add("110kV(个)(线路工程)");
		excelHeaderList.add("产值(万元)(线路工程)");
		excelHeaderList.add("500kV(个)(变电工程)");
		excelHeaderList.add("220kV(个)(变电工程)");
		excelHeaderList.add("110kV(个)(变电工程)");
		excelHeaderList.add("产值(万元)(变电工程)");
		excelHeaderList.add("合计(万元)");
		
				
	
		
		List<BearResultDto> enterpList = actionBearRevised.getBearRevisedList();
		if(enterpList==null  || enterpList.isEmpty()){
        	response.setHeader("content-type", "text/html;charset=UTF-8");
        	response.setCharacterEncoding("UTF-8");
        	response.getWriter().write("没有可以导出的内容:     <a href='javascript:history.go(-1)'><H2> 返回<H2></a> ");
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Map<Integer, Enterprise> enterpriseMap=constDictionary.getEnterpriseMap();
        Integer line500kvSum=0;
        Integer line220kvSum=0;
        Integer line110kvSum=0;
        Integer lineOutputSum=0;
        Integer power500kvSum=0;
        Integer power220kvSum=0;
        Integer power110kvSum=0;
        Integer powerOutputSum=0;
        Integer outputSum=0;
        for (int i=0;i<enterpList.size() ;i++) {
        	BearResultDto enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enterpriseMap.get(enter.getEnterpriseid()).getName());
        	 map.put(2, enter.getLine500kv()+"");
        	 line500kvSum=line500kvSum+enter.getLine500kv();
        	 map.put(3, enter.getLine220kv()+"");
        	 line220kvSum=line220kvSum+enter.getLine220kv();
        	 map.put(4, enter.getLine110kv()+"");  
        	 line110kvSum=line110kvSum+enter.getLine110kv();
        	 map.put(5, enter.getLineOutput()+"");
        	 lineOutputSum=lineOutputSum+enter.getLineOutput();
        	 map.put(6, enter.getPower500kv()+"");
        	 power500kvSum=power500kvSum+enter.getPower500kv();
        	 map.put(7, enter.getPower220kv()+"");
        	 power220kvSum=power220kvSum+enter.getPower220kv();
        	 map.put(8,enter.getPower110kv()+"");
        	 power110kvSum=power110kvSum+enter.getPower110kv();
        	 map.put(9,enter.getPowerOutput()+"");
        	 powerOutputSum=powerOutputSum+enter.getPowerOutput();
        	 map.put(10,enter.getOutputSum()+"");
        	 outputSum=outputSum+enter.getOutputSum();
        
  
        	 valueMap.add(map);
       
		}
      //指定列求和的值
        Map<Integer , String>  map=new HashMap<Integer, String>();
       
        map.put(2, "合计 :  "+line500kvSum);
        map.put(3, "合计 :  "+line220kvSum+"");
        map.put(4, "合计 :  "+line110kvSum);
        map.put(5, "合计 :  "+lineOutputSum);
        map.put(6, "合计 :  "+power500kvSum);
        map.put(7, "合计 :  "+power220kvSum);
        map.put(8, "合计 :  "+power110kvSum);
        map.put(9, "合计 :  "+powerOutputSum);
        map.put(10, "小计 :  "+outputSum);
        
        valueMap.add(map);
       
        //导出
        ExcelUtil.excelExport("不良行为修正结果", excelHeaderList, valueMap, response);
    }
}
