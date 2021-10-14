package edu.njust.service;

import edu.njust.mapper.oracle.RelationshipMapper;
import edu.njust.model.oracle.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipService {
    @Autowired
    private RelationshipMapper relationshipMapper;

    public int addRelationship(Relationship relationship){
        return relationshipMapper.addRelationship(relationship);
    }

    public List<Relationship> findRelationshipByTo(int to){
        return relationshipMapper.findRelationshipByTo(to);
    }
}
