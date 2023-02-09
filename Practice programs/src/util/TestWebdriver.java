package util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWebdriver {
	WebDriver driver;
	WebDriverWait wait;

	public TestWebdriver(String browserName) {		
		this.driver = getWebDriver(browserName);;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	private WebDriver getWebDriver(String browserName)
	{
		WebDriver driver = null;
		switch(browserName)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver1.exe");
			driver = new ChromeDriver();
			System.out.println("Opened chromebrowser");
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver","F:\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("Opened firefoxbrowser");
			break;
			//		case "edge":
			//			System.out.println("Opened edgebrowser");
			//			break;
		default:
			System.out.println("Please provide valid browsername");
		}
		return driver;
	}
	
	
	public void navigateToUrl(String url)
	{
		driver.get(url);
		System.out.println("navigated to URL : "+url);
	}

	public void click(By by, String elementName) {

		WebElement element = getElement(by);
		element.click();
		System.out.println(elementName + " clicked sucessfully");
	}

	public WebElement getElement(By by) {
		waitUntilVisibilityOfElement(by);
		WebElement element = driver.findElement(by);

		return element;

	}

	public void setText(By by, String inputData, String elementName) {

		WebElement element = getElement(by);
		element.sendKeys(inputData);
		System.out.println(elementName + ": " + inputData + " entered sucessfully");

	}

	public void waitUntilVisibilityOfElement(By by) {
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (WebDriverException e) {

			System.err.println("element " + by + "is not visible in given time");
		}
	}
}
