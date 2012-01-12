package com.everis.jiraclient;

import javax.ws.rs.core.Cookie;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.everis.jiraclient.domain.LoginData;
import com.everis.jiraclient.domain.LoginResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class SessionClient {
	
	private String resourceURL;
	
	private static final String SESSION_RESOURCE_PATH = "/auth/1/session";
	
	public SessionClient(String url){
		resourceURL = url;
	}
	
	public LoginResponse login(String username, String password){
    	ClientConfig config = new DefaultClientConfig();
    	config.getClasses().add(JacksonJsonProvider.class);
    	Client client = Client.create(config);
    	WebResource wr = client.resource(resourceURL); 
    	ClientResponse response = wr.path(SESSION_RESOURCE_PATH).type("application/json").post(ClientResponse.class, "{\"username\" : \"" + username + "\", \"password\" : \"" + password + "\"}");
    	LoginData data = response.getEntity(LoginData.class);
    	Cookie cookie = response.getCookies().get(0);
    	return new LoginResponse(cookie, data);
    }
    
    public void logout(Cookie cookie){
    	ClientConfig config = new DefaultClientConfig();
    	config.getClasses().add(JacksonJsonProvider.class);
    	Client client = Client.create(config);
    	WebResource wr = client.resource("http://217.124.190.3/jira/rest");
    	wr.path(SESSION_RESOURCE_PATH).cookie(cookie).type("application/json").delete();
    }
}
