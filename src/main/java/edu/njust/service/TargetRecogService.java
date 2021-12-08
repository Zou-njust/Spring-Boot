package edu.njust.service;
import edu.njust.dto.BasicAttributes;
import edu.njust.dto.RecogResult;
import edu.njust.model.TYpTargetRecog;
import edu.njust.model.UdpDataModel;

import java.util.List;

public interface TargetRecogService {

    // 输入基本属性研判目标飞机
    public RecogResult basicRecog(BasicAttributes params);

    // 输出综合研判概率
    public RecogResult finalRecog(List<RecogResult> resultSet);

    // 判断接收到的数据是否为空情态势数据
    public boolean isBasisInfo(List<UdpDataModel> dataModelList);
    // 提取有效字段并转换为性能参数数据结构
    public List<BasicAttributes> transferModel(List<UdpDataModel> dataModelList);

    // 调用性能参数匹配算法
    public RecogResult basicRecog(List<BasicAttributes> basicParams);

}
