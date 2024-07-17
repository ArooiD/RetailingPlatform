package ru.mirea.web.service;

import org.springframework.stereotype.Service;

import ru.mirea.sdk.api.EndpointBuilder;
import ru.mirea.sdk.api.Message;
import ru.mirea.sdk.api.ModuleSender;
import ru.mirea.sdk.api.ModuleSenderFabric;
@Service
public class WebService {
    private final ModuleSender moduleSender = ModuleSenderFabric.getWeb();
    public String test() {
        EndpointBuilder builder = new EndpointBuilder("http://localhost:8080");
        builder.addNode("test");
        Message m = moduleSender.get(builder.build());
        return m.get(String.class);
    }
}
