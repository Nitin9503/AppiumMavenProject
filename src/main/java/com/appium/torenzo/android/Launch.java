package com.appium.torenzo.android;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Launch {

	
	
	
	
	
	
	 WebDriver driver = null;
	 
	 @BeforeMethod
	  public void openbrowser() throws IOException { 
	   //System.setProperty("webdriver.gecko.driver", "D:\\Selenium Files\\geckodriver.exe");
	   driver = new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");   
	  }
	 
	 @AfterMethod
	  public void closebrowser() {   
	   driver.quit();
	  }  
	 
	 @Test
	  public void Calc_Operations() throws IOException{
	  //Create Object of Properties Class.
	  Properties obj = new Properties();   
	  //Create Object of FileInputStream Class. Pass file path.
	  //FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\ObjectRepo\\objects.properties");
	  FileInputStream objfile = new FileInputStream(System.getProperty("  /Users/rahul.kardel/Documents/Sachin/Appiumstart/src/com/appium/torenzo/android/parameter.properties"));
	
	  //Pass object reference objfile to load method of Properties object.
	  obj.load(objfile); 
	  
	  //Sum operation on calculator.
	  //Accessing element locators of all web elements using obj.getProperty(key)
	  driver.findElement(By.id(obj.getProperty("eight"))).click();
	  driver.findElement(By.id(obj.getProperty("plus"))).click();
	  driver.findElement(By.id(obj.getProperty("four"))).click();
	  driver.findElement(By.id(obj.getProperty("equalsto"))).click();
	  String i = driver.findElement(By.id(obj.getProperty("result"))).getAttribute("value");
	  System.out.println(obj.getProperty("eight")+" + "+obj.getProperty("four")+" = "+i); 
	  driver.findElement(By.id(obj.getProperty("result"))).clear();
	  
	  //Subtraction operation on calculator.
	  //Accessing element locators of all web elements using obj.getProperty(key)
	  driver.findElement(By.id(obj.getProperty("nine"))).click();
	  driver.findElement(By.id(obj.getProperty("minus"))).click();
	  driver.findElement(By.id(obj.getProperty("three"))).click();
	  driver.findElement(By.id(obj.getProperty("equalsto"))).click();
	  String j = driver.findElement(By.id(obj.getProperty("result"))).getAttribute("value");
	  System.out.println(obj.getProperty("nine")+" - "+obj.getProperty("three")+" = "+j);
	  }
	}