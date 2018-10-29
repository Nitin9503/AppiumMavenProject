package TestNG;
import io.appium.java_client.TouchAction;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import static TestNG.StaticVariable.invoice_no1;
import static TestNG.StaticVariable.order_total;
import static TestNG.StaticVariable.order_no1;
import static TestNG.StaticVariable.date;
import static TestNG.StaticVariable.payment;
import static TestNG.StaticVariable.ordernofromreceipt;
import static TestNG.StaticVariable.payment_value;



public class Reusemethod extends Loginapp
{
/*	public Properties obj1 = new Properties();
	FileInputStream objfile= new FileInputStream(System.getProperty("user.dir")+"\\application.properties");*/
   public Reusemethod() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	/* public static String invoice_no1;
	public static String order_no1;
	public static String order_total;
	public static String date;*/
   

   
   public void Allitemwithoutmodifier() throws InterruptedException, IOException
	{
	   obj.load(objfile);
	   
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Order creation process is started with takeout");
	 
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
	    	        
	   order_no1=driver.findElement(By.id(obj.getProperty("OrderNo"))).getText();
		System.out.println("order_no1 in ordercreation is =>" + order_no1);
		driver.findElement(By.xpath(obj.getProperty("AllItems"))).click();
		Thread.sleep(5000);
		
			for (int i=2; i<9; i++)
			{
				Thread.sleep(5000);
				driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).click();
				try{
					System.out.println("searching for modifier ");
					if(driver.findElement(By.xpath(obj.getProperty("ModifierOnItem"))).isDisplayed())
					{
						System.out.println("Modifier displayed ");
						
						driver.findElement(By.id(obj.getProperty("DoneItemModifier"))).click();
								
							}
					
					
				}catch(Exception e)
				{
					System.out.println("Catch exception");
					
					}
						
					}
          }
	public void Allitem() throws IOException, InterruptedException
	{
		obj.load(objfile);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Order creation process is started with takeout");
		
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
		    	        
			order_no1=driver.findElement(By.id(obj.getProperty("OrderNo"))).getText();
			System.out.println("Order number is =>" + order_no1);
			driver.findElement(By.id(obj.getProperty("AddGuest"))).click();
			driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).click();
	     	driver.findElement(By.id(obj.getProperty("AddGuestDone"))).click();
			driver.findElement(By.xpath(obj.getProperty("AllItems"))).click();
			Thread.sleep(5000);
			for (int g=0; g<3; g++)
			{
				Thread.sleep(5000);
			driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index="+g+"]")).click();	
			
				for (int i=1; i<3; i++)
				{	Thread.sleep(500);
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
			order_total=driver.findElement(By.id(obj.getProperty("OrderTotalUpSide"))).getText().substring(1);
			 System.out.println("Order total on order page" +order_total);
			}
	
	
	public void Payment() throws IOException
	{
	obj.load(objfile);
	 
	        List<WebElement> guest = driver.findElements(By.id("guest_name"));
		            
		    System.out.println("Guest count is ==>" +guest.size());

		driver.findElement(By.id(obj.getProperty("OrderTotalUpSide"))).click();
		driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();	
		if (guest.size()<=1)
		{
			System.out.println("Spliting receipt for single guest only"); 
			driver.findElement(By.xpath(obj.getProperty("SingleReceipt"))).click();
		}
		else
		{
			System.out.println("Spliting receipt for split per guest");
			driver.findElement(By.id(obj.getProperty("SplitPerGuest"))).click();
			System.out.println("splited");
		}
		
		
   	List<WebElement> puff = driver.findElements(By.id("name"));
	System.out.println("Receipt count is==> " +puff.size());
	for(WebElement we:puff)
	 {
		 we.click();
         driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
         driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
         String payment = driver.findElement(By.xpath(obj.getProperty("Payment"))).getText();
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

	
	public void Payment1() throws IOException
	{
		// System.out.println("Used for Edit order");
		obj.load(objfile);
		List<WebElement> guest = driver.findElements(By.id(obj.getProperty("GuestName")));
        
	    System.out.println("Guest count is ==>" +guest.size());		
		driver.findElement(By.id(obj.getProperty("OrderTotalUpSide"))).click();
	
		driver.findElement(By.id(obj.getProperty("SplitReceipt"))).click();	
    	driver.findElement(By.xpath(obj.getProperty("SingleReceipt"))).click();
    	ordernofromreceipt = driver.findElement(By.id("order_id")).getText().substring(7);
		System.out.println("Order number is==> " +ordernofromreceipt);
		invoice_no1 = driver.findElement(By.id("invoice_no")).getText().substring(8);
		System.out.println("Invoice numeber is==> " +invoice_no1);
		date = driver.findElement(By.id("date")).getText();
		System.out.println("Date of receipt paid is==> " +date);
	   	List<WebElement> puff = driver.findElements(By.id("name"));
		System.out.println("Receipt count is==> " +puff.size());
		for(WebElement we:puff)
		 {
		 we.click();
         driver.findElement(By.xpath(obj.getProperty("PayBill"))).click();
         driver.findElement(By.id(obj.getProperty("AddPayment"))).click();
         payment_value = driver.findElement(By.id("payment_value")).getText().substring(1);
        payment = driver.findElement(By.xpath(obj.getProperty("Payment"))).getText();
	     System.out.println("Window is " + payment);		
		 driver.findElement(By.id("done_guest")).click();
		 driver.findElement(By.xpath(obj.getProperty("CloseTableWithoutReceipt"))).click();
		 System.out.println("Order is succefully created and paid");
		 driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']")).click();
		
		    	
		   }
	    }	
	
	public void swipadmin()
	{
		 {
			
		      double startPercentage=0.01; double finalPercentage=0.9; double anchorPercentage=0.5; int duration=200; 
		      Dimension size = driver.manage().window().getSize();
		      System.out.println("size of element" +size);
		      int anchor = (int) (size.height * anchorPercentage);
			  int startPoint = (int) (size.width * startPercentage);
			  int endPoint = (int) (size.width * finalPercentage);
			  new TouchAction(driver).press(startPoint, anchor).waitAction(Duration.ofMillis(duration)).moveTo(endPoint, anchor).release().perform();
			System.out.println("Swipe admin setting done");
			
	         }
	}
	
	public void scrollcashtab()
	{
		Dimension size = driver.findElement(By.id("cash_details_tab_recycler_view")).getSize();
		System.out.println("edit view size==>"+size);
		int starty = (int) (size.height*0.80);
		int endy = (int) (size.height*0.20);
		int startx = size.width/2;
		WebElement ele=(WebElement)driver.findElements(By.id("cash_details_tab_recycler_view")).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(starty, endy).release().perform();
		
		
	}
	public void editorderscroll()
	{
		System.out.println("Scrolling edit view");
		Dimension size = driver.findElement(By.id("edit_order_recycleview")).getSize();
		System.out.println("edit view size==>"+size);
		int starty = (int) (size.height*0.20);
		int endy = (int) (size.height*0.80);
		int startx = size.width/2;
		WebElement ele = (WebElement) driver.findElements(By.id("edit_order_recycleview")).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(startx, endy).release().perform();
		System.out.println("Scrolling edit view done");
		

	}
	public void scrollreport()
	{
		System.out.println("Scrolling reprot section for matching");
		Dimension size= driver.findElement(By.id("all_report_view")).getSize();
		int statry =  (int) (size.height*0.80);
		int endy = (int) (size.height*0.20);              
		int startx = size.width/2;
		WebElement ele=(WebElement) driver.findElements(By.id("all_report_view")).get(0);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele).moveTo(startx, endy).release().perform();
		
		
		
	}
	
	public void SwapAdmin()
	{
	      double startPercentage=0.01; double finalPercentage=0.9; double anchorPercentage=0.5; int duration=200; 
	      Dimension size = driver.manage().window().getSize();
	      System.out.println("size of element" +size);
	      int anchor = (int) (size.height * anchorPercentage);
		  int startPoint = (int) (size.width * startPercentage);
		  int endPoint = (int) (size.width * finalPercentage);
		  new TouchAction(driver).press(startPoint, anchor).waitAction(Duration.ofMillis(duration)).moveTo(endPoint, anchor).release().perform();
	}
	
	public void reportswap()
	{
		double startPercenatge =0.01; double finalPercentage =0.9; double anchorPercentage = 0.5; int duration = 200;
		Dimension size=driver.manage().window().getSize();
		int anchor = (int) (size.height*anchorPercentage);
		int startPoint = (int) (size.width*startPercenatge);
		int endPoint = (int) (size.width * finalPercentage);	
		TouchAction action = new TouchAction(driver);
		action.press(endPoint, anchor).waitAction(Duration.ofMillis(duration)).moveTo(startPoint, anchor).release().perform();
	}
			/* driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index='0']")).click();
		
            }
*/	
}
	

