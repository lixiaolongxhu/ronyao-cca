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
import com.ronyao.cca.db.model.EnterpriseEquipment;
import com.ronyao.cca.tool.ExcelUtil;
import com.ronyao.cca.ui.extDirect.ActionEnterpEquip;





/**施工装备信息.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/enterpriseEquip")
public class EnterpEquipAction {

	@Resource
	private ActionEnterpEquip  actionEnterpEquip;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("序号");
		excelHeaderList.add("施工企业名称");	
		excelHeaderList.add("大张牵设备(套)");
		excelHeaderList.add("小张牵设备(套)");
		excelHeaderList.add("合计");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				
	

        List<EnterpriseEquipment> enterpList = actionEnterpEquip.getEnterpriseEquipmentList();
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Map<Integer, Enterprise> enterpriseMap=constDictionary.getEnterpriseMap();
        Integer  bigEquipmentSum=0;
        Integer  smallEquipmentSum=0;
        Integer  sum=0;
        for (int i=0;i<enterpList.size() ;i++) {
        	 EnterpriseEquipment enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enterpriseMap.get(enter.getEnterpriseid()).getName());
        	 map.put(2, enter.getBigequipment()+"");
        	 bigEquipmentSum=bigEquipmentSum+enter.getBigequipment();
        	 map.put(3, enter.getSmallequipment()+"");
        	 smallEquipmentSum=smallEquipmentSum+enter.getSmallequipment();
        	 map.put(4, enter.getSum()+"");  
        	 sum=sum+enter.getSum();
        	 map.put(5, enter.getCreatetime());
   
        	 map.put(6,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
        //指定列求和的值
        Map<Integer , String>  map=new HashMap<Integer, String>();
       
        map.put(2, "合计 :  "+bigEquipmentSum);
        map.put(3, "合计 :  "+smallEquipmentSum+"");
        map.put(4, "小计 :  "+sum+"");
        valueMap.add(map);
        //导出
        ExcelUtil.excelExport("施工装备信息", excelHeaderList, valueMap, response);
    }
}
