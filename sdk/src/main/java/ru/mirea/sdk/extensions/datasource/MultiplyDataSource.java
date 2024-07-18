package ru.mirea.sdk.extensions.datasource;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MultiplyDataSource {
    private String dbName;
    private String address;
    private int port;
    private String username;
    private String password;
    private String persistenceUnitName;
    private String packagePath;
    private String dbType;
    private String driverClassName;

    public String getJdbcUrl() {
        return String.format("jdbc:%s://%s:%d/%s", dbType, address, port, dbName);
    }
}