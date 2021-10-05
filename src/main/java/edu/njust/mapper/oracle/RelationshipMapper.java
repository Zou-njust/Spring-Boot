package edu.njust.mapper.oracle;

import edu.njust.model.oracle.Relationship;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RelationshipMapper {
    @Insert("INSERT INTO \"relationship\" (\"from\", \"to\") VALUES (#{from}, #{to})")
    int addRelationship(Relationship relationship);

    @Select("SELECT * FROM \"relationship\" WHERE \"to\"=#{to}")
    List<Relationship> findRelationshipByTo(int to);

}
