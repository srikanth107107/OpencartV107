package testCases;

import java.time.Duration;
//import testBase.BaseClass;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
//import testBase.BaseClass;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void verify_account_registration()
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String Password=randomAlphaNumeric();
		regpage.setPassword(Password);
		regpage.setConfirmPassword(Password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		System.out.println(regpage.getConfirmationMsg());
		Assert.assertEquals(regpage.getConfirmationMsg(),"Your Account Has Been Created!");
		
	}
	
	
}
	
