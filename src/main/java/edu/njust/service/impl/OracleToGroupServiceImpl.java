package edu.njust.service.impl;

import com.alibaba.fastjson.JSON;
import edu.njust.api.CommonResult;
import edu.njust.mapper.oracle.DBQueryMapper;
import edu.njust.service.DBQueryService;
import edu.njust.service.IKnowGraphControlService;
import edu.njust.service.OracleToGroupService;
import edu.njust.util.OracleUtil;
import edu.njust.vo.NodeVO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OracleToGroupServiceImpl implements OracleToGroupService {
    @Autowired
    private DBQueryService dbQueryService;

    @Autowired
    IKnowGraphControlService iKnowGraphControlService;

    @Autowired
    private OracleUtil oracleUtil;

    @Override
    public int createNode(String type,String TableName,String StartID, List<String> PropertiesName) {
        String sql = "select * from " + TableName + " where id = "+ StartID;
        String domain = "知识图谱";
        String Nodename = null;
        List<String> temp = dbQueryService.ColumnQuery(TableName);
        int NodeID = 0;
        Connection conn = null;
        // 创建预编译语句对象，一般都是用这个而不用Statement
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = oracleUtil.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","123456");
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            ResultSetMetaData data = rs.getMetaData();
            int count = 0;
            while (rs.next()) {  //循环遍历结果集
                count = 0 ;
                Nodename = null;
                String property = "{";
                List<String> colNameTotal = new ArrayList<>();
                List<String> colValueTemp = new ArrayList<>();
                for (int i = 1; i <= data.getColumnCount(); i++) {
                    String columnName = data.getColumnName(i);//获得指定列的列名
                    String columnValue = rs.getString(i);//获得指定列的列值
//                 System.out.println(columnName);
                    if (temp.contains("NAME")&&columnName.equals("NAME"))
                    {
                        Nodename = columnValue;
                    }else if(!temp.contains("NAME")&&columnName.equals(("ID")))
                    {
                        Nodename = columnValue;
                    }
                    if(PropertiesName.contains(columnName))
                    {
                        colNameTotal.add(columnName);       //列名list
                        colValueTemp.add(columnValue);      //查询内容的list
                        count++;
                    }
                }
                for(int i =0;i<colNameTotal.size();i++)
                {
                    if(i!=count-1)
                        property+="\"" + colNameTotal.get(i)+ "\":\"" + colValueTemp.get(i) + "\",";
                    else
                    {
                        property += "\"" + colNameTotal.get(i) + "\":\"" + colValueTemp.get(i) + "\"}";
                    }
                }
                System.out.println(domain + "    " + Nodename + "    " + property);
                Map<String, Object> maps = (Map) JSON.parse(property);
                maps.put("name", Nodename);
                Integer newId = iKnowGraphControlService.createNode(domain, type, maps);
                NodeID = newId;
                NodeVO nodeVO = iKnowGraphControlService.queryNode(newId);
                System.out.println(CommonResult.success(nodeVO));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return NodeID;
    }

    @Override
    public void createRelation(Integer StartNode,String RelationName, Integer EndNode) {
        String domain = "知识图谱";
        String source =  StartNode.toString();
        String target = EndNode.toString();
        iKnowGraphControlService.createRel(domain,source,target,RelationName);
    }
}
