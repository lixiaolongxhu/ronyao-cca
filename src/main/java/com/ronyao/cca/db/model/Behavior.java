package com.ronyao.cca.db.model;

import java.math.BigDecimal;

public class Behavior {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior.id
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior.enterpriseId
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	private Integer enterpriseid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior.year
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	private Integer year;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior.generalbadNum
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	private Byte generalbadnum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior.seriousBadNum
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	private Byte seriousbadnum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior.correction
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	private BigDecimal correction;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior.createTime
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior.updateTime
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	private String updatetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior.id
	 * @return  the value of behavior.id
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior.id
	 * @param id  the value for behavior.id
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior.enterpriseId
	 * @return  the value of behavior.enterpriseId
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior.enterpriseId
	 * @param enterpriseid  the value for behavior.enterpriseId
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior.year
	 * @return  the value of behavior.year
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior.year
	 * @param year  the value for behavior.year
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior.generalbadNum
	 * @return  the value of behavior.generalbadNum
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public Byte getGeneralbadnum() {
		return generalbadnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior.generalbadNum
	 * @param generalbadnum  the value for behavior.generalbadNum
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public void setGeneralbadnum(Byte generalbadnum) {
		this.generalbadnum = generalbadnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior.seriousBadNum
	 * @return  the value of behavior.seriousBadNum
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public Byte getSeriousbadnum() {
		return seriousbadnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior.seriousBadNum
	 * @param seriousbadnum  the value for behavior.seriousBadNum
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public void setSeriousbadnum(Byte seriousbadnum) {
		this.seriousbadnum = seriousbadnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior.correction
	 * @return  the value of behavior.correction
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public BigDecimal getCorrection() {
		return correction;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior.correction
	 * @param correction  the value for behavior.correction
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public void setCorrection(BigDecimal correction) {
		this.correction = correction;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior.createTime
	 * @return  the value of behavior.createTime
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior.createTime
	 * @param createtime  the value for behavior.createTime
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior.updateTime
	 * @return  the value of behavior.updateTime
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior.updateTime
	 * @param updatetime  the value for behavior.updateTime
	 * @mbggenerated  Thu Dec 24 10:29:10 CST 2015
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}
}