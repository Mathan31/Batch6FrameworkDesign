package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	private By oUsername = By.id("username");
	private By oPassword = By.id("password");
	private By oSignIn = By.xpath("//button[text()='Sign In']");
	private By oRegister = By.xpath("//*[text()='Register For Account']");
	private By oForgot = By.xpath("//*[text()='Forgot Your Password?']");
	
	public boolean verifyAllElements() {
		if(driver.findElement(oUsername).isDisplayed() && driver.findElement(oPassword).isDisplayed() &&
				driver.findElement(oSignIn).isDisplayed() && driver.findElement(oRegister).isDisplayed() &&
				driver.findElement(oForgot).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public LoginPage typeUserName(String userName) {
		driver.findElement(oUsername).sendKeys(userName);
		return this;
	}
	
	public LoginPage typePassword(String password) {
		driver.findElement(oPassword).sendKeys(password);
		return this;
	}
	
	public HomePage clickOnSignin() {
		driver.findElement(oSignIn).click();
		return new HomePage();
	}
	
	public LoginPage clickSignInFailed() {
		driver.findElement(oSignIn).click();
		return this;
	}
	
	public RegistrationPage clickRegisterAcc() {
		driver.findElement(oRegister).click();
		return new RegistrationPage();
	}
	
	}
