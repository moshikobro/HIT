package kernelioss;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Connect {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String [] args) {
		//String Server = "MOSHIKO-PC\\inst01";
		//int port =1433;
	//	String user = "";
		//String password = "";
	//	String database = "kernelios";
		String jdbcurl;
		Connection con = null;
		
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
		
		try {
			PreparedStatement pst=con.prepareStatement("select * from corses");
			ResultSet rs=pst.executeQuery();
			
			while (rs.next())
			{
				System.out.println("ID= "+rs.getInt("corseId")+"Name= "+rs.getString("corseName"));			
			}
										
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}				
	}

	/**
	 * Create the application.
	 */
	public Connect() {
   	initialize();
	   //  main();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("dsgfh");
		lblNewLabel.setBounds(142, 88, 199, 81);
		frame.getContentPane().add(lblNewLabel);
		
	
		
	}
}
