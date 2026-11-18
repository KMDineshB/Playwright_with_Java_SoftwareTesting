package Day3;

import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenshotCaret;

public class Screenshot {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false));
	Page page=browser.newPage();
	page.navigate("https://github.com/kmdineshb763/library-Management-java-project-restAPI/");
	page.screenshot(new ScreenshotOptions().setPath(Paths.get("")));
	page.screenshot(new ScreenshotOptions().setPath(Paths.get("")).setFullPage(true));
	
	Locator searchLocator= page.getByPlaceholder("Search");
	searchLocator.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(" "))
			.setCaret(ScreenshotCaret.HIDE)
			.setMask(Arrays.asList(searchLocator)));
	playwright.close();
	}
}
