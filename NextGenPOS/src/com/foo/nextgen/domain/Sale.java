package com.foo.nextgen.domain;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.*;


//****************************************process sale : make line item  ; get  total  ; get balance  ; record data ******************************************************
public class Sale 
{
	private  List<SalesLineItem> lineItems = new ArrayList<SalesLineItem>() ;
	private Date date = new Date() ;
	private boolean isComplete = false ;
	private Payment payment ;
	
 
	
	public double getBalance()
	{
		return payment.getAmount() - this.getPreDiscountTotal() ;
	}
 
	public void becomeComplete()
	{ 
		isComplete = true ;
	}
	
	public boolean isComplete() 
	{
		return isComplete ;
	}
	
	public void makeLineItem( ProductDescription desc , int quantity )
	{
		lineItems.add(new SalesLineItem(desc , quantity)) ;
	}
	
	public double getPreDiscountTotal()
	{
		double total = 0 ;
		double subtotal = 0;
		
		for(SalesLineItem lineItem : lineItems)
		{
			subtotal = lineItem.getSubtotal() ;
			total  = total + subtotal;
		}
		
		return total ;
	}
	
 
	
	public void makePayment(double cashTendered)
	{
		payment = new Payment( cashTendered) ;
	}
	
	public List<SalesLineItem> getList()
	{
		return lineItems ;
	}
}
