package com.evaluation.automation.api.test.beans;

import com.evaluation.automation.api.test.constants.ValidateConstants;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Serializable bean class for serializing the promotion elements of the response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Promotion implements Serializable {


    @JsonProperty(ValidateConstants.RESPONSE_VALIDATE_PROMOTIONS_ELEMENT_NAME)
    private String name;
    @JsonProperty(ValidateConstants.RESPONSE_VALIDATE_PROMOTIONS_DESCRIPTION_ELEMENT_NAME)
    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
