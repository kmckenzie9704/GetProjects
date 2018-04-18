package com.acuity.timemanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetProjectsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

    String message = "Sample Unit Test.";	
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testGetProjects() {	  
    	ProjectService prjService = new ProjectService();
    	List<Project> lstProject = prjService.getProjects();
    	assertNotNull(lstProject);
       assertEquals(message,messageUtil.printMessage());
    }

}
