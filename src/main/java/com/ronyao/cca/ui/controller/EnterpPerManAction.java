package com.ronyao.cca.ui.controller;


import java.io.IOException;
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
import com.ronyao.cca.db.model.EnterprisePerManage;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionEnterpPerManLine;
import com.ronyao.cca.ui.extDirect.ActionEnterpPerManPower;





/**施工企业现场管理人员(线路专业人员,变电专业人员).
 * 
 * @author user
 *
 */

@Controller
public class EnterpPerManAction {

	@Resource
	private ActionEnterpPerManLine  actionEnterpPerManLine;
	
	@Resource
	private ActionEnterpPerManPower actionEnterpPerManPower;
	
	@Resource
	private ConstDictionary  constDictionary;

	

	private void exportExcel(String fileName, List<EnterprisePerManage> perManageList,HttpServletResponse response) throws IOException {
		
		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("ID");
		excelHeaderList.add("施工企业名称");	
		excelHeaderList.add("500kv项目经理");
		excelHeaderList.add("220kv及以下项目经理");
		excelHeaderList.add("220kv及以上项目总工");
		excelHeaderList.add("110kv项目总工");
		excelHeaderList.add("安全员");
		excelHeaderList.add("质检员");
		excelHeaderList.add("技术员");
		excelHeaderList.add("造价员");
		excelHeaderList.add("资料员");
		excelHeaderList.add("综合管理员");
		excelHeaderList.add("材料员");
		excelHeaderList.add("协调员");
		excelHeaderList.add("施工队长");
		excelHeaderList.add("施工队,技术员质检员,兼职安全员");
		excelHeaderList.add("合计");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				
	
		
        List<EnterprisePerManage> enterpList = perManageList;
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Map<Integer, Enterprise> enterpriseMap=constDictionary.getEnterpriseMap();
        for (int i=0;i<enterpList.size() ;i++) {
        	EnterprisePerManage enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enterpriseMap.get(enter.getEnterpriseid()).getName());
        	 map.put(2, enter.getOnemanager()+"");
        	 map.put(3, enter.getTwomanager()+"");	
        	 map.put(4, enter.getOnechief()+"");  
        	 map.put(5, enter.getTwochief()+"");
        	 map.put(6, enter.getSafetyofficer()+"");
        	 map.put(7, enter.getInspector()+"");
        	 map.put(8,enter.getTechnician()+"");
        	 map.put(9,enter.getCostmember()+"");
        	 map.put(10,enter.getDocumenter()+"");
        	 map.put(11,enter.getIntegrator()+"");
        	 map.put(12,enter.getMaterial()+"");
        	 map.put(13,enter.getExpeditor()+"");
        	 map.put(14,enter.getConstructionteam()+"");
        	 map.put(15,enter.getPlurality()+"");
        	 map.put(16,enter.getSum()+"");
        	 map.put(17,enter.getCreatetime());
        	 map.put(18,enter.getUpdatetime());
        	 
        	 valueMap.add(map);
       
		}
       
        //导出
        ExcelUtil.excelExport(fileName, excelHeaderList, valueMap, response);
		
	}
	
	
	@RequestMapping(value="/enterprisePerManLine/excel")
	public void exportExcelLine(HttpServletRequest request , HttpServletResponse response) throws Exception{

		String fileName="施工企业现场管理人员(线路专业人员)";
		List<EnterprisePerManage>  perManageList=actionEnterpPerManLine.getEnterprisePerManage();
		exportExcel(fileName,perManageList,response);
	
    }
	

	@RequestMapping(value="/enterprisePerManPower/excel")
	public void exportExcelPower(HttpServletRequest request , HttpServletResponse response) throws Exception{

		String fileName="施工企业现场管理人员(变电专业人员)";
		List<EnterprisePerManage>  perManageList=actionEnterpPerManPower.getEnterprisePerManageList();
		exportExcel(fileName,perManageList,response);
	
   }
}
