package day2;

public class DemoGuru99 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Guru99Project guru = new Guru99Project();
		
		guru.invokeBrowser();
		
		guru.loginToApplication("mngr291493", "apabybE");
		
		String titleOFThePage = guru.getTitle();
		
		System.out.println("Title of the page - "+ titleOFThePage);
		
		guru.logout();
		
		guru.closeBrowser();
		
	}

}