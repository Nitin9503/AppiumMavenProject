package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Practice extends Loginapp {

	public Practice() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Reusemethod call = new Reusemethod();
	
	
	/*FileInputStream fis =new FileInputStream("E:\\Appium1\\GitProjectnew\\TorenzoAppium\\PropertiesFile\\Element.Properties");
	  Properties p = new Properties();
	  p.load(fis);
	System.out.println(p.getProperty("use"));*/
			
			@Test(priority = 0)
	public void cash() throws IOException, InterruptedException
	{
		call.Allitem();
		driver.findElement(By.xpath("//android.widget.Button[@text= 'Cash']")).click();
		System.out.println("Hello");
	}
}
