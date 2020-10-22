package day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static void waitTillElementVisible(WebDriver driver, int timeout, By by) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void waitTillALertIsPresent(WebDriver driver, int timeOutInSeconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
		webDriverWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void waitTillElementIsClickable(WebDriver driver, int timeOutInSeconds, By by) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static void fluentWait(WebDriver driver, int timeout, int pollingTime, By by) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}	
}
