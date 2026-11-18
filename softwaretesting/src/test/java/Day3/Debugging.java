/**
 * 
 */
package Day3;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.*;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

/**
 * 
 */
public class Debugging {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


        Playwright playwright = Playwright.create();

        BrowserType.LaunchOptions options =
            new BrowserType.LaunchOptions().setHeadless(false);

        Browser browser = playwright.chromium().launch(options);

        Page page = browser.newPage();

        // 1. Navigate to website
        page.navigate("https://the-internet.herokuapp.com/");
        
        page.pause();

        // 2. Print title
        System.out.println("Title: " + page.title());

        // 3. Print URL
        System.out.println("URL: " + page.url());

        // 4. Text Locator - Click Form Authentication
        page.getByText("Form Authentication").click();

        // 5. ID Locator - Username
        page.locator("#username").fill("tomsmith");

        // 6. ID Locator - Password
        page.locator("#password").fill("SuperSecretPassword!");

        // 7. Role Locator - Login Button
        page.getByRole(AriaRole.BUTTON,
            new Page.GetByRoleOptions().setName("Login")).click();

        // 8. Verify Login Message
        System.out.println(
            page.locator("#flash").textContent()
        );

        // 9. Check Logout Button
        System.out.println(
            "Logout visible: " +
            page.getByText("Logout").isVisible()
        );

        // 10. Screenshot
        page.screenshot(new Page.ScreenshotOptions()
            .setPath(java.nio.file.Paths.get("login.png")));

        // 11. Logout
        page.getByText("Logout").click();

        // 12. Print final URL
        System.out.println("Final URL: " + page.url());

        // 13. Close Browser
        browser.close();
        playwright.close();
  
	}

}
