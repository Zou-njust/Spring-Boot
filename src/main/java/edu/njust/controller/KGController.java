package edu.njust.controller;

import edu.njust.api.CommonResult;
import edu.njust.entity.DataGraph;
import edu.njust.service.IKnowGraphControlService;
import edu.njust.vo.NodeVO;
import edu.njust.vo.RelationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("/KG")
@CrossOrigin
public class KGController {
    @Autowired
    IKnowGraphControlService service;
    //获取图谱页面
    @GetMapping("getGraph")
    public CommonResult<DataGraph<List<?>>> getSLGraph(@RequestParam(value = "domain") String domain) {
        long startTime = System.currentTimeMillis();
        //String property = "乘员";
        //String value = "4";
        List<NodeVO> node = service.queryNodeByLabel(domain);
        List<RelationVO> link = service.querySLRelation();
        long spanTime = System.currentTimeMillis() - startTime;
        System.out.println("节点：" + node);
        System.out.println("关系：" + link);
        return CommonResult.success(new DataGraph<>(node, link));
    }

}
