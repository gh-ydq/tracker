package com.iot.tracker.core.manage;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.tracker.core.dao.DataPackageLogMapper;
import com.iot.tracker.core.service.DataPackageLogService;
import com.iot.tracker.core.util.DateUtil;
import com.iot.tracker.core.vo.DataPackageLog;

@Component
public class DataPackageLogManage {
	@Autowired
	private DataPackageLogMapper dataPackageLogMapper;
	@Autowired
	private DataPackageLogService dataPackageLogService;
	
	public void saveDataPackageLog(DataPackageLog dataPackageLog){
		dataPackageLogMapper.insertSelective(dataPackageLog);
	}
	
	public List<DataPackageLog> queryDataPackageLog(String userCode,String deviceCode){
		Date currentDate = new Date();
		return dataPackageLogService.queryDataPackageLog(userCode, deviceCode, DateUtil.truncate(currentDate), DateUtil.truncate(DateUtil.addDay(currentDate, 1)));
	}
}
