package edu.njust.mapper;

import edu.njust.model.TGlTrackline;
import edu.njust.model.TGlTracklineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGlTracklineMapper {
    long countByExample(TGlTracklineExample example);

    int deleteByExample(TGlTracklineExample example);

    int insert(TGlTrackline record);

    int insertSelective(TGlTrackline record);

    List<TGlTrackline> selectByExample(TGlTracklineExample example);

    int updateByExampleSelective(@Param("record") TGlTrackline record, @Param("example") TGlTracklineExample example);

    int updateByExample(@Param("record") TGlTrackline record, @Param("example") TGlTracklineExample example);
}