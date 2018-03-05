package de.cultuzz.roomrateinfofetcher.resclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cultagent.bestday.GatewayRequest;
import com.cultagent.bestday.Response;

@Component
public class RestClient {
	
	public Response postXmlToBestDay(GatewayRequest gatewayRequest,String url){
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<GatewayRequest> request = new HttpEntity<GatewayRequest>(gatewayRequest);
		ResponseEntity<Response> response = restTemplate.postForEntity(url, request , Response.class );
		Response gatewayResult = response.getBody();
		return gatewayResult;	
	}

}
