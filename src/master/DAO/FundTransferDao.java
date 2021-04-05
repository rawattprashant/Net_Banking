package master.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import master.DTO.FundTransferDto;
import master.utilities.ConnectionFactory;

public class FundTransferDao {

	Connection cn=null;
	 Statement st=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 
	 public void insertData(FundTransferDto fdto)
		{
		 String insert_sql="insert into FundTransfer values (?,?,?,?,?,?)";
			try {
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement(insert_sql);
				ps.setString(1, fdto.getSaccno());
				ps.setString(2, fdto.getBaccno());
				ps.setDouble(3, fdto.getBalance());
				ps.setString(4, fdto.getDot());
				ps.setString(5, fdto.getIfcs());
				ps.setString(6, fdto.getBanknm());
				ps.executeUpdate();
				cn.commit();
			}
		catch(SQLException se){
			se.printStackTrace();
			
		     }
	     }
	 public ArrayList getTransactionDetails(String accno,String d1,String d2) 
		{
			String sql="select * from Fundtransfer where saccno='"+accno+"' AND  dtrans >= '"+d1+"' AND dtrans <= '"+d2+"'";
			ArrayList arr=new ArrayList();
			try {
			ConnectionFactory con =new ConnectionFactory();
			cn=con.getConn();
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
			FundTransferDto fdto=new FundTransferDto();
			  fdto.setSaccno(rs.getString(1));
			  fdto.setBaccno(rs.getString(2));
			  fdto.setBalance(rs.getDouble(3));
			  fdto.setDot(rs.getString(4));
			  fdto.setIfcs(rs.getString(5));
			  fdto.setBanknm(rs.getString(6));
			  arr.add(fdto);
			        }
			}
			catch(SQLException se) {
			se.printStackTrace();
			}
			return arr;
			}
}

