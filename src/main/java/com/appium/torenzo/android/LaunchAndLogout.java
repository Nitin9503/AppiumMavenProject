package com.appium.torenzo.android;

import java.net.MalformedURLException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import junit.framework.TestListener;
import static com.appium.torenzo.android.StaticVariable.screenshotName2;
@Listeners(Listener.class)
public class LaunchAndLogout {
	Generalfunctions lo = new Generalfunctions();
	public LaunchAndLogout()throws Exception{
		super();
	}
	@Test(priority=1)
	public void verifyLaunchAndlogout() throws Exception{
		lo.launchApp();
	lo.login();
	lo.logout();
		
	}
}
