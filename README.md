# java_playwright_example1

Playwright for Java  
https://playwright.dev/java/docs/intro


## メモ

サポートされているすべてのブラウザを表示
```
./mvnw exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install --help"
```
```
～～～
    Install custom browsers, supports chromium, chrome, chrome-beta, msedge, msedge-beta, msedge-dev, firefox, webkit.
```


指定のブラウザとOSの依存関係をインストール  
※以下は MS Edge
```
./mvnw exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install --with-deps msedge"
```

既にインストールされている場合は already でエラーになるので、バージョンを上げたい場合などは、一度アンインストールするか ```--force``` オプションをつける。
```
./mvnw exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install --force --with-deps msedge"
``` 

指定のブラウザで実行
※以下は MS Edge
```java
import com.microsoft.playwright.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      // Channel can be "chrome", "msedge", "chrome-beta", "msedge-beta" or "msedge-dev".
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
      Page page = browser.newPage();
      // ...
    }
  }
}
```

ブラウザを表示した状態で実行する
```java
Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
```

テストジェネレーター  
https://playwright.dev/java/docs/codegen-intro
```
./mvnw exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen demo.playwright.dev/todomvc"
```

トレースビューア  
https://playwright.dev/java/docs/trace-viewer-intro  
→ トレースの記録 App5.java → trace.zip が作成される  
→ 以下で trace.zip を表示 
```
./mvnw exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace ./output/trace.zip"
```