package com.appium.torenzo.android;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import static com.appium.torenzo.android.StaticVariable.Order_No;
import static com.appium.torenzo.android.StaticVariable.Order_To;
import static com.appium.torenzo.android.StaticVariable.guestname;
import static com.appium.torenzo.android.StaticVariable.partysize;
import static com.appium.torenzo.android.StaticVariable.invoice_no;
import static com.appium.torenzo.android.StaticVariable.invoice_noNckot;
import static com.appium.torenzo.android.StaticVariable.invoice_tillCash;
import static com.appium.torenzo.android.StaticVariable.Amount;
import static com.appium.torenzo.android.StaticVariable.Discount;
import static com.appium.torenzo.android.StaticVariable.OrderNo;
import static com.appium.torenzo.android.StaticVariable.invoice_tillNCKOT;
import static com.appium.torenzo.android.StaticVariable.DiscountR;
import static com.appium.torenzo.android.StaticVariable.b;
import static com.appium.torenzo.android.StaticVariable.ReserTime;
import static com.appium.torenzo.android.StaticVariable.total_amount;
import static com.appium.torenzo.android.Constants.Live_User;
import static com.appium.torenzo.android.Constants.submit_login;
import static com.appium.torenzo.android.Constants.add_guest_done;
import static com.appium.torenzo.android.StaticVariable.diff_amount;
import static com.appium.torenzo.android.StaticVariable.table_name;
import static com.appium.torenzo.android.StaticVariable.table_No;
import static com.appium.torenzo.android.StaticVariable.order_summary_qty;
import static com.appium.torenzo.android.StaticVariable.ID;
import static com.appium.torenzo.android.StaticVariable.OrderID;
import static com.appium.torenzo.android.StaticVariable.customername;
import static com.appium.torenzo.android.StaticVariable.customername1;
import static com.appium.torenzo.android.StaticVariable.screenshotName2;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import junit.framework.TestListener;
@Listeners(Listener.class)
public class Generalfunctions
{
	
	
	public Generalfunctions() throws IOException{
		super();
		
	}
	public  Properties p = new Properties();
	 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//example.properties");
	
