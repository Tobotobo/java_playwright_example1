package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

// https://playwright.dev/java/docs/codegen-intro
public class App4 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://demo.playwright.dev/todomvc/");
            page.navigate("https://demo.playwright.dev/todomvc/#/");
            page.getByPlaceholder("What needs to be done?").click();
            page.getByPlaceholder("What needs to be done?").fill("aaa");
            page.getByPlaceholder("What needs to be done?").press("Enter");
        }
    }
}