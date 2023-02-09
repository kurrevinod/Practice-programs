package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Samplsite {
	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
	
System.setProperty("webdriver.gecko.driver","F:\\Selenium\\geckodriver.exe");
System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\driver chrome\\chromedriver.exe");
driver=new ChromeDriver();

driver.get("https://www.toolsqa.com");
driver.manage().window().maximize();
//driver.wait(15);
Thread.sleep(5000);
driver.manage().window().minimize();
Thread.sleep(5000);
driver.manage().window().maximize();
System.out.println(driver.getCurrentUrl());
//System.out.println(driver.getPageSource());
System.out.println(driver.getTitle());
/*
 * Select select =new Select(driver.findElement(By.id("")));
 * select.selectByIndex(' '); WebElement element=driver.findElement(By.id(" "));
 * Actions action=new Actions(driver); action.dragAndDrop(element,
 * element).build().perform();
 * 
 * JavascriptExecutor js=(JavascriptExecutor)driver; js.executeScript("")
 */

//driver.close();
}
}