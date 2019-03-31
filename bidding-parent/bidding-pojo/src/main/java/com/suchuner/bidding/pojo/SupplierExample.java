package com.suchuner.bidding.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupplierExample() {
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

        public Criteria andBusemailIsNull() {
            addCriterion("busEmail is null");
            return (Criteria) this;
        }

        public Criteria andBusemailIsNotNull() {
            addCriterion("busEmail is not null");
            return (Criteria) this;
        }

        public Criteria andBusemailEqualTo(String value) {
            addCriterion("busEmail =", value, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailNotEqualTo(String value) {
            addCriterion("busEmail <>", value, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailGreaterThan(String value) {
            addCriterion("busEmail >", value, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailGreaterThanOrEqualTo(String value) {
            addCriterion("busEmail >=", value, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailLessThan(String value) {
            addCriterion("busEmail <", value, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailLessThanOrEqualTo(String value) {
            addCriterion("busEmail <=", value, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailLike(String value) {
            addCriterion("busEmail like", value, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailNotLike(String value) {
            addCriterion("busEmail not like", value, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailIn(List<String> values) {
            addCriterion("busEmail in", values, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailNotIn(List<String> values) {
            addCriterion("busEmail not in", values, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailBetween(String value1, String value2) {
            addCriterion("busEmail between", value1, value2, "busemail");
            return (Criteria) this;
        }

        public Criteria andBusemailNotBetween(String value1, String value2) {
            addCriterion("busEmail not between", value1, value2, "busemail");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("linkMan is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkMan is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkMan =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkMan <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkMan >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkMan >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkMan <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkMan <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkMan like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkMan not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkMan in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkMan not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkMan between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkMan not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailIsNull() {
            addCriterion("linkManEmail is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailIsNotNull() {
            addCriterion("linkManEmail is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailEqualTo(String value) {
            addCriterion("linkManEmail =", value, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailNotEqualTo(String value) {
            addCriterion("linkManEmail <>", value, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailGreaterThan(String value) {
            addCriterion("linkManEmail >", value, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailGreaterThanOrEqualTo(String value) {
            addCriterion("linkManEmail >=", value, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailLessThan(String value) {
            addCriterion("linkManEmail <", value, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailLessThanOrEqualTo(String value) {
            addCriterion("linkManEmail <=", value, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailLike(String value) {
            addCriterion("linkManEmail like", value, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailNotLike(String value) {
            addCriterion("linkManEmail not like", value, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailIn(List<String> values) {
            addCriterion("linkManEmail in", values, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailNotIn(List<String> values) {
            addCriterion("linkManEmail not in", values, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailBetween(String value1, String value2) {
            addCriterion("linkManEmail between", value1, value2, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andLinkmanemailNotBetween(String value1, String value2) {
            addCriterion("linkManEmail not between", value1, value2, "linkmanemail");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andCheckmanIsNull() {
            addCriterion("checkMan is null");
            return (Criteria) this;
        }

        public Criteria andCheckmanIsNotNull() {
            addCriterion("checkMan is not null");
            return (Criteria) this;
        }

        public Criteria andCheckmanEqualTo(Long value) {
            addCriterion("checkMan =", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanNotEqualTo(Long value) {
            addCriterion("checkMan <>", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanGreaterThan(Long value) {
            addCriterion("checkMan >", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanGreaterThanOrEqualTo(Long value) {
            addCriterion("checkMan >=", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanLessThan(Long value) {
            addCriterion("checkMan <", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanLessThanOrEqualTo(Long value) {
            addCriterion("checkMan <=", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanIn(List<Long> values) {
            addCriterion("checkMan in", values, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanNotIn(List<Long> values) {
            addCriterion("checkMan not in", values, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanBetween(Long value1, Long value2) {
            addCriterion("checkMan between", value1, value2, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanNotBetween(Long value1, Long value2) {
            addCriterion("checkMan not between", value1, value2, "checkman");
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

        public Criteria andCheckinfoIsNull() {
            addCriterion("checkInfo is null");
            return (Criteria) this;
        }

        public Criteria andCheckinfoIsNotNull() {
            addCriterion("checkInfo is not null");
            return (Criteria) this;
        }

        public Criteria andCheckinfoEqualTo(String value) {
            addCriterion("checkInfo =", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoNotEqualTo(String value) {
            addCriterion("checkInfo <>", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoGreaterThan(String value) {
            addCriterion("checkInfo >", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoGreaterThanOrEqualTo(String value) {
            addCriterion("checkInfo >=", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoLessThan(String value) {
            addCriterion("checkInfo <", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoLessThanOrEqualTo(String value) {
            addCriterion("checkInfo <=", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoLike(String value) {
            addCriterion("checkInfo like", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoNotLike(String value) {
            addCriterion("checkInfo not like", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoIn(List<String> values) {
            addCriterion("checkInfo in", values, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoNotIn(List<String> values) {
            addCriterion("checkInfo not in", values, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoBetween(String value1, String value2) {
            addCriterion("checkInfo between", value1, value2, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoNotBetween(String value1, String value2) {
            addCriterion("checkInfo not between", value1, value2, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumIsNull() {
            addCriterion("bizLicRegNum is null");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumIsNotNull() {
            addCriterion("bizLicRegNum is not null");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumEqualTo(String value) {
            addCriterion("bizLicRegNum =", value, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumNotEqualTo(String value) {
            addCriterion("bizLicRegNum <>", value, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumGreaterThan(String value) {
            addCriterion("bizLicRegNum >", value, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumGreaterThanOrEqualTo(String value) {
            addCriterion("bizLicRegNum >=", value, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumLessThan(String value) {
            addCriterion("bizLicRegNum <", value, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumLessThanOrEqualTo(String value) {
            addCriterion("bizLicRegNum <=", value, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumLike(String value) {
            addCriterion("bizLicRegNum like", value, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumNotLike(String value) {
            addCriterion("bizLicRegNum not like", value, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumIn(List<String> values) {
            addCriterion("bizLicRegNum in", values, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumNotIn(List<String> values) {
            addCriterion("bizLicRegNum not in", values, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumBetween(String value1, String value2) {
            addCriterion("bizLicRegNum between", value1, value2, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicregnumNotBetween(String value1, String value2) {
            addCriterion("bizLicRegNum not between", value1, value2, "bizlicregnum");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateIsNull() {
            addCriterion("bizLicEndDate is null");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateIsNotNull() {
            addCriterion("bizLicEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateEqualTo(Date value) {
            addCriterionForJDBCDate("bizLicEndDate =", value, "bizlicenddate");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("bizLicEndDate <>", value, "bizlicenddate");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateGreaterThan(Date value) {
            addCriterionForJDBCDate("bizLicEndDate >", value, "bizlicenddate");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bizLicEndDate >=", value, "bizlicenddate");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateLessThan(Date value) {
            addCriterionForJDBCDate("bizLicEndDate <", value, "bizlicenddate");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bizLicEndDate <=", value, "bizlicenddate");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateIn(List<Date> values) {
            addCriterionForJDBCDate("bizLicEndDate in", values, "bizlicenddate");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("bizLicEndDate not in", values, "bizlicenddate");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bizLicEndDate between", value1, value2, "bizlicenddate");
            return (Criteria) this;
        }

        public Criteria andBizlicenddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bizLicEndDate not between", value1, value2, "bizlicenddate");
            return (Criteria) this;
        }

        public Criteria andBizlicdocIsNull() {
            addCriterion("bizLicDoc is null");
            return (Criteria) this;
        }

        public Criteria andBizlicdocIsNotNull() {
            addCriterion("bizLicDoc is not null");
            return (Criteria) this;
        }

        public Criteria andBizlicdocEqualTo(String value) {
            addCriterion("bizLicDoc =", value, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocNotEqualTo(String value) {
            addCriterion("bizLicDoc <>", value, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocGreaterThan(String value) {
            addCriterion("bizLicDoc >", value, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocGreaterThanOrEqualTo(String value) {
            addCriterion("bizLicDoc >=", value, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocLessThan(String value) {
            addCriterion("bizLicDoc <", value, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocLessThanOrEqualTo(String value) {
            addCriterion("bizLicDoc <=", value, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocLike(String value) {
            addCriterion("bizLicDoc like", value, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocNotLike(String value) {
            addCriterion("bizLicDoc not like", value, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocIn(List<String> values) {
            addCriterion("bizLicDoc in", values, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocNotIn(List<String> values) {
            addCriterion("bizLicDoc not in", values, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocBetween(String value1, String value2) {
            addCriterion("bizLicDoc between", value1, value2, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andBizlicdocNotBetween(String value1, String value2) {
            addCriterion("bizLicDoc not between", value1, value2, "bizlicdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregnumIsNull() {
            addCriterion("taxRegNum is null");
            return (Criteria) this;
        }

        public Criteria andTaxregnumIsNotNull() {
            addCriterion("taxRegNum is not null");
            return (Criteria) this;
        }

        public Criteria andTaxregnumEqualTo(String value) {
            addCriterion("taxRegNum =", value, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumNotEqualTo(String value) {
            addCriterion("taxRegNum <>", value, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumGreaterThan(String value) {
            addCriterion("taxRegNum >", value, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumGreaterThanOrEqualTo(String value) {
            addCriterion("taxRegNum >=", value, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumLessThan(String value) {
            addCriterion("taxRegNum <", value, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumLessThanOrEqualTo(String value) {
            addCriterion("taxRegNum <=", value, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumLike(String value) {
            addCriterion("taxRegNum like", value, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumNotLike(String value) {
            addCriterion("taxRegNum not like", value, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumIn(List<String> values) {
            addCriterion("taxRegNum in", values, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumNotIn(List<String> values) {
            addCriterion("taxRegNum not in", values, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumBetween(String value1, String value2) {
            addCriterion("taxRegNum between", value1, value2, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregnumNotBetween(String value1, String value2) {
            addCriterion("taxRegNum not between", value1, value2, "taxregnum");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateIsNull() {
            addCriterion("taxRegEndDate is null");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateIsNotNull() {
            addCriterion("taxRegEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateEqualTo(Date value) {
            addCriterionForJDBCDate("taxRegEndDate =", value, "taxregenddate");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("taxRegEndDate <>", value, "taxregenddate");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateGreaterThan(Date value) {
            addCriterionForJDBCDate("taxRegEndDate >", value, "taxregenddate");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("taxRegEndDate >=", value, "taxregenddate");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateLessThan(Date value) {
            addCriterionForJDBCDate("taxRegEndDate <", value, "taxregenddate");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("taxRegEndDate <=", value, "taxregenddate");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateIn(List<Date> values) {
            addCriterionForJDBCDate("taxRegEndDate in", values, "taxregenddate");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("taxRegEndDate not in", values, "taxregenddate");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("taxRegEndDate between", value1, value2, "taxregenddate");
            return (Criteria) this;
        }

        public Criteria andTaxregenddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("taxRegEndDate not between", value1, value2, "taxregenddate");
            return (Criteria) this;
        }

        public Criteria andTaxregdocIsNull() {
            addCriterion("taxRegDoc is null");
            return (Criteria) this;
        }

        public Criteria andTaxregdocIsNotNull() {
            addCriterion("taxRegDoc is not null");
            return (Criteria) this;
        }

        public Criteria andTaxregdocEqualTo(String value) {
            addCriterion("taxRegDoc =", value, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocNotEqualTo(String value) {
            addCriterion("taxRegDoc <>", value, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocGreaterThan(String value) {
            addCriterion("taxRegDoc >", value, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocGreaterThanOrEqualTo(String value) {
            addCriterion("taxRegDoc >=", value, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocLessThan(String value) {
            addCriterion("taxRegDoc <", value, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocLessThanOrEqualTo(String value) {
            addCriterion("taxRegDoc <=", value, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocLike(String value) {
            addCriterion("taxRegDoc like", value, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocNotLike(String value) {
            addCriterion("taxRegDoc not like", value, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocIn(List<String> values) {
            addCriterion("taxRegDoc in", values, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocNotIn(List<String> values) {
            addCriterion("taxRegDoc not in", values, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocBetween(String value1, String value2) {
            addCriterion("taxRegDoc between", value1, value2, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andTaxregdocNotBetween(String value1, String value2) {
            addCriterion("taxRegDoc not between", value1, value2, "taxregdoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNull() {
            addCriterion("orgCode is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNotNull() {
            addCriterion("orgCode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeEqualTo(String value) {
            addCriterion("orgCode =", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotEqualTo(String value) {
            addCriterion("orgCode <>", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThan(String value) {
            addCriterion("orgCode >", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("orgCode >=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThan(String value) {
            addCriterion("orgCode <", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("orgCode <=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLike(String value) {
            addCriterion("orgCode like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotLike(String value) {
            addCriterion("orgCode not like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIn(List<String> values) {
            addCriterion("orgCode in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotIn(List<String> values) {
            addCriterion("orgCode not in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeBetween(String value1, String value2) {
            addCriterion("orgCode between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotBetween(String value1, String value2) {
            addCriterion("orgCode not between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateIsNull() {
            addCriterion("orgCodeEndDate is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateIsNotNull() {
            addCriterion("orgCodeEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateEqualTo(Date value) {
            addCriterionForJDBCDate("orgCodeEndDate =", value, "orgcodeenddate");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("orgCodeEndDate <>", value, "orgcodeenddate");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateGreaterThan(Date value) {
            addCriterionForJDBCDate("orgCodeEndDate >", value, "orgcodeenddate");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("orgCodeEndDate >=", value, "orgcodeenddate");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateLessThan(Date value) {
            addCriterionForJDBCDate("orgCodeEndDate <", value, "orgcodeenddate");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("orgCodeEndDate <=", value, "orgcodeenddate");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateIn(List<Date> values) {
            addCriterionForJDBCDate("orgCodeEndDate in", values, "orgcodeenddate");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("orgCodeEndDate not in", values, "orgcodeenddate");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("orgCodeEndDate between", value1, value2, "orgcodeenddate");
            return (Criteria) this;
        }

        public Criteria andOrgcodeenddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("orgCodeEndDate not between", value1, value2, "orgcodeenddate");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocIsNull() {
            addCriterion("orgCodeDoc is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocIsNotNull() {
            addCriterion("orgCodeDoc is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocEqualTo(String value) {
            addCriterion("orgCodeDoc =", value, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocNotEqualTo(String value) {
            addCriterion("orgCodeDoc <>", value, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocGreaterThan(String value) {
            addCriterion("orgCodeDoc >", value, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocGreaterThanOrEqualTo(String value) {
            addCriterion("orgCodeDoc >=", value, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocLessThan(String value) {
            addCriterion("orgCodeDoc <", value, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocLessThanOrEqualTo(String value) {
            addCriterion("orgCodeDoc <=", value, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocLike(String value) {
            addCriterion("orgCodeDoc like", value, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocNotLike(String value) {
            addCriterion("orgCodeDoc not like", value, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocIn(List<String> values) {
            addCriterion("orgCodeDoc in", values, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocNotIn(List<String> values) {
            addCriterion("orgCodeDoc not in", values, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocBetween(String value1, String value2) {
            addCriterion("orgCodeDoc between", value1, value2, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andOrgcodedocNotBetween(String value1, String value2) {
            addCriterion("orgCodeDoc not between", value1, value2, "orgcodedoc");
            return (Criteria) this;
        }

        public Criteria andIsaliveIsNull() {
            addCriterion("isAlive is null");
            return (Criteria) this;
        }

        public Criteria andIsaliveIsNotNull() {
            addCriterion("isAlive is not null");
            return (Criteria) this;
        }

        public Criteria andIsaliveEqualTo(Integer value) {
            addCriterion("isAlive =", value, "isalive");
            return (Criteria) this;
        }

        public Criteria andIsaliveNotEqualTo(Integer value) {
            addCriterion("isAlive <>", value, "isalive");
            return (Criteria) this;
        }

        public Criteria andIsaliveGreaterThan(Integer value) {
            addCriterion("isAlive >", value, "isalive");
            return (Criteria) this;
        }

        public Criteria andIsaliveGreaterThanOrEqualTo(Integer value) {
            addCriterion("isAlive >=", value, "isalive");
            return (Criteria) this;
        }

        public Criteria andIsaliveLessThan(Integer value) {
            addCriterion("isAlive <", value, "isalive");
            return (Criteria) this;
        }

        public Criteria andIsaliveLessThanOrEqualTo(Integer value) {
            addCriterion("isAlive <=", value, "isalive");
            return (Criteria) this;
        }

        public Criteria andIsaliveIn(List<Integer> values) {
            addCriterion("isAlive in", values, "isalive");
            return (Criteria) this;
        }

        public Criteria andIsaliveNotIn(List<Integer> values) {
            addCriterion("isAlive not in", values, "isalive");
            return (Criteria) this;
        }

        public Criteria andIsaliveBetween(Integer value1, Integer value2) {
            addCriterion("isAlive between", value1, value2, "isalive");
            return (Criteria) this;
        }

        public Criteria andIsaliveNotBetween(Integer value1, Integer value2) {
            addCriterion("isAlive not between", value1, value2, "isalive");
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

        public Criteria andIsnormalEqualTo(Integer value) {
            addCriterion("isNormal =", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalNotEqualTo(Integer value) {
            addCriterion("isNormal <>", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalGreaterThan(Integer value) {
            addCriterion("isNormal >", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalGreaterThanOrEqualTo(Integer value) {
            addCriterion("isNormal >=", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalLessThan(Integer value) {
            addCriterion("isNormal <", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalLessThanOrEqualTo(Integer value) {
            addCriterion("isNormal <=", value, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalIn(List<Integer> values) {
            addCriterion("isNormal in", values, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalNotIn(List<Integer> values) {
            addCriterion("isNormal not in", values, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalBetween(Integer value1, Integer value2) {
            addCriterion("isNormal between", value1, value2, "isnormal");
            return (Criteria) this;
        }

        public Criteria andIsnormalNotBetween(Integer value1, Integer value2) {
            addCriterion("isNormal not between", value1, value2, "isnormal");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNull() {
            addCriterion("companyName is null");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNotNull() {
            addCriterion("companyName is not null");
            return (Criteria) this;
        }

        public Criteria andCompanynameEqualTo(String value) {
            addCriterion("companyName =", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotEqualTo(String value) {
            addCriterion("companyName <>", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThan(String value) {
            addCriterion("companyName >", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThanOrEqualTo(String value) {
            addCriterion("companyName >=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThan(String value) {
            addCriterion("companyName <", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThanOrEqualTo(String value) {
            addCriterion("companyName <=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLike(String value) {
            addCriterion("companyName like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotLike(String value) {
            addCriterion("companyName not like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameIn(List<String> values) {
            addCriterion("companyName in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotIn(List<String> values) {
            addCriterion("companyName not in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameBetween(String value1, String value2) {
            addCriterion("companyName between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotBetween(String value1, String value2) {
            addCriterion("companyName not between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andShortnameIsNull() {
            addCriterion("shortName is null");
            return (Criteria) this;
        }

        public Criteria andShortnameIsNotNull() {
            addCriterion("shortName is not null");
            return (Criteria) this;
        }

        public Criteria andShortnameEqualTo(String value) {
            addCriterion("shortName =", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotEqualTo(String value) {
            addCriterion("shortName <>", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameGreaterThan(String value) {
            addCriterion("shortName >", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameGreaterThanOrEqualTo(String value) {
            addCriterion("shortName >=", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLessThan(String value) {
            addCriterion("shortName <", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLessThanOrEqualTo(String value) {
            addCriterion("shortName <=", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLike(String value) {
            addCriterion("shortName like", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotLike(String value) {
            addCriterion("shortName not like", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameIn(List<String> values) {
            addCriterion("shortName in", values, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotIn(List<String> values) {
            addCriterion("shortName not in", values, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameBetween(String value1, String value2) {
            addCriterion("shortName between", value1, value2, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotBetween(String value1, String value2) {
            addCriterion("shortName not between", value1, value2, "shortname");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andRegfundIsNull() {
            addCriterion("regfund is null");
            return (Criteria) this;
        }

        public Criteria andRegfundIsNotNull() {
            addCriterion("regfund is not null");
            return (Criteria) this;
        }

        public Criteria andRegfundEqualTo(Long value) {
            addCriterion("regfund =", value, "regfund");
            return (Criteria) this;
        }

        public Criteria andRegfundNotEqualTo(Long value) {
            addCriterion("regfund <>", value, "regfund");
            return (Criteria) this;
        }

        public Criteria andRegfundGreaterThan(Long value) {
            addCriterion("regfund >", value, "regfund");
            return (Criteria) this;
        }

        public Criteria andRegfundGreaterThanOrEqualTo(Long value) {
            addCriterion("regfund >=", value, "regfund");
            return (Criteria) this;
        }

        public Criteria andRegfundLessThan(Long value) {
            addCriterion("regfund <", value, "regfund");
            return (Criteria) this;
        }

        public Criteria andRegfundLessThanOrEqualTo(Long value) {
            addCriterion("regfund <=", value, "regfund");
            return (Criteria) this;
        }

        public Criteria andRegfundIn(List<Long> values) {
            addCriterion("regfund in", values, "regfund");
            return (Criteria) this;
        }

        public Criteria andRegfundNotIn(List<Long> values) {
            addCriterion("regfund not in", values, "regfund");
            return (Criteria) this;
        }

        public Criteria andRegfundBetween(Long value1, Long value2) {
            addCriterion("regfund between", value1, value2, "regfund");
            return (Criteria) this;
        }

        public Criteria andRegfundNotBetween(Long value1, Long value2) {
            addCriterion("regfund not between", value1, value2, "regfund");
            return (Criteria) this;
        }

        public Criteria andLawpersonIsNull() {
            addCriterion("lawPerson is null");
            return (Criteria) this;
        }

        public Criteria andLawpersonIsNotNull() {
            addCriterion("lawPerson is not null");
            return (Criteria) this;
        }

        public Criteria andLawpersonEqualTo(String value) {
            addCriterion("lawPerson =", value, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonNotEqualTo(String value) {
            addCriterion("lawPerson <>", value, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonGreaterThan(String value) {
            addCriterion("lawPerson >", value, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonGreaterThanOrEqualTo(String value) {
            addCriterion("lawPerson >=", value, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonLessThan(String value) {
            addCriterion("lawPerson <", value, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonLessThanOrEqualTo(String value) {
            addCriterion("lawPerson <=", value, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonLike(String value) {
            addCriterion("lawPerson like", value, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonNotLike(String value) {
            addCriterion("lawPerson not like", value, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonIn(List<String> values) {
            addCriterion("lawPerson in", values, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonNotIn(List<String> values) {
            addCriterion("lawPerson not in", values, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonBetween(String value1, String value2) {
            addCriterion("lawPerson between", value1, value2, "lawperson");
            return (Criteria) this;
        }

        public Criteria andLawpersonNotBetween(String value1, String value2) {
            addCriterion("lawPerson not between", value1, value2, "lawperson");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idCard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idCard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idCard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idCard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idCard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idCard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idCard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idCard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idCard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idCard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idCard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idCard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idCard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idCard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNull() {
            addCriterion("startDate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startDate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(Date value) {
            addCriterionForJDBCDate("startDate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("startDate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(Date value) {
            addCriterionForJDBCDate("startDate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("startDate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(Date value) {
            addCriterionForJDBCDate("startDate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("startDate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<Date> values) {
            addCriterionForJDBCDate("startDate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("startDate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("startDate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("startDate not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andCallnumIsNull() {
            addCriterion("callNum is null");
            return (Criteria) this;
        }

        public Criteria andCallnumIsNotNull() {
            addCriterion("callNum is not null");
            return (Criteria) this;
        }

        public Criteria andCallnumEqualTo(String value) {
            addCriterion("callNum =", value, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumNotEqualTo(String value) {
            addCriterion("callNum <>", value, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumGreaterThan(String value) {
            addCriterion("callNum >", value, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumGreaterThanOrEqualTo(String value) {
            addCriterion("callNum >=", value, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumLessThan(String value) {
            addCriterion("callNum <", value, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumLessThanOrEqualTo(String value) {
            addCriterion("callNum <=", value, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumLike(String value) {
            addCriterion("callNum like", value, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumNotLike(String value) {
            addCriterion("callNum not like", value, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumIn(List<String> values) {
            addCriterion("callNum in", values, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumNotIn(List<String> values) {
            addCriterion("callNum not in", values, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumBetween(String value1, String value2) {
            addCriterion("callNum between", value1, value2, "callnum");
            return (Criteria) this;
        }

        public Criteria andCallnumNotBetween(String value1, String value2) {
            addCriterion("callNum not between", value1, value2, "callnum");
            return (Criteria) this;
        }

        public Criteria andCompanyemailIsNull() {
            addCriterion("companyEmail is null");
            return (Criteria) this;
        }

        public Criteria andCompanyemailIsNotNull() {
            addCriterion("companyEmail is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyemailEqualTo(String value) {
            addCriterion("companyEmail =", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailNotEqualTo(String value) {
            addCriterion("companyEmail <>", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailGreaterThan(String value) {
            addCriterion("companyEmail >", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailGreaterThanOrEqualTo(String value) {
            addCriterion("companyEmail >=", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailLessThan(String value) {
            addCriterion("companyEmail <", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailLessThanOrEqualTo(String value) {
            addCriterion("companyEmail <=", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailLike(String value) {
            addCriterion("companyEmail like", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailNotLike(String value) {
            addCriterion("companyEmail not like", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailIn(List<String> values) {
            addCriterion("companyEmail in", values, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailNotIn(List<String> values) {
            addCriterion("companyEmail not in", values, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailBetween(String value1, String value2) {
            addCriterion("companyEmail between", value1, value2, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailNotBetween(String value1, String value2) {
            addCriterion("companyEmail not between", value1, value2, "companyemail");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeid is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeid is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Integer value) {
            addCriterion("typeid =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Integer value) {
            addCriterion("typeid <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Integer value) {
            addCriterion("typeid >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeid >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Integer value) {
            addCriterion("typeid <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("typeid <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Integer> values) {
            addCriterion("typeid in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Integer> values) {
            addCriterion("typeid not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Integer value1, Integer value2) {
            addCriterion("typeid between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("typeid not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andEmpnumsIsNull() {
            addCriterion("empNums is null");
            return (Criteria) this;
        }

        public Criteria andEmpnumsIsNotNull() {
            addCriterion("empNums is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnumsEqualTo(Integer value) {
            addCriterion("empNums =", value, "empnums");
            return (Criteria) this;
        }

        public Criteria andEmpnumsNotEqualTo(Integer value) {
            addCriterion("empNums <>", value, "empnums");
            return (Criteria) this;
        }

        public Criteria andEmpnumsGreaterThan(Integer value) {
            addCriterion("empNums >", value, "empnums");
            return (Criteria) this;
        }

        public Criteria andEmpnumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("empNums >=", value, "empnums");
            return (Criteria) this;
        }

        public Criteria andEmpnumsLessThan(Integer value) {
            addCriterion("empNums <", value, "empnums");
            return (Criteria) this;
        }

        public Criteria andEmpnumsLessThanOrEqualTo(Integer value) {
            addCriterion("empNums <=", value, "empnums");
            return (Criteria) this;
        }

        public Criteria andEmpnumsIn(List<Integer> values) {
            addCriterion("empNums in", values, "empnums");
            return (Criteria) this;
        }

        public Criteria andEmpnumsNotIn(List<Integer> values) {
            addCriterion("empNums not in", values, "empnums");
            return (Criteria) this;
        }

        public Criteria andEmpnumsBetween(Integer value1, Integer value2) {
            addCriterion("empNums between", value1, value2, "empnums");
            return (Criteria) this;
        }

        public Criteria andEmpnumsNotBetween(Integer value1, Integer value2) {
            addCriterion("empNums not between", value1, value2, "empnums");
            return (Criteria) this;
        }

        public Criteria andFrameIsNull() {
            addCriterion("frame is null");
            return (Criteria) this;
        }

        public Criteria andFrameIsNotNull() {
            addCriterion("frame is not null");
            return (Criteria) this;
        }

        public Criteria andFrameEqualTo(String value) {
            addCriterion("frame =", value, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameNotEqualTo(String value) {
            addCriterion("frame <>", value, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameGreaterThan(String value) {
            addCriterion("frame >", value, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameGreaterThanOrEqualTo(String value) {
            addCriterion("frame >=", value, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameLessThan(String value) {
            addCriterion("frame <", value, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameLessThanOrEqualTo(String value) {
            addCriterion("frame <=", value, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameLike(String value) {
            addCriterion("frame like", value, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameNotLike(String value) {
            addCriterion("frame not like", value, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameIn(List<String> values) {
            addCriterion("frame in", values, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameNotIn(List<String> values) {
            addCriterion("frame not in", values, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameBetween(String value1, String value2) {
            addCriterion("frame between", value1, value2, "frame");
            return (Criteria) this;
        }

        public Criteria andFrameNotBetween(String value1, String value2) {
            addCriterion("frame not between", value1, value2, "frame");
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