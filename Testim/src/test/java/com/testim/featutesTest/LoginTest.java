package com.testim.featutesTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testim.TestBase.TestBase;
import com.testim.featuresPage.LoginPage;

public class LoginTest extends TestBase {
	
	public LoginTest() {
		PageFactory.initElements(driver, this);
	}
	@BeforeMethod
	public void LaunchURL() {
		driver.get("https://www.saucedemo.com/");
		log.info("URL SucessFully Launched.");
		
		}
	
	//To check user able to login successfully with valid userNameAndPassword
	@Test(priority=0 ,groups= {"Smoke","Functional"})
	public void loginWithValidUserNamePassword() {
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnLoginButton();
	loginPage.verifyUserRedirectOnHomePage("https://www.saucedemo.com/inventory.html");
		
	}
	
	
	//To check if user enter invalid userName and password 
	@Test(priority=1,groups= {"Functional"},dataProvider="UserNameAndPassword", dataProviderClass=LoginPage.class)
	public void loginWithInvalidUserNamePassword(String userName, String Password) {
		loginPage.enterUserName(userName);
		loginPage.enterPassword(Password);
		loginPage.clickOnLoginButton();
		loginPage.checkInvalidUserNamePasswordErrorMSG();
	}
	
	// To check if user not enter UserName and password and try to login
	@Test(priority=2 ,groups="Functional")
	public void loginWithoutEnterUsernamePassword() {
		loginPage.clickOnLoginButton();
		loginPage.noInputUserErrorMs();
		
	}
	
	@Test(priority=3,groups="Functional")
	public void loginWithoutEnterPassword() {
		loginPage.enterUserName("Yogesh");
		loginPage.clickOnLoginButton();
		loginPage.noInputUserErrorMs();
	}
	

}
