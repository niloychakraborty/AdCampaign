package com.rest.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rest.model.AdCampaignModel;

public interface CampaignRepository extends MongoRepository<AdCampaignModel, String> {

}
