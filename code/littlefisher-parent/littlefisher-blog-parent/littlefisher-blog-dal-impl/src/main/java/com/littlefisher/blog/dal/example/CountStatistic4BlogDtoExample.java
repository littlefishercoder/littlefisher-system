package com.littlefisher.blog.dal.example;

import java.util.ArrayList;
import java.util.List;


public class CountStatistic4BlogDtoExample {
    /** orderByClause */
    protected String orderByClause;

    /** distinct */
    protected boolean distinct;

    /** oredCriteria */
    protected List<Criteria> oredCriteria;

    /**
     * Description: CountStatistic4BlogDtoExample<br>
     *
     * @author jinyanan <br>
     */
    public CountStatistic4BlogDtoExample() {
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

        public Criteria andVisitedTimesIsNull() {
            addCriterion("visited_times is null");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesIsNotNull() {
            addCriterion("visited_times is not null");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesEqualTo(Long value) {
            addCriterion("visited_times =", value, "visitedTimes");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesNotEqualTo(Long value) {
            addCriterion("visited_times <>", value, "visitedTimes");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesGreaterThan(Long value) {
            addCriterion("visited_times >", value, "visitedTimes");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesGreaterThanOrEqualTo(Long value) {
            addCriterion("visited_times >=", value, "visitedTimes");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesLessThan(Long value) {
            addCriterion("visited_times <", value, "visitedTimes");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesLessThanOrEqualTo(Long value) {
            addCriterion("visited_times <=", value, "visitedTimes");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesIn(List<Long> values) {
            addCriterion("visited_times in", values, "visitedTimes");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesNotIn(List<Long> values) {
            addCriterion("visited_times not in", values, "visitedTimes");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesBetween(Long value1, Long value2) {
            addCriterion("visited_times between", value1, value2, "visitedTimes");
            return (Criteria) this;
        }

        public Criteria andVisitedTimesNotBetween(Long value1, Long value2) {
            addCriterion("visited_times not between", value1, value2, "visitedTimes");
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