package api;

import org.springframework.http.HttpStatusCode;

import java.io.InputStream;
import java.util.LinkedHashMap;

public class Message {
    protected Message(){}
    protected Message(HttpStatusCode statusCode, String body) {
    }

    protected Message(Exception e) {

    }

    protected Message(HttpStatusCode statusCode, InputStream body) {
    }

    public <T> T get(Class<T> tClass){
        return null;
    }
}
