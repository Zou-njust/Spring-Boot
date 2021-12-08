package edu.njust.controller;

import edu.njust.dto.BasicAttributes;
import edu.njust.dto.RecogResult;
import edu.njust.model.Membership;
import edu.njust.model.TYpTargetRecog;
import edu.njust.model.UdpDataModel;
import edu.njust.service.TargetRecogService;
import edu.njust.udp.UdpPortListener;
import edu.njust.udp.UdpSender;
import edu.njust.utils.AutoRecogResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Scope("prototype")
@RequestMapping("/targetRecog")
@CrossOrigin
public class TargetRecogController {

    @Resource
    private TargetRecogService recogService;

    @GetMapping("/autoRecog")
    public AutoRecogResult autoRecog() {
        // 调用研判服务
        AutoRecogResult recogResult = new AutoRecogResult();
        recogResult.setTargetModel("E-8");
        recogResult.setTargetType(1);
        recogResult.setCountryCode("美国");
        recogResult.setStartPlace("嘉手那");
        // 生成属性符合概率
        return recogResult;
    }

    // 对接收的数据调用属性研判服务
    @GetMapping("/process")
    public void processData() {
        List<UdpDataModel> dataModelList = UdpPortListener.udpDataModelList;
        // 判断接收的数据是否位属性研判输入数据(空情态势数据)
        if(recogService.isBasisInfo(dataModelList)) {
            // 开始处理接收的数据，转化为算法输入

            // 判断并筛选有效数据字段（目标名称、速度、高度、地址码、注册码、目标rcs）、（典型航迹）、（战术战法）
            List<BasicAttributes> list = recogService.transferModel(dataModelList);
            // 调用身份属性研判算法

            // 调用第三方服务
        }
    }

    @PostMapping("/send")
    public void sendResult(@RequestBody TYpTargetRecog recog) {
        // 将结果转换为目标数据结构
//        recog.toString()
        // 发送到目标平台
        UdpSender sender = new UdpSender();
        sender.send(recog.toString());

    }
}
