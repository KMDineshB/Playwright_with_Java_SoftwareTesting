package day2;

import com.microsoft.playwright.*;

public class httpAuth {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch();
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setHttpCredentials("admin","admin"));
		Page page = context.newPage();
		page.navigate("https://the-internet.herokuapp.com/basic_auth");
		System.out.println(page.locator("h3").textContent());
		playwright.close();
	}

}
