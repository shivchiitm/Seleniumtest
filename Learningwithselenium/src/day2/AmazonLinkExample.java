package day2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AmazonLinkExample {
	ChromeDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver" ,"F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
	public int Linkcount() {
		List<WebElement> linkcount = driver.findElements(By.tagName("a"));
		return linkcount.size();
	}
	
	public String getLinkUrl(String linkString) {
		WebElement linkElement = driver.findElementByLinkText(linkString);
		return linkElement.getAttribute("href");
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void getAllLinkInfo() {
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		for (WebElement element : allLink) {
			System.out.println("Linktext - " + element.getText() + " and the URL is - " + element.getAttribute("href"));
			System.out.println("---------------------------------------------------------------------------------");
		}
	}
	
	public static void main(String[] args) {
		AmazonLinkExample amazonLinkExample = new AmazonLinkExample();
		amazonLinkExample.invokeBrowser();
		int linkCount = amazonLinkExample.Linkcount();
		System.out.println("Link Count - " + linkCount);
		String linkUrl = amazonLinkExample.getLinkUrl("Amazon Pay");
		System.out.println("Link URL - " + linkUrl);
		amazonLinkExample.closeBrowser();
	}
}
