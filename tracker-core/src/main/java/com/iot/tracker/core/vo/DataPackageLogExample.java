package com.iot.tracker.core.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataPackageLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataPackageLogExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNull() {
            addCriterion("user_code is null");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNotNull() {
            addCriterion("user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUserCodeEqualTo(String value) {
            addCriterion("user_code =", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotEqualTo(String value) {
            addCriterion("user_code <>", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThan(String value) {
            addCriterion("user_code >", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_code >=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThan(String value) {
            addCriterion("user_code <", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThanOrEqualTo(String value) {
            addCriterion("user_code <=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLike(String value) {
            addCriterion("user_code like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotLike(String value) {
            addCriterion("user_code not like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeIn(List<String> values) {
            addCriterion("user_code in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotIn(List<String> values) {
            addCriterion("user_code not in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeBetween(String value1, String value2) {
            addCriterion("user_code between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotBetween(String value1, String value2) {
            addCriterion("user_code not between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIsNull() {
            addCriterion("device_code is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIsNotNull() {
            addCriterion("device_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeEqualTo(String value) {
            addCriterion("device_code =", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotEqualTo(String value) {
            addCriterion("device_code <>", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeGreaterThan(String value) {
            addCriterion("device_code >", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("device_code >=", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLessThan(String value) {
            addCriterion("device_code <", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLessThanOrEqualTo(String value) {
            addCriterion("device_code <=", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLike(String value) {
            addCriterion("device_code like", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotLike(String value) {
            addCriterion("device_code not like", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIn(List<String> values) {
            addCriterion("device_code in", values, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotIn(List<String> values) {
            addCriterion("device_code not in", values, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeBetween(String value1, String value2) {
            addCriterion("device_code between", value1, value2, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotBetween(String value1, String value2) {
            addCriterion("device_code not between", value1, value2, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andLgtIsNull() {
            addCriterion("lgt is null");
            return (Criteria) this;
        }

        public Criteria andLgtIsNotNull() {
            addCriterion("lgt is not null");
            return (Criteria) this;
        }

        public Criteria andLgtEqualTo(Double value) {
            addCriterion("lgt =", value, "lgt");
            return (Criteria) this;
        }

        public Criteria andLgtNotEqualTo(Double value) {
            addCriterion("lgt <>", value, "lgt");
            return (Criteria) this;
        }

        public Criteria andLgtGreaterThan(Double value) {
            addCriterion("lgt >", value, "lgt");
            return (Criteria) this;
        }

        public Criteria andLgtGreaterThanOrEqualTo(Double value) {
            addCriterion("lgt >=", value, "lgt");
            return (Criteria) this;
        }

        public Criteria andLgtLessThan(Double value) {
            addCriterion("lgt <", value, "lgt");
            return (Criteria) this;
        }

        public Criteria andLgtLessThanOrEqualTo(Double value) {
            addCriterion("lgt <=", value, "lgt");
            return (Criteria) this;
        }

        public Criteria andLgtIn(List<Double> values) {
            addCriterion("lgt in", values, "lgt");
            return (Criteria) this;
        }

        public Criteria andLgtNotIn(List<Double> values) {
            addCriterion("lgt not in", values, "lgt");
            return (Criteria) this;
        }

        public Criteria andLgtBetween(Double value1, Double value2) {
            addCriterion("lgt between", value1, value2, "lgt");
            return (Criteria) this;
        }

        public Criteria andLgtNotBetween(Double value1, Double value2) {
            addCriterion("lgt not between", value1, value2, "lgt");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andHightIsNull() {
            addCriterion("hight is null");
            return (Criteria) this;
        }

        public Criteria andHightIsNotNull() {
            addCriterion("hight is not null");
            return (Criteria) this;
        }

        public Criteria andHightEqualTo(Integer value) {
            addCriterion("hight =", value, "hight");
            return (Criteria) this;
        }

        public Criteria andHightNotEqualTo(Integer value) {
            addCriterion("hight <>", value, "hight");
            return (Criteria) this;
        }

        public Criteria andHightGreaterThan(Integer value) {
            addCriterion("hight >", value, "hight");
            return (Criteria) this;
        }

        public Criteria andHightGreaterThanOrEqualTo(Integer value) {
            addCriterion("hight >=", value, "hight");
            return (Criteria) this;
        }

        public Criteria andHightLessThan(Integer value) {
            addCriterion("hight <", value, "hight");
            return (Criteria) this;
        }

        public Criteria andHightLessThanOrEqualTo(Integer value) {
            addCriterion("hight <=", value, "hight");
            return (Criteria) this;
        }

        public Criteria andHightIn(List<Integer> values) {
            addCriterion("hight in", values, "hight");
            return (Criteria) this;
        }

        public Criteria andHightNotIn(List<Integer> values) {
            addCriterion("hight not in", values, "hight");
            return (Criteria) this;
        }

        public Criteria andHightBetween(Integer value1, Integer value2) {
            addCriterion("hight between", value1, value2, "hight");
            return (Criteria) this;
        }

        public Criteria andHightNotBetween(Integer value1, Integer value2) {
            addCriterion("hight not between", value1, value2, "hight");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("speed is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("speed is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(Double value) {
            addCriterion("speed =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(Double value) {
            addCriterion("speed <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(Double value) {
            addCriterion("speed >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(Double value) {
            addCriterion("speed >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(Double value) {
            addCriterion("speed <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(Double value) {
            addCriterion("speed <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<Double> values) {
            addCriterion("speed in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<Double> values) {
            addCriterion("speed not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(Double value1, Double value2) {
            addCriterion("speed between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(Double value1, Double value2) {
            addCriterion("speed not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andStarIsNull() {
            addCriterion("star is null");
            return (Criteria) this;
        }

        public Criteria andStarIsNotNull() {
            addCriterion("star is not null");
            return (Criteria) this;
        }

        public Criteria andStarEqualTo(Integer value) {
            addCriterion("star =", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotEqualTo(Integer value) {
            addCriterion("star <>", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThan(Integer value) {
            addCriterion("star >", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("star >=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThan(Integer value) {
            addCriterion("star <", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualTo(Integer value) {
            addCriterion("star <=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarIn(List<Integer> values) {
            addCriterion("star in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotIn(List<Integer> values) {
            addCriterion("star not in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarBetween(Integer value1, Integer value2) {
            addCriterion("star between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotBetween(Integer value1, Integer value2) {
            addCriterion("star not between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Integer value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Integer value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Integer value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Integer value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Integer value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Integer> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Integer> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Integer value1, Integer value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("time not between", value1, value2, "time");
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

        public Criteria andPowerStatusIsNull() {
            addCriterion("power_status is null");
            return (Criteria) this;
        }

        public Criteria andPowerStatusIsNotNull() {
            addCriterion("power_status is not null");
            return (Criteria) this;
        }

        public Criteria andPowerStatusEqualTo(Integer value) {
            addCriterion("power_status =", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusNotEqualTo(Integer value) {
            addCriterion("power_status <>", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusGreaterThan(Integer value) {
            addCriterion("power_status >", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("power_status >=", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusLessThan(Integer value) {
            addCriterion("power_status <", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusLessThanOrEqualTo(Integer value) {
            addCriterion("power_status <=", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusIn(List<Integer> values) {
            addCriterion("power_status in", values, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusNotIn(List<Integer> values) {
            addCriterion("power_status not in", values, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusBetween(Integer value1, Integer value2) {
            addCriterion("power_status between", value1, value2, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("power_status not between", value1, value2, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusIsNull() {
            addCriterion("e_door_switch_status is null");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusIsNotNull() {
            addCriterion("e_door_switch_status is not null");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusEqualTo(Integer value) {
            addCriterion("e_door_switch_status =", value, "eDoorSwitchStatus");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusNotEqualTo(Integer value) {
            addCriterion("e_door_switch_status <>", value, "eDoorSwitchStatus");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusGreaterThan(Integer value) {
            addCriterion("e_door_switch_status >", value, "eDoorSwitchStatus");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_door_switch_status >=", value, "eDoorSwitchStatus");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusLessThan(Integer value) {
            addCriterion("e_door_switch_status <", value, "eDoorSwitchStatus");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusLessThanOrEqualTo(Integer value) {
            addCriterion("e_door_switch_status <=", value, "eDoorSwitchStatus");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusIn(List<Integer> values) {
            addCriterion("e_door_switch_status in", values, "eDoorSwitchStatus");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusNotIn(List<Integer> values) {
            addCriterion("e_door_switch_status not in", values, "eDoorSwitchStatus");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusBetween(Integer value1, Integer value2) {
            addCriterion("e_door_switch_status between", value1, value2, "eDoorSwitchStatus");
            return (Criteria) this;
        }

        public Criteria andEDoorSwitchStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("e_door_switch_status not between", value1, value2, "eDoorSwitchStatus");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusIsNull() {
            addCriterion("silent_mode_status is null");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusIsNotNull() {
            addCriterion("silent_mode_status is not null");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusEqualTo(Integer value) {
            addCriterion("silent_mode_status =", value, "silentModeStatus");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusNotEqualTo(Integer value) {
            addCriterion("silent_mode_status <>", value, "silentModeStatus");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusGreaterThan(Integer value) {
            addCriterion("silent_mode_status >", value, "silentModeStatus");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("silent_mode_status >=", value, "silentModeStatus");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusLessThan(Integer value) {
            addCriterion("silent_mode_status <", value, "silentModeStatus");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("silent_mode_status <=", value, "silentModeStatus");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusIn(List<Integer> values) {
            addCriterion("silent_mode_status in", values, "silentModeStatus");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusNotIn(List<Integer> values) {
            addCriterion("silent_mode_status not in", values, "silentModeStatus");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusBetween(Integer value1, Integer value2) {
            addCriterion("silent_mode_status between", value1, value2, "silentModeStatus");
            return (Criteria) this;
        }

        public Criteria andSilentModeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("silent_mode_status not between", value1, value2, "silentModeStatus");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusIsNull() {
            addCriterion("bluetooth_lock_status is null");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusIsNotNull() {
            addCriterion("bluetooth_lock_status is not null");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusEqualTo(Integer value) {
            addCriterion("bluetooth_lock_status =", value, "bluetoothLockStatus");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusNotEqualTo(Integer value) {
            addCriterion("bluetooth_lock_status <>", value, "bluetoothLockStatus");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusGreaterThan(Integer value) {
            addCriterion("bluetooth_lock_status >", value, "bluetoothLockStatus");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bluetooth_lock_status >=", value, "bluetoothLockStatus");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusLessThan(Integer value) {
            addCriterion("bluetooth_lock_status <", value, "bluetoothLockStatus");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bluetooth_lock_status <=", value, "bluetoothLockStatus");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusIn(List<Integer> values) {
            addCriterion("bluetooth_lock_status in", values, "bluetoothLockStatus");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusNotIn(List<Integer> values) {
            addCriterion("bluetooth_lock_status not in", values, "bluetoothLockStatus");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusBetween(Integer value1, Integer value2) {
            addCriterion("bluetooth_lock_status between", value1, value2, "bluetoothLockStatus");
            return (Criteria) this;
        }

        public Criteria andBluetoothLockStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bluetooth_lock_status not between", value1, value2, "bluetoothLockStatus");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("data_type like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("data_type not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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