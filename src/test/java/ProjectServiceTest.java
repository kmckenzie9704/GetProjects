package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Project;
import main.java.ProjectService;

class ProjectServiceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

    String message = "Sample Unit Test.";	
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void TestGetProjects() {	  
    	ProjectService prjService = new ProjectService();
    	List<Project> lstProject = prjService.getProjects();
    	assertNotNull(lstProject);
       assertEquals(message,messageUtil.printMessage());
    }

}
