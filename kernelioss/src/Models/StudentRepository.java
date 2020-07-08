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

public class StudentRepository {
	private String jdbcur;
	private Connection conn;

	public StudentRepository() 
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
	
		
     public JTable GetStudentsData()
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
				CallableStatement cstmt = this.conn.prepareCall("{call GetStudentsData()}");
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
	

	public Boolean InsertNewStudent (Student s,int courseID)
	{
		try
		{
		 String commandText = "{call InsertNewStudent(?,?,?,?,?,?,?,?)}";
			CallableStatement stmt = this.conn.prepareCall(commandText);
		    stmt.setObject(1,s.GetID());
		    stmt.setObject(2, s.GetfirstName());
		    stmt.setObject(3, s.GetLastName());
		    stmt.setObject(4, s.GetAddress());
		    stmt.setObject(5,new java.sql.Date(s.GetbirthDate().getTime()));
		    stmt.setObject(6,s.GetPhoneNumber());
		    stmt.setObject(7,s.GetGrade());
		    stmt.setObject(8,courseID);
		   
		    boolean gotResults = stmt.execute();		
			 return true;
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
			return false;
	}
		
		
	public Boolean SetStudentDetails(Student s,int courseID)
	{
	
		try
		{	
	
		 String commandText = "{call UpdateStudent(?,?,?,?,?,?,?,?)}";
		CallableStatement stmt = this.conn.prepareCall(commandText);
	    stmt.setObject(1,s.GetID());
	    stmt.setObject(2, s.GetfirstName());
	    stmt.setObject(3, s.GetLastName());
	    stmt.setObject(4, s.GetAddress());
	    stmt.setObject(5,new java.sql.Date(s.GetbirthDate().getTime()));
	    stmt.setObject(6,s.GetPhoneNumber());
	    stmt.setObject(7,s.GetGrade());
	    stmt.setObject(8,courseID);
	   
	     stmt.execute();		
		 return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
		return false;
	}
		
	
	public Boolean DeleteStudent (String studentID)
	{
		try
		{	
	
		 String commandText = "{call DeleteStudent(?)}";
		CallableStatement stmt = this.conn.prepareCall(commandText);
	     stmt.setObject(1,studentID);    
	     stmt.execute();		
		 return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	

	

	
	public Boolean IsStudentExists (String studentID)
	{
		try
		{	
	
		 String commandText = "{call IsStudentExists(?,?)}";
		 CallableStatement stmt = this.conn.prepareCall(commandText);
		     stmt.setObject(1,studentID);
		    stmt.registerOutParameter(2,Types.INTEGER);
	        stmt.executeUpdate();	
	        int numOfStudents = stmt.getInt(2);
	        
	     if(numOfStudents>0)
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
