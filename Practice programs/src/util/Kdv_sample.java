package util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Kdv_sample {

	public static WebDriver driver;

	
	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\driver chrome\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://qa-view.prebill-kdvlaw.com/login");

driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
driver.findElement(By.xpath("//*[@name='username']")).sendKeys("vinod");
		// driver.findElement(By.xpath("//*[@name='password']")).sendKeys("vinod"); 
		driver.findElement(By.id("password")).sendKeys("vinod");
		driver.findElement(By.xpath("//*[text()='SIGN IN']")).click();
		driver.manage().window().maximize();
	Thread.sleep(2000);
		WebElement w1=driver.findElement(By.xpath("//*[@href='/email-prebill']"));
		Actions a1 = new Actions(driver); 
		a1.contextClick(w1).perform(); 
		Robot r1 = new Robot(); 
		r1.keyPress(KeyEvent.VK_DOWN); 
		r1.keyPress(KeyEvent.VK_ENTER);
		
driver.quit();
	}

}
