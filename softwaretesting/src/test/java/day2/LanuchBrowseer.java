package day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LanuchBrowseer {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch( //webkit , firefox
				new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();    //ownbrowsr -> setchannel("chrome")
		page.navigate("https://letcode.in/edit");
		String title = page.title();
		System.out.println("Tilte "+ title);
		
		page.close();
		browser.close();
		playwright.close();
	}

}
