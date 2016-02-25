package com.dts.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.db.DBFactory;

public class InitServlet extends HttpServlet
{
	AbstractDataAccessObject dobject;

	public void init(ServletConfig sc)
	{
		ServletContext ctx = sc.getServletContext();
		InputStream fis = ctx.getResourceAsStream(sc.getInitParameter("config"));
		Properties props = new Properties();
		
		try
		{
			props.load(fis);
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		dobject = new AbstractDataAccessObject();
		dobject.setProperties(props);

		LoggerManager.logger = new LoggerManager().getLogger(props.getProperty("logfile"));
		LoggerManager.writeLogInfo("Logger Instantiated");

		try
		{
			new DBFactory();
		}
		catch (NullPointerException npe)
		{
			LoggerManager.writeLogWarning("Connection to database FAILED");
		}
	}
}
