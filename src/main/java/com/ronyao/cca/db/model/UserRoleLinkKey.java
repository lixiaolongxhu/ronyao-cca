package com.ronyao.cca.db.model;

public class UserRoleLinkKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_role_link.userId
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	private Integer userid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_role_link.roleId
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	private Integer roleid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_role_link.userId
	 * @return  the value of user_role_link.userId
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public Integer getUserid() {
		return userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_role_link.userId
	 * @param userid  the value for user_role_link.userId
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_role_link.roleId
	 * @return  the value of user_role_link.roleId
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_role_link.roleId
	 * @param roleid  the value for user_role_link.roleId
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
}