
package com.rest.services;
import com.rest.dbutil.DBUtil;
import com.rest.dbutil.DBUtilInterface;
import com.rest.model.AdCampaignModel;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class AdCampaignImpl implements RestServiceInterface{
	Logger logger = Logger.getLogger(AdCampaignImpl.class.getName());
	DBUtilInterface dbutil = new DBUtil();
	public static final String sep = "~";

	public List<AdCampaignModel> getAds(String id , String attributeName){
		return dbutil.find(attributeName, id, AdCampaignModel.class);
	}
	public List<AdCampaignModel> getAdsByTitleAndDuration(String id){
		String[] values = id.split(sep);
		String[] attributeNames = {"adTitle","adDuration"};
		return dbutil.find(attributeNames, values, AdCampaignModel.class);
	
	}

	public AdCampaignModel createAd(AdCampaignModel adCampaign) {
	  String partnerID = adCampaign.getPartnerId();
	  String[] attributeNames = {"partnerId","adStatus"};
	  String[] values = {partnerID,"true"};
	  AdCampaignModel  existingActiveAd = dbutil.findOne(attributeNames,values, AdCampaignModel.class);
	  if(existingActiveAd == null){
		  operations.insert(adCampaign);
		  return dbutil.findOne(attributeNames,values, AdCampaignModel.class);
       }
		else{
			// Return error message
		}
	  return null;
	}

	public List<AdCampaignModel> updateAd(AdCampaignModel adCampaign) {
		String partnerID = adCampaign.getPartnerId();
        return dbutil.update(AdCampaignModel.class, adCampaign);
	}
	public List<AdCampaignModel> getAds() {
		return operations.findAll(AdCampaignModel.class);
	}

	
}
