package com.foo.nextgen.domain;

import java.util.HashMap;
import java.util.Map;

public class PercentageDiscountPricingStrategy implements ISalePricingStrategy
{
	private double percentage   ;
	
	public PercentageDiscountPricingStrategy()
	{
		this.percentage = 1 ;
	}
	public void  setParameter(double parameter)
	{
		this.percentage = parameter ;
	}
	
	//calculate total 
	public double getTotal(Sale sale)
	{
		return sale.getPreDiscountTotal() * percentage ;
	}
}
