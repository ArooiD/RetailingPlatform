package ru.mirea.web.service;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.sdk.api.*;
import ru.mirea.sdk.extensions.datasource.MultiplyDatabaseService;
import ru.mirea.sdk.genearators.ShopPlannerGenerator;

@Service
@Slf4j
public class WebService {

    private final ModuleSender webSender = ModuleSenderFabric.getWeb();
    private final EntityManager entityManager;

    @Autowired
    public WebService(MultiplyDatabaseService multiplyDatabaseService) {
        this.entityManager = multiplyDatabaseService.getEntityManager("postgresPU");
    }

    public String testGetRequest() {
        EndpointBuilder builder = Endpoint.build();
        builder.addNode("test");
        Message m = webSender.get(builder.build());
        return m.unWrapBody(String.class);
    }

    @PostConstruct
    public void testMultiplyEntityManager() {
        log.info("!!!!!!!!!!!!!!!!!! entityManager initialized: " + String.valueOf(entityManager != null));
    }

    public Object render(int rows, int cols) {
        log.info("!!!!!!!!!!!!!!!!!! entityManager initialized: " + String.valueOf(entityManager != null));
        return ShopPlannerGenerator.generateStoreLayout(rows, cols);
    }
}
