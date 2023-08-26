package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Register_Apply_BasePage_Cach2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	// Declare (Khai bao)
	BasePage basePage;
	// BasePage: la class
	// basePage: la Object

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

		// Initial (Khoi tao)
		//Che giaus ddi viec khoi tao cua mot doi tuong
		basePage = BasePage.getBasePageObject();

		emailAddress = "minhthu" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_01_Register_Empty_Data() {
		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-errorr']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Minh");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Thu");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", "1234@123.!");
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Minh");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Thu");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");

		basePage.waitForElementClickAble(driver, "//a[@class='ico-login']");
		basePage.clickToElement(driver, "//a[@class='ico-login'");

	}

	@Test
	public void TC_04_Register_Existing_Email() {
		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Minh");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Thu");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"),
				"The specified email already exists");

	}

	@Test
	public void TC_05_Register_PassWord_Less_Than_6_Characters() {
		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Minh");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Thu");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", "minhthu" + generateFakeNumber() + "@gmail.com");
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "1236");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "1236");

		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {

		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Minh");
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Thu");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", "minhthu" + generateFakeNumber() + "@gmail.com");
		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "1236");

		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
