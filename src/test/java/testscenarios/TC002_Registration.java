package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC002_Registration extends BaseClass{
	
	@BeforeTest
	public void setUp() {
		sExcelName = "TC002";
	}

	@Test(priority = 1)
	public void registrationFieldValidation() {
		boolean result = new LoginPage()
			.clickRegisterAcc()
			.fieldValidation();
		Assert.assertEquals(result, true);
		new RegistrationPage().clickUILogo();
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void registrationWithMandatoryFields(String fName,String lName,String uName,String email,String pWord) {
		new LoginPage()
			.clickRegisterAcc()
			.enterFirstName(fName)
			.selectTitle("Mr")
			.enterMiddleName()
			.enterLastName(lName)
			.selectGender("Male")
			.enterUserName(uName+generateRandomInt(1,10000))
			.enterEmail(email+generateRandomInt(1, 20000)+"@credosystemz.com")
			.enterPassword(pWord)
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
