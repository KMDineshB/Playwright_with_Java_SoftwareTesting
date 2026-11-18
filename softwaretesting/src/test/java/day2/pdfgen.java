package day2;


import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class pdfgen {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                    .setHeadless(true)
            );

            Page page = browser.newPage();

            page.navigate("https://letcode.in/");

            page.pdf(new Page.PdfOptions()
                .setPath(Paths.get("D:\\LetCode.pdf"))
                .setFormat("A4")
                .setPrintBackground(true));

            System.out.println("PDF generated successfully!");

            browser.close();
        }
    }
}
