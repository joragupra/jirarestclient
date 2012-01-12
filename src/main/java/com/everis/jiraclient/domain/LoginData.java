package com.everis.jiraclient.domain;

import javax.ws.rs.Path;

@Path("/")
public class LoginData {
	
	private Session session;
	
	private LoginInfo loginInfo;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
}
