package edu.njust.vo;

import java.util.Map;
import java.util.Objects;

/**
 * 关系显示对象
 *
 * @author gudongxian
 * @version 0.1
 * @date 2020/9/24
 */
public class RelationVO {

    /**
     * 关系ID
     */
    private Long id;
    /**
     * 开始节点ID
     */
    private Long sourceId;
    /**
     * 结束节点ID
     */
    private Long targetId;

    private Map<String, Object> properties;

    public RelationVO() {
    }

    public RelationVO(Long id, Long sourceId, Long targetId, String name) {
        this.id = id;
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.name = name;
    }

    public RelationVO(Long id, Long sourceId, Long targetId, Map<String, Object> properties, String name) {
        this.id = id;
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.properties = properties;
        this.name = name;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    /**
     * 关系名称，用于显示
     */
    private String name;

    @Override
    public String toString() {
        return "RelationVO{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", targetId=" + targetId +
                ", properties=" + properties +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    针对set集合重复问题重写了equals和hashCode方法
//    id用==不能正确判别，使用下面的方法可以，可能是因为用了Long类而不是基础类型
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof RelationVO)){
            return false;
        }
        RelationVO n=(RelationVO) obj;
        if(Objects.equals(this.id, n.id)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.id.hashCode();
    }
}
