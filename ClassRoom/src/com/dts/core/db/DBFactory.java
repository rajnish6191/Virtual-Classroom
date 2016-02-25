package com.dts.core.db;

import com.dts.core.dao.AbstractDataAccessObject;

public class DBFactory
{
	public DBFactory()
	{
		new AbstractDataAccessObject().getConnection();
	}
}
