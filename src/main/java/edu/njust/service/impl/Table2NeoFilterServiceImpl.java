package edu.njust.service.impl;

import edu.njust.dal.IFieldMeanRepository;
import edu.njust.dal.TableDisplayNameRepository;
import edu.njust.dydb.DyDatabaseRepository;
import edu.njust.entity.dto.FieldMean;
import edu.njust.entity.dto.TableDisplayName;
import edu.njust.service.ITable2NeoFilterService;
import edu.njust.util.StringUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 表隐射过滤服务
 *
 * @author gudongxian
 * @version 0.1
 * @date 2020/10/19
 */
@Service
public class Table2NeoFilterServiceImpl implements ITable2NeoFilterService {

    private Map<String, String> fieldMap = new ConcurrentHashMap<>();
    private Map<String, String> tableMapName = new ConcurrentHashMap<>();
    private IFieldMeanRepository fieldMeanRepository;
    private TableDisplayNameRepository tableDisplayNameRepository;

    public Table2NeoFilterServiceImpl(IFieldMeanRepository fieldMeanRepository, TableDisplayNameRepository tableDisplayNameRepository) {
        this.fieldMeanRepository = fieldMeanRepository;
        this.tableDisplayNameRepository = tableDisplayNameRepository;
/*        tableMapName.put("LABEL_INFO", "NATURE_NAME");
        tableMapName.put("LABEL_USER_FOCUS", "LABEL_INFO_ID");*/
    }

    @Override
    public void filterFieldMean(Map<String, Object> data) {
        for (Map.Entry<String, Object> item : data.entrySet()) {
            if (null == item.getValue()) {
                item.setValue("无");
            }
        }
        Map<String, Object> tmp = new HashMap<>();
        Iterator<Map.Entry<String, Object>> entryIterator = data.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            if (fieldMap.containsKey(next.getKey())) {
                tmp.put(fieldMap.get(next.getKey()), next.getValue());
                entryIterator.remove();
            } else {
                FieldMean fieldMean = fieldMeanRepository.getFirstByField(next.getKey());
                if (fieldMean != null) {
                    fieldMap.put(next.getKey(), fieldMean.getMean());
                    tmp.put(fieldMean.getMean(), next.getValue());
                    entryIterator.remove();
                } else {
                    // 防止没有查到，查不到就用当前KEY
                    fieldMap.put(next.getKey(), next.getKey());
                }
            }
        }
        data.putAll(tmp);
    }

    @Override
    public void filterFieldMean(List<Map<String, Object>> data) {
        for (Map<String, Object> datum : data) {
            filterFieldMean(datum);
        }
    }

    @Override
    public void filterFieldMean(Map<String, Object> data, String table, DyDatabaseRepository databaseRepository, JdbcTemplate jdbcTemplate) {
        for (Map.Entry<String, Object> item : data.entrySet()) {
            if (null == item.getValue()) {
                item.setValue("无");
            }
        }
        Map<String, Object> tmp = new HashMap<>();
        Iterator<Map.Entry<String, Object>> entryIterator = data.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            if (fieldMap.containsKey(next.getKey())) {
                tmp.put(fieldMap.get(next.getKey()), next.getValue());
                entryIterator.remove();
            } else {
                FieldMean fieldMean = fieldMeanRepository.getFirstByTableNameAndField(table, next.getKey());
                if (fieldMean != null) {
                    fieldMap.put(next.getKey(), fieldMean.getMean());
                    tmp.put(fieldMean.getMean(), next.getValue());
                    entryIterator.remove();
                } else {
                    if (databaseRepository == null || jdbcTemplate == null) {
                        continue;
                    }
                    // 映射表没有查到，到注释里面查找
                    String comment = databaseRepository.queryColumnComment(jdbcTemplate, table, next.getKey());
                    if (!StringUtil.isBlank(comment)) {
                        // 替换数据
                        comment = comment.trim();
                        fieldMap.put(next.getKey(), comment);
                        tmp.put(comment, next.getValue());
                        entryIterator.remove();

                        // 将当前注释保存到Mean表中
                        fieldMean = new FieldMean();
                        fieldMean.setTableName(table);
                        fieldMean.setMean(comment);
                        fieldMean.setField(next.getKey());
                        fieldMeanRepository.save(fieldMean);

                    } else {
                        // 防止没有查到，查不到就用当前KEY
                        fieldMap.put(next.getKey(), next.getKey());
                    }
                }
            }
        }
        data.putAll(tmp);
    }

    @Override
    public void filterFieldMean(List<Map<String, Object>> data, String table, DyDatabaseRepository databaseRepository, JdbcTemplate jdbcTemplate) {
        for (Map<String, Object> datum : data) {
            filterFieldMean(datum, table, databaseRepository, jdbcTemplate);
        }
    }

    @Override
    public void addDisplayName(Map<String, Object> data, String table) {
        if (tableMapName.containsKey(table)) {
            data.put("name", data.get(tableMapName.get(table)));
        } else {
            TableDisplayName tableDisplayName = tableDisplayNameRepository.getFirstByTableName(table);
            if (tableDisplayName != null) {
                data.put("name", data.get(tableDisplayName.getDisplayColumn()));
                tableMapName.put(table, tableDisplayName.getDisplayColumn());
            }
        }
    }

    @Override
    public void addDisplayName(List<Map<String, Object>> data, String table) {
        for (Map<String, Object> datum : data) {
            addDisplayName(datum, table);
        }
    }


}
