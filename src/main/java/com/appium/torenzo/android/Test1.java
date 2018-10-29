package com.appium.torenzo.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.TestListener;
//@Listeners(ListenerTest.class)
public class Test1 extends Maintest1{
	@Test(priority=1)
	public void orderCreationWithlimiteditem() throws Exception{
		 
		 {
			// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]")).click();
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
						
					//	scrollUpOnItemList();
						i=i-3;
						System.out.println("the Reduced index value of item is i= "+i);
							}
				}
					}}
					catch(Exception e)
					{
						//scrollUpOnGuestlist();
						//g=g-1;
						System.out.println("the Reduced index value of guest is g= "+g);
						
				}
			 		
						
					}
			/*		
				   WebElement OrderNo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no"));
			// Order_No=OrderNo.getText();
			 System.out.println(Order_No);
			 WebElement OrderTo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/total_order"));
			// Order_To=OrderTo.getText();
			 System.out.println(Order_To);
			  System.out.println(Order_To.replaceFirst(".$",""));
*/
			} 
		 	
		  
	 }
	 
}
