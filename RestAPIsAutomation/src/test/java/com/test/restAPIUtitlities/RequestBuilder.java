package com.test.restAPIUtitlities;

import java.util.Map;
import com.jayway.restassured.authentication.BasicAuthScheme;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.specification.RequestSpecification;


/**
 * @author neha.raybagkar
 *
 */

public class RequestBuilder {

  /**
   * @param headers
   * @return
   */
  public RequestSpecification getrequestSpecHeaders(Map<String, String> headers, RequestSpecification requestSpec) {
    return requestSpec.headers(headers);

  }

  /**
   * @param cookies
   * @return
   */
  public RequestSpecification getrequestSpecCookies(Cookies cookies, RequestSpecification requestSpec) {
    return requestSpec.cookies(cookies);

  }

  /**
   * @param username
   * @param password
   * @return
   */
  public RequestSpecification setBasicAuth(String username, String password, RequestSpecification requestSpec) {

    return requestSpec.auth().basic(username, password);


  }

  /**
   * @param username
   * @param password
   * @param requestSpec
   * @return
   */
  public RequestSpecification setBasicAuthPreemptive(String username, String password,
      RequestSpecification requestSpec) {

    return requestSpec.auth().preemptive().basic(username, password);


  }
  
  /**
   * @param username
   * @param password
   * @param requestSpec
   * @return
   */
  public RequestSpecification setDigestAuth(String username, String password,
      RequestSpecification requestSpec) {

    return requestSpec.auth().digest(username, password);


  }




}
