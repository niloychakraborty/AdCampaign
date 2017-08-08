package com.rest.application.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rest.controller.AdCampaignController;
import com.rest.model.AdCampaignModel;
import com.rest.model.AdCampaignModelBuilder;
import com.rest.services.AdCampaignImpl;

@RunWith(SpringRunner.class)
@ComponentScan(basePackageClasses = AdCampaignController.class)
@WebMvcTest(value=AdCampaignController.class, secure=false)
public class CampaignAdApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@MockBean 
	AdCampaignImpl adCampaignService;
	AdCampaignModel  adCampaignOut =  new AdCampaignModelBuilder().setAdContent("Test Content 1")
            .setAdStatus("true")
            .setAdTitle("Nike")
            .setDuration(Integer.parseInt("1"))
            .setPartnerId("10001")
            .build();

	@Test
	public void testAdCampaignControler() throws Exception {
		ArrayList<AdCampaignModel> adCampaignArr = new ArrayList<AdCampaignModel>();
		adCampaignArr.add(adCampaignOut);
		Mockito.when(
				 adCampaignService.getAds(Mockito.anyString(),Mockito.anyString())).thenReturn(adCampaignArr);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/adcampaignsbypartnerid/10001").accept(
				MediaType.APPLICATION_JSON);

                mockMvc.perform(requestBuilder)
	                   .andExpect(status().isOk())
	                   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
	                   .andExpect(jsonPath("$[0].partner_id", is("10001")))
                       .andExpect(jsonPath("$[0].duration",is(1)))
                       .andExpect(jsonPath("$[0].ad_content",is("Test Content 1")))
                       .andExpect(jsonPath("$[0].ad_title",is("Nike")))
                       .andExpect(jsonPath("$[0].ad_status",is("true")));
               
	}
}

