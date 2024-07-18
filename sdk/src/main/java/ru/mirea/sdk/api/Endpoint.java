package ru.mirea.sdk.api;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Endpoint {
    private final String baseURL;
    private final List<String> nodes;
    private String module = "";
    private Map<String, Object> params;

    protected Endpoint() {
        this.baseURL = null;
        this.nodes = new ArrayList<>();
    }

    protected Endpoint(String baseURL, String module, List<String> nodes) {
        this.baseURL = baseURL;
        this.module = module;
        this.nodes = nodes;
    }

    protected Endpoint(String baseURL, List<String> nodes) {
        this.baseURL = baseURL;
        this.nodes = nodes;
    }

    public static EndpointBuilder build() {
        return new EndpointBuilder(ModuleSenderConfiguration.getBaseUrl());
    }

    protected Endpoint setModule(String module) {
        this.module = module;
        return this;
    }

    @Override
    public String toString() {
        assert baseURL != null;
        StringBuilder sb = new StringBuilder(baseURL);
        sb.append(module);
        if (nodes.size() > 0) {
            sb.append("/").append(String.join("/", nodes));
        }
        return sb.toString();
    }
}
