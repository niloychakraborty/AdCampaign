package com.rest.dbutil;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.rest.model.AdCampaignModel;

public class DBUtil implements DBUtilInterface{
	
	public static DBUtil dbUtil ;
	
	public List<AdCampaignModel> find(String attributeName, String value, Class entityClass) {
		Query query = new Query(where(attributeName).is(value));
		List<AdCampaignModel> objectList = operations.find(query, entityClass);
		return objectList;
	}
	public List<AdCampaignModel> find(String attributeNames[], String values[], Class entityClass) {
		Query query = new Query(where(attributeNames[0]).is(values[0]).and(attributeNames[1]).is(values[1]));
		List<AdCampaignModel> objectList = operations.find(query,entityClass);
		return objectList;
	}
	public List<AdCampaignModel> findAll(Class className) {
		return operations.findAll(className);
	}
	public List<AdCampaignModel> update(Class className,AdCampaignModel adCampaign) {
		WriteResult wr;
		Query query = new Query(where("partnerId").is(adCampaign.getPartnerId()).and("adStatus").is("true"));
		//This logic should be optimized
		Update update = new Update();
		wr = operations.updateFirst(query, update.update("adDuration", adCampaign.getDuration()) , AdCampaignModel.class);
		wr = operations.updateFirst(query, update.update("adTitle", adCampaign.getAdTitle()) , AdCampaignModel.class);
		wr = operations.updateFirst(query, update.update("adContent", adCampaign.getAdContent()) , AdCampaignModel.class);
		wr = operations.updateFirst(query, update.update("adStatus", adCampaign.getAdStatus()) , AdCampaignModel.class);
		List<AdCampaignModel>  existingActiveAd = operations.find(query, AdCampaignModel.class);
		return existingActiveAd;
		
	}
	@Override
	public AdCampaignModel findOne(String[] attributeNames, String[] values, Class EntityClass) {
		  Query query = new Query(where(attributeNames[0]).is(values[0]).and(attributeNames[1]).is(values[1]));
		  return operations.findOne(query, AdCampaignModel.class);
	}
}
