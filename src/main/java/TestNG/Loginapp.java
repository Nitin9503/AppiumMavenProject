package TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import io.appium.java_client.android.AndroidDriver;

//@Listeners(TestNG.Listener.class)
public class Loginapp{
	

			
	public Properties obj = new Properties();	

	 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/application.properties");
		
		org.apache.log4j.Logger log = LogManager.getLogger(Loginapp.class);
 
	 public Loginapp() throws IOException{
				
	 }
	 
	public static AndroidDriver driver;
	//public static AndroidDriver driver;
	@BeforeSuite(alwaysRun=true)
	public void launch() throws IOException
	{
		log.info("************************************ Permission popup **********************************************");
         //  for mac machine bellow is the command for launch termninal
		    Process p1  = Runtime.getRuntime().exec("/usr/bin/open -a Terminal");
		 //  navigate to folder and save text file ==  cd Library/Android/sdk/platform-tools ; adb logcat > Sachin.txt
		
		 //  for window machine bellow is the command for launch termninal
       //  Process p1 = Runtime.getRuntime().exec("cmd.exe /c start cd \"E:\\AppiumFile\\android-sdk-windows\\platform-tools\" && dir");
	    // System.out.println("Launched CMD window");
	
		    log.info("************************************ Launching App**********************************************");
	  DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Honor");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("newCommandTimeout","150");
        caps.setCapability("udid", "192.168.56.101:5555");
        caps.setCapability("appPackage", "com.torenzo.torenzocafe");
		caps.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");
	//	caps.setCapability("app", "/Users/rahul.kardel/Downloads/app-release 75.apk");
		try{
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		}catch(Exception e)
		{
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test(priority=0)
	public void login() throws IOException
	{
		
		
	String	Title=driver.findElement(By.id("open_exist_store")).getText();
	
	System.out.println("Title ==" +Title);
	obj.load(objfile);

    log.info("************************************ Login App  **********************************************");
		System.out.println("Value of Live user" +obj.getProperty("Live-User"));
    try{

	
	    if(driver.findElement(By.xpath(obj.getProperty("TitleLogin"))).isDisplayed())
		{
	    	//driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys("torenzocafe");
           // driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys("1234");
			driver.findElement(By.id(obj.getProperty("Submit"))).click();
		   driver.findElement(By.id(obj.getProperty("Clock-In"))).click();
		 
		   driver.findElement(By.id(obj.getProperty("Role-Name"))).click();
		    System.out.println("on home page");
		    driver.unlockDevice();
		}
		
		
	}catch(Exception e)
	{
	    
		driver.findElement(By.xpath(obj.getProperty("Live-User"))).click();
		//driver.findElement(By.xpath("Demo-User")).click();
	//	driver.findElement(By.id(obj.getProperty("UserName"))).sendKeys("torenzocafe");
	//	driver.findElement(By.id(obj.getProperty("PassWord"))).sendKeys("1234");
     	driver.findElement(By.id(obj.getProperty("Submit"))).click();
	    driver.findElement(By.id(obj.getProperty("Clock-In"))).click();
	    driver.findElement(By.id(obj.getProperty("Role-Name"))).click();
	    System.out.println("on home page");
	}
	

}

	
	@Test(priority=1)
	   public void permission() throws IOException
		{
										
	    obj.load(objfile);
	    log.info("************************************ Permission popup **********************************************");
		try{
		
			if (driver.findElement(By.xpath(obj.getProperty("PermissionPopup"))).isDisplayed())
			{
				 System.out.println("Permission popup is displayed");
				 driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
			    driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
			
			}
		}catch (Exception e)
	      	{
			
				System.out.println("Permission popup is not displayed");
			}
		}	
	
	
				 
	}
	
	
   