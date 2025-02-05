package com.testim.featutesTest;

import static org.testng.Assert.fail;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testim.TestBase.TestBase;
import com.testim.utility.Waits;

public class BuyProductFlowTest extends TestBase {
	
	public BuyProductFlowTest() {
		PageFactory.initElements(driver,this);
	}
	
	@BeforeMethod
	public void preCondtion() {
		driver.get("https://www.saucedemo.com/");
		Waits.implicitlyWait(2000);
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnLoginButton();
	loginPage.verifyUserRedirectOnHomePage("https://www.saucedemo.com/inventory.html");
		
	}
	
	@Test(priority=0)
	public void checkBuyProductE2EFlow() {
		
		buyPage.clickOnProduct();
		buyPage.getProductPrice();
		buyPage.clickOnAddToCart();
		cartPage.clickOnCartButton();
	    cartPage.verifyProductPrice(buyPage.getProductPrice());
		cartPage.clickOnCheckOut();
		checkInfoPage.enterName("Yogesh");
		checkInfoPage.enterLastName("Nale");
		checkInfoPage.enterPostalCode("423107");
		checkInfoPage.clickOnContinueButton();
		checkoutPage.clickOnFinish();
		checkCompletePage.checkOrderPlaceSuccessfullMsg("Thank you for your order!");
	log.info("ExecutionComplete");
	
	}

}
