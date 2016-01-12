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
import com.ronyao.cca.db.model.AptitudeClassify;
import com.ronyao.cca.db.model.AptitudeRankClassify;
import com.ronyao.cca.db.model.EnterpriseAptitudeWithBLOBs;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionEnterpApt;







/**企业资质标准分类表信息.
 * 
 * @author user
 *
 */
@Controller
@RequestMapping(value="/enterpriseApt")
public class EnterpAptAction {

	
	@Resource
	private ConstDictionary  constDictionary;
	
	@Resource
	private ActionEnterpApt  actionEnterpApt;

	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{
		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("企业资质");
		excelHeaderList.add("等级");
		excelHeaderList.add("资质要求");
		excelHeaderList.add("执业资格(企业人员)");
		excelHeaderList.add("技术负责人(企业人员)");
		excelHeaderList.add("技术人员(企业人员)");
		excelHeaderList.add("技能人员(企业人员)");
		excelHeaderList.add("承包范围");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				
	

        List<EnterpriseAptitudeWithBLOBs> enterpList = actionEnterpApt.getEnterpriseAptitudeList();
        if(enterpList==null  || enterpList.isEmpty()){
        	response.setHeader("content-type", "text/html;charset=UTF-8");
        	response.setCharacterEncoding("UTF-8");
        	response.getWriter().write("没有可以导出的内容:     <a href='javascript:history.go(-1)'><H2> 返回<H2></a> ");
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Map<Byte, AptitudeRankClassify> aptitudeRankClassifyMap=constDictionary.getAptitudeRankClassifyMap();
        Map<Byte, AptitudeClassify> aptitudeClassifyMap=constDictionary.getAptitudeClassifyMap();
        for (int i=0;i<enterpList.size() ;i++) {
        	EnterpriseAptitudeWithBLOBs enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, aptitudeClassifyMap.get(enter.getAptitudeid()).getName()+"");
        	 map.put(2,aptitudeRankClassifyMap.get(enter.getAptituderank()).getName()+"" );
        	 map.put(3,enter.getQualifications() );
        	 map.put(4, enter.getPracticing());
        	
        	 map.put(5, enter.getCharge()+"");
        	 map.put(6, enter.getTechnical()+"");
        	 map.put(7, enter.getSkills()+"");
        	 
        	 map.put(8, enter.getJobrange()+"");
  
        	 map.put(9, enter.getCreatetime());
        	 
        	 map.put(10,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
      
        
       
     
        ExcelUtil.excelExport("企业资质标准分类表信息", excelHeaderList, valueMap, response);
    
    }
}
