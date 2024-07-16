package api;

import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public abstract class AbstractModuleSender {
    protected final RestTemplate restTemplate = new RestTemplate();

    protected final RequestCallback requestCallback = request -> {
        request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
    };
    protected final ResponseExtractor<String> responseExtractor = new ResponseExtractor<String>() {
        @Override
        public String extractData(ClientHttpResponse response) throws IOException {
            return response.getBody().toString();
        }
    };
}
