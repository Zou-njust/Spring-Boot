package edu.njust.model;

import java.io.Serializable;

public class TGlTrackline implements Serializable {
    private String id;

    private String targetId;

    private String targetSort;

    private String name;

    private String takeoffAirportId;

    private String landingAirportId;

    private String taskActionAreaId;

    private String savePath;

    private String importTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetSort() {
        return targetSort;
    }

    public void setTargetSort(String targetSort) {
        this.targetSort = targetSort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTakeoffAirportId() {
        return takeoffAirportId;
    }

    public void setTakeoffAirportId(String takeoffAirportId) {
        this.takeoffAirportId = takeoffAirportId;
    }

    public String getLandingAirportId() {
        return landingAirportId;
    }

    public void setLandingAirportId(String landingAirportId) {
        this.landingAirportId = landingAirportId;
    }

    public String getTaskActionAreaId() {
        return taskActionAreaId;
    }

    public void setTaskActionAreaId(String taskActionAreaId) {
        this.taskActionAreaId = taskActionAreaId;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getImportTime() {
        return importTime;
    }

    public void setImportTime(String importTime) {
        this.importTime = importTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", targetId=").append(targetId);
        sb.append(", targetSort=").append(targetSort);
        sb.append(", name=").append(name);
        sb.append(", takeoffAirportId=").append(takeoffAirportId);
        sb.append(", landingAirportId=").append(landingAirportId);
        sb.append(", taskActionAreaId=").append(taskActionAreaId);
        sb.append(", savePath=").append(savePath);
        sb.append(", importTime=").append(importTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}