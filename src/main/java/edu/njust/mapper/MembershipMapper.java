package edu.njust.mapper;

import edu.njust.model.Membership;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MembershipMapper {

    @Select("select * from BN.Membership")
    List<Membership> selectAll();
}
