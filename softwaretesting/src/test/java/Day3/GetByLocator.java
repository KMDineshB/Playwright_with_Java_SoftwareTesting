package Day3;

import com.microsoft.playwright.*;

public class GetByLocator {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                    .setHeadless(false)
            );

            Page page = browser.newPage();

            page.navigate("https://letcode.in/edit");

            // ID / CSS Locator
            page.locator("#fullName").fill("Dinesh");

            // Placeholder Locator
            page.getByPlaceholder("Enter your name")
                .fill("Dinesh Kumar");

            // Text Locator
            page.getByText("Clear me").click();

            // XPath Locator
            page.locator("//input[@id='join']")
                .fill("Hello Playwright");

            browser.close();
        }
    }
}
