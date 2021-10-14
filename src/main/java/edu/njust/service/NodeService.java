package edu.njust.service;

import edu.njust.mapper.oracle.NodeMapper;
import edu.njust.model.oracle.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeService {
    @Autowired
    private NodeMapper nodeMapper;
    public int addNode(Node node){
        return nodeMapper.addNode(node);
    }

    public int findIdByNameAndType(String name, int type){
        return nodeMapper.findIdByNameAndType(name, type);
    }

    public String findNameById(int id){
        return nodeMapper.findNameById(id);
    }

    public List<Node> findAllNodeByType(int type){
        return nodeMapper.findAllNodeByType(type);
    }

    public int updateCPTByNameAndType(String name, int type, String cpt){
        return nodeMapper.updateCPTByNameAndType(name, type, cpt);
    }

}
