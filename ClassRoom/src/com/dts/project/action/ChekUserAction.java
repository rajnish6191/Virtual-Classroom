package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.dae.dao.SecurityDAO;

public class ChekUserAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String target = "Registerform.jsp?status1=Invalid username and password";
		try
		{
			
			 
			String user = new SecurityDAO().checkUser(username);

			if (user.equals(null))
			{
				target = "Registerform.jsp?status1=<font color=green>_/Available</font>";
				
			}
			
			else
				target = "Registerform.jsp?status1=<font color=red>Alreadyexist</font>&userName="+username;
		}
		catch (Exception e)
		{
			target = "Registerform.jsp?status1=<font color=green>_/<b>Available</b></font>&userName="+username;
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);	}

}
