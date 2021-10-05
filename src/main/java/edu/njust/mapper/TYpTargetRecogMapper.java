package edu.njust.mapper;

import edu.njust.model.TYpTargetRecog;
import edu.njust.model.TYpTargetRecogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TYpTargetRecogMapper {
    long countByExample(TYpTargetRecogExample example);

    int deleteByExample(TYpTargetRecogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TYpTargetRecog record);

    int insertSelective(TYpTargetRecog record);

    List<TYpTargetRecog> selectByExample(TYpTargetRecogExample example);

    TYpTargetRecog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TYpTargetRecog record, @Param("example") TYpTargetRecogExample example);

    int updateByExample(@Param("record") TYpTargetRecog record, @Param("example") TYpTargetRecogExample example);

    int updateByPrimaryKeySelective(TYpTargetRecog record);

    int updateByPrimaryKey(TYpTargetRecog record);
}