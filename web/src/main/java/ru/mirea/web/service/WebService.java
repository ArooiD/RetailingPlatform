package ru.mirea.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.sdk.api.*;

@Service
@Slf4j
public class WebService {
    private final ModuleSender webSender = ModuleSenderFabric.getWeb();
    public String testGetRequest() {
        EndpointBuilder builder = Endpoint.build();
        builder.addNode("test").addNode("test").addNode("test");
        Message m = webSender.get(builder.build());
        return m.unWrapBody(String.class);
    }

    public String testPostRequest() {
        EndpointBuilder builder = Endpoint.build();
        builder.addNode("test").addNode("test").addNode("test");
        Message m = webSender.post(builder.build(), null);
        return m.unWrapBody(String.class);
    }

    public String testPutRequest() {
        EndpointBuilder builder = Endpoint.build();
        builder.addNode("test").addNode("test").addNode("test");
        Message m = webSender.put(builder.build(), null);
        return m.unWrapBody(String.class);
    }

    public String testDeleteRequest() {
        EndpointBuilder builder = Endpoint.build();
        builder.addNode("test").addNode("test").addNode("test");
        Message m = webSender.delete(builder.build());
        return m.unWrapBody(String.class);
    }
}
