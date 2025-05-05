package driver;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver(String browser) {
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        if (webDriver.get() == null) {
            webDriver.set(DriverFactory.createDriver(browserType));
        }
        configureDriver(webDriver.get());
        return webDriver.get();
    }

    private static void configureDriver(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        WebDriver driver = webDriver.get();
        if (driver != null) {
            driver.quit();
            webDriver.remove();
        }
    }
}

