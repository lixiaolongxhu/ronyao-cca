package com.ronyao.cca.service.dto;

/**施工企业承载结果.
 * 
 * @author user
 *
 */
public class BearResultDto {

	private Integer  enterpriseid; //企业id
	private String   enterpriseName;
	private String   supervisorunit;// 企业主管单位
	private Integer  treeYearOutput;//近三年产值
	private Integer  treeYearProject ;//近三年项目数
	
	//线路工程
	private Integer  line500kv=0;  //500kv项目个数
	private Integer  line220kv=0;  //220kv项目个数
	private Integer  line110kv=0;  //110kv项目个数
	private Integer  lineOutput=0; //线路工程产值
	private Integer  lineProjectSum=0;  //线路工程总数
	
	//变电工程
	private Integer  power500kv=0;  //500kv项目个数
	private Integer  power220kv=0;  //220kv项目个数
	private Integer  power110kv=0;  //110kv项目个数
	private Integer  powerOutput=0; //变电工程产值
	private Integer  powerProjectSum=0;//变电工程总数
	
	
	private Integer outputSum=0;// 线路工程+变电工程
	private Integer projectSum=0; //工程总数

	
	
	
	

	public String getEnterpriseName() {
		return enterpriseName;
	}







	public String getSupervisorunit() {
		return supervisorunit;
	}







	public void setSupervisorunit(String supervisorunit) {
		this.supervisorunit = supervisorunit;
	}







	public Integer getTreeYearOutput() {
		return treeYearOutput;
	}







	public void setTreeYearOutput(Integer treeYearOutput) {
		this.treeYearOutput = treeYearOutput;
	}







	public Integer getTreeYearProject() {
		return treeYearProject;
	}







	public void setTreeYearProject(Integer treeYearProject) {
		this.treeYearProject = treeYearProject;
	}







	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}







	public Integer getLineProjectSum() {
		return lineProjectSum;
	}







	public void setLineProjectSum(Integer lineProjectSum) {
		this.lineProjectSum = lineProjectSum;
	}







	public Integer getPowerProjectSum() {
		return powerProjectSum;
	}







	public void setPowerProjectSum(Integer powerProjectSum) {
		this.powerProjectSum = powerProjectSum;
	}







	public Integer getProjectSum() {
		return projectSum;
	}







	public void setProjectSum(Integer projectSum) {
		this.projectSum = projectSum;
	}







	public BearResultDto(Integer enterpriseId) {
		super();
		this.enterpriseid=enterpriseId;
	}







	public Integer getEnterpriseid() {
		return enterpriseid;
	}







	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}







	public Integer getLine500kv() {
		return line500kv;
	}



	public void setLine500kv(Integer line500kv) {
		this.line500kv = line500kv;
	}



	public Integer getLine220kv() {
		return line220kv;
	}



	public void setLine220kv(Integer line220kv) {
		this.line220kv = line220kv;
	}



	public Integer getLine110kv() {
		return line110kv;
	}



	public void setLine110kv(Integer line110kv) {
		this.line110kv = line110kv;
	}



	public Integer getLineOutput() {
		return lineOutput;
	}



	public void setLineOutput(Integer lineOutput) {
		this.lineOutput = lineOutput;
	}



	public Integer getPower500kv() {
		return power500kv;
	}



	public void setPower500kv(Integer power500kv) {
		this.power500kv = power500kv;
	}



	public Integer getPower220kv() {
		return power220kv;
	}



	public void setPower220kv(Integer power220kv) {
		this.power220kv = power220kv;
	}



	public Integer getPower110kv() {
		return power110kv;
	}



	public void setPower110kv(Integer power110kv) {
		this.power110kv = power110kv;
	}



	public Integer getPowerOutput() {
		return powerOutput;
	}



	public void setPowerOutput(Integer powerOutput) {
		this.powerOutput = powerOutput;
	}



	public Integer getOutputSum() {
		return outputSum;
	}



	public void setOutputSum(Integer outputSum) {
		this.outputSum = outputSum;
	}
	
	
	
	
}
