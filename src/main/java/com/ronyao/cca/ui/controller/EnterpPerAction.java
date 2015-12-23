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
import com.ronyao.cca.db.dao.EnterprisePersonMapper;
import com.ronyao.cca.db.model.EnterprisePerson;
import com.ronyao.cca.db.model.EnterprisePersonExample;
import com.ronyao.cca.tool.ExcelUtil;







/**企业持证人员信息
 * 
 * @author user
 *
 */
@Controller
@RequestMapping(value="/enterprisePer")
public class EnterpPerAction {

	@Resource
	private EnterprisePersonMapper enterprisePersonMapper;
	
	
	@Resource
	private ConstDictionary  constDictionary;
	
	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletRequest request , HttpServletResponse response) throws Exception{
		List<String>   excelHeaderList=new ArrayList<String>();
		
		excelHeaderList.add("ID");
		excelHeaderList.add("施工企业名称");
		excelHeaderList.add("一级(国家注册建造师)");
		excelHeaderList.add("二级(国家注册建造师)");
		excelHeaderList.add("合计(国家注册建造师)");
		excelHeaderList.add("中级(中級以上职称人员 )");
		excelHeaderList.add("高级(中級以上职称人员 )");
		excelHeaderList.add("合计(中級以上职称人员 )");
		excelHeaderList.add("中级(中级工以上技术人员)");
		excelHeaderList.add("高级(中级工以上技术人员)");
		excelHeaderList.add("技师(中级工以上技术人员)");
		excelHeaderList.add("高级技师(中级工以上技术人员)");
		excelHeaderList.add("合计(中级工以上技术人员)");
		excelHeaderList.add("记录创建时间");
		excelHeaderList.add("记录修改时间");
				
	
        EnterprisePersonExample example=new EnterprisePersonExample();
        List<EnterprisePerson> enterpList = enterprisePersonMapper.selectByExample(example);
        if(enterpList.isEmpty()){
        	return;
        }
        
        List<Map<Integer , String>>  valueMap=new ArrayList<Map<Integer,String>>();
        for (int i=0;i<enterpList.size() ;i++) {
        	EnterprisePerson enter=enterpList.get(i);
        	 Map<Integer , String>  map=new HashMap<Integer, String>();
        	 
        	 map.put(0, String.valueOf(i+1));
        	 
        	 map.put(1, constDictionary.getEnterpriseMap().get(enter.getEnterpriseid()).getName()+"");
        	 map.put(2,enter.getConstructorone() +"");
        	 map.put(3,enter.getConstructortwo() +"");
        	
        	 map.put(4, enter.getConstructortotal()+"");
        	 
        	 map.put(5,enter.getStaffmiddle()+"");
        	 map.put(6,enter.getStaffhigh()+"");
        	 map.put(7,enter.getStafftotal()+"");
        	 map.put(8,enter.getSkillmiddle()+"");
        	 map.put(9,enter.getSkillhigh()+"");
        	 map.put(10,enter.getSkilltech()+"");
        	 map.put(11,enter.getSkilltechhigh()+"");
        	 map.put(12,enter.getSkilltotal()+"");
        	 map.put(13,enter.getCreatetime());
        	 map.put(14,enter.getUpdatetime());
        	
        	 valueMap.add(map);
       
		}
      
        
       
     
        ExcelUtil.excelExport("持证人员信息", excelHeaderList, valueMap, response);
    }
}
