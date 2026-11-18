package day2;
import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class Trace {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                    .setHeadless(false)
            );

            BrowserContext context = browser.newContext();

            // Start tracing
            context.tracing().start(
                new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true)
            );

            Page page = context.newPage();

            // Open website
            page.navigate("https://letcode.in/edit");

            // Perform actions
            page.locator("#fullName").fill("Dinesh");

            page.locator("#join").fill("dinesh@gmail.com");

            page.waitForTimeout(2000);

            // Save trace file
            context.tracing().stop(
                new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip"))
            );

            context.close();
            browser.close();

            System.out.println("Trace saved successfully!");
        }
    }
}

