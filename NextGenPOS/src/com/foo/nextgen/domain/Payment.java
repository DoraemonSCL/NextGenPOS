package com.foo.nextgen.domain;

import java.math.BigDecimal;

//************************************customer payment **************************************************
public class Payment 
{
	private double amount ;
	public Payment(double cashTendered ) 
	{ 
		amount = cashTendered ;
	}
	public double getAmount() 
	{
		return amount ;
	} ;
}
