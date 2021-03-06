package com.ronyao.cca.db.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseAssessExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public EnterpriseAssessExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
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

		public Criteria andCategoryIsNull() {
			addCriterion("category is null");
			return (Criteria) this;
		}

		public Criteria andCategoryIsNotNull() {
			addCriterion("category is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryEqualTo(String value) {
			addCriterion("category =", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryNotEqualTo(String value) {
			addCriterion("category <>", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryGreaterThan(String value) {
			addCriterion("category >", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryGreaterThanOrEqualTo(String value) {
			addCriterion("category >=", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryLessThan(String value) {
			addCriterion("category <", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryLessThanOrEqualTo(String value) {
			addCriterion("category <=", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryLike(String value) {
			addCriterion("category like", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryNotLike(String value) {
			addCriterion("category not like", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryIn(List<String> values) {
			addCriterion("category in", values, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryNotIn(List<String> values) {
			addCriterion("category not in", values, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryBetween(String value1, String value2) {
			addCriterion("category between", value1, value2, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryNotBetween(String value1, String value2) {
			addCriterion("category not between", value1, value2, "category");
			return (Criteria) this;
		}

		public Criteria andStandardIsNull() {
			addCriterion("standard is null");
			return (Criteria) this;
		}

		public Criteria andStandardIsNotNull() {
			addCriterion("standard is not null");
			return (Criteria) this;
		}

		public Criteria andStandardEqualTo(String value) {
			addCriterion("standard =", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotEqualTo(String value) {
			addCriterion("standard <>", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardGreaterThan(String value) {
			addCriterion("standard >", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardGreaterThanOrEqualTo(String value) {
			addCriterion("standard >=", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardLessThan(String value) {
			addCriterion("standard <", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardLessThanOrEqualTo(String value) {
			addCriterion("standard <=", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardLike(String value) {
			addCriterion("standard like", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotLike(String value) {
			addCriterion("standard not like", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardIn(List<String> values) {
			addCriterion("standard in", values, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotIn(List<String> values) {
			addCriterion("standard not in", values, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardBetween(String value1, String value2) {
			addCriterion("standard between", value1, value2, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotBetween(String value1, String value2) {
			addCriterion("standard not between", value1, value2, "standard");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartIsNull() {
			addCriterion("projectNumStart is null");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartIsNotNull() {
			addCriterion("projectNumStart is not null");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartEqualTo(Integer value) {
			addCriterion("projectNumStart =", value, "projectnumstart");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartNotEqualTo(Integer value) {
			addCriterion("projectNumStart <>", value, "projectnumstart");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartGreaterThan(Integer value) {
			addCriterion("projectNumStart >", value, "projectnumstart");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartGreaterThanOrEqualTo(Integer value) {
			addCriterion("projectNumStart >=", value, "projectnumstart");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartLessThan(Integer value) {
			addCriterion("projectNumStart <", value, "projectnumstart");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartLessThanOrEqualTo(Integer value) {
			addCriterion("projectNumStart <=", value, "projectnumstart");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartIn(List<Integer> values) {
			addCriterion("projectNumStart in", values, "projectnumstart");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartNotIn(List<Integer> values) {
			addCriterion("projectNumStart not in", values, "projectnumstart");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartBetween(Integer value1, Integer value2) {
			addCriterion("projectNumStart between", value1, value2,
					"projectnumstart");
			return (Criteria) this;
		}

		public Criteria andProjectnumstartNotBetween(Integer value1,
				Integer value2) {
			addCriterion("projectNumStart not between", value1, value2,
					"projectnumstart");
			return (Criteria) this;
		}

		public Criteria andProjectnumendIsNull() {
			addCriterion("projectNumEnd is null");
			return (Criteria) this;
		}

		public Criteria andProjectnumendIsNotNull() {
			addCriterion("projectNumEnd is not null");
			return (Criteria) this;
		}

		public Criteria andProjectnumendEqualTo(Integer value) {
			addCriterion("projectNumEnd =", value, "projectnumend");
			return (Criteria) this;
		}

		public Criteria andProjectnumendNotEqualTo(Integer value) {
			addCriterion("projectNumEnd <>", value, "projectnumend");
			return (Criteria) this;
		}

		public Criteria andProjectnumendGreaterThan(Integer value) {
			addCriterion("projectNumEnd >", value, "projectnumend");
			return (Criteria) this;
		}

		public Criteria andProjectnumendGreaterThanOrEqualTo(Integer value) {
			addCriterion("projectNumEnd >=", value, "projectnumend");
			return (Criteria) this;
		}

		public Criteria andProjectnumendLessThan(Integer value) {
			addCriterion("projectNumEnd <", value, "projectnumend");
			return (Criteria) this;
		}

		public Criteria andProjectnumendLessThanOrEqualTo(Integer value) {
			addCriterion("projectNumEnd <=", value, "projectnumend");
			return (Criteria) this;
		}

		public Criteria andProjectnumendIn(List<Integer> values) {
			addCriterion("projectNumEnd in", values, "projectnumend");
			return (Criteria) this;
		}

		public Criteria andProjectnumendNotIn(List<Integer> values) {
			addCriterion("projectNumEnd not in", values, "projectnumend");
			return (Criteria) this;
		}

		public Criteria andProjectnumendBetween(Integer value1, Integer value2) {
			addCriterion("projectNumEnd between", value1, value2,
					"projectnumend");
			return (Criteria) this;
		}

		public Criteria andProjectnumendNotBetween(Integer value1,
				Integer value2) {
			addCriterion("projectNumEnd not between", value1, value2,
					"projectnumend");
			return (Criteria) this;
		}

		public Criteria andOutputstartIsNull() {
			addCriterion("outputStart is null");
			return (Criteria) this;
		}

		public Criteria andOutputstartIsNotNull() {
			addCriterion("outputStart is not null");
			return (Criteria) this;
		}

		public Criteria andOutputstartEqualTo(BigDecimal value) {
			addCriterion("outputStart =", value, "outputstart");
			return (Criteria) this;
		}

		public Criteria andOutputstartNotEqualTo(BigDecimal value) {
			addCriterion("outputStart <>", value, "outputstart");
			return (Criteria) this;
		}

		public Criteria andOutputstartGreaterThan(BigDecimal value) {
			addCriterion("outputStart >", value, "outputstart");
			return (Criteria) this;
		}

		public Criteria andOutputstartGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("outputStart >=", value, "outputstart");
			return (Criteria) this;
		}

		public Criteria andOutputstartLessThan(BigDecimal value) {
			addCriterion("outputStart <", value, "outputstart");
			return (Criteria) this;
		}

		public Criteria andOutputstartLessThanOrEqualTo(BigDecimal value) {
			addCriterion("outputStart <=", value, "outputstart");
			return (Criteria) this;
		}

		public Criteria andOutputstartIn(List<BigDecimal> values) {
			addCriterion("outputStart in", values, "outputstart");
			return (Criteria) this;
		}

		public Criteria andOutputstartNotIn(List<BigDecimal> values) {
			addCriterion("outputStart not in", values, "outputstart");
			return (Criteria) this;
		}

		public Criteria andOutputstartBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("outputStart between", value1, value2, "outputstart");
			return (Criteria) this;
		}

		public Criteria andOutputstartNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("outputStart not between", value1, value2,
					"outputstart");
			return (Criteria) this;
		}

		public Criteria andOutputendIsNull() {
			addCriterion("outputEnd is null");
			return (Criteria) this;
		}

		public Criteria andOutputendIsNotNull() {
			addCriterion("outputEnd is not null");
			return (Criteria) this;
		}

		public Criteria andOutputendEqualTo(BigDecimal value) {
			addCriterion("outputEnd =", value, "outputend");
			return (Criteria) this;
		}

		public Criteria andOutputendNotEqualTo(BigDecimal value) {
			addCriterion("outputEnd <>", value, "outputend");
			return (Criteria) this;
		}

		public Criteria andOutputendGreaterThan(BigDecimal value) {
			addCriterion("outputEnd >", value, "outputend");
			return (Criteria) this;
		}

		public Criteria andOutputendGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("outputEnd >=", value, "outputend");
			return (Criteria) this;
		}

		public Criteria andOutputendLessThan(BigDecimal value) {
			addCriterion("outputEnd <", value, "outputend");
			return (Criteria) this;
		}

		public Criteria andOutputendLessThanOrEqualTo(BigDecimal value) {
			addCriterion("outputEnd <=", value, "outputend");
			return (Criteria) this;
		}

		public Criteria andOutputendIn(List<BigDecimal> values) {
			addCriterion("outputEnd in", values, "outputend");
			return (Criteria) this;
		}

		public Criteria andOutputendNotIn(List<BigDecimal> values) {
			addCriterion("outputEnd not in", values, "outputend");
			return (Criteria) this;
		}

		public Criteria andOutputendBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("outputEnd between", value1, value2, "outputend");
			return (Criteria) this;
		}

		public Criteria andOutputendNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("outputEnd not between", value1, value2, "outputend");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table enterprise_assess
	 * @mbggenerated  Wed Jan 13 12:15:38 CST 2016
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
     * This class corresponds to the database table enterprise_assess
     *
     * @mbggenerated do_not_delete_during_merge Tue Dec 29 14:59:40 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}