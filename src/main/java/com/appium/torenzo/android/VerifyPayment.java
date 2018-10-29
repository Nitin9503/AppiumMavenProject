package com.appium.torenzo.android;

import org.testng.annotations.Test;

public class VerifyPayment {
Generalfunctions lo = new Generalfunctions();
public VerifyPayment() throws Exception{
	super();
}
	
	
	@Test(priority=0)
	public void addGuestAndItem() throws Exception{
		lo.launchApp();
		lo.login();
		
	}
	@Test(priority=1)
		public void OrderCreationTakeout() throws Exception{
			lo.OrderCreationforTakeOut();
	}
	@Test(priority=2)
	public void spitReceiptEquallyForAll() throws Exception{
		lo.paymentsplitReceipt();
}

}
