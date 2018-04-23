package main.java.health;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/health")
public class HealthCheck {

    @GET 
   public String check()
    {
    	String strReturn = "getProjects is healthy.";
    	return strReturn;
    }
}
