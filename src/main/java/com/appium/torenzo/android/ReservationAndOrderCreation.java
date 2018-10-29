package com.appium.torenzo.android;

import java.io.IOException;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.appium.torenzo.android.StaticVariable.ReserTime;
import static com.appium.torenzo.android.StaticVariable.customername;
import static com.appium.torenzo.android.StaticVariable.customername1;
@Listeners(Listener.class)
public class ReservationAndOrderCreation extends Generalfunctions{
	//public  static String customername= "Ajinkya";

	//public static String customername1= "Virat";
	public String customername2="Ajinkya";
	public String customername3="Ashish";
	public String Type= "two";
	Generalfunctions lo = new Generalfunctions();
	
	
	public ReservationAndOrderCreation()throws Exception{
		super();
	}
   
	public void launchAndLogout() throws IOException, InterruptedException{
	
		lo.launchApp();
		lo.login();
	}
	
	@Test
	public void execute() throws Exception{
		
	    lo.VerifyTableviewIcon();
	   //lo.ScrollOnTables();
	   // lo.SelectTable();
	   // Thread.sleep(5000);
	    lo.verifyReservation(customername1);
	    lo.ReserTransferTable();
		lo.addguestforDineIn();
		
       lo.loadOrder(Type);
       Thread.sleep(5000);
        lo.seatedPay();
        lo.payWithCash();
        //lo.DbconnbeforePay();
	
	}
	
	}


