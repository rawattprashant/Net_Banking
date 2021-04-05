package master.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import master.DTO.CustomerDto;
import master.utilities.ConnectionFactory;

public class CustomerDao {

	Connection cn=null;
	PreparedStatement ps=null;
	Statement st=null;
	String insert_sql=" insert into customer1 values(?,?,?,?,?,?)";
	String delete_sql="delete from customer1 where cid=?";
	String update_sql="update customer1 set phno=?,email=?  where cid=?";
	String changePass_sql="update customer1 set pass=?  where cid=?";
	
	public void insertData(CustomerDto cdto)//to insert values
	{
		try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			ps=cn.prepareStatement(insert_sql);
			ps.setString(1, cdto.getCid());
			ps.setString(2, cdto.getCname());
			ps.setString(3, cdto.getPass());
			ps.setString(4, cdto.getPhno());
			ps.setString(5, cdto.getEmail());
			ps.setString(6, cdto.getDob());
			ps.executeUpdate();
			cn.commit();
		}
	catch(SQLException se){
		se.printStackTrace();
		
	     }
     }
	
	public void deleteData(CustomerDto cdto)//to delete a netbanking customer
	{
		try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			ps=cn.prepareStatement(delete_sql);
			ps.setString(1, cdto.getCid());
			ps.executeUpdate();
			cn.commit();
			
		}
		catch(SQLException se){
			se.printStackTrace();
			
		}
	}
	
	public void updateData(CustomerDto cdto)//to update phone,email and cid
	{
		try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			ps=cn.prepareStatement(update_sql);
			ps.setString(1,cdto.getPhno());
			ps.setString(2, cdto.getEmail());
			ps.setString(3, cdto.getCid());
			ps.executeUpdate();
			cn.commit();
			
		}
		catch(SQLException se){
			se.printStackTrace();
			
		}
	}
	
	public boolean checkUserId(String userid)//to check the availabilty of userid,returns false if userid already exists
	{
		String check_sql="select * from customer1 where cid='"+userid+"'";
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
	
	public boolean checkPass(String pass)//to check the availabilty of password
	{
		String check_sql="select * from customer1 where pass='"+pass+"'";
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
	
	public boolean checkEmail(String email)//to check the availabilty of email
	{
		String check_sql="select * from customer1 where email='"+email+"'";
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
	
	public boolean checkPhoneNo(String phno)//to check the availabilty of phone
	{
		String check_sql="select * from customer1 where phno='"+phno+"'";
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
	
	public void changePass(CustomerDto cdto)//to change Password
	{
		try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			ps=cn.prepareStatement(changePass_sql);
			ps.setString(1,cdto.getPass());
			ps.setString(2, cdto.getCid());
			ps.executeUpdate();
			cn.commit();
			
		}
		catch(SQLException se){
			se.printStackTrace();
			
		}
    }
}