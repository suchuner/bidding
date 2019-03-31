package com.suchuner.bidding.pojo;

import java.util.ArrayList;
import java.util.List;

public class BiddingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BiddingExample() {
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

        public Criteria andMarginIdIsNull() {
            addCriterion("margin_id is null");
            return (Criteria) this;
        }

        public Criteria andMarginIdIsNotNull() {
            addCriterion("margin_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarginIdEqualTo(Long value) {
            addCriterion("margin_id =", value, "marginId");
            return (Criteria) this;
        }

        public Criteria andMarginIdNotEqualTo(Long value) {
            addCriterion("margin_id <>", value, "marginId");
            return (Criteria) this;
        }

        public Criteria andMarginIdGreaterThan(Long value) {
            addCriterion("margin_id >", value, "marginId");
            return (Criteria) this;
        }

        public Criteria andMarginIdGreaterThanOrEqualTo(Long value) {
            addCriterion("margin_id >=", value, "marginId");
            return (Criteria) this;
        }

        public Criteria andMarginIdLessThan(Long value) {
            addCriterion("margin_id <", value, "marginId");
            return (Criteria) this;
        }

        public Criteria andMarginIdLessThanOrEqualTo(Long value) {
            addCriterion("margin_id <=", value, "marginId");
            return (Criteria) this;
        }

        public Criteria andMarginIdIn(List<Long> values) {
            addCriterion("margin_id in", values, "marginId");
            return (Criteria) this;
        }

        public Criteria andMarginIdNotIn(List<Long> values) {
            addCriterion("margin_id not in", values, "marginId");
            return (Criteria) this;
        }

        public Criteria andMarginIdBetween(Long value1, Long value2) {
            addCriterion("margin_id between", value1, value2, "marginId");
            return (Criteria) this;
        }

        public Criteria andMarginIdNotBetween(Long value1, Long value2) {
            addCriterion("margin_id not between", value1, value2, "marginId");
            return (Criteria) this;
        }

        public Criteria andIsmarginIsNull() {
            addCriterion("isMargin is null");
            return (Criteria) this;
        }

        public Criteria andIsmarginIsNotNull() {
            addCriterion("isMargin is not null");
            return (Criteria) this;
        }

        public Criteria andIsmarginEqualTo(Integer value) {
            addCriterion("isMargin =", value, "ismargin");
            return (Criteria) this;
        }

        public Criteria andIsmarginNotEqualTo(Integer value) {
            addCriterion("isMargin <>", value, "ismargin");
            return (Criteria) this;
        }

        public Criteria andIsmarginGreaterThan(Integer value) {
            addCriterion("isMargin >", value, "ismargin");
            return (Criteria) this;
        }

        public Criteria andIsmarginGreaterThanOrEqualTo(Integer value) {
            addCriterion("isMargin >=", value, "ismargin");
            return (Criteria) this;
        }

        public Criteria andIsmarginLessThan(Integer value) {
            addCriterion("isMargin <", value, "ismargin");
            return (Criteria) this;
        }

        public Criteria andIsmarginLessThanOrEqualTo(Integer value) {
            addCriterion("isMargin <=", value, "ismargin");
            return (Criteria) this;
        }

        public Criteria andIsmarginIn(List<Integer> values) {
            addCriterion("isMargin in", values, "ismargin");
            return (Criteria) this;
        }

        public Criteria andIsmarginNotIn(List<Integer> values) {
            addCriterion("isMargin not in", values, "ismargin");
            return (Criteria) this;
        }

        public Criteria andIsmarginBetween(Integer value1, Integer value2) {
            addCriterion("isMargin between", value1, value2, "ismargin");
            return (Criteria) this;
        }

        public Criteria andIsmarginNotBetween(Integer value1, Integer value2) {
            addCriterion("isMargin not between", value1, value2, "ismargin");
            return (Criteria) this;
        }

        public Criteria andMarginIsNull() {
            addCriterion("margin is null");
            return (Criteria) this;
        }

        public Criteria andMarginIsNotNull() {
            addCriterion("margin is not null");
            return (Criteria) this;
        }

        public Criteria andMarginEqualTo(Long value) {
            addCriterion("margin =", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotEqualTo(Long value) {
            addCriterion("margin <>", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginGreaterThan(Long value) {
            addCriterion("margin >", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginGreaterThanOrEqualTo(Long value) {
            addCriterion("margin >=", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginLessThan(Long value) {
            addCriterion("margin <", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginLessThanOrEqualTo(Long value) {
            addCriterion("margin <=", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginIn(List<Long> values) {
            addCriterion("margin in", values, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotIn(List<Long> values) {
            addCriterion("margin not in", values, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginBetween(Long value1, Long value2) {
            addCriterion("margin between", value1, value2, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotBetween(Long value1, Long value2) {
            addCriterion("margin not between", value1, value2, "margin");
            return (Criteria) this;
        }

        public Criteria andCashIsNull() {
            addCriterion("cash is null");
            return (Criteria) this;
        }

        public Criteria andCashIsNotNull() {
            addCriterion("cash is not null");
            return (Criteria) this;
        }

        public Criteria andCashEqualTo(Long value) {
            addCriterion("cash =", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotEqualTo(Long value) {
            addCriterion("cash <>", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThan(Long value) {
            addCriterion("cash >", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThanOrEqualTo(Long value) {
            addCriterion("cash >=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThan(Long value) {
            addCriterion("cash <", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThanOrEqualTo(Long value) {
            addCriterion("cash <=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashIn(List<Long> values) {
            addCriterion("cash in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotIn(List<Long> values) {
            addCriterion("cash not in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashBetween(Long value1, Long value2) {
            addCriterion("cash between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotBetween(Long value1, Long value2) {
            addCriterion("cash not between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andMargindocIsNull() {
            addCriterion("marginDoc is null");
            return (Criteria) this;
        }

        public Criteria andMargindocIsNotNull() {
            addCriterion("marginDoc is not null");
            return (Criteria) this;
        }

        public Criteria andMargindocEqualTo(String value) {
            addCriterion("marginDoc =", value, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocNotEqualTo(String value) {
            addCriterion("marginDoc <>", value, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocGreaterThan(String value) {
            addCriterion("marginDoc >", value, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocGreaterThanOrEqualTo(String value) {
            addCriterion("marginDoc >=", value, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocLessThan(String value) {
            addCriterion("marginDoc <", value, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocLessThanOrEqualTo(String value) {
            addCriterion("marginDoc <=", value, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocLike(String value) {
            addCriterion("marginDoc like", value, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocNotLike(String value) {
            addCriterion("marginDoc not like", value, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocIn(List<String> values) {
            addCriterion("marginDoc in", values, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocNotIn(List<String> values) {
            addCriterion("marginDoc not in", values, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocBetween(String value1, String value2) {
            addCriterion("marginDoc between", value1, value2, "margindoc");
            return (Criteria) this;
        }

        public Criteria andMargindocNotBetween(String value1, String value2) {
            addCriterion("marginDoc not between", value1, value2, "margindoc");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andIswinnerIsNull() {
            addCriterion("isWinner is null");
            return (Criteria) this;
        }

        public Criteria andIswinnerIsNotNull() {
            addCriterion("isWinner is not null");
            return (Criteria) this;
        }

        public Criteria andIswinnerEqualTo(Byte value) {
            addCriterion("isWinner =", value, "iswinner");
            return (Criteria) this;
        }

        public Criteria andIswinnerNotEqualTo(Byte value) {
            addCriterion("isWinner <>", value, "iswinner");
            return (Criteria) this;
        }

        public Criteria andIswinnerGreaterThan(Byte value) {
            addCriterion("isWinner >", value, "iswinner");
            return (Criteria) this;
        }

        public Criteria andIswinnerGreaterThanOrEqualTo(Byte value) {
            addCriterion("isWinner >=", value, "iswinner");
            return (Criteria) this;
        }

        public Criteria andIswinnerLessThan(Byte value) {
            addCriterion("isWinner <", value, "iswinner");
            return (Criteria) this;
        }

        public Criteria andIswinnerLessThanOrEqualTo(Byte value) {
            addCriterion("isWinner <=", value, "iswinner");
            return (Criteria) this;
        }

        public Criteria andIswinnerIn(List<Byte> values) {
            addCriterion("isWinner in", values, "iswinner");
            return (Criteria) this;
        }

        public Criteria andIswinnerNotIn(List<Byte> values) {
            addCriterion("isWinner not in", values, "iswinner");
            return (Criteria) this;
        }

        public Criteria andIswinnerBetween(Byte value1, Byte value2) {
            addCriterion("isWinner between", value1, value2, "iswinner");
            return (Criteria) this;
        }

        public Criteria andIswinnerNotBetween(Byte value1, Byte value2) {
            addCriterion("isWinner not between", value1, value2, "iswinner");
            return (Criteria) this;
        }

        public Criteria andListpricedocIsNull() {
            addCriterion("listPriceDoc is null");
            return (Criteria) this;
        }

        public Criteria andListpricedocIsNotNull() {
            addCriterion("listPriceDoc is not null");
            return (Criteria) this;
        }

        public Criteria andListpricedocEqualTo(String value) {
            addCriterion("listPriceDoc =", value, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocNotEqualTo(String value) {
            addCriterion("listPriceDoc <>", value, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocGreaterThan(String value) {
            addCriterion("listPriceDoc >", value, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocGreaterThanOrEqualTo(String value) {
            addCriterion("listPriceDoc >=", value, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocLessThan(String value) {
            addCriterion("listPriceDoc <", value, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocLessThanOrEqualTo(String value) {
            addCriterion("listPriceDoc <=", value, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocLike(String value) {
            addCriterion("listPriceDoc like", value, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocNotLike(String value) {
            addCriterion("listPriceDoc not like", value, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocIn(List<String> values) {
            addCriterion("listPriceDoc in", values, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocNotIn(List<String> values) {
            addCriterion("listPriceDoc not in", values, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocBetween(String value1, String value2) {
            addCriterion("listPriceDoc between", value1, value2, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andListpricedocNotBetween(String value1, String value2) {
            addCriterion("listPriceDoc not between", value1, value2, "listpricedoc");
            return (Criteria) this;
        }

        public Criteria andBiddocIsNull() {
            addCriterion("bidDoc is null");
            return (Criteria) this;
        }

        public Criteria andBiddocIsNotNull() {
            addCriterion("bidDoc is not null");
            return (Criteria) this;
        }

        public Criteria andBiddocEqualTo(String value) {
            addCriterion("bidDoc =", value, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocNotEqualTo(String value) {
            addCriterion("bidDoc <>", value, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocGreaterThan(String value) {
            addCriterion("bidDoc >", value, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocGreaterThanOrEqualTo(String value) {
            addCriterion("bidDoc >=", value, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocLessThan(String value) {
            addCriterion("bidDoc <", value, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocLessThanOrEqualTo(String value) {
            addCriterion("bidDoc <=", value, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocLike(String value) {
            addCriterion("bidDoc like", value, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocNotLike(String value) {
            addCriterion("bidDoc not like", value, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocIn(List<String> values) {
            addCriterion("bidDoc in", values, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocNotIn(List<String> values) {
            addCriterion("bidDoc not in", values, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocBetween(String value1, String value2) {
            addCriterion("bidDoc between", value1, value2, "biddoc");
            return (Criteria) this;
        }

        public Criteria andBiddocNotBetween(String value1, String value2) {
            addCriterion("bidDoc not between", value1, value2, "biddoc");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andBussinessIsNull() {
            addCriterion("bussiness is null");
            return (Criteria) this;
        }

        public Criteria andBussinessIsNotNull() {
            addCriterion("bussiness is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessEqualTo(Double value) {
            addCriterion("bussiness =", value, "bussiness");
            return (Criteria) this;
        }

        public Criteria andBussinessNotEqualTo(Double value) {
            addCriterion("bussiness <>", value, "bussiness");
            return (Criteria) this;
        }

        public Criteria andBussinessGreaterThan(Double value) {
            addCriterion("bussiness >", value, "bussiness");
            return (Criteria) this;
        }

        public Criteria andBussinessGreaterThanOrEqualTo(Double value) {
            addCriterion("bussiness >=", value, "bussiness");
            return (Criteria) this;
        }

        public Criteria andBussinessLessThan(Double value) {
            addCriterion("bussiness <", value, "bussiness");
            return (Criteria) this;
        }

        public Criteria andBussinessLessThanOrEqualTo(Double value) {
            addCriterion("bussiness <=", value, "bussiness");
            return (Criteria) this;
        }

        public Criteria andBussinessIn(List<Double> values) {
            addCriterion("bussiness in", values, "bussiness");
            return (Criteria) this;
        }

        public Criteria andBussinessNotIn(List<Double> values) {
            addCriterion("bussiness not in", values, "bussiness");
            return (Criteria) this;
        }

        public Criteria andBussinessBetween(Double value1, Double value2) {
            addCriterion("bussiness between", value1, value2, "bussiness");
            return (Criteria) this;
        }

        public Criteria andBussinessNotBetween(Double value1, Double value2) {
            addCriterion("bussiness not between", value1, value2, "bussiness");
            return (Criteria) this;
        }

        public Criteria andServiceIsNull() {
            addCriterion("service is null");
            return (Criteria) this;
        }

        public Criteria andServiceIsNotNull() {
            addCriterion("service is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEqualTo(Double value) {
            addCriterion("service =", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotEqualTo(Double value) {
            addCriterion("service <>", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThan(Double value) {
            addCriterion("service >", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThanOrEqualTo(Double value) {
            addCriterion("service >=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThan(Double value) {
            addCriterion("service <", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThanOrEqualTo(Double value) {
            addCriterion("service <=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceIn(List<Double> values) {
            addCriterion("service in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotIn(List<Double> values) {
            addCriterion("service not in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceBetween(Double value1, Double value2) {
            addCriterion("service between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotBetween(Double value1, Double value2) {
            addCriterion("service not between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andTechnologyIsNull() {
            addCriterion("technology is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyIsNotNull() {
            addCriterion("technology is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyEqualTo(Double value) {
            addCriterion("technology =", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyNotEqualTo(Double value) {
            addCriterion("technology <>", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyGreaterThan(Double value) {
            addCriterion("technology >", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyGreaterThanOrEqualTo(Double value) {
            addCriterion("technology >=", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyLessThan(Double value) {
            addCriterion("technology <", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyLessThanOrEqualTo(Double value) {
            addCriterion("technology <=", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyIn(List<Double> values) {
            addCriterion("technology in", values, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyNotIn(List<Double> values) {
            addCriterion("technology not in", values, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyBetween(Double value1, Double value2) {
            addCriterion("technology between", value1, value2, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyNotBetween(Double value1, Double value2) {
            addCriterion("technology not between", value1, value2, "technology");
            return (Criteria) this;
        }

        public Criteria andTotalscoreIsNull() {
            addCriterion("totalScore is null");
            return (Criteria) this;
        }

        public Criteria andTotalscoreIsNotNull() {
            addCriterion("totalScore is not null");
            return (Criteria) this;
        }

        public Criteria andTotalscoreEqualTo(Double value) {
            addCriterion("totalScore =", value, "totalscore");
            return (Criteria) this;
        }

        public Criteria andTotalscoreNotEqualTo(Double value) {
            addCriterion("totalScore <>", value, "totalscore");
            return (Criteria) this;
        }

        public Criteria andTotalscoreGreaterThan(Double value) {
            addCriterion("totalScore >", value, "totalscore");
            return (Criteria) this;
        }

        public Criteria andTotalscoreGreaterThanOrEqualTo(Double value) {
            addCriterion("totalScore >=", value, "totalscore");
            return (Criteria) this;
        }

        public Criteria andTotalscoreLessThan(Double value) {
            addCriterion("totalScore <", value, "totalscore");
            return (Criteria) this;
        }

        public Criteria andTotalscoreLessThanOrEqualTo(Double value) {
            addCriterion("totalScore <=", value, "totalscore");
            return (Criteria) this;
        }

        public Criteria andTotalscoreIn(List<Double> values) {
            addCriterion("totalScore in", values, "totalscore");
            return (Criteria) this;
        }

        public Criteria andTotalscoreNotIn(List<Double> values) {
            addCriterion("totalScore not in", values, "totalscore");
            return (Criteria) this;
        }

        public Criteria andTotalscoreBetween(Double value1, Double value2) {
            addCriterion("totalScore between", value1, value2, "totalscore");
            return (Criteria) this;
        }

        public Criteria andTotalscoreNotBetween(Double value1, Double value2) {
            addCriterion("totalScore not between", value1, value2, "totalscore");
            return (Criteria) this;
        }

        public Criteria andIsBeginIsNull() {
            addCriterion("is_begin is null");
            return (Criteria) this;
        }

        public Criteria andIsBeginIsNotNull() {
            addCriterion("is_begin is not null");
            return (Criteria) this;
        }

        public Criteria andIsBeginEqualTo(Byte value) {
            addCriterion("is_begin =", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginNotEqualTo(Byte value) {
            addCriterion("is_begin <>", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginGreaterThan(Byte value) {
            addCriterion("is_begin >", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_begin >=", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginLessThan(Byte value) {
            addCriterion("is_begin <", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginLessThanOrEqualTo(Byte value) {
            addCriterion("is_begin <=", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginIn(List<Byte> values) {
            addCriterion("is_begin in", values, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginNotIn(List<Byte> values) {
            addCriterion("is_begin not in", values, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginBetween(Byte value1, Byte value2) {
            addCriterion("is_begin between", value1, value2, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginNotBetween(Byte value1, Byte value2) {
            addCriterion("is_begin not between", value1, value2, "isBegin");
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