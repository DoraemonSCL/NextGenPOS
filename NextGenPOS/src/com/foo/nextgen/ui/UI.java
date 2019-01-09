package com.foo.nextgen.ui;

import java.awt.Font;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class UI extends JFrame
{
//********************************************declare weights******************************************************
	JButton make_new_sale_button ;
	JButton confirm_button ;
	JButton end_sale_button ;
	JTextField item_id_textfield ;
	JTextField account_id_textfield ;
	JTextField quantity_textfield ;
	JTextField detail_show_textfield ;
	JList detail_list ;
	JTextField preview_total_textfield ;
	JTextField total_textfield ;
	JTextField payment_textfield ;
	JTextField balance_textfield ;
	DefaultListModel list_model ;
	
	
//***************************************get()****************************************************
	
	
	public JButton getMakeNewSaleButton()
	{
		return make_new_sale_button ;
	}
	
	public JButton getConfirmButton()
	{
		return confirm_button ;
	} 
	
	public JButton getEndSaleButton()
	{
		return end_sale_button ;
	}
	
	public JTextField getItemIdTextfield()
	{
		return item_id_textfield ;
	}
	
	public JTextField getAccountIdTextfield()
	{
		return account_id_textfield ;
	}
	
	public JTextField getQuantityTextfield()
	{
		return quantity_textfield ;
	}
	
	public JTextField getDetailShowTextfieldTextfield()
	{
		return detail_show_textfield ;
	}
	
	public JList getDetailList()
	{
		return detail_list ;
	}
	
	public JTextField getPaymentTextfield()
	{
		return payment_textfield ;
	}
	
	public JTextField getPreviewTotalTextfield()
	{
		return preview_total_textfield ;
	}
	
	public JTextField getTotalTextfield()
	{
		return total_textfield ;
	}
	
	public JTextField getBalanceTextfield()
	{
		return balance_textfield ;
	}
	
	public DefaultListModel getListModel()
	{
		return list_model ;
	}
	
	
//*****************************setUMLFont*************************************************
	
	
 private static void InitGlobalFont(Font font) {
	  FontUIResource fontRes = new FontUIResource(font);
	  for (Enumeration<Object> keys = UIManager.getDefaults().keys();
	  keys.hasMoreElements(); ) {
	  Object key = keys.nextElement();
	  Object value = UIManager.get(key);
	  if (value instanceof FontUIResource) {
	  UIManager.put(key, fontRes);
	  }
	  }
}  
	
 
//*********************Create frame ************************************
 
 
		public void createFrame()
		{
			 InitGlobalFont(new Font("alias", Font.PLAIN, 20)); 
			
			JFrame.setDefaultLookAndFeelDecorated(true);
			
			JFrame frame = new JFrame("The Foo Store") ;
			frame.setSize((int)(2*1.2*580),(int)(1.2*800));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			JPanel panel = new JPanel() ;
			frame.add(panel) ;
			
			placeComponents(panel);
			
			
			frame.setVisible(true);
			
		}
		

//***********************Fill in panel *********************************
		
		
		public void placeComponents(JPanel panel)
		{
			panel.setLayout(null);

			
			int height_space = (int)(1.2 * 40) ;
			int height =(int) (1.2 * 50) ;
			int linespace = (int)(1.2* 30) ;
			int label_width =(int)( 1.5 * 60) ;
			int text_width = (int)(2 * 1.5 * 300) ;
			int width_space =(int) ( 1.5 * 80) ;
			
			
			Font font = new Font("TimesRoman",Font.BOLD,20);
			
			//create item_id label and text field 
			JLabel item_id_label = new JLabel("Item ID: ") ;
			item_id_label.setBounds(width_space, height_space, label_width, height);
			item_id_label.setFont(font);
			panel.add(item_id_label) ;
			
			item_id_textfield = new  JTextField() ;
			item_id_textfield.setBounds(width_space + label_width , height_space, text_width / 3, height) ;
			item_id_textfield.setFont(font);
			panel.add(item_id_textfield) ;
			
			//create account number label and text field 
			JLabel account_id_label = new JLabel("Account ID: ") ;
			account_id_label.setBounds(width_space + label_width  + text_width / 3, height_space, 3*label_width / 2 , height);
			account_id_label.setFont(font);
			panel.add(account_id_label) ;
			
			account_id_textfield = new  JTextField() ;
			account_id_textfield.setBounds(width_space + label_width  + text_width / 3 + 3*label_width /2, height_space, text_width / 6 , height) ;
			account_id_textfield.setFont(font);
			panel.add(account_id_textfield) ;
			
			//create quantity label and text field 
			JLabel quantity_label = new JLabel("Quantity:") ;
			quantity_label.setBounds(width_space + label_width  + text_width / 3 + 3*label_width /2 + text_width / 6, height_space   , label_width, height);
			quantity_label.setFont(font);
			panel.add(quantity_label) ;
			
			quantity_textfield = new  JTextField() ;
			quantity_textfield.setBounds(width_space + label_width  + text_width / 3 + 3*label_width /2 + text_width / 6  + label_width , height_space   , text_width / 10, height) ;
			quantity_textfield.setFont(font);
			panel.add(quantity_textfield) ;
			
			// create confirm button
			confirm_button = new JButton("Confirm");
			confirm_button.setBounds(width_space + label_width  + text_width / 3 + 3*label_width /2 + text_width / 6  + label_width + text_width / 8 , height_space, 3 * text_width/16, height);
			confirm_button.setFont(font);
			panel.add(confirm_button);
			
			// create  detail's list 
			detail_list = new JList() ;
			detail_list.setBounds(width_space + label_width , height_space +( height + linespace), text_width, 4 * height);
			list_model = new DefaultListModel() ;
			panel.add(detail_list) ;
			
			//preview total money's label
			JLabel pretotal_label = new JLabel("PreTotal:") ;
			pretotal_label.setBounds(text_width / 24 + width_space + label_width , height_space +4*( height + linespace), text_width / 4, height);
			pretotal_label.setFont(font);
			panel.add(pretotal_label) ;
			
			// total money's label
			JLabel total_label = new JLabel("Total:") ;
			total_label.setBounds(text_width / 24 + width_space + label_width + text_width / 8, height_space +4*( height + linespace), text_width / 4, height);
			total_label.setFont(font);
			panel.add(total_label) ;
			
			//preview total money 
		    preview_total_textfield = new JTextField() ;
		    preview_total_textfield.setBounds(text_width / 24 + width_space + label_width , height_space +4*( height + linespace) + height, text_width / 8, height);
		    preview_total_textfield.setFont(font);
			panel.add(preview_total_textfield) ;
			
			//total money 
		     total_textfield = new JTextField() ;
		     total_textfield.setBounds(text_width / 24 + width_space + label_width + text_width / 8 , height_space +4*( height + linespace) + height, text_width / 8, height);
		     total_textfield.setFont(font);
			panel.add( total_textfield) ;
			
			//total money's label
			JLabel pyament_label = new JLabel("Payment:") ;
			pyament_label.setBounds(text_width / 24 + width_space + label_width + (text_width / 3) , height_space +4*( height + linespace), text_width / 4, height);
			pyament_label.setFont(font);
			panel.add(pyament_label) ;
			
			//payment money 
			payment_textfield = new JTextField() ;
			payment_textfield.setBounds(text_width / 24 + width_space + label_width + (text_width / 3) , height_space +4*( height + linespace) + height, text_width / 4, height);
			payment_textfield.setFont(font);
			panel.add(payment_textfield) ;
			
			//total money's label
			JLabel balance_label = new JLabel("Balance:") ;
			balance_label.setBounds(text_width / 24 + width_space + label_width + 2* (text_width / 3) , height_space +4*( height + linespace), text_width / 4, height);
			balance_label.setFont(font);
			panel.add(balance_label) ;
			
			//balance money 
			balance_textfield = new JTextField() ;
			balance_textfield.setBounds(text_width / 24 + width_space + label_width + 2* (text_width / 3) , height_space +4*( height + linespace) + height, text_width / 4, height);
			balance_textfield.setFont(font);
			panel.add(balance_textfield) ;
			
			//create submit button 
			make_new_sale_button = new JButton("Make New Sale ");
			make_new_sale_button.setBounds(width_space, height_space +6*( height + linespace), text_width/2, height);
			make_new_sale_button.setFont(font);
			panel.add(make_new_sale_button);
			end_sale_button = new JButton("End Sale");
			end_sale_button.setBounds(2*width_space + text_width / 2, height_space +6*( height + linespace), text_width/2, height);
			end_sale_button.setFont(font);
			panel.add(end_sale_button);
		}
}
