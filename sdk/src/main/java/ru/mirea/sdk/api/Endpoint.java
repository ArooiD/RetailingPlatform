package ru.mirea.sdk.api;


import java.util.ArrayList;
import java.util.List;

public class Endpoint {
    private final String baseURL;
    private String module = "";
    private final List<String> nodes;
    protected Endpoint(){
        this.baseURL = null;
        this.nodes = new ArrayList<>();
    }
    protected Endpoint(String baseURL, String module, List<String> nodes){
        this.baseURL = baseURL;
        this.module = module;
        this.nodes = nodes;
    }
    protected Endpoint(String baseURL, List<String> nodes) {
        this.baseURL = baseURL;
        this.nodes = nodes;
    }
    protected Endpoint setModule(String module){
        this.module = module;
        return this;
    }
    @Override
    public String toString(){
        return baseURL + "/" + module +"/"+ String.join("/",nodes);
    }
}
