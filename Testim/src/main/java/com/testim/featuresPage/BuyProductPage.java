package com.testim.featuresPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testim.TestBase.TestBase;

public class BuyProductPage extends TestBase {

	public BuyProductPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement AddToCart;

	@FindBy(xpath = "(//div[@class='inventory_item_name '])[1]")
	private WebElement FirstProductAvailableOnPage;

	@FindBy(xpath = "//div[@data-test='inventory-item-price']")
	private WebElement productPrice;

	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement RemoveButton;

	// click on product
	public void clickOnProduct() {
		FirstProductAvailableOnPage.click();
	}

	// Product Add To Cart
	public void clickOnAddToCart() {
		if (AddToCart.isDisplayed()) {
			AddToCart.click();
		} else if (RemoveButton.isDisplayed()) {
			RemoveButton.click();
			AddToCart.click();
		}

	}

	// public void get product prise
	public String getProductPrice() {
		String Price= productPrice.getText();
		return Price;

	}

}
