package com.test.restResponseVerifications;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.jayway.restassured.response.Response;

/**
 * @author neha.raybagkar
 *
 */
public class Verifications {

  protected Logger logger = Logger.getLogger(this.getClass().getName());


  /**
   * @param response
   * @param code
   */
  public boolean verifystatus(Response response, int code) {

    try {
      Assert.assertEquals(response.getStatusCode(), code);
      return true;
    } catch (AssertionError assertError) {
      logger.error("Expected code was" + code + "Actual code was" + response.getStatusCode());
      return false;
    }


  }

  /**
   * @param response
   * @param line
   * @param softAssert
   * @return
   */
  public boolean verifyStatusLine(Response response, String line, SoftAssert softAssert) {
    try {
      Assert.assertEquals(response.getStatusLine(), line);
      return true;
    } catch (AssertionError assertError) {
      logger.error("Expected code was" + line + "Actual code was" + response.getStatusLine());
      return false;
    }
  }

  /**
   * @param path
   * @param response
   * @return
   */
  public List<String> getValuesSpecifcPath(String path, Response response) {
    List<String> values = response.path(path);
    return values;
  }

  /**
   * @param expectedVal
   * @param headerName
   * @param response
   * @return
   */
  public boolean verifyHeaderValues(String expectedVal, String headerName, Response response) {
    String headerVal = response.getHeader(headerName);
    try {

      Assert.assertEquals(headerVal, expectedVal);
      return true;
    } catch (AssertionError assertError) {
      logger.error("Expected header value was" + expectedVal + "Actual header value was" + headerVal);
      return false;

    }
  }

}
