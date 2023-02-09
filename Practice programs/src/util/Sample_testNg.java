package util;

import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;




public class Sample_testNg {
	public static WebDriver driver;

	@Parameters("Browser")
	@BeforeTest()
	public static void launchBrower(String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\driver chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(Browser +" : Browser launched sucessfully");
		}
		else { Browser.equalsIgnoreCase("firefox")
; 
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			System.out.println(Browser +" : Browser launched sucessfully");
		}
	}

	@Test
	public static void login() throws Exception {
		driver.get("https://qa-view.prebill-kdvlaw.com/login");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("vinod");
		// driver.findElement(By.xpath("//*[@name='password']")).sendKeys("vinod"); 
		driver.findElement(By.id("password")).sendKeys("vinod");
		driver.findElement(By.xpath("//*[text()='SIGN IN']")).click();
		System.out.println("Logged sucessfully");

		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement w1 = driver.findElement(By.xpath("//*[@href='/email-prebill']"));
		Actions a1 = new Actions(driver);
		a1.contextClick(w1).perform();
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_DOWN);
		r1.keyPress(KeyEvent.VK_ENTER);
		System.out.println("Test run sucessfully");

		Thread.sleep(3000);
		/*
		 * ArrayList<String> a11=new ArrayList<String>(driver.getWindowHandles());
		 * driver.switchTo().window(a11.get(1));
		 */

		String parenWindow = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		for (String window : childWindow) {
			if (!(parenWindow.equals(childWindow))) {
				driver.switchTo().window(window);
			}
		}
		/*
		 * Iterator<String> iterator=childWindow.iterator();
		 * 
		 * 
		 * 
		 * while(iterator.hasNext())
		 * 
		 * { String itr=iterator.next(); if(!(parenWindow.equals(childWindow))) {
		 * driver.switchTo().window(itr);
		 * //driver.findElement(By.xpath("//*[@id='carrier']")).click();
		 * 
		 * }
		 * 
		 * }
		 */

		// driver.quit();
	}
		@AfterTest
		public static void browserValue()
		{
			
		}
		
	

}
