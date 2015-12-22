package com.ronyao.cca.db.model;

public class VoltageRankClassify {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column voltage_rank_classify.id
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column voltage_rank_classify.name
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column voltage_rank_classify.value
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private Integer value;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column voltage_rank_classify.bigEquipment
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private Integer bigequipment;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column voltage_rank_classify.id
	 * @return  the value of voltage_rank_classify.id
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column voltage_rank_classify.id
	 * @param id  the value for voltage_rank_classify.id
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column voltage_rank_classify.name
	 * @return  the value of voltage_rank_classify.name
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column voltage_rank_classify.name
	 * @param name  the value for voltage_rank_classify.name
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column voltage_rank_classify.value
	 * @return  the value of voltage_rank_classify.value
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column voltage_rank_classify.value
	 * @param value  the value for voltage_rank_classify.value
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column voltage_rank_classify.bigEquipment
	 * @return  the value of voltage_rank_classify.bigEquipment
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public Integer getBigequipment() {
		return bigequipment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column voltage_rank_classify.bigEquipment
	 * @param bigequipment  the value for voltage_rank_classify.bigEquipment
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setBigequipment(Integer bigequipment) {
		this.bigequipment = bigequipment;
	}
}