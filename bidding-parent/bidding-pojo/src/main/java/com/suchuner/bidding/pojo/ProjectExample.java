package com.suchuner.bidding.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andProjectnumIsNull() {
            addCriterion("projectNum is null");
            return (Criteria) this;
        }

        public Criteria andProjectnumIsNotNull() {
            addCriterion("projectNum is not null");
            return (Criteria) this;
        }

        public Criteria andProjectnumEqualTo(String value) {
            addCriterion("projectNum =", value, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumNotEqualTo(String value) {
            addCriterion("projectNum <>", value, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumGreaterThan(String value) {
            addCriterion("projectNum >", value, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumGreaterThanOrEqualTo(String value) {
            addCriterion("projectNum >=", value, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumLessThan(String value) {
            addCriterion("projectNum <", value, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumLessThanOrEqualTo(String value) {
            addCriterion("projectNum <=", value, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumLike(String value) {
            addCriterion("projectNum like", value, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumNotLike(String value) {
            addCriterion("projectNum not like", value, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumIn(List<String> values) {
            addCriterion("projectNum in", values, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumNotIn(List<String> values) {
            addCriterion("projectNum not in", values, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumBetween(String value1, String value2) {
            addCriterion("projectNum between", value1, value2, "projectnum");
            return (Criteria) this;
        }

        public Criteria andProjectnumNotBetween(String value1, String value2) {
            addCriterion("projectNum not between", value1, value2, "projectnum");
            return (Criteria) this;
        }

        public Criteria andItemnameIsNull() {
            addCriterion("itemName is null");
            return (Criteria) this;
        }

        public Criteria andItemnameIsNotNull() {
            addCriterion("itemName is not null");
            return (Criteria) this;
        }

        public Criteria andItemnameEqualTo(String value) {
            addCriterion("itemName =", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotEqualTo(String value) {
            addCriterion("itemName <>", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThan(String value) {
            addCriterion("itemName >", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThanOrEqualTo(String value) {
            addCriterion("itemName >=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThan(String value) {
            addCriterion("itemName <", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThanOrEqualTo(String value) {
            addCriterion("itemName <=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLike(String value) {
            addCriterion("itemName like", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotLike(String value) {
            addCriterion("itemName not like", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameIn(List<String> values) {
            addCriterion("itemName in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotIn(List<String> values) {
            addCriterion("itemName not in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameBetween(String value1, String value2) {
            addCriterion("itemName between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotBetween(String value1, String value2) {
            addCriterion("itemName not between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNull() {
            addCriterion("budget is null");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNotNull() {
            addCriterion("budget is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetEqualTo(Long value) {
            addCriterion("budget =", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotEqualTo(Long value) {
            addCriterion("budget <>", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThan(Long value) {
            addCriterion("budget >", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThanOrEqualTo(Long value) {
            addCriterion("budget >=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThan(Long value) {
            addCriterion("budget <", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThanOrEqualTo(Long value) {
            addCriterion("budget <=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetIn(List<Long> values) {
            addCriterion("budget in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotIn(List<Long> values) {
            addCriterion("budget not in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetBetween(Long value1, Long value2) {
            addCriterion("budget between", value1, value2, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotBetween(Long value1, Long value2) {
            addCriterion("budget not between", value1, value2, "budget");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andNoticeIsNull() {
            addCriterion("notice is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIsNotNull() {
            addCriterion("notice is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeEqualTo(String value) {
            addCriterion("notice =", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotEqualTo(String value) {
            addCriterion("notice <>", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeGreaterThan(String value) {
            addCriterion("notice >", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("notice >=", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLessThan(String value) {
            addCriterion("notice <", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLessThanOrEqualTo(String value) {
            addCriterion("notice <=", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLike(String value) {
            addCriterion("notice like", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotLike(String value) {
            addCriterion("notice not like", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeIn(List<String> values) {
            addCriterion("notice in", values, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotIn(List<String> values) {
            addCriterion("notice not in", values, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeBetween(String value1, String value2) {
            addCriterion("notice between", value1, value2, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotBetween(String value1, String value2) {
            addCriterion("notice not between", value1, value2, "notice");
            return (Criteria) this;
        }

        public Criteria andBiddingdocIsNull() {
            addCriterion("biddingDoc is null");
            return (Criteria) this;
        }

        public Criteria andBiddingdocIsNotNull() {
            addCriterion("biddingDoc is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingdocEqualTo(String value) {
            addCriterion("biddingDoc =", value, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocNotEqualTo(String value) {
            addCriterion("biddingDoc <>", value, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocGreaterThan(String value) {
            addCriterion("biddingDoc >", value, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocGreaterThanOrEqualTo(String value) {
            addCriterion("biddingDoc >=", value, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocLessThan(String value) {
            addCriterion("biddingDoc <", value, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocLessThanOrEqualTo(String value) {
            addCriterion("biddingDoc <=", value, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocLike(String value) {
            addCriterion("biddingDoc like", value, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocNotLike(String value) {
            addCriterion("biddingDoc not like", value, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocIn(List<String> values) {
            addCriterion("biddingDoc in", values, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocNotIn(List<String> values) {
            addCriterion("biddingDoc not in", values, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocBetween(String value1, String value2) {
            addCriterion("biddingDoc between", value1, value2, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingdocNotBetween(String value1, String value2) {
            addCriterion("biddingDoc not between", value1, value2, "biddingdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocIsNull() {
            addCriterion("buyListAndReqDoc is null");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocIsNotNull() {
            addCriterion("buyListAndReqDoc is not null");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocEqualTo(String value) {
            addCriterion("buyListAndReqDoc =", value, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocNotEqualTo(String value) {
            addCriterion("buyListAndReqDoc <>", value, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocGreaterThan(String value) {
            addCriterion("buyListAndReqDoc >", value, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocGreaterThanOrEqualTo(String value) {
            addCriterion("buyListAndReqDoc >=", value, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocLessThan(String value) {
            addCriterion("buyListAndReqDoc <", value, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocLessThanOrEqualTo(String value) {
            addCriterion("buyListAndReqDoc <=", value, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocLike(String value) {
            addCriterion("buyListAndReqDoc like", value, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocNotLike(String value) {
            addCriterion("buyListAndReqDoc not like", value, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocIn(List<String> values) {
            addCriterion("buyListAndReqDoc in", values, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocNotIn(List<String> values) {
            addCriterion("buyListAndReqDoc not in", values, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocBetween(String value1, String value2) {
            addCriterion("buyListAndReqDoc between", value1, value2, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBuylistandreqdocNotBetween(String value1, String value2) {
            addCriterion("buyListAndReqDoc not between", value1, value2, "buylistandreqdoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocIsNull() {
            addCriterion("biddingRequireDoc is null");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocIsNotNull() {
            addCriterion("biddingRequireDoc is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocEqualTo(String value) {
            addCriterion("biddingRequireDoc =", value, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocNotEqualTo(String value) {
            addCriterion("biddingRequireDoc <>", value, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocGreaterThan(String value) {
            addCriterion("biddingRequireDoc >", value, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocGreaterThanOrEqualTo(String value) {
            addCriterion("biddingRequireDoc >=", value, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocLessThan(String value) {
            addCriterion("biddingRequireDoc <", value, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocLessThanOrEqualTo(String value) {
            addCriterion("biddingRequireDoc <=", value, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocLike(String value) {
            addCriterion("biddingRequireDoc like", value, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocNotLike(String value) {
            addCriterion("biddingRequireDoc not like", value, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocIn(List<String> values) {
            addCriterion("biddingRequireDoc in", values, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocNotIn(List<String> values) {
            addCriterion("biddingRequireDoc not in", values, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocBetween(String value1, String value2) {
            addCriterion("biddingRequireDoc between", value1, value2, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andBiddingrequiredocNotBetween(String value1, String value2) {
            addCriterion("biddingRequireDoc not between", value1, value2, "biddingrequiredoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocIsNull() {
            addCriterion("otherDoc is null");
            return (Criteria) this;
        }

        public Criteria andOtherdocIsNotNull() {
            addCriterion("otherDoc is not null");
            return (Criteria) this;
        }

        public Criteria andOtherdocEqualTo(String value) {
            addCriterion("otherDoc =", value, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocNotEqualTo(String value) {
            addCriterion("otherDoc <>", value, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocGreaterThan(String value) {
            addCriterion("otherDoc >", value, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocGreaterThanOrEqualTo(String value) {
            addCriterion("otherDoc >=", value, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocLessThan(String value) {
            addCriterion("otherDoc <", value, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocLessThanOrEqualTo(String value) {
            addCriterion("otherDoc <=", value, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocLike(String value) {
            addCriterion("otherDoc like", value, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocNotLike(String value) {
            addCriterion("otherDoc not like", value, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocIn(List<String> values) {
            addCriterion("otherDoc in", values, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocNotIn(List<String> values) {
            addCriterion("otherDoc not in", values, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocBetween(String value1, String value2) {
            addCriterion("otherDoc between", value1, value2, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andOtherdocNotBetween(String value1, String value2) {
            addCriterion("otherDoc not between", value1, value2, "otherdoc");
            return (Criteria) this;
        }

        public Criteria andStarterIsNull() {
            addCriterion("starter is null");
            return (Criteria) this;
        }

        public Criteria andStarterIsNotNull() {
            addCriterion("starter is not null");
            return (Criteria) this;
        }

        public Criteria andStarterEqualTo(Long value) {
            addCriterion("starter =", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterNotEqualTo(Long value) {
            addCriterion("starter <>", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterGreaterThan(Long value) {
            addCriterion("starter >", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterGreaterThanOrEqualTo(Long value) {
            addCriterion("starter >=", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterLessThan(Long value) {
            addCriterion("starter <", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterLessThanOrEqualTo(Long value) {
            addCriterion("starter <=", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterIn(List<Long> values) {
            addCriterion("starter in", values, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterNotIn(List<Long> values) {
            addCriterion("starter not in", values, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterBetween(Long value1, Long value2) {
            addCriterion("starter between", value1, value2, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterNotBetween(Long value1, Long value2) {
            addCriterion("starter not between", value1, value2, "starter");
            return (Criteria) this;
        }

        public Criteria andCheckerIsNull() {
            addCriterion("checker is null");
            return (Criteria) this;
        }

        public Criteria andCheckerIsNotNull() {
            addCriterion("checker is not null");
            return (Criteria) this;
        }

        public Criteria andCheckerEqualTo(Long value) {
            addCriterion("checker =", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotEqualTo(Long value) {
            addCriterion("checker <>", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerGreaterThan(Long value) {
            addCriterion("checker >", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerGreaterThanOrEqualTo(Long value) {
            addCriterion("checker >=", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerLessThan(Long value) {
            addCriterion("checker <", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerLessThanOrEqualTo(Long value) {
            addCriterion("checker <=", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerIn(List<Long> values) {
            addCriterion("checker in", values, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotIn(List<Long> values) {
            addCriterion("checker not in", values, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerBetween(Long value1, Long value2) {
            addCriterion("checker between", value1, value2, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotBetween(Long value1, Long value2) {
            addCriterion("checker not between", value1, value2, "checker");
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

        public Criteria andCheckerdateIsNull() {
            addCriterion("checkerDate is null");
            return (Criteria) this;
        }

        public Criteria andCheckerdateIsNotNull() {
            addCriterion("checkerDate is not null");
            return (Criteria) this;
        }

        public Criteria andCheckerdateEqualTo(Date value) {
            addCriterionForJDBCDate("checkerDate =", value, "checkerdate");
            return (Criteria) this;
        }

        public Criteria andCheckerdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("checkerDate <>", value, "checkerdate");
            return (Criteria) this;
        }

        public Criteria andCheckerdateGreaterThan(Date value) {
            addCriterionForJDBCDate("checkerDate >", value, "checkerdate");
            return (Criteria) this;
        }

        public Criteria andCheckerdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("checkerDate >=", value, "checkerdate");
            return (Criteria) this;
        }

        public Criteria andCheckerdateLessThan(Date value) {
            addCriterionForJDBCDate("checkerDate <", value, "checkerdate");
            return (Criteria) this;
        }

        public Criteria andCheckerdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("checkerDate <=", value, "checkerdate");
            return (Criteria) this;
        }

        public Criteria andCheckerdateIn(List<Date> values) {
            addCriterionForJDBCDate("checkerDate in", values, "checkerdate");
            return (Criteria) this;
        }

        public Criteria andCheckerdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("checkerDate not in", values, "checkerdate");
            return (Criteria) this;
        }

        public Criteria andCheckerdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("checkerDate between", value1, value2, "checkerdate");
            return (Criteria) this;
        }

        public Criteria andCheckerdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("checkerDate not between", value1, value2, "checkerdate");
            return (Criteria) this;
        }

        public Criteria andDatelineIsNull() {
            addCriterion("dateline is null");
            return (Criteria) this;
        }

        public Criteria andDatelineIsNotNull() {
            addCriterion("dateline is not null");
            return (Criteria) this;
        }

        public Criteria andDatelineEqualTo(Date value) {
            addCriterionForJDBCDate("dateline =", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineNotEqualTo(Date value) {
            addCriterionForJDBCDate("dateline <>", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineGreaterThan(Date value) {
            addCriterionForJDBCDate("dateline >", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dateline >=", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineLessThan(Date value) {
            addCriterionForJDBCDate("dateline <", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dateline <=", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineIn(List<Date> values) {
            addCriterionForJDBCDate("dateline in", values, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineNotIn(List<Date> values) {
            addCriterionForJDBCDate("dateline not in", values, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dateline between", value1, value2, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dateline not between", value1, value2, "dateline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andJudgenumsIsNull() {
            addCriterion("judgeNums is null");
            return (Criteria) this;
        }

        public Criteria andJudgenumsIsNotNull() {
            addCriterion("judgeNums is not null");
            return (Criteria) this;
        }

        public Criteria andJudgenumsEqualTo(Integer value) {
            addCriterion("judgeNums =", value, "judgenums");
            return (Criteria) this;
        }

        public Criteria andJudgenumsNotEqualTo(Integer value) {
            addCriterion("judgeNums <>", value, "judgenums");
            return (Criteria) this;
        }

        public Criteria andJudgenumsGreaterThan(Integer value) {
            addCriterion("judgeNums >", value, "judgenums");
            return (Criteria) this;
        }

        public Criteria andJudgenumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("judgeNums >=", value, "judgenums");
            return (Criteria) this;
        }

        public Criteria andJudgenumsLessThan(Integer value) {
            addCriterion("judgeNums <", value, "judgenums");
            return (Criteria) this;
        }

        public Criteria andJudgenumsLessThanOrEqualTo(Integer value) {
            addCriterion("judgeNums <=", value, "judgenums");
            return (Criteria) this;
        }

        public Criteria andJudgenumsIn(List<Integer> values) {
            addCriterion("judgeNums in", values, "judgenums");
            return (Criteria) this;
        }

        public Criteria andJudgenumsNotIn(List<Integer> values) {
            addCriterion("judgeNums not in", values, "judgenums");
            return (Criteria) this;
        }

        public Criteria andJudgenumsBetween(Integer value1, Integer value2) {
            addCriterion("judgeNums between", value1, value2, "judgenums");
            return (Criteria) this;
        }

        public Criteria andJudgenumsNotBetween(Integer value1, Integer value2) {
            addCriterion("judgeNums not between", value1, value2, "judgenums");
            return (Criteria) this;
        }

        public Criteria andWinnerIsNull() {
            addCriterion("winner is null");
            return (Criteria) this;
        }

        public Criteria andWinnerIsNotNull() {
            addCriterion("winner is not null");
            return (Criteria) this;
        }

        public Criteria andWinnerEqualTo(Long value) {
            addCriterion("winner =", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerNotEqualTo(Long value) {
            addCriterion("winner <>", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerGreaterThan(Long value) {
            addCriterion("winner >", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerGreaterThanOrEqualTo(Long value) {
            addCriterion("winner >=", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerLessThan(Long value) {
            addCriterion("winner <", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerLessThanOrEqualTo(Long value) {
            addCriterion("winner <=", value, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerIn(List<Long> values) {
            addCriterion("winner in", values, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerNotIn(List<Long> values) {
            addCriterion("winner not in", values, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerBetween(Long value1, Long value2) {
            addCriterion("winner between", value1, value2, "winner");
            return (Criteria) this;
        }

        public Criteria andWinnerNotBetween(Long value1, Long value2) {
            addCriterion("winner not between", value1, value2, "winner");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterionForJDBCDate("endDate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("endDate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterionForJDBCDate("endDate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endDate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterionForJDBCDate("endDate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endDate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterionForJDBCDate("endDate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("endDate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endDate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endDate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Long value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Long value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Long value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Long value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Long value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Long value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Long> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Long> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Long value1, Long value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Long value1, Long value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andIsbeginIsNull() {
            addCriterion("isBegin is null");
            return (Criteria) this;
        }

        public Criteria andIsbeginIsNotNull() {
            addCriterion("isBegin is not null");
            return (Criteria) this;
        }

        public Criteria andIsbeginEqualTo(Byte value) {
            addCriterion("isBegin =", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginNotEqualTo(Byte value) {
            addCriterion("isBegin <>", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginGreaterThan(Byte value) {
            addCriterion("isBegin >", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginGreaterThanOrEqualTo(Byte value) {
            addCriterion("isBegin >=", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginLessThan(Byte value) {
            addCriterion("isBegin <", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginLessThanOrEqualTo(Byte value) {
            addCriterion("isBegin <=", value, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginIn(List<Byte> values) {
            addCriterion("isBegin in", values, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginNotIn(List<Byte> values) {
            addCriterion("isBegin not in", values, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginBetween(Byte value1, Byte value2) {
            addCriterion("isBegin between", value1, value2, "isbegin");
            return (Criteria) this;
        }

        public Criteria andIsbeginNotBetween(Byte value1, Byte value2) {
            addCriterion("isBegin not between", value1, value2, "isbegin");
            return (Criteria) this;
        }

        public Criteria andReportdocIsNull() {
            addCriterion("reportDoc is null");
            return (Criteria) this;
        }

        public Criteria andReportdocIsNotNull() {
            addCriterion("reportDoc is not null");
            return (Criteria) this;
        }

        public Criteria andReportdocEqualTo(String value) {
            addCriterion("reportDoc =", value, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocNotEqualTo(String value) {
            addCriterion("reportDoc <>", value, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocGreaterThan(String value) {
            addCriterion("reportDoc >", value, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocGreaterThanOrEqualTo(String value) {
            addCriterion("reportDoc >=", value, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocLessThan(String value) {
            addCriterion("reportDoc <", value, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocLessThanOrEqualTo(String value) {
            addCriterion("reportDoc <=", value, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocLike(String value) {
            addCriterion("reportDoc like", value, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocNotLike(String value) {
            addCriterion("reportDoc not like", value, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocIn(List<String> values) {
            addCriterion("reportDoc in", values, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocNotIn(List<String> values) {
            addCriterion("reportDoc not in", values, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocBetween(String value1, String value2) {
            addCriterion("reportDoc between", value1, value2, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andReportdocNotBetween(String value1, String value2) {
            addCriterion("reportDoc not between", value1, value2, "reportdoc");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingIsNull() {
            addCriterion("isRebidding is null");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingIsNotNull() {
            addCriterion("isRebidding is not null");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingEqualTo(Byte value) {
            addCriterion("isRebidding =", value, "isrebidding");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingNotEqualTo(Byte value) {
            addCriterion("isRebidding <>", value, "isrebidding");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingGreaterThan(Byte value) {
            addCriterion("isRebidding >", value, "isrebidding");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingGreaterThanOrEqualTo(Byte value) {
            addCriterion("isRebidding >=", value, "isrebidding");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingLessThan(Byte value) {
            addCriterion("isRebidding <", value, "isrebidding");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingLessThanOrEqualTo(Byte value) {
            addCriterion("isRebidding <=", value, "isrebidding");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingIn(List<Byte> values) {
            addCriterion("isRebidding in", values, "isrebidding");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingNotIn(List<Byte> values) {
            addCriterion("isRebidding not in", values, "isrebidding");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingBetween(Byte value1, Byte value2) {
            addCriterion("isRebidding between", value1, value2, "isrebidding");
            return (Criteria) this;
        }

        public Criteria andIsrebiddingNotBetween(Byte value1, Byte value2) {
            addCriterion("isRebidding not between", value1, value2, "isrebidding");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdIsNull() {
            addCriterion("more_winner_id is null");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdIsNotNull() {
            addCriterion("more_winner_id is not null");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdEqualTo(String value) {
            addCriterion("more_winner_id =", value, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdNotEqualTo(String value) {
            addCriterion("more_winner_id <>", value, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdGreaterThan(String value) {
            addCriterion("more_winner_id >", value, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("more_winner_id >=", value, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdLessThan(String value) {
            addCriterion("more_winner_id <", value, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdLessThanOrEqualTo(String value) {
            addCriterion("more_winner_id <=", value, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdLike(String value) {
            addCriterion("more_winner_id like", value, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdNotLike(String value) {
            addCriterion("more_winner_id not like", value, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdIn(List<String> values) {
            addCriterion("more_winner_id in", values, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdNotIn(List<String> values) {
            addCriterion("more_winner_id not in", values, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdBetween(String value1, String value2) {
            addCriterion("more_winner_id between", value1, value2, "moreWinnerId");
            return (Criteria) this;
        }

        public Criteria andMoreWinnerIdNotBetween(String value1, String value2) {
            addCriterion("more_winner_id not between", value1, value2, "moreWinnerId");
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