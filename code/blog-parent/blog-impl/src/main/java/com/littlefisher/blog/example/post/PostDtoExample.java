package com.littlefisher.blog.example.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.littlefisher.blog.enums.post.EnumPostState;
import com.littlefisher.blog.enums.post.EnumPostType;


public class PostDtoExample {
    /** orderByClause */
    protected String orderByClause;

    /** distinct */
    protected boolean distinct;

    /** oredCriteria */
    protected List<Criteria> oredCriteria;

    /**
     * Description: PostDtoExample<br>
     *
     * @author jinyanan <br>
     */
    public PostDtoExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlIsNull() {
            addCriterion("original_url is null");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlIsNotNull() {
            addCriterion("original_url is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlEqualTo(String value) {
            addCriterion("original_url =", value, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlNotEqualTo(String value) {
            addCriterion("original_url <>", value, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlGreaterThan(String value) {
            addCriterion("original_url >", value, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlGreaterThanOrEqualTo(String value) {
            addCriterion("original_url >=", value, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlLessThan(String value) {
            addCriterion("original_url <", value, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlLessThanOrEqualTo(String value) {
            addCriterion("original_url <=", value, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlLike(String value) {
            addCriterion("original_url like", value, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlNotLike(String value) {
            addCriterion("original_url not like", value, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlIn(List<String> values) {
            addCriterion("original_url in", values, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlNotIn(List<String> values) {
            addCriterion("original_url not in", values, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlBetween(String value1, String value2) {
            addCriterion("original_url between", value1, value2, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andOriginalUrlNotBetween(String value1, String value2) {
            addCriterion("original_url not between", value1, value2, "originalUrl");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(EnumPostType value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(EnumPostType value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(EnumPostType value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(EnumPostType value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(EnumPostType value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(EnumPostType value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(EnumPostType value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(EnumPostType value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<EnumPostType> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<EnumPostType> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(EnumPostType value1, EnumPostType value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(EnumPostType value1, EnumPostType value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateIsNull() {
            addCriterion("last_modify_date is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateIsNotNull() {
            addCriterion("last_modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateEqualTo(Date value) {
            addCriterion("last_modify_date =", value, "lastModifyDate");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateNotEqualTo(Date value) {
            addCriterion("last_modify_date <>", value, "lastModifyDate");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateGreaterThan(Date value) {
            addCriterion("last_modify_date >", value, "lastModifyDate");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_modify_date >=", value, "lastModifyDate");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateLessThan(Date value) {
            addCriterion("last_modify_date <", value, "lastModifyDate");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("last_modify_date <=", value, "lastModifyDate");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateIn(List<Date> values) {
            addCriterion("last_modify_date in", values, "lastModifyDate");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateNotIn(List<Date> values) {
            addCriterion("last_modify_date not in", values, "lastModifyDate");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateBetween(Date value1, Date value2) {
            addCriterion("last_modify_date between", value1, value2, "lastModifyDate");
            return (Criteria) this;
        }

        public Criteria andLastModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("last_modify_date not between", value1, value2, "lastModifyDate");
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

        public Criteria andCommentTimesIsNull() {
            addCriterion("comment_times is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimesIsNotNull() {
            addCriterion("comment_times is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimesEqualTo(Long value) {
            addCriterion("comment_times =", value, "commentTimes");
            return (Criteria) this;
        }

        public Criteria andCommentTimesNotEqualTo(Long value) {
            addCriterion("comment_times <>", value, "commentTimes");
            return (Criteria) this;
        }

        public Criteria andCommentTimesGreaterThan(Long value) {
            addCriterion("comment_times >", value, "commentTimes");
            return (Criteria) this;
        }

        public Criteria andCommentTimesGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_times >=", value, "commentTimes");
            return (Criteria) this;
        }

        public Criteria andCommentTimesLessThan(Long value) {
            addCriterion("comment_times <", value, "commentTimes");
            return (Criteria) this;
        }

        public Criteria andCommentTimesLessThanOrEqualTo(Long value) {
            addCriterion("comment_times <=", value, "commentTimes");
            return (Criteria) this;
        }

        public Criteria andCommentTimesIn(List<Long> values) {
            addCriterion("comment_times in", values, "commentTimes");
            return (Criteria) this;
        }

        public Criteria andCommentTimesNotIn(List<Long> values) {
            addCriterion("comment_times not in", values, "commentTimes");
            return (Criteria) this;
        }

        public Criteria andCommentTimesBetween(Long value1, Long value2) {
            addCriterion("comment_times between", value1, value2, "commentTimes");
            return (Criteria) this;
        }

        public Criteria andCommentTimesNotBetween(Long value1, Long value2) {
            addCriterion("comment_times not between", value1, value2, "commentTimes");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andEnableCommentIsNull() {
            addCriterion("enable_comment is null");
            return (Criteria) this;
        }

        public Criteria andEnableCommentIsNotNull() {
            addCriterion("enable_comment is not null");
            return (Criteria) this;
        }

        public Criteria andEnableCommentEqualTo(String value) {
            addCriterion("enable_comment =", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentNotEqualTo(String value) {
            addCriterion("enable_comment <>", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentGreaterThan(String value) {
            addCriterion("enable_comment >", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentGreaterThanOrEqualTo(String value) {
            addCriterion("enable_comment >=", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentLessThan(String value) {
            addCriterion("enable_comment <", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentLessThanOrEqualTo(String value) {
            addCriterion("enable_comment <=", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentLike(String value) {
            addCriterion("enable_comment like", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentNotLike(String value) {
            addCriterion("enable_comment not like", value, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentIn(List<String> values) {
            addCriterion("enable_comment in", values, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentNotIn(List<String> values) {
            addCriterion("enable_comment not in", values, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentBetween(String value1, String value2) {
            addCriterion("enable_comment between", value1, value2, "enableComment");
            return (Criteria) this;
        }

        public Criteria andEnableCommentNotBetween(String value1, String value2) {
            addCriterion("enable_comment not between", value1, value2, "enableComment");
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

        public Criteria andStateEqualTo(EnumPostState value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(EnumPostState value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(EnumPostState value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(EnumPostState value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(EnumPostState value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(EnumPostState value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(EnumPostState value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(EnumPostState value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<EnumPostState> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<EnumPostState> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(EnumPostState value1, EnumPostState value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(EnumPostState value1, EnumPostState value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateDateIsNull() {
            addCriterion("state_date is null");
            return (Criteria) this;
        }

        public Criteria andStateDateIsNotNull() {
            addCriterion("state_date is not null");
            return (Criteria) this;
        }

        public Criteria andStateDateEqualTo(Date value) {
            addCriterion("state_date =", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateNotEqualTo(Date value) {
            addCriterion("state_date <>", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateGreaterThan(Date value) {
            addCriterion("state_date >", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("state_date >=", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateLessThan(Date value) {
            addCriterion("state_date <", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateLessThanOrEqualTo(Date value) {
            addCriterion("state_date <=", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateIn(List<Date> values) {
            addCriterion("state_date in", values, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateNotIn(List<Date> values) {
            addCriterion("state_date not in", values, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateBetween(Date value1, Date value2) {
            addCriterion("state_date between", value1, value2, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateNotBetween(Date value1, Date value2) {
            addCriterion("state_date not between", value1, value2, "stateDate");
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