package com.appium.torenzo.android;

import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Practice {
	 Dimension size;
	 public static AppiumDriver driver;
	 public void launchApp() throws MalformedURLException{
		   System.out.println("Appium launching started");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("appium-version", "1.5.3");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "6.0");
			capabilities.setCapability("deviceName", "Honor");
    capabilities.setCapability("udid", "192.168.56.101:5555");
			capabilities.setCapability("appPackage", "com.torenzo.torenzocafe");
			
			capabilities.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");
		
		     capabilities.setCapability("app", "/Users/rahul.kardel/Downloads/app-release 75.apk");
	           driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	               driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	               public void login()
	       	
	          {
	       		try{
	       			if(driver.findElement(By.xpath("//android.widget.TextView[@text='torenzocafe']")).isDisplayed())
	       			{
	       				driver.findElement(By.id("com.torenzo.torenzocafe:id/submit_login")).click();
	       			    driver.findElement(By.id("com.torenzo.torenzocafe:id/clock_in")).click();
	       			    driver.findElement(By.id("com.torenzo.torenzocafe:id/role_name")).click();
	       			    System.out.println("on home page");
	       			}
	       			
	       			
	       		}catch(Exception e)
	       		{
	       			driver.findElement(By.xpath("//android.widget.TextView[@text='Open Existing Restaurant/Store (Live Users)']")).click();
	       	
	       	     	driver.findElement(By.id("com.torenzo.torenzocafe:id/submit_login")).click();
	       		    driver.findElement(By.id("com.torenzo.torenzocafe:id/clock_in")).click();
	       		    driver.findElement(By.id("com.torenzo.torenzocafe:id/role_name")).click();
	       		    System.out.println("on home page");
	       		}                
	               // driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
	                 
	                 System.out.println("on home page"); 
	                 try{
	                     if (driver.findElement(By.xpath("//android.widget.Button[@text='Allow']")).isDisplayed())
	                     {
	                     driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	                      driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	                      System.out.println("Permission popup is displayed");
	                     }
	                     }catch (Exception e){
	                     
	                       System.out.println("Permission popup is not displayed");
	                      }
	 }
	
	 public void VerifyTableviewIcon() throws InterruptedException{
		 try{
				if(driver.findElement(By.id("table_structure_img")).isDisplayed())
				 {
				  System.out.println("Reloading table");
			      double startPercentage=0.01; double finalPercentage=0.9; double anchorPercentage=0.5; int duration=200; 
			      org.openqa.selenium.Dimension size = driver.manage().window().getSize();
			      int anchor = (int) (size.height * anchorPercentage);
				  int startPoint = (int) (size.width * startPercentage);
				  int endPoint = (int) (size.width * finalPercentage);
				  new TouchAction(driver).press(startPoint, anchor).waitAction().moveTo(endPoint, anchor).release().perform();
				  driver.findElement(By.id("admin_settings")).click();
				  driver.findElement(By.id("reload_tables")).click();
		   }
					 
		   }catch (Exception e)
			  {
			System.out.println("verifying table strucuture");
		    double startPercentage=0.01; double finalPercentage=0.9; double anchorPercentage=0.5; int duration=200; 
		    org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		    int anchor = (int) (size.height * anchorPercentage);
		    int startPoint = (int) (size.width * startPercentage);
		    int endPoint = (int) (size.width * finalPercentage);
		    new TouchAction(driver).press(startPoint, anchor).waitAction().moveTo(endPoint, anchor).release().perform();
	        driver.findElement(By.id("admin_settings")).click();
	    	System.out.println("verifying table strucuture 2");
		    driver.findElement(By.id("tableview_display")).click();
		    driver.findElement(By.id("back_arrow_layout")).click();

		    // driver.findElement(By.id("reload_tables")).click();
		    Thread.sleep(2000);
		      }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public void orderCreate(){
	
			driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]")).click();
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Take-Out']")).click();

		// driver.findElement(By.id("com.torenzo.torenzocafe:id/new_order_type_name")).click();
		 
		 driver.findElement(By.xpath("//android.widget.TextView[@text='All Items']")).click();

		//driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index=1]")).click();
		for(int i=1; i<2; i++){
		    System.out.println("The value of i is: "+i);
		    driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).click();

		    
		   boolean present;
		    try{
		    	driver.findElement(By.xpath("com.torenzo.torenzocafe:id/cancel_modifier_dialog"));
		       present = true;
		    } catch (NoSuchElementException e) {
		       present = false;
		    }
		   if(present){
			   driver.findElement(By.id("com.torenzo.torenzocafe:id/modifier_type")).click();
			   driver.findElement(By.id("com.torenzo.torenzocafe:id/done_item_modifier")).click();
			  	 /* for(int k=1; k<4;k++){
			            Driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[4]/UIATableCell[1]/UIACollectionView[1]/UIACollectionCell["+k+"]/UIAStaticText[1] ")).click();
			           	Driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[27]")).click();
		 
			  	  }
			  	  */}
		  
		   }
		
	 }
	 public void addQuantity() throws InterruptedException{
		 
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/ordered_item_name")).click(); 
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/quantity_text")).click();
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_five")).click();
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_done")).click();
		 System.out.println("item qauntity get added ");
		 Thread.sleep(2000);
	   }
	 
		 public void EditModifiers(){
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/ordered_item_name")).click(); 
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/modifier")).click();
		 System.out.println("Custom modifier will be adding");
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/custom_modifier_add")).sendKeys("Onion");
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/custom_modifier_count")).sendKeys("5");
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_custom_modifier_btn")).click();
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/done_item_modifier")).click();
	  }
		 
		 public void itemDiscounts(){
			 //Discount in Amount
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/ordered_item_name")).click(); 
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Discount']")).click();
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/reason")).sendKeys("Friend");
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/amount")).sendKeys("10");
			 System.out.println("Discount will get added in amount");
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/apply")).click();
			 
			 //Discount in percentage
		     driver.findElement(By.id("com.torenzo.torenzocafe:id/reason")).sendKeys("Relative");
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/amount")).sendKeys("5");
			 System.out.println("Discount will get added in percentage");
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/percent_flag")).click();
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/apply")).click();
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/done_discount")).click(); 
		 } 
		 public void loadOrder(){
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/order_list_layout")).click();
			// driver.findElement(By.id("com.torenzo.torenzocafe:id/search_order_byid")).sendKeys("");  
			 driver.findElement(By.xpath("//android.widget.TextView [@text='23-Jun-2018 03:40:24']")).click();
		 }
		 public void logout(){
			
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/user_details")).click();
			 try{
				 if(driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).isDisplayed())
			 
			 {
					 driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();	 
			 }
				 }
			catch(Exception e){
				//scrollUpOnUserDetailslist()
				 driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
			}
		
		 
		 }
		public void orderCreationWithlimiteditem(){
			 
			 {
				 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]")).click();
				try{
				if(driver.findElement(By.xpath("//com.torenzo.torenzocafe:id/cancel_new_order_select']")).isDisplayed())
					
				{
					 driver.findElement(By.xpath("//android.widget.TextView[@text='Take-Out']")).click();
					}
						
				}
				catch(Exception e){
					System.out.println("currently table view option button is disable");
				}
				 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[3]/android.widget.ImageView[1]")).click();
				driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_one")).click();
				 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_done")).click();
				 driver.findElement(By.xpath("//android.widget.TextView[@text='All Items']")).click();
				System.out.println("selecting guest and adding item to them");
				
				for (int g=0; g<2; g++)
				{
					try{
						System.out.println("The guest is searching which ia having index values is g="+g);
						if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index="+g+"]")).isDisplayed())
						{
					driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index="+g+"]")).click();	
					System.out.println("The guest get selected whose index value is g= "+g);
					Thread.sleep(1000);
					
					for (int i=1; i<3; i++)
					{
						try{
							if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).isDisplayed())
							{
						driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'grid_menu_layout') and @index="+i+"]")).click();
						System.out.println(i);
						
						
						try {
							System.out.println("searching for modifier ");
							if(driver.findElement(By.xpath("//android.widget.TextView[@text='Apply Modifiers']")).isDisplayed())
							{
								System.out.println("Modifier displayed ");
								try{
									if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).isDisplayed())
									{
										System.out.println("clicking on modifier ");
										driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='0']")).click();
										driver.findElement(By.id("done_item_modifier")).click();
										
									}
								     }catch(Exception e)
								       {
								    	 System.out.println("Modifier is not present on modifier window hence entering custom modifier");
								    	 WebElement custom = driver.findElement(By.id("custom_modifier_add"));
										custom.sendKeys("Spicy");
										WebElement count = driver.findElement(By.id("custom_modifier_count"));
										count.sendKeys("2");
										driver.findElement(By.id("add_custom_modifier_btn")).click();
										custom.sendKeys("Extra Spicy");
										count.sendKeys("3");
										driver.findElement(By.id("add_custom_modifier_btn")).click();
										driver.findElement(By.id("done_item_modifier")).click();
										
									}
							 }
							
						}catch(Exception e)
						   {
							
							System.out.println("Catch exception");
							
							}
							
							
							}
						}catch(Exception e){
							System.out.println("searched element not present on window  ");
							System.out.println("scroll up on item started");
							
							//scrollUpOnItemList();
							i=i-3;
							System.out.println("the Reduced index value of item is i= "+i);
								}
					}
						}}
						catch(Exception e)
						{
							//  scrollUpOnGuestlist();
							//g=g-1;
							System.out.println("the Reduced index value of guest is g= "+g);
							
					}
				 		
							
						}
						
					   WebElement OrderNo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no"));
				/* Order_No=OrderNo.getText();
				 System.out.println(Order_No);
				 WebElement OrderTo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/total_order"));
				 Order_To=OrderTo.getText();
				 System.out.println(Order_To);
				  System.out.println(Order_To.replaceFirst(".$",""));
*/
				} 
			 	
			  
		 }
		 //android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]
	 public static void main(String[] args) throws IOException, InterruptedException {
		
				Desktop d = Desktop.getDesktop();
				File f = new File("/usr/bin/open -a/Applications/Utilities/Terminal.app");
				try {
					d.open(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
		 
			
		 Practice pa= new Practice();
	pa.launchApp();
	//pa.VerifyTableviewIcon();
	pa.orderCreate();
	pa.loadOrder();
	//pa. addQuantity();
	//pa.EditModifiers();
	//pa.itemDiscounts();
	 }
}