package com.ronyao.cca.db.model;

public class rolePermissionLinkKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role_permission_link.roleId
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	private Integer roleid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role_permission_link.permissionId
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	private Integer permissionid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role_permission_link.roleId
	 * @return  the value of role_permission_link.roleId
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role_permission_link.roleId
	 * @param roleid  the value for role_permission_link.roleId
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role_permission_link.permissionId
	 * @return  the value of role_permission_link.permissionId
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	public Integer getPermissionid() {
		return permissionid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role_permission_link.permissionId
	 * @param permissionid  the value for role_permission_link.permissionId
	 * @mbggenerated  Mon Dec 21 11:37:23 CST 2015
	 */
	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}
}