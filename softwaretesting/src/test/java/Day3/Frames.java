
package Day3;

import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.*;

public class Frames {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://letcode.in/frame");
//        way1
        // Switch to iframe
        Frame frame = page.frame("firstFr");

        // Enter Name
        frame.getByPlaceholder("Enter Name").fill("Dinesh");

        // Enter Email
        frame.getByPlaceholder("Enter email").fill("Dinesh@gmail.com");
        
//        Frame innerframe = page.frameByUrl(Pattern.compile("innerFrame"));
//        innerframe.getByPlaceholder("Enter mail").type("dinesh@gmail.com");
        
        
        
//        way 2 
        List<Frame> childFrame=frame.childFrames();
        childFrame.forEach(f->{
        	System.out.println(f.url());
        });
       
//        Frame locator 
        page.frameLocator("#firstFr")
        .getByPlaceholder("Enter Name")
        .fill("Dinesh");
        
        Thread.sleep(5000);

        browser.close();
        playwright.close();
    }
}
