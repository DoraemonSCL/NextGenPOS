package com.foo.nextgen.domain;

public class AbsoluteDiscountOverThresholdPricingStrategy implements ISalePricingStrategy
{
	private double discount ;
	private double threshold ;
	private double parameter ;
	
	public AbsoluteDiscountOverThresholdPricingStrategy() 
	{
		// TODO Auto-generated constructor stub
		discount = 50 ;
		threshold = 100 ;
	}
	
	public void setParameter(double parameter)
	{
		this.parameter = parameter ;
	}
	
	//set discount 
	public void setDiscount(double discount )
	{
		this.discount = discount ;
	}
	
	//set threshold 
	public void setThreshold(double threshold)
	{
		this.threshold = threshold ;
	}
	
	public double getTotal(Sale sale )
	{
		double pdt = sale.getPreDiscountTotal() ;
		
		if(pdt < threshold)
		{
			return pdt ;
		}
		return pdt - discount ;
	}
}
