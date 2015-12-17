package com.ronyao.cca.db.model;

public class User {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.id
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.loginName
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String loginname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.token
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String token;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.realName
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String realname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.nickname
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String nickname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.portraitPath
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String portraitpath;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.status
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.createTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.updateTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	private String updatetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.id
	 * @return  the value of user.id
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.id
	 * @param id  the value for user.id
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.loginName
	 * @return  the value of user.loginName
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getLoginname() {
		return loginname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.loginName
	 * @param loginname  the value for user.loginName
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname == null ? null : loginname.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.password
	 * @return  the value of user.password
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.password
	 * @param password  the value for user.password
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.token
	 * @return  the value of user.token
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getToken() {
		return token;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.token
	 * @param token  the value for user.token
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.realName
	 * @return  the value of user.realName
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.realName
	 * @param realname  the value for user.realName
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setRealname(String realname) {
		this.realname = realname == null ? null : realname.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.nickname
	 * @return  the value of user.nickname
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.nickname
	 * @param nickname  the value for user.nickname
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.portraitPath
	 * @return  the value of user.portraitPath
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getPortraitpath() {
		return portraitpath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.portraitPath
	 * @param portraitpath  the value for user.portraitPath
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setPortraitpath(String portraitpath) {
		this.portraitpath = portraitpath == null ? null : portraitpath.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.status
	 * @return  the value of user.status
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.status
	 * @param status  the value for user.status
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.createTime
	 * @return  the value of user.createTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.createTime
	 * @param createtime  the value for user.createTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.updateTime
	 * @return  the value of user.updateTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.updateTime
	 * @param updatetime  the value for user.updateTime
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}
}