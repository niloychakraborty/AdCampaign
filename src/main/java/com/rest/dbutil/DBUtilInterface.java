package com.rest.dbutil;

import java.util.HashMap;
import java.util.List;

import com.rest.model.AdCampaignModel;
import com.rest.services.RestServiceInterface;

public interface DBUtilInterface extends RestServiceInterface {
	public List<AdCampaignModel> find(String attributeName, String value, Class entityClass);
	public List<AdCampaignModel> find(String attributeNames[], String values[], Class entityClass);
	public List<AdCampaignModel> findAll(Class className);
	public List<AdCampaignModel> update(Class className,AdCampaignModel adCampaign);
	public AdCampaignModel findOne(String attributeNames[], String values[], Class EntityClass);
	
}
