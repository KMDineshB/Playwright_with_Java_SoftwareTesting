package day2;

import com.microsoft.playwright.*;

public class alert {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page = browser.newPage();

        page.onDialog(dialog -> {
            System.out.println("Alert Message: " + dialog.message());
            dialog.accept();
        });

        page.navigate("https://letcode.in/alert");

        page.locator("#accept").click(); // prompt , modern , simple 

//        browser.close();
//        playwright.close();
    }
}
