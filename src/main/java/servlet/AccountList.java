package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objModelAccount.Account;
import businessLogicAccount.businessAccount;

/**
 * Servlet implementation class AccountList
 */
public class AccountList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		businessAccount businessAccount = new businessLogicAccount.businessAccount();

		out.println("<h1>Account List</h1>");
		Iterator<Account> iterator = businessAccount.getAccountList()
				.iterator();

		Account account = new Account();
		while (iterator.hasNext()) {
			account = iterator.next();
			out.println(account.getAccountNo() + " " + account.getAccountName()
					+ " " + account.getAccountType() + "  "
					+ account.getAccountBalance()+"<br>");

		}
	}
}
