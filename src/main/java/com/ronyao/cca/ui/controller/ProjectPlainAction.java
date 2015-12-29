package com.ronyao.cca.ui.controller;

import java.text.DecimalFormat;
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
import com.ronyao.cca.db.model.ProjectPlain;
import com.ronyao.cca.db.model.VoltageRankClassify;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionProjectPlain;





/**下一年度公司新开工项目情况.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/projectPlain")
public class ProjectPlainAction {

	@Resource
	private ActionProjectPlain  actionProjectPlain;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("电压等级");	
		excelHeaderList.add("项目年份");
		excelHeaderList.add("项目个数(个)");
		excelHeaderList.add("线路工程数(标包数(个))");
		excelHeaderList.add("变电工程数(标包数(个))");
		excelHeaderList.add("线路工程数(评估可承担个数(个))");		
		excelHeaderList.add("变电工程数(评估可承担个数(个))");
		excelHeaderList.add("线路长度(公里)");
		excelHeaderList.add("变电容量(万千伏安)");
		excelHeaderList.add("总投资(亿元)");	
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				

        List<ProjectPlain> enterpList = actionProjectPlain.getProjectPlainList();
        if(enterpList==null  || enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Map<Integer, VoltageRankClassify>  voltageRankClassifyMap=constDictionary.getVoltageRankClassifyMap();
        
        Integer projectNumSum=0;
        Integer lineprojectSum=0;
        Integer powerprojectSum=0;
        Integer assesslineprojectSum=0;
        Integer assesspowerprojectSum=0;
        Integer lineLengthSum=0;
        Integer volumeSum=0;
        Float investmentSum=0f;
        for (int i=0;i<enterpList.size() ;i++) {
        	ProjectPlain enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, voltageRankClassifyMap.get(enter.getVoltagerankclassifyid()).getName());
        	 map.put(2, enter.getYear()+"年");	
        	 map.put(3, enter.getProjectnum()+"");
        	 projectNumSum=projectNumSum+enter.getProjectnum();
        	 map.put(4, enter.getLineproject()+"");  
        	 lineprojectSum=lineprojectSum+enter.getLineproject();
        	 map.put(5, enter.getPowerproject()+"");
        	 powerprojectSum=powerprojectSum+enter.getPowerproject();     
        	 map.put(6, enter.getAssesslineproject()+"");
        	 assesslineprojectSum=assesslineprojectSum+enter.getAssesslineproject();
        	 map.put(7, enter.getAssesspowerproject()+"");
        	 assesspowerprojectSum=assesspowerprojectSum+enter.getAssesspowerproject();
        	 map.put(8, enter.getLinelength()+"");
        	 lineLengthSum=lineLengthSum+enter.getLinelength();
        	 map.put(9, enter.getVolume()+"");
        	 volumeSum=volumeSum+enter.getVolume();
        	 map.put(10, enter.getInvestment()+"");
        	 investmentSum=investmentSum+enter.getInvestment().floatValue();
        	 
        	 map.put(11, enter.getCreatetime());
        	 
        	 map.put(12,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
        
        //指定列求和的值
        Map<Integer , String>  map=new HashMap<Integer, String>();
     
        map.put(3, "合计 :  "+projectNumSum+"");
        map.put(4, "合计 :  "+lineprojectSum+"");
        map.put(5, "合计 :  "+powerprojectSum+"");
        map.put(6, "合计 :  "+assesslineprojectSum);
        map.put(7, "合计 :  "+assesspowerprojectSum);
        map.put(8, "合计 :  "+lineLengthSum);
        map.put(9, "合计 :  "+volumeSum);
        map.put(10, "合计 :  "+new DecimalFormat(".00").format(investmentSum));
      
        
        valueMap.add(map);
       
        //导出
        ExcelUtil.excelExport("下一年度公司新开工项目情况", excelHeaderList, valueMap, response);
    }
}
