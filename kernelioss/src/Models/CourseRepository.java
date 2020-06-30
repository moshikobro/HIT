package Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CourseRepository {

	private String jdbcur;
	private Connection conn;

	public CourseRepository() 
	{
		try
		{
		
		this.jdbcur	="jdbc:sqlserver://MOSHIKO-PC\\SQLEXPRESS;databaseName=kernelios;integratedSecurity=true";
		this.conn=  DriverManager.getConnection(this.jdbcur);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	
	}
		
     public JTable GetCourseData()
	    {
	    		
		    ResultSet rs=null;
		    JTable table=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			}catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}		
						
			try
			{			
				CallableStatement cstmt = this.conn.prepareCall("{call GetCourses()}");
				 rs = cstmt.executeQuery();				
				table = new JTable(buildTableModel(rs));
														
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
	    	return table;
	    }
	      
     
     public JTable GetDaysOfWeek()
	    {
	    		
		    ResultSet rs=null;
		    JTable table=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			}catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}		
						
			try
			{			
				CallableStatement cstmt = this.conn.prepareCall("{call GetDaysOfWeek()}");
				 rs = cstmt.executeQuery();				
				table = new JTable(buildTableModel(rs));
														
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
	    	return table;
	    }
	      
    
     public JTable GetCourseTypes()
	    {
	    		
		    ResultSet rs=null;
		    JTable table=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			}catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}		
						
			try
			{			
				CallableStatement cstmt = this.conn.prepareCall("{call GetCourseTypes()}");
				 rs = cstmt.executeQuery();				
				table = new JTable(buildTableModel(rs));
														
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
	    	return table;
	    }
	 
     
     public JTable GetStudentsInCourse(int courseID)
	    {    		
		    ResultSet rs=null;
		    JTable table=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			}catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}		
						
			try
			{			
				CallableStatement cstmt = this.conn.prepareCall("{call GetStudentsInCourse(?)}");
				cstmt.setObject(1,courseID);
				rs = cstmt.executeQuery();				
				table = new JTable(buildTableModel(rs));													
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
	    	return table;
	    }
	 
     

	 private static DefaultTableModel buildTableModel(ResultSet rs)
	            throws SQLException {

	        ResultSetMetaData metaData = rs.getMetaData();

	        // names of columns
	        Vector<String> columnNames = new Vector<String>();
	        int columnCount = metaData.getColumnCount();
	        for (int column = 1; column <= columnCount; column++) {
	            columnNames.add(metaData.getColumnName(column));
	        }

	        // data of the table
	        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	        while (rs.next()) {
	            Vector<Object> vector = new Vector<Object>();
	            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	                vector.add(rs.getObject(columnIndex));
	            }
	            data.add(vector);
	        }
  
	        return new DefaultTableModel(data, columnNames);
	    }
	
	
	public Boolean SetCourse(Course c)
	{
	
		try
		{	
	
		 String commandText = "{call UpdateCourse(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement stmt = this.conn.prepareCall(commandText);
	    stmt.setObject(1,c.GetCourseID());
	    stmt.setObject(2, c.GetCourseType());
	    stmt.setObject(3, new java.sql.Date (c.GetCourseStartDate().getTime()));
	    stmt.setObject(4, new java.sql.Date (c.GetCourseEndDate().getTime()));
	    stmt.setObject(5,c.GetCourseDayOfWeekID());
	    stmt.setObject(6,c.GetNetworkingLecturerID());
	    stmt.setObject(7,c.GetSystemLecturerID());
	    stmt.setObject(8,c.GetSyberLecturerID());
	    stmt.setObject(9,new java.sql.Date (c.GetNetworkingStartDate().getTime()));
	    stmt.setObject(10,new java.sql.Date( c.GetSystemStartDate().getTime()));
	    stmt.setObject(11,new java.sql.Date( c.GetSyberStartDate().getTime()));
	    stmt.setObject(12,new java.sql.Date (c.GetNetworkingEndDate().getTime()));
	    stmt.setObject(13,new java.sql.Date ( c.GetSystemEndDate().getTime()));
	    stmt.setObject(14,new java.sql.Date( c.GetSyberEndDate().getTime()));
	    stmt.setObject(15,new java.sql.Date (c.GetTestDate().getTime()));
	    
	    stmt.execute();		
		 return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
		return false;
	}
		
	
	public Boolean DeleteCourse (int courseID)
	{
		try
		{	
	
		 String commandText = "{call DeleteCourse(?)}";
		 CallableStatement stmt = this.conn.prepareCall(commandText);
	     stmt.setObject(1,courseID);    
	     boolean gotResults = stmt.execute();		
		 return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public Boolean InsertNewCourse (Course c)
	{
		try
		{	
	
		 String commandText = "{call InsertNewCourse(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		 CallableStatement stmt = this.conn.prepareCall(commandText);
		    stmt.setObject(1,c.GetCourseID());
		    stmt.setObject(2, c.GetCourseType());
		    stmt.setObject(3, new java.sql.Date (c.GetCourseStartDate().getTime()));
		    stmt.setObject(4, new java.sql.Date (c.GetCourseEndDate().getTime()));
		    stmt.setObject(5,c.GetCourseDayOfWeekID());
		    stmt.setObject(6,c.GetNetworkingLecturerID());
		    stmt.setObject(7,c.GetSystemLecturerID());
		    stmt.setObject(8,c.GetSyberLecturerID());
		    stmt.setObject(9,new java.sql.Date (c.GetNetworkingStartDate().getTime()));
		    stmt.setObject(10,new java.sql.Date( c.GetSystemStartDate().getTime()));
		    stmt.setObject(11,new java.sql.Date( c.GetSyberStartDate().getTime()));
		    stmt.setObject(12,new java.sql.Date (c.GetNetworkingEndDate().getTime()));
		    stmt.setObject(13,new java.sql.Date ( c.GetSystemEndDate().getTime()));
		    stmt.setObject(14,new java.sql.Date( c.GetSyberEndDate().getTime()));
		    stmt.setObject(15,new java.sql.Date (c.GetTestDate().getTime()));
		    
		  stmt.execute();		
		 return true;	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public int GetNextCourseNumber()
	{
		try
		{
		String nextId="";
		ResultSet rs=null;		 
		 CallableStatement cstmt = this.conn.prepareCall("{call GetNextCourseNumber()}");
		 rs = cstmt.executeQuery();
		 while(rs.next()) {
			 nextId= rs.getString(1);
		 }
		 return Integer.parseInt(nextId);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return -1;		
	}

	
	
}
