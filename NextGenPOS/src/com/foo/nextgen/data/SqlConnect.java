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
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序     
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
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码  
		  
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
