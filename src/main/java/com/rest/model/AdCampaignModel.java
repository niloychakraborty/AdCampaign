
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
public class AdCampaignModel {

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
    public String getPartnerId() {
        return partnerId;
    }

    @JsonProperty("partner_id")
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("ad_content")
    public String getAdContent() {
        return adContent;
    }

    @JsonProperty("ad_content")
    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }

    @JsonProperty("ad_title")
    public String getAdTitle() {
        return adTitle;
    }

    @JsonProperty("ad_title")
    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    @JsonProperty("ad_status")
    public String getAdStatus() {
        return adStatus;
    }

    @JsonProperty("ad_status")
    public void setAdStatus(String adStatus) {
        this.adStatus = adStatus;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
