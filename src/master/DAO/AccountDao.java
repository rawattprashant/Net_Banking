package master.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import master.DTO.AccountDto;
import master.utilities.ConnectionFactory;

public class AccountDao {
	 Connection cn=null;
	 Statement st=null;
	 PreparedStatement ps=null;
	// ResultSet rs=null;
	 
	 
	 public void insertData(AccountDto adto)//to insert values in account
		{
		 String insert_sql="insert into account values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement(insert_sql);
				ps.setString(1,adto.getName());
				ps.setString(2, adto.getGender());
				ps.setString(3, adto.getDob());
				ps.setString(4, adto.getIdname());
				ps.setString(5, adto.getIdno());
				ps.setString(6, adto.getPhno());
				ps.setString(7, adto.getEmail());
				ps.setString(8, adto.getAddr());
				ps.setString(9, adto.getPincode());
				ps.setString(10, adto.getAcctype());
				ps.setString(11, adto.getAccno());
				ps.setString(12, adto.getCid());
				ps.setDouble(13, adto.getBal());
				ps.executeUpdate();
				cn.commit();
			}
		catch(SQLException se){
			se.printStackTrace();
			
		     }
	     }
	 public void deleteData(AccountDto adto)//to delete account
		{
		 String delete_sql="delete from account where accno=?";
			try {
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement(delete_sql);
				ps.setString(1, adto.getAccno());
				ps.executeUpdate();
				cn.commit();
				
			}
			catch(SQLException se){
				se.printStackTrace();
				
			}
		}
		
		public void updateData(AccountDto adto)//to update balance 
		{
			String update_sql="update account set bal=? where accno=?";
			
			AccountDao ad=new AccountDao();
			double prevBal=ad.getBalance(adto.getAccno());
			try {
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement(update_sql);
				ps.setDouble(1, (prevBal+adto.getBal()));
				ps.setString(2, adto.getAccno());
				ps.executeUpdate();
				cn.commit();
				
			}
			catch(SQLException se){
				se.printStackTrace();
				
			}
		}
		
	
	public double getBalance(String accno)// to get available balance
	{
		String sql_get="select bal from account where accno='"+accno+"'";
		double balance=0.0;
		try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql_get);
		   if(rs.next())
		   {
			   balance=rs.getDouble(1);
		   }
		
		}
			catch(SQLException se)
			{
			se.printStackTrace();	
		}
		return balance;
	}
	
	
	public String getAcc(String cid) { //to get the account number corresponding to passed cid
		String sql="select accno from account where cid ='"+cid+"'";
		String ac="";
		try {
		ConnectionFactory con =new ConnectionFactory();
		cn=con.getConn();
		st=cn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
		ac=rs.getString(1);
		System.out.println(ac);
	}
		}
		catch(SQLException se)
		{
		se.printStackTrace();	
	}
		return ac;
	}
	
	public boolean checkAccount(String accno)//results true if account exists
	{
		String check_sql="select * from account where accno='"+accno+"'";
		boolean exists=false;
		try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			st=cn.createStatement();
			ResultSet rs=st.executeQuery(check_sql);
			if(rs.next()) {
				exists=true;
			}
		}
		catch(SQLException se){
			se.printStackTrace();
			
		}
		return exists;
    }
	
	public boolean checkIdno(String idno)//checks the availability of idno,it results true if idno is not linked with other account
	{
		String check_sql="select * from account where idno='"+idno+"'";
		boolean avail=true;
		try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			st=cn.createStatement();
			ResultSet rs=st.executeQuery(check_sql);
			if(rs.next()) {
				avail=false;
			}
		}
		catch(SQLException se){
			se.printStackTrace();
			
		}
		return avail;
    }
	
	public boolean checkEmail(String email)//checks the availability of email
	{
		String check_sql="select * from account where email='"+email+"'";
		boolean avail=true;
		try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			st=cn.createStatement();
			ResultSet rs=st.executeQuery(check_sql);
			if(rs.next()) {
				avail=false;
			}
		}
		catch(SQLException se){
			se.printStackTrace();
			
		}
		return avail;
    }
	
	public boolean checkPhoneNo(String phno)
	{
		String check_sql="select * from account where phno='"+phno+"'";
		boolean avail=true;
		try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			st=cn.createStatement();
			ResultSet rs=st.executeQuery(check_sql);
			if(rs.next()) {
				avail=false;
			}
		}
		catch(SQLException se){
			se.printStackTrace();
			
		}
		return avail;
    }
	
	public boolean checkUserId(String userid)
	{
		String check_sql="select * from account where cid='"+userid+"'";
		boolean avail=true;
		try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			st=cn.createStatement();
			ResultSet rs=st.executeQuery(check_sql);
			if(rs.next()) {
				avail=false;
			}
		}
		catch(SQLException se){
			se.printStackTrace();
			
		}
		return avail;
    }
		
	public ArrayList getBDetails(String accno) //to get the details of an account
	{
		String sql="select a.accno,a.name,a.bal,a.acctype,c.cid from account a,customer1 c where a.cid=c.cid and a.accno='"+accno+"'";
		ArrayList arr=new ArrayList();
		try {
		ConnectionFactory con =new ConnectionFactory();
		cn=con.getConn();
		st=cn.createStatement();
		 ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
		AccountDto adto=new AccountDto();
		  adto.setAccno(rs.getString(1));
		  adto.setName(rs.getString(2));
		  adto.setBal(rs.getDouble(3));
		  adto.setAcctype(rs.getString(4));
		  adto.setCid(rs.getString(5));
		  arr.add(adto);
		        }
		}
		catch(SQLException se) {
		se.printStackTrace();
		}
		return arr;
		}
}
