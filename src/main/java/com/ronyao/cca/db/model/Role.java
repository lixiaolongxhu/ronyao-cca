package com.ronyao.cca.db.model;

public class Role {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.id
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.parentId
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Integer parentid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.name
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.status
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.createTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.updateTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	private String updatetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.id
	 * @return  the value of role.id
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.id
	 * @param id  the value for role.id
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.parentId
	 * @return  the value of role.parentId
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Integer getParentid() {
		return parentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.parentId
	 * @param parentid  the value for role.parentId
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.name
	 * @return  the value of role.name
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.name
	 * @param name  the value for role.name
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.status
	 * @return  the value of role.status
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.status
	 * @param status  the value for role.status
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.createTime
	 * @return  the value of role.createTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.createTime
	 * @param createtime  the value for role.createTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.updateTime
	 * @return  the value of role.updateTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.updateTime
	 * @param updatetime  the value for role.updateTime
	 * @mbggenerated  Fri Dec 18 14:33:37 CST 2015
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}
}