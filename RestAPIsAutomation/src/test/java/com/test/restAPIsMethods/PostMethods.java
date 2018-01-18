package com.test.restAPIsMethods;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class PostMethods {

	/**
	 * @param uri
	 * @return
	 */
	public Response postWithUri(String uri,RequestSpecification requestspec) {
		Response response = RestAssured.given().spec(requestspec).log().all().post(uri);
		return response;
	}

	/**
	 * @param url
	 * @return
	 */
	public Response postWithUrl(String url,RequestSpecification requestspec) {
		Response response = RestAssured.given().spec(requestspec).log().all().post(url);
		return response;
	}

	/**
	 * @param path
	 * @param pathParams
	 * @return
	 */
	public Response postWithMap(String path, Map<String, String> pathParams,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().spec(requestspec).log().all().accept(ContentType.JSON)
				.body(new Gson().toJson(pathParams)).when().post(path);

		return response;

	}
	
	/**
	 * @param parameters
	 * @param url
	 * @return
	 */
	public Response postRequestwithJsonMap(HashMap<String, String> parameters, String url,RequestSpecification requestspec) {
		Response response;
		response = RestAssured.given().request().spec(requestspec).accept(ContentType.JSON).log().all().body(new Gson().toJson(parameters)).when()
				.post(url);
		return response;
	}
	
	/**
	 * @param parameters
	 * @param url
	 * @return
	 */
	public Response postWithQueryParams(HashMap<String, String> parameters, String url,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().spec(requestspec).parameters(parameters).when().post(url);
		return response;

	}

	/**
	 * @param path
	 * @param jsonRequest
	 * @return
	 */
	public Response postWithJson(String path, JsonObject jsonRequest,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().log().all().accept(ContentType.JSON).body(jsonRequest).when()
				.post(path);
		return response;

	}
	
	/**
	 * @param path
	 * @param requestobj
	 * @return
	 */
	public Response postWithObject(String path, Object requestobj,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().spec(requestspec).log().all().accept(ContentType.JSON).when().post(path,
				requestobj);
		return response;
	}
	
	/**
	 * @param path
	 * @param pathParams
	 * @return
	 */
	public Response postWithXML(String path, Map<String, String> pathParams,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().spec(requestspec).log().all().accept(ContentType.XML).body(pathParams).when()
				.post(path);
		return response;

	}

}
