package httc_backend.data_processor.PublicApiClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class PublicApiClient {
    @Value("${concordia.api.auth}")
    private String concordiaApiAuth;

    private static final Logger logger = LoggerFactory.getLogger(PublicApiClient.class);
    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> fetchSchedulesFromConcordiaApi(){
        String url = "https://opendata.concordia.ca/API/v1/course/schedule/filter/*/*/*";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + base64());
        logger.info("Sending request to {}", url);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        logger.info("Received request from {}", url);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    private String base64() {
        return Base64.getEncoder()
                .encodeToString(concordiaApiAuth.getBytes());
    }
}
