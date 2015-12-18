package com.ronyao.cca.db.model;

public class EnterpriseFile {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_file.id
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_file.enterpriseId
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	private Integer enterpriseid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_file.fileType
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	private Byte filetype;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_file.aptitudeType
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	private Byte aptitudetype;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_file.path
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	private String path;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_file.createTime
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_file.updatTime
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	private String updattime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_file.id
	 * @return  the value of enterprise_file.id
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_file.id
	 * @param id  the value for enterprise_file.id
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_file.enterpriseId
	 * @return  the value of enterprise_file.enterpriseId
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_file.enterpriseId
	 * @param enterpriseid  the value for enterprise_file.enterpriseId
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_file.fileType
	 * @return  the value of enterprise_file.fileType
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public Byte getFiletype() {
		return filetype;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_file.fileType
	 * @param filetype  the value for enterprise_file.fileType
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public void setFiletype(Byte filetype) {
		this.filetype = filetype;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_file.aptitudeType
	 * @return  the value of enterprise_file.aptitudeType
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public Byte getAptitudetype() {
		return aptitudetype;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_file.aptitudeType
	 * @param aptitudetype  the value for enterprise_file.aptitudeType
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public void setAptitudetype(Byte aptitudetype) {
		this.aptitudetype = aptitudetype;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_file.path
	 * @return  the value of enterprise_file.path
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public String getPath() {
		return path;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_file.path
	 * @param path  the value for enterprise_file.path
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_file.createTime
	 * @return  the value of enterprise_file.createTime
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_file.createTime
	 * @param createtime  the value for enterprise_file.createTime
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_file.updatTime
	 * @return  the value of enterprise_file.updatTime
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public String getUpdattime() {
		return updattime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_file.updatTime
	 * @param updattime  the value for enterprise_file.updatTime
	 * @mbggenerated  Fri Dec 18 11:26:28 CST 2015
	 */
	public void setUpdattime(String updattime) {
		this.updattime = updattime == null ? null : updattime.trim();
	}
}