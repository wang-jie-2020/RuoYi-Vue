package com.ruoyi.framework.datasource;

import java.util.Map;
import javax.sql.DataSource;

import com.ruoyi.framework.aspectj.DataSourceAspect;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 *      see {@link DataSourceAspect}
 *
 *      简单理解: 构造函数中传入了
 *
 * @author ruoyi
 */
public class DynamicDataSource extends AbstractRoutingDataSource
{
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources)
    {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey()
    {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}