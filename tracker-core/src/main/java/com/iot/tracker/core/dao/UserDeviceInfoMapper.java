package com.iot.tracker.core.dao;

import com.iot.tracker.core.vo.UserDeviceInfo;
import com.iot.tracker.core.vo.UserDeviceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDeviceInfoMapper {
    int countByExample(UserDeviceInfoExample example);

    int deleteByExample(UserDeviceInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDeviceInfo record);

    int insertSelective(UserDeviceInfo record);

    List<UserDeviceInfo> selectByExample(UserDeviceInfoExample example);

    UserDeviceInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDeviceInfo record, @Param("example") UserDeviceInfoExample example);

    int updateByExample(@Param("record") UserDeviceInfo record, @Param("example") UserDeviceInfoExample example);

    int updateByPrimaryKeySelective(UserDeviceInfo record);

    int updateByPrimaryKey(UserDeviceInfo record);
}