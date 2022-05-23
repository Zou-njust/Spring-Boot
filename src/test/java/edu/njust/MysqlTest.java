package edu.njust;

import edu.njust.mapper.mysql.UserMapper;
import edu.njust.model.mysql.UserModel;
import edu.njust.service.IKnowGraphControlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MysqlTest {
    @Autowired
    IKnowGraphControlService service;
    @Autowired
    UserMapper userMapper;
    @Test
    void linkMysql(){
        List<String> tableNames=userMapper.select_table();
        for(String tableName:tableNames){
            System.out.println(tableName);
        }
    }
}
