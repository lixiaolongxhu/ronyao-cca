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
import com.ronyao.cca.db.dao.EnterpriseEquipmentMapper;
import com.ronyao.cca.db.model.Enterprise;
import com.ronyao.cca.db.model.EnterpriseEquipment;
import com.ronyao.cca.db.model.EnterpriseEquipmentExample;
import com.ronyao.cca.tool.ExcelUtil;





/**施工装备信息.
 * 
 * @author user
 *
 */

@Controller
@RequestMapping(value="/enterpriseEquip")
public class EnterpEquipAction {

	@Resource
	private EnterpriseEquipmentMapper  enterpriseEquipmentMapper;
	
	@Resource
	private ConstDictionary  constDictionary;

	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{

		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("ID");
		excelHeaderList.add("施工企业名称");	
		excelHeaderList.add("大张牵设备(套)");
		excelHeaderList.add("小张牵设备(套)");
		excelHeaderList.add("合计");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				
	
		EnterpriseEquipmentExample example=new EnterpriseEquipmentExample();
        List<EnterpriseEquipment> enterpList = enterpriseEquipmentMapper.selectByExample(example);
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        Map<Integer, Enterprise> enterpriseMap=constDictionary.enterpriseMap;
        for (int i=0;i<enterpList.size() ;i++) {
        	 EnterpriseEquipment enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 map.put(1, enterpriseMap.get(enter.getEnterpriseid()).getName());
        	 map.put(2, enter.getBigequipment()+"");
        	 map.put(3, enter.getSmallequipment()+"");
        	 map.put(4, enter.getSum()+"");  
        	 map.put(5, enter.getCreatetime());
   
        	 map.put(6,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
       
        //导出
        ExcelUtil.excelExport("施工装备信息", excelHeaderList, valueMap, response);
    }
}
