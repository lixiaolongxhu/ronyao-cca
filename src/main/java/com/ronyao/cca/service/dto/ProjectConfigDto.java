package com.ronyao.cca.service.dto;

/**工程项目配置
 * 
 * @author user
 *
 */
public class ProjectConfigDto {
	
	private Integer  projectNum;  //前电压可以承接的项目数
	private Integer  surplusPersonTotal; //剩余企业可用的总人数
	private Integer  surplusOneManager ;// 
	private Integer  surplusTwoManager ;//剩余项目经理数
	

	private Integer surplusOneChief; 
	private Integer surplusTwoChief;// 剩余总工数
	
	private Integer  surplusSafetyOfficer ;//剩余安全员数
	private Integer  surplusInspector;// 剩余质检员数
	
	public Integer getProjectNum() {
		return projectNum;
	}
	public void setProjectNum(Integer projectNum) {
		this.projectNum = projectNum;
	}
	public Integer getSurplusPersonTotal() {
		return surplusPersonTotal;
	}
	public void setSurplusPersonTotal(Integer surplusPersonTotal) {
		this.surplusPersonTotal = surplusPersonTotal;
	}
	public Integer getSurplusOneManager() {
		return surplusOneManager;
	}
	public void setSurplusOneManager(Integer surplusOneManager) {
		this.surplusOneManager = surplusOneManager;
	}
	public Integer getSurplusTwoManager() {
		return surplusTwoManager;
	}
	public void setSurplusTwoManager(Integer surplusTwoManager) {
		this.surplusTwoManager = surplusTwoManager;
	}
	public Integer getSurplusOneChief() {
		return surplusOneChief;
	}
	public void setSurplusOneChief(Integer surplusOneChief) {
		this.surplusOneChief = surplusOneChief;
	}
	public Integer getSurplusTwoChief() {
		return surplusTwoChief;
	}
	public void setSurplusTwoChief(Integer surplusTwoChief) {
		this.surplusTwoChief = surplusTwoChief;
	}
	public Integer getSurplusSafetyOfficer() {
		return surplusSafetyOfficer;
	}
	public void setSurplusSafetyOfficer(Integer surplusSafetyOfficer) {
		this.surplusSafetyOfficer = surplusSafetyOfficer;
	}
	public Integer getSurplusInspector() {
		return surplusInspector;
	}
	public void setSurplusInspector(Integer surplusInspector) {
		this.surplusInspector = surplusInspector;
	}
	
	
	
	
	
}
