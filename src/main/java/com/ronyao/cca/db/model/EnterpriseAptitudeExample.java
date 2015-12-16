package com.ronyao.cca.db.model;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseAptitudeExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public EnterpriseAptitudeExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andAptitudeidIsNull() {
			addCriterion("aptitudeId is null");
			return (Criteria) this;
		}

		public Criteria andAptitudeidIsNotNull() {
			addCriterion("aptitudeId is not null");
			return (Criteria) this;
		}

		public Criteria andAptitudeidEqualTo(Byte value) {
			addCriterion("aptitudeId =", value, "aptitudeid");
			return (Criteria) this;
		}

		public Criteria andAptitudeidNotEqualTo(Byte value) {
			addCriterion("aptitudeId <>", value, "aptitudeid");
			return (Criteria) this;
		}

		public Criteria andAptitudeidGreaterThan(Byte value) {
			addCriterion("aptitudeId >", value, "aptitudeid");
			return (Criteria) this;
		}

		public Criteria andAptitudeidGreaterThanOrEqualTo(Byte value) {
			addCriterion("aptitudeId >=", value, "aptitudeid");
			return (Criteria) this;
		}

		public Criteria andAptitudeidLessThan(Byte value) {
			addCriterion("aptitudeId <", value, "aptitudeid");
			return (Criteria) this;
		}

		public Criteria andAptitudeidLessThanOrEqualTo(Byte value) {
			addCriterion("aptitudeId <=", value, "aptitudeid");
			return (Criteria) this;
		}

		public Criteria andAptitudeidIn(List<Byte> values) {
			addCriterion("aptitudeId in", values, "aptitudeid");
			return (Criteria) this;
		}

		public Criteria andAptitudeidNotIn(List<Byte> values) {
			addCriterion("aptitudeId not in", values, "aptitudeid");
			return (Criteria) this;
		}

		public Criteria andAptitudeidBetween(Byte value1, Byte value2) {
			addCriterion("aptitudeId between", value1, value2, "aptitudeid");
			return (Criteria) this;
		}

		public Criteria andAptitudeidNotBetween(Byte value1, Byte value2) {
			addCriterion("aptitudeId not between", value1, value2, "aptitudeid");
			return (Criteria) this;
		}

		public Criteria andAptituderankIsNull() {
			addCriterion("aptitudeRank is null");
			return (Criteria) this;
		}

		public Criteria andAptituderankIsNotNull() {
			addCriterion("aptitudeRank is not null");
			return (Criteria) this;
		}

		public Criteria andAptituderankEqualTo(Byte value) {
			addCriterion("aptitudeRank =", value, "aptituderank");
			return (Criteria) this;
		}

		public Criteria andAptituderankNotEqualTo(Byte value) {
			addCriterion("aptitudeRank <>", value, "aptituderank");
			return (Criteria) this;
		}

		public Criteria andAptituderankGreaterThan(Byte value) {
			addCriterion("aptitudeRank >", value, "aptituderank");
			return (Criteria) this;
		}

		public Criteria andAptituderankGreaterThanOrEqualTo(Byte value) {
			addCriterion("aptitudeRank >=", value, "aptituderank");
			return (Criteria) this;
		}

		public Criteria andAptituderankLessThan(Byte value) {
			addCriterion("aptitudeRank <", value, "aptituderank");
			return (Criteria) this;
		}

		public Criteria andAptituderankLessThanOrEqualTo(Byte value) {
			addCriterion("aptitudeRank <=", value, "aptituderank");
			return (Criteria) this;
		}

		public Criteria andAptituderankIn(List<Byte> values) {
			addCriterion("aptitudeRank in", values, "aptituderank");
			return (Criteria) this;
		}

		public Criteria andAptituderankNotIn(List<Byte> values) {
			addCriterion("aptitudeRank not in", values, "aptituderank");
			return (Criteria) this;
		}

		public Criteria andAptituderankBetween(Byte value1, Byte value2) {
			addCriterion("aptitudeRank between", value1, value2, "aptituderank");
			return (Criteria) this;
		}

		public Criteria andAptituderankNotBetween(Byte value1, Byte value2) {
			addCriterion("aptitudeRank not between", value1, value2,
					"aptituderank");
			return (Criteria) this;
		}

		public Criteria andQualificationsIsNull() {
			addCriterion("qualifications is null");
			return (Criteria) this;
		}

		public Criteria andQualificationsIsNotNull() {
			addCriterion("qualifications is not null");
			return (Criteria) this;
		}

		public Criteria andQualificationsEqualTo(String value) {
			addCriterion("qualifications =", value, "qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsNotEqualTo(String value) {
			addCriterion("qualifications <>", value, "qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsGreaterThan(String value) {
			addCriterion("qualifications >", value, "qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsGreaterThanOrEqualTo(String value) {
			addCriterion("qualifications >=", value, "qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsLessThan(String value) {
			addCriterion("qualifications <", value, "qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsLessThanOrEqualTo(String value) {
			addCriterion("qualifications <=", value, "qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsLike(String value) {
			addCriterion("qualifications like", value, "qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsNotLike(String value) {
			addCriterion("qualifications not like", value, "qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsIn(List<String> values) {
			addCriterion("qualifications in", values, "qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsNotIn(List<String> values) {
			addCriterion("qualifications not in", values, "qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsBetween(String value1, String value2) {
			addCriterion("qualifications between", value1, value2,
					"qualifications");
			return (Criteria) this;
		}

		public Criteria andQualificationsNotBetween(String value1, String value2) {
			addCriterion("qualifications not between", value1, value2,
					"qualifications");
			return (Criteria) this;
		}

		public Criteria andPracticingIsNull() {
			addCriterion("practicing is null");
			return (Criteria) this;
		}

		public Criteria andPracticingIsNotNull() {
			addCriterion("practicing is not null");
			return (Criteria) this;
		}

		public Criteria andPracticingEqualTo(String value) {
			addCriterion("practicing =", value, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingNotEqualTo(String value) {
			addCriterion("practicing <>", value, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingGreaterThan(String value) {
			addCriterion("practicing >", value, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingGreaterThanOrEqualTo(String value) {
			addCriterion("practicing >=", value, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingLessThan(String value) {
			addCriterion("practicing <", value, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingLessThanOrEqualTo(String value) {
			addCriterion("practicing <=", value, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingLike(String value) {
			addCriterion("practicing like", value, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingNotLike(String value) {
			addCriterion("practicing not like", value, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingIn(List<String> values) {
			addCriterion("practicing in", values, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingNotIn(List<String> values) {
			addCriterion("practicing not in", values, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingBetween(String value1, String value2) {
			addCriterion("practicing between", value1, value2, "practicing");
			return (Criteria) this;
		}

		public Criteria andPracticingNotBetween(String value1, String value2) {
			addCriterion("practicing not between", value1, value2, "practicing");
			return (Criteria) this;
		}

		public Criteria andChargeIsNull() {
			addCriterion("charge is null");
			return (Criteria) this;
		}

		public Criteria andChargeIsNotNull() {
			addCriterion("charge is not null");
			return (Criteria) this;
		}

		public Criteria andChargeEqualTo(String value) {
			addCriterion("charge =", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotEqualTo(String value) {
			addCriterion("charge <>", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeGreaterThan(String value) {
			addCriterion("charge >", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeGreaterThanOrEqualTo(String value) {
			addCriterion("charge >=", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeLessThan(String value) {
			addCriterion("charge <", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeLessThanOrEqualTo(String value) {
			addCriterion("charge <=", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeLike(String value) {
			addCriterion("charge like", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotLike(String value) {
			addCriterion("charge not like", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeIn(List<String> values) {
			addCriterion("charge in", values, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotIn(List<String> values) {
			addCriterion("charge not in", values, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeBetween(String value1, String value2) {
			addCriterion("charge between", value1, value2, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotBetween(String value1, String value2) {
			addCriterion("charge not between", value1, value2, "charge");
			return (Criteria) this;
		}

		public Criteria andTechnicalIsNull() {
			addCriterion("technical is null");
			return (Criteria) this;
		}

		public Criteria andTechnicalIsNotNull() {
			addCriterion("technical is not null");
			return (Criteria) this;
		}

		public Criteria andTechnicalEqualTo(String value) {
			addCriterion("technical =", value, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalNotEqualTo(String value) {
			addCriterion("technical <>", value, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalGreaterThan(String value) {
			addCriterion("technical >", value, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalGreaterThanOrEqualTo(String value) {
			addCriterion("technical >=", value, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalLessThan(String value) {
			addCriterion("technical <", value, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalLessThanOrEqualTo(String value) {
			addCriterion("technical <=", value, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalLike(String value) {
			addCriterion("technical like", value, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalNotLike(String value) {
			addCriterion("technical not like", value, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalIn(List<String> values) {
			addCriterion("technical in", values, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalNotIn(List<String> values) {
			addCriterion("technical not in", values, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalBetween(String value1, String value2) {
			addCriterion("technical between", value1, value2, "technical");
			return (Criteria) this;
		}

		public Criteria andTechnicalNotBetween(String value1, String value2) {
			addCriterion("technical not between", value1, value2, "technical");
			return (Criteria) this;
		}

		public Criteria andSkillsIsNull() {
			addCriterion("skills is null");
			return (Criteria) this;
		}

		public Criteria andSkillsIsNotNull() {
			addCriterion("skills is not null");
			return (Criteria) this;
		}

		public Criteria andSkillsEqualTo(String value) {
			addCriterion("skills =", value, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsNotEqualTo(String value) {
			addCriterion("skills <>", value, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsGreaterThan(String value) {
			addCriterion("skills >", value, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsGreaterThanOrEqualTo(String value) {
			addCriterion("skills >=", value, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsLessThan(String value) {
			addCriterion("skills <", value, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsLessThanOrEqualTo(String value) {
			addCriterion("skills <=", value, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsLike(String value) {
			addCriterion("skills like", value, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsNotLike(String value) {
			addCriterion("skills not like", value, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsIn(List<String> values) {
			addCriterion("skills in", values, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsNotIn(List<String> values) {
			addCriterion("skills not in", values, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsBetween(String value1, String value2) {
			addCriterion("skills between", value1, value2, "skills");
			return (Criteria) this;
		}

		public Criteria andSkillsNotBetween(String value1, String value2) {
			addCriterion("skills not between", value1, value2, "skills");
			return (Criteria) this;
		}

		public Criteria andJobrangeIsNull() {
			addCriterion("jobRange is null");
			return (Criteria) this;
		}

		public Criteria andJobrangeIsNotNull() {
			addCriterion("jobRange is not null");
			return (Criteria) this;
		}

		public Criteria andJobrangeEqualTo(String value) {
			addCriterion("jobRange =", value, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeNotEqualTo(String value) {
			addCriterion("jobRange <>", value, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeGreaterThan(String value) {
			addCriterion("jobRange >", value, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeGreaterThanOrEqualTo(String value) {
			addCriterion("jobRange >=", value, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeLessThan(String value) {
			addCriterion("jobRange <", value, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeLessThanOrEqualTo(String value) {
			addCriterion("jobRange <=", value, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeLike(String value) {
			addCriterion("jobRange like", value, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeNotLike(String value) {
			addCriterion("jobRange not like", value, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeIn(List<String> values) {
			addCriterion("jobRange in", values, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeNotIn(List<String> values) {
			addCriterion("jobRange not in", values, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeBetween(String value1, String value2) {
			addCriterion("jobRange between", value1, value2, "jobrange");
			return (Criteria) this;
		}

		public Criteria andJobrangeNotBetween(String value1, String value2) {
			addCriterion("jobRange not between", value1, value2, "jobrange");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNull() {
			addCriterion("createTime is null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNotNull() {
			addCriterion("createTime is not null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeEqualTo(String value) {
			addCriterion("createTime =", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotEqualTo(String value) {
			addCriterion("createTime <>", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThan(String value) {
			addCriterion("createTime >", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
			addCriterion("createTime >=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThan(String value) {
			addCriterion("createTime <", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThanOrEqualTo(String value) {
			addCriterion("createTime <=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLike(String value) {
			addCriterion("createTime like", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotLike(String value) {
			addCriterion("createTime not like", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIn(List<String> values) {
			addCriterion("createTime in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotIn(List<String> values) {
			addCriterion("createTime not in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeBetween(String value1, String value2) {
			addCriterion("createTime between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotBetween(String value1, String value2) {
			addCriterion("createTime not between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeIsNull() {
			addCriterion("updateTime is null");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeIsNotNull() {
			addCriterion("updateTime is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeEqualTo(String value) {
			addCriterion("updateTime =", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotEqualTo(String value) {
			addCriterion("updateTime <>", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeGreaterThan(String value) {
			addCriterion("updateTime >", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
			addCriterion("updateTime >=", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeLessThan(String value) {
			addCriterion("updateTime <", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
			addCriterion("updateTime <=", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeLike(String value) {
			addCriterion("updateTime like", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotLike(String value) {
			addCriterion("updateTime not like", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeIn(List<String> values) {
			addCriterion("updateTime in", values, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotIn(List<String> values) {
			addCriterion("updateTime not in", values, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeBetween(String value1, String value2) {
			addCriterion("updateTime between", value1, value2, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotBetween(String value1, String value2) {
			addCriterion("updateTime not between", value1, value2, "updatetime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table enterprise_aptitude
	 * @mbggenerated  Wed Dec 16 10:35:10 CST 2015
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table enterprise_aptitude
     *
     * @mbggenerated do_not_delete_during_merge Thu Dec 10 09:17:40 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}