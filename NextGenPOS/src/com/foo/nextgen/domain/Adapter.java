package com.foo.nextgen.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;

import com.foo.nextgen.ui.UI;

public class Adapter 
{
	
	private UI ui ;
	private Register register ;
	boolean  flag = true ;
	
	String  compositePricingStrategystring = "customer" ;
	PricingStrategyFactory pricingStrategyFactory = PricingStrategyFactory.pricingStrategyFactory ;
	CompositePricingStrategy compositePricingStrategy =  pricingStrategyFactory.getCompositePricingStrategy(compositePricingStrategystring) ;
	ISalePricingStrategy pricestrategy = pricingStrategyFactory.getISalePricingStrategy("per") ;
	
	
//***************************************Constructor**************************************************
	
	Adapter(UI ui ,Register register )
	{
		this.register = register ;
		this.ui = ui ;
	}

	
	
	
	
//**************************************Make new sale ****************************************
	
	public void process()
	{
		DefaultListModel list_model = ui.getListModel() ;
		compositePricingStrategy.add(pricestrategy);
		
		ui.getMakeNewSaleButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				//initial widget
				ui.getItemIdTextfield().setText("");
				ui.getAccountIdTextfield().setText("");
				ui.getQuantityTextfield().setText("");
				list_model.removeAllElements();
				ui.getPreviewTotalTextfield().setText("");
				ui.getTotalTextfield().setText("");
				ui.getPaymentTextfield().setText("");
				ui.getBalanceTextfield().setText("");
				
				
				//set default best price strategy
				if(!ui.getTotalTextfield().getText().equals(""))
				{
					compositePricingStrategystring = ui.getTotalTextfield().getText() ;
					compositePricingStrategy =  pricingStrategyFactory.getCompositePricingStrategy(compositePricingStrategystring);
					
				}
				
				compositePricingStrategy.strategies.clear();
				ISalePricingStrategy iSalePricingStrategyper = pricingStrategyFactory.getISalePricingStrategy("per") ;
				iSalePricingStrategyper.setParameter(1);
				compositePricingStrategy.add(iSalePricingStrategyper);
				register.makeNewSale();
				flag = true ;
				
			}});
		
//**************************************Make new sale item ***********************************
		
		ui.getConfirmButton().addActionListener(new ActionListener()
		{
			int account_number = 100 ;
			double  item_id ;
			int quantity ;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(flag)
					{
					register.makeNewSale();
					flag = false ;
					}
				
				
				
				if(!ui.getItemIdTextfield().getText().equals(""))
				{
					list_model.removeAllElements();
					item_id = Double.parseDouble(ui.getItemIdTextfield().getText());
					//if id=200 ,  add new price strategy
					if(item_id == 200)
					{
						ISalePricingStrategy iSalePricingStrategyper = pricingStrategyFactory.getISalePricingStrategy("per") ;
						iSalePricingStrategyper.setParameter(0.85);
						compositePricingStrategy.add(iSalePricingStrategyper);
					}
					
					//set default quantity 
					if(ui.getQuantityTextfield().getText().equals(""))
					{
						 quantity= 1 ;
					}else
					{
						quantity = Integer.parseInt(ui.getQuantityTextfield().getText()) ;
					}
					
					if(item_id>=100 && item_id <= 1000)
					{
						register.enterItem(item_id , quantity);
						register.endSale();
					}
					
					// if account number = 200 , add new price strategy
					if(ui.getAccountIdTextfield().getText().equals(""))
					{
						account_number = 0 ;
					}else
					{
						account_number = Integer.parseInt(ui.getAccountIdTextfield().getText()) ;	
					}
					 
					if(account_number == 200)
					{
						ISalePricingStrategy iSalePricingStrategyper = pricingStrategyFactory.getISalePricingStrategy("abs") ;
						//iSalePricingStrategyper.setParameter(0.80);
						compositePricingStrategy.add(iSalePricingStrategyper);
					}
					
					//show preview total 
					String result = "" ;
					result = result + register.getCurrentSale().getPreDiscountTotal() ;
					ui.getPreviewTotalTextfield().setText(result);
					
					// show total 
					System.out.println(compositePricingStrategy.getTotal(register.getCurrentSale()));
					String total_text = "";
					total_text = total_text +  String.format("%.2f", compositePricingStrategy.getTotal(register.getCurrentSale()));
					ui.getTotalTextfield().setText(total_text);
					
		
					List<SalesLineItem> lineItems  = register.getCurrentSale().getList() ;
					String list_item = "" ;
					for(SalesLineItem lineItem : lineItems)
					{
						
						ProductDescription desc = lineItem.getDescription() ;
						
						double item_id_show = desc.getItemID() ;
						double price = desc.getPrice() ;
						String description = desc.getDescription() ;
						int quantity_show = lineItem.getQuantity() ;
						double subtotal = lineItem.getSubtotal() ;
						
						list_item = "ItemID:  " + String.valueOf(item_id_show)+ "     Price:    " + String.valueOf(price)+ "      Description:    " + description + "      Quantity:    "+ String.valueOf(quantity_show) + "      SubTotal:    " + String.valueOf(subtotal);
						
						list_model.addElement(list_item);
						ui.getDetailList().setModel(list_model);
					}
					
					ui.getItemIdTextfield().setText("");
					ui.getQuantityTextfield().setText("");
					
				}
				
			}
			
		});
		
//****************************************Calculate balance***********************************
		
		ui.getEndSaleButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				double payment ;
				if(ui.getPaymentTextfield().getText().equals(""))
				{
					payment= 0.0 ;
					ui.getPaymentTextfield().setText("Please input Payment!");
				}else
				{
					payment = Double.parseDouble(ui.getPaymentTextfield().getText()) ;
				}
				
				register.makePayment(payment);
				//double balance = 
				double balance = payment - compositePricingStrategy.getTotal(register.getCurrentSale()) ;// register.getCurrentSale().getBalance() ;
				ui.getBalanceTextfield().setText(String.valueOf(String.format("%.2f",  balance)));
				
			}
		}); ;
	}
	
}
