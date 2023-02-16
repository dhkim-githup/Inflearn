package com.example.webstory.comm;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {


	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
	String user_id="scott";
	String user_pw="tiger";
	String qry="";

	private Connection conn = null; // DB �� connection �� ��ü�� ����

	public Connection getConn(){

		try{
			/* Driver Loading */
		    Class.forName(driver);
		    conn = DriverManager.getConnection(dbURL, user_id, user_pw);
		    
		    /* Transaction ó���� ����ڰ� ���� �ϵ��� �Ѵ� */
		    conn.setAutoCommit(false); 

		    System.out.println("OK Connection");

		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return conn;
	}


}