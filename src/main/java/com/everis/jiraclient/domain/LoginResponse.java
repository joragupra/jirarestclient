package com.everis.jiraclient.domain;

import javax.ws.rs.core.Cookie;

public class LoginResponse {

	private LoginData loginData;
	
	private Cookie cookie;
	
	public LoginResponse(Cookie cookie, LoginData data){
		this.cookie = cookie;
		this.loginData = data;
	}
	
	public LoginData getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	public Cookie getCookie() {
		return cookie;
	}

	public void setCookie(Cookie cookie) {
		this.cookie = cookie;
	}	
}