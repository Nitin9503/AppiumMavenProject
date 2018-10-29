package com.appium.torenzo.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestListener;
//@Listeners(ListenerTest.class)
public class Maintest1 {
public static AppiumDriver driver;

 @BeforeSuite
	 public void launchApp() throws MalformedURLException{
		   System.out.println("Appium launching started");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("appium-version", "1.5.3");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "6.0");
			capabilities.setCapability("deviceName", "Honor");
			//capabilities.setCapability("udid", "B3VNU17914100329");
			capabilities.setCapability("udid", "192.168.56.101:5555");
			capabilities.setCapability("appPackage", "com.torenzo.torenzocafe");
			//capabilities.setCapability("udid", "emulator-5554");
			capabilities.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");
			capabilities.setCapability("newCommandTimeout","100");
			//capabilities.setCapability("app", "Torenzo");
			//capabilities.setCapability("udid", "95bb78de2a63886aaa9542d51740dbda53ffc7ca");
			capabilities.setCapability("app", "/Users/rahul.kardel/Downloads/androidApk19july18/torenzo76.apk");
			// capabilities.setCapability("app", "/Users/rahul.kardel/Downloads/app-release(10july)75.apk");
	           driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	               driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	               System.out.println("Appium launch successfully");
	               
	           }
 @BeforeTest
	   public void login()
	       		{
	       		
	       		
	       		try{
	       			if(driver.findElement(By.xpath("//android.widget.TextView[@text='Torenzo Cafe']")).isDisplayed())
	       			{
	       			 driver.findElement(By.id("com.torenzo.torenzocafe:id/access_name")).sendKeys("torenzocafe");
	       				//driver.findElement(By.xpath("//android.widget.EditText[@text='admin4']")).sendKeys("torenzocafe");
	       				driver.findElement(By.id("com.torenzo.torenzocafe:id/submit_login")).click();
	       			    driver.findElement(By.id("com.torenzo.torenzocafe:id/clock_in")).click();
	       			    driver.findElement(By.id("com.torenzo.torenzocafe:id/role_name")).click();
	       			    System.out.println("on home page");
	       			}
	       			
	       			
	       		}
	       		catch(Exception e)
	       		{
	       			//driver.findElement(By.xpath("//android.widget.TextView[@text='View Sample Restaurant/Store (Demo Users)']")).click();
	       			driver.findElement(By.xpath("//android.widget.TextView[@text='Open Existing Restaurant/Store (Live Users)']")).click();
	       			
	       			driver.findElement(By.id("com.torenzo.torenzocafe:id/access_name")).sendKeys("torenzocafe");
	       			//driver.findElement(By.xpath("//android.widget.EditText[@text='admin4']")).sendKeys("torenzocafe");
	       	     	
	       			driver.findElement(By.id("com.torenzo.torenzocafe:id/submit_login")).click();
	       		    driver.findElement(By.id("com.torenzo.torenzocafe:id/clock_in")).click();
	       		    driver.findElement(By.id("com.torenzo.torenzocafe:id/role_name")).click();
	       		    System.out.println("on home page");
	       		}
	               
	               
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
	 
}


