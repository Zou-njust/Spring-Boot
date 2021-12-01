package edu.njust.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BasicAttributes {

    private String TargetID; // 目标编号
    private String PointID; // 当前航点号
    private double Longitude; // 经度
    private double Latitude; // 纬度
    private double Height; // 高度
    private double Speed; // 速度
    private String StartPlace; // 起飞机场
    private String CountryCode; // 国家地区
    private Date UpdateTime; // 更新时间
}
