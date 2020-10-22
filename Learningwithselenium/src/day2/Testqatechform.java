package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testqatechform {
	ChromeDriver driver;
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver" ,"F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test.qatechhub.com/form-elements/");
	}
	
	public void formfill() {
		driver.findElementByName("wpforms[fields][1][first]").sendKeys("Sonalika");
		driver.findElementByName("wpforms[fields][1][last]").sendKeys("Gupta");
		
		String emaiString = "ss" + System.currentTimeMillis() + "abc@gmail.com";
		driver.findElementByName("wpforms[fields][2]").sendKeys(emaiString);
		driver.findElement(By.name("wpforms[fields][4]")).sendKeys("9999999999");
		driver.findElement(By.xpath("//input[@value=\"Female\"]")).click();
		
		WebElement dropElement = driver.findElement(By.name("wpforms[fields][5]"));
		Select accountType = new Select(dropElement);
		accountType.selectByVisibleText("Cypress");
		driver.findElement(By.xpath("//button[@value=\"wpforms-submit\"]")).click();
			
	}
	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) {
		Testqatechform testqatechform = new Testqatechform();
		testqatechform.invokeBrowser();
		testqatechform.formfill();
		testqatechform.closeBrowser();
	}
}
