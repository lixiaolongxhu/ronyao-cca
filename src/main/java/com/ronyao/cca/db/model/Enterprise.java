package com.ronyao.cca.db.model;

public class Enterprise {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.id
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.supervisorUnit
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private String supervisorunit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.name
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.fullName
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private String fullname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.property
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Byte property;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.register
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Integer register;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.assets
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Integer assets;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.workers
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Integer workers;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.overallRank
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Byte overallrank;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.professionRank
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Byte professionrank;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.output
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Integer output;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.project
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Integer project;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.createTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise.updateTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private String updatetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.id
	 * @return  the value of enterprise.id
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.id
	 * @param id  the value for enterprise.id
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.supervisorUnit
	 * @return  the value of enterprise.supervisorUnit
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public String getSupervisorunit() {
		return supervisorunit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.supervisorUnit
	 * @param supervisorunit  the value for enterprise.supervisorUnit
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setSupervisorunit(String supervisorunit) {
		this.supervisorunit = supervisorunit == null ? null : supervisorunit
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.name
	 * @return  the value of enterprise.name
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.name
	 * @param name  the value for enterprise.name
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.fullName
	 * @return  the value of enterprise.fullName
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.fullName
	 * @param fullname  the value for enterprise.fullName
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname == null ? null : fullname.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.property
	 * @return  the value of enterprise.property
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Byte getProperty() {
		return property;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.property
	 * @param property  the value for enterprise.property
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setProperty(Byte property) {
		this.property = property;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.register
	 * @return  the value of enterprise.register
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Integer getRegister() {
		return register;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.register
	 * @param register  the value for enterprise.register
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setRegister(Integer register) {
		this.register = register;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.assets
	 * @return  the value of enterprise.assets
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Integer getAssets() {
		return assets;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.assets
	 * @param assets  the value for enterprise.assets
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setAssets(Integer assets) {
		this.assets = assets;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.workers
	 * @return  the value of enterprise.workers
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Integer getWorkers() {
		return workers;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.workers
	 * @param workers  the value for enterprise.workers
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setWorkers(Integer workers) {
		this.workers = workers;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.overallRank
	 * @return  the value of enterprise.overallRank
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Byte getOverallrank() {
		return overallrank;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.overallRank
	 * @param overallrank  the value for enterprise.overallRank
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setOverallrank(Byte overallrank) {
		this.overallrank = overallrank;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.professionRank
	 * @return  the value of enterprise.professionRank
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Byte getProfessionrank() {
		return professionrank;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.professionRank
	 * @param professionrank  the value for enterprise.professionRank
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setProfessionrank(Byte professionrank) {
		this.professionrank = professionrank;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.output
	 * @return  the value of enterprise.output
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Integer getOutput() {
		return output;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.output
	 * @param output  the value for enterprise.output
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setOutput(Integer output) {
		this.output = output;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.project
	 * @return  the value of enterprise.project
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Integer getProject() {
		return project;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.project
	 * @param project  the value for enterprise.project
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setProject(Integer project) {
		this.project = project;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.createTime
	 * @return  the value of enterprise.createTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.createTime
	 * @param createtime  the value for enterprise.createTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise.updateTime
	 * @return  the value of enterprise.updateTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise.updateTime
	 * @param updatetime  the value for enterprise.updateTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}
}