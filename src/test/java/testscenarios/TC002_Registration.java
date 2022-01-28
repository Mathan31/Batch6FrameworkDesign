package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC002_Registration extends BaseClass{
	

	@Test(priority = 1)
	public void registrationFieldValidation() {
		boolean result = new LoginPage()
			.clickRegisterAcc()
			.fieldValidation();
		Assert.assertEquals(result, true);
		new RegistrationPage().clickUILogo();
	}
	
	@Test(priority = 2)
	public void registrationWithMandatoryFields() {
		new LoginPage()
			.clickRegisterAcc()
			.enterFirstName("Mathan")
			.selectTitle("Mr")
			.enterMiddleName()
			.enterLastName("Chandrasekaran")
			.selectGender("Male")
			.enterUserName("Credo"+generateRandomInt(1,10000))
			.enterEmail("credo"+generateRandomInt(1, 20000)+"@credosystemz.com")
			.enterPassword("credo123")
			.clickRegisterLink()
			.verifyUserRegistration()
			.clickOnLogin();
	}
	
	public int generateRandomInt(int min,int max) {
		Random r = new Random();
		int result = r.nextInt((max-min)+1)+min;
		return result;
	}
	
	
}
