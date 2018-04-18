package main.java;

import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "project") 

public class Project implements Serializable {  
	   private static final long serialVersionUID = 1L; 
	   private String projectId; 
	   private String projectName; 
	   private String projectManager;  
	   private String projectCode;
	   private int projectTotalHours;
	   
	   public Project(){} 
	    
	   public Project(String id, String name, String projectManager){  
	      this.projectId = id; 
	      this.projectName = name; 
	      this.projectManager = projectManager; 
	   }  
	   
	   public String getProjectId() { 
	      return projectId; 
	   }  
	   
	   @XmlElement 
	   public void setProjectId(String strProjectId) { 
	      this.projectId = strProjectId; 
	   } 
	   
	   public String getProjectName() { 
	      return projectName; 
	   } 
	   
	   @XmlElement
	   public void setProjectName(String strProjectName) { 
	      this.projectName = strProjectName; 
	   } 
	   
	   public String getProjectManager() { 
	      return projectManager; 
	   } 
	   
	   @XmlElement 
	   public void setProjectManager(String strProjectManager) { 
	      this.projectManager = strProjectManager; 
	   }   

	   public String getProjectCode() { 
		      return projectCode; 
		   } 
		   
		   @XmlElement 
		   public void setProjectCode(String strProjectCode) {
		      this.projectCode = strProjectCode; 
		   }   

	   public int getProjectTotalHours() { 
		      return projectTotalHours; 
	   } 
		   
	   @XmlElement 
	   public void setProjectTotalHours(int intProjectTotalHours) { 
	      this.projectTotalHours = intProjectTotalHours; 
	   }   
}