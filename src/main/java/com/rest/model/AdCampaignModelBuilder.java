
package com.rest.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "partner_id",
    "duration",
    "ad_content",
    "ad_title",
    "ad_status"
})
public class AdCampaignModelBuilder {

    @JsonProperty("partner_id")
    private String partnerId;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("ad_content")
    private String adContent;
    @JsonProperty("ad_title")
    private String adTitle;
    @JsonProperty("ad_status")
    private String adStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("partner_id")
    public AdCampaignModelBuilder setPartnerId(String partnerId) {
        this.partnerId = partnerId;
        return this;
    }

    @JsonProperty("duration")
    public AdCampaignModelBuilder setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }
    @JsonProperty("ad_content")
    public AdCampaignModelBuilder setAdContent(String adContent) {
        this.adContent = adContent;
        return this;
    }
    @JsonProperty("ad_title")
    public AdCampaignModelBuilder setAdTitle(String adTitle) {
        this.adTitle = adTitle;
        return this;
    }
    @JsonProperty("ad_status")
    public AdCampaignModelBuilder setAdStatus(String adStatus) {
        this.adStatus = adStatus;
        return this;
    }
    @JsonAnySetter
    public AdCampaignModelBuilder setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
    
    public AdCampaignModel build()
    {
    	AdCampaignModel adCampaignModel = new AdCampaignModel();
    	adCampaignModel.setAdContent(adContent);
    	adCampaignModel.setAdStatus(adStatus);
    	adCampaignModel.setAdTitle(adTitle);
    	adCampaignModel.setDuration(duration);
    	adCampaignModel.setPartnerId(partnerId);
    	return adCampaignModel;
    }
    

}
