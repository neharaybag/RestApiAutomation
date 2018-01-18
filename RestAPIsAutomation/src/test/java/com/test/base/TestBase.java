package com.test.base;

import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;

public class TestBase {
  
 

	static {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	RequestSpecBuilder builder = new RequestSpecBuilder();
	protected RequestSpecification spec = builder.build();
	private SoftAssert softAssert = new SoftAssert();

	public TestBase() {

	}

	@BeforeTest
	public void beforeTest() {
	

	}

	@AfterTest
	public void afterTest() {
	}

}
