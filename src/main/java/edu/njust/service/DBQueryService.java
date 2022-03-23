package edu.njust.service;

import edu.njust.mapper.oracle.DBQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class DBQueryService {
    @Autowired
    private DBQueryMapper dbQuery;

    public List<String> TableNameQuery()
    {
        return dbQuery.TableNameQuery();
    }

    public List<String> ColumnQuery(String TableName)
    {
        return dbQuery.ColumnQuery(TableName);
    }

    public List<String> getIdValue(String TableName){return dbQuery.getIdValue(TableName);}

    public List<String> getValueByID(String TableName,String ID){return dbQuery.getValueByID(TableName,ID);}

    public List<String> getColValue(String ColumnName,String TableName) {return dbQuery.getColValue(ColumnName,TableName);}

}
