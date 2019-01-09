package com.foo.nextgen.domain;


//**************************************Initial product description information*************

//record  product description ¡¢ quantity 

public class SalesLineItem 
{
	private int quantity ;
	private ProductDescription description ;
	
	public SalesLineItem(ProductDescription desc , int quantity )
	{
		this.description = desc ;
		this.quantity = quantity ;
	}
	
	public double getSubtotal()
	{
		return description.getPrice() *  quantity ;
	}
	
	public int getQuantity()
	{
		return quantity ;
	}
	public ProductDescription getDescription()
	{
		return description ;
	}
}
