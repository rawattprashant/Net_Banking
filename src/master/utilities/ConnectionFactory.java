package master.utilities;
import java.sql.*;
public class ConnectionFactory {
	Connection cn=null;
	public Connection getConn()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","net","net");
			
		}
		catch(ClassNotFoundException ce)
		{
			
			System.getProperty("java.classpath");
			ce.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
   }
		return cn;
		
	}

}
