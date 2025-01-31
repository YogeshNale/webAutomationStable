package com.testim.featuresPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testim.TestBase.TestBase;

public class CheckoutPage extends TestBase {
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@data-test='tax-label']")
	private WebElement TaxAmount;
	
	@FindBy(xpath="//div[@data-test='total-label']")
	private WebElement TotalAmount;
	
	@FindBy(xpath="//button[@id='finish']")
	private WebElement FinishButton;
	
	
	public String getTaxAmount() {
		String taxAmount=TaxAmount.getText();
		return taxAmount;
	}
	
	public String getTotalAmount() {
		String amount= TotalAmount.getText();
		return amount;
	}
	
	public String verifyTotalAmount(String expectedAmount) {
		String amount= TotalAmount.getText(); 
		System.out.println(amount.trim());
		Assert.assertEquals(amount.trim(),expectedAmount);
		  return amount;

	}
	
	   //click on finish Button 
		public void clickOnFinish() {
			FinishButton.click();
		}

}
