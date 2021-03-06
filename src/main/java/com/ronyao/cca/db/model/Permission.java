package com.ronyao.cca.db.model;

public class Permission {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permission.id
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permission.parentId
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private Integer parentid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permission.name
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permission.url
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private String url;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permission.type
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private Byte type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permission.description
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permission.weight
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private Byte weight;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permission.status
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permission.createTime
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column permission.updateTime
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private String updatetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permission.id
	 * @return  the value of permission.id
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permission.id
	 * @param id  the value for permission.id
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permission.parentId
	 * @return  the value of permission.parentId
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public Integer getParentid() {
		return parentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permission.parentId
	 * @param parentid  the value for permission.parentId
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permission.name
	 * @return  the value of permission.name
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permission.name
	 * @param name  the value for permission.name
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permission.url
	 * @return  the value of permission.url
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permission.url
	 * @param url  the value for permission.url
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permission.type
	 * @return  the value of permission.type
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public Byte getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permission.type
	 * @param type  the value for permission.type
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setType(Byte type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permission.description
	 * @return  the value of permission.description
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permission.description
	 * @param description  the value for permission.description
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permission.weight
	 * @return  the value of permission.weight
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public Byte getWeight() {
		return weight;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permission.weight
	 * @param weight  the value for permission.weight
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setWeight(Byte weight) {
		this.weight = weight;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permission.status
	 * @return  the value of permission.status
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permission.status
	 * @param status  the value for permission.status
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permission.createTime
	 * @return  the value of permission.createTime
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permission.createTime
	 * @param createtime  the value for permission.createTime
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column permission.updateTime
	 * @return  the value of permission.updateTime
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column permission.updateTime
	 * @param updatetime  the value for permission.updateTime
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}
}