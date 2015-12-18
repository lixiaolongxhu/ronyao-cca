package com.ronyao.cca.db.model;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseFileExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public EnterpriseFileExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enterprise_file
	 * @mbggenerated  Fri Dec 18 15:29:24 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table enterprise_file
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

		public Criteria andFiletypeIsNull() {
			addCriterion("fileType is null");
			return (Criteria) this;
		}

		public Criteria andFiletypeIsNotNull() {
			addCriterion("fileType is not null");
			return (Criteria) this;
		}

		public Criteria andFiletypeEqualTo(Byte value) {
			addCriterion("fileType =", value, "filetype");
			return (Criteria) this;
		}

		public Criteria andFiletypeNotEqualTo(Byte value) {
			addCriterion("fileType <>", value, "filetype");
			return (Criteria) this;
		}

		public Criteria andFiletypeGreaterThan(Byte value) {
			addCriterion("fileType >", value, "filetype");
			return (Criteria) this;
		}

		public Criteria andFiletypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("fileType >=", value, "filetype");
			return (Criteria) this;
		}

		public Criteria andFiletypeLessThan(Byte value) {
			addCriterion("fileType <", value, "filetype");
			return (Criteria) this;
		}

		public Criteria andFiletypeLessThanOrEqualTo(Byte value) {
			addCriterion("fileType <=", value, "filetype");
			return (Criteria) this;
		}

		public Criteria andFiletypeIn(List<Byte> values) {
			addCriterion("fileType in", values, "filetype");
			return (Criteria) this;
		}

		public Criteria andFiletypeNotIn(List<Byte> values) {
			addCriterion("fileType not in", values, "filetype");
			return (Criteria) this;
		}

		public Criteria andFiletypeBetween(Byte value1, Byte value2) {
			addCriterion("fileType between", value1, value2, "filetype");
			return (Criteria) this;
		}

		public Criteria andFiletypeNotBetween(Byte value1, Byte value2) {
			addCriterion("fileType not between", value1, value2, "filetype");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeIsNull() {
			addCriterion("aptitudeType is null");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeIsNotNull() {
			addCriterion("aptitudeType is not null");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeEqualTo(Byte value) {
			addCriterion("aptitudeType =", value, "aptitudetype");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeNotEqualTo(Byte value) {
			addCriterion("aptitudeType <>", value, "aptitudetype");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeGreaterThan(Byte value) {
			addCriterion("aptitudeType >", value, "aptitudetype");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("aptitudeType >=", value, "aptitudetype");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeLessThan(Byte value) {
			addCriterion("aptitudeType <", value, "aptitudetype");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeLessThanOrEqualTo(Byte value) {
			addCriterion("aptitudeType <=", value, "aptitudetype");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeIn(List<Byte> values) {
			addCriterion("aptitudeType in", values, "aptitudetype");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeNotIn(List<Byte> values) {
			addCriterion("aptitudeType not in", values, "aptitudetype");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeBetween(Byte value1, Byte value2) {
			addCriterion("aptitudeType between", value1, value2, "aptitudetype");
			return (Criteria) this;
		}

		public Criteria andAptitudetypeNotBetween(Byte value1, Byte value2) {
			addCriterion("aptitudeType not between", value1, value2,
					"aptitudetype");
			return (Criteria) this;
		}

		public Criteria andPathIsNull() {
			addCriterion("path is null");
			return (Criteria) this;
		}

		public Criteria andPathIsNotNull() {
			addCriterion("path is not null");
			return (Criteria) this;
		}

		public Criteria andPathEqualTo(String value) {
			addCriterion("path =", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotEqualTo(String value) {
			addCriterion("path <>", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathGreaterThan(String value) {
			addCriterion("path >", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathGreaterThanOrEqualTo(String value) {
			addCriterion("path >=", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLessThan(String value) {
			addCriterion("path <", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLessThanOrEqualTo(String value) {
			addCriterion("path <=", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLike(String value) {
			addCriterion("path like", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotLike(String value) {
			addCriterion("path not like", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathIn(List<String> values) {
			addCriterion("path in", values, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotIn(List<String> values) {
			addCriterion("path not in", values, "path");
			return (Criteria) this;
		}

		public Criteria andPathBetween(String value1, String value2) {
			addCriterion("path between", value1, value2, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotBetween(String value1, String value2) {
			addCriterion("path not between", value1, value2, "path");
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

		public Criteria andUpdattimeIsNull() {
			addCriterion("updatTime is null");
			return (Criteria) this;
		}

		public Criteria andUpdattimeIsNotNull() {
			addCriterion("updatTime is not null");
			return (Criteria) this;
		}

		public Criteria andUpdattimeEqualTo(String value) {
			addCriterion("updatTime =", value, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeNotEqualTo(String value) {
			addCriterion("updatTime <>", value, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeGreaterThan(String value) {
			addCriterion("updatTime >", value, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeGreaterThanOrEqualTo(String value) {
			addCriterion("updatTime >=", value, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeLessThan(String value) {
			addCriterion("updatTime <", value, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeLessThanOrEqualTo(String value) {
			addCriterion("updatTime <=", value, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeLike(String value) {
			addCriterion("updatTime like", value, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeNotLike(String value) {
			addCriterion("updatTime not like", value, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeIn(List<String> values) {
			addCriterion("updatTime in", values, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeNotIn(List<String> values) {
			addCriterion("updatTime not in", values, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeBetween(String value1, String value2) {
			addCriterion("updatTime between", value1, value2, "updattime");
			return (Criteria) this;
		}

		public Criteria andUpdattimeNotBetween(String value1, String value2) {
			addCriterion("updatTime not between", value1, value2, "updattime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table enterprise_file
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
     * This class corresponds to the database table enterprise_file
     *
     * @mbggenerated do_not_delete_during_merge Wed Dec 09 15:42:41 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}