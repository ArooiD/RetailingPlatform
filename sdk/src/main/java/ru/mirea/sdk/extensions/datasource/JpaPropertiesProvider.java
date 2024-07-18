package ru.mirea.sdk.extensions.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class JpaPropertiesProvider {

    private final Environment env;

    @Autowired
    public JpaPropertiesProvider(Environment env) {
        this.env = env;
    }

    public Properties jpaProperties() {
        Properties properties = new Properties();
        String hibernateDialect = env.getProperty("hibernate.dialect");
        if (hibernateDialect != null) {
            properties.put("hibernate.dialect", hibernateDialect);
        }
        String hbm2ddlAuto = env.getProperty("hibernate.hbm2ddl.auto");
        if (hbm2ddlAuto != null) {
            properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        }
        String showSql = env.getProperty("hibernate.show_sql");
        if (showSql != null) {
            properties.put("hibernate.show_sql", showSql);
        }
        return properties;
    }
}