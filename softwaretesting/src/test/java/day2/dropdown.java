package day2;



import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;


public class dropdown {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));

            Page page = browser.newPage();

            // Open dropdown page
            page.navigate("https://letcode.in/dropdowns");

            // 1. Select by visible label
            page.locator("#fruits").selectOption(
                    new SelectOption().setLabel("Apple")
            );

            // 2. Select by value
            page.locator("#superheros").selectOption("aq");

            // 3. Select multiple options
            page.locator("#lang").selectOption(
                    new String[]{"java", "js", "python"}
            );

            // 4. Select by index
            page.locator("#country").selectOption(
                    new SelectOption().setIndex(2)
            );

            // 5. Get selected value
            String selectedValue =
                    page.locator("#fruits").inputValue();

            System.out.println("Selected Fruit: " + selectedValue);

            // 6. Get selected option text
            String selectedText = page.locator(
                    "#fruits option:checked"
            ).textContent();

            System.out.println("Selected Text: " + selectedText);

            System.out.println("Dropdown testing completed!");

            browser.close();
        }
    

    }
    }

