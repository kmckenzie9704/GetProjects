package main.java.health;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import java.util.Map;

import com.codahale.metrics.health.HealthCheck;

import okhttp3.HttpUrl; 
import okhttp3.OkHttpClient; 
import okhttp3.Request; 
import okhttp3.Response; 

@Path("/health")
public class ExternalServiceHealthCheck extends HealthCheck {

    private final OkHttpClient client = new OkHttpClient();
    private final HttpUrl path = new HttpUrl.Builder()
    	       .scheme("https")
    	       .host("www.google.com")
    	       .addPathSegment("search")
    	       .addQueryParameter("q", "polar bears")
    	       .build();

/*
    public ExternalServiceHealthCheck(OkHttpClient client, HttpUrl path) {
        this.client = client;
        this.path = path;
    }
*/
//	public ExternalServiceHealthCheck() {}
	
    @GET 
   public String test()
    {
    	StringBuilder sblVariable = new StringBuilder();
    	/*
    	Map<String, String> env = System.getenv();
    	for (String envName : env.keySet()) {
    		sblVariables.append(envName);
    		sblVariables.append(" ");
    		sblVariables.append(env.get(envName));
    		sblVariables.append("%n");
    	}
		*/
    	sblVariable.append("Java Home: ");
    	sblVariable.append(System.getenv("JAVA_HOME"));
    	sblVariable.append("%n");
    	sblVariable.append("Host: ");
    	sblVariable.append(System.getenv("ICE_GETPROJECTS_DB_HOST"));

    	
    	return sblVariable.toString();
    	
    }
    
//    @Produces(MediaType.TEXT_HTML)
   @Override
    public Result check() throws Exception {
        Request request = new Request.Builder()
            .url(path)
            .get()
            .build();
        Response response = client.newCall(request).execute();
        // If response is a 20x response code pass it.
        if (response.isSuccessful()) {
            return Result.healthy();
        }
        return Result.unhealthy("code: %s - body: %s", response.code(), response.body().string());
    }

}
