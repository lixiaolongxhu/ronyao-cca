package com.ronyao.cca.db.model;

public class AptitudeClassify {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column aptitude_classify.id
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	private Byte id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column aptitude_classify.name
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	private String name;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column aptitude_classify.id
	 * @return  the value of aptitude_classify.id
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public Byte getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column aptitude_classify.id
	 * @param id  the value for aptitude_classify.id
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public void setId(Byte id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column aptitude_classify.name
	 * @return  the value of aptitude_classify.name
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column aptitude_classify.name
	 * @param name  the value for aptitude_classify.name
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
}