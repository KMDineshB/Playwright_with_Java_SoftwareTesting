package day2;


import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class videorecord {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                    .setHeadless(false)
            );

            // Create context with video recording
            BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get("videos"))
                    .setRecordVideoSize(1280, 720)
            );

            Page page = context.newPage();

            // Open website
            page.navigate("https://letcode.in/edit");

            // Perform actions
            page.locator("#fullName").fill("Dinesh");

            page.locator("#join").fill("dinesh@gmail.com");

            page.waitForTimeout(3000);

            // Close context to save video
            context.close();

            browser.close();
            System.out.println("Video recording completed!");
        }
    }
}

