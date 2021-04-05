package master.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.AccountDao;
import master.DAO.CustomerDao;
import master.DTO.CustomerDto;

/**
 * Servlet implementation class CustomerAddServe
 */
public class CustomerAddServe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cid=request.getParameter("cid");
		String cname=request.getParameter("cname");
        String pass=request.getParameter("pass");
		String phno=request.getParameter("phno");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		
		
		CustomerDto cdto= new CustomerDto(); //accepting the values from servelet
		cdto.setCid(cid);
		cdto.setCname(cname);
		cdto.setPass(pass);
		cdto.setPhno(phno);
		cdto.setEmail(email);
		cdto.setDob(dob);
		
		CustomerDao cdao=new CustomerDao();//data saved to cdto
		//checking the availability of user id,password,email,phone number
		AccountDao adao=new AccountDao();
		if(request.getParameter("customerSubmit")!=null)
		{
		if(cdao.checkUserId(cid) && !(adao.checkUserId(cid)))
		{	
			if(cdao.checkPass(pass))
			{
				if(cdao.checkEmail(email) && cdao.checkPhoneNo(phno))
				{
					cdao.insertData(cdto);
					response.sendRedirect("CstShow.jsp");
				}
				else {
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('email id or phone number is not available');");  
					out.println("</script>");
				}
			}
			else {
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('try different Password');");  
				out.println("</script>");
			}
		}
		else {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('user id not availabe');");  
			out.println("</script>");
		}
				
	}
  }

}
