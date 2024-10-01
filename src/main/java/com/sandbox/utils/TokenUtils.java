package com.sandbox.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sandbox.model.TokenDTO;

public class TokenUtils {
	
	private static final String URL = "https://apisandbox.openbankproject.com/my/logins/direct";

	public static String getExternalToken(RestTemplate restTemplate) {
		HttpHeaders headers = new HttpHeaders();
		String authorizationHeader = "DirectLogin username=ellie.uk.29@example.com, password=a81594, consumer_key=4j5psxm055juthdfrj1hpcwawn4qlshkoelkz3s4";
		headers.set("Authorization", authorizationHeader);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		try {
			ResponseEntity<TokenDTO> response = restTemplate.exchange(URL, HttpMethod.POST, entity, TokenDTO.class);
			return response.getBody().getToken();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
