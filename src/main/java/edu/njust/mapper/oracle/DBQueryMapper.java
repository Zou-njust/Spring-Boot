package edu.njust.mapper.oracle;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.sql.ResultSet;
import java.util.List;

@Mapper
@Repository
public interface DBQueryMapper {

    List<String> TableNameQuery();

    List<String> ColumnQuery(String table_name);

    @Select("SELECT \"ID\" FROM ${TableName}")
    List<String> getIdValue(String TableName);

    @Select("SELECT * FROM ${TableName}")
    List<String> getAllValue(String TableName);

    @Select("SELECT * FROM ${TableName} WHERE \"ID\" = ${ID} ")
    List<String> getValueByID(String TableName,String ID);

    @Select("SELECT  ${ColumnName}  FROM ${TableName} ")
    List<String> getColValue(String ColumnName,String TableName);
}
