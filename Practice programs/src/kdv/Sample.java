package kdv;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.TestWebdriver;


public class Sample {
	public static WebDriver driver;
	public static void main(String args[])  {

		By usernameBy = By.id("username");
		By passwordBy = By.id("password");
		By signInBy = By.xpath("//span[contains(text(),'sign in')]");

		TestWebdriver testDriver = new TestWebdriver("chrome");



		String baseUrl = "https://qa-view.prebill-kdvlaw.com";
		testDriver.navigateToUrl(baseUrl);
		String actualTitle = driver.getTitle();
		if(actualTitle.equalsIgnoreCase(baseUrl))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("not matched");
		}
		testDriver.setText(usernameBy, "vinod", "Username");
		testDriver.setText(passwordBy, "vinod", "Password");
		testDriver.click(signInBy, "SignIn Button");
		driver.close();
	}

}
