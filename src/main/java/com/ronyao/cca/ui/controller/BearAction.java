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
import com.ronyao.cca.ui.extDirect.ActionBear;






/**承载能力计算结果.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/bear")
public class BearAction {

	@Resource
	private ActionBear  actionBear;
	
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
		
				
	
		
		List<BearResultDto> enterpList = actionBear.getBearResultList();
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Map<Integer, Enterprise> enterpriseMap=constDictionary.getEnterpriseMap();
        for (int i=0;i<enterpList.size() ;i++) {
        	BearResultDto enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enterpriseMap.get(enter.getEnterpriseid()).getName());
        	 map.put(2, enter.getLine500kv()+"");
        	 map.put(3, enter.getLine220kv()+"");
        	 map.put(4, enter.getLine110kv()+"");  
        	 map.put(5, enter.getLineOutput()+"");
        	 map.put(6, enter.getPower500kv()+"");
        	 map.put(7, enter.getPower220kv()+"");
        	 map.put(8,enter.getPower110kv()+"");
        	 map.put(9,enter.getPowerOutput()+"");
        	 map.put(10,enter.getOutputSum()+"");
        
  
        	 valueMap.add(map);
       
		}
       
        //导出
        ExcelUtil.excelExport("承载能力计算结果", excelHeaderList, valueMap, response);
    }
}
