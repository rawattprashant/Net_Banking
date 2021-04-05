package master.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.AccountDao;
import master.DAO.LoginDao;

/**
 * implementation class CustomerLoginServe 
 */
public class CustomerLoginServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServe() {
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
		String cid=request.getParameter("cid");
		String pass =request.getParameter("pass");
		
		
		LoginDao ldao=new LoginDao();
	    String pw=ldao.getPassword(cid);
	    if(request.getParameter("log")!=null)
	    {
		 if(pass.equals(pw)) {
		   //response.sendRedirect("Customer.jsp");
			 AccountDao adao=new AccountDao();
		     String accnumber=adao.getAcc(cid);
		     request.setAttribute("accnum", accnumber);
		     request.getRequestDispatcher("Customer.jsp").forward(request, response);
		     
		 }
		 else {
			 out.println("Username or Password incorrect");
	        }
		 }	
	}
}
