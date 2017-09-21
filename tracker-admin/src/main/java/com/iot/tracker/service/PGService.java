package com.iot.tracker.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iot.tracker.core.manage.DataPackageLogManage;
import com.iot.tracker.core.manage.UserDeviceInfoManage;
import com.iot.tracker.core.vo.DataPackageLog;
import com.iot.tracker.core.vo.UserDeviceInfo;
import com.iot.tracker.dto.upstream.pg.PGPacketDto;

@Service
public class PGService {
	private Logger logger = LoggerFactory.getLogger(PGService.class);
	@Autowired
	private DataPackageLogManage dataPackageLogManage;
	@Autowired
	private UserDeviceInfoManage userdeviceInfoManage;
	
	
	@Transactional
	public void savePGMsg(PGPacketDto pgPacketDto){
		String userCode = getUserCode(pgPacketDto.getImei()+"");
		DataPackageLog dataPackageLog = buildDataPackageLog(pgPacketDto, userCode);
		dataPackageLogManage.saveDataPackageLog(dataPackageLog);
	}
	
	@Transactional
	public void updateUserDeviceLatLgt(PGPacketDto pgPacketDto){
		String userCode = getUserCode(pgPacketDto.getImei()+"");
		userdeviceInfoManage.updateUserDeviceInfo(buildUserDeviceInfo(pgPacketDto), userCode, pgPacketDto.getImei()+"");
	}
	
	private String getUserCode(String deviceCode){
		UserDeviceInfo userDeviceInfo = userdeviceInfoManage.findByDeviceCode(deviceCode);
		if(userDeviceInfo != null){
			return userDeviceInfo.getUserCode();
		}else{
			return null;
		}
	}
	
	private UserDeviceInfo buildUserDeviceInfo(PGPacketDto pgPacketDto){
		UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
		userDeviceInfo.setLat(Double.valueOf(pgPacketDto.getLat()));
		userDeviceInfo.setLgt(Double.valueOf(pgPacketDto.getLng()));
		userDeviceInfo.setUpdateTime(new Date());
		return userDeviceInfo;
	}
	
	private DataPackageLog buildDataPackageLog(PGPacketDto pgPacketDto,String userCode){
		DataPackageLog dataPackageLog = new DataPackageLog();
		dataPackageLog.setBluetoothLockStatus(Integer.valueOf(pgPacketDto.getBluetoothLockStatus()));
		dataPackageLog.setDataType("0000");
		dataPackageLog.setDeviceCode(pgPacketDto.getImei()+"");
		dataPackageLog.seteDoorSwitchStatus(Integer.valueOf(pgPacketDto.getEDoorSwitchStatus()));
		dataPackageLog.setHight(Integer.valueOf(pgPacketDto.getHight()));
		dataPackageLog.setLat(Double.valueOf(pgPacketDto.getLat()));
		dataPackageLog.setLgt(Double.valueOf(pgPacketDto.getLng()));
		dataPackageLog.setPowerStatus(Integer.valueOf(pgPacketDto.getPowerStatus()));
		dataPackageLog.setSilentModeStatus(Integer.valueOf(pgPacketDto.getSilentModeStatus()));
		dataPackageLog.setSpeed(Double.valueOf(pgPacketDto.getSpeed()));
		dataPackageLog.setStar(Integer.valueOf(pgPacketDto.getStar()));
		dataPackageLog.setStatus(Integer.valueOf(pgPacketDto.getStatus()));
		dataPackageLog.setTime(Integer.valueOf(pgPacketDto.getTime()));
		dataPackageLog.setCreatedTime(new Date());
		dataPackageLog.setUpdateTime(new Date());
		dataPackageLog.setUserCode(userCode);
		return dataPackageLog;
	}
	
	public UserDeviceInfo buildUserDeviceInfo(PGPacketDto pgPacketDto,String userCode){
		UserDeviceInfo userDeviceInfo = new UserDeviceInfo();
		userDeviceInfo.setLat(Double.valueOf(pgPacketDto.getLat()));
		userDeviceInfo.setLgt(Double.valueOf(pgPacketDto.getLng()));
		userDeviceInfo.setUpdateTime(new Date());
		return userDeviceInfo;
	}
}
