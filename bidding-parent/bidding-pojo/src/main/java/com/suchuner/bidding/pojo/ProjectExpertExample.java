package com.suchuner.bidding.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProjectExpertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExpertExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPjtIdIsNull() {
            addCriterion("pjt_id is null");
            return (Criteria) this;
        }

        public Criteria andPjtIdIsNotNull() {
            addCriterion("pjt_id is not null");
            return (Criteria) this;
        }

        public Criteria andPjtIdEqualTo(Long value) {
            addCriterion("pjt_id =", value, "pjtId");
            return (Criteria) this;
        }

        public Criteria andPjtIdNotEqualTo(Long value) {
            addCriterion("pjt_id <>", value, "pjtId");
            return (Criteria) this;
        }

        public Criteria andPjtIdGreaterThan(Long value) {
            addCriterion("pjt_id >", value, "pjtId");
            return (Criteria) this;
        }

        public Criteria andPjtIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pjt_id >=", value, "pjtId");
            return (Criteria) this;
        }

        public Criteria andPjtIdLessThan(Long value) {
            addCriterion("pjt_id <", value, "pjtId");
            return (Criteria) this;
        }

        public Criteria andPjtIdLessThanOrEqualTo(Long value) {
            addCriterion("pjt_id <=", value, "pjtId");
            return (Criteria) this;
        }

        public Criteria andPjtIdIn(List<Long> values) {
            addCriterion("pjt_id in", values, "pjtId");
            return (Criteria) this;
        }

        public Criteria andPjtIdNotIn(List<Long> values) {
            addCriterion("pjt_id not in", values, "pjtId");
            return (Criteria) this;
        }

        public Criteria andPjtIdBetween(Long value1, Long value2) {
            addCriterion("pjt_id between", value1, value2, "pjtId");
            return (Criteria) this;
        }

        public Criteria andPjtIdNotBetween(Long value1, Long value2) {
            addCriterion("pjt_id not between", value1, value2, "pjtId");
            return (Criteria) this;
        }

        public Criteria andJudge1IdIsNull() {
            addCriterion("judge_1_id is null");
            return (Criteria) this;
        }

        public Criteria andJudge1IdIsNotNull() {
            addCriterion("judge_1_id is not null");
            return (Criteria) this;
        }

        public Criteria andJudge1IdEqualTo(Long value) {
            addCriterion("judge_1_id =", value, "judge1Id");
            return (Criteria) this;
        }

        public Criteria andJudge1IdNotEqualTo(Long value) {
            addCriterion("judge_1_id <>", value, "judge1Id");
            return (Criteria) this;
        }

        public Criteria andJudge1IdGreaterThan(Long value) {
            addCriterion("judge_1_id >", value, "judge1Id");
            return (Criteria) this;
        }

        public Criteria andJudge1IdGreaterThanOrEqualTo(Long value) {
            addCriterion("judge_1_id >=", value, "judge1Id");
            return (Criteria) this;
        }

        public Criteria andJudge1IdLessThan(Long value) {
            addCriterion("judge_1_id <", value, "judge1Id");
            return (Criteria) this;
        }

        public Criteria andJudge1IdLessThanOrEqualTo(Long value) {
            addCriterion("judge_1_id <=", value, "judge1Id");
            return (Criteria) this;
        }

        public Criteria andJudge1IdIn(List<Long> values) {
            addCriterion("judge_1_id in", values, "judge1Id");
            return (Criteria) this;
        }

        public Criteria andJudge1IdNotIn(List<Long> values) {
            addCriterion("judge_1_id not in", values, "judge1Id");
            return (Criteria) this;
        }

        public Criteria andJudge1IdBetween(Long value1, Long value2) {
            addCriterion("judge_1_id between", value1, value2, "judge1Id");
            return (Criteria) this;
        }

        public Criteria andJudge1IdNotBetween(Long value1, Long value2) {
            addCriterion("judge_1_id not between", value1, value2, "judge1Id");
            return (Criteria) this;
        }

        public Criteria andJudge2IdIsNull() {
            addCriterion("judge_2_id is null");
            return (Criteria) this;
        }

        public Criteria andJudge2IdIsNotNull() {
            addCriterion("judge_2_id is not null");
            return (Criteria) this;
        }

        public Criteria andJudge2IdEqualTo(Long value) {
            addCriterion("judge_2_id =", value, "judge2Id");
            return (Criteria) this;
        }

        public Criteria andJudge2IdNotEqualTo(Long value) {
            addCriterion("judge_2_id <>", value, "judge2Id");
            return (Criteria) this;
        }

        public Criteria andJudge2IdGreaterThan(Long value) {
            addCriterion("judge_2_id >", value, "judge2Id");
            return (Criteria) this;
        }

        public Criteria andJudge2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("judge_2_id >=", value, "judge2Id");
            return (Criteria) this;
        }

        public Criteria andJudge2IdLessThan(Long value) {
            addCriterion("judge_2_id <", value, "judge2Id");
            return (Criteria) this;
        }

        public Criteria andJudge2IdLessThanOrEqualTo(Long value) {
            addCriterion("judge_2_id <=", value, "judge2Id");
            return (Criteria) this;
        }

        public Criteria andJudge2IdIn(List<Long> values) {
            addCriterion("judge_2_id in", values, "judge2Id");
            return (Criteria) this;
        }

        public Criteria andJudge2IdNotIn(List<Long> values) {
            addCriterion("judge_2_id not in", values, "judge2Id");
            return (Criteria) this;
        }

        public Criteria andJudge2IdBetween(Long value1, Long value2) {
            addCriterion("judge_2_id between", value1, value2, "judge2Id");
            return (Criteria) this;
        }

        public Criteria andJudge2IdNotBetween(Long value1, Long value2) {
            addCriterion("judge_2_id not between", value1, value2, "judge2Id");
            return (Criteria) this;
        }

        public Criteria andJudge3IdIsNull() {
            addCriterion("judge_3_id is null");
            return (Criteria) this;
        }

        public Criteria andJudge3IdIsNotNull() {
            addCriterion("judge_3_id is not null");
            return (Criteria) this;
        }

        public Criteria andJudge3IdEqualTo(Long value) {
            addCriterion("judge_3_id =", value, "judge3Id");
            return (Criteria) this;
        }

        public Criteria andJudge3IdNotEqualTo(Long value) {
            addCriterion("judge_3_id <>", value, "judge3Id");
            return (Criteria) this;
        }

        public Criteria andJudge3IdGreaterThan(Long value) {
            addCriterion("judge_3_id >", value, "judge3Id");
            return (Criteria) this;
        }

        public Criteria andJudge3IdGreaterThanOrEqualTo(Long value) {
            addCriterion("judge_3_id >=", value, "judge3Id");
            return (Criteria) this;
        }

        public Criteria andJudge3IdLessThan(Long value) {
            addCriterion("judge_3_id <", value, "judge3Id");
            return (Criteria) this;
        }

        public Criteria andJudge3IdLessThanOrEqualTo(Long value) {
            addCriterion("judge_3_id <=", value, "judge3Id");
            return (Criteria) this;
        }

        public Criteria andJudge3IdIn(List<Long> values) {
            addCriterion("judge_3_id in", values, "judge3Id");
            return (Criteria) this;
        }

        public Criteria andJudge3IdNotIn(List<Long> values) {
            addCriterion("judge_3_id not in", values, "judge3Id");
            return (Criteria) this;
        }

        public Criteria andJudge3IdBetween(Long value1, Long value2) {
            addCriterion("judge_3_id between", value1, value2, "judge3Id");
            return (Criteria) this;
        }

        public Criteria andJudge3IdNotBetween(Long value1, Long value2) {
            addCriterion("judge_3_id not between", value1, value2, "judge3Id");
            return (Criteria) this;
        }

        public Criteria andJudge4IdIsNull() {
            addCriterion("judge_4_id is null");
            return (Criteria) this;
        }

        public Criteria andJudge4IdIsNotNull() {
            addCriterion("judge_4_id is not null");
            return (Criteria) this;
        }

        public Criteria andJudge4IdEqualTo(Long value) {
            addCriterion("judge_4_id =", value, "judge4Id");
            return (Criteria) this;
        }

        public Criteria andJudge4IdNotEqualTo(Long value) {
            addCriterion("judge_4_id <>", value, "judge4Id");
            return (Criteria) this;
        }

        public Criteria andJudge4IdGreaterThan(Long value) {
            addCriterion("judge_4_id >", value, "judge4Id");
            return (Criteria) this;
        }

        public Criteria andJudge4IdGreaterThanOrEqualTo(Long value) {
            addCriterion("judge_4_id >=", value, "judge4Id");
            return (Criteria) this;
        }

        public Criteria andJudge4IdLessThan(Long value) {
            addCriterion("judge_4_id <", value, "judge4Id");
            return (Criteria) this;
        }

        public Criteria andJudge4IdLessThanOrEqualTo(Long value) {
            addCriterion("judge_4_id <=", value, "judge4Id");
            return (Criteria) this;
        }

        public Criteria andJudge4IdIn(List<Long> values) {
            addCriterion("judge_4_id in", values, "judge4Id");
            return (Criteria) this;
        }

        public Criteria andJudge4IdNotIn(List<Long> values) {
            addCriterion("judge_4_id not in", values, "judge4Id");
            return (Criteria) this;
        }

        public Criteria andJudge4IdBetween(Long value1, Long value2) {
            addCriterion("judge_4_id between", value1, value2, "judge4Id");
            return (Criteria) this;
        }

        public Criteria andJudge4IdNotBetween(Long value1, Long value2) {
            addCriterion("judge_4_id not between", value1, value2, "judge4Id");
            return (Criteria) this;
        }

        public Criteria andJudge5IdIsNull() {
            addCriterion("judge_5_id is null");
            return (Criteria) this;
        }

        public Criteria andJudge5IdIsNotNull() {
            addCriterion("judge_5_id is not null");
            return (Criteria) this;
        }

        public Criteria andJudge5IdEqualTo(Long value) {
            addCriterion("judge_5_id =", value, "judge5Id");
            return (Criteria) this;
        }

        public Criteria andJudge5IdNotEqualTo(Long value) {
            addCriterion("judge_5_id <>", value, "judge5Id");
            return (Criteria) this;
        }

        public Criteria andJudge5IdGreaterThan(Long value) {
            addCriterion("judge_5_id >", value, "judge5Id");
            return (Criteria) this;
        }

        public Criteria andJudge5IdGreaterThanOrEqualTo(Long value) {
            addCriterion("judge_5_id >=", value, "judge5Id");
            return (Criteria) this;
        }

        public Criteria andJudge5IdLessThan(Long value) {
            addCriterion("judge_5_id <", value, "judge5Id");
            return (Criteria) this;
        }

        public Criteria andJudge5IdLessThanOrEqualTo(Long value) {
            addCriterion("judge_5_id <=", value, "judge5Id");
            return (Criteria) this;
        }

        public Criteria andJudge5IdIn(List<Long> values) {
            addCriterion("judge_5_id in", values, "judge5Id");
            return (Criteria) this;
        }

        public Criteria andJudge5IdNotIn(List<Long> values) {
            addCriterion("judge_5_id not in", values, "judge5Id");
            return (Criteria) this;
        }

        public Criteria andJudge5IdBetween(Long value1, Long value2) {
            addCriterion("judge_5_id between", value1, value2, "judge5Id");
            return (Criteria) this;
        }

        public Criteria andJudge5IdNotBetween(Long value1, Long value2) {
            addCriterion("judge_5_id not between", value1, value2, "judge5Id");
            return (Criteria) this;
        }

        public Criteria andJudge6IdIsNull() {
            addCriterion("judge_6_id is null");
            return (Criteria) this;
        }

        public Criteria andJudge6IdIsNotNull() {
            addCriterion("judge_6_id is not null");
            return (Criteria) this;
        }

        public Criteria andJudge6IdEqualTo(Long value) {
            addCriterion("judge_6_id =", value, "judge6Id");
            return (Criteria) this;
        }

        public Criteria andJudge6IdNotEqualTo(Long value) {
            addCriterion("judge_6_id <>", value, "judge6Id");
            return (Criteria) this;
        }

        public Criteria andJudge6IdGreaterThan(Long value) {
            addCriterion("judge_6_id >", value, "judge6Id");
            return (Criteria) this;
        }

        public Criteria andJudge6IdGreaterThanOrEqualTo(Long value) {
            addCriterion("judge_6_id >=", value, "judge6Id");
            return (Criteria) this;
        }

        public Criteria andJudge6IdLessThan(Long value) {
            addCriterion("judge_6_id <", value, "judge6Id");
            return (Criteria) this;
        }

        public Criteria andJudge6IdLessThanOrEqualTo(Long value) {
            addCriterion("judge_6_id <=", value, "judge6Id");
            return (Criteria) this;
        }

        public Criteria andJudge6IdIn(List<Long> values) {
            addCriterion("judge_6_id in", values, "judge6Id");
            return (Criteria) this;
        }

        public Criteria andJudge6IdNotIn(List<Long> values) {
            addCriterion("judge_6_id not in", values, "judge6Id");
            return (Criteria) this;
        }

        public Criteria andJudge6IdBetween(Long value1, Long value2) {
            addCriterion("judge_6_id between", value1, value2, "judge6Id");
            return (Criteria) this;
        }

        public Criteria andJudge6IdNotBetween(Long value1, Long value2) {
            addCriterion("judge_6_id not between", value1, value2, "judge6Id");
            return (Criteria) this;
        }

        public Criteria andJudge7IdIsNull() {
            addCriterion("judge_7_id is null");
            return (Criteria) this;
        }

        public Criteria andJudge7IdIsNotNull() {
            addCriterion("judge_7_id is not null");
            return (Criteria) this;
        }

        public Criteria andJudge7IdEqualTo(Long value) {
            addCriterion("judge_7_id =", value, "judge7Id");
            return (Criteria) this;
        }

        public Criteria andJudge7IdNotEqualTo(Long value) {
            addCriterion("judge_7_id <>", value, "judge7Id");
            return (Criteria) this;
        }

        public Criteria andJudge7IdGreaterThan(Long value) {
            addCriterion("judge_7_id >", value, "judge7Id");
            return (Criteria) this;
        }

        public Criteria andJudge7IdGreaterThanOrEqualTo(Long value) {
            addCriterion("judge_7_id >=", value, "judge7Id");
            return (Criteria) this;
        }

        public Criteria andJudge7IdLessThan(Long value) {
            addCriterion("judge_7_id <", value, "judge7Id");
            return (Criteria) this;
        }

        public Criteria andJudge7IdLessThanOrEqualTo(Long value) {
            addCriterion("judge_7_id <=", value, "judge7Id");
            return (Criteria) this;
        }

        public Criteria andJudge7IdIn(List<Long> values) {
            addCriterion("judge_7_id in", values, "judge7Id");
            return (Criteria) this;
        }

        public Criteria andJudge7IdNotIn(List<Long> values) {
            addCriterion("judge_7_id not in", values, "judge7Id");
            return (Criteria) this;
        }

        public Criteria andJudge7IdBetween(Long value1, Long value2) {
            addCriterion("judge_7_id between", value1, value2, "judge7Id");
            return (Criteria) this;
        }

        public Criteria andJudge7IdNotBetween(Long value1, Long value2) {
            addCriterion("judge_7_id not between", value1, value2, "judge7Id");
            return (Criteria) this;
        }

        public Criteria andJudge8IdIsNull() {
            addCriterion("judge_8_id is null");
            return (Criteria) this;
        }

        public Criteria andJudge8IdIsNotNull() {
            addCriterion("judge_8_id is not null");
            return (Criteria) this;
        }

        public Criteria andJudge8IdEqualTo(Long value) {
            addCriterion("judge_8_id =", value, "judge8Id");
            return (Criteria) this;
        }

        public Criteria andJudge8IdNotEqualTo(Long value) {
            addCriterion("judge_8_id <>", value, "judge8Id");
            return (Criteria) this;
        }

        public Criteria andJudge8IdGreaterThan(Long value) {
            addCriterion("judge_8_id >", value, "judge8Id");
            return (Criteria) this;
        }

        public Criteria andJudge8IdGreaterThanOrEqualTo(Long value) {
            addCriterion("judge_8_id >=", value, "judge8Id");
            return (Criteria) this;
        }

        public Criteria andJudge8IdLessThan(Long value) {
            addCriterion("judge_8_id <", value, "judge8Id");
            return (Criteria) this;
        }

        public Criteria andJudge8IdLessThanOrEqualTo(Long value) {
            addCriterion("judge_8_id <=", value, "judge8Id");
            return (Criteria) this;
        }

        public Criteria andJudge8IdIn(List<Long> values) {
            addCriterion("judge_8_id in", values, "judge8Id");
            return (Criteria) this;
        }

        public Criteria andJudge8IdNotIn(List<Long> values) {
            addCriterion("judge_8_id not in", values, "judge8Id");
            return (Criteria) this;
        }

        public Criteria andJudge8IdBetween(Long value1, Long value2) {
            addCriterion("judge_8_id between", value1, value2, "judge8Id");
            return (Criteria) this;
        }

        public Criteria andJudge8IdNotBetween(Long value1, Long value2) {
            addCriterion("judge_8_id not between", value1, value2, "judge8Id");
            return (Criteria) this;
        }

        public Criteria andJudge9IdIsNull() {
            addCriterion("judge_9_id is null");
            return (Criteria) this;
        }

        public Criteria andJudge9IdIsNotNull() {
            addCriterion("judge_9_id is not null");
            return (Criteria) this;
        }

        public Criteria andJudge9IdEqualTo(Long value) {
            addCriterion("judge_9_id =", value, "judge9Id");
            return (Criteria) this;
        }

        public Criteria andJudge9IdNotEqualTo(Long value) {
            addCriterion("judge_9_id <>", value, "judge9Id");
            return (Criteria) this;
        }

        public Criteria andJudge9IdGreaterThan(Long value) {
            addCriterion("judge_9_id >", value, "judge9Id");
            return (Criteria) this;
        }

        public Criteria andJudge9IdGreaterThanOrEqualTo(Long value) {
            addCriterion("judge_9_id >=", value, "judge9Id");
            return (Criteria) this;
        }

        public Criteria andJudge9IdLessThan(Long value) {
            addCriterion("judge_9_id <", value, "judge9Id");
            return (Criteria) this;
        }

        public Criteria andJudge9IdLessThanOrEqualTo(Long value) {
            addCriterion("judge_9_id <=", value, "judge9Id");
            return (Criteria) this;
        }

        public Criteria andJudge9IdIn(List<Long> values) {
            addCriterion("judge_9_id in", values, "judge9Id");
            return (Criteria) this;
        }

        public Criteria andJudge9IdNotIn(List<Long> values) {
            addCriterion("judge_9_id not in", values, "judge9Id");
            return (Criteria) this;
        }

        public Criteria andJudge9IdBetween(Long value1, Long value2) {
            addCriterion("judge_9_id between", value1, value2, "judge9Id");
            return (Criteria) this;
        }

        public Criteria andJudge9IdNotBetween(Long value1, Long value2) {
            addCriterion("judge_9_id not between", value1, value2, "judge9Id");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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