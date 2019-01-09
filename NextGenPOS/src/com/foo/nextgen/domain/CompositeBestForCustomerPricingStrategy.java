package com.foo.nextgen.domain;

import java.util.Iterator;

public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy
{
	public double getTotal(Sale sale)
	{
		double lowestTotal = Integer.MAX_VALUE ;
		
		for(Iterator i = strategies.iterator() ; i.hasNext() ;)
		{
			ISalePricingStrategy strategy = (ISalePricingStrategy)i.next();
			double total = strategy.getTotal(sale) ;
			
			lowestTotal = Math.min(total , lowestTotal) ;
		}
		
		return lowestTotal ;
		
	}

	@Override
	public void setParameter(double parameter) {
		// TODO Auto-generated method stub
		
	}

}
