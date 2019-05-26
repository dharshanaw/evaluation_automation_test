package com.evaluation.automation.api.test.beans;

import com.evaluation.automation.api.test.constants.ValidateConstants;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * This class is the serializable object for API response for mapping. This bean will hold values
 * of the response to carried out for other test steps.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarbonCredit implements Serializable {

    @JsonProperty(ValidateConstants.RESPONSE_VALIDATE_NAME_ELEMENT_NAME)
    private String name;
    @JsonProperty(ValidateConstants.RESPONSE_VALIDATE_CANRELIST_ELEMENT_NAME)
    private boolean canRelist;
    @JsonProperty(ValidateConstants.RESPONSE_VALIDATE_PROMOTIONS_ELEMENT)
    private List<Promotion> promotionList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanRelist() {
        return canRelist;
    }

    public void setCanRelist(boolean canRelist) {
        this.canRelist = canRelist;
    }

    public List<Promotion> getPromotionsBean() {
        return promotionList;
    }

    public void setPromotionsBean(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }
}
