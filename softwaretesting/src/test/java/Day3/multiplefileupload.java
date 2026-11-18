package Day3;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class multiplefileupload {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.sendgb.com/");
        page.locator("button:has-text('Close')>> visible=true").click();
        page.locator("span:has-text('OK')>>visible=true").click();
        
        page.locator("input[type='false']").setInputFiles(new Path[] {
        		Paths.get("sample.txt"),
        		Paths.get("sec.xlxs")
        });
	}
}
