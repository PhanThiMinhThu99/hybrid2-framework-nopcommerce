package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	
protected WebDriver getBrowserDriver(String browserName) {
	if (browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
	} else if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		driver = new ChromeDriver();
	} else if (browserName.equals("edge")) {
		System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
		driver = new EdgeDriver();
	}else if (browserName.equals("opera")) {
		System.setProperty("webdriver.opera.driver", projectPath + "/browserDrivers/operadriver");
		driver = new OperaDriver();
	}
	
	else {
       throw new RuntimeException("Browser name invalid");
	}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://demo.nopcommerce.com/");
	return driver;
}
}
