package com.iot.tracker.core.vo;

import java.util.Date;

public class DataPackageLog {
    private Integer id;

    private String userCode;

    private String deviceCode;

    private Double lgt;

    private Double lat;

    private Integer hight;

    private Double speed;

    private Integer star;

    private Integer time;

    private Integer status;

    private Integer powerStatus;

    private Integer eDoorSwitchStatus;

    private Integer silentModeStatus;

    private Integer bluetoothLockStatus;

    private String dataType;

    private Date createdTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public Double getLgt() {
        return lgt;
    }

    public void setLgt(Double lgt) {
        this.lgt = lgt;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getHight() {
        return hight;
    }

    public void setHight(Integer hight) {
        this.hight = hight;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(Integer powerStatus) {
        this.powerStatus = powerStatus;
    }

    public Integer geteDoorSwitchStatus() {
        return eDoorSwitchStatus;
    }

    public void seteDoorSwitchStatus(Integer eDoorSwitchStatus) {
        this.eDoorSwitchStatus = eDoorSwitchStatus;
    }

    public Integer getSilentModeStatus() {
        return silentModeStatus;
    }

    public void setSilentModeStatus(Integer silentModeStatus) {
        this.silentModeStatus = silentModeStatus;
    }

    public Integer getBluetoothLockStatus() {
        return bluetoothLockStatus;
    }

    public void setBluetoothLockStatus(Integer bluetoothLockStatus) {
        this.bluetoothLockStatus = bluetoothLockStatus;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}