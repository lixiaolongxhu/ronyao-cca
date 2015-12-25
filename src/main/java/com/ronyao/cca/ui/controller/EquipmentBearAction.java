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

import com.ronyao.cca.db.model.EquipmentBear;

import com.ronyao.cca.db.model.VoltageRankClassify;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionEquipmentBear;





/**机具设备对工程承载力的评估.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/equipmentBear")
public class EquipmentBearAction {

	@Resource
	private ActionEquipmentBear  actionEquipmentBear;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("ID");
		excelHeaderList.add("张牵设备");	
		excelHeaderList.add("电压等级");
		excelHeaderList.add("单回/双回");
		excelHeaderList.add("平地丘陵  (导线展放效率(km/月.套))");
		excelHeaderList.add("山区  (导线展放效率(km/月.套))");
		excelHeaderList.add("说明");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				
	
		
        List<EquipmentBear> enterpList = actionEquipmentBear.getEquipmentBearList();
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Map<Integer, VoltageRankClassify> voltageRankClassifyMap=constDictionary.getVoltageRankClassifyMap();
        for (int i=0;i<enterpList.size() ;i++) {
        	EquipmentBear enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enter.getName());
        	 map.put(2, voltageRankClassifyMap.get(enter.getVoltagerankid()).getName() +"" );
        	
        	 //1 单回  2 双回
        	 if(enter.getLinetype()==1){
        		 map.put(3, "单回"); 
        	 }else{
        		 map.put(3, "双回");
        	 }
        	
        	
        	 map.put(4, enter.getLineplain()+"");  
     
        	 map.put(5, enter.getLinebrae()+"");
        	
        
        	 map.put(6, enter.getExplains()+"");
        	 
  
        	 map.put(7, enter.getCreatetime());
        	 
        	 map.put(8,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
       
        //导出
        ExcelUtil.excelExport("机具设备对工程承载力的评估", excelHeaderList, valueMap, response);
    }
}
