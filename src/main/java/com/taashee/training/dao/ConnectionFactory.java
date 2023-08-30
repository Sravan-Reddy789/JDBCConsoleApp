package com.taashee.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
	private static ConnectionFactory connectionFactory = new ConnectionFactory();
	private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/trainingdb";
	private final String USERNAME = "root";
	private final String PASSWORD = "taashee123";
	
		public ConnectionFactory()
		{
			try {
				Class.forName(DRIVER_CLASS);}
			catch(ClassNotFoundException e){
				e.printStackTrace();}
		}
		private Connection fetchConnection()
		{
			Connection con= null;
			try
			{
				con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			}
			catch(SQLException throwables)
			{
				throwables.printStackTrace();
			}
			return con;
		}
		public static Connection getConnection()
		{
			return connectionFactory.fetchConnection();
		}
		
}
