package ru.mirea.sdk.extensions.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties(MultiplyPersistenceConfig.class)
public class PersistenceConfig {
    private static final Logger logger = LoggerFactory.getLogger(PersistenceConfig.class);

    private final MultiplyPersistenceConfig multiplyPersistenceConfig;
    private final JpaPropertiesProvider jpaPropertiesProvider;

    @Autowired
    public PersistenceConfig(MultiplyPersistenceConfig multiplyPersistenceConfig, JpaPropertiesProvider jpaPropertiesProvider) {
        this.multiplyPersistenceConfig = multiplyPersistenceConfig;
        this.jpaPropertiesProvider = jpaPropertiesProvider;
    }

    @Bean(name = "multiplyEntityManagerFactories")
    @Primary
    public Map<String, LocalContainerEntityManagerFactoryBean> entityManagerFactories() {
        Map<String, LocalContainerEntityManagerFactoryBean> entityManagerFactoryBeans = new HashMap<>();

        try {
            for (MultiplyDataSource dataSourceConfig : multiplyPersistenceConfig.getMultiply()) {

                logger.info(dataSourceConfig.getPersistenceUnitName());
                HikariConfig config = new HikariConfig();
                config.setDriverClassName(dataSourceConfig.getDriverClassName());
                config.setJdbcUrl(dataSourceConfig.getJdbcUrl());
                config.setUsername(dataSourceConfig.getUsername());
                config.setPassword(dataSourceConfig.getPassword());
                DataSource dataSource = new HikariDataSource(config);

                LocalContainerEntityManagerFactoryBean emFactoryBean = new LocalContainerEntityManagerFactoryBean();
                emFactoryBean.setDataSource(dataSource);
                emFactoryBean.setPackagesToScan(dataSourceConfig.getPackagePath());
                emFactoryBean.setPersistenceUnitName(dataSourceConfig.getPersistenceUnitName());

                HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
                emFactoryBean.setJpaVendorAdapter(vendorAdapter);
                Properties properties = jpaPropertiesProvider.jpaProperties();
                emFactoryBean.setJpaProperties(properties);

                emFactoryBean.afterPropertiesSet();

                entityManagerFactoryBeans.put(dataSourceConfig.getPersistenceUnitName(), emFactoryBean);
            }
        } catch (Exception e) {
            logger.error("Failed to initialize EntityManagerFactory", e);
            //throw new RuntimeException("Failed to initialize EntityManagerFactory", e);
        }

        return entityManagerFactoryBeans;
    }

    @Bean(name = "multiplyTransactionManagers")
    public Map<String, JpaTransactionManager> transactionManagers() {
        Map<String, JpaTransactionManager> transactionManagers = new HashMap<>();

        for (Map.Entry<String, LocalContainerEntityManagerFactoryBean> entry : entityManagerFactories().entrySet()) {
            EntityManagerFactory emf = entry.getValue().getObject();
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(emf);
            transactionManagers.put(entry.getKey(), transactionManager);
        }
        return transactionManagers;
    }
}
