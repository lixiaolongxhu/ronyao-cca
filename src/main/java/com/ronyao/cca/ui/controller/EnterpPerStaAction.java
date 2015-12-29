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
import com.ronyao.cca.db.model.EnterprisePerStandard;
import com.ronyao.cca.db.model.PostClassify;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionEnterpPerSta;





/**
 * 企业自身主要人员评估(施工项目部人员构成)
 * @author user
 *
 */

@Controller
@RequestMapping(value="/enterprisePerSta")
public class EnterpPerStaAction {

	@Resource
	private ActionEnterpPerSta  actionEnterpPerSta;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("岗位");	
		excelHeaderList.add("持证要求");
		excelHeaderList.add("平地丘陵(线路工程(人数))");
		excelHeaderList.add("山区(线路工程(人数))");
		excelHeaderList.add("变电工程(人数)");
		excelHeaderList.add("是否允许其他位人员兼职");
		excelHeaderList.add("备注");	
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				
	
        List<EnterprisePerStandard> enterpList = actionEnterpPerSta.getEnterprisePerStandardsList();
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Integer lineflatnumSum=0;
        Integer linemountainnumSum=0;
        Integer powernumSum=0;
        Map<Integer, PostClassify> postClassiyMap=constDictionary.getPostClassifyMap();
        for (int i=0;i<enterpList.size() ;i++) {
        	EnterprisePerStandard enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, postClassiyMap.get(enter.getPostclassifyid()).getName());
        	 map.put(2,enter.getHolderrequire() );
        	
        	 map.put(3,enter.getLineflatnum() +"");
        	 lineflatnumSum=lineflatnumSum+enter.getLineflatnum();
        	 map.put(4, enter.getLinemountainnum()+"");  
        	 linemountainnumSum=linemountainnumSum+enter.getLinemountainnum();
        	 map.put(5, enter.getPowernum()+"");
        	 powernumSum=powernumSum+enter.getPowernum();
        	
        	 if(enter.getJob()==1){
        		 map.put(6, "不允许");    //1 不允许  2 允许
        	 }else{
        		 map.put(6, "允许");
        	 }
        
        	 map.put(7, enter.getRemark()+"");
        	 
  
        	 map.put(8, enter.getCreatetime());
        	 
        	 map.put(9,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
        //指定列求和的值
        Map<Integer , String>  map=new HashMap<Integer, String>();
        map.put(1, "");
        map.put(2, "");
        map.put(3, "合计 :  "+lineflatnumSum+"");
        map.put(4, "合计 :  "+linemountainnumSum+"");
        map.put(5, "合计 :  "+powernumSum+"");
        map.put(6, "");
        map.put(7, "");
        map.put(8, "");
        map.put(9, "");
        valueMap.add(map);
        //导出
        ExcelUtil.excelExport("企业自身主要人员评估", excelHeaderList, valueMap, response);
    }
}
