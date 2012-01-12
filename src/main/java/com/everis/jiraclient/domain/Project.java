package com.everis.jiraclient.domain;

import java.util.List;
import java.util.Map;

public class Project {
	
	private String self;
	
	private String key;
	
	private String name;
	
	private Lead lead;
	
	private List<Component> components;
	
	private List<IssueType> issueTypes;
	
	private List<Version> versions;
	
	private String assigneeType;
	
	private Map<String,String> roles;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public List<IssueType> getIssueTypes() {
		return issueTypes;
	}

	public void setIssueTypes(List<IssueType> issueTypes) {
		this.issueTypes = issueTypes;
	}

	public String getAssigneeType() {
		return assigneeType;
	}

	public void setAssigneeType(String assigneeType) {
		this.assigneeType = assigneeType;
	}

	public List<Version> getVersions() {
		return versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

	public Map<String, String> getRoles() {
		return roles;
	}

	public void setRoles(Map<String,String> roles) {
		this.roles = roles;
	}
}
