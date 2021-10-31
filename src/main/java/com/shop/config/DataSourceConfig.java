package com.shop.config;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
//@RefreshScope
public class DataSourceConfig {

    //数据源1
    @Bean(name = "dbcp1")
    @ConfigurationProperties(prefix = "spring.datasource.dbcp1") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    //数据源2
    @Bean(name = "dbcp2")
    @ConfigurationProperties(prefix = "spring.datasource.dbcp2") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    //数据源2
    @Bean(name = "dbcp3")
    @ConfigurationProperties(prefix = "spring.datasource.dbcp3") // application.properteis中对应属性的前缀
    public DataSource dataSource3() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDS dynamicDS = new DynamicDS();
        // 默认数据源
//        dynamicDataSource.setDefaultTargetDataSource(dataSource1());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("dbcp1", dataSource1());
        dsMap.put("dbcp2", dataSource2());
        dsMap.put("dbcp3", dataSource3());

        dynamicDS.setTargetDataSources(dsMap);
        return dynamicDS;
    }

    /**
     * 配置@Transactional注解事物
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}
