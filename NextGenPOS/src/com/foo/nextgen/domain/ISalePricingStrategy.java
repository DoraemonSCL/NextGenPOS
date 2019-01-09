package com.foo.nextgen.domain;

public interface ISalePricingStrategy
{
	double getTotal(Sale sale) ;
	void setParameter(double parameter);
}
