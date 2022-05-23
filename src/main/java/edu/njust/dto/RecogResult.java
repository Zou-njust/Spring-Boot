package edu.njust.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 身份研判结果（机型+概率）
 */
@Getter
@Setter
public class RecogResult {

    private String TargetModel1;
    private float probability1;
    private String TargetModel2;
    private float probability2;
    private String TargetModel3;
    private float probability3;
    public void setType(String[] str){
        this.TargetModel1=str[0];
        this.TargetModel2=str[1];
        this.TargetModel3=str[2];
    }
    public void setPro(float[] pros){
        this.probability1=pros[0];
        this.probability2=pros[1];
        this.probability3=pros[2];
    }
}
