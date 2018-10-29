package TestNG;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNG.Listener.class)
public class Split1 extends Loginapp {
    
	
	public Split1() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Test(priority=8)
      public void ordercreate() throws IOException
      {
		obj.load(objfile);
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  System.out.println("Order creation process is started with takeout");
		  System.out.println("In this class covered all split option with one guest");
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
		driver.findElement(By.xpath(obj.getProperty("AllItems"))).click();
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
		}catch (Exception e)
		{
			
			 System.out.println("modifier not found");
		}
	}
	}




	    @Test(priority=9)
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
			     if (guest.size()<=1)
			      {
				    System.out.println("This logic for only single guest");
			        driver.findElement(By.id("split_evently_layout")).click();
	    	        driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='2']")).click();
			        driver.findElement(By.id("doneClick")).click();    
			        List<WebElement> puff = driver.findElements(By.id("name"));
			    	System.out.println("Receipt count is==> " +puff.size());
			   
			    	for(WebElement we:puff)
			    	{
				    		   we.click();
				    		   driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
				    		   driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
				    	       String paymentamonut = driver.findElement(By.id("payment_value")).getText().substring(1);
				    	    
				    	      System.out.println("paymentamonut total is ==>" +paymentamonut);
				    	      
					          int spliteven = 3;
					    	  System.out.println("here 1"); 
					    	  System.out.println("paymentamonut total is ==>" +receipttotal);  
					    	  float evenguest = (receipttotal/spliteven);
					    	  System.out.println("here 2"); 
					    	  System.out.println("even total is ==>" +evenguest);
					    	  Float paymentamountwindow = Float.parseFloat(paymentamonut);
					    	  System.out.println("payment amount is ==>" +paymentamountwindow);
			         if(paymentamountwindow== evenguest)
			    	   {
			    		  System.out.println("here 4");
			    		   driver.findElement(By.id("delete_card")).click();
			    	       driver.findElement(By.id("button2")).click();
			    		   driver.findElement(By.id("cancel_dialog")).click();
			    	   }
			    	    else
			    	     {
			    		  System.out.println("Value not proper divide");  
			    	     }
			
			    	}
			    	
			     	driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();	
			    	driver.findElement(By.xpath(obj.getProperty("SingleReceipt"))).click();
			      }
			      else
			        {
					System.out.println("Spliting receipt for split per guest");
					driver.findElement(By.id(obj.getProperty("SplitPerGuest"))).click();
					System.out.println("splited");
			      }
			    }
			else
			  {
			   
			   System.out.println("Order amonut and receipt total does not match");
			  }
		     	    List<WebElement> puff = driver.findElements(By.id("name"));
					System.out.println("Receipt count is==> " +puff.size());
				  for(WebElement we:puff)
				   {
			     	we.click();
			 	   driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
	    		   driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
			       String payment = driver.findElement(By.xpath("//android.widget.TextView[@text='Payment']")).getText();
				    System.out.println("Window is " + payment);		
					driver.findElement(By.id("com.torenzo.torenzocafe:id/done_guest")).click();
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
				  System.out.println("In this class covered all split option with one guest DONE (Split1 class) ");
			}	
			
			}

	

