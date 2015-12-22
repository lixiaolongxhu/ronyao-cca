package com.ronyao.cca.db.model;

public class UserRoleLink extends UserRoleLinkKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_role_link.status
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_role_link.createTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_role_link.updateTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private String updatetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_role_link.status
	 * @return  the value of user_role_link.status
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_role_link.status
	 * @param status  the value for user_role_link.status
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_role_link.createTime
	 * @return  the value of user_role_link.createTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_role_link.createTime
	 * @param createtime  the value for user_role_link.createTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_role_link.updateTime
	 * @return  the value of user_role_link.updateTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_role_link.updateTime
	 * @param updatetime  the value for user_role_link.updateTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}
}