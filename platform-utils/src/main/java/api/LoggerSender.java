package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;

import java.util.concurrent.atomic.AtomicReference;

public class LoggerSender extends AbstractModuleSender implements ModuleSender{
    @Override
    public Message get(Endpoint endpoint) {
        try {
            ResponseEntity<String> request = restTemplate.getForEntity(endpoint.toString(), String.class);
            return new Message(request.getStatusCode(), request.getBody());
        }
        catch (Exception e){
            return new Message(e);
        }
    }

    @Override
    public <T> Message post(Endpoint endpoint, T body) {
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