	public static AndroidDriver driver;
	 Dimension size;
	
/*	public String Order_No;
	public String Order_To;
	public String guestname;
	public String partysize;
	public int b;
	public String invoice_no;
	//public String invoice_noNckot;
	public String invoice_tillCash; 
	public String Amount ;
	public String Discount;
	public String OrderNo;
	public String invoice_tillNCKOT ;
	public String DiscountR;
	public String total_amount;
*/
	
	
	@BeforeSuite 
	 public void launchApp() throws IOException, InterruptedException{
		  
		Process p = Runtime.getRuntime().exec("/usr/bin/open -a Terminal[$ ./Documents]");

			//Thread.sleep(4000);
		
		
	   
			System.out.println("Appium launching started");
		 DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("appium-version", "1.5.3");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "6.0");
			caps.setCapability("deviceName", "Honor");
			//capabilities.setCapability("udid", "B3VNU17914100329");
			caps.setCapability("udid", "192.168.56.101:5555");
			caps.setCapability("appPackage", "com.torenzo.torenzocafe");
			//capabilities.setCapability("udid", "emulator-5554");
			caps.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");
			//capabilities.setCapability("newCommandTimeout","100");
			//capabilities.setCapability("app", "Torenzo");
			//capabilities.setCapability("udid", "95bb78de2a63886aaa9542d51740dbda53ffc7ca");
			//caps.setCapability("app", "/Users/rahul.kardel/Downloads/app-release229.apk");
	           driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	               driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	               System.out.println("Appium launch successfully");
	               
	           }
	 @BeforeTest
	public void login() throws IOException
	       	{
		
		// p.load(fis);
		//  p.getProperty("sam");
		//  System.out.println(p.getProperty("sam"));
		 
		
		
		
		
	       		try{
	       			if(driver.findElement(By.xpath("//android.widget.TextView[@text='Torenzo Cafe']")).isDisplayed())
	       			  {
	       			//driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Access Name']")).sendKeys("admin4");
	       			 System.out.println("passing login credentials");
	       				//driver.findElement(By.id("com.torenzo.torenzocafe:id/access_name")).sendKeys("admin4");
	       			   // driver.findElement(By.id("com.torenzo.torenzocafe:id/access_code")).sendKeys("1234");
	                    driver.findElement(By.id(submit_login)).click();
	       			    driver.findElement(By.id("com.torenzo.torenzocafe:id/clock_in")).click();
	       			    driver.findElement(By.id("com.torenzo.torenzocafe:id/role_name")).click();
	       			   
	       			  }
	       			
	       			
	       		}
	       		catch(Exception e)
	       		{
	       		
	       		 
	       			//driver.findElement(By.xpath("//android.widget.TextView[@text='View Sample Restaurant/Store (Demo Users)']")).click();
	       			driver.findElement(By.xpath("//android.widget.TextView[@text='Open Existing Restaurant/Store (Live Users)']")).click();
	       			//driver.findElement(By.id("com.torenzo.torenzocafe:id/access_name")).sendKeys("torenzocafe");
	       			System.out.println("passing login credentials");
	       			//driver.findElement(By.id("com.torenzo.torenzocafe:id/access_name")).sendKeys("torenzocafe");
       			   // driver.findElement(By.id("com.torenzo.torenzocafe:id/access_code")).sendKeys("1234");
	       		/*    System.out.println("here1");
      		      WebElement element = driver.findElement(By.id("com.torenzo.torenzocafe:id/access_code"));

	       		    System.out.println("here2");
      	   		 TouchAction touchAction = new TouchAction(driver);
      	   		 element.click();
      	   	element.sendKeys(Keys.BACK_SPACE);
     

      		    System.out.println("here3");
      		 

      		    System.out.println("here4");
	    //   	driver.findElement(By.id("com.torenzo.torenzocafe:id/access_code")).sendKeys("1234");*/
	       	     	driver.findElement(By.id(submit_login)).click();
	       		    driver.findElement(By.id("com.torenzo.torenzocafe:id/clock_in")).click();
	       		   // driver.findElement(By.id("com.torenzo.torenzocafe:id/role_name")).click();
	       		 driver.findElement(By.xpath("//android.widget.TextView[@text='Cashier']")).click();
	       		    System.out.println("on home page");
	       		}
	               
	               
	             
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
			      Dimension size = driver.manage().window().getSize();
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
		        Dimension size = driver.manage().window().getSize();
		       	int anchor = (int) (size.height * anchorPercentage);
		       	int startPoint = (int) (size.width * startPercentage);
		       	int endPoint = (int) (size.width * finalPercentage);
		       	new TouchAction(driver).press(startPoint, anchor).waitAction().moveTo(endPoint, anchor).release().perform();
		       	driver.findElement(By.id("admin_settings")).click();
		       	System.out.println("verifying table strucuture 2");
		       	driver.findElement(By.id("tableview_display")).click();
		       	driver.findElement(By.id("reload_tables")).click();
		       	Thread.sleep(2000);
		      }
	 }
         
	 public void navigatToNckot() throws InterruptedException{
		 
		
				System.out.println("navigate to Nckot section");
				double startPercentage=0.01; double finalPercentage=0.9; double anchorPercentage=0.5; int duration=200; 
				Dimension size = driver.manage().window().getSize();
				int anchor = (int) (size.height * anchorPercentage);
				int startPoint = (int) (size.width * startPercentage);
				int endPoint = (int) (size.width * finalPercentage);
				new TouchAction(driver).press(startPoint, anchor).waitAction().moveTo(endPoint, anchor).release().perform();
				driver.findElement(By.id("com.torenzo.torenzocafe:id/nonkot_order")).click();
				// driver.findElement(By.id("admin_settings")).click();
				System.out.println("verifying nckot");
		  
		   
		      }
	 
	 public void verifyReservation(String customername1) throws InterruptedException{
		 
       	 	driver.findElement(By.id("table_guest_list")).click(); 
       	
       	 	//verify add new reservation tab with blank data showing error message or not
       	 	System.out.println("verify add new reservation tab with blank data showing error message or not");
       	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/add_reservation_btn")).click(); 
       	 
       	 	driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")).click();
       	 	System.out.println("It shown error message so verified add new reservation tab successfully");
		
       	 	//typing customer name here
       	 	Thread.sleep(3000);
       	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_party_name")).sendKeys(customername1);
       	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_add_customer")).click(); 
		 
       	 	//entering party size here
       	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/new_tbl_party_size")).click(); 
       	 	System.out.println("entering party size");
       	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_three")).click(); 
       	 	driver.findElement(By.id(add_guest_done)).click(); 
       	 	partysize =driver.findElement(By.id("com.torenzo.torenzocafe:id/new_tbl_party_size")).getText();
       	 	System.out.println(partysize);
       	 	//selecting table below code
       	 		 System.out.println("specify Table");
      	 	driver.findElement(By.id("com.torenzo.torenzocafe:id/specify_tbl")).click(); 
      		System.out.println("selecting table");
       	for (int t=1; t<=40;t++)
         	{
   	            driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();      
   	            try{
   		             if(driver.findElement(By.xpath("//android.widget.TextView[@text='Table options']")).isDisplayed())
   		                 {

   		            	 driver.navigate().back();		
   		                  }
   	            }catch(Exception e)
   	
                   	{
   	            	   
   		                      	System.out.println("Table specified successfully");
   	                          	
   		                         break;	
   	                         }
   	            t++;
   				}
       //selecting date here
       driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_select_resv_date")).click(); 
       
       //driver.findElement(By.id("android:id/next")).click();
       WebElement st= driver.findElement(By.id("android:id/date_picker_header_date"));
       System.out.println(st.getText());
      String date=st.getText().substring(9);
      int d=Integer.parseInt(date);
     // d=d+3;
      System.out.println(d);
       
     	 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.ViewAnimator[1]/android.view.ViewGroup[1]/com.android.internal.widget.ViewPager[1]/android.view.View[1]/android.view.View["+d+"]")).click();
     	 driver.findElement(By.id("android:id/button1")).click(); 
     	 
     	 //selecting time here
     	 driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_select_resv_time")).click(); 
     	 WebElement time= driver.findElement(By.id("android:id/hours"));
     	 String hours=time.getText();
     	 System.out.println(hours);
     	String hour=time.getText().substring(0, 1);
     	 System.out.println(hour);
     	 int t=Integer.parseInt(hour);
     	 System.out.println(t);
     	 t=t+2;
     	 System.out.println(t);
     	 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.RadialTimePickerView.RadialPickerTouchHelper["+t+"]")).click();
     	 
     	 driver.findElement(By.id("android:id/button1")).click(); 
     	 ReserTime = driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_select_resv_time")).getText(); 
     	 System.out.println(ReserTime); 
     	 DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			Date date1 = new Date();
			System.out.println(dateFormat.format(date1));
			
       
       //	driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[2]")).click();
     	
    	 
    	 //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[1]")).sendKeys("9564648258");
    	
		 //entering contact no here
       driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_contact_no")).sendKeys("9876584341");
    	// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[2]")).sendKeys("David@gmail.com");
    		
      //entering Email address here
       /*  driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_email")).sendKeys("David@gmail.com");
	 
	      //selecting tags
	       driver.findElement(By.id("com.torenzo.torenzocafe:id/tag_btn_name")).click(); 
	
    	    System.out.println("Tags are adding started");
    	    for(int k=1;k<4;k++)
	        {  
		
    		 driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]")).click(); 
	
	             }
    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_done")).click(); 
    		 System.out.println("Tags got added successfully");
    		 
    		
    		
    		 driver.findElement(By.xpath("//android.widget.TextView[@text='+ Add Allergy']")).click();
    		 System.out.println("adding allergies started");
    		 for(int j=1;j<4;j++)
    		     {  
    			
    	    		 driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]")).click(); 
    		
    		          }
    	    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_done")).click(); 
    	    		 System.out.println("Allergies got added successfully");
    		 
    		 //Giving visits note here
    		driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_visit_notes")).sendKeys("I am very happy with your service and food taste is also good");
    	*/
    		//Tap onAdd reservation tab
    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_reservation_btn")).click();  
         }
	
	 
	 public void verifyWaiting(String customername1) throws InterruptedException{
		 //driver.findElement(By.id("table_structure_img")).click();
		 System.out.println("tapping on torenzo reserve tab");
		 driver.findElement(By.id("table_guest_list")).click(); 
		 System.out.println("tapping on waiting section tab");
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/waiting_btn")).click(); 
		
		/*//verify add new reservation tab with blank data showing error message or not
       	 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_waiting_btn")).click(); 
       	 driver.findElement(By.id("android:id/button1")).click(); 
		 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")).click();
	*/
		
	  //typing customer name here
		 Thread.sleep(3000);
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_wait_party_name")).sendKeys(customername1);
		 
		 guestname = driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_wait_party_name")).getText();
		 System.out.println(guestname);
    	 driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_add_wait_customer")).click(); 
		 
		 //entering party size here
    	 driver.findElement(By.id("com.torenzo.torenzocafe:id/new_wait_party_size")).click(); 
   		 System.out.println("entering party size");
   		 Thread.sleep(3000);
   		System.out.println("verifying table strucuture3");
   		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_four")).click(); 
   		 	System.out.println("verifying table strucuture4");
   		 driver.findElement(By.id(add_guest_done)).click(); 
   		System.out.println("verifying table strucuture5");
   		Thread.sleep(2000);
       partysize =driver.findElement(By.id("com.torenzo.torenzocafe:id/new_wait_party_size")).getText();
       System.out.println(partysize);
    	 
    	 //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[1]")).sendKeys("9564648258");
    	
		 //entering contact no here
       driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_wait_contact_no")).sendKeys("8876584341");
    	// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[2]")).sendKeys("David@gmail.com");
    		
       //entering Email address here
       driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_wait_email")).sendKeys("Navin@gmail.com");
	 
	 //selecting tags
    	 driver.findElement(By.id("com.torenzo.torenzocafe:id/tag_btn_name")).click(); 
	
    	 System.out.println("Tags are adding started");
    	 for(int t=1;t<4;t++)
	     {  
		
    		 driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+t+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]")).click(); 
	
	       }
    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_done")).click(); 
    		 System.out.println("Tags got added successfully");
    		 driver.findElement(By.xpath("//android.widget.TextView[@text='+ Add Allergy']")).click();
    		 System.out.println("adding allergies started");
    		
    		 for(int j=1;j<4;j++)
    		     {  
    			
    	    		 driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]")).click(); 
    		
    		          }
    	    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_done")).click(); 
    	    		 System.out.println("Allergies got added successfully");
    		 //Giving visits note here
    		 //driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_wait_visit_notes")).sendKeys(" hiii I am very happy with your service and food taste is also good");
    		
    		//Tap onAdd reservation tab
    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_waiting_btn")).click();  
    		 
    		 
	 }
	public void updateWaiting(String customername3) throws InterruptedException
	  {
		 System.out.println("opening waiting list");
		      driver.findElement(By.id("com.torenzo.torenzocafe:id/waiting_btn")).click(); 
		      System.out.println("Tags are adding started");
		      driver.findElement(By.xpath("//android.widget.TextView[@text='"+customername3+"']")).click();
		//driver.findElement(By.id("com.torenzo.torenzocafe:id/guest_name")).click();
		
		 WebElement element=driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_wait_party_name"));
		 element.click();
		 element.sendKeys(Keys.CONTROL + "a");
		 element.sendKeys(Keys.DELETE);
		 
		  //typing customer name here
			 Thread.sleep(3000);
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_wait_party_name")).sendKeys("Amar");
			 //driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_wait_party_name"))).setValue("7");
	    	 driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_add_wait_customer")).click(); 
			 
			 //entering party size here
	    	 driver.findElement(By.id("com.torenzo.torenzocafe:id/new_wait_party_size")).click(); 
	   		 System.out.println("entering party size");
	   		 Thread.sleep(3000);
	   		System.out.println("verifying table strucuture3");
	   		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_five")).click(); 
	   		 driver.findElement(By.id(add_guest_done)).click(); 
	   		System.out.println("verifying table strucuture4");
	      
	       
	    	 
	    	 //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[1]")).sendKeys("9564648258");
	    	
			 //entering contact no here
	       driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_wait_contact_no")).sendKeys("8876584341");
	    	// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[2]")).sendKeys("David@gmail.com");
	    		
	       //entering Email address here
	       driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_wait_email")).sendKeys("Navin@gmail.com");
		 
		 //selecting tags
	    	 driver.findElement(By.id("com.torenzo.torenzocafe:id/tag_btn_name")).click(); 
		
	    	 System.out.println("Tags are adding started");
	    	 for(int t=1;t<4;t++)
		     {  
			
	    		 driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+t+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]")).click(); 
		
		       }
	    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_done")).click(); 
	    		 System.out.println("Tags got added successfully");
	    		 System.out.println("adding allergies started");
	    		 for(int j=1;j<4;j++)
    		     {  
    			
    	    		 driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]")).click(); 
    		
    		          }
    	    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_done")).click(); 
    	    		 System.out.println("Allergies got added successfully");
	    		 //Giving visits note here
	    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_wait_visit_notes")).sendKeys(" hiii I am very happy with your service and food taste is also good");
	    		
	    		//Tap onAdd waiting tab
	    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_waiting_btn")).click();  
	}
		 
	 
	  
	//driver.findElement(By.id("com.torenzo.torenzocafe:id/seated_btn")).click();

	 
	 public void updateReservation(String customername, String customername1) throws InterruptedException{
		 System.out.println("1");
		 //driver.findElement(By.id("table_guest_list")).click(); 
		 
		 System.out.println("2");
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/reservation_btn")).click();
		 System.out.println("3");
		 Thread.sleep(2000);
	//driver.findElement(By.id("com.torenzo.torenzocafe:id/guest_name")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@text='"+customername+"']")).click();
	System.out.println("4");
	
   //typing customer name here
	// Thread.sleep(3000);
	/* WebElement element=driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_party_name"));
	 element.click();
	 element.sendKeys(Keys.CONTROL + "a");
	 element.sendKeys(Keys.DELETE);
	 */

	
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_party_name")).click();
	 System.out.println("4");
	driver.findElement(By.xpath("//android.widget.TextView[@text='Delete']")).click();
	System.out.println("5");
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_party_name")).sendKeys(customername1);
	 System.out.println("26");
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_add_customer")).click(); 
	 
	 //entering party size here
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/new_tbl_party_size")).click(); 
		 System.out.println("entering party size");
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).click(); 
		 driver.findElement(By.id(add_guest_done)).click(); 
		
  //selecting table below code
	 System.out.println("specify Table");
  driver.findElement(By.id("com.torenzo.torenzocafe:id/specify_tbl")).click(); 
 
 	 
 	 System.out.println("selecting table");
  for (int t=41; t>=1; t--)
    	{
	            driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();      
	            try{
		             if(driver.findElement(By.xpath("//android.widget.TextView[@text='Table options']")).isDisplayed())
		                 {

		            	 driver.navigate().back();		
		                  }
	            }catch(Exception e)
	           {
	            	   System.out.println("Table specified successfully");
	                          	 break;	
	                         }
	                 t--;
				}
  //selecting date here
  driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_select_resv_date")).click(); 
 
  //driver.findElement(By.id("android:id/next")).click();
  WebElement st= driver.findElement(By.id("android:id/date_picker_header_date"));
 String date=st.getText().substring(9, 10);
 int d=Integer.parseInt(date);
 d=d+1;
 System.out.println(d);
  
	 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.ViewAnimator[1]/android.view.ViewGroup[1]/com.android.internal.widget.ViewPager[1]/android.view.View[1]/android.view.View["+d+"]")).click();
	 driver.findElement(By.id("android:id/button1")).click(); 
	 
	 //selecting time here
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/btn_select_resv_time")).click(); 
	 WebElement time= driver.findElement(By.id("android:id/hours"));
	 String hour=time.getText().substring(0, 1);
	 System.out.println(hour);
	 int t=Integer.parseInt(hour);
	 System.out.println(t);
	 t=t+1;
	 System.out.println(t);
	 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.RadialTimePickerView.RadialPickerTouchHelper["+t+"]")).click();
	 
	 driver.findElement(By.id("android:id/button1")).click(); 
  //	driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[2]")).click();
	
	 
	 //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[1]")).sendKeys("9564648258");
	
	 //entering contact no here
  driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_contact_no")).sendKeys("876584341");
	// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[2]")).sendKeys("David@gmail.com");
		
  //entering Email address here
  driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_email")).sendKeys("samay@gmail.com");

