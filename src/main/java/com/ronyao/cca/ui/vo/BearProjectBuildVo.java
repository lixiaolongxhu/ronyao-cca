package com.ronyao.cca.ui.vo;

/**企业还可承载建设项目情况.
 * 
 * @author user
 *
 */
public class BearProjectBuildVo {



	private String   enterpriseName;
	private String   supervisorunit;// 企业主管单位

	
	//线路工程
	private Integer  line500kv=0;  //500kv项目个数
	private Integer  line220kv=0;  //220kv项目个数
	private Integer  line110kv=0;  //110kv项目个数
	
	
	//变电工程
	private Integer  power500kv=0;  //500kv项目个数
	private Integer  power220kv=0;  //220kv项目个数
	private Integer  power110kv=0;  //110kv项目个数
	

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
	
	
	
}
