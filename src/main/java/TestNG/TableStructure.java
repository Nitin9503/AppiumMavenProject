
package TestNG;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

@Listeners(TestNG.Listener.class)
public class TableStructure extends Loginapp{
		
	public TableStructure() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Test(priority=2)
		public void orderwithtable() throws IOException
		{
		
			  obj.load(objfile);
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  Reusemethod call = new Reusemethod();	
    	try{
	    	 if(driver.findElement(By.id(obj.getProperty("TableStructureIcon"))).isDisplayed())
			 {
			  System.out.println("Reloading table structure");
		
		     call.SwapAdmin();
			 driver.findElement(By.id(obj.getProperty("AdminSettings"))).click();
		     driver.findElement(By.id(obj.getProperty("ReloadTables"))).click();
	         }
				 
	      }catch (Exception e)
		  {
			    System.out.println("verifying table strucuture");
			    call.SwapAdmin();
			    driver.findElement(By.id(obj.getProperty("AdminSettings"))).click();
		        driver.findElement(By.id(obj.getProperty("TableviewDisplay"))).click();
		        driver.findElement(By.id(obj.getProperty("ReloadTables"))).click();
	      }
		
	     System.out.println("selecting table");
	     for (int t=22; t<=40;t++)
	       {
	    	   System.out.println("value of t is" +t);
	           System.out.println("increment ");   	 
		       driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();      
		        try{
			           if(driver.findElement(By.xpath(obj.getProperty("TableOptions"))).isDisplayed())
			                 {
			        	            System.out.println(" Busy "); 
			                      	driver.pressKeyCode(AndroidKeyCode.BACK);
				
			                  }
		            }catch(Exception e)
		
	                  	{
		            	      if(driver.findElement(By.id(obj.getProperty("CancelGuestbyPhoneNumber"))).isDisplayed())
			                     {
			                      	System.out.println("table is free and adding guest");
		                          	driver.findElement(By.id("add_guest_three")).click();
			                         driver.findElement(By.id(obj.getProperty("DoneEmployeeList"))).click();
			                         break;	
		                         }
				
	 	
	                  	}
		        t++;
		             }
	          
		       }

		
	@Test(priority=3)
	 public void Addguest() throws IOException
	 {
		obj.load(objfile);
		System.out.println("selecting guest and adding item to them");
		driver.findElement(By.xpath(obj.getProperty("AllItems"))).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for (int g=0; g<3; g++)
		{
			driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index="+g+"]")).click();				
			for (int i=1; i<3; i++)
			{
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
      	
			@Test(priority=4)
			 public void paymentorder() throws IOException
			 {
			 Reusemethod pay = new Reusemethod();
			 pay.Payment();
			System.out.println("Table structure class end here");
		
	 }
  }	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
