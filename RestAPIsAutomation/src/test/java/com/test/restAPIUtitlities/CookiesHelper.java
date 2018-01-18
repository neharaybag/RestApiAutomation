package com.test.restAPIUtitlities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookies;

/**
 * @author neha.raybagkar
 *
 */
public class CookiesHelper {

	/**
	 * @param name
	 * @param val
	 * @param setSecured
	 * @param comment
	 * @return
	 */
	public Cookie buildCookie(String name, String val, boolean setSecured, String comment) {
		Cookie cookie = new Cookie.Builder(name, val).setSecured(setSecured).setComment(comment).build();
		return cookie;
	}

	/**
	 * @param cookiesList
	 * @return
	 */
	public Cookies buidDetailedCookies(List<Cookie> cookiesList) {
		Cookies cookies = new Cookies(cookiesList);
		return cookies;

	}

}
