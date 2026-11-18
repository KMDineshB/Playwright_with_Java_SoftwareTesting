package day2;

import com.microsoft.playwright.*;

public class context {
    public static void main(String[] args) {
    	// multiple page open 
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions()
                .setHeadless(false)
        );

        // Create Context 1
        BrowserContext context1 = browser.newContext();

        // Create Page 1
        Page page1 = context1.newPage();

        page1.navigate("https://www.google.com");

        // Create Context 2
        BrowserContext context2 = browser.newContext();

        // Create Page 2
        Page page2 = context2.newPage();

        page2.navigate("https://www.youtube.com");

        browser.close();
        playwright.close();
    }
}
