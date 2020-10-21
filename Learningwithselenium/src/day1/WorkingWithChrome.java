package day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome {
	
	ChromeDriver driver;
	
	
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		
		//Maximize the browser's screen
		driver.manage().window().maximize();
		
		Dimension dim = new Dimension(1024, 680);
		
		driver.manage().window().setSize(dim);
		
		//Bypass all the existing cookies
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/v4");
		
		
	}

	public void navigateCommands() {
		
		driver.navigate().to("https://facebook.com");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
	}
	
	public void printTitleofThePage() {
		String title = driver.getTitle();
		
		System.out.println("The title of the page - "+ title);
	}
	
	public void closeBrowser() {

		//Closes the current active window or tab
		//driver.close();
		
		//Closes all the windows opened during session
		driver.quit();
	}

}