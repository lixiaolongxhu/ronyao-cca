package com.ronyao.cca.service.dto;

import java.util.Map;

import com.ronyao.cca.db.model.EnterprisePerStandard;

/**企业人人员施工项目人员必须配备
 * 
 * @author user
 *
 */
public class EnterprisePerStaDto {

	private	Integer  linePerStaSum=0; //线路工程要求(平地丘陵)配置总人数
	private Integer  powerPerStaSum=0; //变电工程要求配置总人数
	
	private Map<Integer, EnterprisePerStandard>  perStaMap; //人员配备  key  岗位id

	public Integer getLinePerStaSum() {
		return linePerStaSum;
	}

	public void setLinePerStaSum(Integer linePerStaSum) {
		this.linePerStaSum = linePerStaSum;
	}

	public Integer getPowerPerStaSum() {
		return powerPerStaSum;
	}

	public void setPowerPerStaSum(Integer powerPerStaSum) {
		this.powerPerStaSum = powerPerStaSum;
	}

	public Map<Integer, EnterprisePerStandard> getPerStaMap() {
		return perStaMap;
	}

	public void setPerStaMap(Map<Integer, EnterprisePerStandard> perStaMap) {
		this.perStaMap = perStaMap;
	}

	
	
	
	
	
}
