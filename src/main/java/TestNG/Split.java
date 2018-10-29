
package TestNG;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNG.Listener.class)
public class Split extends Loginapp {

	
	public Split() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority=6)
	 public void TakeoutOrder() throws InterruptedException, IOException{
		obj.load(objfile);
		  System.out.println("Order creation process is started with takeout");
		  System.out.println("In this class covered all split option with multiple guest");
		 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 	driver.findElement(By.id(obj.getProperty("CreateNewOrder"))).click();
	      	
	         try{
	    	        if(driver.findElement(By.id(obj.getProperty("CancelNewOrder"))).isDisplayed())
	    	         {
	    	        	
	    	        	 driver.findElement(By.xpath(obj.getProperty("TakeOutOrder"))).click();
	    	         }
	    	        
	         }catch (Exception e)
	         {
	 		       System.out.println("Catching transaction type exception");
	         }
	    	        
		String order_no=driver.findElement(By.id(obj.getProperty("OrderNo"))).getText();
		System.out.println("Order number is =>" + order_no);
		driver.findElement(By.id(obj.getProperty("AddGuest"))).click();
		driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).click();
    	driver.findElement(By.id(obj.getProperty("AddGuestDone"))).click();
		driver.findElement(By.xpath(obj.getProperty("AllItems"))).click();
			
			for (int g=0; g<3; g++)
			{
				
				driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index="+g+"]")).click();	
				
				
				for (int i=1; i<3; i++)
				{
					driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).click();
					try{
						System.out.println("searching for modifier ");
						if(driver.findElement(By.xpath(obj.getProperty("ModifierOnItem"))).isDisplayed())
						{
							System.out.println("Modifier displayed ");
							try{
								if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).isDisplayed())
								{
									System.out.println("clicking on modifier ");
									driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).click();
									driver.findElement(By.id(obj.getProperty("DoneItemModifier"))).click();
									
								}
							   
							 }catch(Exception e)
								{
							    	 System.out.println("Modifier is not present on modifier window hence entering custom modifier");
							    	 WebElement custom = driver.findElement(By.id(obj.getProperty("CustomModifierAdd")));
										custom.sendKeys("Spicy");
										WebElement count = driver.findElement(By.id(obj.getProperty("CustomModifierCount")));
										count.sendKeys("2");
										driver.findElement(By.id(obj.getProperty("AddCustomModifierBtn"))).click();
										custom.sendKeys("Extra Spicy");
										count.sendKeys("3");
										driver.findElement(By.id(obj.getProperty("AddCustomModifierBtn"))).click();
										driver.findElement(By.id(obj.getProperty("DoneItemModifie"))).click();
									
								}
						}
						
					}catch(Exception e)
					    {
						System.out.println("Catch exception");
						
						}
							
			   }
			}
	  }
  
	@Test(priority=7)
	   public void payment() throws InterruptedException
			
	     {
			List<WebElement> guest = driver.findElements(By.id("guest_name"));
			        
			System.out.println("Guest count is ==>" +guest.size());
			
			float orderamount = Float.parseFloat(driver.findElement(By.id("com.torenzo.torenzocafe:id/order_total_upside")).getText().substring(1));
			System.out.println("Order amount is ==>" +orderamount);
			
			driver.findElement(By.id(obj.getProperty("OrderTotalUpSide"))).click();
			float receipttotal = Float.parseFloat(driver.findElement(By.id("total_value")).getText().substring(1));
			System.out.println("receipt total is ==>" +receipttotal);
			   
			if (orderamount == receipttotal)
			{
				driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();		
			      System.out.println("This logic for multiple guest");
					
			        driver.findElement(By.id(obj.getProperty("SplitEquallyForAllLayout"))).click();
			        System.out.println("spliting equally for all tab no. 2"); 
			        List<WebElement> puff = driver.findElements(By.id("name"));
			    	System.out.println("Receipt count is==> " +puff.size());
			    	
			    	for(WebElement we:puff)
			    	{
				    		   we.click();
				    		   driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
				    		   driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
				    	       String paymentamonut = driver.findElement(By.id("payment_value")).getText().substring(1);
				    	    
				    	      System.out.println("paymentamonut total is ==>" +paymentamonut);
				   
					    	  System.out.println("here 1"); 
					    	  System.out.println("paymentamonut total is ==>" +receipttotal);  
					    	  float perreceipt = (receipttotal/puff.size());
					    	  System.out.println("here 2"); 
					    	  System.out.println("even total is ==>" +perreceipt);
					    	  Float paymentamountwindow = Float.parseFloat(paymentamonut);
					    	  System.out.println("payment amount is ==>" +paymentamountwindow);
					    	  
			     if(paymentamountwindow== perreceipt)
			    	  {
			    	     System.out.println("amount match");
			    	     driver.findElement(By.id("delete_card")).click();
			    	     driver.findElement(By.id("button2")).click();
			    	
			    		  driver.findElement(By.id("cancel_dialog")).click();
			    	  }
			    	   else
			    	    {
			    		  System.out.println("Value not proper divide");  
			    	    }
			
			    	}
			     	System.out.println("tap on split receipt");  
			    	driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();	 
			   
			        driver.findElement(By.id(obj.getProperty("SplitEquallyBySelectedGuestLayout"))).click();	
			        System.out.println("spliting equally per guest  tab no. 4");  
			    	List<WebElement> guestcount = driver.findElements(By.id("guest_name"));
			    	System.out.println("Total guest present on window =>" +guestcount.size());
			
			    	for(WebElement we:guestcount)
			    	{
			    		we.click();
			    	}

			        driver.findElement(By.id("doneClick")).click();	
			    	System.out.println("Receipt count is==> " +puff.size());
			    	for(WebElement we:puff)
			    	{
				    		   we.click();
				    		   driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
				    		   driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
				    	       String paymentamonut = driver.findElement(By.id("payment_value")).getText().substring(1);
				    	    
				    	      System.out.println("paymentamonut total is ==>" +paymentamonut);
				   
					    	  System.out.println("here 1"); 
					    	 
					    	  float perguest = (receipttotal/guestcount.size());
					    	  System.out.println("here 2"); 
					    	  System.out.println("per guest amountt ==>" +perguest);
					    	  Float paymentamountwindow = Float.parseFloat(paymentamonut);
					    	  System.out.println("payment amount is ==>" +paymentamountwindow);
		       		if(paymentamountwindow  == perguest)
			    	  {
		       			System.out.println("amount match");
		       		 driver.findElement(By.id("delete_card")).click();
		    	     driver.findElement(By.id("button2")).click();
		    	
			    		  driver.findElement(By.id("cancel_dialog")).click();
			    		  
			    	  }
			    
		       		else {
		       			
		       			
		       		  System.out.println("Value not proper divide");
		       			
		       			
		       	     	}
		       		
			    	}
			  	System.out.println("tap on split receipt");  
			       
			    	driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();	
			    	driver.findElement(By.xpath(obj.getProperty("SingleReceipt"))).click();
			    	driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();	
			    	 driver.findElement(By.id("bill_selected_guest_layout")).click();
			    	System.out.println("Bill selected guest from split receipt window tab no .5");
			    	
			    	
			    	List<WebElement> guestcount1 = driver.findElements(By.id("guest_name"));
			    	System.out.println("Total guest present on guest =>" +guestcount1.size());
			
			    	for(WebElement we:guestcount1)
			    	{
			    		we.click();
			    	}
			      
                    driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
			    
			    	System.out.println("Receipt count is==> " +puff.size());
			    	for(WebElement we:puff)
			    	{
				    		   we.click();
				    		   driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
				    		   driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
				    	       String paymentamonut = driver.findElement(By.id("payment_value")).getText().substring(1);
				    	    
				    	      System.out.println("paymentamonut total is ==>" +paymentamonut);
				   
					    	  System.out.println("here 1"); 
					    	 
					    	  float perguest = (receipttotal/guestcount1.size());
					    	  System.out.println("here 2"); 
					    	  System.out.println("per guest amountt ==>" +perguest);
					    	  Float paymentamountwindow = Float.parseFloat(paymentamonut);
					    	  System.out.println("payment amount is ==>" +paymentamountwindow);
		       		if(paymentamountwindow  == perguest)
			    	  {
		       			System.out.println("amount match");
		       		   driver.findElement(By.id("delete_card")).click();
		    	       driver.findElement(By.id("button2")).click();
		    	
			    		  driver.findElement(By.id("cancel_dialog")).click();
			    		  
			    	  }
			    
		       		else {
		       			
		       			
		       		  System.out.println("Value not proper divide");
		       			
		       			
		       	     	}
		       		
			    	}
			    	
			    	System.out.println("tap on split receipt");  
			    	driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();	
			    	driver.findElement(By.xpath(obj.getProperty("SingleReceipt"))).click();
			    	driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();	
			    	 driver.findElement(By.id("select_guest_combine_layout")).click();
			    	System.out.println("Payment with taking guest as combine tab no. 6");
			    	List<WebElement> guestcount2 = driver.findElements(By.id("guest_name"));
			    	System.out.println("Total guest present on guest =>" +guestcount2.size());
			
			    	for(WebElement we:guestcount2)
			    	{
			    		we.click();
			    	}
			      

			        driver.findElement(By.id("doneClick")).click();	
			        List<WebElement> puff1 = driver.findElements(By.id("name")); 
			    	System.out.println("Receipt count is==> " +puff1.size());
			    	for(WebElement we:puff1)
			    	{
				    		   we.click();
				    		   driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
				    		   driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
				    	       String paymentamonut = driver.findElement(By.id("payment_value")).getText().substring(1);
				    	    
				    	      System.out.println("paymentamonut total is ==>" +paymentamonut);
				   
					    	  System.out.println("here 1"); 
					    	 
					    	  float perguest = (receipttotal/puff1.size());
					    	  System.out.println("here 2"); 
					    	  System.out.println("per guest amountt ==>" +perguest);
					    	  Float paymentamountwindow = Float.parseFloat(paymentamonut);
					    	  System.out.println("payment amount is ==>" +paymentamountwindow);
		       		if(paymentamountwindow  == perguest)
			    	  {
		       			System.out.println("amount match");
		       		 driver.findElement(By.id("delete_card")).click();
		    	     driver.findElement(By.id("button2")).click();
		    	
			    		  driver.findElement(By.id("cancel_dialog")).click();
			    		  
			    	  }
			    
		       		else {
		       			
		       			
		       		  System.out.println("Value not proper divide");
		       			
		       			
		       	     	}
		       		
			    	}
   
			 	System.out.println("tap on split receipt");  
			 	driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();	
		    	driver.findElement(By.xpath(obj.getProperty("SingleReceipt"))).click();
				
				List<WebElement> puff11 = driver.findElements(By.id("name"));
					System.out.println("Receipt count is==> " +puff11.size());
				for(WebElement we:puff11)
				{
			     	we.click();
			     	 driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
		    		   driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
			       String payment = driver.findElement(By.xpath("//android.widget.TextView[@text='Payment']")).getText();
				    System.out.println("Window is " + payment);		
				    driver.findElement(By.id(obj.getProperty("DoneGuest"))).click();
					 driver.findElement(By.xpath(obj.getProperty("CloseTableWithoutReceipt"))).click();
				  System.out.println("Click on Close table without receipt and entring into try"); 
				try
				{
					System.out.println("without closing tbl"); 
					driver.findElement(By.id(obj.getProperty("ContinueWithoutClosingTable"))).click();
				}
				catch (Exception e)
				{
					 System.out.println("Catching exception here"); 
					 System.out.println("Order is succefully created and paid");
					
				}
				
				         
				}		
				 driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']")).click();
			}	

			System.out.println("Order splited with multiple option present with more than one guest DONE (Split class)");
			}
    
	
       }
	
	

