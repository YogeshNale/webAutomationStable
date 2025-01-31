package com.testim.featuresPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testim.TestBase.TestBase;

public class CartPage extends TestBase {
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@data-test='shopping-cart-link']")
	private WebElement cartOption;
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement CheckoutButton;
	
	@FindBy(xpath = "//div[@data-test='inventory-item-price']")
	private WebElement productPrice;
	
	//click on cart button 
	public void clickOnCartButton() {
		cartOption.click();
	}
	
	//public void compare product price 
	public String verifyProductPrice(String expectedPrice) {
		
		String productPriceOncartPage=productPrice.getText();
		Assert.assertEquals(productPriceOncartPage,expectedPrice);
		return productPriceOncartPage;
		
	}
	
	//click on checkout
	public void clickOnCheckOut() {
		CheckoutButton.click();
	}
	
	

}
