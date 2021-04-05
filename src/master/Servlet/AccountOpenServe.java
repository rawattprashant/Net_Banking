package master.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.AccountDao;
import master.DTO.AccountDto;


/**
 * Servlet implementation class AccountOpenServe
 */
public class AccountOpenServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountOpenServe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 String name=request.getParameter("name");
		 String gender=request.getParameter("gender");
		 String dob=request.getParameter("dob");
		 String idname=request.getParameter("idProof");
		 String idno=request.getParameter("idno");
		 String phno=request.getParameter("phone");
		 String email=request.getParameter("email");
		 String addr=request.getParameter("address");
		 String pincode=request.getParameter("pincode");
	     String acctype=request.getParameter("acctype");
		 String cid=request.getParameter("cid");
		 Double bal =Double.parseDouble(request.getParameter("bal"));
		 
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");//to calculate the age of customer
		 LocalDate date1 = LocalDate.parse(dob, dtf);
		 LocalDate date2 = LocalDate.now();
		 Period diff = Period.between(date1, date2);
		 
		 AccountDto adto=new AccountDto();//accepting values from servlet
		 adto.setName(name);
		 adto.setGender(gender);
		 adto.setDob(dob);
		 adto.setIdname(idname);
		 adto.setIdno(idno);
		 adto.setPhno(phno);
		 adto.setEmail(email);
		 adto.setAddr(addr);
		 adto.setPincode(pincode);
		 adto.setAcctype(acctype);
		 adto.setCid(cid);
		 adto.setBal(bal);
		 
		 AccountDao adao=new AccountDao();
		 if(diff.getYears()>=18)
		 {
		  if(adao.checkIdno(idno))
		  {
			 if(adao.checkPhoneNo(phno))
			 {
				 if(adao.checkEmail(email)) 
				 {
					 if(adao.checkUserId(cid))
					 {
						 adao.insertData(adto);
						 String accnumber=adao.getAcc(cid);
						 request.setAttribute("accnum", accnumber);
						 request.getRequestDispatcher("show.jsp").forward(request, response);
					}

					 else
					 {
						 out.println("User Id not available "); 
						 RequestDispatcher rs=request.getRequestDispatcher("FundFailed.jsp");
						 rs.include(request, response);
					 }
				 }
				 else
				 {
					 out.println("Email Id not available");
					 RequestDispatcher rs=request.getRequestDispatcher("FundFailed.jsp");
					 rs.include(request, response);
				 }
			 }
			 else
			 {
				 out.println("Phone number not available");
				 RequestDispatcher rs=request.getRequestDispatcher("FundFailed.jsp");
				 rs.include(request, response);
				
			 }
		 }
		 else
		 {
			 out.println("An account is already linked with this id");
			 RequestDispatcher rs=request.getRequestDispatcher("FundFailed.jsp");
			 rs.include(request, response);
		 }
	 }
	 else
		 {
			 out.println("Age must be 18 or above!!.Try again");
			 RequestDispatcher rs=request.getRequestDispatcher("FundFailed.jsp");
			 rs.include(request, response);
		 }
	}
}		
