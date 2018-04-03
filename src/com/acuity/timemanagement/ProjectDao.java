package com.acuity.timemanagement;

import java.util.ArrayList; 
import java.util.List;  
import java.sql.*;


public class ProjectDao {
	public List<Project> getAllProjects() throws Exception { 		      
	List<Project> projectList = new ArrayList<Project>(); 
	Project prjCurrent = null;
	try
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		Connection m_Connection = DriverManager.getConnection(
				"jdbc:sqlserver://192.168.56.1\\SQLEXPRESS:1433;databaseName=TimeTracking;integratedSecurity=false", "timaccess", "hgyt65%^");

		Statement m_Statement = m_Connection.createStatement();
		String query = "SELECT * FROM Projects";

		ResultSet m_ResultSet = m_Statement.executeQuery(query);

		while (m_ResultSet.next()) {
			prjCurrent = new Project();
			prjCurrent.setProjectId(m_ResultSet.getString(1));
			prjCurrent.setProjectName( m_ResultSet.getString(2));
			prjCurrent.setProjectManager( m_ResultSet.getString(3));
			prjCurrent.setProjectTotalHours( m_ResultSet.getInt(4));
			projectList.add(prjCurrent); 
		}    
    } 
	catch (SQLException se) {
		se.printStackTrace();
	}

	return projectList; 
	}
}
