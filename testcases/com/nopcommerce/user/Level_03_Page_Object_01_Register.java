package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_01_Register{
	//Declare
	private String lastname, firstname, password, emailAddress;
	private WebDriver driver;
	//Declare + Init
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		//Dang o man hinh HomePage va khoi tao
		homePage = new HomePageObject(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		lastname = "Minh";
		firstname = "Thu";
		password = "123456";
		emailAddress = "minhthu" + generateFakeNumber() + "@gmail.com";
		

	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		
       //Click vao Register link --> nhay qua trang Register
        registerPage = new RegisterPageObject(driver);

		System.out.println("Register_01 - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {

		System.out.println("Register_02 - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		//Click vao Register link --> nhay qua trang Register
        registerPage = new RegisterPageObject(driver);
		
		System.out.println("Register_02 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputToEmailTextbox("1234@123.!");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		


		System.out.println("Register_02 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();


		System.out.println("Register_02 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Success() {
		System.out.println("Register_03 - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		
		//Click vao Register link --> nhay qua trang Register
        registerPage = new RegisterPageObject(driver);
        
		System.out.println("Register_03 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		

		System.out.println("Register_03 - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Register_03 - Step 05: Click to Register button");
		registerPage.clickToLoginButton();
	}

	@Test
	public void Register_04_Existing_Email() {
		
		System.out.println("Register_04 - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		
		//Click vao Register link --> nhay qua trang Register
        registerPage = new RegisterPageObject(driver);

	    
	    System.out.println("Register_04 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_PassWord_Less_Than_6_Characters() {
		System.out.println("Register_05 - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		
		//Click vao Register link --> nhay qua trang Register
        registerPage = new RegisterPageObject(driver);
		
		System.out.println("Register_05 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputToEmailTextbox("minhthu" + generateFakeNumber() + "@gmail.com");
		registerPage.inputToPasswordTextbox("1236");
		registerPage.inputToConfirmPasswordTextbox("1236");

		System.out.println("Register_05 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
	
		System.out.println("Register_05 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password must meet the following rules:\\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {

//		waitForAllElementClickable(driver, "//a[@class='ico-register']");
//		clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Register_06 - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		
		//Click vao Register link --> nhay qua trang Register
        registerPage = new RegisterPageObject(driver);
        
        
//		sendKeyToElement(driver, "//input[@id='FirstName']", "Minh");
//		sendKeyToElement(driver, "//input[@id='LastName']", "Thu");
//		sendKeyToElement(driver, "//input[@id='Email']", "minhthu" + generateFakeNumber() + "@gmail.com");
//		sendKeyToElement(driver, "//input[@id='Password']", "123456");
//		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "1236");
		
		System.out.println("Register_06 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputToEmailTextbox("minhthu" + generateFakeNumber() + "@gmail.com");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("1236");

//		waitForAllElementClickable(driver, "//button[@id='register-button']");
//		clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register_06 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
//				"The password and confirmation password do not match.");
		System.out.println("Register_06 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "The password and confirmation password do not match.");

	}


	@AfterClass
	public void afterClass() {
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
