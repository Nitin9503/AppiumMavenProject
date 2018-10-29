package com.appium.torenzo.android;

import org.testng.annotations.Test;

public class LoadCreatedOrder {
public String Type="three";
	Generalfunctions lo = new Generalfunctions();
	public LoadCreatedOrder() throws Exception{
		super();
	}
	@Test(priority=0)
	public void verfylogin() throws Exception{
		//lo.login();
		System.out.println("Already login");
	}
	@Test(priority=1)
	public void OrderCreationTakeout() throws Exception{
		lo.OrderCreationforTakeOut();
	}
	@Test(priority=2)
	public void currentOrderLoad() throws Exception{
	
		lo.loadOrder(Type);
	 }
  }
