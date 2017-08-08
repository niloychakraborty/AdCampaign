package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.AdCampaignModel;
import com.rest.services.AdCampaignImpl;


@RestController
@ComponentScan(basePackages = {"com.rest.services"})
public class AdCampaignController {
	@Autowired
	private AdCampaignImpl  adService;
	
 /*   @RequestMapping(method= RequestMethod.GET,value="/adcampaigns1")
 	public List<AdCampaignModel> getAds(@RequestBody AdCampaignModel input){
		return adService.getAd(input);
	}
	*/
    @RequestMapping(method= RequestMethod.GET,value="/adcampaignsbypartnerid/{id}")
 	public List<AdCampaignModel> getAdsByParentId(@PathVariable String id){
		return adService.getAds(id,"partnerId");
	}
    @RequestMapping(method= RequestMethod.GET,value="/adcampaignsbyadcontent/{id}")
 	public List<AdCampaignModel> getAdsByContent(@PathVariable String id){
		return adService.getAds(id,"adContent");
	}
    @RequestMapping(method= RequestMethod.GET,value="/adcampaignsbyadtitle/{id}")
 	public List<AdCampaignModel> getAdsByTitle(@PathVariable String id){
		return adService.getAds(id,"adTitle");
	}
    @RequestMapping(method= RequestMethod.GET,value="/adcampaignsbyadduration/{id}")
 	public List<AdCampaignModel> getAdsByDuration(@PathVariable String id){
		return adService.getAds(id,"adDuration");
	}
    @RequestMapping(method= RequestMethod.GET,value="/adcampaignsbyadtitleandduration/{id}")
 	public List<AdCampaignModel> getAdsByTitleAndDuration(@PathVariable String id){
		return adService.getAdsByTitleAndDuration(id);
	}
    @RequestMapping(method= RequestMethod.GET,value="/adcampaigns")
 	public List<AdCampaignModel> getAds(){
		return adService.getAds();
	}
    @RequestMapping(method=RequestMethod.POST, value="/createadcampaign")
	public AdCampaignModel createAd( @RequestBody AdCampaignModel adCampaign){
    	return adService.createAd(adCampaign);
	}
    
    @RequestMapping(method=RequestMethod.PUT, value="/updateadcampaign")
	public List<AdCampaignModel> updateAd( @RequestBody AdCampaignModel adCampaign){
    	return adService.updateAd(adCampaign);
	}
}
