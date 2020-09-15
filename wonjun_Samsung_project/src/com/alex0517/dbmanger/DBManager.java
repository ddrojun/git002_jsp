package com.alex0517.dbmanger;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	private static Connection conn;
	public DBManager() {conn =null;	}
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		//DataSource db = (DataSource)envContext.lookup("jdbc/day003");
		DataSource db = (DataSource)envContext.lookup("jdbc/alex0517"); //호스팅용
		///////////////////////////////////////////////////////////////////
		
		conn = db.getConnection();
		return conn;
		
	}
}
