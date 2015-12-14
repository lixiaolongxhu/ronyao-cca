package com.ronyao.cca.db.model;

import java.util.ArrayList;
import java.util.List;

public class EquipmentBearExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public EquipmentBearExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
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

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
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

		public Criteria andVoltagerankidEqualTo(Byte value) {
			addCriterion("voltageRankId =", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidNotEqualTo(Byte value) {
			addCriterion("voltageRankId <>", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidGreaterThan(Byte value) {
			addCriterion("voltageRankId >", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidGreaterThanOrEqualTo(Byte value) {
			addCriterion("voltageRankId >=", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidLessThan(Byte value) {
			addCriterion("voltageRankId <", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidLessThanOrEqualTo(Byte value) {
			addCriterion("voltageRankId <=", value, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidIn(List<Byte> values) {
			addCriterion("voltageRankId in", values, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidNotIn(List<Byte> values) {
			addCriterion("voltageRankId not in", values, "voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidBetween(Byte value1, Byte value2) {
			addCriterion("voltageRankId between", value1, value2,
					"voltagerankid");
			return (Criteria) this;
		}

		public Criteria andVoltagerankidNotBetween(Byte value1, Byte value2) {
			addCriterion("voltageRankId not between", value1, value2,
					"voltagerankid");
			return (Criteria) this;
		}

		public Criteria andLinetypeIsNull() {
			addCriterion("lineType is null");
			return (Criteria) this;
		}

		public Criteria andLinetypeIsNotNull() {
			addCriterion("lineType is not null");
			return (Criteria) this;
		}

		public Criteria andLinetypeEqualTo(Byte value) {
			addCriterion("lineType =", value, "linetype");
			return (Criteria) this;
		}

		public Criteria andLinetypeNotEqualTo(Byte value) {
			addCriterion("lineType <>", value, "linetype");
			return (Criteria) this;
		}

		public Criteria andLinetypeGreaterThan(Byte value) {
			addCriterion("lineType >", value, "linetype");
			return (Criteria) this;
		}

		public Criteria andLinetypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("lineType >=", value, "linetype");
			return (Criteria) this;
		}

		public Criteria andLinetypeLessThan(Byte value) {
			addCriterion("lineType <", value, "linetype");
			return (Criteria) this;
		}

		public Criteria andLinetypeLessThanOrEqualTo(Byte value) {
			addCriterion("lineType <=", value, "linetype");
			return (Criteria) this;
		}

		public Criteria andLinetypeIn(List<Byte> values) {
			addCriterion("lineType in", values, "linetype");
			return (Criteria) this;
		}

		public Criteria andLinetypeNotIn(List<Byte> values) {
			addCriterion("lineType not in", values, "linetype");
			return (Criteria) this;
		}

		public Criteria andLinetypeBetween(Byte value1, Byte value2) {
			addCriterion("lineType between", value1, value2, "linetype");
			return (Criteria) this;
		}

		public Criteria andLinetypeNotBetween(Byte value1, Byte value2) {
			addCriterion("lineType not between", value1, value2, "linetype");
			return (Criteria) this;
		}

		public Criteria andLineplainIsNull() {
			addCriterion("linePlain is null");
			return (Criteria) this;
		}

		public Criteria andLineplainIsNotNull() {
			addCriterion("linePlain is not null");
			return (Criteria) this;
		}

		public Criteria andLineplainEqualTo(Byte value) {
			addCriterion("linePlain =", value, "lineplain");
			return (Criteria) this;
		}

		public Criteria andLineplainNotEqualTo(Byte value) {
			addCriterion("linePlain <>", value, "lineplain");
			return (Criteria) this;
		}

		public Criteria andLineplainGreaterThan(Byte value) {
			addCriterion("linePlain >", value, "lineplain");
			return (Criteria) this;
		}

		public Criteria andLineplainGreaterThanOrEqualTo(Byte value) {
			addCriterion("linePlain >=", value, "lineplain");
			return (Criteria) this;
		}

		public Criteria andLineplainLessThan(Byte value) {
			addCriterion("linePlain <", value, "lineplain");
			return (Criteria) this;
		}

		public Criteria andLineplainLessThanOrEqualTo(Byte value) {
			addCriterion("linePlain <=", value, "lineplain");
			return (Criteria) this;
		}

		public Criteria andLineplainIn(List<Byte> values) {
			addCriterion("linePlain in", values, "lineplain");
			return (Criteria) this;
		}

		public Criteria andLineplainNotIn(List<Byte> values) {
			addCriterion("linePlain not in", values, "lineplain");
			return (Criteria) this;
		}

		public Criteria andLineplainBetween(Byte value1, Byte value2) {
			addCriterion("linePlain between", value1, value2, "lineplain");
			return (Criteria) this;
		}

		public Criteria andLineplainNotBetween(Byte value1, Byte value2) {
			addCriterion("linePlain not between", value1, value2, "lineplain");
			return (Criteria) this;
		}

		public Criteria andLinebraeIsNull() {
			addCriterion("lineBrae is null");
			return (Criteria) this;
		}

		public Criteria andLinebraeIsNotNull() {
			addCriterion("lineBrae is not null");
			return (Criteria) this;
		}

		public Criteria andLinebraeEqualTo(Byte value) {
			addCriterion("lineBrae =", value, "linebrae");
			return (Criteria) this;
		}

		public Criteria andLinebraeNotEqualTo(Byte value) {
			addCriterion("lineBrae <>", value, "linebrae");
			return (Criteria) this;
		}

		public Criteria andLinebraeGreaterThan(Byte value) {
			addCriterion("lineBrae >", value, "linebrae");
			return (Criteria) this;
		}

		public Criteria andLinebraeGreaterThanOrEqualTo(Byte value) {
			addCriterion("lineBrae >=", value, "linebrae");
			return (Criteria) this;
		}

		public Criteria andLinebraeLessThan(Byte value) {
			addCriterion("lineBrae <", value, "linebrae");
			return (Criteria) this;
		}

		public Criteria andLinebraeLessThanOrEqualTo(Byte value) {
			addCriterion("lineBrae <=", value, "linebrae");
			return (Criteria) this;
		}

		public Criteria andLinebraeIn(List<Byte> values) {
			addCriterion("lineBrae in", values, "linebrae");
			return (Criteria) this;
		}

		public Criteria andLinebraeNotIn(List<Byte> values) {
			addCriterion("lineBrae not in", values, "linebrae");
			return (Criteria) this;
		}

		public Criteria andLinebraeBetween(Byte value1, Byte value2) {
			addCriterion("lineBrae between", value1, value2, "linebrae");
			return (Criteria) this;
		}

		public Criteria andLinebraeNotBetween(Byte value1, Byte value2) {
			addCriterion("lineBrae not between", value1, value2, "linebrae");
			return (Criteria) this;
		}

		public Criteria andExplainsIsNull() {
			addCriterion("explains is null");
			return (Criteria) this;
		}

		public Criteria andExplainsIsNotNull() {
			addCriterion("explains is not null");
			return (Criteria) this;
		}

		public Criteria andExplainsEqualTo(String value) {
			addCriterion("explains =", value, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsNotEqualTo(String value) {
			addCriterion("explains <>", value, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsGreaterThan(String value) {
			addCriterion("explains >", value, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsGreaterThanOrEqualTo(String value) {
			addCriterion("explains >=", value, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsLessThan(String value) {
			addCriterion("explains <", value, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsLessThanOrEqualTo(String value) {
			addCriterion("explains <=", value, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsLike(String value) {
			addCriterion("explains like", value, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsNotLike(String value) {
			addCriterion("explains not like", value, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsIn(List<String> values) {
			addCriterion("explains in", values, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsNotIn(List<String> values) {
			addCriterion("explains not in", values, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsBetween(String value1, String value2) {
			addCriterion("explains between", value1, value2, "explains");
			return (Criteria) this;
		}

		public Criteria andExplainsNotBetween(String value1, String value2) {
			addCriterion("explains not between", value1, value2, "explains");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table equipment_bear
	 * @mbggenerated  Mon Dec 14 12:58:34 CST 2015
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
     * This class corresponds to the database table equipment_bear
     *
     * @mbggenerated do_not_delete_during_merge Wed Dec 09 15:42:41 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}