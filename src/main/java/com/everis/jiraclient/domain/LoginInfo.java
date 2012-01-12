package com.everis.jiraclient.domain;

import java.util.Date;

public class LoginInfo {
	
	public Date getLastFailedLoginTime() {
		return lastFailedLoginTime;
	}

	public void setLastFailedLoginTime(Date lastFailedLoginTime) {
		this.lastFailedLoginTime = lastFailedLoginTime;
	}

	public Date getPreviousLoginTime() {
		return previousLoginTime;
	}

	public void setPreviousLoginTime(Date previousLoginTime) {
		this.previousLoginTime = previousLoginTime;
	}

	private int failedLoginCount;

	private int loginCount;
	
	private Date lastFailedLoginTime;
	
	private Date previousLoginTime;

	public int getFailedLoginCount() {
		return failedLoginCount;
	}

	public void setFailedLoginCount(int failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
}
