package com.test.restAPIsMethods;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author neha.raybagkar
 *
 */
public class PutMethods {

	/**
	 * @param uri
	 * @return
	 */
	public Response putWithURI(String uri,RequestSpecification requestspec) {
		Response response = RestAssured.given().spec(requestspec).log().all().put(uri);
		return response;
	}

	/**
	 * @param url
	 * @return
	 */
	public Response putWithURL(String url,RequestSpecification requestspec) {
		Response response = RestAssured.given().spec(requestspec).log().all().put(url);
		return response;
	}

	/**
	 * @param path
	 * @param pathParams
	 * @return
	 */
	public Response putWithMap(String path, Map<String, String> pathParams,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().spec(requestspec).log().all().accept(ContentType.JSON)
				.body(new Gson().toJson(pathParams)).when().put(path);
		return response;

	}

	/**
	 * @param parameters
	 * @param url
	 * @return
	 */
	public Response putRequestwithJsonMap(HashMap<String, String> parameters, String url,RequestSpecification requestspec) {
		Response response;
		response = RestAssured.given().request().spec(requestspec).accept(ContentType.JSON).log().all().body(new Gson().toJson(parameters)).when()
				.put(url);
		return response;
	}

	/**
	 * @param path
	 * @param jsonRequest
	 * @return
	 */
	public Response putWithJson(String path, JsonObject jsonRequest,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().spec(requestspec).log().all().accept(ContentType.JSON).body(jsonRequest).when()
				.put(path);
		return response;

	}

	/**
	 * @param parameters
	 * @param url
	 * @return
	 */
	public Response putWithQueryParams(HashMap<String, String> parameters, String url,RequestSpecification requestspec) {
		Response response = RestAssured.given().parameters(parameters).when().put(url);
		return response;

	}

	/**
	 * @param path
	 * @param requestobj
	 * @return
	 */
	public Response putWithObject(String path, Object requestobj,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().log().all().accept(ContentType.JSON).body(requestobj).when()
				.put(path);
		return response;

	}
	
	/**
	 * @param path
	 * @param pathParams
	 * @return
	 */
	public Response putWithXML(String path, Map<String, String> pathParams,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().log().all().accept(ContentType.XML).body(pathParams).when()
				.put(path);
		return response;

	}

}
