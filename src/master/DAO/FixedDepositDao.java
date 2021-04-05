package master.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import master.DTO.FixedDepositDto;
import master.utilities.ConnectionFactory;

public class FixedDepositDao {

	 Connection cn=null;
	 Statement st=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 
	 public void insertData(FixedDepositDto fdto)
		{
		 String insert_sql="insert into FixedD values (?,?,?,?)";
			try {
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement(insert_sql);
				ps.setDouble(1, fdto.getFdamt());
				ps.setDouble(2, fdto.getYear());
				ps.setString(3, fdto.getAccno());
				ps.setString(4, fdto.getDopen());
				ps.executeUpdate();
				cn.commit();
			}
		catch(SQLException se){
			se.printStackTrace();
			
		     }
	     }
	 
	 
	 public ResultSet getInterest(String accno)
		{
			String sql="select accno,dopen,year,fdamt,fd_func(fdamt) interest,(fdamt+fd_func(fdamt)*year) maturity from FixedD where accno='"+accno+"'";
			//double interest=0.0;
			try {
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				st=cn.createStatement();
				rs=st.executeQuery(sql);
				
			}
				catch(SQLException se)
				{
				se.printStackTrace();	
			}
			return rs;
		}
	
}
