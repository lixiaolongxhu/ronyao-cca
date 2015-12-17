package com.ronyao.cca.db.model;

import java.util.ArrayList;
import java.util.List;

public class EnterprisePersonExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public EnterprisePersonExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
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

		public Criteria andEnterpriseidIsNull() {
			addCriterion("enterpriseId is null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidIsNotNull() {
			addCriterion("enterpriseId is not null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidEqualTo(Integer value) {
			addCriterion("enterpriseId =", value, "enterpriseid");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidNotEqualTo(Integer value) {
			addCriterion("enterpriseId <>", value, "enterpriseid");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidGreaterThan(Integer value) {
			addCriterion("enterpriseId >", value, "enterpriseid");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidGreaterThanOrEqualTo(Integer value) {
			addCriterion("enterpriseId >=", value, "enterpriseid");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidLessThan(Integer value) {
			addCriterion("enterpriseId <", value, "enterpriseid");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidLessThanOrEqualTo(Integer value) {
			addCriterion("enterpriseId <=", value, "enterpriseid");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidIn(List<Integer> values) {
			addCriterion("enterpriseId in", values, "enterpriseid");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidNotIn(List<Integer> values) {
			addCriterion("enterpriseId not in", values, "enterpriseid");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidBetween(Integer value1, Integer value2) {
			addCriterion("enterpriseId between", value1, value2, "enterpriseid");
			return (Criteria) this;
		}

		public Criteria andEnterpriseidNotBetween(Integer value1, Integer value2) {
			addCriterion("enterpriseId not between", value1, value2,
					"enterpriseid");
			return (Criteria) this;
		}

		public Criteria andConstructoroneIsNull() {
			addCriterion("constructorOne is null");
			return (Criteria) this;
		}

		public Criteria andConstructoroneIsNotNull() {
			addCriterion("constructorOne is not null");
			return (Criteria) this;
		}

		public Criteria andConstructoroneEqualTo(Byte value) {
			addCriterion("constructorOne =", value, "constructorone");
			return (Criteria) this;
		}

		public Criteria andConstructoroneNotEqualTo(Byte value) {
			addCriterion("constructorOne <>", value, "constructorone");
			return (Criteria) this;
		}

		public Criteria andConstructoroneGreaterThan(Byte value) {
			addCriterion("constructorOne >", value, "constructorone");
			return (Criteria) this;
		}

		public Criteria andConstructoroneGreaterThanOrEqualTo(Byte value) {
			addCriterion("constructorOne >=", value, "constructorone");
			return (Criteria) this;
		}

		public Criteria andConstructoroneLessThan(Byte value) {
			addCriterion("constructorOne <", value, "constructorone");
			return (Criteria) this;
		}

		public Criteria andConstructoroneLessThanOrEqualTo(Byte value) {
			addCriterion("constructorOne <=", value, "constructorone");
			return (Criteria) this;
		}

		public Criteria andConstructoroneIn(List<Byte> values) {
			addCriterion("constructorOne in", values, "constructorone");
			return (Criteria) this;
		}

		public Criteria andConstructoroneNotIn(List<Byte> values) {
			addCriterion("constructorOne not in", values, "constructorone");
			return (Criteria) this;
		}

		public Criteria andConstructoroneBetween(Byte value1, Byte value2) {
			addCriterion("constructorOne between", value1, value2,
					"constructorone");
			return (Criteria) this;
		}

		public Criteria andConstructoroneNotBetween(Byte value1, Byte value2) {
			addCriterion("constructorOne not between", value1, value2,
					"constructorone");
			return (Criteria) this;
		}

		public Criteria andConstructortwoIsNull() {
			addCriterion("constructorTwo is null");
			return (Criteria) this;
		}

		public Criteria andConstructortwoIsNotNull() {
			addCriterion("constructorTwo is not null");
			return (Criteria) this;
		}

		public Criteria andConstructortwoEqualTo(Byte value) {
			addCriterion("constructorTwo =", value, "constructortwo");
			return (Criteria) this;
		}

		public Criteria andConstructortwoNotEqualTo(Byte value) {
			addCriterion("constructorTwo <>", value, "constructortwo");
			return (Criteria) this;
		}

		public Criteria andConstructortwoGreaterThan(Byte value) {
			addCriterion("constructorTwo >", value, "constructortwo");
			return (Criteria) this;
		}

		public Criteria andConstructortwoGreaterThanOrEqualTo(Byte value) {
			addCriterion("constructorTwo >=", value, "constructortwo");
			return (Criteria) this;
		}

		public Criteria andConstructortwoLessThan(Byte value) {
			addCriterion("constructorTwo <", value, "constructortwo");
			return (Criteria) this;
		}

		public Criteria andConstructortwoLessThanOrEqualTo(Byte value) {
			addCriterion("constructorTwo <=", value, "constructortwo");
			return (Criteria) this;
		}

		public Criteria andConstructortwoIn(List<Byte> values) {
			addCriterion("constructorTwo in", values, "constructortwo");
			return (Criteria) this;
		}

		public Criteria andConstructortwoNotIn(List<Byte> values) {
			addCriterion("constructorTwo not in", values, "constructortwo");
			return (Criteria) this;
		}

		public Criteria andConstructortwoBetween(Byte value1, Byte value2) {
			addCriterion("constructorTwo between", value1, value2,
					"constructortwo");
			return (Criteria) this;
		}

		public Criteria andConstructortwoNotBetween(Byte value1, Byte value2) {
			addCriterion("constructorTwo not between", value1, value2,
					"constructortwo");
			return (Criteria) this;
		}

		public Criteria andConstructortotalIsNull() {
			addCriterion("constructorTotal is null");
			return (Criteria) this;
		}

		public Criteria andConstructortotalIsNotNull() {
			addCriterion("constructorTotal is not null");
			return (Criteria) this;
		}

		public Criteria andConstructortotalEqualTo(Byte value) {
			addCriterion("constructorTotal =", value, "constructortotal");
			return (Criteria) this;
		}

		public Criteria andConstructortotalNotEqualTo(Byte value) {
			addCriterion("constructorTotal <>", value, "constructortotal");
			return (Criteria) this;
		}

		public Criteria andConstructortotalGreaterThan(Byte value) {
			addCriterion("constructorTotal >", value, "constructortotal");
			return (Criteria) this;
		}

		public Criteria andConstructortotalGreaterThanOrEqualTo(Byte value) {
			addCriterion("constructorTotal >=", value, "constructortotal");
			return (Criteria) this;
		}

		public Criteria andConstructortotalLessThan(Byte value) {
			addCriterion("constructorTotal <", value, "constructortotal");
			return (Criteria) this;
		}

		public Criteria andConstructortotalLessThanOrEqualTo(Byte value) {
			addCriterion("constructorTotal <=", value, "constructortotal");
			return (Criteria) this;
		}

		public Criteria andConstructortotalIn(List<Byte> values) {
			addCriterion("constructorTotal in", values, "constructortotal");
			return (Criteria) this;
		}

		public Criteria andConstructortotalNotIn(List<Byte> values) {
			addCriterion("constructorTotal not in", values, "constructortotal");
			return (Criteria) this;
		}

		public Criteria andConstructortotalBetween(Byte value1, Byte value2) {
			addCriterion("constructorTotal between", value1, value2,
					"constructortotal");
			return (Criteria) this;
		}

		public Criteria andConstructortotalNotBetween(Byte value1, Byte value2) {
			addCriterion("constructorTotal not between", value1, value2,
					"constructortotal");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleIsNull() {
			addCriterion("staffMiddle is null");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleIsNotNull() {
			addCriterion("staffMiddle is not null");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleEqualTo(Byte value) {
			addCriterion("staffMiddle =", value, "staffmiddle");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleNotEqualTo(Byte value) {
			addCriterion("staffMiddle <>", value, "staffmiddle");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleGreaterThan(Byte value) {
			addCriterion("staffMiddle >", value, "staffmiddle");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleGreaterThanOrEqualTo(Byte value) {
			addCriterion("staffMiddle >=", value, "staffmiddle");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleLessThan(Byte value) {
			addCriterion("staffMiddle <", value, "staffmiddle");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleLessThanOrEqualTo(Byte value) {
			addCriterion("staffMiddle <=", value, "staffmiddle");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleIn(List<Byte> values) {
			addCriterion("staffMiddle in", values, "staffmiddle");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleNotIn(List<Byte> values) {
			addCriterion("staffMiddle not in", values, "staffmiddle");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleBetween(Byte value1, Byte value2) {
			addCriterion("staffMiddle between", value1, value2, "staffmiddle");
			return (Criteria) this;
		}

		public Criteria andStaffmiddleNotBetween(Byte value1, Byte value2) {
			addCriterion("staffMiddle not between", value1, value2,
					"staffmiddle");
			return (Criteria) this;
		}

		public Criteria andStaffhighIsNull() {
			addCriterion("staffHigh is null");
			return (Criteria) this;
		}

		public Criteria andStaffhighIsNotNull() {
			addCriterion("staffHigh is not null");
			return (Criteria) this;
		}

		public Criteria andStaffhighEqualTo(Byte value) {
			addCriterion("staffHigh =", value, "staffhigh");
			return (Criteria) this;
		}

		public Criteria andStaffhighNotEqualTo(Byte value) {
			addCriterion("staffHigh <>", value, "staffhigh");
			return (Criteria) this;
		}

		public Criteria andStaffhighGreaterThan(Byte value) {
			addCriterion("staffHigh >", value, "staffhigh");
			return (Criteria) this;
		}

		public Criteria andStaffhighGreaterThanOrEqualTo(Byte value) {
			addCriterion("staffHigh >=", value, "staffhigh");
			return (Criteria) this;
		}

		public Criteria andStaffhighLessThan(Byte value) {
			addCriterion("staffHigh <", value, "staffhigh");
			return (Criteria) this;
		}

		public Criteria andStaffhighLessThanOrEqualTo(Byte value) {
			addCriterion("staffHigh <=", value, "staffhigh");
			return (Criteria) this;
		}

		public Criteria andStaffhighIn(List<Byte> values) {
			addCriterion("staffHigh in", values, "staffhigh");
			return (Criteria) this;
		}

		public Criteria andStaffhighNotIn(List<Byte> values) {
			addCriterion("staffHigh not in", values, "staffhigh");
			return (Criteria) this;
		}

		public Criteria andStaffhighBetween(Byte value1, Byte value2) {
			addCriterion("staffHigh between", value1, value2, "staffhigh");
			return (Criteria) this;
		}

		public Criteria andStaffhighNotBetween(Byte value1, Byte value2) {
			addCriterion("staffHigh not between", value1, value2, "staffhigh");
			return (Criteria) this;
		}

		public Criteria andStafftotalIsNull() {
			addCriterion("staffTotal is null");
			return (Criteria) this;
		}

		public Criteria andStafftotalIsNotNull() {
			addCriterion("staffTotal is not null");
			return (Criteria) this;
		}

		public Criteria andStafftotalEqualTo(Byte value) {
			addCriterion("staffTotal =", value, "stafftotal");
			return (Criteria) this;
		}

		public Criteria andStafftotalNotEqualTo(Byte value) {
			addCriterion("staffTotal <>", value, "stafftotal");
			return (Criteria) this;
		}

		public Criteria andStafftotalGreaterThan(Byte value) {
			addCriterion("staffTotal >", value, "stafftotal");
			return (Criteria) this;
		}

		public Criteria andStafftotalGreaterThanOrEqualTo(Byte value) {
			addCriterion("staffTotal >=", value, "stafftotal");
			return (Criteria) this;
		}

		public Criteria andStafftotalLessThan(Byte value) {
			addCriterion("staffTotal <", value, "stafftotal");
			return (Criteria) this;
		}

		public Criteria andStafftotalLessThanOrEqualTo(Byte value) {
			addCriterion("staffTotal <=", value, "stafftotal");
			return (Criteria) this;
		}

		public Criteria andStafftotalIn(List<Byte> values) {
			addCriterion("staffTotal in", values, "stafftotal");
			return (Criteria) this;
		}

		public Criteria andStafftotalNotIn(List<Byte> values) {
			addCriterion("staffTotal not in", values, "stafftotal");
			return (Criteria) this;
		}

		public Criteria andStafftotalBetween(Byte value1, Byte value2) {
			addCriterion("staffTotal between", value1, value2, "stafftotal");
			return (Criteria) this;
		}

		public Criteria andStafftotalNotBetween(Byte value1, Byte value2) {
			addCriterion("staffTotal not between", value1, value2, "stafftotal");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleIsNull() {
			addCriterion("skillMiddle is null");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleIsNotNull() {
			addCriterion("skillMiddle is not null");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleEqualTo(Byte value) {
			addCriterion("skillMiddle =", value, "skillmiddle");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleNotEqualTo(Byte value) {
			addCriterion("skillMiddle <>", value, "skillmiddle");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleGreaterThan(Byte value) {
			addCriterion("skillMiddle >", value, "skillmiddle");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleGreaterThanOrEqualTo(Byte value) {
			addCriterion("skillMiddle >=", value, "skillmiddle");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleLessThan(Byte value) {
			addCriterion("skillMiddle <", value, "skillmiddle");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleLessThanOrEqualTo(Byte value) {
			addCriterion("skillMiddle <=", value, "skillmiddle");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleIn(List<Byte> values) {
			addCriterion("skillMiddle in", values, "skillmiddle");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleNotIn(List<Byte> values) {
			addCriterion("skillMiddle not in", values, "skillmiddle");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleBetween(Byte value1, Byte value2) {
			addCriterion("skillMiddle between", value1, value2, "skillmiddle");
			return (Criteria) this;
		}

		public Criteria andSkillmiddleNotBetween(Byte value1, Byte value2) {
			addCriterion("skillMiddle not between", value1, value2,
					"skillmiddle");
			return (Criteria) this;
		}

		public Criteria andSkillhighIsNull() {
			addCriterion("skillHigh is null");
			return (Criteria) this;
		}

		public Criteria andSkillhighIsNotNull() {
			addCriterion("skillHigh is not null");
			return (Criteria) this;
		}

		public Criteria andSkillhighEqualTo(Byte value) {
			addCriterion("skillHigh =", value, "skillhigh");
			return (Criteria) this;
		}

		public Criteria andSkillhighNotEqualTo(Byte value) {
			addCriterion("skillHigh <>", value, "skillhigh");
			return (Criteria) this;
		}

		public Criteria andSkillhighGreaterThan(Byte value) {
			addCriterion("skillHigh >", value, "skillhigh");
			return (Criteria) this;
		}

		public Criteria andSkillhighGreaterThanOrEqualTo(Byte value) {
			addCriterion("skillHigh >=", value, "skillhigh");
			return (Criteria) this;
		}

		public Criteria andSkillhighLessThan(Byte value) {
			addCriterion("skillHigh <", value, "skillhigh");
			return (Criteria) this;
		}

		public Criteria andSkillhighLessThanOrEqualTo(Byte value) {
			addCriterion("skillHigh <=", value, "skillhigh");
			return (Criteria) this;
		}

		public Criteria andSkillhighIn(List<Byte> values) {
			addCriterion("skillHigh in", values, "skillhigh");
			return (Criteria) this;
		}

		public Criteria andSkillhighNotIn(List<Byte> values) {
			addCriterion("skillHigh not in", values, "skillhigh");
			return (Criteria) this;
		}

		public Criteria andSkillhighBetween(Byte value1, Byte value2) {
			addCriterion("skillHigh between", value1, value2, "skillhigh");
			return (Criteria) this;
		}

		public Criteria andSkillhighNotBetween(Byte value1, Byte value2) {
			addCriterion("skillHigh not between", value1, value2, "skillhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltechIsNull() {
			addCriterion("skillTech is null");
			return (Criteria) this;
		}

		public Criteria andSkilltechIsNotNull() {
			addCriterion("skillTech is not null");
			return (Criteria) this;
		}

		public Criteria andSkilltechEqualTo(Byte value) {
			addCriterion("skillTech =", value, "skilltech");
			return (Criteria) this;
		}

		public Criteria andSkilltechNotEqualTo(Byte value) {
			addCriterion("skillTech <>", value, "skilltech");
			return (Criteria) this;
		}

		public Criteria andSkilltechGreaterThan(Byte value) {
			addCriterion("skillTech >", value, "skilltech");
			return (Criteria) this;
		}

		public Criteria andSkilltechGreaterThanOrEqualTo(Byte value) {
			addCriterion("skillTech >=", value, "skilltech");
			return (Criteria) this;
		}

		public Criteria andSkilltechLessThan(Byte value) {
			addCriterion("skillTech <", value, "skilltech");
			return (Criteria) this;
		}

		public Criteria andSkilltechLessThanOrEqualTo(Byte value) {
			addCriterion("skillTech <=", value, "skilltech");
			return (Criteria) this;
		}

		public Criteria andSkilltechIn(List<Byte> values) {
			addCriterion("skillTech in", values, "skilltech");
			return (Criteria) this;
		}

		public Criteria andSkilltechNotIn(List<Byte> values) {
			addCriterion("skillTech not in", values, "skilltech");
			return (Criteria) this;
		}

		public Criteria andSkilltechBetween(Byte value1, Byte value2) {
			addCriterion("skillTech between", value1, value2, "skilltech");
			return (Criteria) this;
		}

		public Criteria andSkilltechNotBetween(Byte value1, Byte value2) {
			addCriterion("skillTech not between", value1, value2, "skilltech");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighIsNull() {
			addCriterion("skillTechHigh is null");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighIsNotNull() {
			addCriterion("skillTechHigh is not null");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighEqualTo(Byte value) {
			addCriterion("skillTechHigh =", value, "skilltechhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighNotEqualTo(Byte value) {
			addCriterion("skillTechHigh <>", value, "skilltechhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighGreaterThan(Byte value) {
			addCriterion("skillTechHigh >", value, "skilltechhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighGreaterThanOrEqualTo(Byte value) {
			addCriterion("skillTechHigh >=", value, "skilltechhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighLessThan(Byte value) {
			addCriterion("skillTechHigh <", value, "skilltechhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighLessThanOrEqualTo(Byte value) {
			addCriterion("skillTechHigh <=", value, "skilltechhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighIn(List<Byte> values) {
			addCriterion("skillTechHigh in", values, "skilltechhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighNotIn(List<Byte> values) {
			addCriterion("skillTechHigh not in", values, "skilltechhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighBetween(Byte value1, Byte value2) {
			addCriterion("skillTechHigh between", value1, value2,
					"skilltechhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltechhighNotBetween(Byte value1, Byte value2) {
			addCriterion("skillTechHigh not between", value1, value2,
					"skilltechhigh");
			return (Criteria) this;
		}

		public Criteria andSkilltotalIsNull() {
			addCriterion("skillTotal is null");
			return (Criteria) this;
		}

		public Criteria andSkilltotalIsNotNull() {
			addCriterion("skillTotal is not null");
			return (Criteria) this;
		}

		public Criteria andSkilltotalEqualTo(Byte value) {
			addCriterion("skillTotal =", value, "skilltotal");
			return (Criteria) this;
		}

		public Criteria andSkilltotalNotEqualTo(Byte value) {
			addCriterion("skillTotal <>", value, "skilltotal");
			return (Criteria) this;
		}

		public Criteria andSkilltotalGreaterThan(Byte value) {
			addCriterion("skillTotal >", value, "skilltotal");
			return (Criteria) this;
		}

		public Criteria andSkilltotalGreaterThanOrEqualTo(Byte value) {
			addCriterion("skillTotal >=", value, "skilltotal");
			return (Criteria) this;
		}

		public Criteria andSkilltotalLessThan(Byte value) {
			addCriterion("skillTotal <", value, "skilltotal");
			return (Criteria) this;
		}

		public Criteria andSkilltotalLessThanOrEqualTo(Byte value) {
			addCriterion("skillTotal <=", value, "skilltotal");
			return (Criteria) this;
		}

		public Criteria andSkilltotalIn(List<Byte> values) {
			addCriterion("skillTotal in", values, "skilltotal");
			return (Criteria) this;
		}

		public Criteria andSkilltotalNotIn(List<Byte> values) {
			addCriterion("skillTotal not in", values, "skilltotal");
			return (Criteria) this;
		}

		public Criteria andSkilltotalBetween(Byte value1, Byte value2) {
			addCriterion("skillTotal between", value1, value2, "skilltotal");
			return (Criteria) this;
		}

		public Criteria andSkilltotalNotBetween(Byte value1, Byte value2) {
			addCriterion("skillTotal not between", value1, value2, "skilltotal");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table enterprise_person
	 * @mbggenerated  Thu Dec 17 09:52:13 CST 2015
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
     * This class corresponds to the database table enterprise_person
     *
     * @mbggenerated do_not_delete_during_merge Wed Dec 09 15:42:41 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}