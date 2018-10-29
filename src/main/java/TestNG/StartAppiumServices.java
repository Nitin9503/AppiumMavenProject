package TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class StartAppiumServices {

	private static AppiumDriverLocalService service;


	
	public static void main (String[] args)
	{
	
		startServer();
		stopServer();
		
	}
	
	
	public static void startServer() {

			service = AppiumDriverLocalService
			.buildService(new AppiumServiceBuilder()
			.usingDriverExecutable(new File("/Applications/Appium.app/Contents/Resources/node/bin/node"))
			.withAppiumJS(
			new File(
			"/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/appium.js"))
			.withIPAddress("127.0.0.1").usingPort(4723));
			service.start();
			if(service.isRunning())
			System.out.println("Appium server started successfully");
			}
	  

	public static void stopServer() {
		System.out.println("Trying to stop appium server");
		
	  try {
		service.stop();
		System.out.println("appium server is stopped");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("appium server is already stoped");
	}
	}
	


		

}
