package edu.njust.dal;

import edu.njust.entity.dto.TableDisplayName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 数据库显示的列
 *
 * @author gudongxian
 * @version 0.1
 * @date 2020/9/4
 */
public interface TableDisplayNameRepository extends JpaRepository<TableDisplayName, Long> {
    /**
     * 根据表名查询显示的列
     *
     * @param tableName 表名
     * @return 数据列表
     */
    TableDisplayName getFirstByTableName(String tableName);
}
