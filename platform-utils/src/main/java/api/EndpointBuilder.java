package api;

import java.util.List;

public class EndpointBuilder {
    private String baseURL;
    private List<String> nodes;
    EndpointBuilder addNode(String node){
        this.nodes.add(node);
        return this;
    }
    Endpoint build(){
        return new Endpoint(baseURL, nodes);
    }
}
