package master.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.AccountDao;
import master.DAO.FundTransferDao;
import master.DTO.FundTransferDto;

public class FundTransferServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FundTransferServe() {
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
		String saccno= request.getParameter("saccno");
		String baccno=request.getParameter("baccno");
		Double balance =Double.parseDouble(request.getParameter("amt"));
		String dot=request.getParameter("dot");
	    String ifcs=request.getParameter("ifcs");
	    String banknm=request.getParameter("bname");
	    boolean flag=true;
	    
		AccountDao adao=new AccountDao();
		//create an object of this class in fund transfer servlet "FundTransferServe" n call these methods to do check eligibilty b4 fund transfer;
		double avl_balance=adao.getBalance(saccno);
		if(banknm.equals("MD Bank")) {
			flag=adao.checkAccount(baccno);
		}
		
		if(flag)
		{
			if((avl_balance-balance)>2000.00)
			{
				FundTransferDto fdto=new FundTransferDto();
				fdto.setSaccno(saccno);
				fdto.setBaccno(baccno);
				fdto.setBalance(balance);
				fdto.setDot(dot);
				fdto.setIfcs(ifcs);
				fdto.setBanknm(banknm);
				
				FundTransferDao fdao=new FundTransferDao();
				fdao.insertData(fdto);
				response.sendRedirect("transfer.jsp");
				
			}
			else {
			    out.println("Transaction Cancelled as balance is low");
				RequestDispatcher rs=request.getRequestDispatcher("FundFailed.jsp");
				rs.include(request, response);
			}
	    }
		else {
			out.println("Invalid account number");
			RequestDispatcher rs=request.getRequestDispatcher("FundFailed.jsp");
			rs.include(request, response);
		}
	}
		
}
