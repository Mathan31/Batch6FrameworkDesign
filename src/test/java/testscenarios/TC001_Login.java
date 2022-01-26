package testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage().verifyAllElements();
		Assert.assertEquals(result, true);			
	}
	
	@Test(priority = 2)
	public void loginWithValidCredential() {
		boolean result = new LoginPage()
		.typeUserName("Mathan")
		.typePassword("Testing123")
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
