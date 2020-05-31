package com.hy.multipledatasources.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Objects;

/***
 * @description 多数据源配置类。主数据源
 * @EnableJpaRepositories:  basePackages 指定到自己的repository。
 * @author hy
 * @date 2020/5/31 13:50
 **/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.hy.multipledatasources.employee.repository"},
                       entityManagerFactoryRef = "primaryEntityManagerFactory",
                       transactionManagerRef = "primaryTransactionManager")
public class MultipleDataSourcesPrimaryConfig {

    /**
     * 配置数据源   @Primary . 标记为主数据源
     * @return 、
     */
    @Bean("primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 实体管理工厂的bean
     * @param builder \
     * @return \
     */
    @Bean(name = "primaryEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(primaryDataSource())
                //这个是指向你的domain, entity的路径。 实体类所在的包
                .packages("com.hy.multipledatasources.employee.entity")
                .persistenceUnit("primary")
                .build();
    }

    /**
     * 配置 实体管理器
     * @param builder 、
     * @return 、
     */
    @Bean(name = "primaryEntityManager")
    @Primary
    public EntityManager primaryEntityManager(EntityManagerFactoryBuilder builder){
        return  Objects.requireNonNull(entityManagerFactory(builder).getObject()).createEntityManager();
    }

    /**
     * 配置事务管理
     * @param builder 、
     * @return 、
     */
    @Bean(name = "primaryTransactionManager")
    @Primary
    public PlatformTransactionManager primaryTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory(builder).getObject()));
    }
}
