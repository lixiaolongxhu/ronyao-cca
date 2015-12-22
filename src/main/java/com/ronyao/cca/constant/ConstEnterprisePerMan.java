package com.ronyao.cca.constant;

import com.ronyao.cca.db.model.EnterprisePerManage;

/**施工企业现场管理人员配置常量
 * 
 * @author user
 *
 */
public class ConstEnterprisePerMan {

	/**线路专业人员
	 * 
	 */
	public static final  int 	LINE_PROFESSION=1;
	
	/**变电专业人员
	 * 
	 */
	public static final  int    POWER_PROFESSION=2;
	
	
	
	/**现场施工人员合计.
	 * 
	 * @param ep
	 */
	public static final  void sum(EnterprisePerManage ep){
		Integer sum=
				ep.getOnemanager()+ep.getTwomanager()+
				ep.getOnechief()+ep.getTwochief()+
				ep.getSafetyofficer()+ep.getInspector()+
				ep.getTechnician()+ep.getCostmember()+
				ep.getDocumenter()+ep.getIntegrator()+
				ep.getMaterial()+ep.getExpeditor()+
				ep.getConstructionteam()+ep.getPlurality();
		
		ep.setSum(sum);
	}
}
