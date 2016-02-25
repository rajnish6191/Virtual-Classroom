package com.dts.core.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.core.util.LoggerManager;

public class ReportController extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException
	{
		try
		{
			res.sendRedirect("ReportDateSelector.jsp");
		}
		catch (IOException ioe)
		{
			LoggerManager.writeLogInfo(ioe);
		}
	}
}
