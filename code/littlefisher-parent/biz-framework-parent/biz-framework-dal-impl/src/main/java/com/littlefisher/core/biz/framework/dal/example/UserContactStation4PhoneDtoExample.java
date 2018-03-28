package com.littlefisher.core.biz.framework.dal.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.littlefisher.biz.framework.common.enums.EnumUserContactStation4PhoneType;

public class UserContactStation4PhoneDtoExample {
    /** orderByClause */
    protected String orderByClause;

    /** distinct */
    protected boolean distinct;

    /** oredCriteria */
    protected List<Criteria> oredCriteria;

    /**
     * Description: UserContactStation4PhoneDtoExample<br>
     *
     * @author jinyanan <br>
     */
    public UserContactStation4PhoneDtoExample() {
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

        public Criteria andContactStationIdIsNull() {
            addCriterion("contact_station_id is null");
            return (Criteria) this;
        }

        public Criteria andContactStationIdIsNotNull() {
            addCriterion("contact_station_id is not null");
            return (Criteria) this;
        }

        public Criteria andContactStationIdEqualTo(Long value) {
            addCriterion("contact_station_id =", value, "contactStationId");
            return (Criteria) this;
        }

        public Criteria andContactStationIdNotEqualTo(Long value) {
            addCriterion("contact_station_id <>", value, "contactStationId");
            return (Criteria) this;
        }

        public Criteria andContactStationIdGreaterThan(Long value) {
            addCriterion("contact_station_id >", value, "contactStationId");
            return (Criteria) this;
        }

        public Criteria andContactStationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contact_station_id >=", value, "contactStationId");
            return (Criteria) this;
        }

        public Criteria andContactStationIdLessThan(Long value) {
            addCriterion("contact_station_id <", value, "contactStationId");
            return (Criteria) this;
        }

        public Criteria andContactStationIdLessThanOrEqualTo(Long value) {
            addCriterion("contact_station_id <=", value, "contactStationId");
            return (Criteria) this;
        }

        public Criteria andContactStationIdIn(List<Long> values) {
            addCriterion("contact_station_id in", values, "contactStationId");
            return (Criteria) this;
        }

        public Criteria andContactStationIdNotIn(List<Long> values) {
            addCriterion("contact_station_id not in", values, "contactStationId");
            return (Criteria) this;
        }

        public Criteria andContactStationIdBetween(Long value1, Long value2) {
            addCriterion("contact_station_id between", value1, value2, "contactStationId");
            return (Criteria) this;
        }

        public Criteria andContactStationIdNotBetween(Long value1, Long value2) {
            addCriterion("contact_station_id not between", value1, value2, "contactStationId");
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

        public Criteria andTypeEqualTo(EnumUserContactStation4PhoneType value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(EnumUserContactStation4PhoneType value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(EnumUserContactStation4PhoneType value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(EnumUserContactStation4PhoneType value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(EnumUserContactStation4PhoneType value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(EnumUserContactStation4PhoneType value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(EnumUserContactStation4PhoneType value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(EnumUserContactStation4PhoneType value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<EnumUserContactStation4PhoneType> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<EnumUserContactStation4PhoneType> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(EnumUserContactStation4PhoneType value1, EnumUserContactStation4PhoneType value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(EnumUserContactStation4PhoneType value1, EnumUserContactStation4PhoneType value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrIsNull() {
            addCriterion("phone_nbr is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrIsNotNull() {
            addCriterion("phone_nbr is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrEqualTo(String value) {
            addCriterion("phone_nbr =", value, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrNotEqualTo(String value) {
            addCriterion("phone_nbr <>", value, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrGreaterThan(String value) {
            addCriterion("phone_nbr >", value, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrGreaterThanOrEqualTo(String value) {
            addCriterion("phone_nbr >=", value, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrLessThan(String value) {
            addCriterion("phone_nbr <", value, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrLessThanOrEqualTo(String value) {
            addCriterion("phone_nbr <=", value, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrLike(String value) {
            addCriterion("phone_nbr like", value, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrNotLike(String value) {
            addCriterion("phone_nbr not like", value, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrIn(List<String> values) {
            addCriterion("phone_nbr in", values, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrNotIn(List<String> values) {
            addCriterion("phone_nbr not in", values, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrBetween(String value1, String value2) {
            addCriterion("phone_nbr between", value1, value2, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andPhoneNbrNotBetween(String value1, String value2) {
            addCriterion("phone_nbr not between", value1, value2, "phoneNbr");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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