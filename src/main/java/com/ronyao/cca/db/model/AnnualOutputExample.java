package com.ronyao.cca.db.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AnnualOutputExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public AnnualOutputExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
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

		public Criteria andIdEqualTo(Byte value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Byte value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Byte value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Byte value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Byte value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Byte value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Byte> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Byte> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Byte value1, Byte value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Byte value1, Byte value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidIsNull() {
			addCriterion("voltageRankId is null");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidIsNotNull() {
			addCriterion("voltageRankId is not null");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidEqualTo(Integer value) {
			addCriterion("voltageRankId =", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidNotEqualTo(Integer value) {
			addCriterion("voltageRankId <>", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidGreaterThan(Integer value) {
			addCriterion("voltageRankId >", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidGreaterThanOrEqualTo(Integer value) {
			addCriterion("voltageRankId >=", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidLessThan(Integer value) {
			addCriterion("voltageRankId <", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidLessThanOrEqualTo(Integer value) {
			addCriterion("voltageRankId <=", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidIn(List<Integer> values) {
			addCriterion("voltageRankId in", values, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidNotIn(List<Integer> values) {
			addCriterion("voltageRankId not in", values, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidBetween(Integer value1, Integer value2) {
			addCriterion("voltageRankId between", value1, value2,
					"voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidNotBetween(Integer value1,
				Integer value2) {
			addCriterion("voltageRankId not between", value1, value2,
					"voltagerankid");
			return (Criteria) this;
		}

		public Criteria andProjecttypeIsNull() {
			addCriterion("projectType is null");
			return (Criteria) this;
		}

		public Criteria andProjecttypeIsNotNull() {
			addCriterion("projectType is not null");
			return (Criteria) this;
		}

		public Criteria andProjecttypeEqualTo(Byte value) {
			addCriterion("projectType =", value, "projecttype");
			return (Criteria) this;
		}

		public Criteria andProjecttypeNotEqualTo(Byte value) {
			addCriterion("projectType <>", value, "projecttype");
			return (Criteria) this;
		}

		public Criteria andProjecttypeGreaterThan(Byte value) {
			addCriterion("projectType >", value, "projecttype");
			return (Criteria) this;
		}

		public Criteria andProjecttypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("projectType >=", value, "projecttype");
			return (Criteria) this;
		}

		public Criteria andProjecttypeLessThan(Byte value) {
			addCriterion("projectType <", value, "projecttype");
			return (Criteria) this;
		}

		public Criteria andProjecttypeLessThanOrEqualTo(Byte value) {
			addCriterion("projectType <=", value, "projecttype");
			return (Criteria) this;
		}

		public Criteria andProjecttypeIn(List<Byte> values) {
			addCriterion("projectType in", values, "projecttype");
			return (Criteria) this;
		}

		public Criteria andProjecttypeNotIn(List<Byte> values) {
			addCriterion("projectType not in", values, "projecttype");
			return (Criteria) this;
		}

		public Criteria andProjecttypeBetween(Byte value1, Byte value2) {
			addCriterion("projectType between", value1, value2, "projecttype");
			return (Criteria) this;
		}

		public Criteria andProjecttypeNotBetween(Byte value1, Byte value2) {
			addCriterion("projectType not between", value1, value2,
					"projecttype");
			return (Criteria) this;
		}

		public Criteria andTimllimitIsNull() {
			addCriterion("timLlimit is null");
			return (Criteria) this;
		}

		public Criteria andTimllimitIsNotNull() {
			addCriterion("timLlimit is not null");
			return (Criteria) this;
		}

		public Criteria andTimllimitEqualTo(Byte value) {
			addCriterion("timLlimit =", value, "timllimit");
			return (Criteria) this;
		}

		public Criteria andTimllimitNotEqualTo(Byte value) {
			addCriterion("timLlimit <>", value, "timllimit");
			return (Criteria) this;
		}

		public Criteria andTimllimitGreaterThan(Byte value) {
			addCriterion("timLlimit >", value, "timllimit");
			return (Criteria) this;
		}

		public Criteria andTimllimitGreaterThanOrEqualTo(Byte value) {
			addCriterion("timLlimit >=", value, "timllimit");
			return (Criteria) this;
		}

		public Criteria andTimllimitLessThan(Byte value) {
			addCriterion("timLlimit <", value, "timllimit");
			return (Criteria) this;
		}

		public Criteria andTimllimitLessThanOrEqualTo(Byte value) {
			addCriterion("timLlimit <=", value, "timllimit");
			return (Criteria) this;
		}

		public Criteria andTimllimitIn(List<Byte> values) {
			addCriterion("timLlimit in", values, "timllimit");
			return (Criteria) this;
		}

		public Criteria andTimllimitNotIn(List<Byte> values) {
			addCriterion("timLlimit not in", values, "timllimit");
			return (Criteria) this;
		}

		public Criteria andTimllimitBetween(Byte value1, Byte value2) {
			addCriterion("timLlimit between", value1, value2, "timllimit");
			return (Criteria) this;
		}

		public Criteria andTimllimitNotBetween(Byte value1, Byte value2) {
			addCriterion("timLlimit not between", value1, value2, "timllimit");
			return (Criteria) this;
		}

		public Criteria andProjectnumIsNull() {
			addCriterion("projectNum is null");
			return (Criteria) this;
		}

		public Criteria andProjectnumIsNotNull() {
			addCriterion("projectNum is not null");
			return (Criteria) this;
		}

		public Criteria andProjectnumEqualTo(BigDecimal value) {
			addCriterion("projectNum =", value, "projectnum");
			return (Criteria) this;
		}

		public Criteria andProjectnumNotEqualTo(BigDecimal value) {
			addCriterion("projectNum <>", value, "projectnum");
			return (Criteria) this;
		}

		public Criteria andProjectnumGreaterThan(BigDecimal value) {
			addCriterion("projectNum >", value, "projectnum");
			return (Criteria) this;
		}

		public Criteria andProjectnumGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("projectNum >=", value, "projectnum");
			return (Criteria) this;
		}

		public Criteria andProjectnumLessThan(BigDecimal value) {
			addCriterion("projectNum <", value, "projectnum");
			return (Criteria) this;
		}

		public Criteria andProjectnumLessThanOrEqualTo(BigDecimal value) {
			addCriterion("projectNum <=", value, "projectnum");
			return (Criteria) this;
		}

		public Criteria andProjectnumIn(List<BigDecimal> values) {
			addCriterion("projectNum in", values, "projectnum");
			return (Criteria) this;
		}

		public Criteria andProjectnumNotIn(List<BigDecimal> values) {
			addCriterion("projectNum not in", values, "projectnum");
			return (Criteria) this;
		}

		public Criteria andProjectnumBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("projectNum between", value1, value2, "projectnum");
			return (Criteria) this;
		}

		public Criteria andProjectnumNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("projectNum not between", value1, value2, "projectnum");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputIsNull() {
			addCriterion("annualOutPut is null");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputIsNotNull() {
			addCriterion("annualOutPut is not null");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputEqualTo(Integer value) {
			addCriterion("annualOutPut =", value, "annualoutput");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputNotEqualTo(Integer value) {
			addCriterion("annualOutPut <>", value, "annualoutput");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputGreaterThan(Integer value) {
			addCriterion("annualOutPut >", value, "annualoutput");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputGreaterThanOrEqualTo(Integer value) {
			addCriterion("annualOutPut >=", value, "annualoutput");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputLessThan(Integer value) {
			addCriterion("annualOutPut <", value, "annualoutput");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputLessThanOrEqualTo(Integer value) {
			addCriterion("annualOutPut <=", value, "annualoutput");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputIn(List<Integer> values) {
			addCriterion("annualOutPut in", values, "annualoutput");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputNotIn(List<Integer> values) {
			addCriterion("annualOutPut not in", values, "annualoutput");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputBetween(Integer value1, Integer value2) {
			addCriterion("annualOutPut between", value1, value2, "annualoutput");
			return (Criteria) this;
		}

		public Criteria andAnnualoutputNotBetween(Integer value1, Integer value2) {
			addCriterion("annualOutPut not between", value1, value2,
					"annualoutput");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table annual_output
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
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
     * This class corresponds to the database table annual_output
     *
     * @mbggenerated do_not_delete_during_merge Fri Dec 11 13:04:18 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}