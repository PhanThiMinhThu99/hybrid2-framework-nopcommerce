package com.liveguru.user;

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
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		
	}

	@Test
	public void User_01_Register_To_System() {
		
	}

	@Test
	public void User_02_Login_To_System() {
		
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
