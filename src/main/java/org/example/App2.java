package org.example;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

// https://playwright.dev/java/docs/intro
public class App2 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      //Browser browser = playwright.webkit().launch();
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
      Page page = browser.newPage();
      page.navigate("https://playwright.dev/");
      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
    }
  }
}