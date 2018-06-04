package com.littlefisher.blog.dal.example;

import java.util.ArrayList;
import java.util.List;


public class CountStatistic4PostDtoExample {
    /** orderByClause */
    protected String orderByClause;

    /** distinct */
    protected boolean distinct;

    /** oredCriteria */
    protected List<Criteria> oredCriteria;

    /**
     * Description: CountStatistic4PostDtoExample<br>
     *
     * @author jinyanan <br>
     */
    public CountStatistic4PostDtoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * Description: setOrderByClause<br>
     *
     * @author jinyanan <br>
     * @param orderByClause orderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * Description: getOrderByClause<br>
     *
     * @author jinyanan <br>
     * @return String String<br>
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * Description: setDistinct<br>
     *
     * @author jinyanan <br>
     * @param distinct distinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * Description: isDistinct<br>
     *
     * @author jinyanan <br>
     * @return boolean boolean<br>
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * Description: getOredCriteria<br>
     *
     * @author jinyanan <br>
     * @return List<Criteria> List<Criteria><br>
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * Description: or<br>
     *
     * @author jinyanan <br>
     * @param criteria criteria
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * Description: or<br>
     *
     * @author jinyanan <br>
     * @return Criteria Criteria<br>
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * Description: createCriteria<br>
     *
     * @author jinyanan <br>
     * @return Criteria Criteria<br>
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * Description: createCriteriaInternal<br>
     *
     * @author jinyanan <br>
     * @return Criteria Criteria<br>
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * Description: clear<br>
     *
     * @author jinyanan <br>
     */
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

