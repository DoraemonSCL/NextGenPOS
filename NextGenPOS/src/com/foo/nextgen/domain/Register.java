package com.foo.nextgen.domain;

import java.math.BigDecimal;


//***********************Register: make new sale ; enter Item ; end sale  ; make payment  *****************************************************


public class Register 
{
	private ProductCatalog catalog ;
	private Sale currentSale ;
	//private ISalePricingStrategy iSalePricingStrategy ;
	PricingStrategyFactory pricingStrategyFactory ;
	CompositePricingStrategy compositePricingStrategy ;
	public Register( ProductCatalog catalog )
	{
		this.catalog = catalog ;
	}
	
	public void endSale()
	{
		currentSale.becomeComplete();
	}
	
	public void enterItem(double id , int quantity)
	{
		ProductDescription desc = catalog.getProductDescription(id);
		currentSale.makeLineItem(desc, quantity);
	}
	
	public void makeNewSale()
	{
		currentSale  = new Sale() ;
		 
	}
	
	public void makePayment(double cashTendered)
	{
		currentSale.makePayment(cashTendered) ;
	}
	
	public Sale getCurrentSale()
	{
		return currentSale ;
	}
	
 
	
	public void initialize()
	{
		//PricingStrategyFactory pricingStrategyFactory = PricingStrategyFactory.getInstance();
		pricingStrategyFactory = PricingStrategyFactory.getInstance();
		
	}
	
	
	/*public PricingStrategyFactory getPricingStrategyFactory()
	{
		return pricingStrategyFactory ;
	}*/
 

}
