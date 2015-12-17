package com.ronyao.cca.ui.vo;




/**承载项目产值与近三年项目产值对比
 * 
 * @author user
 *
 */
public class OutputConstrastVo  {

	
	

	private   Integer  outputSum;
	private   String   enterpriseName;
	private   String   supervisorunit;// 企业主管单位
	private   Integer  treeYearOutputAverage ;//近三年项目数
	private   Integer  constrast;// 对比差值
	public Integer getOutputSum() {
		return outputSum;
	}
	public void setOutputSum(Integer outputSum) {
		this.outputSum = outputSum;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getSupervisorunit() {
		return supervisorunit;
	}
	public void setSupervisorunit(String supervisorunit) {
		this.supervisorunit = supervisorunit;
	}
	
	
	public Integer getTreeYearOutputAverage() {
		return treeYearOutputAverage;
	}
	public void setTreeYearOutputAverage(Integer treeYearOutputAverage) {
		this.treeYearOutputAverage = treeYearOutputAverage;
	}
	public Integer getConstrast() {
		return constrast;
	}
	public void setConstrast(Integer constrast) {
		this.constrast = constrast;
	}
	
	
	
	
	
	
	
	
}
