package Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LecturerRepository {
	private String jdbcur;
	private Connection conn;

	public LecturerRepository() 
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
	
		
     public JTable GetLecturersData()
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
				CallableStatement cstmt = this.conn.prepareCall("{call GetLecturers()}");
				 rs = cstmt.executeQuery();				
				table = new JTable(buildTableModel(rs));
														
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
	    	return table;
	    }
	      
     
     public JTable GetSpecializations()
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
				CallableStatement cstmt = this.conn.prepareCall("{call GetSpecializations()}");
				 rs = cstmt.executeQuery();				
				table = new JTable(buildTableModel(rs));
														
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
	    	return table;
	    }
           
     public JTable  GetLecturersForSpecializationInNetwork()
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
				CallableStatement cstmt = this.conn.prepareCall("{call  GetLecturersForSpecializationInNetwork()}");
				 rs = cstmt.executeQuery();				
				table = new JTable(buildTableModel(rs));
														
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
	    	return table;
	    }
     public JTable  GetLecturersForSpecializationInSystem()
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
				CallableStatement cstmt = this.conn.prepareCall("{call  GetLecturersForSpecializationInSystem()}");
				 rs = cstmt.executeQuery();				
				table = new JTable(buildTableModel(rs));
														
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
	    	return table;
	    }
     public JTable  GetLecturersForSpecializationInSyber()
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
				CallableStatement cstmt = this.conn.prepareCall("{call  GetLecturersForSpecializationInSyber()}");
				 rs = cstmt.executeQuery();				
				table = new JTable(buildTableModel(rs));
														
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
	    	return table;
	    }
     
     public JTable  GetStatuses()
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
				CallableStatement cstmt = this.conn.prepareCall("{call  GetStatuses()}");
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
	

	public Boolean InsertNewLecturer (Lecturer l)
	{
		try
		{
		 String commandText = "{call InsertNewLecturer(?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement stmt = this.conn.prepareCall(commandText);
		    stmt.setObject(1,l.GetID());
		    stmt.setObject(2, l.GetfirstName());
		    stmt.setObject(3, l.GetLastName());
		    stmt.setObject(4, l.GetAddress());
		    stmt.setObject(5,new java.sql.Date(l.GetbirthDate().getTime()));
		    stmt.setObject(6,l.GetSpecializationID_1());
		    stmt.setObject(7,l.GetSpecializationID_2());
		    stmt.setObject(8,l.GetSpecializationID_3());
		    stmt.setObject(9,l.GetPhoneNumber());
		    stmt.setObject(10,l.GetStatus());
		   
		    boolean gotResults = stmt.execute();		
			 return true;
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
			return false;
	}
		
		
	public Boolean SetLecturerDetails(Lecturer l)
	{
	
		try
		{	
	
		 String commandText = "{call UpdateLecturer(?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement stmt = this.conn.prepareCall(commandText);
	    stmt.setObject(1,l.GetID());
	    stmt.setObject(2, l.GetfirstName());
	    stmt.setObject(3, l.GetLastName());
	    stmt.setObject(4, l.GetAddress());
	    stmt.setObject(5,new java.sql.Date(l.GetbirthDate().getTime()));
	    stmt.setObject(6,l.GetSpecializationID_1());
	    stmt.setObject(7,l.GetSpecializationID_2());
	    stmt.setObject(8,l.GetSpecializationID_3());
	    stmt.setObject(9,l.GetPhoneNumber());
	    stmt.setObject(10,l.GetStatus());
	   
	    boolean gotResults = stmt.execute();		
		 return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
		return false;
	}
		
	
	public Boolean DeleteLecturer (String LecturerID)
	{
		try
		{	
	
		 String commandText = "{call DeleteLecturer(?)}";
		CallableStatement stmt = this.conn.prepareCall(commandText);
	     stmt.setObject(1,LecturerID);    
	     boolean gotResults = stmt.execute();		
		 return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	

	public Boolean CheckIfLecturerIsValid (int seq ,int courseID,int courseType,int dayInWeek,Date courseEndDate)
	{
		try
		{	
	
		 String commandText = "{call CheckIfLecturerIsValid(?,?,?,?,?,?)}";
		 CallableStatement stmt = this.conn.prepareCall(commandText);
		     stmt.setObject(1,seq);
		    stmt.setObject(2,courseID);
		    stmt.setObject(3, courseType);
		    stmt.setObject(4,dayInWeek);
		    stmt.setObject(5,new java.sql.Date(courseEndDate.getTime()));
		    stmt.registerOutParameter(6,Types.INTEGER);
	        stmt.executeUpdate();	
	        int numOfCourses = stmt.getInt(6);
	        
	     if(numOfCourses>0)
		     return false;
	     
	     return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	public Boolean CanBeDeleted (String lecturerID)
	{
		try
		{	
	
		 String commandText = "{call CanBeDeleted(?,?)}";
		 CallableStatement stmt = this.conn.prepareCall(commandText);
		     stmt.setObject(1,lecturerID);
		    stmt.registerOutParameter(2,Types.INTEGER);
	        stmt.executeUpdate();	
	        int numOfCourses = stmt.getInt(2);
	        
	     if(numOfCourses>0)
		     return true;
	     
	     else
	    	 return false; 

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean IsLecturerActive (int lecturerSeqID)
	{
		try
		{	
	
		 String commandText = "{call IsLecturerActive(?,?)}";
		 CallableStatement stmt = this.conn.prepareCall(commandText);
		     stmt.setObject(1,lecturerSeqID);
		    stmt.registerOutParameter(2,Types.INTEGER);
	        stmt.executeUpdate();	
	        int activeID = stmt.getInt(2);
	        
	     if(activeID>0)
		     return true;
	     
	     else
	    	 return false; 

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Boolean IsLecturerExists (String lecturerID)
	{
		try
		{	
	
		 String commandText = "{call IsLecturerExists(?,?)}";
		 CallableStatement stmt = this.conn.prepareCall(commandText);
		     stmt.setObject(1,lecturerID);
		    stmt.registerOutParameter(2,Types.INTEGER);
	        stmt.executeUpdate();	
	        int isEnd = stmt.getInt(2);
	        
	     if(isEnd>0)
		     return true;
	     
	     else
	    	 return false; 

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
