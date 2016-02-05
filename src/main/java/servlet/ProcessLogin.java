package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.UserSecurity.LoginLogic;

/**
 * Servlet implementation class ProcessLogin
 */
public class ProcessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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

		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");

		LoginLogic loginLogic = new LoginLogic(userName, pwd);
		if (!loginLogic.isLoginSucess()) {

			out.println("<h1>Get OUT of Here you moroon</h1>");

		} else {
			out.println("Welcome " + userName.toString());
		}
		
		String txtHtml="<form action=\"ProcessLogin\" method=\"POST\">"+ "User Name : <input name=\"userName\"/><br>";
		txtHtml=txtHtml+"Password : <input name=\"pwd\" type=\"password\"/><br>"+"<input type=\"submit\" value=\"Login\"></form>";
		
		out.println(txtHtml);
		
	}

}
