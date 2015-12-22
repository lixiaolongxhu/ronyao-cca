package com.ronyao.cca.db.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectBuildExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	public ProjectBuildExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
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

		public Criteria andSupervisorunitIsNull() {
			addCriterion("supervisorUnit is null");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitIsNotNull() {
			addCriterion("supervisorUnit is not null");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitEqualTo(String value) {
			addCriterion("supervisorUnit =", value, "supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitNotEqualTo(String value) {
			addCriterion("supervisorUnit <>", value, "supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitGreaterThan(String value) {
			addCriterion("supervisorUnit >", value, "supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitGreaterThanOrEqualTo(String value) {
			addCriterion("supervisorUnit >=", value, "supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitLessThan(String value) {
			addCriterion("supervisorUnit <", value, "supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitLessThanOrEqualTo(String value) {
			addCriterion("supervisorUnit <=", value, "supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitLike(String value) {
			addCriterion("supervisorUnit like", value, "supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitNotLike(String value) {
			addCriterion("supervisorUnit not like", value, "supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitIn(List<String> values) {
			addCriterion("supervisorUnit in", values, "supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitNotIn(List<String> values) {
			addCriterion("supervisorUnit not in", values, "supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitBetween(String value1, String value2) {
			addCriterion("supervisorUnit between", value1, value2,
					"supervisorunit");
			return (Criteria) this;
		}

		public Criteria andSupervisorunitNotBetween(String value1, String value2) {
			addCriterion("supervisorUnit not between", value1, value2,
					"supervisorunit");
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

		public Criteria andYearIsNull() {
			addCriterion("year is null");
			return (Criteria) this;
		}

		public Criteria andYearIsNotNull() {
			addCriterion("year is not null");
			return (Criteria) this;
		}

		public Criteria andYearEqualTo(Integer value) {
			addCriterion("year =", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearNotEqualTo(Integer value) {
			addCriterion("year <>", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearGreaterThan(Integer value) {
			addCriterion("year >", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearGreaterThanOrEqualTo(Integer value) {
			addCriterion("year >=", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearLessThan(Integer value) {
			addCriterion("year <", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearLessThanOrEqualTo(Integer value) {
			addCriterion("year <=", value, "year");
			return (Criteria) this;
		}

		public Criteria andYearIn(List<Integer> values) {
			addCriterion("year in", values, "year");
			return (Criteria) this;
		}

		public Criteria andYearNotIn(List<Integer> values) {
			addCriterion("year not in", values, "year");
			return (Criteria) this;
		}

		public Criteria andYearBetween(Integer value1, Integer value2) {
			addCriterion("year between", value1, value2, "year");
			return (Criteria) this;
		}

		public Criteria andYearNotBetween(Integer value1, Integer value2) {
			addCriterion("year not between", value1, value2, "year");
			return (Criteria) this;
		}

		public Criteria andClassifyIsNull() {
			addCriterion("classify is null");
			return (Criteria) this;
		}

		public Criteria andClassifyIsNotNull() {
			addCriterion("classify is not null");
			return (Criteria) this;
		}

		public Criteria andClassifyEqualTo(Integer value) {
			addCriterion("classify =", value, "classify");
			return (Criteria) this;
		}

		public Criteria andClassifyNotEqualTo(Integer value) {
			addCriterion("classify <>", value, "classify");
			return (Criteria) this;
		}

		public Criteria andClassifyGreaterThan(Integer value) {
			addCriterion("classify >", value, "classify");
			return (Criteria) this;
		}

		public Criteria andClassifyGreaterThanOrEqualTo(Integer value) {
			addCriterion("classify >=", value, "classify");
			return (Criteria) this;
		}

		public Criteria andClassifyLessThan(Integer value) {
			addCriterion("classify <", value, "classify");
			return (Criteria) this;
		}

		public Criteria andClassifyLessThanOrEqualTo(Integer value) {
			addCriterion("classify <=", value, "classify");
			return (Criteria) this;
		}

		public Criteria andClassifyIn(List<Integer> values) {
			addCriterion("classify in", values, "classify");
			return (Criteria) this;
		}

		public Criteria andClassifyNotIn(List<Integer> values) {
			addCriterion("classify not in", values, "classify");
			return (Criteria) this;
		}

		public Criteria andClassifyBetween(Integer value1, Integer value2) {
			addCriterion("classify between", value1, value2, "classify");
			return (Criteria) this;
		}

		public Criteria andClassifyNotBetween(Integer value1, Integer value2) {
			addCriterion("classify not between", value1, value2, "classify");
			return (Criteria) this;
		}

		public Criteria andLine110kvIsNull() {
			addCriterion("line110kv is null");
			return (Criteria) this;
		}

		public Criteria andLine110kvIsNotNull() {
			addCriterion("line110kv is not null");
			return (Criteria) this;
		}

		public Criteria andLine110kvEqualTo(Integer value) {
			addCriterion("line110kv =", value, "line110kv");
			return (Criteria) this;
		}

		public Criteria andLine110kvNotEqualTo(Integer value) {
			addCriterion("line110kv <>", value, "line110kv");
			return (Criteria) this;
		}

		public Criteria andLine110kvGreaterThan(Integer value) {
			addCriterion("line110kv >", value, "line110kv");
			return (Criteria) this;
		}

		public Criteria andLine110kvGreaterThanOrEqualTo(Integer value) {
			addCriterion("line110kv >=", value, "line110kv");
			return (Criteria) this;
		}

		public Criteria andLine110kvLessThan(Integer value) {
			addCriterion("line110kv <", value, "line110kv");
			return (Criteria) this;
		}

		public Criteria andLine110kvLessThanOrEqualTo(Integer value) {
			addCriterion("line110kv <=", value, "line110kv");
			return (Criteria) this;
		}

		public Criteria andLine110kvIn(List<Integer> values) {
			addCriterion("line110kv in", values, "line110kv");
			return (Criteria) this;
		}

		public Criteria andLine110kvNotIn(List<Integer> values) {
			addCriterion("line110kv not in", values, "line110kv");
			return (Criteria) this;
		}

		public Criteria andLine110kvBetween(Integer value1, Integer value2) {
			addCriterion("line110kv between", value1, value2, "line110kv");
			return (Criteria) this;
		}

		public Criteria andLine110kvNotBetween(Integer value1, Integer value2) {
			addCriterion("line110kv not between", value1, value2, "line110kv");
			return (Criteria) this;
		}

		public Criteria andLine220kvIsNull() {
			addCriterion("line220kv is null");
			return (Criteria) this;
		}

		public Criteria andLine220kvIsNotNull() {
			addCriterion("line220kv is not null");
			return (Criteria) this;
		}

		public Criteria andLine220kvEqualTo(Integer value) {
			addCriterion("line220kv =", value, "line220kv");
			return (Criteria) this;
		}

		public Criteria andLine220kvNotEqualTo(Integer value) {
			addCriterion("line220kv <>", value, "line220kv");
			return (Criteria) this;
		}

		public Criteria andLine220kvGreaterThan(Integer value) {
			addCriterion("line220kv >", value, "line220kv");
			return (Criteria) this;
		}

		public Criteria andLine220kvGreaterThanOrEqualTo(Integer value) {
			addCriterion("line220kv >=", value, "line220kv");
			return (Criteria) this;
		}

		public Criteria andLine220kvLessThan(Integer value) {
			addCriterion("line220kv <", value, "line220kv");
			return (Criteria) this;
		}

		public Criteria andLine220kvLessThanOrEqualTo(Integer value) {
			addCriterion("line220kv <=", value, "line220kv");
			return (Criteria) this;
		}

		public Criteria andLine220kvIn(List<Integer> values) {
			addCriterion("line220kv in", values, "line220kv");
			return (Criteria) this;
		}

		public Criteria andLine220kvNotIn(List<Integer> values) {
			addCriterion("line220kv not in", values, "line220kv");
			return (Criteria) this;
		}

		public Criteria andLine220kvBetween(Integer value1, Integer value2) {
			addCriterion("line220kv between", value1, value2, "line220kv");
			return (Criteria) this;
		}

		public Criteria andLine220kvNotBetween(Integer value1, Integer value2) {
			addCriterion("line220kv not between", value1, value2, "line220kv");
			return (Criteria) this;
		}

		public Criteria andLine500kvIsNull() {
			addCriterion("line500kv is null");
			return (Criteria) this;
		}

		public Criteria andLine500kvIsNotNull() {
			addCriterion("line500kv is not null");
			return (Criteria) this;
		}

		public Criteria andLine500kvEqualTo(Integer value) {
			addCriterion("line500kv =", value, "line500kv");
			return (Criteria) this;
		}

		public Criteria andLine500kvNotEqualTo(Integer value) {
			addCriterion("line500kv <>", value, "line500kv");
			return (Criteria) this;
		}

		public Criteria andLine500kvGreaterThan(Integer value) {
			addCriterion("line500kv >", value, "line500kv");
			return (Criteria) this;
		}

		public Criteria andLine500kvGreaterThanOrEqualTo(Integer value) {
			addCriterion("line500kv >=", value, "line500kv");
			return (Criteria) this;
		}

		public Criteria andLine500kvLessThan(Integer value) {
			addCriterion("line500kv <", value, "line500kv");
			return (Criteria) this;
		}

		public Criteria andLine500kvLessThanOrEqualTo(Integer value) {
			addCriterion("line500kv <=", value, "line500kv");
			return (Criteria) this;
		}

		public Criteria andLine500kvIn(List<Integer> values) {
			addCriterion("line500kv in", values, "line500kv");
			return (Criteria) this;
		}

		public Criteria andLine500kvNotIn(List<Integer> values) {
			addCriterion("line500kv not in", values, "line500kv");
			return (Criteria) this;
		}

		public Criteria andLine500kvBetween(Integer value1, Integer value2) {
			addCriterion("line500kv between", value1, value2, "line500kv");
			return (Criteria) this;
		}

		public Criteria andLine500kvNotBetween(Integer value1, Integer value2) {
			addCriterion("line500kv not between", value1, value2, "line500kv");
			return (Criteria) this;
		}

		public Criteria andPower110kvIsNull() {
			addCriterion("power110kv is null");
			return (Criteria) this;
		}

		public Criteria andPower110kvIsNotNull() {
			addCriterion("power110kv is not null");
			return (Criteria) this;
		}

		public Criteria andPower110kvEqualTo(Integer value) {
			addCriterion("power110kv =", value, "power110kv");
			return (Criteria) this;
		}

		public Criteria andPower110kvNotEqualTo(Integer value) {
			addCriterion("power110kv <>", value, "power110kv");
			return (Criteria) this;
		}

		public Criteria andPower110kvGreaterThan(Integer value) {
			addCriterion("power110kv >", value, "power110kv");
			return (Criteria) this;
		}

		public Criteria andPower110kvGreaterThanOrEqualTo(Integer value) {
			addCriterion("power110kv >=", value, "power110kv");
			return (Criteria) this;
		}

		public Criteria andPower110kvLessThan(Integer value) {
			addCriterion("power110kv <", value, "power110kv");
			return (Criteria) this;
		}

		public Criteria andPower110kvLessThanOrEqualTo(Integer value) {
			addCriterion("power110kv <=", value, "power110kv");
			return (Criteria) this;
		}

		public Criteria andPower110kvIn(List<Integer> values) {
			addCriterion("power110kv in", values, "power110kv");
			return (Criteria) this;
		}

		public Criteria andPower110kvNotIn(List<Integer> values) {
			addCriterion("power110kv not in", values, "power110kv");
			return (Criteria) this;
		}

		public Criteria andPower110kvBetween(Integer value1, Integer value2) {
			addCriterion("power110kv between", value1, value2, "power110kv");
			return (Criteria) this;
		}

		public Criteria andPower110kvNotBetween(Integer value1, Integer value2) {
			addCriterion("power110kv not between", value1, value2, "power110kv");
			return (Criteria) this;
		}

		public Criteria andPower220kvIsNull() {
			addCriterion("power220kv is null");
			return (Criteria) this;
		}

		public Criteria andPower220kvIsNotNull() {
			addCriterion("power220kv is not null");
			return (Criteria) this;
		}

		public Criteria andPower220kvEqualTo(Integer value) {
			addCriterion("power220kv =", value, "power220kv");
			return (Criteria) this;
		}

		public Criteria andPower220kvNotEqualTo(Integer value) {
			addCriterion("power220kv <>", value, "power220kv");
			return (Criteria) this;
		}

		public Criteria andPower220kvGreaterThan(Integer value) {
			addCriterion("power220kv >", value, "power220kv");
			return (Criteria) this;
		}

		public Criteria andPower220kvGreaterThanOrEqualTo(Integer value) {
			addCriterion("power220kv >=", value, "power220kv");
			return (Criteria) this;
		}

		public Criteria andPower220kvLessThan(Integer value) {
			addCriterion("power220kv <", value, "power220kv");
			return (Criteria) this;
		}

		public Criteria andPower220kvLessThanOrEqualTo(Integer value) {
			addCriterion("power220kv <=", value, "power220kv");
			return (Criteria) this;
		}

		public Criteria andPower220kvIn(List<Integer> values) {
			addCriterion("power220kv in", values, "power220kv");
			return (Criteria) this;
		}

		public Criteria andPower220kvNotIn(List<Integer> values) {
			addCriterion("power220kv not in", values, "power220kv");
			return (Criteria) this;
		}

		public Criteria andPower220kvBetween(Integer value1, Integer value2) {
			addCriterion("power220kv between", value1, value2, "power220kv");
			return (Criteria) this;
		}

		public Criteria andPower220kvNotBetween(Integer value1, Integer value2) {
			addCriterion("power220kv not between", value1, value2, "power220kv");
			return (Criteria) this;
		}

		public Criteria andPower500kvIsNull() {
			addCriterion("power500kv is null");
			return (Criteria) this;
		}

		public Criteria andPower500kvIsNotNull() {
			addCriterion("power500kv is not null");
			return (Criteria) this;
		}

		public Criteria andPower500kvEqualTo(Integer value) {
			addCriterion("power500kv =", value, "power500kv");
			return (Criteria) this;
		}

		public Criteria andPower500kvNotEqualTo(Integer value) {
			addCriterion("power500kv <>", value, "power500kv");
			return (Criteria) this;
		}

		public Criteria andPower500kvGreaterThan(Integer value) {
			addCriterion("power500kv >", value, "power500kv");
			return (Criteria) this;
		}

		public Criteria andPower500kvGreaterThanOrEqualTo(Integer value) {
			addCriterion("power500kv >=", value, "power500kv");
			return (Criteria) this;
		}

		public Criteria andPower500kvLessThan(Integer value) {
			addCriterion("power500kv <", value, "power500kv");
			return (Criteria) this;
		}

		public Criteria andPower500kvLessThanOrEqualTo(Integer value) {
			addCriterion("power500kv <=", value, "power500kv");
			return (Criteria) this;
		}

		public Criteria andPower500kvIn(List<Integer> values) {
			addCriterion("power500kv in", values, "power500kv");
			return (Criteria) this;
		}

		public Criteria andPower500kvNotIn(List<Integer> values) {
			addCriterion("power500kv not in", values, "power500kv");
			return (Criteria) this;
		}

		public Criteria andPower500kvBetween(Integer value1, Integer value2) {
			addCriterion("power500kv between", value1, value2, "power500kv");
			return (Criteria) this;
		}

		public Criteria andPower500kvNotBetween(Integer value1, Integer value2) {
			addCriterion("power500kv not between", value1, value2, "power500kv");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table project_build
	 * @mbggenerated  Tue Dec 22 14:07:13 CST 2015
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
     * This class corresponds to the database table project_build
     *
     * @mbggenerated do_not_delete_during_merge Fri Dec 18 11:21:36 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}