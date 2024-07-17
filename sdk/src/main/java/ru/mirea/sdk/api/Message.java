package ru.mirea.sdk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatusCode;

import java.io.IOException;
import java.io.InputStream;

public class Message {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpStatusCode statusCode;
    private final Object body;
    protected Message(HttpStatusCode statusCode, Object body){
        this.statusCode = statusCode;
        this.body = body;
    }
    protected Message(HttpStatusCode statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    protected Message(Exception e) {
        this.statusCode = HttpStatusCode.valueOf(400);
        this.body = e.getMessage();
    }

    protected Message(HttpStatusCode statusCode, InputStream body) throws IOException {
        this.statusCode = statusCode;
        this.body = new String(body.readAllBytes());
        body.close();
    }

    public <T> T unWrapBody(Class<T> tClass){
        return objectMapper.convertValue(this.body, tClass);
    }

    public Integer unWrapCode(){
        return this.statusCode.value();
    }

    public Boolean isSuccess(){
        return !this.statusCode.isError();
    }

    public HttpStatusCode getStatusCode(){return this.statusCode;}
}
