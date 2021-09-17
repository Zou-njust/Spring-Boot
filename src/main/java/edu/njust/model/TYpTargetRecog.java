package edu.njust.model;

import java.io.Serializable;
import java.util.Date;

public class TYpTargetRecog implements Serializable {
    private String id;

    private String targetId;

    private Byte targetType;

    private String pointId;

    private String aircraftId;

    private String targetName;

    private Byte judgeMeans;

    private Byte probability;

    private Date importTime;

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

    public Byte getTargetType() {
        return targetType;
    }

    public void setTargetType(Byte targetType) {
        this.targetType = targetType;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public Byte getJudgeMeans() {
        return judgeMeans;
    }

    public void setJudgeMeans(Byte judgeMeans) {
        this.judgeMeans = judgeMeans;
    }

    public Byte getProbability() {
        return probability;
    }

    public void setProbability(Byte probability) {
        this.probability = probability;
    }

    public Date getImportTime() {
        return importTime;
    }

    public void setImportTime(Date importTime) {
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
        sb.append(", targetType=").append(targetType);
        sb.append(", pointId=").append(pointId);
        sb.append(", aircraftId=").append(aircraftId);
        sb.append(", targetName=").append(targetName);
        sb.append(", judgeMeans=").append(judgeMeans);
        sb.append(", probability=").append(probability);
        sb.append(", importTime=").append(importTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}