package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;
import java.nio.file.Paths;

// https://playwright.dev/java/docs/trace-viewer-intro
public class App5 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Browser browser = browserType.launch();
            // Browser browser = playwright.chromium().launch(new
            // BrowserType.LaunchOptions()
            // .setHeadless(false));
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
            BrowserContext context = browser.newContext();

            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
            page.navigate("https://playwright.dev");

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("./output/trace.zip")));
        }
    }
}
