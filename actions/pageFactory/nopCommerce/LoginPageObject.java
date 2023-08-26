package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import commons.BasePageFactory;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
    private WebDriver driver;
    
    public LoginPageObject(WebDriver driver) {
   	 this.driver = driver;
   	 PageFactory.initElements(driver, this);
    }
    @FindBy(id = "email")
    private WebElement emailTextbox;
    @FindBy (how = How.XPATH, using = "//input[@class='password']" )
    private WebElement passwordTextbox;
    @FindBy (how = How.XPATH, using = "//button[contains(@class,'login-button')]")
    private WebElement loginButton;
    @FindBy (xpath = "//span[@class='field-validation-error']")
    private WebElement emailErrorMessage;
    @FindBy (xpath = "//div[contains(@class,'validation-summary-errors')]")
    private WebElement unSuccessFullEmailErrorMessage;
    
    //PageObject/Action
    public void clickToLoginButton() {
    	waitForElementClickAble(driver, loginButton);
    	clickToElement(driver, loginButton);
    }

    public String getErrorMessageEmailTextbox() {
    	waitForElementVisible(driver, emailErrorMessage);
    	return getElementText(driver, emailErrorMessage);
    }

    public void inputToEmailTextbox(String email) {
    	waitForElementVisible(driver, emailTextbox);
    	sendKeyToElement(driver, emailTextbox, email);
    	
    }

    public String getErrorMessageUnsuccessfull() {
    	waitForElementVisible(driver, unSuccessFullEmailErrorMessage);
    	return getElementText(driver, unSuccessFullEmailErrorMessage);
    }
    public void inputToPasswordTextbox(String passWord) {
    	waitForElementVisible(driver, passwordTextbox);
    	sendKeyToElement(driver, passwordTextbox, passWord);
    }
}