package edu.njust.controller;

import edu.njust.api.CommonResult;
import edu.njust.entity.MappingValue;
import edu.njust.entity.SubmitInfo;
import edu.njust.service.DBQueryService;
import edu.njust.service.OracleToGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/DBQuery")
public class QracleQueryController {
    @Autowired
    private DBQueryService dbQueryService;

    @Autowired
    private OracleToGroupService oracleToGroupService;

    @PostMapping(value = "/TableNameQuery")
    public List<String> getTableName()throws Exception
    {
        List<String> list = dbQueryService.TableNameQuery();
        for (String str : list) {
            System.out.println(str);
        }
        return list;

    }

    @PostMapping(value = "/ColumnQuery")
    public List<String> getColumnName(@RequestParam(value="TableName") String TableName)throws Exception
    {
        List<String> list = dbQueryService.ColumnQuery(TableName);
        for (String str : list) {
            System.out.println(str);
        }
        return list;
    }

    @PostMapping(value = "/getID")
    public List<String> getId(@RequestParam(value="TableName") String TableName)throws Exception
    {
        List<String> list = dbQueryService.getIdValue(TableName);
//        List<String> list = dbQueryService.getAllValue(TableName);
        for (String str : list) {
            System.out.println(str);
        }
        return list;
    }


    @PostMapping(value = "/getMapping")
    public HashMap<Integer,MappingValue> getMapping(@RequestParam(value="TableName") String TableName,
                                   @RequestParam(value="ColumnName1") String ColumnName1,
                                   @RequestParam(value="ColumnName2") String ColumnName2
    )throws Exception
    {
        List<String> startList = dbQueryService.getColValue(ColumnName1,TableName);
        List<String> endingList = dbQueryService.getColValue(ColumnName2,TableName);
        MappingValue mappingValue = new MappingValue();
        HashMap<Integer,MappingValue> map = new HashMap<Integer, MappingValue>();
        int count = 0;
        for(int i=0,j=0;i<startList.size()&&j<endingList.size();i++,j++)
        {
            count++;
            mappingValue.setStartValue(startList.get(i));
            mappingValue.setEndingValue(endingList.get(j));
            map.put(count,mappingValue);
        }
//        boolean b = map.containsKey(1);
//        System.out.println(1);
//        System.out.println(map.toString());
//        Set entrySet = map.entrySet();
//        Iterator iterator = entrySet.iterator();
//        while(iterator.hasNext()){
//            Object obj =iterator.next();
//            Map.Entry entry = (Map.Entry) obj;
//            System.out.println(entry.getKey()+"---->"+entry.getValue());
//        }
        return map;
    }

    @PostMapping(value = "/createGraph")
    public CommonResult getMapping(@RequestBody SubmitInfo submitInfo)throws Exception
    {
        boolean isMapping =false;
        String RelationName = submitInfo.getRelationName();
        String StartType =submitInfo.getStartType();
        String EndType = submitInfo.getEndType();
        String StartTableName = submitInfo.getStartTableName();
        String EndingTableName = submitInfo.getEndingTableName();
        List<String> StartList = submitInfo.getStartList();
        List<String> EndingList = submitInfo.getEndingList();
        HashMap<Integer,MappingValue> map =submitInfo.getMap();
        List<String> list1 = dbQueryService.getIdValue(StartTableName);
        List<String> list2 = dbQueryService.getIdValue(EndingTableName);
        Set<Integer> integers = map.keySet();
        for (Integer in:integers){
            String StartID = map.get(in).getStartValue();
            String EndID = map.get(in).getEndingValue();
            System.out.println(StartID);
            System.out.println(EndID);
            if (list1.contains(map.get(in).getStartValue())&&list2.contains(map.get(in).getEndingValue()))
            {
                System.out.println("匹配成功");
                int Id1 = oracleToGroupService.createNode(StartType,StartTableName,StartID,StartList);
                int Id2 = oracleToGroupService.createNode(EndType,EndingTableName,EndID,EndingList);
                oracleToGroupService.createRelation(Id1,RelationName,Id2);
                isMapping = true;
            }
        }
        if (isMapping)
        return CommonResult.success("映射成功！");
        else  return CommonResult.success("映射失败，映射表选取错误，请重新选择！");
    }

}
