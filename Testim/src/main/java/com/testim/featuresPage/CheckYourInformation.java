package com.testim.featuresPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testim.TestBase.TestBase;

public class CheckYourInformation extends TestBase {
	
	public CheckYourInformation() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='first-name']")
	private WebElement FirstName;
	
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement LastName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	private WebElement PostalCode;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement ContinueButton;
	
	
	
	//enter name 
		public void enterName(String Name) {
			FirstName.sendKeys(Name);
		}
		
		//enter last name
		public void enterLastName(String lastName) {
			LastName.sendKeys(lastName);
			
		}
		
		//enter postal Code 
		public void enterPostalCode(String postalCode) {
			PostalCode.sendKeys(postalCode);
		}
		
		//click on continue Button
		public void clickOnContinueButton() {
			ContinueButton.click();
		}
		
		
	
	
	

}
