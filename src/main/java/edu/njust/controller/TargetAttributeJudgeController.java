package edu.njust.controller;

import edu.njust.algorithm.TreeNode;
import edu.njust.model.TGlTrackline;
import edu.njust.model.TYpTargetRecog;
import edu.njust.service.TYpTargetRecogService;
import edu.njust.service.TargetAttributeJudgeService;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Scope("prototype")
@RequestMapping("/targetJudge")
@CrossOrigin
public class TargetAttributeJudgeController {

    @Resource
    private TargetAttributeJudgeService judgeService;
    @Resource
    private TYpTargetRecogService targetRecogService;

    @GetMapping("select")
    public List<TGlTrackline> select() {
        return judgeService.get();
    }

    @PostMapping("/trainDt")
    public void train(@RequestParam(value = "data_path") String data_path, @RequestParam(value = "targetAttr") String targetAttr) {
        judgeService.trainDt(data_path, targetAttr);
    }

    @PostMapping("/judgeMb")
    public TYpTargetRecog judge(@RequestBody TGlTrackline trackline) {
        // 构建决策树
        TreeNode node = new TreeNode();
        // 决策树预测
        Map<String, String> map = new HashMap<>();
        if(trackline != null) {
            BeanMap beanMap = BeanMap.create(trackline);
            for(Object key :beanMap.keySet()) {
                map.put(key+"", (String) beanMap.get(key));
            }
        }
        String targetValue = judgeService.predictAttr(map, node);
        return targetRecogService.getResult(targetValue);
    }
}