//selecting tags
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/tag_btn_name")).click(); 

	 System.out.println("Tags are adding started");
	 for(int p=1;p<6;p++)
{  
	
		 driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+p+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]")).click(); 

}
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_done")).click(); 
		 System.out.println("Tags got added successfully");
		 
		 System.out.println("adding allergies started");
		 for(int j=1;j<5;j++)
		     {  
			
	    		 driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]")).click(); 
		
		          }
	    		 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_done")).click(); 
	    		 System.out.println("Allergies got added successfully");

		 //Giving visits note here
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_visit_notes")).sendKeys("I am very happy with your service and food taste is also good");
		
		//Tap onAdd reservation tab
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_reservation_btn")).click();  
    }
	
	 
	 
	 
	 public void ReservationDelete() throws InterruptedException{
	 driver.findElement(By.id("table_guest_list")).click(); 
		 
		 System.out.println("7");
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/reservation_btn")).click();
		 System.out.println("8");
		   Dimension size = driver.findElement(By.xpath("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index='0']")).getSize();
	          System.out.println("size of element" +size);
	          System.out.println("swipe1");
	          int x1 = (int) (size.width * 0.20);
	          
	          int x2 = (int) (size.width * 0.80);
	          TouchAction action = new TouchAction(driver);
	          System.out.println("swipe2");
	    
	      WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index='0']"))).get(0);
	      System.out.println("value" +ele2);
	      action.longPress(ele2).moveTo(x1,360).release().perform();	   
	      System.out.println("swipe4");
	  	driver.findElement(By.xpath("//android.widget.TextView[@text='Delete']")).click();
		 Thread.sleep(2000);
	 }   
	 public void SwipeTotransfertable() throws InterruptedException{
		// driver.findElement(By.id("com.torenzo.torenzocafe:id/reservation_btn")).click();
		 System.out.println("swiping on element started");
		 b--;
		   Dimension size = driver.findElement(By.xpath("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index='"+b+"']")).getSize();
	          System.out.println("size of element" +size);
	          System.out.println("swipe1");
	          int x1 = (int) (size.width * 0.20);
	          
	          int x2 = (int) (size.width * 0.80);
	          TouchAction action = new TouchAction(driver);
	          System.out.println("swipe2");
	    
	      WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index='"+b+"']"))).get(0);
	      System.out.println("value" +ele2);
	      action.longPress(ele2).moveTo(x1,860).release().perform();	   
	      System.out.println("swipe4");
	  	//driver.findElement(By.xpath("//android.widget.TextView[@text='Delete']")).click();
		// Thread.sleep(2000); 
	      try{
	    	  if(driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).isDisplayed())
	    	  { 
	    		  driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
	    		  }
	      }
	      catch(Exception e){
	    	  driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
	      }
		 
         System.out.println("click on transfer table button1");
       //  System.out.println("specify table verifying");
    	// driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
  //   System.out.println("click on transfer table button1");
     
    	 for (int t=9; t<=42;t++)
      	   {
    		  System.out.println("veriying for loop");
	            driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();  
	          System.out.println("select table with index id = "+t);
	         try{
	             if(driver.findElement(By.xpath("//android.widget.TextView[@text='Table options']")).isDisplayed())
	                 {

	            	 driver.navigate().back();		
	                  }
          }catch(Exception e)

          	{
          	      if(driver.findElement(By.id("cancel_guestby_phone_number")).isDisplayed())
	                     {
	                      	System.out.println("catch");
                        	driver.findElement(By.id("add_guest_three")).click();
	                        driver.findElement(By.id("done_employee_list")).click();
	                         break;	
                       }
	            }
	         }
    	 }
	 public void ReserTransferTable() throws Exception{
		
     // driver.findElement(By.id("table_guest_list")).click(); 
      System.out.println("click on table guest list icon");
	  driver.findElement(By.id("com.torenzo.torenzocafe:id/reservation_btn")).click();
	  System.out.println("click on Reservation button");
	 //driver.findElement(By.id("com.torenzo.torenzocafe:id/search_reservation")).sendKeys(customername1); 
	  for(b=1; b<13; b++){
		  try{
			  System.out.println(b);
			if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]")).isDisplayed())//android.widget.LinearLayout[1]/android.widget.LinearLayout[1]
             {
				String gsize=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
		      System.out.println(gsize);
		      String gname=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
			  System.out.println(gname);
			  System.out.println(customername1 +" " +gname +"  " +partysize+" " +gsize);
			 try{
				 System.out.println("check and compare customername and partysize");
			    if(customername1.equalsIgnoreCase(gname)&&(partysize.equalsIgnoreCase(gsize)))
			       {System.out.println("Current guest name and party size are equals ");
			       b--;
		        Dimension size = driver.findElement(By.xpath("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index='"+b+"']")).getSize();
	            System.out.println("size of element" +size);
	            int x1 = (int) (size.width * 0.20);
	            int x2 = (int) (size.width * 0.80);
	            TouchAction action = new TouchAction(driver);
	            System.out.println("swipe2");
			    WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index='"+b+"']"))).get(0);
	            System.out.println("value" +ele2);
	            b=b+1;
	            switch(b){
	            case 1:
	    	     if(b == 1){
	    		  System.out.println("the vue of b is getting="+b );
	    		  action.longPress(ele2).moveTo(x1,360).release().perform();
	    	       }
	    	       break;
	             case 2:
	         	  if(b == 2){
	    	 	   System.out.println("the vue of b is getting="+b );
	    		   action.longPress(ele2).moveTo(x1,520).release().perform();
	    	       }
	          	   break;
	             case 3:
	    	      if(b == 3){
	    		   System.out.println("the vue of b is getting="+b );
	    		   action.longPress(ele2).moveTo(x1,680).release().perform();
	    	       }
	    	       break;
	             case 4:
	    	      if(b == 4){
	    		  System.out.println("the vue of b is getting="+b );
	    		  action.longPress(ele2).moveTo(x1,840).release().perform();
	    	      }
	    	       break;
	             case 5:
	    	      if(b == 5){
	    		  System.out.println("the vue of b is getting="+b );
	    		  action.longPress(ele2).moveTo(x1,1000).release().perform();
	    	      }
	    	      break;
	             case 6:
	    	      if(b == 6){
	    		   System.out.println("the vue of b is getting="+b );
	    		   action.longPress(ele2).moveTo(x1,1160).release().perform();
	    	       }
	    	      break;
	             case 7:
	    	      if(b == 7){
	    		  System.out.println("the vue of b is getting="+b );
	    		  action.longPress(ele2).moveTo(x1,1320).release().perform();
	    	      }
	    	      break;
	            case 8:
	    	      if(b == 8){
	    		  System.out.println("the vue of b is getting="+b );
	    		  action.longPress(ele2).moveTo(x1,1480).release().perform();
	    	      }
	    	      break;
	            case 9:
	    	      if(b == 9){
	    		  System.out.println("the vue of b is getting="+b );
	    		  action.longPress(ele2).moveTo(x1,1640).release().perform();
	    	      }
	    	      break;
	            case 10:
	    	      if(b == 1){  System.out.println("the vue of b is getting="+b );
	    		  action.longPress(ele2).moveTo(x1,1800).release().perform();
	    	       }
	    	       break;
	            case 11:
	    	      if(b == 11){
	    		  System.out.println("the vue of b is getting="+b );
	    		  action.longPress(ele2).moveTo(x1,1960).release().perform();
	    	      }
	    	      break;
	            case 12:
	    	      if(b == 12){
	    		  System.out.println("the vue of b is getting="+b );
	    		  action.longPress(ele2).moveTo(x1,2120).release().perform();
	    	      }
	    	      break;
	             default:
	    	     System.out.println("the value of b not exist");
	    	     }
	             // action.longPress(ele2).moveTo(x1,360).release().perform();	   
	            System.out.println("swipe4");
	            break;
			       }
			     } 
			   catch(Exception e){
		       System.out.println("party size and customername not match");
				    }
			     }  
			  }
			   catch(Exception e){
			   System.out.println("searched cell not found so scrollup on reservation list");
			   b=b-3;
			   if(b>0)
			    {b--;
				}
			   else
				{
				System.out.println("value of b= 0");
				}
				System.out.println("reduced value of "+b);
				scrollUpOnResevationList();
					           }
				System.out.println("party size and customername not match");
			}	
	                                               //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
		    //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
		    String st= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
		    // String st= driver.findElement(By.id("com.torenzo.torenzocafe:id/table_name")).getText();
	        System.out.println(st);
	        if(st.equalsIgnoreCase("Specify Table"))
	             {
	                System.out.println("specify table verifying");
	            	driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
	            	System.out.println("click on transfer table button1");
	            	System.out.println("specify table verifying");
	             
	            	//driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
	            	// System.out.println("click on transfer table button1");
             
	            		for (int t=39; t<=47;t++)
	            		{
            		      System.out.println("veriying for loop");
            		      	try{
            		      		driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();  
            		      		System.out.println("select table with index id = "+t);
            		        }catch(Exception e){
            		      		t=t-t+1;
            		      		driver.findElement(By.id("com.torenzo.torenzocafe:id/floor_select_btn")).click();
            		      		driver.findElement(By.xpath("//android.widget.TextView[@text='Floor2']")).click();
		                        driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();  
            			                        }
  		                    try{
  		                    	System.out.println("it enter into try block");
  		                    	if(driver.findElement(By.xpath("//android.widget.TextView[@text='Table options']")).isDisplayed())
  		                    	{
  		                    	 driver.navigate().back();		
  		                        }
  		                    }catch(Exception e)
  	                      	 	{
  	            	        /* if(driver.findElement(By.id("cancel_guestby_phone_number")).isDisplayed())
  	            	         		{
  		                      		System.out.println("catch");
  		                      		driver.findElement(By.id("add_guest_three")).click();
  		                      		driver.findElement(By.id("done_employee_list")).click();
  		                      	
  	                             	}*/
  		              	break;	
  	                      	 	}
  		                    t=t+1;
	                  }
	            	
	          }    
	             else
                     {
                    System.out.println("tap on transfer table2");
        	        driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
        	        System.out.println("click on transfer table successfully");
                     }      
        }   
	 public void waitingTransfertable() throws Exception{
		  //driver.findElement(By.id("table_guest_list")).click(); 
		  System.out.println("waiting transfer to table started "); 
		  driver.findElement(By.id("com.torenzo.torenzocafe:id/waiting_btn")).click(); 
		  System.out.println("taping on waiting tab to show waiting list "); 
		  //driver.findElement(By.id("com.torenzo.torenzocafe:id/search_waiting")).sendKeys(customername1);
		  System.out.println("Searching by guastname"); 
		  for(b=1; b<13; b++)
			{
			try{
				System.out.println(b);
				if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]")).isDisplayed())//android.widget.LinearLayout[1]/android.widget.LinearLayout[1]
                  { String gsize=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
		            System.out.println(gsize);
		            String gname=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
				    System.out.println(gname);
				    try{
				    	  System.out.println(customername1 +" " +gname +"  " +partysize+" " +gsize);
				        System.out.println("check and compare game");
			            if(customername1.equalsIgnoreCase(gname)&&(gsize.equalsIgnoreCase(partysize)))
			              {System.out.println("Current guest name and party size are equals ");
						   System.out.println("swiping on element started");
						   b--;
						   Dimension size = driver.findElement(By.xpath("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index='"+b+"']")).getSize();
						   System.out.println("size of element" +size);
						   System.out.println("swipe1");
						   int x1 = (int) (size.width * 0.20);
						   int x2 = (int) (size.width * 0.80);
						   TouchAction action = new TouchAction(driver);
						   System.out.println("swipe2");
						   WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.view.ViewGroup[contains(@resource-id,'swipe_layout') and @index='"+b+"']"))).get(0);
						   System.out.println("value" +ele2);
						   b=b+1;
						   switch(b){
						   case 1:
						     if(b == 1){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,360).release().perform();
						    	       }
						    	  break;
						    case 2:
						      if(b == 2){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,520).release().perform();
						    	         }
						    	  break;
						    case 3:
						      if(b == 3){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,680).release().perform();
						    	         }
						    	  break;
						    case 4:
						      if(b == 4){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,840).release().perform();
						    	        }
						    	  break;
						    case 5:
						      if(b == 5){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,1000).release().perform();
						    	         }
						    	  break;
						    case 6:
						      if(b == 6){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,1160).release().perform();
						    	        }
						    	  break;
						    case 7:
						      if(b == 7){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,1320).release().perform();
						    	         }
						    	  break;
						    case 8:
						      if(b == 8){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,1480).release().perform();
						    	        }
						    	  break;
						    case 9:
						      if(b == 9){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,1640).release().perform();
						    	        }
						    	  break;
						    case 10:
						      if(b == 1){  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,1800).release().perform();
						    	        }
						    	  break;
						    case 11:
						      if(b == 11){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,1960).release().perform();
						    	  }
						    	  break;
						    case 12:
						      if(b == 12){
						    		  System.out.println("the vue of b is getting="+b );
						    		  action.longPress(ele2).moveTo(x1,2120).release().perform();
						    	          }
						    	  break;
						     default:
						    	  System.out.println("the value of b not exist");
						    	   }
						     System.out.println("swipe4");
						      break;
			                  }
			                
				      }catch(Exception e){
				    	System.out.println("customername and party size not match");
				                          }
				   }
			      }catch(Exception e){
					System.out.println("searched waiting cell not present");
					b=b-3;
					if(b>0)
					{
						b--;
					}
					else
					{
						//System.out.println("value of b= 0");
					}
					System.out.println("reduced value of "+b);
					scrollUpOnWaitingList();
					
			      }
				
				}
		   System.out.println("the value of b is equal to "+b);
		   //driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();

		   String st= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
		   System.out.println(st);
	       System.out.println("The value st as shown as  "+st);
	       if(st.equalsIgnoreCase("Transfer To Table"))
	             {
	       	 System.out.println(b);
			  // driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
			   driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();

	                System.out.println("specify table verifying");
	            	//driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup["+b+"]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
	            	System.out.println("click on transfer table button1");
	            	System.out.println("specify table verifying");
	            	//driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")).click();
	            	//driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
	            	// System.out.println("click on transfer table button1");
          
	            		for (int t=1; t<=47;t++)
	            		{
         		      System.out.println("veriying for loop");
         		      	try{
         		      		driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();  
         		      		System.out.println("select table with index id = "+t);
         		        }catch(Exception e){
         		      		t=t-t+1;
         		      		driver.findElement(By.id("com.torenzo.torenzocafe:id/floor_select_btn")).click();
         		      		driver.findElement(By.xpath("//android.widget.TextView[@text='Floor2']")).click();
		                        driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();  
         			                        }
		                    try{
		                    	System.out.println("it enter into try block");
		                    	if(driver.findElement(By.xpath("//android.widget.TextView[@text='Table options']")).isDisplayed())
		                    	{
		                    	 driver.navigate().back();		
		                        }
		                    }catch(Exception e)
	                      	 	{
	            	             break;	
	                      	 	}
		                    t=t+1;
	                  }
	            	
	          }    
	             else
                  {
                 System.out.println("tap on transfer table2");
     	        driver.findElement(By.xpath("//android.widget.TextView[@text='Transfer To Table']")).click();
     	        System.out.println("click on transfer table successfully");
                  }      
		      	   }
	 public void SelectTable(){
		 for (int t=1; t<=4;t++)
    	   {
  		  System.out.println("veriying for loop");
  		  try{
            driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();  
          System.out.println("select table with index id = "+t);
  		  }
  		  catch(Exception e){
  			  t=t-t+1;
  			  	driver.findElement(By.id("com.torenzo.torenzocafe:id/floor_select_btn")).click();
                      driver.findElement(By.xpath("//android.widget.TextView[@text='Floor2']")).click();
                      driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();  
  			  
  		  }
            try{
             if(driver.findElement(By.xpath("//android.widget.TextView[@text='Table options']")).isDisplayed())
                 {

            	 driver.navigate().back();		
                  }
        }catch(Exception e)
                  	{
        	         if(driver.findElement(By.id("cancel_guestby_phone_number")).isDisplayed())
                         {
                      	System.out.println("catch");
                      	driver.findElement(By.id("add_guest_three")).click();
                        driver.findElement(By.id("done_employee_list")).click();
                         break;	
                         }
		            }
            }
	 }
	 public void addguestforDineIn() throws Exception
	 {
			
		 driver.findElement(By.xpath("//android.widget.TextView[@text='All Items']")).click();
		System.out.println("selecting guest and adding item to them");
		table_No = driver.findElement(By.id("com.torenzo.torenzocafe:id/table_name")).getText();
		for (int g=0; g<3; g++)
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
				if (g==1)
				{
		           i=i+2;
				
				}
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
					
					scrollUpOnItemList();
					i=i-3;
					System.out.println("the Reduced index value of item is i= "+i);
						}
			}
				}}
				catch(Exception e)
				{
					scrollUpOnGuestlist();
					//g=g-1;
					System.out.println("the Reduced index value of guest is g= "+g);
					
			}
		 		
					
				}
				
			   WebElement OrderNo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no"));
		 Order_No=OrderNo.getText();
		 System.out.println(Order_No);
		 WebElement OrderTo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/total_order"));
		 Order_To=OrderTo.getText();
		 System.out.println(Order_To);
		  System.out.println(Order_To.replaceFirst(".$",""));
		  order_summary_qty = driver.findElement(By.id("com.torenzo.torenzocafe:id/order_summary_qty")).getText().substring(1);
		 
			
	 }
	 public void OrderCreationforTakeOut() throws Exception
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
			driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_four")).click();
			 driver.findElement(By.id(add_guest_done)).click();
		 driver.findElement(By.xpath("//android.widget.TextView[@text='All Items']")).click();
		System.out.println("selecting guest and adding item to them");
		
		for (int g=0; g<5; g++)
		{
			try{
				System.out.println("The guest is searching which ia having index values is g="+g);
				if(driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index="+g+"]")).isDisplayed())
				{
			driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index="+g+"]")).click();	
			System.out.println("The guest get selected whose index value is g= "+g);
			Thread.sleep(1000);
			
			for (int i=2; i<3; i++)
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
					
					scrollUpOnItemList();
					i=i-3;
					System.out.println("the Reduced index value of item is i= "+i);
						}
			}
				}}
				catch(Exception e)
				{
					scrollUpOnGuestlist();
					//g=g-1;
					System.out.println("the Reduced index value of guest is g= "+g);
					
			}
		 		
					
				}
				
			   WebElement OrderNo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no"));
		 Order_No=OrderNo.getText();
		 System.out.println(Order_No);
		 WebElement OrderTo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/total_order"));
		 Order_To=OrderTo.getText();
		 System.out.println(Order_To);
		  System.out.println(Order_To.replaceFirst(".$",""));
	 order_summary_qty = driver.findElement(By.id("com.torenzo.torenzocafe:id/order_summary_qty")).getText().substring(1);
		  
		} 
	 public void orderCreationWithlimiteditem() throws Exception{
		 
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
			 driver.findElement(By.id(add_guest_done)).click();
			 driver.findElement(By.xpath(p.getProperty("All_Item"))).click();
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
				
				for (int i=4; i<5; i++)
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
						
						scrollUpOnItemList();
						i=i-3;
						System.out.println("the Reduced index value of item is i= "+i);
							}
				}
					}}
					catch(Exception e)
					{
						scrollUpOnGuestlist();
						//g=g-1;
						System.out.println("the Reduced index value of guest is g= "+g);
						
				}
			 		
						
					}
					
			 WebElement OrderNo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no"));
			 Order_No=OrderNo.getText();
			 System.out.println(Order_No);
			 WebElement OrderTo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/total_order"));
			 Order_To=OrderTo.getText();
			 System.out.println(Order_To);
			 System.out.println(Order_To.replaceFirst(".$",""));
			 order_summary_qty = driver.findElement(By.id("com.torenzo.torenzocafe:id/order_summary_qty")).getText().substring(1);
			} 
		driver.findElement(By.id("com.torenzo.torenzocafe:id/menu_img_grid")).click();	         
		 
		// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.ImageView[1]")).click(); 
		 //driver.findElement(By.id("com.torenzo.torenzocafe:id/combine")).click();	
	 }
	 
	 public void loadOrder(String Type) throws Exception{
		 //android.widget.TextView  
		/*  DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			Date date1 = new Date();
			
			//Date date = new Date();
			//String startDate= new SimpleDateFormat("dd-MMM-yyyy").format(date);
			
			System.out.println(date1);
			*/
		 DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/order_list_layout")).click();
		 try{
			 if(driver.findElement(By.id("com.torenzo.torenzocafe:id/transaction_typetext_two")).isDisplayed()){
				 driver.findElement(By.id("com.torenzo.torenzocafe:id/transaction_typetext_"+Type+"")).click();
			 }
		 }
			 catch(Exception e){
				 System.out.println("it shown only Takeout type order");
			 }
		 
		
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/search_order_byid")).sendKeys(Order_No);  
		 Thread.sleep(2000);
		 //scrollUp();
		// driver.findElement(By.xpath("//android.widget.TextView [@text='23-Jun-2018 03:40:24']")).click();
	for(int a=1; a<10; a++)
	{
		try
		  {
			System.out.println(a);
			if(driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout["+a+"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).isDisplayed())
			  {
				
	
		        String CurDate=driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout["+a+"]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText().substring(0, 11);
                  System.out.println(CurDate);
                  // System.out.println(CurDate.substring(0, 11));
		        String Amount=driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout["+a+"]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
		      System.out.println(Amount);
		    try{
	              if((Order_To.replaceFirst(".$","")).equalsIgnoreCase(Amount)&&(CurDate.equals(dateFormat.format(date))))
			                         //if((CurDate.equals(date1))&(Order_To).equalsIgnoreCase(Amount))
			                         //android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
		           {
				    System.out.println("Current date is equal ");
		 		    //android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
		            driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout["+a+"]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).click();
		
		             if(driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no")).isDisplayed()){
				     System.out.println("order get load successfully");
	               
				     break;
				     }
		           
	         }
		  }
	catch(Exception e){
		
		//if(driver.findElement(By.id("com.torenzo.torenzocafe:id/order_no")).isDisplayed()){`
			//break;
		          //     }
	         }
	
	           }
		}
		catch(Exception e){
			System.out.println("Date and time not match");
			
			a=a-3;
			if(a>1)
			{
				a--;
			}
			else
			{
				System.out.println("value of a=1");
			}
			System.out.println("reduced value of "+a);
			scrollUpOnOrderList();
			
			               }
		
		}
	 }
	 ////@Test
	 public void logout() throws Exception{
			
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/user_details")).click();
		 try{
			 if(driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).isDisplayed())
		 
		 {
				 driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();	 
		 }
			 }
		catch(Exception e){
			scrollUpOnUserDetailslist();
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
		}
	
	 
	 }
	 public void scrollUpOnOrderList() throws Exception {
		// Get the size of screen.
		//Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'orders_list_recycler_view') and @index='0']")).getSize();
			Dimension size = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]")).getSize();
			System.out.println(size);
		// Find swipe start and end point from screen’s width and height.
		// Find start y point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);
	    
		// Find end y point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width/2;
