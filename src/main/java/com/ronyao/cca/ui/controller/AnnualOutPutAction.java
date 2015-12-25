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
import com.ronyao.cca.db.model.AnnualOutput;
import com.ronyao.cca.db.model.VoltageRankClassify;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionAnnualOutput;





/**施工项目团队工程施工产值.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/annualOutput")
public class AnnualOutPutAction {

	@Resource
	private ActionAnnualOutput  actionAnnualOutput;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("ID");
		excelHeaderList.add("电压等级");	
		excelHeaderList.add("施工项目类型");
		excelHeaderList.add("合理工期(月)");
		excelHeaderList.add("单个项目部完成项目数量(个/年)");
		excelHeaderList.add("年产值(万元/年)");
		excelHeaderList.add("备注");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				

        List<AnnualOutput> enterpList = actionAnnualOutput.getAnnualOutputList();
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Map<Integer, VoltageRankClassify>  voltageRankClassifyMap=constDictionary.getVoltageRankClassifyMap();
        for (int i=0;i<enterpList.size() ;i++) {
        	AnnualOutput enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, voltageRankClassifyMap.get(enter.getVoltagerankid()).getName());
        	 //ry.constant.project_type =[[1,'线路工程项目'],[2,'变电工程项目']]
        	 if(enter.getProjecttype()==1){
        		 map.put(2, "线路工程");
        	 }else{
        		 map.put(2, "变电工程");
        	 }
        	
        	 map.put(3, enter.getTimelimit()+"");
        	
        	
        	
        	 map.put(4, enter.getProjectnum()+"");  
     
        	 map.put(5, enter.getAnnualoutput()+"");
        	
        
        	 map.put(6, enter.getRemark()+"");
        	 
  
        	 map.put(7, enter.getCreatetime());
        	 
        	 map.put(8,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
       
        //导出
        ExcelUtil.excelExport("施工项目团队工程施工产值", excelHeaderList, valueMap, response);
    }
}
