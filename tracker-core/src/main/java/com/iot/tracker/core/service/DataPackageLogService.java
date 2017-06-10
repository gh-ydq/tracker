package com.iot.tracker.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.tracker.core.dao.DataPackageLogMapper;
import com.iot.tracker.core.vo.DataPackageLog;
import com.iot.tracker.core.vo.DataPackageLogExample;

@Component
public class DataPackageLogService {
	@Autowired
	private DataPackageLogMapper dataPackageLogMapper;
	
	public List<DataPackageLog> queryDataPackageLog(String userCode,String deviceCode,Date startDatetime,Date endDatetime){
		DataPackageLogExample example = buildDataPackageLog(userCode, deviceCode, startDatetime, endDatetime);
		return dataPackageLogMapper.selectByExample(example);
	}
	
	private DataPackageLogExample buildDataPackageLog(String userCode,String deviceCode,Date startDatetime,Date endDatetime){
		DataPackageLogExample dataPackageLogExample = new DataPackageLogExample();
		dataPackageLogExample.createCriteria().andUserCodeEqualTo(userCode)
		.andDeviceCodeEqualTo(deviceCode)
		.andUpdateTimeLessThan(endDatetime)
		.andUpdateTimeGreaterThanOrEqualTo(startDatetime);
		return dataPackageLogExample;
	}
	
}
