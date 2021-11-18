package edu.njust.service.impl;

import edu.njust.dto.BasicAttributes;
import edu.njust.dto.RecogResult;
import edu.njust.model.UdpDataModel;
import edu.njust.service.TargetRecogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TargetRecogServiceImpl implements TargetRecogService {

    @Override
    public RecogResult finalRecog(List<RecogResult> resultSet) {
        // 调用权值要素输出综合研判结果
        return null;
    }

    @Override
    public RecogResult basicRecog(BasicAttributes params) {
        // 调用目标飞机基本属性匹配算法输出基本属性研判概率
        return null;
    }

    /**
     * 判断udp数据是否为空情态势数据
     * @param dataModelList udp数据
     * @return boolean
     */
    @Override
    public boolean isBasisInfo(List<UdpDataModel> dataModelList) {
        return false;
    }

    /**
     * 提取有效字段，转换为性能参数数据结构
     * @param dataModelList udp数据
     * @return 目标性能参数
     */
    @Override
    public List<BasicAttributes> transferModel(List<UdpDataModel> dataModelList) {
        return new ArrayList<>();
    }

    /**
     * 调用性能参数匹配算法
     * @return 概率结果
     */
    @Override
    public RecogResult basicRecog(List<BasicAttributes> basicParams) {
        RecogResult result = new RecogResult();
        return result;
    }
}
