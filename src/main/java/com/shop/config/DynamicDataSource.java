package com.shop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Override
    protected Object determineCurrentLookupKey() {
        String dbsource = DataSourceContextHolder.getDB();
        if(dbsource == null ){
            dbsource = "db1";
            logger.info("数据源为NULL 返回数据源"+DataSourceContextHolder.getDB());
        }
        return dbsource;
    }

}
