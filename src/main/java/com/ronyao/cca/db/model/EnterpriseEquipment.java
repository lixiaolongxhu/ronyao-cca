package com.ronyao.cca.db.model;

public class EnterpriseEquipment {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_equipment.id
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_equipment.enterpriseId
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private Integer enterpriseid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_equipment.bigEquipment
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private Integer bigequipment;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_equipment.smallEquipment
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private Integer smallequipment;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_equipment.sum
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private Integer sum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_equipment.createTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private String createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_equipment.updateTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	private String updatetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_equipment.id
	 * @return  the value of enterprise_equipment.id
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_equipment.id
	 * @param id  the value for enterprise_equipment.id
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_equipment.enterpriseId
	 * @return  the value of enterprise_equipment.enterpriseId
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_equipment.enterpriseId
	 * @param enterpriseid  the value for enterprise_equipment.enterpriseId
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_equipment.bigEquipment
	 * @return  the value of enterprise_equipment.bigEquipment
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public Integer getBigequipment() {
		return bigequipment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_equipment.bigEquipment
	 * @param bigequipment  the value for enterprise_equipment.bigEquipment
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setBigequipment(Integer bigequipment) {
		this.bigequipment = bigequipment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_equipment.smallEquipment
	 * @return  the value of enterprise_equipment.smallEquipment
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public Integer getSmallequipment() {
		return smallequipment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_equipment.smallEquipment
	 * @param smallequipment  the value for enterprise_equipment.smallEquipment
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setSmallequipment(Integer smallequipment) {
		this.smallequipment = smallequipment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_equipment.sum
	 * @return  the value of enterprise_equipment.sum
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public Integer getSum() {
		return sum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_equipment.sum
	 * @param sum  the value for enterprise_equipment.sum
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setSum(Integer sum) {
		this.sum = sum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_equipment.createTime
	 * @return  the value of enterprise_equipment.createTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_equipment.createTime
	 * @param createtime  the value for enterprise_equipment.createTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_equipment.updateTime
	 * @return  the value of enterprise_equipment.updateTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_equipment.updateTime
	 * @param updatetime  the value for enterprise_equipment.updateTime
	 * @mbggenerated  Tue Dec 22 10:55:38 CST 2015
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}
}