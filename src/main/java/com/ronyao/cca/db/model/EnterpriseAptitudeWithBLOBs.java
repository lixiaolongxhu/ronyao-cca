package com.ronyao.cca.db.model;

public class EnterpriseAptitudeWithBLOBs extends EnterpriseAptitude {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_aptitude.charge
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private String charge;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_aptitude.technical
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private String technical;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_aptitude.skills
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private String skills;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column enterprise_aptitude.jobRange
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	private String jobrange;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_aptitude.charge
	 * @return  the value of enterprise_aptitude.charge
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String getCharge() {
		return charge;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_aptitude.charge
	 * @param charge  the value for enterprise_aptitude.charge
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setCharge(String charge) {
		this.charge = charge == null ? null : charge.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_aptitude.technical
	 * @return  the value of enterprise_aptitude.technical
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String getTechnical() {
		return technical;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_aptitude.technical
	 * @param technical  the value for enterprise_aptitude.technical
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setTechnical(String technical) {
		this.technical = technical == null ? null : technical.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_aptitude.skills
	 * @return  the value of enterprise_aptitude.skills
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_aptitude.skills
	 * @param skills  the value for enterprise_aptitude.skills
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setSkills(String skills) {
		this.skills = skills == null ? null : skills.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column enterprise_aptitude.jobRange
	 * @return  the value of enterprise_aptitude.jobRange
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String getJobrange() {
		return jobrange;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column enterprise_aptitude.jobRange
	 * @param jobrange  the value for enterprise_aptitude.jobRange
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setJobrange(String jobrange) {
		this.jobrange = jobrange == null ? null : jobrange.trim();
	}
}