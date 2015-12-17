package com.ronyao.cca.db.model;

import java.math.BigDecimal;

public class EnterpriseAssess {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_assess.id
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_assess.category
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String category;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_assess.standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String standard;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_assess.projectNumStart
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private Integer projectnumstart;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_assess.projectNumEnd
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private Integer projectnumend;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_assess.outputStart
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private BigDecimal outputstart;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_assess.outputEnd
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private BigDecimal outputend;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_assess.createTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_assess.updateTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String updatetime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_assess.enterprise
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String enterprise;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_assess.id
	 * @return  the value of enterprise_assess.id
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_assess.id
	 * @param id  the value for enterprise_assess.id
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_assess.category
	 * @return  the value of enterprise_assess.category
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_assess.category
	 * @param category  the value for enterprise_assess.category
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setCategory(String category) {
		this.category = category == null ? null : category.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_assess.standard
	 * @return  the value of enterprise_assess.standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_assess.standard
	 * @param standard  the value for enterprise_assess.standard
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setStandard(String standard) {
		this.standard = standard == null ? null : standard.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_assess.projectNumStart
	 * @return  the value of enterprise_assess.projectNumStart
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public Integer getProjectnumstart() {
		return projectnumstart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_assess.projectNumStart
	 * @param projectnumstart  the value for enterprise_assess.projectNumStart
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setProjectnumstart(Integer projectnumstart) {
		this.projectnumstart = projectnumstart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_assess.projectNumEnd
	 * @return  the value of enterprise_assess.projectNumEnd
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public Integer getProjectnumend() {
		return projectnumend;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_assess.projectNumEnd
	 * @param projectnumend  the value for enterprise_assess.projectNumEnd
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setProjectnumend(Integer projectnumend) {
		this.projectnumend = projectnumend;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_assess.outputStart
	 * @return  the value of enterprise_assess.outputStart
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public BigDecimal getOutputstart() {
		return outputstart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_assess.outputStart
	 * @param outputstart  the value for enterprise_assess.outputStart
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setOutputstart(BigDecimal outputstart) {
		this.outputstart = outputstart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_assess.outputEnd
	 * @return  the value of enterprise_assess.outputEnd
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public BigDecimal getOutputend() {
		return outputend;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_assess.outputEnd
	 * @param outputend  the value for enterprise_assess.outputEnd
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setOutputend(BigDecimal outputend) {
		this.outputend = outputend;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_assess.createTime
	 * @return  the value of enterprise_assess.createTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_assess.createTime
	 * @param createtime  the value for enterprise_assess.createTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_assess.updateTime
	 * @return  the value of enterprise_assess.updateTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_assess.updateTime
	 * @param updatetime  the value for enterprise_assess.updateTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_assess.enterprise
	 * @return  the value of enterprise_assess.enterprise
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getEnterprise() {
		return enterprise;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_assess.enterprise
	 * @param enterprise  the value for enterprise_assess.enterprise
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise == null ? null : enterprise.trim();
	}
}