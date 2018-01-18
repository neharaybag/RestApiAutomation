package com.test.restAPIsMethods;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.test.base.BaseClass;

/**
 * @author neha.raybagkar
 *
 */
/**
 * @author neha.raybagkar
 *
 */
/**
 * @author neha.raybagkar
 *
 */
public class GetMethods extends BaseClass {


	/**
	 * @param uri
	 * @param requestSpec
	 * @return
	 */
	public Response getWithURI(String uri,RequestSpecification requestSpec) {
		Response response = RestAssured.given().spec(requestSpec).log().all().get(uri);
		return response;
	}

	
	/**
	 * @param url
	 * @param requestSpec
	 * @return
	 */
	public Response getWithURL(String url,RequestSpecification requestSpec) {
		Response response = RestAssured.given().spec(requestSpec).log().all().get(url);
		return response;
	}

	
	/**
	 * @param path
	 * @param pathParams
	 * @param requestSpec
	 * @return
	 */
	public Response getWithMap(String path, Map<String, String> pathParams,RequestSpecification requestSpec) {
		Response response = RestAssured.given().request().spec(requestSpec).log().all().accept(ContentType.JSON).when().get(path,
				pathParams);
		return response;

	}

	
	/**
	 * @param path
	 * @param jsonRequest
	 * @param requestSpec
	 * @return
	 */
	public Response getWithJson(String path, JsonObject jsonRequest,RequestSpecification requestSpec) {
		Response response = RestAssured.given().request().spec(requestSpec).log().all().accept(ContentType.JSON).body(jsonRequest).when()
				.get(path);
		return response;

	}

	
	/**
	 * @param parameters
	 * @param url
	 * @param requestSpec
	 * @return
	 */
	public Response getRequestwithJsonMap(HashMap<String, String> parameters, String url,RequestSpecification requestSpec) {
		Response response;
		response = RestAssured.given().request().spec(requestSpec).accept(ContentType.JSON).log().all().body(new Gson().toJson(parameters)).when()
				.get(url);
		return response;
	}

	
	/**
	 * @param path
	 * @param requestobj
	 * @param requestSpec
	 * @return
	 */
	public Response getWithObject(String path, Object requestobj,RequestSpecification requestSpec) {
		Response response = RestAssured.given().request().spec(requestSpec).log().all().accept(ContentType.JSON).when().get(path,
				requestobj);
		return response;

	}

	/**
	 * @param parameters
	 * @param url
	 * @return
	 */
	public Response getWithQueryParams(HashMap<String, String> parameters, String url,RequestSpecification requestSpec) {
		Response response = RestAssured.given().request().spec(requestSpec).parameters(parameters).when().get(url);
		return response;

	}

	
	/**
	 * @param path
	 * @param pathParams
	 * @param requestSpec
	 * @return
	 */
	public Response getWithXML(String path, Map<String, String> pathParams,RequestSpecification requestSpec) {
		Response response = RestAssured.given().request().spec(requestSpec).log().all().accept(ContentType.XML).body(pathParams).when()
				.get(path);
		return response;

	}

}
