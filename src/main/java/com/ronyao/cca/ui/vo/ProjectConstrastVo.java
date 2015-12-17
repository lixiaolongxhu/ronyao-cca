package com.ronyao.cca.ui.vo;



/**承载项目数与近三年项目数对比
 * 
 * @author user
 *
 */
public class ProjectConstrastVo  {

	
	
	
	private   Integer  projectNumSum110kv;
	private   Integer  proejctNumSum220kv;
	private   Integer  projectNumSum500kv;
	private   Integer  projectNumSum;
	private   String   enterpriseName;
	private   String   supervisorunit;// 企业主管单位
	private   Integer  treeYearProjectAverage ;//近三年项目数平均
	private   Integer  constrast;// 对比差值
	
	
	public Integer getProjectNumSum110kv() {
		return projectNumSum110kv;
	}
	public void setProjectNumSum110kv(Integer projectNumSum110kv) {
		this.projectNumSum110kv = projectNumSum110kv;
	}
	public Integer getProejctNumSum220kv() {
		return proejctNumSum220kv;
	}
	public void setProejctNumSum220kv(Integer proejctNumSum220kv) {
		this.proejctNumSum220kv = proejctNumSum220kv;
	}
	public Integer getProjectNumSum500kv() {
		return projectNumSum500kv;
	}
	public void setProjectNumSum500kv(Integer projectNumSum500kv) {
		this.projectNumSum500kv = projectNumSum500kv;
	}
	public Integer getProjectNumSum() {
		return projectNumSum;
	}
	public void setProjectNumSum(Integer projectNumSum) {
		this.projectNumSum = projectNumSum;
	}
	public Integer getTreeYearProjectAverage() {
		return treeYearProjectAverage;
	}
	public void setTreeYearProjectAverage(Integer treeYearProjectAverage) {
		this.treeYearProjectAverage = treeYearProjectAverage;
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
	
	
	public Integer getConstrast() {
		return constrast;
	}
	public void setConstrast(Integer constrast) {
		this.constrast = constrast;
	}
	
	
	
	
	
}
