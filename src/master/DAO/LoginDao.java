package master.DAO;
import java.sql.*;
import master.utilities.ConnectionFactory;
public class LoginDao {
		
		PreparedStatement ps=null;
		Statement st=null;
		Connection cn=null;
		ResultSet rs=null;
		
		public String getPassword(String cid)
		{
			String sql="select pass from customer1 where cid='"+cid+"'";
			String password=null;
			try {
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				st=cn.createStatement();
				rs=st.executeQuery(sql);
				if(rs.next())
				{
					password=rs.getString(1);
				}
			}
				catch(SQLException se)
				{
				se.printStackTrace();	
			}
			return password;
		}
		 }
