package edu.njust.controller;

import edu.njust.api.CommonResult;
import edu.njust.dto.BasicAttributes;
import edu.njust.dto.IdentityResult;
import edu.njust.dto.RecogResult;
import edu.njust.entity.PbMsg;
import edu.njust.model.Membership;
import edu.njust.model.TYpTargetRecog;
import edu.njust.model.UdpDataModel;
import edu.njust.service.TargetRecogService;
import edu.njust.udp.UdpPortListener;
import edu.njust.udp.UdpSender;
import edu.njust.udp.UdpResultData;
import edu.njust.udp.udpmodel.IdentityModel;
import edu.njust.utils.AutoRecogResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


@RestController
@Scope("prototype")
@RequestMapping("/targetRecog")
@CrossOrigin
public class TargetRecogController {

    @Autowired
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
    public void processData() throws ParseException {
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
    public void sendResult(@RequestBody IdentityResult result) {
        //创建身份属性研判结果发送帧
        UdpResultData message = new UdpResultData();
        message.createHead(164, (short)18000, (short)18001, (byte)1, new Date().getTime());
        message.createIdentityBody(result.getTargetID(), result.getTargetSendSerialNum(), result.getMbNum(), result.getModelList());
        message.createTail();
        // 消息结果组装成字节流发送到目标平台
        UdpSender sender = new UdpSender();
        sender.send(message.assembleByte());
    }

    @GetMapping("judgeType")
    public CommonResult<RecogResult> judgeType(@RequestParam(value="longitude") float longitude,
                             @RequestParam(value="latitude") float latitude,
                             @RequestParam(value="height") float height,
                             @RequestParam(value="speed") float speed,
                             @RequestParam(value="pbModel") String pbModel){
        BasicAttributes input=new BasicAttributes(longitude,latitude,height,speed);
        RecogResult res= null;
        try {
            res = recogService.typeRecog(input,pbModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.success(res);
    }

    @GetMapping("getPbList")
    public CommonResult<List<PbMsg>> getPbList(@RequestParam(value="pageNum") int pageNum){
        List<PbMsg> res = recogService.getPbList(pageNum);
//        for(PbMsg pbMsg:res){
//            System.out.println(pbMsg.getName()+" "+pbMsg.getTimeString());
//        }
        return CommonResult.success(res);
    }

    @GetMapping("getTotal")
    public CommonResult<Integer> getTotal(){
        return CommonResult.success(recogService.getTotal());
    }
}
