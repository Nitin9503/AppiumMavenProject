package com.appium.torenzo.android;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.appium.torenzo.android.StaticVariable.customername1;
import static com.appium.torenzo.android.StaticVariable.b;
@Listeners(Listener.class)
public class WaitingAndOrderCreation{
	public String customername= "sammy";
	//public String customername1= "sam";
	//public String customername2="samay";
	public String customername3="Navin1";
	public String Type= "two";
	Generalfunctions lo = new Generalfunctions();
	public WaitingAndOrderCreation()throws Exception{
		super();
	}
	@Test(priority=0)
	public void addwaiting() throws InterruptedException, IOException {
		lo.launchApp();
		lo.login();
		lo.VerifyTableviewIcon();
		
	}
	@Test(priority=1)
	public void selectWaitingList() throws Exception{
		lo.verifyWaiting(customername1);
		lo.waitingTransfertable();
		System.out.println("waiting got selected from list successfully");
		lo.addguestforDineIn();
        lo.loadOrder(Type);
        Thread.sleep(5000);
        lo.seatedPay();
        lo.payWithCash();
	}
	
   }
