package master.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import master.DTO.RecurringDepositDto;
import master.utilities.ConnectionFactory;

public class RecurringDepositDao {
	 Connection cn=null;
	 Statement st=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 
	 public void insertData(RecurringDepositDto rcdto)
		{
		 String insert_sql="insert into RecurringD values (?,?,?,?)";
			try {
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement(insert_sql);
				ps.setDouble(1, rcdto.getRdamt());
				ps.setInt(2, rcdto.getMonth());
				ps.setString(3, rcdto.getAccno());
				ps.setString(4, rcdto.getDopen());
				ps.executeUpdate();
				cn.commit();
			}
		catch(SQLException se){
			se.printStackTrace();
			
		     }
	     }
	 
	 public ResultSet getRDMaturity(String accno)
		{
			String sql="select accno,dopen,month,rdamt,RD_func(rdamt) interest,(rdamt+RD_func(rdamt))*month maturity from RecurringD where accno='"+accno+"'";
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
