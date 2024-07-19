package ru.mirea.sdk.extensions.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MultiplyDatabaseService {

    private final Map<String, EntityManagerFactory> entityManagerFactories;
    private final Map<String, JpaTransactionManager> transactionManagers;

    @Autowired
    public MultiplyDatabaseService(
            @Qualifier("multiplyEntityManagerFactories") Map<String, LocalContainerEntityManagerFactoryBean> entityManagerFactories,
            @Qualifier("multiplyTransactionManagers") Map<String, JpaTransactionManager> transactionManagers) {
        this.entityManagerFactories = entityManagerFactories.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getObject()));
        this.transactionManagers = transactionManagers;
    }

    public EntityManager getEntityManager(String persistenceUnitName) {
        EntityManagerFactory emf = entityManagerFactories.get(persistenceUnitName);
        if (emf == null) {
            //throw new IllegalArgumentException("No EntityManagerFactory found for persistence unit: " + persistenceUnitName);
        }
        return emf.createEntityManager();
    }

    public JpaTransactionManager getTransactionManager(String persistenceUnitName) {
        return transactionManagers.get(persistenceUnitName);
    }
}
