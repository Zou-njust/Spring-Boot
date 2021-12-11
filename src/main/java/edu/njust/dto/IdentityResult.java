package edu.njust.dto;

import edu.njust.udp.udpmodel.IdentityModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 身份属性研判结果消息发送内容
 */
@Getter
@Setter
public class IdentityResult {
    String TargetID; // 目标批号
    String TargetSendSerialNum; // 当前航点号
    byte mbNum; // 研判目标个数N
    IdentityModel[] modelList;
}
