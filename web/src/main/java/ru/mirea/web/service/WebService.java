package ru.mirea.web.service;

import org.springframework.stereotype.Service;

import ru.mirea.sdk.api.*;

@Service
public class WebService {
    private final ModuleSender moduleSender = ModuleSenderFabric.getWeb();
    public String test() {
        EndpointBuilder builder = Endpoint.build();
        builder.addNode("test").addNode("test").addNode("test");
        Message m = moduleSender.get(builder.build());
        return m.get(String.class);
    }
}
