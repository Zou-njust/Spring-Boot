package edu.njust.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class SubmitInfo implements Serializable {
    private String RelationName;
    private String StartType;
    private String EndType;
    private String StartTableName;
    private String EndingTableName;
    private HashMap<Integer,MappingValue> map;
    private List<String> StartList;
    private List<String> EndingList;


    public String getRelationName() {
        return RelationName;
    }

    public void setRelationName(String relationName) {
        RelationName = relationName;
    }

    public String getType() {
        return StartType;
    }

    public void setType(String startType) {
        StartType = startType;
    }

    public String getEndType() {
        return EndType;
    }

    public void setEndType(String endType) {
        EndType = endType;
    }

    public String getStartTableName() {
        return StartTableName;
    }

    public void setStartTableName(String startTableName) {
        StartTableName = startTableName;
    }

    public String getEndingTableName() {
        return EndingTableName;
    }

    public void setEndingTableName(String endingTableName) {
        EndingTableName = endingTableName;
    }

    public HashMap<Integer, MappingValue> getMap() {
        return map;
    }

    public void setMap(HashMap<Integer, MappingValue> map) {
        this.map = map;
    }

    public List<String> getStartList() {
        return StartList;
    }

    public void setStartList(List<String> startList) {
        StartList = startList;
    }

    public List<String> getEndingList() {
        return EndingList;
    }

    public void setEndingList(List<String> endingList) {
        EndingList = endingList;
    }
}
