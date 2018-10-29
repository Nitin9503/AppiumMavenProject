package TestNG;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
@Listeners(TestNG.Listener.class)
public class Takeout extends Loginapp {

	
   	public Takeout() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority=5)
	 public void Takeoutorder() throws IOException, InterruptedException
   	   {

   		        System.out.println("Order creation process is started with takeout secong time");
	     	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  
	     	   Ordercreate call = new Ordercreate();
    		    call.Allitem();
    		 
 	           for (int d=0; d<1;d++)
 	           {
	 	          Dimension size = driver.findElement(By.xpath("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index="+d+"]")).getSize();
	 	          System.out.println("size of element" +size);
	 	          System.out.println("swipe1");
	 	          int x1 = (int) (size.width * 0.10);
	 	          System.out.println("size of element1" +size.width);
	 	          int x2 = (int) (size.width * 0.10);
	 	          TouchAction action = new TouchAction(driver);
	 	          System.out.println("swipe2");
 	      
	 	           WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index="+d+"]"))).get(0);
	 	   
	 			  action.longPress(ele2).moveTo(x1,100).release().perform();
 	      
         
		 	      System.out.println("swipe3");
		 	      driver.findElement(By.xpath("//android.widget.TextView[@text='Delete']")).click();
		 	      System.out.println("swipe5");
		 	      String print = driver.findElement(By.id("alertTitle")).getText();
		 	      System.out.println("Title =>" +print);
		 	      driver.findElement(By.id("button1")).click(); 
		 	      driver.findElement(By.id("delete_modifier")).click();
		 	       driver.findElement(By.id("button2")).click(); 
		 	       
 	           }
	 	           System.out.println("delete operation happened succesfully"); 			
	     
	 	          System.out.println("Now going for payment"); 	   
	 	           Reusemethod pay = new Reusemethod();
	  			   pay.Payment();
	               System.out.println("Takeout class end here");	  
	              
             }
       }