        public Criteria andCountStatisticIdIsNull() {
            addCriterion("count_statistic_id is null");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdIsNotNull() {
            addCriterion("count_statistic_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdEqualTo(Long value) {
            addCriterion("count_statistic_id =", value, "countStatisticId");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdNotEqualTo(Long value) {
            addCriterion("count_statistic_id <>", value, "countStatisticId");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdGreaterThan(Long value) {
            addCriterion("count_statistic_id >", value, "countStatisticId");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdGreaterThanOrEqualTo(Long value) {
            addCriterion("count_statistic_id >=", value, "countStatisticId");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdLessThan(Long value) {
            addCriterion("count_statistic_id <", value, "countStatisticId");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdLessThanOrEqualTo(Long value) {
            addCriterion("count_statistic_id <=", value, "countStatisticId");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdIn(List<Long> values) {
            addCriterion("count_statistic_id in", values, "countStatisticId");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdNotIn(List<Long> values) {
            addCriterion("count_statistic_id not in", values, "countStatisticId");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdBetween(Long value1, Long value2) {
            addCriterion("count_statistic_id between", value1, value2, "countStatisticId");
            return (Criteria) this;
        }

        public Criteria andCountStatisticIdNotBetween(Long value1, Long value2) {
            addCriterion("count_statistic_id not between", value1, value2, "countStatisticId");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNull() {
            addCriterion("post_id is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(Long value) {
            addCriterion("post_id =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(Long value) {
            addCriterion("post_id <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(Long value) {
            addCriterion("post_id >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(Long value) {
            addCriterion("post_id >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(Long value) {
            addCriterion("post_id <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(Long value) {
            addCriterion("post_id <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<Long> values) {
            addCriterion("post_id in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<Long> values) {
            addCriterion("post_id not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(Long value1, Long value2) {
            addCriterion("post_id between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(Long value1, Long value2) {
            addCriterion("post_id not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andReadTimesIsNull() {
            addCriterion("read_times is null");
            return (Criteria) this;
        }

        public Criteria andReadTimesIsNotNull() {
            addCriterion("read_times is not null");
            return (Criteria) this;
        }

        public Criteria andReadTimesEqualTo(Long value) {
            addCriterion("read_times =", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesNotEqualTo(Long value) {
            addCriterion("read_times <>", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesGreaterThan(Long value) {
            addCriterion("read_times >", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesGreaterThanOrEqualTo(Long value) {
            addCriterion("read_times >=", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesLessThan(Long value) {
            addCriterion("read_times <", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesLessThanOrEqualTo(Long value) {
            addCriterion("read_times <=", value, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesIn(List<Long> values) {
            addCriterion("read_times in", values, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesNotIn(List<Long> values) {
            addCriterion("read_times not in", values, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesBetween(Long value1, Long value2) {
            addCriterion("read_times between", value1, value2, "readTimes");
            return (Criteria) this;
        }

        public Criteria andReadTimesNotBetween(Long value1, Long value2) {
            addCriterion("read_times not between", value1, value2, "readTimes");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesIsNull() {
            addCriterion("commented_times is null");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesIsNotNull() {
            addCriterion("commented_times is not null");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesEqualTo(Long value) {
            addCriterion("commented_times =", value, "commentedTimes");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesNotEqualTo(Long value) {
            addCriterion("commented_times <>", value, "commentedTimes");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesGreaterThan(Long value) {
            addCriterion("commented_times >", value, "commentedTimes");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesGreaterThanOrEqualTo(Long value) {
            addCriterion("commented_times >=", value, "commentedTimes");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesLessThan(Long value) {
            addCriterion("commented_times <", value, "commentedTimes");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesLessThanOrEqualTo(Long value) {
            addCriterion("commented_times <=", value, "commentedTimes");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesIn(List<Long> values) {
            addCriterion("commented_times in", values, "commentedTimes");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesNotIn(List<Long> values) {
            addCriterion("commented_times not in", values, "commentedTimes");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesBetween(Long value1, Long value2) {
            addCriterion("commented_times between", value1, value2, "commentedTimes");
            return (Criteria) this;
        }

        public Criteria andCommentedTimesNotBetween(Long value1, Long value2) {
            addCriterion("commented_times not between", value1, value2, "commentedTimes");
            return (Criteria) this;
        }

        public Criteria andLikedTimesIsNull() {
            addCriterion("liked_times is null");
            return (Criteria) this;
        }

        public Criteria andLikedTimesIsNotNull() {
            addCriterion("liked_times is not null");
            return (Criteria) this;
        }

        public Criteria andLikedTimesEqualTo(Long value) {
            addCriterion("liked_times =", value, "likedTimes");
            return (Criteria) this;
        }

        public Criteria andLikedTimesNotEqualTo(Long value) {
            addCriterion("liked_times <>", value, "likedTimes");
            return (Criteria) this;
        }

        public Criteria andLikedTimesGreaterThan(Long value) {
            addCriterion("liked_times >", value, "likedTimes");
            return (Criteria) this;
        }

        public Criteria andLikedTimesGreaterThanOrEqualTo(Long value) {
            addCriterion("liked_times >=", value, "likedTimes");
            return (Criteria) this;
        }

        public Criteria andLikedTimesLessThan(Long value) {
            addCriterion("liked_times <", value, "likedTimes");
            return (Criteria) this;
        }

        public Criteria andLikedTimesLessThanOrEqualTo(Long value) {
            addCriterion("liked_times <=", value, "likedTimes");
            return (Criteria) this;
        }

        public Criteria andLikedTimesIn(List<Long> values) {
            addCriterion("liked_times in", values, "likedTimes");
            return (Criteria) this;
        }

        public Criteria andLikedTimesNotIn(List<Long> values) {
            addCriterion("liked_times not in", values, "likedTimes");
            return (Criteria) this;
        }

        public Criteria andLikedTimesBetween(Long value1, Long value2) {
            addCriterion("liked_times between", value1, value2, "likedTimes");
            return (Criteria) this;
        }

        public Criteria andLikedTimesNotBetween(Long value1, Long value2) {
            addCriterion("liked_times not between", value1, value2, "likedTimes");
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