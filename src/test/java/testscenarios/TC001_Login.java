package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@BeforeTest
	public void setUp() {
		sExcelName = "TC001";
	}
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage().verifyAllElements();
		Assert.assertEquals(result, true);			
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void loginWithValidCredential(String uName,String passWord) {
		boolean result = new LoginPage()
		.typeUserName(uName)
		.typePassword(passWord)
		.clickOnSignin()
		.validateHomePage()
		.clickLogOut()
		.verifyAllElements();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage()
		.typePassword("Kowsi")
		.typePassword("Testing")
		.clickSignInFailed()
		.verifyAllElements();
		Assert.assertEquals(result, true);	
	}

}
