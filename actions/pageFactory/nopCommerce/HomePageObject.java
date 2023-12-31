package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
    private WebDriver driver;
    
    public HomePageObject(WebDriver driver) {
   	 this.driver = driver;
   	 PageFactory.initElements(driver, this);
    }
    //Page UI
   @FindBy(how = How.XPATH, using ="//a[@class='ico-register']")
    private WebElement registerLink;
   
   @FindBy (xpath = "//a[@class='ico-register']")
   private WebElement loginLink;
   
   @FindBy (css = "a[class='ico-register']")
   private WebElement myAccountLink;
   
   //Page Object/Action
   public void clickToRegisterLink() {
	   waitForElementClickAble(driver,registerLink );
	   clickToElement(driver, registerLink);
   }
   public void clickToLoginLink() {
     waitForElementClickAble(driver, loginLink);
     clickToElement(driver, loginLink);
   }
   
   
}