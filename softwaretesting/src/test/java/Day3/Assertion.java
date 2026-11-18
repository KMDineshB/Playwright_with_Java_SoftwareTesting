
package Day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.setDefaultAssertionTimeout;
public class Assertion {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to LetCode
            page.navigate("https://letcode.in/edit");

            // Locate heading
            Locator header = page.locator("h1");

            // Assertions
            setDefaultAssertionTimeout(10000);
            assertThat(page).hasTitle("Interact With Input Fields");
            assertThat(page).hasURL("https://letcode.in/edit");
            assertThat(header).hasText("Input");
            assertThat(page.locator("#join"))
            .hasAttribute("placeholder", "I am Good Boy");

            page.navigate("https://letcode.in/radio");
            assertThat(page.locator("#notfoo")).not().isChecked();
            System.out.println("All assertions passed!");

 
            browser.close();
            playwright.close();
        
    }
}
