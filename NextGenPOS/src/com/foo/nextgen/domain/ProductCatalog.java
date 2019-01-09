package com.foo.nextgen.domain;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.foo.nextgen.data.SqlConnect;
import com.mysql.cj.protocol.Resultset;


//********************************************product catalog*****************************************************************

//Use Map storage product catalog ¡ª¡ª(key:ItemID , value : ProductDescription)

public class ProductCatalog
{
	private Map<Double , ProductDescription> descriptions = new HashMap<Double , ProductDescription>() ;
	SqlConnect sqlConnect = new SqlConnect() ;
 
//Initial ten product information 
	ProductDescription desc ;
	public ProductCatalog()
	{
		 Statement  statement = sqlConnect.connect() ;
		 ResultSet rs;
			try 
			{
				rs = statement.executeQuery("select * from productdescription");
				while(rs.next())
				{
					desc = new ProductDescription(rs.getDouble("id") , rs.getDouble("price") , rs.getString("description")) ;
					descriptions.put( rs.getDouble("id"), desc) ;
				}
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
		
		/*
		double id1 = 100 ;
		double id2 = 200 ;
		double id3 = 300 ;
		double id4 = 400 ;
		double id5 = 500 ;
		double id6 = 600 ;
		double id7 = 700 ;
		double id8 = 800 ;
		double id9 = 900;
		double id10 = 1000 ;
		
		
		double price1 = 1;
		double price2 = 2;
		double price3 = 3;
		double price4 = 4;
		double price5 = 5;
		double price6 = 6;
		double price7 = 7;
		double price8 = 8;
		double price9 = 9;
		double price10 = 10;
		
		
		
		desc = new ProductDescription(id1 , price1 , "product 1 ") ;
		descriptions.put(id1, desc ) ;
		desc = new ProductDescription(id2 , price2 , "product 2") ;
		descriptions.put(id2, desc);
		desc = new ProductDescription(id3 , price3 , "product 3 ") ;
		descriptions.put(id3, desc ) ;
		desc = new ProductDescription(id4 , price4 , "product 4") ;
		descriptions.put(id4, desc);
		desc = new ProductDescription(id5 , price5 , "product 5 ") ;
		descriptions.put(id5, desc ) ;
		desc = new ProductDescription(id6 , price6 , "product 6") ;
		descriptions.put(id6, desc);
		desc = new ProductDescription(id7 , price7 , "product 7 ") ;
		descriptions.put(id7, desc ) ;
		desc = new ProductDescription(id8 , price8 , "product 8") ;
		descriptions.put(id8, desc);
		desc = new ProductDescription(id9 , price9 , "product 9 ") ;
		descriptions.put(id9, desc ) ;
		desc = new ProductDescription(id10 , price10 , "product 10") ;
		descriptions.put(id10, desc);
		*/
	}
	
	
	
	public ProductDescription getProductDescription(double id )
	{
		return descriptions.get(id);
	}
}
