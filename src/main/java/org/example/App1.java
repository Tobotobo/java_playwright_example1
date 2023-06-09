package org.example;

import com.microsoft.playwright.*;

// https://playwright.dev/java/docs/intro
public class App1 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            //Browser browser = playwright.chromium().launch();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }
    }
}