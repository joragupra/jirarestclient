package com.everis.jiraclient;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jettison.json.JSONObject;

import com.everis.jiraclient.domain.LoginInfo;
import com.everis.jiraclient.domain.LoginData;
import com.everis.jiraclient.domain.LoginResponse;
import com.everis.jiraclient.domain.Project;
import com.everis.jiraclient.domain.Session;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.json.impl.provider.entity.JSONRootElementProvider;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
    	SessionClient sessionClient = new SessionClient("http://217.124.190.3/jira/rest");
    	Cookie cookie = sessionClient.login("jagudopr", "pr0y3ct0XXX").getCookie();
    	
    	ClientConfig config = new DefaultClientConfig();
    	config.getClasses().add(JacksonJsonProvider.class);
    	Client c = Client.create(config);
    	WebResource res = c.resource("http://217.124.190.3/jira/rest/api/2.0.alpha1/project");
    	String proyectos = res.cookie(cookie).get(String.class);
    	System.out.println("Proyectos:\n" + proyectos);
    	res = c.resource("http://217.124.190.3/jira/rest/api/2.0.alpha1/project/AFIRMA");
    	String proyecto = res.cookie(cookie).get(String.class);
    	System.out.println("Proyecto:\n" + proyecto);
    	res = c.resource("http://217.124.190.3/jira/rest/api/2.0.alpha1/project");
    	TypeFactory.collectionType(List.class, Project.class);
    	new TypeReference<List<Project>>(){}.getClass();
    	ClientResponse response = res.type("application/json").cookie(cookie).get(ClientResponse.class);
    	List<Project> lProject = (List<Project>) response.getEntity(TypeFactory.arrayType(Project.class).getClass());
    	System.out.println("Clave de proyecto: " + lProject.get(0).getKey());
    	res = c.resource("http://217.124.190.3/jira/rest/api/2.0.alpha1/project/AFIRMA");
    	Project afirmaProject = res.type("application/json").cookie(cookie).get(Project.class);
    	sessionClient.logout(cookie);
    	
//    	ClientConfig config = new DefaultClientConfig();
//    	Client c = Client.create(config);
//    	Cookie cookie = login(c, "jagudopr", "pr0y3ct0XXX").getCookie();
//    	WebResource res = c.resource("http://217.124.190.3/jira/rest/api/2.0.alpha1/search");
//    	MultivaluedMap<String,String> queryParams = new MultivaluedMapImpl();
//    	queryParams.add("jql", "reporter = damartin");
//    	String result = res.queryParams(queryParams).cookie(cookie).get(String.class);
//        System.out.println("Search result:\n" + result);
//        logout(cookie);
    }
    
//    private static void login(Client c, String username, String password){
//    	ClientConfig config = new DefaultClientConfig();
//    	config.getClasses().add(JSONRootElementProvider.class);
//    	MultivaluedMap<String,String> queryParams = new MultivaluedMapImpl();
//    	Client cc = Client.create(config);
//    	queryParams.add("username", username);
//    	queryParams.add("password", password);
//    	WebResource res = cc.resource("http://217.124.190.3/jira/rest/auth/1/session");
//    	res.accept(MediaType.APPLICATION_JSON_TYPE);
//    	ClientResponse response = res.type("application/json").post(ClientResponse.class, queryParams);
//    	System.out.println("Login:\n" + response.getStatus());
//    }
    
    private static LoginResponse login(Client c, String username, String password){
    	ClientConfig config = new DefaultClientConfig();
    	config.getClasses().add(JacksonJsonProvider.class);
    	Client client = Client.create(config);
    	WebResource wr = client.resource("http://217.124.190.3/jira/rest"); 
    	ClientResponse response = wr.path("/auth/1/session").type("application/json").post(ClientResponse.class, "{\"username\" : \"" + username + "\", \"password\" : \"" + password + "\"}");//post(ClientResponse.class, queryParams);
    	LoginData data = response.getEntity(LoginData.class);
    	System.out.println("Login:\n" + response.getStatus());
    	Cookie cookie = response.getCookies().get(0);
    	System.out.println("Cookie: " + response.getCookies().get(0).getName() + ": " + response.getCookies().get(0).getValue());
    	String sesion = wr.path("/auth/1/session").cookie(cookie).type("application/json").get(String.class);
    	System.out.println("Sesion:\n" + sesion);
    	LoginData info = wr.path("/auth/1/session").type("application/json").post(LoginData.class, "{\"username\" : \"" + username + "\", \"password\" : \"" + password + "\"}");//post(ClientResponse.class, queryParams);
    	return new LoginResponse(cookie, data);
    }
    
    private static void logout(Cookie cookie){
    	ClientConfig config = new DefaultClientConfig();
    	config.getClasses().add(JacksonJsonProvider.class);
    	Client client = Client.create(config);
    	WebResource wr = client.resource("http://217.124.190.3/jira/rest");
    	wr.path("/auth/1/session").cookie(cookie).type("application/json").delete();
    }
}
