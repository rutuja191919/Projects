
import java.sql.Connection;
import java.sql.DatabaseMetaData;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class JDBC
{

	Connection con;
	Statement st;
	ResultSet rs;
	public JDBC() 
	{
		// TODO Auto-generated constructor stub
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
		} catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e.getMessage()+"----");
		}

	}
	
}	

