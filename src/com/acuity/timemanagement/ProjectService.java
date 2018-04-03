package com.acuity.timemanagement;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/ProjectService") 

public class ProjectService {
	   ProjectDao projectDao = new ProjectDao();  
	   @GET 
	   @Path("/projects") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public List<Project> getProjects(){ 
		   List<Project> lstProject = null;
	      try {
	    	  lstProject = projectDao.getAllProjects();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	      return lstProject;
	   }  
}
