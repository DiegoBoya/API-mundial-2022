package diego.worldcup.api.mundial22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public abstract class BaseService {

	@Value("${worldcup.base.url}")
	protected String baseUrl;

	@Autowired
	protected RestTemplate restTemplate;
	
	protected HttpHeaders buildAuthToken(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Bearer "+token);
		return headers;
	}
}
