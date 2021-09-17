package edu.njust.mapper;

import edu.njust.model.TGlTrackline;
import edu.njust.model.TGlTracklineExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TGlTracklineMapper {

    long countByExample(TGlTracklineExample example);

    int deleteByExample(TGlTracklineExample example);

    int deleteByPrimaryKey(String id);

    int insert(TGlTrackline record);

    int insertSelective(TGlTrackline record);

    List<TGlTrackline> selectByExample(TGlTracklineExample example);

    TGlTrackline selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TGlTrackline record, @Param("example") TGlTracklineExample example);

    int updateByExample(@Param("record") TGlTrackline record, @Param("example") TGlTracklineExample example);

    int updateByPrimaryKeySelective(TGlTrackline record);

    int updateByPrimaryKey(TGlTrackline record);
}