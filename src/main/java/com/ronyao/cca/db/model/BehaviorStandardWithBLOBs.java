package com.ronyao.cca.db.model;

public class BehaviorStandardWithBLOBs extends BehaviorStandard {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior_standard.sincerity
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	private String sincerity;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior_standard.save
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	private String save;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior_standard.progress
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	private String progress;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior_standard.service
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	private String service;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column behavior_standard.other
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	private String other;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior_standard.sincerity
	 * @return  the value of behavior_standard.sincerity
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public String getSincerity() {
		return sincerity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior_standard.sincerity
	 * @param sincerity  the value for behavior_standard.sincerity
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public void setSincerity(String sincerity) {
		this.sincerity = sincerity == null ? null : sincerity.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior_standard.save
	 * @return  the value of behavior_standard.save
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public String getSave() {
		return save;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior_standard.save
	 * @param save  the value for behavior_standard.save
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public void setSave(String save) {
		this.save = save == null ? null : save.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior_standard.progress
	 * @return  the value of behavior_standard.progress
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior_standard.progress
	 * @param progress  the value for behavior_standard.progress
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public void setProgress(String progress) {
		this.progress = progress == null ? null : progress.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior_standard.service
	 * @return  the value of behavior_standard.service
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public String getService() {
		return service;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior_standard.service
	 * @param service  the value for behavior_standard.service
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public void setService(String service) {
		this.service = service == null ? null : service.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column behavior_standard.other
	 * @return  the value of behavior_standard.other
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public String getOther() {
		return other;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column behavior_standard.other
	 * @param other  the value for behavior_standard.other
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public void setOther(String other) {
		this.other = other == null ? null : other.trim();
	}
}