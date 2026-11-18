
package Day3;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class LearnLocator {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page = browser.newPage();

        page.navigate("https://letcode.in/test");

        // 1. URL
        System.out.println("URL: " + page.url());

        // 2. Text Locator
        page.locator("text=Click").first().click();

        // 3. CSS Locator
        page.locator("a").first().click();
        page.goBack();

        // 4. ID Locator
        page.locator("#home").click();

        // 5. Class Locator
        page.locator(".navbar-burger").click();

        // 6. Attribute Locator
        page.locator("[href='/test']").click();

        // 7. XPath Locator
        page.locator("//a[contains(text(),'Click')]").click();

        // 8. Get By Text
        page.getByText("Click", new Page.GetByTextOptions()
            .setExact(true)).click();

        // 9. Get By Role
        page.getByRole(AriaRole.LINK,
            new Page.GetByRoleOptions().setName("Click")).click();

        // 10. Get By Placeholder
        // Example on the Edit page:
        page.navigate("https://letcode.in/edit");
        page.getByPlaceholder("Enter your name").fill("Dinesh");

        // 11. Get By Label
        page.getByLabel("Clear me").fill("Playwright Java");

        // 12. Input Locator
        page.locator("input").first().fill("Hello");

        // 13. Button Locator
        page.locator("button").first().click();

        // 14. Count
        System.out.println("Inputs: " +
            page.locator("input").count());

        // 15. Visibility
        System.out.println("Visible: " +
            page.locator("input").first().isVisible());

        // 16. Enabled
        System.out.println("Enabled: " +
            page.locator("input").first().isEnabled());

        // 17. Attribute
        System.out.println("Attribute: " +
            page.locator("input").first().getAttribute("placeholder"));

        // 18. Text Content
        System.out.println("Text: " +
            page.locator("h1").textContent());

        // 19. Hover
        page.locator("input").first().hover();

        // 20. Focus
        page.locator("input").first().focus();

        // 21. Clear
        page.locator("input").first().clear();

        // 22. Press
        page.locator("input").first().press("Enter");

        // 23. Screenshot
        page.screenshot(new Page.ScreenshotOptions()
            .setPath(java.nio.file.Paths.get("locator.png")));

        browser.close();
        playwright.close();
    }
}
