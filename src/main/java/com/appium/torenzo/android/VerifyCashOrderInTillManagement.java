package com.appium.torenzo.android;

import org.openqa.selenium.By;
import static com.appium.torenzo.android.StaticVariable.invoice_no;
import static com.appium.torenzo.android.StaticVariable.invoice_noNckot;
import org.testng.annotations.Test;

public class VerifyCashOrderInTillManagement {
	Generalfunctions lo = new Generalfunctions();
	public VerifyCashOrderInTillManagement()  throws Exception{
		super();
	}
	
	@Test(priority=0)
	public void LoginAndOrderCreate() throws Exception{

		lo.launchApp();
		lo.login();
		lo.orderCreationWithlimiteditem();
		lo.DbconnbeforePay();
	    //lo.DbconnOrderEntry();
		Thread.sleep(1000);
		lo.payWithCash();
		System.out.println("fetching data from database like Order table");
		Thread.sleep(5000);
		lo.DbconnAfterPay();
	
       System.out.println("fetching data from database like transaction table");
		Thread.sleep(5000);
		lo.DbconnReceiptdata();
		//Thread.sleep(1000);
	}
	
	@Test(priority=1)
	public void PaymentAndNckotLoad() throws InterruptedException{
		//lo.verifyNckot();
		//lo.payWithCash();
		//Thread.sleep(5000);
		//lo.DbconnInstance();
		lo.tillManagment();
		//lo.Tillsubmit();
	}
	/*@Test(priority=2)
		public void acceptNckotAndcheckInTill() throws InterruptedException{
	
		//lo.tillManagment();
		//lo.Tillsubmit();
	//}
		lo.accepttNckot();
		  lo.tillManagment();
		Thread.sleep(1000);
		
	}
	@Test(priority=3)
		public void RejectNckotAndcheckInTill() throws Exception{
        lo.orderCreationWithlimiteditem();	
		lo.verifyNckot();
		lo.rejctNckot();
	
	}*/
	
}
