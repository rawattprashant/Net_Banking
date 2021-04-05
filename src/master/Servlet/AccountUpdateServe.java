package master.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.AccountDao;
import master.DAO.UpdateAccDao;
import master.DTO.AccountDto;
import master.DTO.UpdateAccDto;

/**
 *  implementation class AccountUpdateServe
 */
public class AccountUpdateServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountUpdateServe() {
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
		String accno=request.getParameter("accno");
		Double balance=Double.parseDouble(request.getParameter("balance"));
		String depositBy=request.getParameter("depomethod");
		String dateofDeposit=request.getParameter("dodeposit");
		
		UpdateAccDto udto=new UpdateAccDto();
		udto.setAccno(accno);
		udto.setBal(balance);
		udto.setDepositby(depositBy);
		udto.setDateofDeposit(dateofDeposit);
		
		AccountDto adto=new AccountDto();
		adto.setAccno(accno);
		adto.setBal(balance);
		
		
		AccountDao adao= new AccountDao();
		adao.updateData(adto);
		UpdateAccDao udao=new UpdateAccDao();
		udao.insertData(udto);
		out.println("Account Balance updated!!");
		response.sendRedirect("FundFailed.jsp");
		
	}

}
