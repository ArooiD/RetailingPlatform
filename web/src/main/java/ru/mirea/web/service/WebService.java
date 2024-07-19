package ru.mirea.web.service;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import net.datafaker.Faker;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.sdk.api.*;
import ru.mirea.sdk.entity.storage.Provider;
import ru.mirea.sdk.extensions.datasource.MultiplyDatabaseService;
import ru.mirea.sdk.genearators.ShopPlannerGenerator;

import java.util.UUID;

@Service
@Slf4j
@Transactional
public class WebService {

    private final ModuleSender webSender = ModuleSenderFabric.getWeb();
    //private final EntityManager entityManager;

    Faker faker = new Faker();

    @PersistenceContext()
    private EntityManager defalutContext;

    @Autowired
    public WebService(MultiplyDatabaseService multiplyDatabaseService) {
        //this.entityManager = multiplyDatabaseService.getEntityManager("postgresPU");
    }

    public String testGetRequest() {
        EndpointBuilder builder = Endpoint.build();
        builder.addNode("test");
        Message m = webSender.get(builder.build());
        return m.unWrapBody(String.class);
    }

    @PostConstruct
    @Transactional
    public void testMultiplyEntityManager() {
        EntityTransaction transaction = defalutContext.getTransaction();
        try {
            transaction.begin();
            CriteriaBuilder cb = defalutContext.getCriteriaBuilder();
            CriteriaUpdate<Provider> cu = cb.createCriteriaUpdate(Provider.class);
            Root<Provider> root = cu.from(Provider.class);
            for (int i = 0; i < 10; i++) {
                String address = faker.address().fullAddress();
                String name = faker.company().name();
                UUID newId = UUID.randomUUID();
                cu.set("address", address);
                cu.set("name", name);
                cu.where(cb.equal(root.get("id"), newId));
                defalutContext.createQuery(cu).executeUpdate();
            }
            transaction.commit();
            log.info("Update completed successfully.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("Error updating Provider entities", e);
        } finally {
            defalutContext.close();
        }
    }
}
