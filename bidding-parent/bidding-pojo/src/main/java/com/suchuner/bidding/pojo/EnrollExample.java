package com.suchuner.bidding.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EnrollExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnrollExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSupIdIsNull() {
            addCriterion("sup_id is null");
            return (Criteria) this;
        }

        public Criteria andSupIdIsNotNull() {
            addCriterion("sup_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupIdEqualTo(Long value) {
            addCriterion("sup_id =", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdNotEqualTo(Long value) {
            addCriterion("sup_id <>", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdGreaterThan(Long value) {
            addCriterion("sup_id >", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sup_id >=", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdLessThan(Long value) {
            addCriterion("sup_id <", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdLessThanOrEqualTo(Long value) {
            addCriterion("sup_id <=", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdIn(List<Long> values) {
            addCriterion("sup_id in", values, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdNotIn(List<Long> values) {
            addCriterion("sup_id not in", values, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdBetween(Long value1, Long value2) {
            addCriterion("sup_id between", value1, value2, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdNotBetween(Long value1, Long value2) {
            addCriterion("sup_id not between", value1, value2, "supId");
            return (Criteria) this;
        }

        public Criteria andEnrolldateIsNull() {
            addCriterion("enrollDate is null");
            return (Criteria) this;
        }

        public Criteria andEnrolldateIsNotNull() {
            addCriterion("enrollDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnrolldateEqualTo(Date value) {
            addCriterionForJDBCDate("enrollDate =", value, "enrolldate");
            return (Criteria) this;
        }

        public Criteria andEnrolldateNotEqualTo(Date value) {
            addCriterionForJDBCDate("enrollDate <>", value, "enrolldate");
            return (Criteria) this;
        }

        public Criteria andEnrolldateGreaterThan(Date value) {
            addCriterionForJDBCDate("enrollDate >", value, "enrolldate");
            return (Criteria) this;
        }

        public Criteria andEnrolldateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enrollDate >=", value, "enrolldate");
            return (Criteria) this;
        }

        public Criteria andEnrolldateLessThan(Date value) {
            addCriterionForJDBCDate("enrollDate <", value, "enrolldate");
            return (Criteria) this;
        }

        public Criteria andEnrolldateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enrollDate <=", value, "enrolldate");
            return (Criteria) this;
        }

        public Criteria andEnrolldateIn(List<Date> values) {
            addCriterionForJDBCDate("enrollDate in", values, "enrolldate");
            return (Criteria) this;
        }

        public Criteria andEnrolldateNotIn(List<Date> values) {
            addCriterionForJDBCDate("enrollDate not in", values, "enrolldate");
            return (Criteria) this;
        }

        public Criteria andEnrolldateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enrollDate between", value1, value2, "enrolldate");
            return (Criteria) this;
        }

        public Criteria andEnrolldateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enrollDate not between", value1, value2, "enrolldate");
            return (Criteria) this;
        }

        public Criteria andCrediterIdIsNull() {
            addCriterion("crediter_id is null");
            return (Criteria) this;
        }

        public Criteria andCrediterIdIsNotNull() {
            addCriterion("crediter_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrediterIdEqualTo(Long value) {
            addCriterion("crediter_id =", value, "crediterId");
            return (Criteria) this;
        }

        public Criteria andCrediterIdNotEqualTo(Long value) {
            addCriterion("crediter_id <>", value, "crediterId");
            return (Criteria) this;
        }

        public Criteria andCrediterIdGreaterThan(Long value) {
            addCriterion("crediter_id >", value, "crediterId");
            return (Criteria) this;
        }

        public Criteria andCrediterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("crediter_id >=", value, "crediterId");
            return (Criteria) this;
        }

        public Criteria andCrediterIdLessThan(Long value) {
            addCriterion("crediter_id <", value, "crediterId");
            return (Criteria) this;
        }

        public Criteria andCrediterIdLessThanOrEqualTo(Long value) {
            addCriterion("crediter_id <=", value, "crediterId");
            return (Criteria) this;
        }

        public Criteria andCrediterIdIn(List<Long> values) {
            addCriterion("crediter_id in", values, "crediterId");
            return (Criteria) this;
        }

        public Criteria andCrediterIdNotIn(List<Long> values) {
            addCriterion("crediter_id not in", values, "crediterId");
            return (Criteria) this;
        }

        public Criteria andCrediterIdBetween(Long value1, Long value2) {
            addCriterion("crediter_id between", value1, value2, "crediterId");
            return (Criteria) this;
        }

        public Criteria andCrediterIdNotBetween(Long value1, Long value2) {
            addCriterion("crediter_id not between", value1, value2, "crediterId");
            return (Criteria) this;
        }

        public Criteria andCheckdateIsNull() {
            addCriterion("checkDate is null");
            return (Criteria) this;
        }

        public Criteria andCheckdateIsNotNull() {
            addCriterion("checkDate is not null");
            return (Criteria) this;
        }

        public Criteria andCheckdateEqualTo(Date value) {
            addCriterionForJDBCDate("checkDate =", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("checkDate <>", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateGreaterThan(Date value) {
            addCriterionForJDBCDate("checkDate >", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("checkDate >=", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateLessThan(Date value) {
            addCriterionForJDBCDate("checkDate <", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("checkDate <=", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateIn(List<Date> values) {
            addCriterionForJDBCDate("checkDate in", values, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("checkDate not in", values, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("checkDate between", value1, value2, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("checkDate not between", value1, value2, "checkdate");
            return (Criteria) this;
        }

        public Criteria andIsnormalIsNull() {
            addCriterion("isNormal is null");
            return (Criteria) this;
        }

        public Criteria andIsnormalIsNotNull() {
            addCriterion("isNormal is not null");
            return (Criteria) this;
        }

        public Criteria andIsnormalEqualTo(Byte value) {
            addCriterion("enroll.isNormal =", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalNotEqualTo(Byte value) {
            addCriterion("enroll.isNormal <>", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalGreaterThan(Byte value) {
            addCriterion("enroll.isNormal >", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalGreaterThanOrEqualTo(Byte value) {
            addCriterion("isNormal >=", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalLessThan(Byte value) {
            addCriterion("isNormal <", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalLessThanOrEqualTo(Byte value) {
            addCriterion("isNormal <=", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalIn(List<Byte> values) {
            addCriterion("isNormal in", values, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalNotIn(List<Byte> values) {
            addCriterion("isNormal not in", values, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalBetween(Byte value1, Byte value2) {
            addCriterion("isNormal between", value1, value2, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalNotBetween(Byte value1, Byte value2) {
            addCriterion("isNormal not between", value1, value2, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsenrollIsNull() {
            addCriterion("isEnroll is null");
            return (Criteria) this;
        }

        public Criteria andIsenrollIsNotNull() {
            addCriterion("isEnroll is not null");
            return (Criteria) this;
        }

        public Criteria andIsenrollEqualTo(Byte value) {
            addCriterion("isEnroll =", value, "isenroll");
            return (Criteria) this;
        }

        public Criteria andIsenrollNotEqualTo(Byte value) {
            addCriterion("isEnroll <>", value, "isenroll");
            return (Criteria) this;
        }

        public Criteria andIsenrollGreaterThan(Byte value) {
            addCriterion("isEnroll >", value, "isenroll");
            return (Criteria) this;
        }

        public Criteria andIsenrollGreaterThanOrEqualTo(Byte value) {
            addCriterion("isEnroll >=", value, "isenroll");
            return (Criteria) this;
        }

        public Criteria andIsenrollLessThan(Byte value) {
            addCriterion("isEnroll <", value, "isenroll");
            return (Criteria) this;
        }

        public Criteria andIsenrollLessThanOrEqualTo(Byte value) {
            addCriterion("isEnroll <=", value, "isenroll");
            return (Criteria) this;
        }

        public Criteria andIsenrollIn(List<Byte> values) {
            addCriterion("isEnroll in", values, "isenroll");
            return (Criteria) this;
        }

        public Criteria andIsenrollNotIn(List<Byte> values) {
            addCriterion("isEnroll not in", values, "isenroll");
            return (Criteria) this;
        }

        public Criteria andIsenrollBetween(Byte value1, Byte value2) {
            addCriterion("isEnroll between", value1, value2, "isenroll");
            return (Criteria) this;
        }

        public Criteria andIsenrollNotBetween(Byte value1, Byte value2) {
            addCriterion("isEnroll not between", value1, value2, "isenroll");
            return (Criteria) this;
        }

        public Criteria andIslegalIsNull() {
            addCriterion("islegal is null");
            return (Criteria) this;
        }

        public Criteria andIslegalIsNotNull() {
            addCriterion("islegal is not null");
            return (Criteria) this;
        }

        public Criteria andIslegalEqualTo(Byte value) {
            addCriterion("islegal =", value, "islegal");
            return (Criteria) this;
        }

        public Criteria andIslegalNotEqualTo(Byte value) {
            addCriterion("islegal <>", value, "islegal");
            return (Criteria) this;
        }

        public Criteria andIslegalGreaterThan(Byte value) {
            addCriterion("islegal >", value, "islegal");
            return (Criteria) this;
        }

        public Criteria andIslegalGreaterThanOrEqualTo(Byte value) {
            addCriterion("islegal >=", value, "islegal");
            return (Criteria) this;
        }

        public Criteria andIslegalLessThan(Byte value) {
            addCriterion("islegal <", value, "islegal");
            return (Criteria) this;
        }

        public Criteria andIslegalLessThanOrEqualTo(Byte value) {
            addCriterion("islegal <=", value, "islegal");
            return (Criteria) this;
        }

        public Criteria andIslegalIn(List<Byte> values) {
            addCriterion("islegal in", values, "islegal");
            return (Criteria) this;
        }

        public Criteria andIslegalNotIn(List<Byte> values) {
            addCriterion("islegal not in", values, "islegal");
            return (Criteria) this;
        }

        public Criteria andIslegalBetween(Byte value1, Byte value2) {
            addCriterion("islegal between", value1, value2, "islegal");
            return (Criteria) this;
        }

        public Criteria andIslegalNotBetween(Byte value1, Byte value2) {
            addCriterion("islegal not between", value1, value2, "islegal");
            return (Criteria) this;
        }

        public Criteria andLegaldocIsNull() {
            addCriterion("legalDoc is null");
            return (Criteria) this;
        }

        public Criteria andLegaldocIsNotNull() {
            addCriterion("legalDoc is not null");
            return (Criteria) this;
        }

        public Criteria andLegaldocEqualTo(String value) {
            addCriterion("legalDoc =", value, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocNotEqualTo(String value) {
            addCriterion("legalDoc <>", value, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocGreaterThan(String value) {
            addCriterion("legalDoc >", value, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocGreaterThanOrEqualTo(String value) {
            addCriterion("legalDoc >=", value, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocLessThan(String value) {
            addCriterion("legalDoc <", value, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocLessThanOrEqualTo(String value) {
            addCriterion("legalDoc <=", value, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocLike(String value) {
            addCriterion("legalDoc like", value, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocNotLike(String value) {
            addCriterion("legalDoc not like", value, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocIn(List<String> values) {
            addCriterion("legalDoc in", values, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocNotIn(List<String> values) {
            addCriterion("legalDoc not in", values, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocBetween(String value1, String value2) {
            addCriterion("legalDoc between", value1, value2, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andLegaldocNotBetween(String value1, String value2) {
            addCriterion("legalDoc not between", value1, value2, "legaldoc");
            return (Criteria) this;
        }

        public Criteria andIstaxIsNull() {
            addCriterion("isTax is null");
            return (Criteria) this;
        }

        public Criteria andIstaxIsNotNull() {
            addCriterion("isTax is not null");
            return (Criteria) this;
        }

        public Criteria andIstaxEqualTo(Byte value) {
            addCriterion("isTax =", value, "istax");
            return (Criteria) this;
        }

        public Criteria andIstaxNotEqualTo(Byte value) {
            addCriterion("isTax <>", value, "istax");
            return (Criteria) this;
        }

        public Criteria andIstaxGreaterThan(Byte value) {
            addCriterion("isTax >", value, "istax");
            return (Criteria) this;
        }

        public Criteria andIstaxGreaterThanOrEqualTo(Byte value) {
            addCriterion("isTax >=", value, "istax");
            return (Criteria) this;
        }

        public Criteria andIstaxLessThan(Byte value) {
            addCriterion("isTax <", value, "istax");
            return (Criteria) this;
        }

        public Criteria andIstaxLessThanOrEqualTo(Byte value) {
            addCriterion("isTax <=", value, "istax");
            return (Criteria) this;
        }

        public Criteria andIstaxIn(List<Byte> values) {
            addCriterion("isTax in", values, "istax");
            return (Criteria) this;
        }

        public Criteria andIstaxNotIn(List<Byte> values) {
            addCriterion("isTax not in", values, "istax");
            return (Criteria) this;
        }

        public Criteria andIstaxBetween(Byte value1, Byte value2) {
            addCriterion("isTax between", value1, value2, "istax");
            return (Criteria) this;
        }

        public Criteria andIstaxNotBetween(Byte value1, Byte value2) {
            addCriterion("isTax not between", value1, value2, "istax");
            return (Criteria) this;
        }

        public Criteria andTaxdocIsNull() {
            addCriterion("taxDoc is null");
            return (Criteria) this;
        }

        public Criteria andTaxdocIsNotNull() {
            addCriterion("taxDoc is not null");
            return (Criteria) this;
        }

        public Criteria andTaxdocEqualTo(String value) {
            addCriterion("taxDoc =", value, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocNotEqualTo(String value) {
            addCriterion("taxDoc <>", value, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocGreaterThan(String value) {
            addCriterion("taxDoc >", value, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocGreaterThanOrEqualTo(String value) {
            addCriterion("taxDoc >=", value, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocLessThan(String value) {
            addCriterion("taxDoc <", value, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocLessThanOrEqualTo(String value) {
            addCriterion("taxDoc <=", value, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocLike(String value) {
            addCriterion("taxDoc like", value, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocNotLike(String value) {
            addCriterion("taxDoc not like", value, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocIn(List<String> values) {
            addCriterion("taxDoc in", values, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocNotIn(List<String> values) {
            addCriterion("taxDoc not in", values, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocBetween(String value1, String value2) {
            addCriterion("taxDoc between", value1, value2, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andTaxdocNotBetween(String value1, String value2) {
            addCriterion("taxDoc not between", value1, value2, "taxdoc");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceIsNull() {
            addCriterion("isSocialInsurance is null");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceIsNotNull() {
            addCriterion("isSocialInsurance is not null");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceEqualTo(Byte value) {
            addCriterion("isSocialInsurance =", value, "issocialinsurance");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceNotEqualTo(Byte value) {
            addCriterion("isSocialInsurance <>", value, "issocialinsurance");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceGreaterThan(Byte value) {
            addCriterion("isSocialInsurance >", value, "issocialinsurance");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceGreaterThanOrEqualTo(Byte value) {
            addCriterion("isSocialInsurance >=", value, "issocialinsurance");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceLessThan(Byte value) {
            addCriterion("isSocialInsurance <", value, "issocialinsurance");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceLessThanOrEqualTo(Byte value) {
            addCriterion("isSocialInsurance <=", value, "issocialinsurance");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceIn(List<Byte> values) {
            addCriterion("isSocialInsurance in", values, "issocialinsurance");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceNotIn(List<Byte> values) {
            addCriterion("isSocialInsurance not in", values, "issocialinsurance");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceBetween(Byte value1, Byte value2) {
            addCriterion("isSocialInsurance between", value1, value2, "issocialinsurance");
            return (Criteria) this;
        }

        public Criteria andIssocialinsuranceNotBetween(Byte value1, Byte value2) {
            addCriterion("isSocialInsurance not between", value1, value2, "issocialinsurance");
            return (Criteria) this;
        }

        public Criteria andSidocIsNull() {
            addCriterion("siDoc is null");
            return (Criteria) this;
        }

        public Criteria andSidocIsNotNull() {
            addCriterion("siDoc is not null");
            return (Criteria) this;
        }

        public Criteria andSidocEqualTo(String value) {
            addCriterion("siDoc =", value, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocNotEqualTo(String value) {
            addCriterion("siDoc <>", value, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocGreaterThan(String value) {
            addCriterion("siDoc >", value, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocGreaterThanOrEqualTo(String value) {
            addCriterion("siDoc >=", value, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocLessThan(String value) {
            addCriterion("siDoc <", value, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocLessThanOrEqualTo(String value) {
            addCriterion("siDoc <=", value, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocLike(String value) {
            addCriterion("siDoc like", value, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocNotLike(String value) {
            addCriterion("siDoc not like", value, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocIn(List<String> values) {
            addCriterion("siDoc in", values, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocNotIn(List<String> values) {
            addCriterion("siDoc not in", values, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocBetween(String value1, String value2) {
            addCriterion("siDoc between", value1, value2, "sidoc");
            return (Criteria) this;
        }

        public Criteria andSidocNotBetween(String value1, String value2) {
            addCriterion("siDoc not between", value1, value2, "sidoc");
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