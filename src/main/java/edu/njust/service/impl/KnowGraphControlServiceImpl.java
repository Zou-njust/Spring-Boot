package edu.njust.service.impl;

import edu.njust.dal.IFieldMeanRepository;
import edu.njust.dal.Table2NodelLabelRepository;
import edu.njust.entity.DataMap;
import edu.njust.entity.dto.FieldMean;
import edu.njust.entity.dto.Table2NodeLabel;
import edu.njust.service.IKnowGraphControlService;
import edu.njust.service.ITable2NeoFilterService;
import edu.njust.util.GraphQueryUtils;
import edu.njust.util.StringUtil;
import edu.njust.vo.GraphVO;
import edu.njust.vo.NodeVO;
import edu.njust.vo.RelationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 知识图谱控制服务实现类
 *
 * @author gudongxian
 * @version 0.1
 * @date 2020/9/21
 */
@Service
public class KnowGraphControlServiceImpl implements IKnowGraphControlService {

    private GraphQueryUtils graphQueryUtils;
    private IFieldMeanRepository fieldMeanRepository;
    private Table2NodelLabelRepository table2NodelLabelRepository;

    public KnowGraphControlServiceImpl(GraphQueryUtils graphQueryUtils, IFieldMeanRepository fieldMeanRepository, Table2NodelLabelRepository table2NodelLabelRepository) {
        this.graphQueryUtils = graphQueryUtils;
        this.fieldMeanRepository = fieldMeanRepository;
        this.table2NodelLabelRepository = table2NodelLabelRepository;
    }

    @Override
    public GraphVO querySchema() {
        return graphQueryUtils.findAllGraph(GraphQueryUtils.CALL_SCHEMA);
    }

    @Override
    public NodeVO queryNode(Integer id) {
        return graphQueryUtils.findSingleNodeById(id);
    }

    @Override
    public List<NodeVO> queryNode(String name) {
        return null;
    }

    @Override
    public GraphVO queryNodeNeighbour(Long nodeId) {
        return null;
    }

    @Override
    public Set<String> queryAllLabel() {
        return graphQueryUtils.findAllLabel();
    }

    @Override
    public List<DataMap<String, String>> queryAllLabelMap() {
        Set<String> labels = this.queryAllLabel();
        List<DataMap<String, String>> ret = new LinkedList<>();
        for (String label : labels) {
            Table2NodeLabel tableNodeMap = table2NodelLabelRepository.getFirstByTableName(label);
            if (tableNodeMap != null) {
                ret.add(new DataMap<>(label, tableNodeMap.getNodeLabel()));
            } else {
                ret.add(new DataMap<>(label, label));
            }
        }
        return ret;
    }


    @Override
    public Set<String> queryProperties(String label) {
        Set<String> properties = graphQueryUtils.findProperties(label);
        // 检测名称为纯英文的剔出
        // 2021.1.8 显示英文属性
        /*
        Set<String> enSet = new HashSet<>();
        for (String key : properties) {
            if (StringUtil.isEnglish(key)) {
                enSet.add(key);
            }
        }
        for (String enKey : enSet) {
            properties.remove(enKey);
        }
        */
        return properties;
    }

    @Override
    public List<DataMap<String, String>> queryPropertiesMap(String label) {
        Set<String> properties = this.queryProperties(label);
        List<DataMap<String, String>> ret = new LinkedList<>();
        for (String property : properties) {
            FieldMean fieldMean = fieldMeanRepository.getFirstByTableNameAndField(label, property);
            if (fieldMean != null) {
                ret.add(new DataMap<>(property, fieldMean.getMean()));

            } else {
                ret.add(new DataMap<>(property, property));
            }
        }
        return ret;
    }

    @Override
    public Set<String> queryAllRel() {
        return graphQueryUtils.findAllRel();
    }

    @Override
    public GraphVO queryNeighbour(Long id, String rel) {
        if (StringUtil.isBlank(rel)) {
            return graphQueryUtils.findNeighbour(id);
        }
        return graphQueryUtils.findNeighbour(id, rel);
    }

    @Override
    public GraphVO queryEventNeighbour(Long id, String rel, String startTime, String endTime) {
        return graphQueryUtils.findEventByTimeAndNode(id, rel, startTime, endTime);
    }

    @Autowired
    ITable2NeoFilterService table2NeoFilterService;

    @Override
    public List<NodeVO> queryNodeByProperty(String label, String property, String value) {
        List<NodeVO> nodes = graphQueryUtils.findGraphNode(String.format(GraphQueryUtils.NODE_PROPERTY, label, property, value));
        for (NodeVO node : nodes) {
            Map<String, Object> properties = node.getProperties();
            table2NeoFilterService.filterFieldMean(properties, label, null, null);
            node.setProperties(properties);
        }
        return nodes;
    }
    @Override
    public List<NodeVO> queryNodeByLabel(String label) {
        List<NodeVO> nodes = graphQueryUtils.findGraphNode(String.format(GraphQueryUtils.NODE_LABLE, label));
        for (NodeVO node : nodes) {
            Map<String, Object> properties = node.getProperties();
            table2NeoFilterService.filterFieldMean(properties, label, null, null);
            node.setProperties(properties);
        }
        return nodes;
    }
    @Override
    public List<RelationVO> querySLRelation(){
        List<RelationVO> relations = graphQueryUtils.findGraphRel(GraphQueryUtils.SL_RELATION);
        return relations;
    }

    @Override
    public Set<String> queryRelByNode(Long nodeId) {
        return graphQueryUtils.findNodeConnectedRel(nodeId);
    }

    @Override
    public Map<String, Set<String>> queryRelAndNodeType(Long nodeId) {
        return graphQueryUtils.findNodeConnectedRelAndNodeType(nodeId);
    }

    @Override
    public Boolean deleteNode(Integer nodeId) {
        return graphQueryUtils.deleteNode(nodeId);
    }

    @Override
    public Boolean deleteRel(Integer relId) {
        return graphQueryUtils.deleteRel(relId);
    }
}
