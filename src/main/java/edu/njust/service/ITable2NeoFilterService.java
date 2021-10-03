package edu.njust.service;

import edu.njust.dydb.DyDatabaseRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 数据库表字段映射过滤
 *
 * @author gudongxian
 * @version 0.1
 * @date 2020/10/19
 */
public interface ITable2NeoFilterService {

    /**
     * 对查出的表数据进行过滤
     *
     * @param data 一条表记录
     */
    void filterFieldMean(Map<String, Object> data);

    /**
     * 对查出的表数据进行过滤
     *
     * @param data 多条表记录
     */
    void filterFieldMean(List<Map<String, Object>> data);

    /**
     * 增加显示名称
     *
     * @param data  单条数据
     * @param table 表名
     */
    void addDisplayName(Map<String, Object> data, String table);

    /**
     * 增加显示名称
     *
     * @param data  数据列表
     * @param table 表名
     */
    void addDisplayName(List<Map<String, Object>> data, String table);

    /**
     * 对查出的表数据进行过滤
     *
     * @param data               表数据
     * @param table              表名
     * @param databaseRepository 数据库操作
     */
    void filterFieldMean(Map<String, Object> data, String table, DyDatabaseRepository databaseRepository, JdbcTemplate jdbcTemplate);

    /**
     * 对查出的表数据进行过滤
     *
     * @param data               多条表数据
     * @param table              表名
     * @param databaseRepository 数据库操作
     */
    void filterFieldMean(List<Map<String, Object>> data, String table, DyDatabaseRepository databaseRepository, JdbcTemplate jdbcTemplate);
}
