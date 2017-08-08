package com.rest.application.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.rest.application.CampaignAdApplication;
import com.rest.model.AdCampaignModel;
import com.rest.model.AdCampaignModelBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CampaignAdApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CampaignAdApplicationIT {
	
	@LocalServerPort
	private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
	@Test
	public void testCampaignApplication() {
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		ResponseEntity<List<AdCampaignModel>> response = restTemplate.exchange(
				                          createURLWithPort("/adcampaigns/10001"),
				                          HttpMethod.GET,entity,
				          				new ParameterizedTypeReference<List<AdCampaignModel>>() {
				          				});
		AdCampaignModel  expected =  new AdCampaignModelBuilder().setAdContent("Test Content 1")
	            .setAdStatus("true")
	            .setAdTitle("Nike")
	            .setDuration(new Integer(1))
	            .setPartnerId("10001").build();
		System.out.println(response.getBody().get(0).getAdContent());
		System.out.println(response.getBody().get(0).getAdTitle());
		System.out.println(response.getBody().get(0).getAdStatus());
		System.out.println(response.getBody().get(0).getPartnerId());
		System.out.println(response.getBody().get(0).getDuration());
		System.out.println(expected.equals(response.getBody().get(0)));
		 assertTrue(response.getBody().contains(expected));
	}
	private String createURLWithPort(final String uri) {
		return "http://localhost:" + port + uri;
	}
}
