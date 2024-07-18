package ru.mirea.sdk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.internal.logging.InternalLogger;
import io.micrometer.common.util.internal.logging.InternalLoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractModuleSender implements ModuleSender {
    protected final InternalLogger logger = InternalLoggerFactory.getInstance(ModuleSender.class);
    protected final RestTemplate restTemplate = new RestTemplate();
    protected String baseURL;
    protected String module;

    AbstractModuleSender(String baseURL, String module) {
        this.baseURL = baseURL;
        this.module = module;
    }

    @Override
    public Message get(Endpoint endpoint) {
        endpoint.setModule(module);
        try {
            ResponseEntity<String> request = restTemplate.getForEntity(endpoint.toString(), String.class);
            return new Message(request.getStatusCode(), request.getBody());
        } catch (Exception e) {
            return new Message(e);
        }
    }

    @Override
    public <T> Message post(Endpoint endpoint, T body) {
        endpoint.setModule(module);
        final AtomicReference<Message> result = new AtomicReference<>();
        ResponseExtractor<Message> extractor = response -> {
            Message message = new Message(response.getStatusCode(), response.getBody());
            result.set(message);
            return message;
        };

        RequestCallback requestCallback = request -> {
            request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            new ObjectMapper().writeValue(request.getBody(), body);
        };

        restTemplate.execute(endpoint.toString(), HttpMethod.POST, requestCallback, extractor);
        return result.get();
    }

    @Override
    public <T> Message put(Endpoint endpoint, T body) {
        endpoint.setModule(module);
        final AtomicReference<Message> result = new AtomicReference<>();
        ResponseExtractor<Message> extractor = response -> {
            Message message = new Message(response.getStatusCode(), response.getBody());
            result.set(message);
            return message;
        };

        RequestCallback requestCallback = request -> {
            request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            new ObjectMapper().writeValue(request.getBody(), body);
        };

        restTemplate.execute(endpoint.toString(), HttpMethod.PUT, requestCallback, extractor);
        return result.get();
    }

    @Override
    public Message delete(Endpoint endpoint) {
        endpoint.setModule(module);
        final AtomicReference<Message> result = new AtomicReference<>();
        ResponseExtractor<Message> extractor = response -> {
            Message message = new Message(response.getStatusCode(), response.getBody());
            result.set(message);
            return message;
        };

        restTemplate.execute(endpoint.toString(), HttpMethod.DELETE, null, extractor);
        return result.get();
    }

}
