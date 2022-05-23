package edu.njust.mapper.mysql;

import edu.njust.model.mysql.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {


    //方法1：注解写sql语句
    @Select("select * from user")
    List<UserModel> select_();

    @Select("select table_name from information_schema.tables where table_schema='intention'")
    List<String> select_table();

    @Select("(select 'name','类别','国家地区') UNION (select* from ${tableName} into outfile 'D:/neo4j-community-3.5.28/import/mysql/temp.csv' FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\r\\n');")
    void out_file(@Param("tableName") String tableName);

    //方法2：映射到resources/mapper/_.xml文件
    List<UserModel> select();
    int insert(String username, String userpw);
    int delete(String username);
    int update(String username0, String username, String userpw);
}
