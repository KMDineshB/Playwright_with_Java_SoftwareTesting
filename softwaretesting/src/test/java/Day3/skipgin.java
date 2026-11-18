
package Day3;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class skipgin {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        // Open website
        page.navigate("https://bookcart.azurewebsites.net/");

        // Click Login
        page.locator("xpath=//span[normalize-space()='Login']/..").click();

        // Enter username
        page.locator("input[formcontrolname='username']")
                .fill("ortoni");

        // Enter password
        page.locator("input[formcontrolname='password']")
                .fill("YOUR_PASSWORD");

        // Click Login button
        page.locator("button[color='primary']").click();

        // Wait for successful login
        page.locator("button.mat-menu-trigger")
                .waitFor(new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE));

        // Generate authentication file
        context.storageState(
                new BrowserContext.StorageStateOptions()
                        .setPath(java.nio.file.Paths.get("auth.json"))
        );

        System.out.println("Authentication saved successfully!");

        browser.close();
        playwright.close();
    }
}
