package com.foo.nextgen.domain;

import java.math.BigDecimal;


//****************************************Product description ！！Item id 、 price 、description********************************************************

public class ProductDescription 
{
	private double id ;
	private double price ;
	private String description ;
	
	public ProductDescription(double id , double price , String description)
	{
		this.id = id ;
		this.price = price ;
		this.description = description ;
	}
	
	public double getItemID()
	{
		return id ;
	}
	
	public double getPrice()
	{
		return price ;
	}
	
	public String getDescription()
	{
		return description ;
	}
}
