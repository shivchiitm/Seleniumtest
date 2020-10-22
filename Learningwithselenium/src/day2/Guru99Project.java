package day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99Project {

	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		// Maximize the browser's screen
		driver.manage().window().maximize();

		// Bypass all the existing cookies
		driver.manage().deleteAllCookies();

		driver.get("http://demo.guru99.com/v4");

	}

	public void loginToApplication(String username, String password) {

		// Identifying an element
		WebElement userIdElement = driver.findElementByName("uid");

		userIdElement.clear();

		// Performing an action
		userIdElement.sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

	}

	public String getTitle() {

		return driver.getTitle();
	}
	
	public void addCustomer() {
		driver.findElementByLinkText("New Customer").click();
	}
	
	public void logout() throws InterruptedException {
		driver.findElement(By.linkText("Log out")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
	}

	public void closeBrowser() {
		driver.quit();
	}

}