package day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Amazonproject {
	ChromeDriver driver;
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver" ,"F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
	public void searchproduct(String Product, String catergory) {
		driver.findElementByXPath("//input[@id='twotabsearchtextbox']").sendKeys(Product);
		Select selcategory = new Select(driver.findElementByXPath("//select[@id='searchDropdownBox']"));
		selcategory.selectByVisibleText(catergory);
		driver.findElementByXPath("//input[@value='Go'])").click();
	}
	
	public String getSearchResult() {
		return driver.findElementByXPath("/html[1]/body[1]/div[1]/div[2]/span[1]/div[1]/span[1]/h1[1]/div[1]/div[1]/div[1]/div[1]/span[1]").getText();
	}
	
	public void getNthProduct(int itennumber) {
		
		String xpathexpressionString = String.format("//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result' and @data-index='%d']", itennumber);
		String nthproductdeatilString= driver.findElement(By.xpath(xpathexpressionString)).getText();
		System.out.println(nthproductdeatilString);
	}
	
	public void getAllProduct() {
		List<WebElement> allproductElements = driver.findElementsByXPath("//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result']");
		for(WebElement product:allproductElements) {
			System.out.println(product.getText());
			System.out.println("----------------------------------");
		}
	}
	
	public void getallprodcutsandscroll() {
		List<WebElement> allproductElements = driver.findElementsByXPath("//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result']");
		Actions actions = new Actions(driver);
		for(WebElement product:allproductElements) {
			actions.moveToElement(product).build().perform();
			System.out.println(product.getText());
			System.out.println("----------------------------------");
		}
	}
	
	public void getallproductviajs() {
		List<WebElement> allproductElements = driver.findElementsByXPath("//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result']");
		int xlocation, ylocation;
		for(WebElement product:allproductElements) {
			xlocation = product.getLocation().x;
			ylocation = product.getLocation().y;
			scrollBy(xlocation, ylocation);
			System.out.println(product.getText());
			System.out.println("----------------------------------");
		}
	}
	
	private void scrollBy(int x , int y) {
		JavascriptExecutor jsEnginExecutor;
		jsEnginExecutor = driver;
		String jscommandString = String.format("window.scrollBy(%d,%d", x,y);
		jsEnginExecutor.executeScript(jscommandString);
	}
	public void closeBrowser() {
		driver.quit();
	}
	

	public static void main(String[] args) {
		Amazonproject amazonproject = new Amazonproject();
		amazonproject.invokeBrowser();
		amazonproject.searchproduct("Apple Watch","Electronics" );
		amazonproject.getSearchResult();
		amazonproject.getNthProduct(10);
		amazonproject.getallproductviajs();
		amazonproject.closeBrowser();
	}
}
