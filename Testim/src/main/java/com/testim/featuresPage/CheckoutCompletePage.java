package com.testim.featuresPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testim.TestBase.TestBase;

public class CheckoutCompletePage extends TestBase {
	
	public CheckoutCompletePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Checkout: Complete!']")
	private WebElement CheckOutCompleteText;
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	private WebElement OrderPlaceSuccessFullMsg;
	
	
	//verify oder place successfull msg 
	public void checkOrderPlaceSuccessfullMsg(String ExpextedMsg) {
		
		Assert.assertEquals(OrderPlaceSuccessFullMsg.getText(),ExpextedMsg);
	}
	

}
