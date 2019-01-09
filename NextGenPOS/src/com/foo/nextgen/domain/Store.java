package com.foo.nextgen.domain;


// use store instantiate class --------catalog/register 
public class Store 
{
	 
	
	private ProductCatalog catalog = new ProductCatalog();
	private Register register = new Register(catalog);
	
	public  Register getRegister(){return register ;}
		
 
	   
}
