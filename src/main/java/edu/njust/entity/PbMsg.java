package edu.njust.entity;

public class PbMsg {
    private String name;
    private String timeString;
    public PbMsg(String name,String timeString){
        this.name=name;
        this.timeString=timeString;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setTimeString(String timeString) {
//        this.timeString = timeString;
//    }
//
    public String getName() {
        return name;
    }

    public String getTimeString() {
        return timeString;
    }
}
