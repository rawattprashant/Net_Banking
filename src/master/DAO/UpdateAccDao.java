package master.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import master.DTO.FundTransferDto;
import master.DTO.UpdateAccDto;
import master.utilities.ConnectionFactory;

public class UpdateAccDao {

	Connection cn=null;
	 Statement st=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 
	 public void insertData(UpdateAccDto udto)//to insert values in account
		{
		 String insert_sql="insert into updateacc values(?,?,?,?)";
			try {
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement(insert_sql);
				ps.setString(1,udto.getAccno());
				ps.setDouble(2, udto.getBal());
				ps.setString(3, udto.getDepositby());
				ps.setString(4, udto.getDateofDeposit());
          }
			catch(SQLException se){
				se.printStackTrace();
				
			     }
		}
	 
	 public ArrayList getUpdateDetails(String accno,String d1,String d2) 
		{
			String sql="select * from updateacc where accno='"+accno+"' AND  dodeposit >= '"+d1+"' AND dodeposit <= '"+d2+"'";
			ArrayList arr=new ArrayList();
			try {
			ConnectionFactory con =new ConnectionFactory();
			cn=con.getConn();
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
			UpdateAccDto udto=new UpdateAccDto();
			
			  udto.setAccno(rs.getString(1));
			  udto.setBal(rs.getDouble(2));
			  udto.setDepositby(rs.getString(3));
			  udto.setDateofDeposit(rs.getString(4));
			  arr.add(udto);
			        }
			}
			catch(SQLException se) {
			se.printStackTrace();
			}
			return arr;
			}
}
