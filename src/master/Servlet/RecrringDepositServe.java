package master.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.AccountDao;
import master.DAO.RecurringDepositDao;
import master.DTO.RecurringDepositDto;

/**
 * Servlet implementation class RecrringDepositServe
 */
public class RecrringDepositServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecrringDepositServe() {
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
	    Double rdamt=Double.parseDouble(request.getParameter("rdamt"));
	    Integer month=Integer.parseInt(request.getParameter("month"));
		String accno=request.getParameter("accno");
		String dopen=request.getParameter("dopen");
		
		
		AccountDao adao=new AccountDao();
		//create an object of this class n call these methods to do check eligibility b4 fund transfer;
			double avl_balance=adao.getBalance(accno);
			if((avl_balance-rdamt)>2000.00)
			{
				if(month>=6) {
				//accepting values in fixedDeposit table
				RecurringDepositDto rcdto=new RecurringDepositDto();
				rcdto.setRdamt(rdamt);
				rcdto.setMonth(month);
				rcdto.setAccno(accno);
				rcdto.setDopen(dopen);
				
				
				RecurringDepositDao rcdao=new RecurringDepositDao();
				rcdao.insertData(rcdto);
				//out.println("Recurring Deposit created!!");
				RequestDispatcher rs=request.getRequestDispatcher("DisplayRD.jsp");
				rs.include(request, response);
			  }
				else {
					out.println("Recurring Deposit cannot be created for less than 6 months!!");
					RequestDispatcher rs=request.getRequestDispatcher("FundFailed.jsp");
					rs.include(request, response);
				}
			}
					
			else
			{
				out.println("Recurring Deposit cannot be created due to low balance!!");
				RequestDispatcher rs=request.getRequestDispatcher("FundFailed.jsp");
				rs.include(request, response);
			}
		}
	}


