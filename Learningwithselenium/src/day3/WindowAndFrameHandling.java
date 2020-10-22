package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAndFrameHandling {
	ChromeDriver driver;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
	}
	public void clickTrybutton() {
		String parentwindowString= driver.getWindowHandle();
		System.out.println("Parent Window" +parentwindowString);
		
		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[text() ='Try it']").click();
		
		String childString = driver.getWindowHandles().toArray().toString();
		System.out.println("Child Window" +childString);
		
		driver.switchTo().window(childString);
		System.out.println("Title of child window "+ driver.getTitle());	
		driver.close();
		driver.switchTo().window(parentwindowString);
		System.out.println("Title of parent window "+ driver.getTitle());
		driver.quit();
	}
	public static void main(String[] args) {
		WindowAndFrameHandling windowAndFrameHandling = new WindowAndFrameHandling();
		windowAndFrameHandling.invokeBrowser();
		windowAndFrameHandling.clickTrybutton();
	}
}
