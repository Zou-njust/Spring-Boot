package edu.njust.service;

import java.util.List;

public interface OracleToGroupService {

    public int createNode(String type,String TableName, String StartID ,List<String> PropertiesName);

    public void createRelation(Integer StartNode,String RelationName, Integer EndNode);
}
