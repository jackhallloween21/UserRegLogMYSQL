package JDBC;
import java.sql.*;
public class Connection_Factory {
	Connection cn=null;
	public Connection getConn()
	{
		try
		{
		  Class.forName("com.mysql.cj.jdbc.Driver");//register and load the driver
		  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","x");
		  
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return cn;
	}
	}
