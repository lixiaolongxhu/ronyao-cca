package com.ronyao.cca.service.dto;

/**施工企业承载结果.
 * 
 * @author user
 *
 */
public class BearResultDto {

	private Integer  enterpriseId; //企业id
	
	//线路工程
	private Integer  line500kv=0;  //500kv项目个数
	private Integer  line220kv=0;  //220kv项目个数
	private Integer  line110kv=0;  //110kv项目个数
	private Integer  lineOutput=0; //线路工程产值
	
	//变电工程
	private Integer  power500kv=0;  //500kv项目个数
	private Integer  power220kv=0;  //220kv项目个数
	private Integer  power110kv=0;  //110kv项目个数
	private Integer  powerOutput=0; //变电工程产值
	
	
	
	private Integer outputSum=0;// 线路工程+变电工程


	
	

	public BearResultDto() {
		super();
	}



	public Integer getEnterpriseId() {
		return enterpriseId;
	}



	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
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
