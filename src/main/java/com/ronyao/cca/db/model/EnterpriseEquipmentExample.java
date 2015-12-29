package com.ronyao.cca.db.model;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseEquipmentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public EnterpriseEquipmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
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
            addCriterion("enterpriseId not between", value1, value2, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andBigequipmentIsNull() {
            addCriterion("bigEquipment is null");
            return (Criteria) this;
        }

        public Criteria andBigequipmentIsNotNull() {
            addCriterion("bigEquipment is not null");
            return (Criteria) this;
        }

        public Criteria andBigequipmentEqualTo(Integer value) {
            addCriterion("bigEquipment =", value, "bigequipment");
            return (Criteria) this;
        }

        public Criteria andBigequipmentNotEqualTo(Integer value) {
            addCriterion("bigEquipment <>", value, "bigequipment");
            return (Criteria) this;
        }

        public Criteria andBigequipmentGreaterThan(Integer value) {
            addCriterion("bigEquipment >", value, "bigequipment");
            return (Criteria) this;
        }

        public Criteria andBigequipmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("bigEquipment >=", value, "bigequipment");
            return (Criteria) this;
        }

        public Criteria andBigequipmentLessThan(Integer value) {
            addCriterion("bigEquipment <", value, "bigequipment");
            return (Criteria) this;
        }

        public Criteria andBigequipmentLessThanOrEqualTo(Integer value) {
            addCriterion("bigEquipment <=", value, "bigequipment");
            return (Criteria) this;
        }

        public Criteria andBigequipmentIn(List<Integer> values) {
            addCriterion("bigEquipment in", values, "bigequipment");
            return (Criteria) this;
        }

        public Criteria andBigequipmentNotIn(List<Integer> values) {
            addCriterion("bigEquipment not in", values, "bigequipment");
            return (Criteria) this;
        }

        public Criteria andBigequipmentBetween(Integer value1, Integer value2) {
            addCriterion("bigEquipment between", value1, value2, "bigequipment");
            return (Criteria) this;
        }

        public Criteria andBigequipmentNotBetween(Integer value1, Integer value2) {
            addCriterion("bigEquipment not between", value1, value2, "bigequipment");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentIsNull() {
            addCriterion("smallEquipment is null");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentIsNotNull() {
            addCriterion("smallEquipment is not null");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentEqualTo(Integer value) {
            addCriterion("smallEquipment =", value, "smallequipment");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentNotEqualTo(Integer value) {
            addCriterion("smallEquipment <>", value, "smallequipment");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentGreaterThan(Integer value) {
            addCriterion("smallEquipment >", value, "smallequipment");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("smallEquipment >=", value, "smallequipment");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentLessThan(Integer value) {
            addCriterion("smallEquipment <", value, "smallequipment");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentLessThanOrEqualTo(Integer value) {
            addCriterion("smallEquipment <=", value, "smallequipment");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentIn(List<Integer> values) {
            addCriterion("smallEquipment in", values, "smallequipment");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentNotIn(List<Integer> values) {
            addCriterion("smallEquipment not in", values, "smallequipment");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentBetween(Integer value1, Integer value2) {
            addCriterion("smallEquipment between", value1, value2, "smallequipment");
            return (Criteria) this;
        }

        public Criteria andSmallequipmentNotBetween(Integer value1, Integer value2) {
            addCriterion("smallEquipment not between", value1, value2, "smallequipment");
            return (Criteria) this;
        }

        public Criteria andSumIsNull() {
            addCriterion("sum is null");
            return (Criteria) this;
        }

        public Criteria andSumIsNotNull() {
            addCriterion("sum is not null");
            return (Criteria) this;
        }

        public Criteria andSumEqualTo(Integer value) {
            addCriterion("sum =", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotEqualTo(Integer value) {
            addCriterion("sum <>", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThan(Integer value) {
            addCriterion("sum >", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum >=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThan(Integer value) {
            addCriterion("sum <", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThanOrEqualTo(Integer value) {
            addCriterion("sum <=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumIn(List<Integer> values) {
            addCriterion("sum in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotIn(List<Integer> values) {
            addCriterion("sum not in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumBetween(Integer value1, Integer value2) {
            addCriterion("sum between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotBetween(Integer value1, Integer value2) {
            addCriterion("sum not between", value1, value2, "sum");
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
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table enterprise_equipment
     *
     * @mbggenerated do_not_delete_during_merge Tue Dec 29 14:59:40 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table enterprise_equipment
     *
     * @mbggenerated Tue Dec 29 14:59:40 CST 2015
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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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
}