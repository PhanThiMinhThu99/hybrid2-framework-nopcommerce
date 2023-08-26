package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
private WebDriver driver;

public LoginPageObject(WebDriver driver) {
	this.driver = driver;
}
public HomePageObject clickToLoginButton() {
	waitForElementClickAble(driver, LoginPageUI.LOGIN_BUTTON);
	clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	return PageGeneratorManager.getHomePage(driver);
}

public String getErrorMessageEmailTextbox() {
	waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
}

public void inputToEmailTextbox(String email) {
	waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
	sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	
}

public String getErrorMessageUnsuccessfull() {
	waitForElementVisible(driver, LoginPageUI.UNSUCCESSFULL_EMAIL_ERROR_MESSAGE);
	return getElementText(driver, LoginPageUI.UNSUCCESSFULL_EMAIL_ERROR_MESSAGE);
}
public void inputToPasswordTextbox(String passWord) {
	waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
	sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWord);
}





}

