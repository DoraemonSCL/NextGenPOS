package com.foo.nextgen.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnect
{
	public Statement connect()
	{
		 try {  
		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������     
		      //Class.forName("org.gjt.mm.mysql.Driver");  
		     System.out.println("Success loading Mysql Driver!");  
		    }  
		    catch (Exception e) {  
		      System.out.print("Error loading Mysql Driver!");  
		      e.printStackTrace();  
		    }  
		    try 
		    {  
		      Connection connect = DriverManager.getConnection(  
		          "jdbc:mysql://localhost:3306/store?serverTimezone=UTC","root","123456");  
		           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������  
		  
		      System.out.println("Success connect Mysql server!");  
		       return  connect.createStatement();  
		    }  
		    catch (Exception e) {  
		      System.out.print("get data error!");  
		      e.printStackTrace();  
		    }
			return null;  
	}
}
