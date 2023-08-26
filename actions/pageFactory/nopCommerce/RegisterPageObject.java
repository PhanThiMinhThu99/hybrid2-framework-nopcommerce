package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.BasePageFactory;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
    private WebDriver driver;
    
    public RegisterPageObject(WebDriver driver) {
   	 this.driver = driver;
   	 PageFactory.initElements(driver, this);
    }
   	 @FindBy(id = "Email")
   	 private WebElement emailTextbox;
   	@FindBy(id = "FirstName")
  	 private WebElement firstNameTextbox;
   	@FindBy(id = "LastName")
  	 private WebElement lastNameTextbox;
   	@FindBy(id = "Password")
  	 private WebElement passwordTextbox;
   	@FindBy(id = "ConfirmPassword")
  	 private WebElement confirmPasswordTextbox;
   	@FindBy(id = "register-button")
  	 private WebElement registerButton;
   	@FindBy(id = "FirstName-error")
  	 private WebElement firstNameErrorMessage;
   	@FindBy(id = "LastName-error")
  	 private WebElement lastNameErrorMessage;
   	@FindBy(id = "Email-error")
  	 private WebElement emailErrorMessage;
   	@FindBy(id = "Password-error")
  	 private WebElement passwordlErrorMessage;
   	@FindBy(id = "ConfirmPassword-error")
  	 private WebElement confirmPasswordlErrorMessage;
   	@FindBy(xpath = "//div[@class='result']")
  	 private WebElement registerSuccessMessage;
   	@FindBy(xpath = "//a[@class='ico-login']")
  	 private WebElement logoutLink;
   	@FindBy(id = "//div[contains(@class,'message-error')]//li")
  	 private WebElement existingEmailErrorMessage;
   	@FindBy(id = "//a[contains(@class,'register-continue-button')]")
  	 private WebElement continueButton;
   	
   	//PageObject/Action
   	public void clickToRegisterButton() {
		waitForElementClickAble(driver,registerButton);
		clickToElement(driver, registerButton); 
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver,  firstNameErrorMessage);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver,passwordlErrorMessage);
		return getElementText(driver, passwordlErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordlErrorMessage);
		return getElementText(driver,confirmPasswordlErrorMessage );
	}

	public void inputToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeyToElement(driver, firstNameTextbox, firstname);
	}

	public void inputToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, lastNameTextbox);
		sendKeyToElement(driver, lastNameTextbox, lastname);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);
		
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, emailAddress);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendKeyToElement(driver, confirmPasswordTextbox, confirmPassword);
		
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLoginButton() {
		waitForElementClickAble(driver,logoutLink);
		clickToElement(driver, logoutLink); 
		
	}

	public String getErrorMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
	return getElementText(driver, existingEmailErrorMessage);
}

	public void clickToContinueButton() {
		waitForElementClickAble(driver, continueButton);
		clickToElement(driver, continueButton);
		
	}
    
}