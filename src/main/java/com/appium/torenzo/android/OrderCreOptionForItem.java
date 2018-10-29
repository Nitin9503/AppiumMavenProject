package com.appium.torenzo.android;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listener.class)
public class OrderCreOptionForItem {
	Generalfunctions lo = new Generalfunctions();
	public OrderCreOptionForItem() throws Exception{
		super();
	}
	
	
	@Test(priority=0)
	public void addGuestAndItem() throws Exception{
		lo.login();
		lo.orderCreationWithlimiteditem();
		Thread.sleep(1000);
	}
	@Test(priority=1)
	public void verifyQuantity() throws InterruptedException{
		lo.addQuantity();
		Thread.sleep(1000);
	}
	@Test(priority=2)
	public void verifyModifiers() throws InterruptedException{
		lo.EditModifiers();
		Thread.sleep(1000);
	}
	@Test(priority=3)
	public void verifyDiscount() throws InterruptedException{
		lo.itemDiscounts();
		Thread.sleep(1000);
	}
	/*@Test(priority=4)
	public void verifyReOrder() throws InterruptedException{
		lo.Reorder();
		Thread.sleep(1000);
	}*/
	@Test(priority=4)
	public void verifylogout() throws Exception{
		lo.payWithCash();
	Thread.sleep(5000);
	System.out.println("fetching data from database like Order table");
	lo.DbconnAfterPay();
	System.out.println("");
	  System.out.println("fetching data from database like transaction table");
			Thread.sleep(5000);
			lo.DbconnReceiptdata();
}
}