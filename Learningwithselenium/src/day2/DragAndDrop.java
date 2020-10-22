package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	ChromeDriver driver;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://test.qatechhub.com/drag-and-drop/");
	}
	public void performDragAndDrop() {
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		String colorBeforeDnD = target.getCssValue("color");
		Actions actions = new Actions(driver);
		//actions.dragAndDrop(source, target);
		actions.moveToElement(source).clickAndHold(source).moveToElement(target).release(target).build().perform();
		String colorAfterDnD = target.getCssValue("color");
		System.out.println("Before Dnd - "+ colorBeforeDnD);
		System.out.println("After Dnd - "+ colorAfterDnD);
	}
	public void close() {
		driver.quit();
	}
	public static void main(String[] args) {
		DragAndDrop dragAndDrop = new DragAndDrop();
		dragAndDrop.invokeBrowser();
		dragAndDrop.performDragAndDrop();
		dragAndDrop.close();
	}
}
