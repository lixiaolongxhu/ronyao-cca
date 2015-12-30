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
import com.ronyao.cca.ui.extDirect.ActionBearContrast;
import com.ronyao.cca.ui.vo.OutputConstrastVo;
import com.ronyao.cca.ui.vo.ProjectConstrastVo;





/**施工企业承载能力评估(修改后结果),与近三年的项目数以及产值的平均值对比.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/bearContrast")
public class BearContrastAction {

	@Resource
	private ActionBearContrast  actionBearContrast;
	
	
	@Resource
	private ConstDictionary  constDictionary;

	
	/**工程数对比导出
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/projectNum/excel")
	public void exportExcelProjectNum(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("主管单位");	
		excelHeaderList.add("施工企业名称");
		excelHeaderList.add("500kv(项目评估个数)");
		excelHeaderList.add("220kv(项目评估个数)");
		excelHeaderList.add("110kV(项目评估个数)");
		excelHeaderList.add("合计(项目评估个数)");
		excelHeaderList.add("近三年平均承载项目个数");
		excelHeaderList.add("项目评估个数与近三年平均承载工程个数的差额");
		
				

        List<ProjectConstrastVo> enterpList = actionBearContrast.getProjectConstratVoList();
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
       Integer projectNumSum500kv=0;
       Integer projectNumSum220kv=0;
       Integer projectNumSum110kv=0;
       Integer projectNumSum=0;
       Integer treeYearProjectAverageSum=0;
       Integer constrastSum=0;
        for (int i=0;i<enterpList.size() ;i++) {
        	ProjectConstrastVo enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enter.getSupervisorunit());
        	 map.put(2, enter.getEnterpriseName());
        	 
        	 map.put(3, enter.getProjectNumSum500kv()+"");
        	 projectNumSum500kv=projectNumSum500kv+enter.getProjectNumSum500kv();
        	 map.put(4, enter.getProejctNumSum220kv()+"");
        	 projectNumSum220kv=projectNumSum220kv+enter.getProejctNumSum220kv();
        	 map.put(5, enter.getProjectNumSum110kv()+"");
        	 projectNumSum110kv=projectNumSum110kv+enter.getProjectNumSum110kv();
    
        	 map.put(6, enter.getProjectNumSum()+"");
        	 projectNumSum=projectNumSum+enter.getProjectNumSum();
  
        	 map.put(7, enter.getTreeYearProjectAverage()+"");
        	 treeYearProjectAverageSum=treeYearProjectAverageSum+enter.getTreeYearProjectAverage();
        	 
        	 map.put(8,enter.getConstrast()+"");
        	 constrastSum=constrastSum+enter.getConstrast();
        	 valueMap.add(map);
       
		}
        //指定列求和的值
        Map<Integer , String>  map=new HashMap<Integer, String>();
       
       
        map.put(3, "合计 :  "+projectNumSum500kv+"");
        map.put(4, "合计 :  "+projectNumSum220kv);
        map.put(5, "合计 :  "+projectNumSum110kv);
        map.put(6, "合计 :  "+projectNumSum);
        map.put(7, "合计 :  "+treeYearProjectAverageSum);
        map.put(8, "合计 :  "+constrastSum);
     
        
        valueMap.add(map);
       
        //导出
        ExcelUtil.excelExport("工程数量对比情况", excelHeaderList, valueMap, response);
    }
	
	/**产值对比导出
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/output/excel")
	public void exportExcelOutput(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("主管单位");	
		excelHeaderList.add("施工企业名称");
		excelHeaderList.add("评估值(万元");
		excelHeaderList.add("近三年产值平均值(万元)");
		excelHeaderList.add("差额(万元)");
		
		
				

        List<OutputConstrastVo> enterpList = actionBearContrast.getOutputConstrastVoList();
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
       Integer outputSum=0;
       Integer treeYearOutputAverage=0;
       Integer constrastSum=0;
        for (int i=0;i<enterpList.size() ;i++) {
        	OutputConstrastVo enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enter.getSupervisorunit());
        	 map.put(2, enter.getEnterpriseName());
        	
        	 map.put(3, enter.getOutputSum()+"");
        	 outputSum=outputSum+enter.getOutputSum();
        	
        	
        	 map.put(4, enter.getTreeYearOutputAverage()+"");  
        	 treeYearOutputAverage=treeYearOutputAverage+enter.getTreeYearOutputAverage();
        	 map.put(5, enter.getConstrast()+"");
        	 constrastSum=constrastSum+enter.getConstrast();
        
        	
        	 valueMap.add(map);
       
		}
        //指定列求和的值
        Map<Integer , String>  map=new HashMap<Integer, String>();
       
       
        map.put(3, "合计 :  "+outputSum+"");
        map.put(4, "合计 :  "+treeYearOutputAverage);
        map.put(5, "合计 :  "+constrastSum);
     
     
        
        valueMap.add(map);
        //导出
        ExcelUtil.excelExport("产值对比情况", excelHeaderList, valueMap, response);
    }
}
