package com.iot.tracker.core.manage;

import org.springframework.stereotype.Component;

import com.iot.tracker.core.dao.DataPackageLogMapper;
import com.iot.tracker.core.vo.DataPackageLog;

@Component
public class DataPackageLogManage {
	private DataPackageLogMapper dataPackageLogMapper;
	
	public void saveDataPackageLog(DataPackageLog dataPackageLog){
		dataPackageLogMapper.insertSelective(dataPackageLog);
	}
}
