package com.everis.jiraclient.domain;

import java.util.Date;

public class Version {
	
	private String self;
	
	private int id;
	
	private String name;
	
	private boolean overdue;
	
	private String userReleaseDate;
	
	private boolean archived;
	
	private String releaseDate;
	
	private boolean released;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOverdue() {
		return overdue;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	public String getUserReleaseDate() {
		return userReleaseDate;
	}

	public void setUserReleaseDate(String userReleaseDate) {
		this.userReleaseDate = userReleaseDate;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isReleased() {
		return released;
	}

	public void setReleased(boolean released) {
		this.released = released;
	}
}