package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EbayProject {
	ChromeDriver driver;
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// Maximize the browser's screen
		driver.manage().window().maximize();
		// Bypass all the existing cookies
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ebay.in");
	}
	
	public void selectAValueFromSubMenu() {
		WebElement webElement = driver.findElement(By.linkText("Electronics"));
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).build().perform();
		
		WaitUtility.waitTillElementVisible(driver, 10, By.linkText("Smart Watches"));
		WebElement webElement2 = driver.findElementByLinkText("Smart Watches");
		actions.moveToElement(webElement2).click().build().perform();
	}
	
	public static void main(String[] args) {
		EbayProject ebayProject = new EbayProject();
		ebayProject.invokeBrowser();
		ebayProject.selectAValueFromSubMenu();	
	}
	
}
