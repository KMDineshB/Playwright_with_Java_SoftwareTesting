
package Day3;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

public class interact {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = null;

        try {

            LaunchOptions setHeadless =
                    new BrowserType.LaunchOptions().setHeadless(false);

            browser = playwright.chromium().launch(setHeadless);

            Page page = browser.newPage();

            // Navigate to website
            page.navigate("https://letcode.in/elements");

            // Enter username
            page.getByPlaceholder("Enter name : ").fill("orthonikc");

            // Click search button
            page.locator("id=dearch").click();

            // Locate links
            Locator links = page.locator("ol li a");

            // Wait for last link
            links.last().waitFor(
                    new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.ATTACHED)
                            .setTimeout(20000)
            );

            // Count links
            int count = links.count();

            System.out.println("Count : " + count);

            // Print all link texts
            for (int i = 0; i < count; i++) {

                String textcontent = links.nth(i).textContent();

                System.out.println(textcontent);
            }

        } finally {

            if (browser != null) {
                browser.close();
            }

            playwright.close();
        }
    }

	}
