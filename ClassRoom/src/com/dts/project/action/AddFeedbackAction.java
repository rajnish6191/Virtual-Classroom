package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dts.dae.dao.SecurityDAO;
import com.yourcompany.struts.form.ProfileForm;

public class AddFeedbackAction extends HttpServlet {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	private static final long serialVersionUID = -2941564269120432640L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		boolean flag = false;
		String path = "";
		HttpSession session = request.getSession();

		// if(session.getAttribute("user")==null)
		// response.sendRedirect("LoginForm.jsp?status=Session Expired");

		String page = "";

		String target = "Password Changed Failed";
		ProfileForm profileForm = new ProfileForm();
		profileForm.setFeedback(request.getParameter("feedback"));
		profileForm.setLoginid(request.getParameter("username"));

		flag = new SecurityDAO().postFeedback(profileForm);

		if (flag) {
			target = page + "?status=feed back posted Successfully";
			request.setAttribute("status", target);
			path = "./StudentHome.jsp";
		} else {
			target = page + "?status=Password Changed Failed";
			request.setAttribute("status", target);
			path = "./StudentHome.jsp";
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}