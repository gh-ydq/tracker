package com.iot.tracker.core.dao;

import com.iot.tracker.core.vo.DataPackageLog;
import com.iot.tracker.core.vo.DataPackageLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataPackageLogMapper {
    int countByExample(DataPackageLogExample example);

    int deleteByExample(DataPackageLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataPackageLog record);

    int insertSelective(DataPackageLog record);

    List<DataPackageLog> selectByExample(DataPackageLogExample example);

    DataPackageLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataPackageLog record, @Param("example") DataPackageLogExample example);

    int updateByExample(@Param("record") DataPackageLog record, @Param("example") DataPackageLogExample example);

    int updateByPrimaryKeySelective(DataPackageLog record);

    int updateByPrimaryKey(DataPackageLog record);
}