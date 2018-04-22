package main.java.health;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import java.util.Map;

@Path("/health")
public class HealthCheck {

    @GET 
   public String check()
    {
    	String strReturn = "getProjects is healthy.";
    	return strReturn;
    }
}
