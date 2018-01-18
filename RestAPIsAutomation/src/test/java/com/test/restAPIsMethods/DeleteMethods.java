package com.test.restAPIsMethods;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class DeleteMethods {

	/**
	 * @param uri
	 * @return
	 */
	public Response deletetWithURI(String uri,RequestSpecification requestspec) {
		Response response = RestAssured.given().spec(requestspec).log().all().delete(uri);
		return response;
	}

	/**
	 * @param url
	 * @return
	 */
	public Response deleteWithURL(String url,RequestSpecification requestspec) {
		Response response = RestAssured.given().log().all().delete(url);
		return response;
	}

	/**
	 * This method accepts Map as input for get request (JSON request)
	 * 
	 * @param restAssured
	 * @param path
	 * @param pathParams
	 * @return
	 */
	public Response deleteWithMap(String path, Map<String, String> pathParams,RequestSpecification requestspec) {

		Response response = RestAssured.given().request().log().all().delete(path, pathParams);
		return response;

	}

	/**
	 * This method accepts jsonobject as input for get request (JSON request)
	 * 
	 * @param restAssured
	 * @param path
	 * @param pathParams
	 * @return
	 */
	public Response deleteWithJson(String path, JsonObject jsonRequest,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().log().all().accept(ContentType.JSON).body(jsonRequest).when()
				.delete(path);
		return response;

	}

	/**
	 * @param parameters
	 * @param url
	 * @return
	 */
	public Response deleteRequestwithJsonMap(HashMap<String, String> parameters, String url,RequestSpecification requestspec) {
		Response response;
		response = RestAssured.given().accept(ContentType.JSON).log().all().body(new Gson().toJson(parameters)).when()
				.delete(url);
		return response;
	}

	/**
	 * @param parameters
	 * @param url
	 * @return
	 */
	public Response deleteWithQueryParams(HashMap<String, String> parameters, String url,RequestSpecification requestspec) {
		Response response = RestAssured.given().parameters(parameters).when().delete(url);
		return response;

	}

	/**
	 * This method accepts input as object (ContentType JSON)
	 * 
	 * @param path
	 * @param requestobj
	 * @return
	 */
	public Response deleteWithObject(String path, Object requestobj,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().log().all().delete(path, requestobj);
		return response;

	}

	/**
	 * This method is for get method request as xml Type
	 * 
	 * @param path
	 * @param pathParams
	 * @return
	 */
	public Response deleteWithXML(String path, Map<String, String> pathParams,RequestSpecification requestspec) {
		Response response = RestAssured.given().request().log().all().accept(ContentType.XML).body(pathParams).when()
				.delete(path);
		return response;

	}

}