System.out.println(starty);
System.out.println(endy);
System.out.println(startx);
			// Swipe from Bottom to Top.

//WebElement ele2 = (WebElement) driver.findElements(By.xpath(("android.support.v7.widget.RecyclerView[contains(@resource-id,'orders_list_recycler_view') and @index='0']"))).get(0);
WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]"))).get(0);

System.out.println("value" +ele2);
TouchAction action = new TouchAction(driver);
action.longPress(ele2).moveTo(startx,starty).release().perform();	   
			//driver.swipe(startx, starty, startx, endy, 3000);
			Thread.sleep(2000);
		}
	 public void scrollUpOnItemList() throws Exception {
			// Get the size of screen.
			Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'menus_grid_recycler_view') and @index='1']")).getSize();
			
			System.out.println(size);
			// Find swipe start and end point from screen’s width and height.
			// Find start y point which is at bottom side of screen.
			int starty = (int) (size.height * 0.80);
		    
			// Find end y point which is at top side of screen.
			int endy = (int) (size.height * 0.20);
			// Find horizontal point where you wants to swipe. It is in middle of
			// screen width.
			int startx = size.width/2;
	System.out.println(starty);
	System.out.println(endy);
	System.out.println(startx);
				// Swipe from Bottom to Top.

	WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'menus_grid_recycler_view') and @index='1']"))).get(0);
	System.out.println("value" +ele2);
	TouchAction action = new TouchAction(driver);
	action.longPress(ele2).moveTo(startx,endy).release().perform();	   
				//driver.swipe(startx, starty, startx, endy, 3000);
				Thread.sleep(2000);
			}
	 public void scrollUpOnGuestlist() throws Exception {
			// Get the size of screen.
			Dimension size = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]")).getSize();
			
			System.out.println(size);
			// Find swipe start and end point from screen’s width and height.
			// Find start y point which is at bottom side of screen.
			int starty = (int) (size.height * 0.80);
		    
			// Find end y point which is at top side of screen.
			int endy = (int) (size.height * 0.20);
			// Find horizontal point where you wants to swipe. It is in middle of
			// screen width.
			int startx = size.width/2;
	System.out.println(starty);
	System.out.println(endy);
	System.out.println(startx);
				// Swipe from Bottom to Top.

	WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]"))).get(0);
	System.out.println("value" +ele2);
	TouchAction action = new TouchAction(driver);
	action.longPress(ele2).moveTo(startx,endy).release().perform();	   
				//driver.swipe(startx, starty, startx, endy, 3000);
				Thread.sleep(2000);
			}
	 //@Test
	 public void scrollUpOnUserDetailslist() throws Exception {
			// Get the size of screen.
			Dimension size = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]")).getSize();
			
			System.out.println(size);
			// Find swipe start and end point from screen’s width and height.
			// Find start y point which is at bottom side of screen.
			int starty = (int) (size.height * 0.80);
		    
			// Find end y point which is at top side of screen.
			int endy = (int) (size.height * 0.20);
			// Find horizontal point where you wants to swipe. It is in middle of
			// screen width.
			int startx = size.width/2;
	System.out.println(starty);
	System.out.println(endy);
	System.out.println(startx);
				// Swipe from Bottom to Top.

	WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]"))).get(0);
	System.out.println("value" +ele2);
	TouchAction action = new TouchAction(driver);
	action.longPress(ele2).moveTo(startx,endy).release().perform();	   
				//driver.swipe(startx, starty, startx, endy, 3000);
				Thread.sleep(2000);
			}
	 public void scrollUpOnWaitingList() throws Exception {
			// Get the size of screen.
			Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'waiting_recycler_view') and @index='0']")).getSize();
			
			System.out.println(size);
			// Find swipe start and end point from screen’s width and height.
			// Find start y point which is at bottom side of screen.
			int starty = (int) (size.height * 0.80);
		    
			// Find end y point which is at top side of screen.
			int endy = (int) (size.height * 0.20);
			// Find horizontal point where you wants to swipe. It is in middle of
			// screen width.
			int startx = size.width/2;
	System.out.println(starty);
	System.out.println(endy);
	System.out.println(startx);
				// Swipe from Bottom to Top.

	WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'waiting_recycler_view') and @index='0']"))).get(0);
	System.out.println("value" +ele2);
	TouchAction action = new TouchAction(driver);
	action.longPress(ele2).moveTo(startx,endy).release().perform();	   
				//driver.swipe(startx, starty, startx, endy, 3000);
				Thread.sleep(2000);
			}
	 public void scrollUpOnResevationList() throws Exception {
			// Get the size of screen.
			Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'reservation_recycler_view') and @index='0']")).getSize();
			
			System.out.println(size);
			// Find swipe start and end point from screen’s width and height.
			// Find start y point which is at bottom side of screen.
			int starty = (int) (size.height * 0.80);
		    
			// Find end y point which is at top side of screen.
			int endy = (int) (size.height * 0.20);
			// Find horizontal point where you wants to swipe. It is in middle of
			// screen width.
			int startx = size.width/2;
	System.out.println(starty);
	System.out.println(endy);
	System.out.println(startx);
				// Swipe from Bottom to Top.

	WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'reservation_recycler_view') and @index='0']"))).get(0);
	System.out.println("value" +ele2);
	TouchAction action = new TouchAction(driver);
	action.longPress(ele2).moveTo(startx,endy).release().perform();	   
				//driver.swipe(startx, starty, startx, endy, 3000);
				Thread.sleep(2000);
			}
 public void addQuantity() throws InterruptedException{
		 
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/ordered_item_name")).click(); 
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/quantity_text")).click();
		 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_five")).click();
		 driver.findElement(By.id(add_guest_done)).click();
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
			 WebElement OrderTo =  driver.findElement(By.id("com.torenzo.torenzocafe:id/total_order"));
			 Order_To=OrderTo.getText();
			 
		 } 
		 public void Reorder(){
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/ordered_item_name")).click(); 
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/reorder")).click();
		 }
		 public void paymentsplitReceipt(){
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/order_total_upside")).click();
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/split_receipt")).click();
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/split_equally_for_all")).click();
			/* for(int i=1; i<6; i++)
			 {
				 try{
					 System.out.println("value of i is"+i);
					*/ 
			 for(int j=1; j<5; j++)
					   {
						    try
						     {
						    	System.out.println("value of j is = "+j);
						    	if(j>3){
						    		System.out.println("The value of j is greater than 3 i.e = "+j);
						    		ScrollOnReceipt(); 
						    		j--;
						    		System.out.println(" reduce value of j is = "+j);
						    	}
							 if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[“+j+”]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]")).isDisplayed());
							     {                           //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]
							    	                         //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]
							    	 System.out.println(" verifying receipt with paid icon value of j is = "+j);
								 ScrollOnReceipt(); 
								 j--;
								 System.out.println("after scrolling the reduce value of j is = "+j);
							      }
						      }
					 catch(Exception e)
					
					 { 
						 
						 
					 if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout["+j+"]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")).isDisplayed());
                          {
						 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout["+j+"]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")).click();
						
						 System.out.println("select receipt with value of j is = "+j);
						 driver.findElement(By.id("com.torenzo.torenzocafe:id/paybill")).click();
						 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_payment")).click();
						 driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
						
						 
						 try{
							 if(driver.findElement(By.xpath("//android.widget.Button[@text='Continue without closing table']")).isDisplayed())
							    { 
								 driver.findElement(By.xpath("//android.widget.Button[@text='Continue without closing table']")).click();
							     }
							 }
                          
						 catch(Exception a){
						 driver.findElement(By.xpath("//android.widget.Button[@text='Close table without']")).click();
						                   }
	                     }
				    }
		         }
			 
	       }//first try closed here
                  /*        catch(Exception e){
                        	  
                        	  
                        	  ScrollOnReceipt();
                        	 i=i-2;
                        	  System.out.println("Reduced value of i is "+i);
                                      }
					 }
				   
		

		 } */
		 public void payWithCash() throws InterruptedException{
			//driver.findElement(By.id("com.torenzo.torenzocafe:id/order_total_upside")).click();
				invoice_no= driver.findElement(By.id("com.torenzo.torenzocafe:id/invoice_no")).getText().substring(8);
				System.out.println(invoice_no);
				driver.findElement(By.id("com.torenzo.torenzocafe:id/discount_popUp")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='10%(Amount)']")).click();
				DiscountR=driver.findElement(By.id("com.torenzo.torenzocafe:id/discount_value")).getText();
				driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")).click();
				driver.findElement(By.id("com.torenzo.torenzocafe:id/paybill")).click();
				total_amount= driver.findElement(By.id("com.torenzo.torenzocafe:id/total_amount")).getText();
				driver.findElement(By.id("com.torenzo.torenzocafe:id/add_payment")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
				driver.findElement(By.xpath("//android.widget.Button[@text='Close table without receipt']")).click();
				Thread.sleep(5000);
		 }
		 
		 public void verifyNckot() throws InterruptedException{
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/order_total_upside")).click();
			invoice_no= driver.findElement(By.id("com.torenzo.torenzocafe:id/invoice_no")).getText().substring(8, 27);
			System.out.println(invoice_no);
			 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")).click();
			
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/paybill")).click();
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Non Chargeable KOT']")).click();
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/add_payment")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
			driver.findElement(By.xpath("//android.widget.Button[@text='Close table without receipt']")).click();
			Thread.sleep(5000);

			System.out.println("navigate to Nckot section");
		    double startPercentage=0.01; double finalPercentage=0.9; double anchorPercentage=0.5; int duration=200; 
		    Dimension size = driver.manage().window().getSize();
		    int anchor = (int) (size.height * anchorPercentage);
		    int startPoint = (int) (size.width * startPercentage);
		    int endPoint = (int) (size.width * finalPercentage);
		    new TouchAction(driver).press(startPoint, anchor).waitAction().moveTo(endPoint, anchor).release().perform();
		    driver.findElement(By.id("com.torenzo.torenzocafe:id/nonkot_order")).click();
		   // driver.findElement(By.id("admin_settings")).click();
	    	System.out.println("verifying nckot");
	    	   driver.findElement(By.id("com.torenzo.torenzocafe:id/search")).click();
	    
			Thread.sleep(2000);
			
			 for(int j=1; j<13; j++)
			   {
				 System.out.println("verifying loop for cell of j is ="+j);	 
				    try
				     {
				    	 System.out.println("j is ="+j);	 
			 if(driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).isDisplayed())
			 {
				 invoice_noNckot=driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
				  System.out.println(" invoice no from receipt before payment is"+invoice_noNckot);	 
			   try{
				 if(invoice_noNckot.equalsIgnoreCase(invoice_no)){
					 driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+j+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
						driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
					 break;
				                               }
			   }catch(Exception e){
					System.out.println("invoice numbers not match");
				    }
			      }
			    }
			   catch(Exception e){
				 j=j-7;
				   if(j>0)
				   {
					   j--;
				   }
				   System.out.println("scroll up on Nckot list started");
				   scrollOnNckotlist();
			      }
			   }
			 
			}
		 public void rejctNckot(){
			 driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'transaction') and @index='0']")).click();	
			 driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[5]/android.widget.Button[1]")).click(); 
			 driver.findElement(By.xpath("//android.widget.Button[@text='Ok']")).click();
		 }
		 public void accepttNckot() throws InterruptedException{
			 driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'transaction') and @index='0']")).click();	
			// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.Button[1]")).click();
			// driver.findElement(By.id("com.torenzo.torenzocafe:id/Accept Order")).click();	
			 driver.findElement(By.xpath("//android.widget.Button[@text='Ok']")).click();
			 
			
			 //tap on nckot tab in till management
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/user_details")).click();		
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_till_mgmt")).click();	
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_gift_card_details_tab")).click();

			 for(int l=1; l<13; l++)
			    {
				 System.out.println("verifying loop for cell of j is ="+l);	 
				    try
				     {
				    	 System.out.println("j is ="+l);	 
			 if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed())
			 {
				 invoice_tillNCKOT=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
				  System.out.println("invoice no from receipt before payment is"+invoice_noNckot);	 
			   try{
				 if(invoice_noNckot.equalsIgnoreCase(invoice_tillCash)){
					 OrderNo= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
					Discount= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")).getText();
		             Amount= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")).getText();
					 System.out.println("Order detaill showing in nckot secton below :");
					 System.out.println("Order No"+"           "+"Invoice No"+"      "+"Discount"+"   "+"Amount");
					 System.out.println(OrderNo+"           "+invoice_tillNCKOT+"      "+Discount+"   "+Amount);
					// driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
					 break;
				                               }
			   }catch(Exception e){
					System.out.println("invoice numbers not match");
				    }
			      }
			    }
			   catch(Exception e){
				 l=l-18;
				   if(l>0)
				   {
					   l--;
				   }
				   System.out.println("scroll up on Nckot list started");
				   scrollOnNCKOTIntill();
			      }
			   }
			 
		 }
			
			 
			 
			 
			    
		 		
 public void tillManagment() throws InterruptedException{ 
	 
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/user_details")).click();		
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_till_mgmt")).click();	
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_cash_details")).click();	
	 
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]

	 for(int k=1; k<25; k++)
	   {
		 System.out.println("verifying loop for cell of j is ="+k);	 
		    try
		     {
		    	 System.out.println("j is ="+k);	 
	 if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed())
	 {
		 invoice_tillCash=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
		  System.out.println(invoice_tillCash);	
		  System.out.println("Receipt invoice no is ="+invoice_no);
			 OrderNo= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
			 System.out.println(OrderNo);	
			 Amount= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")).getText();
             System.out.println(Amount);
             try{
		 if(invoice_no.equalsIgnoreCase(invoice_tillCash)&&(Order_No.equalsIgnoreCase(OrderNo))&&(total_amount.equalsIgnoreCase(Amount)))
			 { 
			 OrderNo= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
			Discount= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")).getText();
			// invoice_tillCash=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
             //Amount= driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")).getText().substring(1);
			 System.out.println();
					 System.out.println("Order details taken from order creation and receipt :");
			 System.out.println("Order No"+"           "+"Invoice No"+"      "+"Discount"+"   "+"Amount");
			 System.out.println(Order_No+"           "+invoice_no+"      "+DiscountR+"   "+total_amount);
			 System.out.println();
             System.out.println("Order details taken from Till in Cash Detail section :");
			 System.out.println("Order No"+"           "+"Invoice No"+"      "+"Discount"+"   "+"Amount");
			 System.out.println(OrderNo+"           "+invoice_tillCash+"       "+Discount+"    "+Amount);
			 System.out.println();
			// driver.findElement(By.id("com.torenzo.torenzocafe:id/done")).click();
			 break;
		                               }
	   }catch(Exception e){
			System.out.println("invoice numbers not match");
		    }
	      }
	    }
	   catch(Exception e){
		 k=k-2;
		   if(k>0)
		   {
			   k--;
		   }
		   System.out.println("scroll up on Nckot list started");
		   scrollOncashDetailIntill();
	      }
	   }
	 driver.findElement(By.id("com.torenzo.torenzocafe:id/home_btn")).click(); 
	 Thread.sleep(1000);
 }
			 
		 public void scrollOncashDetailIntill() throws InterruptedException{
	Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'cash_details_tab_recycler_view') and @index='0']")).getSize();
				
				System.out.println(size);
				// Find swipe start and end point from screen’s width and height.
				// Find start y point which is at bottom side of screen.
				int starty = (int) (size.height * 0.80);
			    
				// Find end y point which is at top side of screen.
				int endy = (int) (size.height * 0.20);
				// Find horizontal point where you wants to swipe. It is in middle of
				// screen width.
				int startx = size.width/2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
					// Swipe from Bottom to Top.

		WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'cash_details_tab_recycler_view') and @index='0']"))).get(0);
		System.out.println("value" +ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx,endy).release().perform();	   
					//driver.swipe(startx, starty, startx, endy, 3000);
					Thread.sleep(2000);
		 }
		 public void scrollOnNCKOTIntill() throws InterruptedException{
				Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'gift_card_details_tab_recycler_view') and @index='0']")).getSize();
							
							System.out.println(size);
							// Find swipe start and end point from screen’s width and height.
							// Find start y point which is at bottom side of screen.
							int starty = (int) (size.height * 0.80);
						    
							// Find end y point which is at top side of screen.
							int endy = (int) (size.height * 0.20);
							// Find horizontal point where you wants to swipe. It is in middle of
							// screen width.
							int startx = size.width/2;
					System.out.println(starty);
					System.out.println(endy);
					System.out.println(startx);
								// Swipe from Bottom to Top.

					WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'gift_card_details_tab_recycler_view') and @index='0']"))).get(0);
					System.out.println("value" +ele2);
					TouchAction action = new TouchAction(driver);
					action.longPress(ele2).moveTo(startx,endy).release().perform();	   
								//driver.swipe(startx, starty, startx, endy, 3000);
								Thread.sleep(2000);
					 }
		 public void scrollOnNckotlist() throws InterruptedException{
				Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'edit_order_recycleview') and @index='0']")).getSize();
				
				System.out.println(size);
				// Find swipe start and end point from screen’s width and height.
				// Find start y point which is at bottom side of screen.
				int starty = (int) (size.height * 0.80);
			    
				// Find end y point which is at top side of screen.
				int endy = (int) (size.height * 0.20);
				// Find horizontal point where you wants to swipe. It is in middle of
				// screen width.
				int startx = size.width/2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
					// Swipe from Bottom to Top.

		WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'edit_order_recycleview') and @index='0']"))).get(0);
		System.out.println("value" +ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx,endy).release().perform();	   
					//driver.swipe(startx, starty, startx, endy, 3000);
					Thread.sleep(2000);
			}
		 public void ScrollOnReceipt()
		  {
				  Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'edit_order_recycleview') and @index='0']")).getSize();
		          System.out.println("size of element" +size);
		     
		          int x1 = (int) (size.width * 0.10);
		        
		          int x2 = (int) (size.width * 0.90);
		         
		          TouchAction action = new TouchAction(driver);
			  
			      WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'payment_recycle_view') and @index='0']"))).get(0);
			      System.out.println("value" +ele2);
			      action.longPress(ele2).moveTo(x1,850).release().perform();	   
			      System.out.println("swipe4");
				
		     }
		 public void ScrollOnTables()
		  {
				  Dimension size = driver.findElement(By.xpath("//android.widget.ImageView[contains(@resource-id,'floor_img') and @index='0']")).getSize();
		          System.out.println("size of element" +size);
		     
		          int x1 = (int) (size.width * 0.10);
		        
		          int x2 = (int) (size.width * 0.90);
		         
		          TouchAction action = new TouchAction(driver);
			  
			      WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.widget.ImageView[contains(@resource-id,'floor_img') and @index='0']"))).get(0);
			      System.out.println("value" +ele2);
			      action.longPress(ele2).moveTo(x1,850).release().perform();	   
			      System.out.println("swipe4");
				
		     }
		public void Tillsubmit() throws InterruptedException{
			Thread.sleep(2000);
			driver.findElement(By.id("com.torenzo.torenzocafe:id/user_details")).click();		
			driver.findElement(By.id("com.torenzo.torenzocafe:id/txt_till_mgmt")).click();	
			diff_amount=driver.findElement(By.id("com.torenzo.torenzocafe:id/diff_amount")).getText().substring(1);
			//com.torenzo.torenzocafe:id/edt_cent_amount
			System.out.println(diff_amount);
			diff_amount =diff_amount.substring(0, diff_amount.length()-3);
			System.out.println(diff_amount);
			driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_cent_amount")).click();
		    String[] a = diff_amount.split("");
		    int len=diff_amount.length();
			for(int s=0;s<len; s++)
			{
		    System.out.println(a[s]);
		    driver.findElement(By.xpath("//android.widget.Button[@text='"+a[s]+"']")).click();
	        }
	    	//driver.findElement(By.id("com.torenzo.torenzocafe:id/edt_cent_amount")).sendKeys(diff_amount);	
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/submit")).click();	
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/submit_till")).click();
			 driver.findElement(By.id("com.torenzo.torenzocafe:id/back_search_list")).click();
			 if(driver.findElement(By.xpath("//android.widget.TextView[@text='AceCafe 1']")).isDisplayed()){
		    //driver.findElement(By.xpath("//android.widget.TextView[@text='AceCafe 1']")).click();
			 int[] i = {1,2,3,4};
			   // System.out.println(i);
			    for(int j=0; j < i.length; j++) {
			    System.out.println("Value at index " + j + ": " + i[j]);
			    driver.findElement(By.xpath("//android.widget.Button[@text='"+i[j]+"']")).click(); //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.LinearLayout[3]/android.widget.ImageView[1]
			                                     }
			    }
		 }
		 
		
		 public void DbconnReceiptdata(){
				
			 try{  
				 Order_To=Order_To.substring(1);
		         System.out.println("ID"+"     "+"ReceiptTotal"+"     "+"isPaid"+"    "+"Tax"+"        "+"Discount"+"     "+"InvoiceNumber"+"             "+"ReceiptDateTime"+"      "+"StoreID"+"       "+"ReceiptTime");  
			     Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.76:3306/MainDB","root","root");  
				 Statement stmt=(Statement) con.createStatement(); 
		         ResultSet rt=stmt.executeQuery("select * from MainDB.receiptdata where InvoiceNumber='"+invoice_no+"';");  
				 while(rt.next())
				 {
				 System.out.println(rt.getString("ID")+"    "+rt.getString("ReceiptTotal")+"            "+rt.getString("isPaid")+"       "+rt.getString("Tax")+"    "+rt.getString("Discount")+"       "+rt.getString("InvoiceNumber")+"     "+rt.getString("ReceiptDateTime")+"    "+rt.getString("StoreID")+"         "+rt.getString("ReceiptTime"));  
				 } 
				 System.out.println("");
				 System.out.println("ID"+"     "+"StartDate"+"     "+"OrderAmount"+"    "+"ReceiptTotal"+"        "+"InvoiceNumber"+"     "+"TransactionType"+"             "+"uniqueOrderNO"+"      "+"StoreID"+"       "+"drawerID");  
				 ResultSet rd=stmt.executeQuery("select * from MainDB.drawertransaction where InvoiceNumber='"+invoice_no+"';");  
				 while(rd.next())
				 System.out.println(rd.getString("ID")+"    "+rd.getString("StartDate")+"      "+rd.getString("OrderAmount")+"      "+rd.getString("ReceiptTotal")+"     "+rd.getString("InvoiceNumber")+"       "+rd.getString("TransactionType")+"       "+rd.getString("uniqueOrderNO")+"             "+rd.getString("StoreID")+"         "+rd.getString("drawerID"));  

				 con.close();  
				 }catch(Exception e){ System.out.println(e);}  
			 System.out.println("");
		                               }
		 
		 
		 public void DbconnbeforePay(){
		 try{  
			 Order_To=Order_To.substring(1);
		     System.out.println("fetching data from database like Order table Before payment");
			 System.out.println("ID"+"       "+"LastUpdated"+"              "+"Total"+"       "+"Tax"+"         "+"Discount"+"    "+"status"+"          "+"UniqueId"+"       "+"StoreID"+"     "+"EmployeeName");  
		     Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.76:3306/MainDB","root","root");  
		     //Connection con=(Connection) DriverManager.getConnection("//127.0.0.1:3306/28_May_pnrdb?autoReconnect=true&useSSL=false","root","root");  
			 Statement stmt=(Statement) con.createStatement(); 
			 ResultSet rs=stmt.executeQuery("select * from MainDB.order  where UniqueId='"+Order_No+"' and Total="+Order_To+";");  
			 while(rs.next()) 
			  {
			 System.out.println(rs.getString("ID")+"    "+rs.getString("LastUpdated")+"      "+rs.getString("Total")+"      "+rs.getString("Tax")+"     "+rs.getString("Discount")+"       "+rs.getString("status")+"       "+rs.getString("UniqueId")+"             "+rs.getString("StoreID")+"         "+rs.getString("EmployeeName"));  
		     System.out.println("OrderID"+"     "+"FullPrice"+"     "+"Price"+"         "+"QuantityOnOrder"+"      "+"SalesTax"+"    "+"Description"+"       "+"CategoryName"+"       "+"DepartmentName"+"     "+"Taxable");  
			 OrderID=(rs.getString("ID"));
		      }
			 ResultSet rk=stmt.executeQuery("select * from MainDB.orderentry where OrderId='"+OrderID+"';"); 
		     while(rk.next())  
			 System.out.println(rk.getString("OrderID")+"     "+rk.getString("FullPrice")+"       "+rk.getString("Price")+"           "+rk.getString("QuantityOnOrder")+"                "+rk.getString("SalesTax")+"         "+rk.getString("Description")+"          "+rk.getString("CategoryName")+"             "+rk.getString("DepartmentName")+"         "+rk.getString("Taxable"));  
			 System.out.println("");
			 con.close();  
			 }catch(Exception e){ System.out.println(e);} 
		
		 } public void DbconnAfterPay(){
			 try{  
				  
				 System.out.println("fetching data from database like Order table After payment");
				 System.out.println("ID"+"       "+"LastUpdated"+"              "+"Total"+"       "+"Tax"+"         "+"Discount"+"    "+"status"+"          "+"UniqueId"+"       "+"StoreID"+"     "+"EmployeeName");  
				 Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.76:3306/MainDB","root","root");  
			     Statement stmt=(Statement) con.createStatement(); 
				 ResultSet rs=stmt.executeQuery("select * from MainDB.order  where UniqueId='"+Order_No+"' and Total="+Order_To+";");  
				  while(rs.next())  
				 System.out.println(rs.getString("ID")+"    "+rs.getString("LastUpdated")+"      "+rs.getString("Total")+"      "+rs.getString("Tax")+"     "+rs.getString("Discount")+"       "+rs.getString("status")+"       "+rs.getString("UniqueId")+"             "+rs.getString("StoreID")+"         "+rs.getString("EmployeeName"));  
			     con.close();  
				 }catch(Exception e){ System.out.println(e);} 
			
			 }
		 public void DbconnOrderEntry(){
			
			 try{  
				 Order_To=Order_To.substring(1);
			     System.out.println("fetching data from database like OrderEntry table");
			     System.out.println("OrderID"+"     "+"FullPrice"+"     "+"Price"+"         "+"QuantityOnOrder"+"      "+"SalesTax"+"    "+"Description"+"       "+"CategoryName"+"       "+"DepartmentName"+"     "+"Taxable");  
		         Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.76:3306/MainDB","root","root");  
			     Statement stmt=(Statement) con.createStatement(); 
			     ResultSet rs=stmt.executeQuery("select * from MainDB.order  where UniqueId='"+Order_No+"' and Total="+Order_To+";");  
				 while(rs.next())  
				 System.out.println(rs.getString("ID")+"    "+rs.getString("FullPrice")+"    "+rs.getString("Price")+"   "+rs.getString("QuantityOnOrder")+"     "+rs.getString("SalesTax")+"       "+rs.getString("Description")+"       "+rs.getString("CategoryName")+"             "+rs.getString("DepartmentName")+"         "+rs.getString("Taxable"));  
			     con.close();  
				 }catch(Exception e){ System.out.println(e);}  
			                           }
		 public void seatedPay() throws InterruptedException{
					driver.findElement(By.id("com.torenzo.torenzocafe:id/table_structure_img")).click();
					 driver.findElement(By.id("com.torenzo.torenzocafe:id/table_guest_list")).click();
					 driver.findElement(By.id("com.torenzo.torenzocafe:id/seated_btn")).click();
					 for(int d=1; d<18; d++)
				 {            
						 System.out.println("the value of D is = "+d);//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[6]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]
						 try{                               //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
							if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+d+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).isDisplayed())
							{ System.out.println(" D first is = "+d);
								// if(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[“+d+”]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).isDisplayed()){
								
								 table_name=driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+d+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText().substring(8);
								 System.out.println(" D second is = "+d);
								 try{
								 System.out.println("compare tables are:  "+table_No+" "+table_name);
								 //if(table_name.equalsIgnoreCase(table_No)){
									 if(table_name.equalsIgnoreCase(table_No)){
										 System.out.println("Table name and table no. are matched");
								    	  driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+d+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
								    	 
								    	  break;
									 }
								 }
								 catch(Exception e){
									 System.out.println("Table name and table no are not matched");
									                }
								 }
						 }
						 
						 catch(Exception e){
							 d=d-6;
							 ScrollUpOnSeatedList();
							 
							 
						 }
				    }	 
					 

				 }
		 public void ScrollUpOnSeatedList() throws InterruptedException{
			 Dimension size = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'seated_recycler_view') and @index='0']")).getSize();
				
				System.out.println(size);
				// Find swipe start and end point from screen’s width and height.
				// Find start y point which is at bottom side of screen.
				int starty = (int) (size.height * 0.80);
			    
				// Find end y point which is at top side of screen.
				int endy = (int) (size.height * 0.20);
				// Find horizontal point where you wants to swipe. It is in middle of
				// screen width.
				int startx = size.width/2;
		System.out.println(starty);
		System.out.println(endy);
		System.out.println(startx);
					// Swipe from Bottom to Top.

		WebElement ele2 = (WebElement) driver.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[contains(@resource-id,'seated_recycler_view') and @index='0']"))).get(0);
		System.out.println("value" +ele2);
		TouchAction action = new TouchAction(driver);
		action.longPress(ele2).moveTo(startx,endy).release().perform();	   
					//driver.swipe(startx, starty, startx, endy, 3000);
					Thread.sleep(2000);
		 }
		

		 
	//public static void main(String[] args) throws Exception {
		
	//	public String customername= "sammy";
    //    public String customername1= "sam";
		//public String customername2="samay";
		//public String customername3="Navin";
		
		
	//	Generalfunctions lo = new Generalfunctions();
		//lo.launchApp();
		//lo.login();
	    //lo.VerifyTableviewIcon();
		//lo.ReservationDelete();
	    //lo.verifyReservation(customername);
	    //lo.updateReservation(customername,customername1);
		//lo.verifyWaiting (customername2);
		//lo.updateWaiting(customername3);
	    // lo.ReserTransferTable();
        // lo.addguest();
         //lo.loadOrder();
        
             
             
          
      		
	}
//}