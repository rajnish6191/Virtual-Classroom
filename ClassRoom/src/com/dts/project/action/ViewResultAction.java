package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.core.util.CoreList;
import com.dts.dae.dao.SecurityDAO;
import com.yourcompany.struts.form.ProfileForm;

public class ViewResultAction extends HttpServlet {
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

		String target = "";
		CoreList v = new SecurityDAO().viewResults(request
				.getRealPath("./images"));
		System.out.println("c1 :" + v);

		path = "./ViewResults.jsp?c1=" + v;
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}