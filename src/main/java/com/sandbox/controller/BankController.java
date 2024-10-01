package com.sandbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.sandbox.model.BankResponseDTO;
import com.sandbox.utils.TokenUtils;

@RestController
@RequestMapping(path = "/bank")
public class BankController {

	private final String BASE_URL = "https://apisandbox.openbankproject.com/obp/v4.0.0";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/banks", method = RequestMethod.GET)
	public ResponseEntity<?> getAccounts() {
	    String url = BASE_URL + "/banks";

	    String authToken = TokenUtils.getExternalToken(restTemplate);
	    if (authToken == null || authToken.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or missing token");
	    }

	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Authorization", "DirectLogin token=\"" + authToken + "\"");
	    HttpEntity<String> entity = new HttpEntity<>(headers);

	    try {
	        ResponseEntity<BankResponseDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity,
	                BankResponseDTO.class);
	        return ResponseEntity.ok(response.getBody());

	    } catch (HttpClientErrorException e) {
	        return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
	    } catch (HttpServerErrorException e) {
	        return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown error: " + e.getMessage());
	    }
	}


}
