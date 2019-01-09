package com.foo.nextgen.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositePricingStrategy implements ISalePricingStrategy
{
	protected List<ISalePricingStrategy> strategies = new ArrayList<ISalePricingStrategy>();
	
	public void add(ISalePricingStrategy s)
	{
		strategies.add(s) ;
	}
	
	
	public abstract double getTotal(Sale sale) ;
	 
	
}
