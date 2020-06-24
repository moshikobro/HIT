package Models;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.CallableStatement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


public class Course {

	
  

	public static void main (String [] args) {
		
	}
										

	/**
	 * Create the application.
	 */
	public Course() {
   	initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				
	}
	
	
    public JTable GetCourseData()
    {
    	String jdbcurl;
		Connection con = null;	
	    ResultSet rs=null;
	    JTable table=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}		
		jdbcurl = "jdbc:sqlserver://MOSHIKO-PC\\SQLEXPRESS;databaseName=kernelios;integratedSecurity=true";		
		try {
			con=DriverManager.getConnection(jdbcurl);
					
		}catch (SQLException e)
		
		{
			e.printStackTrace();
		}		
		try
		{
			
			CallableStatement cstmt = con.prepareCall("{call GetCourses()}");
			 rs = cstmt.executeQuery();				
			table = new JTable(buildTableModel(rs));
					
			
      //	while (rs.next())
		//{
		//		System.out.println("ID= "+rs.getInt("corseId")+"Name= "+rs.getInt("corseType"));			
	//	}
										
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
    	return table;
    }
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
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
      	  
    	 
}
