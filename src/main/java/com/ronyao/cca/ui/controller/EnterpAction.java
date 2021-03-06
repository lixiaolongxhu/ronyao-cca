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
import com.ronyao.cca.db.model.AptitudeRankClassify;
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionEnterp;







/**企业基本信息
 * 
 * @author user
 *
 */
@Controller
@RequestMapping(value="/enterprise")
public class EnterpAction {

	@Resource
	private ActionEnterp  actionEnterp;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("主管单位");
		excelHeaderList.add("企业全称");
		excelHeaderList.add("企业简称");
		excelHeaderList.add("企业性质");
		excelHeaderList.add("注册资金(万元)");
		excelHeaderList.add("企业净资产(万元)");
		excelHeaderList.add("在职职工数");
		excelHeaderList.add("总承包(等级)");
		excelHeaderList.add("专业承包(等级)");
		excelHeaderList.add("去年工程数量(近三年工程数量)");
		excelHeaderList.add("前年工程数量(近三年工程数量)");
		excelHeaderList.add("上前年工程数量(近三年工程数量)");
		excelHeaderList.add("合计(近三年工程数量)");
		excelHeaderList.add("去年产值(近三年产值)");
		excelHeaderList.add("前年产值(近三年产值)");
		excelHeaderList.add("上前年产值(近三年产值)");
		excelHeaderList.add("合计(近三年产值)");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
			
        List<Enterprise> enterpList = actionEnterp.getEnterpriseList();
        if(enterpList==null  || enterpList.isEmpty()){
        	response.setHeader("content-type", "text/html;charset=UTF-8");
        	response.setCharacterEncoding("UTF-8");
        	response.getWriter().write("没有可以导出的内容:     <a href='javascript:history.go(-1)'><H2> 返回<H2></a> ");
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Map<Byte, AptitudeRankClassify> aptitudeRankClassifyMap=constDictionary.getAptitudeRankClassifyMap();
        Integer projectLastSum=0;
        Integer projectbeforeSum=0;
        Integer projectbeforelastSum=0;
        Integer projectSum=0;
        Integer outputlast=0;
        Integer outputbefore=0;
        Integer outputbeforelast=0;
        Integer outputSum=0;
        
        for (int i=0;i<enterpList.size() ;i++) {
        	 Enterprise enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enter.getSupervisorunit());
        	 map.put(2,enter.getFullname() );
        	 map.put(3,enter.getName() );
        	 if(enter.getProperty()==1){
        		 map.put(4, "全民");  //1 全民 2 集体
        	 }else{
        		 map.put(4, "集体");
        	 }
        	
        	 map.put(5, enter.getRegister()+"");
        	 map.put(6, enter.getAssets()+"");
        	 map.put(7, enter.getWorkers()+"");
        	 
        	 map.put(8, aptitudeRankClassifyMap.get(enter.getOverallrank()).getName()+"");
        	 map.put(9, aptitudeRankClassifyMap.get(enter.getProfessionrank()).getName()+"");
        	 map.put(10, enter.getProjectlast()+"");
        	 projectLastSum=projectLastSum+enter.getProjectlast();
        	 map.put(11, enter.getProjectbefore()+"");
        	 projectbeforeSum=projectbeforeSum+enter.getProjectbefore();
        	 map.put(12, enter.getProjectbeforelast()+"");
        	 projectbeforelastSum=projectbeforelastSum+enter.getProjectbeforelast();
        	 map.put(13, enter.getProject()+"");
        	 projectSum=projectSum+enter.getProject();
        	 map.put(14, enter.getOutputlast()+"");
        	 outputlast=outputlast+enter.getOutputlast();
        	 map.put(15, enter.getOutputbefore()+"");
        	 outputbefore=outputbefore+enter.getOutputbefore();
        	 map.put(16, enter.getOutputbeforelast()+"");
        	 outputbeforelast=outputbeforelast+enter.getOutputbeforelast();
        	 map.put(17, enter.getOutput()+"");
        	 outputSum=outputSum+enter.getOutput();
        	 map.put(18, enter.getCreatetime());
        	 
        	 map.put(19,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
      
        //指定列求和的值
        Map<Integer , String>  map=new HashMap<Integer, String>();
       
        map.put(10, "合计 :  "+projectLastSum);
        map.put(11, "合计 :  "+projectbeforeSum+"");
        map.put(12, "合计 :  "+projectbeforelastSum);
        map.put(13, "合计 :  "+projectSum);
        map.put(14, "合计 :  "+outputlast);
        map.put(15, "合计 :  "+outputbefore);
        map.put(16, "合计 :  "+outputbeforelast);
        map.put(17, "合计 :  "+outputSum);
        
        valueMap.add(map);
       
     
        ExcelUtil.excelExport("施工企业基本信息", excelHeaderList, valueMap, response);
    }
}
