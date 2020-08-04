package com.hand.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemExample() {
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
            addCriterion(condition, new java.util.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.util.Date> dateList = new ArrayList<java.util.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.util.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.util.Date(value1.getTime()), new java.util.Date(value2.getTime()), property);
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNull() {
            addCriterion("item_code is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("item_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("item_code =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("item_code <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("item_code >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_code >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("item_code <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("item_code <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("item_code like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("item_code not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("item_code in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("item_code not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("item_code between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("item_code not between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemUomIsNull() {
            addCriterion("item_uom is null");
            return (Criteria) this;
        }

        public Criteria andItemUomIsNotNull() {
            addCriterion("item_uom is not null");
            return (Criteria) this;
        }

        public Criteria andItemUomEqualTo(String value) {
            addCriterion("item_uom =", value, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomNotEqualTo(String value) {
            addCriterion("item_uom <>", value, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomGreaterThan(String value) {
            addCriterion("item_uom >", value, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomGreaterThanOrEqualTo(String value) {
            addCriterion("item_uom >=", value, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomLessThan(String value) {
            addCriterion("item_uom <", value, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomLessThanOrEqualTo(String value) {
            addCriterion("item_uom <=", value, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomLike(String value) {
            addCriterion("item_uom like", value, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomNotLike(String value) {
            addCriterion("item_uom not like", value, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomIn(List<String> values) {
            addCriterion("item_uom in", values, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomNotIn(List<String> values) {
            addCriterion("item_uom not in", values, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomBetween(String value1, String value2) {
            addCriterion("item_uom between", value1, value2, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemUomNotBetween(String value1, String value2) {
            addCriterion("item_uom not between", value1, value2, "itemUom");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIsNull() {
            addCriterion("item_description is null");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIsNotNull() {
            addCriterion("item_description is not null");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionEqualTo(String value) {
            addCriterion("item_description =", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotEqualTo(String value) {
            addCriterion("item_description <>", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionGreaterThan(String value) {
            addCriterion("item_description >", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("item_description >=", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLessThan(String value) {
            addCriterion("item_description <", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLessThanOrEqualTo(String value) {
            addCriterion("item_description <=", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLike(String value) {
            addCriterion("item_description like", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotLike(String value) {
            addCriterion("item_description not like", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIn(List<String> values) {
            addCriterion("item_description in", values, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotIn(List<String> values) {
            addCriterion("item_description not in", values, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionBetween(String value1, String value2) {
            addCriterion("item_description between", value1, value2, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotBetween(String value1, String value2) {
            addCriterion("item_description not between", value1, value2, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateIsNull() {
            addCriterion("start_active_date is null");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateIsNotNull() {
            addCriterion("start_active_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_active_date =", value, "startActiveDate");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_active_date <>", value, "startActiveDate");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_active_date >", value, "startActiveDate");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_active_date >=", value, "startActiveDate");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateLessThan(Date value) {
            addCriterionForJDBCDate("start_active_date <", value, "startActiveDate");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_active_date <=", value, "startActiveDate");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_active_date in", values, "startActiveDate");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_active_date not in", values, "startActiveDate");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_active_date between", value1, value2, "startActiveDate");
            return (Criteria) this;
        }

        public Criteria andStartActiveDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_active_date not between", value1, value2, "startActiveDate");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateIsNull() {
            addCriterion("end_active_date is null");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateIsNotNull() {
            addCriterion("end_active_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_active_date =", value, "endActiveDate");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_active_date <>", value, "endActiveDate");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_active_date >", value, "endActiveDate");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_active_date >=", value, "endActiveDate");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateLessThan(Date value) {
            addCriterionForJDBCDate("end_active_date <", value, "endActiveDate");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_active_date <=", value, "endActiveDate");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_active_date in", values, "endActiveDate");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_active_date not in", values, "endActiveDate");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_active_date between", value1, value2, "endActiveDate");
            return (Criteria) this;
        }

        public Criteria andEndActiveDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_active_date not between", value1, value2, "endActiveDate");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagIsNull() {
            addCriterion("enabled_flag is null");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagIsNotNull() {
            addCriterion("enabled_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagEqualTo(Boolean value) {
            addCriterion("enabled_flag =", value, "enabledFlag");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagNotEqualTo(Boolean value) {
            addCriterion("enabled_flag <>", value, "enabledFlag");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagGreaterThan(Boolean value) {
            addCriterion("enabled_flag >", value, "enabledFlag");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enabled_flag >=", value, "enabledFlag");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagLessThan(Boolean value) {
            addCriterion("enabled_flag <", value, "enabledFlag");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("enabled_flag <=", value, "enabledFlag");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagIn(List<Boolean> values) {
            addCriterion("enabled_flag in", values, "enabledFlag");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagNotIn(List<Boolean> values) {
            addCriterion("enabled_flag not in", values, "enabledFlag");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled_flag between", value1, value2, "enabledFlag");
            return (Criteria) this;
        }

        public Criteria andEnabledFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled_flag not between", value1, value2, "enabledFlag");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberIsNull() {
            addCriterion("object_version_number is null");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberIsNotNull() {
            addCriterion("object_version_number is not null");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberEqualTo(Long value) {
            addCriterion("object_version_number =", value, "objectVersionNumber");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberNotEqualTo(Long value) {
            addCriterion("object_version_number <>", value, "objectVersionNumber");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberGreaterThan(Long value) {
            addCriterion("object_version_number >", value, "objectVersionNumber");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("object_version_number >=", value, "objectVersionNumber");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberLessThan(Long value) {
            addCriterion("object_version_number <", value, "objectVersionNumber");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberLessThanOrEqualTo(Long value) {
            addCriterion("object_version_number <=", value, "objectVersionNumber");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberIn(List<Long> values) {
            addCriterion("object_version_number in", values, "objectVersionNumber");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberNotIn(List<Long> values) {
            addCriterion("object_version_number not in", values, "objectVersionNumber");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberBetween(Long value1, Long value2) {
            addCriterion("object_version_number between", value1, value2, "objectVersionNumber");
            return (Criteria) this;
        }

        public Criteria andObjectVersionNumberNotBetween(Long value1, Long value2) {
            addCriterion("object_version_number not between", value1, value2, "objectVersionNumber");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNull() {
            addCriterion("creation_date is null");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNotNull() {
            addCriterion("creation_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreationDateEqualTo(Date value) {
            addCriterion("creation_date =", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotEqualTo(Date value) {
            addCriterion("creation_date <>", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThan(Date value) {
            addCriterion("creation_date >", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_date >=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThan(Date value) {
            addCriterion("creation_date <", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThanOrEqualTo(Date value) {
            addCriterion("creation_date <=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateIn(List<Date> values) {
            addCriterion("creation_date in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotIn(List<Date> values) {
            addCriterion("creation_date not in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateBetween(Date value1, Date value2) {
            addCriterion("creation_date between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotBetween(Date value1, Date value2) {
            addCriterion("creation_date not between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(Long value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(Long value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(Long value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(Long value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(Long value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(Long value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<Long> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<Long> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(Long value1, Long value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(Long value1, Long value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIsNull() {
            addCriterion("last_updated_by is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIsNotNull() {
            addCriterion("last_updated_by is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByEqualTo(Long value) {
            addCriterion("last_updated_by =", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotEqualTo(Long value) {
            addCriterion("last_updated_by <>", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByGreaterThan(Long value) {
            addCriterion("last_updated_by >", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByGreaterThanOrEqualTo(Long value) {
            addCriterion("last_updated_by >=", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLessThan(Long value) {
            addCriterion("last_updated_by <", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLessThanOrEqualTo(Long value) {
            addCriterion("last_updated_by <=", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIn(List<Long> values) {
            addCriterion("last_updated_by in", values, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotIn(List<Long> values) {
            addCriterion("last_updated_by not in", values, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByBetween(Long value1, Long value2) {
            addCriterion("last_updated_by between", value1, value2, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotBetween(Long value1, Long value2) {
            addCriterion("last_updated_by not between", value1, value2, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNull() {
            addCriterion("last_update_date is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNotNull() {
            addCriterion("last_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateEqualTo(Date value) {
            addCriterion("last_update_date =", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotEqualTo(Date value) {
            addCriterion("last_update_date <>", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThan(Date value) {
            addCriterion("last_update_date >", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_date >=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThan(Date value) {
            addCriterion("last_update_date <", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("last_update_date <=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIn(List<Date> values) {
            addCriterion("last_update_date in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotIn(List<Date> values) {
            addCriterion("last_update_date not in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateBetween(Date value1, Date value2) {
            addCriterion("last_update_date between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("last_update_date not between", value1, value2, "lastUpdateDate");
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