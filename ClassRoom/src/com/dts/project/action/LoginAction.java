package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.dae.dao.ProfileDAO;
import com.dts.dae.dao.SecurityDAO;
import com.dts.dae.model.Profile;
import com.yourcompany.struts.form.ProfileForm;

public class LoginAction extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "LoginForm.jsp?status=Invalid username and password";
		try
		{HttpSession session=request.getSession();
			ProfileForm rb = new ProfileForm();
			String username = request.getParameter("username");
			rb.setLoginid(username);
			rb.setPassword(request.getParameter("password"));
             
			String role = new SecurityDAO().loginCheck(rb);
int userid=new SecurityDAO().getUserID(rb);
			if (role.equals("admin"))
			{
				target = "adminhome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("userid",userid);
			}
			else if (role.equals("student"))
			{
				
					target = "StudentHome.jsp?status=Welcome " + username;
				
					//target = "userhome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("userid",userid);
			}
			else if (role.equals("faculty"))
			{
				   System.out.println("SUDHEER");
					target = "FacultyHome.jsp?status=Welcome " + username;
				
					//target = "userhome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("facultyid",userid);
				System.out.println(session.getAttribute("facultyid"));
			}
			else
				target = "LoginForm.jsp?status=Invalid username and password";
		}
		catch (Exception e)
		{
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
