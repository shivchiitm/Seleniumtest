package day1;

public class DemoWorkingWithChrome {
	
	public static void main(String[] args) {
		
		WorkingWithChrome wc = new WorkingWithChrome();
		
		wc.invokeBrowser();
		
		wc.printTitleofThePage();
		wc.navigateCommands();
		
		wc.closeBrowser();
	}

}