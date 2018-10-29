
package TestNG;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;


@Listeners(TestNG.Listener.class)
public class Ordercreate extends Loginapp{

	public Ordercreate() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority=3)
	public void Allitem() throws IOException, InterruptedException{
		 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Order creation process is started with takeout");
	     obj.load(objfile);
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
			Thread.sleep(500);
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
		}
			

		@Test(priority=4)
		public void Payment() throws IOException
		{
			 Reusemethod pay = new Reusemethod();
			 pay.Payment();
		
			System.out.println("Ordercreate class end here");
			
		}
	       	}
	


	