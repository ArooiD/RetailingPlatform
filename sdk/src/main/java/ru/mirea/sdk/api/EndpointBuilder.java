package ru.mirea.sdk.api;

import java.util.ArrayList;
import java.util.List;

public class EndpointBuilder {
    private final String baseURL;
    private final List<String> nodes = new ArrayList<>();

    protected EndpointBuilder(String baseURL) {
        this.baseURL = baseURL;
    }

    public EndpointBuilder addNode(String node) {
        this.nodes.add(node);
        return this;
    }

    public Endpoint build() {
        return new Endpoint(baseURL, nodes);
    }
}
