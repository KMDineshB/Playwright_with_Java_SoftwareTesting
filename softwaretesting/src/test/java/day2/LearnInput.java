package day2;
import com.microsoft.playwright.*;
public class LearnInput {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create(); 

            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));

            Page page = browser.newPage();

            // Open website
            page.navigate("https://letcode.in/edit");

            // Enter text into input field
            Locator nameInput = page.locator("#fullName");
            nameInput.fill("Dinesh");

            // Append text
            page.locator("#join").fill(" I am learning Playwright");

            // Get input value
            String value = page.locator("#getMe").inputValue();
            System.out.println("Input Value: " + value);

            // Clear input field
            page.locator("#clearMe").clear();

            // Read attribute value
            String attribute = page.locator("#getMe")
                    .getAttribute("value");
            System.out.println("Attribute: " + attribute);

            // Type text character by character
            page.locator("#fullName")
                    .pressSequentially(" Kumar");

            System.out.println("Input interaction completed!");

//            browser.close();
        }
    
}

