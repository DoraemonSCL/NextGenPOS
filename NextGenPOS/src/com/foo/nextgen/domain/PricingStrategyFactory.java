package com.foo.nextgen.domain;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.management.InstanceAlreadyExistsException;

import com.foo.nextgen.data.SqlConnect;

public class PricingStrategyFactory 
{
	public static PricingStrategyFactory pricingStrategyFactory ;
	public ISalePricingStrategy iSalePricingStrategy ;
	public CompositePricingStrategy compositePricingStrategy ;
	public SqlConnect	sqlconnect ;
	Map<String , String> map = new HashMap<String , String>() ;
	
	public PricingStrategyFactory() 
	{
		// TODO Auto-generated constructor stub
		map.put("per", "com.foo.nextgen.domain.PercentageDiscountPricingStrategy") ;
		map.put("abs", "com.foo.nextgen.domain.AbsoluteDiscountOverThresholdPricingStrategy") ;
		map.put("customer", "com.foo.nextgen.domain.CompositeBestForCustomerPricingStrategy") ;
		map.put("store", "com.foo.nextgen.domain.CompositeBestForStorePricingStrategy") ;
		map.put("sql", "com.foo.nextgen.data.SqlConnect") ;
	}
	
	//instance factory 
	public static synchronized PricingStrategyFactory getInstance()
	{
		if(pricingStrategyFactory == null)
		{
			pricingStrategyFactory = new PricingStrategyFactory() ;
		}
		
		return pricingStrategyFactory ;
	}
	
	
	public ISalePricingStrategy getISalePricingStrategy(String classname)
	{
		
		
		//String className = System.getProperty("com.foo.nextgen.domain/PercentageDiscountPricingStrategy") ;
		//String PercentageDiscountPricingStrategy = "com.foo.nextgen.domain.PercentageDiscountPricingStrategy" ;
		try 
		{
			iSalePricingStrategy = (ISalePricingStrategy)Class.forName(map.get(classname)).newInstance() ;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return iSalePricingStrategy ;
	}
	
	
	public CompositePricingStrategy getCompositePricingStrategy(String beststrategy )
	{
		try {
			compositePricingStrategy = (CompositePricingStrategy)Class.forName(map.get(beststrategy)).newInstance()  ;
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compositePricingStrategy ;
	}
	
	public SqlConnect getSqlConnect()
	{
		
			 
		SqlConnect sqlconnect =  new SqlConnect(); 
			 
		return sqlconnect ;
	}
}
