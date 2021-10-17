package edu.njust.controller;

import com.alibaba.fastjson.JSON;
import edu.njust.api.CommonResult;
import edu.njust.entity.DataGraph;
import edu.njust.entity.QAEntityItem;
import edu.njust.service.IKnowGraphControlService;
import edu.njust.vo.NodeVO;
import edu.njust.vo.RelationVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<NodeVO> node = service.queryNodeByLabel(domain);
        List<RelationVO> link = service.queryDomainRelation(domain);
        long spanTime = System.currentTimeMillis() - startTime;
        System.out.println("节点：" + node);
        System.out.println("关系：" + link);
        return CommonResult.success(new DataGraph<>(node, link));
    }
    @GetMapping("searchNodeById")
    public CommonResult<NodeVO> searchNodeById(@RequestParam(value = "id") String id) {
        return CommonResult.success(service.queryNode(Integer.parseInt(id)));
    }
    @GetMapping("createNode")
    public CommonResult<NodeVO> createNode(@RequestParam(value = "domain") String domain,@RequestParam(value = "name")String name,
                           @RequestParam(value = "type")String type,
                           @RequestParam(value = "property") String property
    ) {
        System.out.println(domain+ "    " + name + "    " + property);
        Map<String,Object> maps = (Map) JSON.parse(property);
        maps.put("name",name);
        Integer newId =  service.createNode(domain,type, maps);
        NodeVO nodeVO = service.queryNode(newId);
        return CommonResult.success(nodeVO);

    }
    @GetMapping("createRel")
    public CommonResult<RelationVO> createRel(@RequestParam(value = "source") String source,
                                              @RequestParam(value = "target") String target,
                                              @RequestParam(value = "name") String name,
                                              @RequestParam(value = "domain") String domain){
        return CommonResult.success(service.creteRel(domain,source,target,name));
    }
    @DeleteMapping("node")
    public CommonResult<Boolean> deleteNodeById(@RequestParam(value = "id") Integer nodeId) {
        return CommonResult.success(service.deleteNode(nodeId));
    }

    @DeleteMapping("rel")
    public CommonResult<Boolean> deleteRelById(@RequestParam(value = "id") Integer id) {
        return CommonResult.success(service.deleteRel(id));
    }
}