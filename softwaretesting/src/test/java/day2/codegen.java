package day2;


import com.microsoft.playwright.*;

public class codegen {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                    .setHeadless(false)
            );

            Page page = browser.newPage();

            page.navigate("https://letcode.in/login");

            // Opens Playwright Inspector
            page.pause();

            page.locator("#fullName").fill("Dinesh");

            page.locator("#join").fill("Hello Playwright");

            browser.close();
        }
    }
}

