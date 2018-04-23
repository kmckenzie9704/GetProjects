package main.java;

import java.util.ArrayList; 
import java.util.List;
import java.sql.*;


public class ProjectDao {
	public List<Project> getAllProjects() throws Exception { 		      
	List<Project> projectList = new ArrayList<Project>(); 
	Project prjCurrent = null;
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		String strDBHost = System.getenv("ICE_GETPROJECTS_DB_HOST");
		String strDBPort = System.getenv("ICE_GETPROJECTS_DB_PORT");
		String strDBUser = System.getenv("ICE_GETPROJECTS_DB_USER");
		String strDBPassword = System.getenv("ICE_GETPROJECTS_DB_PASSWORD");
		String strDBTable = "TimeTracking";
		String strConnStr = "";
		
    	StringBuilder sblConnectionString = new StringBuilder();
    	sblConnectionString.append("jdbc:mysql://");
    	sblConnectionString.append(strDBHost);
    	sblConnectionString.append(":");
    	sblConnectionString.append(strDBPort);
    	sblConnectionString.append("/");
    	sblConnectionString.append(strDBTable);
    	sblConnectionString.append("?autoReconnect=true&useSSL=false");
    	strConnStr = sblConnectionString.toString();

//		"jdbc:mysql://192.168.56.101:3306/TimeTracking?autoReconnect=true&useSSL=false", "timaccess", "hgYT65^%");

		
		Connection m_Connection = DriverManager.getConnection(strConnStr, strDBUser, strDBPassword);

		Statement m_Statement = m_Connection.createStatement();
		String query = "SELECT * FROM Projects";

		ResultSet m_ResultSet = m_Statement.executeQuery(query);

		while (m_ResultSet.next()) {
			prjCurrent = new Project();
			prjCurrent.setProjectId(m_ResultSet.getString(1));
			prjCurrent.setProjectName( m_ResultSet.getString(2));
			prjCurrent.setProjectManager( m_ResultSet.getString(3));
			prjCurrent.setProjectCode(m_ResultSet.getString(4));
			prjCurrent.setProjectTotalHours( m_ResultSet.getInt(5));
			projectList.add(prjCurrent); 
		}    
    } 
	catch (SQLException se) {
		se.printStackTrace();
	}

	return projectList; 
	}
}
