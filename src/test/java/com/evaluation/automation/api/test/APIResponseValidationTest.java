package com.evaluation.automation.api.test;

import com.evaluation.automation.api.test.beans.CarbonCredit;
import com.evaluation.automation.api.test.beans.Promotion;
import com.evaluation.automation.api.test.constants.ValidateConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Optional;

/**
 * This test class will validate the response from the API with the predefined set of values on the response
 */
public class APIResponseValidationTest {
    ResponseEntity<CarbonCredit> response;

    @BeforeTest
    public void init() {
        RestTemplate restTemplate = new RestTemplate();
        String apiResourceUrl = System.getProperty(ValidateConstants.API_BACKEND_URL_PROPERTY_NAME);
        //Generate a response object based on the respone elements from the response from the get request
        response = restTemplate.getForEntity(apiResourceUrl + "/1", CarbonCredit.class);
    }

    @Test(description = "Validates the api response verify status of response and availability of content")
    public void endpointResponseValidation() {
        Assert.assertEquals(response.getStatusCode(), (HttpStatus.OK));
        Assert.assertNotNull(response.getBody());
    }

    @Test(dependsOnMethods = {"endpointResponseValidation"}, description = "Validate whether Response element Name")
    public void responseNameValidation() {
        Assert.assertEquals(response.getBody().getName(), ValidateConstants.RESPONSE_VALIDATE_NAME_VALUE);
    }

    @Test(dependsOnMethods = {"endpointResponseValidation"}, description = "Validate CanRelist response value")
    public void responseCanRelistStateValidation() {
        Assert.assertEquals(response.getBody().isCanRelist(), ValidateConstants.RESPONSE_VALIDATE_CANRELIST_VALUE);
    }

    @Test(dependsOnMethods = {"endpointResponseValidation"}, description = "Validate promotion response value")
    public void responsePromotionCaptionValidation() {
        Optional<Promotion> promotionElement = response.getBody().getPromotionsBean().stream()
                .filter(promotion ->
                        ValidateConstants.RESPONSE_VALIDATE_PROMOTIONS_ELEMENT_VALUE.equals(promotion.getName()))
                .findAny();
        //Performing a null check for negative case of node being unavailable.
        if (promotionElement.isPresent()) {
            Assert.assertTrue(promotionElement.get().getDescription()
                            .contains(ValidateConstants.RESPONSE_VALIDATE_PROMOTIONS_DESCRIPTION_CONTENT),
                    "Gallery does not contain"
                            + ValidateConstants.RESPONSE_VALIDATE_PROMOTIONS_DESCRIPTION_CONTENT);
        } else {
            //If element is not available test will be failed with the message sending element was not sent
            Assert.fail("Promotion not present to evaluate");
        }

    }

}
