package edu.njust.controller;

import com.alibaba.fastjson.JSON;
import edu.njust.api.CommonResult;
import edu.njust.entity.DataGraph;
import edu.njust.entity.QAEntityItem;
import edu.njust.service.IKnowGraphControlService;
import edu.njust.vo.GraphVO;
import edu.njust.vo.NodeVO;
import edu.njust.vo.RelationVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Relation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        //System.out.println("节点：" + node);
        System.out.println("关系：" + link);
        return CommonResult.success(new DataGraph<>(node, link));
    }
//    @GetMapping("searchNodeByName")
//    public CommonResult<List<NodeVO>> getProperties(@RequestParam(value = "label") String label,
//                                                    @RequestParam(value = "property") String property,
//                                                    @RequestParam(value = "value") String value) {
//        return CommonResult.success(service.findNodeByName(label, property, value));
//    }
    @GetMapping("searchNodeByName")
    public CommonResult<NodeVO> searchNodeByName(@RequestParam(value = "domain") String domain,@RequestParam(value="name") String name){
        return CommonResult.success(service.queryNode(domain,name));
    }

    //返回查询结果一跳关系结果
    @GetMapping("searchByKeyword")
    public CommonResult<GraphVO> searchByKeyword(@RequestParam(value = "domain") String domain,@RequestParam(value = "keyword") String keyword) {
//        System.out.println("输出"+CommonResult.success(service.oneHipONGQuery(service.searchByKeyword(domain,keyword))).getData().getNodes().get(0).getName());
        return CommonResult.success(service.oneHipONGQuery(service.searchByKeyword(domain,keyword)));
    }
    @GetMapping("getLabel")
    public CommonResult<Set<String>> getLabel(@RequestParam(value = "domain") String domain) {
        return CommonResult.success(service.getLabel(domain));
    }
    @GetMapping("getRelLabel")
    public CommonResult<Set<String>> getRelLabel(@RequestParam(value = "domain") String domain) {
        return CommonResult.success(service.getRelLabel(domain));
    }
    @GetMapping("getLabelProperty")
    public CommonResult<Set<String>> getLabelProperty(@RequestParam(value = "domain") String domain, @RequestParam(value = "label") String label){
        return CommonResult.success(service.getLabelProperty(domain,label));
    }
    @GetMapping("searchNodeById")
    public CommonResult<NodeVO> searchNodeById(@RequestParam(value = "id") String id) {
        return CommonResult.success(service.queryNode(Integer.parseInt(id)));
    }
    @GetMapping("searchByProperty")
    public CommonResult<List<NodeVO>> searchByProperty(@RequestParam(value = "domain") String domain, @RequestParam(value = "label") String label, @RequestParam(value = "property") String property, @RequestParam(value = "propertyInput") String propertyInput) {
        return CommonResult.success(service.searchByProperty(domain,label,property,propertyInput));
    }
    @GetMapping("searchByRel")
    public CommonResult<DataGraph<List<?>>> searchByRel(@RequestParam(value = "domain") String domain, @RequestParam(value = "relName") String relName){
        GraphVO graphVO = service.searchByRel(domain,relName);
        List<NodeVO> node = graphVO.getNodes();
        List<RelationVO> link = graphVO.getLinks();
        System.out.println("节点：" + node);
        System.out.println("关系：" + link);
        return CommonResult.success(new DataGraph<>(node, link));
    }
    @GetMapping("searchNodeAndRel")
    public CommonResult<DataGraph<List<?>>> searchNodeAndRel(@RequestParam(value = "id") String id,
                                                  @RequestParam(value = "domain") String domain) {
        GraphVO graphVO = service.queryNodeNeighbour(id, domain);
        List<NodeVO> node = graphVO.getNodes();
        List<RelationVO> link = graphVO.getLinks();
        //System.out.println("节点：" + node);
        //System.out.println("关系：" + link);
        return CommonResult.success(new DataGraph<>(node, link));
    }
    @PostMapping("createNode")
    public CommonResult<NodeVO> createNode(@RequestParam(value = "domain") String domain,@RequestParam(value = "name")String name, @RequestParam(value = "type")String type, @RequestBody String property) {
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
        return CommonResult.success(service.createRel(domain,source,target,name));
    }
    @DeleteMapping("node")
    public CommonResult<Boolean> deleteNodeById(@RequestParam(value = "id") Integer nodeId) {
        return CommonResult.success(service.deleteNode(nodeId));
    }

    @DeleteMapping("rel")
    public CommonResult<Boolean> deleteRelById(@RequestParam(value = "id") Integer id) {
        return CommonResult.success(service.deleteRel(id));
    }
    @PostMapping("deleteProperties")
    public void deleteProperties(@RequestParam(value="id") Integer id, @RequestBody String deleteList){
        List<String> list = (List<String>) JSON.parse(deleteList);
        service.deleteProperties(id,list);
    }
    @PostMapping("editNode")
    public CommonResult<NodeVO> editNode(@RequestParam(value = "id") Integer id, @RequestBody String property) {
        Map<String,Object> maps = (Map) JSON.parse(property);
        Integer nodeid =  service.editNode(id, maps);
        NodeVO nodeVO = service.queryNode(nodeid);
        return CommonResult.success(nodeVO);
    }
    @GetMapping("editRel")
    public CommonResult<Boolean> editRel(@RequestParam(value = "source") String source, @RequestParam(value = "target") String target, @RequestParam(value = "id") Integer id, @RequestParam(value = "name")String name) {
        service.editRel(Integer.parseInt(source),Integer.parseInt(target),id, name);
        return CommonResult.success(true);
    }
    @GetMapping("getNeighbour")
    public CommonResult<GraphVO> getNeighbour(@RequestParam(value = "id") long id) {
        return CommonResult.success(service.queryNeighbour(id, null));
    }
    @GetMapping("getTableNames")
    public CommonResult<List<String>> getTableNames(){
        return CommonResult.success(service.getTableNames());
    }
    @GetMapping("importFromMysql")
    public CommonResult<Boolean> importFromMysql(@RequestParam(value="tableName") String tableName){
        return CommonResult.success(service.importFromMysql(tableName));
    }
}
