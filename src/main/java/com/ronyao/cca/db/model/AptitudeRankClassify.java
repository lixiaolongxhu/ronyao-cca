package com.ronyao.cca.db.model;

public class AptitudeRankClassify {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column aptituderank_classify.id
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	private Byte id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column aptituderank_classify.name
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	private String name;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column aptituderank_classify.id
	 * @return  the value of aptituderank_classify.id
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public Byte getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column aptituderank_classify.id
	 * @param id  the value for aptituderank_classify.id
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public void setId(Byte id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column aptituderank_classify.name
	 * @return  the value of aptituderank_classify.name
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column aptituderank_classify.name
	 * @param name  the value for aptituderank_classify.name
	 * @mbggenerated  Tue Jan 12 13:43:05 CST 2016
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
}