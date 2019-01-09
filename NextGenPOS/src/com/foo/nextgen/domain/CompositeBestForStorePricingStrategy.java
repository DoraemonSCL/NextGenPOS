package com.foo.nextgen.domain;

import java.util.Iterator;

public class CompositeBestForStorePricingStrategy extends CompositePricingStrategy
{
	public double getTotal(Sale sale)
	{
		double lowestTotal = 0.0;
		
		for(Iterator i = strategies.iterator() ; i.hasNext();)
		{
			ISalePricingStrategy strategy = (ISalePricingStrategy)i.next() ;
			double total = strategy.getTotal(sale) ;
			lowestTotal = Math.max(total, lowestTotal) ;
		}
		
		return lowestTotal ;
	}

	@Override
	public void setParameter(double parameter) {
		// TODO Auto-generated method stub
		
	}
}
