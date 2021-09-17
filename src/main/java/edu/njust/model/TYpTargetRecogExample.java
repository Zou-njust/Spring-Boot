package edu.njust.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TYpTargetRecogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TYpTargetRecogExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNull() {
            addCriterion("target_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("target_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdEqualTo(String value) {
            addCriterion("target_id =", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotEqualTo(String value) {
            addCriterion("target_id <>", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThan(String value) {
            addCriterion("target_id >", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(String value) {
            addCriterion("target_id >=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThan(String value) {
            addCriterion("target_id <", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(String value) {
            addCriterion("target_id <=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLike(String value) {
            addCriterion("target_id like", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotLike(String value) {
            addCriterion("target_id not like", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIn(List<String> values) {
            addCriterion("target_id in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotIn(List<String> values) {
            addCriterion("target_id not in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdBetween(String value1, String value2) {
            addCriterion("target_id between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotBetween(String value1, String value2) {
            addCriterion("target_id not between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNull() {
            addCriterion("target_type is null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNotNull() {
            addCriterion("target_type is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeEqualTo(Byte value) {
            addCriterion("target_type =", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotEqualTo(Byte value) {
            addCriterion("target_type <>", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThan(Byte value) {
            addCriterion("target_type >", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("target_type >=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThan(Byte value) {
            addCriterion("target_type <", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThanOrEqualTo(Byte value) {
            addCriterion("target_type <=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIn(List<Byte> values) {
            addCriterion("target_type in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotIn(List<Byte> values) {
            addCriterion("target_type not in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeBetween(Byte value1, Byte value2) {
            addCriterion("target_type between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("target_type not between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andPointIdIsNull() {
            addCriterion("point_id is null");
            return (Criteria) this;
        }

        public Criteria andPointIdIsNotNull() {
            addCriterion("point_id is not null");
            return (Criteria) this;
        }

        public Criteria andPointIdEqualTo(String value) {
            addCriterion("point_id =", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotEqualTo(String value) {
            addCriterion("point_id <>", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThan(String value) {
            addCriterion("point_id >", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThanOrEqualTo(String value) {
            addCriterion("point_id >=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThan(String value) {
            addCriterion("point_id <", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThanOrEqualTo(String value) {
            addCriterion("point_id <=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLike(String value) {
            addCriterion("point_id like", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotLike(String value) {
            addCriterion("point_id not like", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdIn(List<String> values) {
            addCriterion("point_id in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotIn(List<String> values) {
            addCriterion("point_id not in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdBetween(String value1, String value2) {
            addCriterion("point_id between", value1, value2, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotBetween(String value1, String value2) {
            addCriterion("point_id not between", value1, value2, "pointId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdIsNull() {
            addCriterion("aircraft_id is null");
            return (Criteria) this;
        }

        public Criteria andAircraftIdIsNotNull() {
            addCriterion("aircraft_id is not null");
            return (Criteria) this;
        }

        public Criteria andAircraftIdEqualTo(String value) {
            addCriterion("aircraft_id =", value, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdNotEqualTo(String value) {
            addCriterion("aircraft_id <>", value, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdGreaterThan(String value) {
            addCriterion("aircraft_id >", value, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdGreaterThanOrEqualTo(String value) {
            addCriterion("aircraft_id >=", value, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdLessThan(String value) {
            addCriterion("aircraft_id <", value, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdLessThanOrEqualTo(String value) {
            addCriterion("aircraft_id <=", value, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdLike(String value) {
            addCriterion("aircraft_id like", value, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdNotLike(String value) {
            addCriterion("aircraft_id not like", value, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdIn(List<String> values) {
            addCriterion("aircraft_id in", values, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdNotIn(List<String> values) {
            addCriterion("aircraft_id not in", values, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdBetween(String value1, String value2) {
            addCriterion("aircraft_id between", value1, value2, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andAircraftIdNotBetween(String value1, String value2) {
            addCriterion("aircraft_id not between", value1, value2, "aircraftId");
            return (Criteria) this;
        }

        public Criteria andTargetNameIsNull() {
            addCriterion("target_name is null");
            return (Criteria) this;
        }

        public Criteria andTargetNameIsNotNull() {
            addCriterion("target_name is not null");
            return (Criteria) this;
        }

        public Criteria andTargetNameEqualTo(String value) {
            addCriterion("target_name =", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameNotEqualTo(String value) {
            addCriterion("target_name <>", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameGreaterThan(String value) {
            addCriterion("target_name >", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameGreaterThanOrEqualTo(String value) {
            addCriterion("target_name >=", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameLessThan(String value) {
            addCriterion("target_name <", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameLessThanOrEqualTo(String value) {
            addCriterion("target_name <=", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameLike(String value) {
            addCriterion("target_name like", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameNotLike(String value) {
            addCriterion("target_name not like", value, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameIn(List<String> values) {
            addCriterion("target_name in", values, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameNotIn(List<String> values) {
            addCriterion("target_name not in", values, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameBetween(String value1, String value2) {
            addCriterion("target_name between", value1, value2, "targetName");
            return (Criteria) this;
        }

        public Criteria andTargetNameNotBetween(String value1, String value2) {
            addCriterion("target_name not between", value1, value2, "targetName");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansIsNull() {
            addCriterion("judge_means is null");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansIsNotNull() {
            addCriterion("judge_means is not null");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansEqualTo(Byte value) {
            addCriterion("judge_means =", value, "judgeMeans");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansNotEqualTo(Byte value) {
            addCriterion("judge_means <>", value, "judgeMeans");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansGreaterThan(Byte value) {
            addCriterion("judge_means >", value, "judgeMeans");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansGreaterThanOrEqualTo(Byte value) {
            addCriterion("judge_means >=", value, "judgeMeans");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansLessThan(Byte value) {
            addCriterion("judge_means <", value, "judgeMeans");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansLessThanOrEqualTo(Byte value) {
            addCriterion("judge_means <=", value, "judgeMeans");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansIn(List<Byte> values) {
            addCriterion("judge_means in", values, "judgeMeans");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansNotIn(List<Byte> values) {
            addCriterion("judge_means not in", values, "judgeMeans");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansBetween(Byte value1, Byte value2) {
            addCriterion("judge_means between", value1, value2, "judgeMeans");
            return (Criteria) this;
        }

        public Criteria andJudgeMeansNotBetween(Byte value1, Byte value2) {
            addCriterion("judge_means not between", value1, value2, "judgeMeans");
            return (Criteria) this;
        }

        public Criteria andProbabilityIsNull() {
            addCriterion("probability is null");
            return (Criteria) this;
        }

        public Criteria andProbabilityIsNotNull() {
            addCriterion("probability is not null");
            return (Criteria) this;
        }

        public Criteria andProbabilityEqualTo(Byte value) {
            addCriterion("probability =", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityNotEqualTo(Byte value) {
            addCriterion("probability <>", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityGreaterThan(Byte value) {
            addCriterion("probability >", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityGreaterThanOrEqualTo(Byte value) {
            addCriterion("probability >=", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityLessThan(Byte value) {
            addCriterion("probability <", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityLessThanOrEqualTo(Byte value) {
            addCriterion("probability <=", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityIn(List<Byte> values) {
            addCriterion("probability in", values, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityNotIn(List<Byte> values) {
            addCriterion("probability not in", values, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityBetween(Byte value1, Byte value2) {
            addCriterion("probability between", value1, value2, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityNotBetween(Byte value1, Byte value2) {
            addCriterion("probability not between", value1, value2, "probability");
            return (Criteria) this;
        }

        public Criteria andImportTimeIsNull() {
            addCriterion("import_time is null");
            return (Criteria) this;
        }

        public Criteria andImportTimeIsNotNull() {
            addCriterion("import_time is not null");
            return (Criteria) this;
        }

        public Criteria andImportTimeEqualTo(Date value) {
            addCriterion("import_time =", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotEqualTo(Date value) {
            addCriterion("import_time <>", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeGreaterThan(Date value) {
            addCriterion("import_time >", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("import_time >=", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLessThan(Date value) {
            addCriterion("import_time <", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLessThanOrEqualTo(Date value) {
            addCriterion("import_time <=", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeIn(List<Date> values) {
            addCriterion("import_time in", values, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotIn(List<Date> values) {
            addCriterion("import_time not in", values, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeBetween(Date value1, Date value2) {
            addCriterion("import_time between", value1, value2, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotBetween(Date value1, Date value2) {
            addCriterion("import_time not between", value1, value2, "importTime");
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