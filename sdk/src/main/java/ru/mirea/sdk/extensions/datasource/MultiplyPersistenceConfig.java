package ru.mirea.sdk.extensions.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "datasource")
public class MultiplyPersistenceConfig {
    private List<MultiplyDataSource> multiply;

    public List<MultiplyDataSource> getMultiply() {
        return multiply;
    }

    public void setMultiply(List<MultiplyDataSource> multiply) {
        this.multiply = multiply;
    }
}
