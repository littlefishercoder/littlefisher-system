package com.littlefisher.blog.dal.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.littlefisher.blog.common.enums.EnumFriendLinkState;

public class FriendLinkDtoExample {
    /** orderByClause */
    protected String orderByClause;

    /** distinct */
    protected boolean distinct;

    /** oredCriteria */
    protected List<Criteria> oredCriteria;

    /**
     * Description: FriendLinkDtoExample<br>
     *
     * @author jinyanan <br>
     */
    public FriendLinkDtoExample() {
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

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Long value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Long value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Long value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Long value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Long value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Long> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Long> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Long value1, Long value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Long value1, Long value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameIsNull() {
            addCriterion("friend_real_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameIsNotNull() {
            addCriterion("friend_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameEqualTo(String value) {
            addCriterion("friend_real_name =", value, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameNotEqualTo(String value) {
            addCriterion("friend_real_name <>", value, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameGreaterThan(String value) {
            addCriterion("friend_real_name >", value, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("friend_real_name >=", value, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameLessThan(String value) {
            addCriterion("friend_real_name <", value, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameLessThanOrEqualTo(String value) {
            addCriterion("friend_real_name <=", value, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameLike(String value) {
            addCriterion("friend_real_name like", value, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameNotLike(String value) {
            addCriterion("friend_real_name not like", value, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameIn(List<String> values) {
            addCriterion("friend_real_name in", values, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameNotIn(List<String> values) {
            addCriterion("friend_real_name not in", values, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameBetween(String value1, String value2) {
            addCriterion("friend_real_name between", value1, value2, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendRealNameNotBetween(String value1, String value2) {
            addCriterion("friend_real_name not between", value1, value2, "friendRealName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameIsNull() {
            addCriterion("friend_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameIsNotNull() {
            addCriterion("friend_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameEqualTo(String value) {
            addCriterion("friend_nick_name =", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameNotEqualTo(String value) {
            addCriterion("friend_nick_name <>", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameGreaterThan(String value) {
            addCriterion("friend_nick_name >", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("friend_nick_name >=", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameLessThan(String value) {
            addCriterion("friend_nick_name <", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameLessThanOrEqualTo(String value) {
            addCriterion("friend_nick_name <=", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameLike(String value) {
            addCriterion("friend_nick_name like", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameNotLike(String value) {
            addCriterion("friend_nick_name not like", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameIn(List<String> values) {
            addCriterion("friend_nick_name in", values, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameNotIn(List<String> values) {
            addCriterion("friend_nick_name not in", values, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameBetween(String value1, String value2) {
            addCriterion("friend_nick_name between", value1, value2, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameNotBetween(String value1, String value2) {
            addCriterion("friend_nick_name not between", value1, value2, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkIsNull() {
            addCriterion("friend_url_link is null");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkIsNotNull() {
            addCriterion("friend_url_link is not null");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkEqualTo(String value) {
            addCriterion("friend_url_link =", value, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkNotEqualTo(String value) {
            addCriterion("friend_url_link <>", value, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkGreaterThan(String value) {
            addCriterion("friend_url_link >", value, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkGreaterThanOrEqualTo(String value) {
            addCriterion("friend_url_link >=", value, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkLessThan(String value) {
            addCriterion("friend_url_link <", value, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkLessThanOrEqualTo(String value) {
            addCriterion("friend_url_link <=", value, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkLike(String value) {
            addCriterion("friend_url_link like", value, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkNotLike(String value) {
            addCriterion("friend_url_link not like", value, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkIn(List<String> values) {
            addCriterion("friend_url_link in", values, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkNotIn(List<String> values) {
            addCriterion("friend_url_link not in", values, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkBetween(String value1, String value2) {
            addCriterion("friend_url_link between", value1, value2, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLinkNotBetween(String value1, String value2) {
            addCriterion("friend_url_link not between", value1, value2, "friendUrlLink");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(EnumFriendLinkState value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(EnumFriendLinkState value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(EnumFriendLinkState value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(EnumFriendLinkState value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(EnumFriendLinkState value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(EnumFriendLinkState value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(EnumFriendLinkState value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(EnumFriendLinkState value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<EnumFriendLinkState> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<EnumFriendLinkState> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(EnumFriendLinkState value1, EnumFriendLinkState value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(EnumFriendLinkState value1, EnumFriendLinkState value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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