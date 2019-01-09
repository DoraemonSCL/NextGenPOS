package com.foo.nextgen.domain;

import com.foo.nextgen.ui.UI;

public class NestGenPOS 
{
	
	
	public static void main(String []args)
	{
		Store store = new Store() ;
		Register register = store.getRegister() ;
		
		register.initialize();
		UI ui = new UI() ; 
		Adapter adapter = new Adapter(ui , register) ;
		ui.createFrame();
		adapter.process();
	}
}
