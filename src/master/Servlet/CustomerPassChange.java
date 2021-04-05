package master.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.CustomerDao;
import master.DTO.CustomerDto;

/**
 * Servlet implementation class CustomerPassChange
 */
public class CustomerPassChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String cid=request.getParameter("cid");
		String npass=request.getParameter("npass");
		String cpass=request.getParameter("cpass");
		
		CustomerDao rdao=new CustomerDao();
		if(rdao.checkPass(npass)) 
		{
			if(npass.equals(cpass))
			{
				CustomerDto cdto=new CustomerDto();//accepting the values from servlet
				cdto.setCid(cid);
				cdto.setPass(cpass);
				
				//data saved to dto
				rdao.changePass(cdto);
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Password Changed!!');");  
				out.println("</script>");	
				RequestDispatcher rs=request.getRequestDispatcher("login1.jsp");
				rs.include(request, response);
			}
			else
			{
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Passwords didnot match');");  
				out.println("</script>");
		    }
		}
		else
		{
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Try different password');");  
			out.println("</script>");	
		}
		
	}

}
