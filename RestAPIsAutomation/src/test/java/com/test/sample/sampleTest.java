package com.test.sample;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.test.base.TestBase;
import com.test.restAPIUtitlities.RequestBuilder;
import com.test.restAPIsMethods.GetMethods;

public class sampleTest extends TestBase {

	@Test
	public void test () {

		HashMap<String, String> headears = new HashMap<String, String>();
		headears.put("test", "test");
		RequestBuilder req=new RequestBuilder();
		spec=req.getrequestSpecHeaders(headears,spec);
		spec=req.setBasicAuth("name", "password", spec);
		System.out.println("test");
				
	}
}
