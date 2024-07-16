package api;


import java.util.List;

public class Endpoint {
    private final String endpoint;
    protected Endpoint(){endpoint=null;}

    protected Endpoint(String baseURL, List<String> nodes) {
        this.endpoint = baseURL + "/"+ String.join("/",nodes);
    }

    @Override
    public String toString(){
        return endpoint;
    }
}
