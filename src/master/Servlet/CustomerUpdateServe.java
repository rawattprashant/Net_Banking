package master.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import master.DAO.CustomerDao;
import master.DTO.CustomerDto;


/**
 * Servlet implementation class CustomerUpdateServe
 */
public class CustomerUpdateServe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String cid=request.getParameter("cid");
		String phno=request.getParameter("phno");
		String email=request.getParameter("email");
		
		CustomerDto cdto=new CustomerDto();//accepting the values from servlet
		cdto.setCid(cid);
		cdto.setPhno(phno);
		cdto.setEmail(email);
		
		
		CustomerDao rdao=new CustomerDao();//data saved to dto
		rdao.updateData(cdto);
		response.sendRedirect("update.jsp");
		
	}

}
