package master.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.AccountDao;
import master.DAO.FixedDepositDao;
import master.DTO.FixedDepositDto;

/**
 * Servlet implementation class FixedDepositServe
 */
public class FixedDepositServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixedDepositServe() {
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
	    Double fdamt=Double.parseDouble(request.getParameter("fdamt"));
	    Double years=Double.parseDouble(request.getParameter("years"));
		String accno=request.getParameter("accno");
		String dopen=request.getParameter("dopen");
		
		
		AccountDao adao=new AccountDao();
		//create an object of this class n call these methods to do check eligibility b4 fund transfer;
			double avl_balance=adao.getBalance(accno);
			if((avl_balance-fdamt)>2000.00)
			{
				//accepting values in fixedDeposit table
				FixedDepositDto fdto=new FixedDepositDto();
				fdto.setFdamt(fdamt);
				fdto.setYear(years);
				fdto.setAccno(accno);
				fdto.setDopen(dopen);
				
				FixedDepositDao fdao=new FixedDepositDao();
				fdao.insertData(fdto);
				RequestDispatcher rs=request.getRequestDispatcher("DisplayFD.jsp");
				rs.include(request, response);
			}
			else
			{
				out.println("Fixed Deposit cannot be created due to low balance!!");
				RequestDispatcher rs=request.getRequestDispatcher("FundFailed.jsp");
				rs.include(request, response);
			}
		}
		
	}
