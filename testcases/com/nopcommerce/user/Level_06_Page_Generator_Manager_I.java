package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
	// Declare
	private String lastName, firstName, existingEmail, inValidEmail, emailNotFound, inValidPassword, passWord;
	private WebDriver driver;
	// Declare + Init
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);

		lastName = "Minh";
		firstName = "Thu";
		passWord = "123456";
		existingEmail = "minhthu" + generateFakeNumber() + "@gmail.com";
		inValidEmail = "minhthu@123.com@email";
		emailNotFound = "minhthuphanthi" + generateFakeNumber() + "@gmail.com";
		inValidPassword = "123";

		System.out.println("Pre-Condition - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();

		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(passWord);

		System.out.println("Pre-Condition - Step 03: Click to Register button");
		registerPage = registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-Condition - Step 05: Click to continue button");
		homePage = registerPage.clickToContinueButton();

	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		// Tu trang Home click to Login button--> Login Page
		loginPage = PageGeneratorManager.getLoginPage(driver);

		System.out.println("Login_01_Empty_Data - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_01_Empty_Data - Step 03: get error message");
		Assert.assertEquals(loginPage.getErrorMessageEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02_Invalid_Email - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		loginPage = PageGeneratorManager.getLoginPage(driver);
		System.out.println("Login_02_Invalid_Email - Step 02: Input Email address");
		loginPage.inputToEmailTextbox(inValidEmail);

		System.out.println("Login_02_Invalid_Email - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_02_Invalid_Email - Step 04: verify error message");
		Assert.assertEquals(loginPage.getErrorMessageEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		System.out.println("Login_03_Email_Not_Found - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		loginPage = PageGeneratorManager.getLoginPage(driver);
		System.out.println("Login_03_Email_Not_Found - Step 02: input email not found");
		loginPage.inputToEmailTextbox(emailNotFound);

		System.out.println("Login_03_Email_Not_Found - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_03_Email_Not_Found - Step 04: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		System.out.println("Login_04_Existing_Email_Empty_Password - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		loginPage = PageGeneratorManager.getLoginPage(driver);
		System.out.println("Login_04_Existing_Email_Empty_Password - Step 02: Input existing email");
		loginPage.inputToEmailTextbox(existingEmail);

//		System.out.println("Login_04_Existing_Email_Empty_Password - Step 03: Input empty password");
//		loginPage.inputToPasswordTextbox("");

		System.out.println("Login_04_Existing_Email_Empty_Password - Step 04: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_04_Existing_Email_Empty_Password - Step 05: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		loginPage = PageGeneratorManager.getLoginPage(driver);
		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 02: input existing email");
		loginPage.inputToEmailTextbox(existingEmail);

		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 03: input incorrect password");
		loginPage.inputToPasswordTextbox(inValidPassword);

		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 04: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 05: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		System.out.println("Login_06_Valid_Email_Password - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		loginPage = PageGeneratorManager.getLoginPage(driver);
		System.out.println("Login_06_Valid_Email_Password - Step 02: input valid email");
		loginPage.inputToEmailTextbox(existingEmail);

		System.out.println("Login_06_Valid_Email_Password - Step 03: input valid password");
		loginPage.inputToPasswordTextbox(passWord);

		System.out.println("Login_06_Valid_Email_Password - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		// Login thanh cong-->HomePage
		System.out.println("Login_06_Valid_Email_Password - Step 05: Verify My Account link is displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isMyAccountLinkVisible());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
