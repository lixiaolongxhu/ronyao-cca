package com.ronyao.cca.db.model;

public class BehaviorStandard {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior_standard.id
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior_standard.rankType
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	private Byte ranktype;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior_standard.createTime
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior_standard.updateTime
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	private String updatetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior_standard.id
	 * @return  the value of behavior_standard.id
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior_standard.id
	 * @param id  the value for behavior_standard.id
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior_standard.rankType
	 * @return  the value of behavior_standard.rankType
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	public Byte getRanktype() {
		return ranktype;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior_standard.rankType
	 * @param ranktype  the value for behavior_standard.rankType
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	public void setRanktype(Byte ranktype) {
		this.ranktype = ranktype;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior_standard.createTime
	 * @return  the value of behavior_standard.createTime
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior_standard.createTime
	 * @param createtime  the value for behavior_standard.createTime
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior_standard.updateTime
	 * @return  the value of behavior_standard.updateTime
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior_standard.updateTime
	 * @param updatetime  the value for behavior_standard.updateTime
	 * @mbggenerated  Mon Dec 14 17:18:16 CST 2015
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}
}