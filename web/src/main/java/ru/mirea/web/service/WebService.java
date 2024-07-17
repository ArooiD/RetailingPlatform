package ru.mirea.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.sdk.api.*;
import ru.mirea.sdk.genearators.ShopPlannerGenerator;

@Service
@Slf4j
public class WebService {
    private final ModuleSender webSender = ModuleSenderFabric.getWeb();
    public String testGetRequest() {
        EndpointBuilder builder = Endpoint.build();
        builder.addNode("test");
        Message m = webSender.get(builder.build());
        return m.unWrapBody(String.class);
    }

    public Object render(int rows, int cols){
        return ShopPlannerGenerator.generateStoreLayout(rows, cols);
    }
}
