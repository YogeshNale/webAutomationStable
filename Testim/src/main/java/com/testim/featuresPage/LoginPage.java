package com.testim.featuresPage;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.testim.TestBase.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement UserName;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement Password;

	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//button[@class='error-button']")
	private WebElement InvalidUserNamePasswordErrorMsg;

	// Enter username
	public void enterUserName(String userName) {
		UserName.sendKeys(userName);
	}

//Enter Password
	public void enterPassword(String password) {
		Password.click();
		Password.sendKeys(password);

	}

	// click on login Button
	public void clickOnLoginButton() {
		LoginButton.click();
	}
	
	//check user redirect on home page Successfully.
	public void verifyUserRedirectOnHomePage(String actualURL) {
		String HomePageURL=driver.getCurrentUrl();
	Assert.assertEquals(HomePageURL, actualURL);
	
	}
	
	public void checkInvalidUserNamePasswordErrorMSG() {
		Assert.assertTrue(InvalidUserNamePasswordErrorMsg.isDisplayed());
	}
	
	@DataProvider(name="UserNameAndPassword")
	public Object[][] dataProviderUserNameAndPassword() {
		Object[][] data = new Object[3][2];
		data[0][0]="Yogesh";
		data[0][1]="Nale";
		data[1][0]="Abak";
		data[1][1]="Ashsi";
		data[2][0]="Prashant";
		data[2][1]="Ugale";
		return data;
	}

}
