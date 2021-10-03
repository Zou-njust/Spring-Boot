package edu.njust.model;

import java.util.ArrayList;
import java.util.List;

public class TGlTracklineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TGlTracklineExample() {
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

        public Criteria andTargetSortIsNull() {
            addCriterion("target_sort is null");
            return (Criteria) this;
        }

        public Criteria andTargetSortIsNotNull() {
            addCriterion("target_sort is not null");
            return (Criteria) this;
        }

        public Criteria andTargetSortEqualTo(String value) {
            addCriterion("target_sort =", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortNotEqualTo(String value) {
            addCriterion("target_sort <>", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortGreaterThan(String value) {
            addCriterion("target_sort >", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortGreaterThanOrEqualTo(String value) {
            addCriterion("target_sort >=", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortLessThan(String value) {
            addCriterion("target_sort <", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortLessThanOrEqualTo(String value) {
            addCriterion("target_sort <=", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortLike(String value) {
            addCriterion("target_sort like", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortNotLike(String value) {
            addCriterion("target_sort not like", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortIn(List<String> values) {
            addCriterion("target_sort in", values, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortNotIn(List<String> values) {
            addCriterion("target_sort not in", values, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortBetween(String value1, String value2) {
            addCriterion("target_sort between", value1, value2, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortNotBetween(String value1, String value2) {
            addCriterion("target_sort not between", value1, value2, "targetSort");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdIsNull() {
            addCriterion("takeoff_airport_id is null");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdIsNotNull() {
            addCriterion("takeoff_airport_id is not null");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdEqualTo(String value) {
            addCriterion("takeoff_airport_id =", value, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdNotEqualTo(String value) {
            addCriterion("takeoff_airport_id <>", value, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdGreaterThan(String value) {
            addCriterion("takeoff_airport_id >", value, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdGreaterThanOrEqualTo(String value) {
            addCriterion("takeoff_airport_id >=", value, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdLessThan(String value) {
            addCriterion("takeoff_airport_id <", value, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdLessThanOrEqualTo(String value) {
            addCriterion("takeoff_airport_id <=", value, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdLike(String value) {
            addCriterion("takeoff_airport_id like", value, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdNotLike(String value) {
            addCriterion("takeoff_airport_id not like", value, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdIn(List<String> values) {
            addCriterion("takeoff_airport_id in", values, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdNotIn(List<String> values) {
            addCriterion("takeoff_airport_id not in", values, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdBetween(String value1, String value2) {
            addCriterion("takeoff_airport_id between", value1, value2, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andTakeoffAirportIdNotBetween(String value1, String value2) {
            addCriterion("takeoff_airport_id not between", value1, value2, "takeoffAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdIsNull() {
            addCriterion("landing_airport_id is null");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdIsNotNull() {
            addCriterion("landing_airport_id is not null");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdEqualTo(String value) {
            addCriterion("landing_airport_id =", value, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdNotEqualTo(String value) {
            addCriterion("landing_airport_id <>", value, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdGreaterThan(String value) {
            addCriterion("landing_airport_id >", value, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdGreaterThanOrEqualTo(String value) {
            addCriterion("landing_airport_id >=", value, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdLessThan(String value) {
            addCriterion("landing_airport_id <", value, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdLessThanOrEqualTo(String value) {
            addCriterion("landing_airport_id <=", value, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdLike(String value) {
            addCriterion("landing_airport_id like", value, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdNotLike(String value) {
            addCriterion("landing_airport_id not like", value, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdIn(List<String> values) {
            addCriterion("landing_airport_id in", values, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdNotIn(List<String> values) {
            addCriterion("landing_airport_id not in", values, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdBetween(String value1, String value2) {
            addCriterion("landing_airport_id between", value1, value2, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andLandingAirportIdNotBetween(String value1, String value2) {
            addCriterion("landing_airport_id not between", value1, value2, "landingAirportId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdIsNull() {
            addCriterion("task_action_area_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdIsNotNull() {
            addCriterion("task_action_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdEqualTo(String value) {
            addCriterion("task_action_area_id =", value, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdNotEqualTo(String value) {
            addCriterion("task_action_area_id <>", value, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdGreaterThan(String value) {
            addCriterion("task_action_area_id >", value, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_action_area_id >=", value, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdLessThan(String value) {
            addCriterion("task_action_area_id <", value, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdLessThanOrEqualTo(String value) {
            addCriterion("task_action_area_id <=", value, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdLike(String value) {
            addCriterion("task_action_area_id like", value, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdNotLike(String value) {
            addCriterion("task_action_area_id not like", value, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdIn(List<String> values) {
            addCriterion("task_action_area_id in", values, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdNotIn(List<String> values) {
            addCriterion("task_action_area_id not in", values, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdBetween(String value1, String value2) {
            addCriterion("task_action_area_id between", value1, value2, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andTaskActionAreaIdNotBetween(String value1, String value2) {
            addCriterion("task_action_area_id not between", value1, value2, "taskActionAreaId");
            return (Criteria) this;
        }

        public Criteria andSavePathIsNull() {
            addCriterion("save_path is null");
            return (Criteria) this;
        }

        public Criteria andSavePathIsNotNull() {
            addCriterion("save_path is not null");
            return (Criteria) this;
        }

        public Criteria andSavePathEqualTo(String value) {
            addCriterion("save_path =", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotEqualTo(String value) {
            addCriterion("save_path <>", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathGreaterThan(String value) {
            addCriterion("save_path >", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathGreaterThanOrEqualTo(String value) {
            addCriterion("save_path >=", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathLessThan(String value) {
            addCriterion("save_path <", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathLessThanOrEqualTo(String value) {
            addCriterion("save_path <=", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathLike(String value) {
            addCriterion("save_path like", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotLike(String value) {
            addCriterion("save_path not like", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathIn(List<String> values) {
            addCriterion("save_path in", values, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotIn(List<String> values) {
            addCriterion("save_path not in", values, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathBetween(String value1, String value2) {
            addCriterion("save_path between", value1, value2, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotBetween(String value1, String value2) {
            addCriterion("save_path not between", value1, value2, "savePath");
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

        public Criteria andImportTimeEqualTo(String value) {
            addCriterion("import_time =", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotEqualTo(String value) {
            addCriterion("import_time <>", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeGreaterThan(String value) {
            addCriterion("import_time >", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeGreaterThanOrEqualTo(String value) {
            addCriterion("import_time >=", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLessThan(String value) {
            addCriterion("import_time <", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLessThanOrEqualTo(String value) {
            addCriterion("import_time <=", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeLike(String value) {
            addCriterion("import_time like", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotLike(String value) {
            addCriterion("import_time not like", value, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeIn(List<String> values) {
            addCriterion("import_time in", values, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotIn(List<String> values) {
            addCriterion("import_time not in", values, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeBetween(String value1, String value2) {
            addCriterion("import_time between", value1, value2, "importTime");
            return (Criteria) this;
        }

        public Criteria andImportTimeNotBetween(String value1, String value2) {
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