package edu.njust.service;

import edu.njust.algorithm.TreeNode;
import edu.njust.model.TGlTrackline;
import edu.njust.mapper.TGlTracklineMapper;
import edu.njust.mapper.TYpTargetRecogMapper;
import edu.njust.model.TGlTracklineExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class TargetAttributeJudgeService {

    @Resource
    private TGlTracklineMapper tracklineMapper;

    @Resource
    private TYpTargetRecogMapper targetRecogMapper;

    // 获取典型航线数据集
    public List<TGlTrackline> get() {
        return tracklineMapper.selectByExample(new TGlTracklineExample());
    }

    // 训练决策树
    public TreeNode trainDt(String data_path, String targetAttr){
        return new TreeNode();
    }

    // 基于典型航线研判MB属性
    public String predictAttr(Map<String, String> map, TreeNode node) {
        List<TreeNode> childList = node.getChildTreeNode();
        if(childList != null){
            if(childList.size() == 0) {
                return node.getTargetValue();
            }
            String value = map.get(childList.get(0).getAttributeName());
            for(TreeNode next : childList) {
                String t = next.getAttributeValue();
                if(value.compareTo(t) == 0) {
                    predictAttr(map,next);
                }
            }
            return node.getTargetValue();
        }
        else return null;
    }

    //
}
