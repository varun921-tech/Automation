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


//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.safari.SafariOptions;
//
//import java.time.Duration;
//
//public class DriverManager {
//    private static DriverManager instance;
//    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
//
//    private DriverManager() {
//    }
//
//    public static synchronized DriverManager getInstance() {
//        if (instance == null) {
//            instance = new DriverManager();
//        }
//        return instance;
//    }
//
//    public WebDriver initializeDriver(BrowserType browserType) {
//        WebDriver driver;
//
//        switch (browserType) {
//            case CHROME:
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--start-maximized");
//                chromeOptions.addArguments("--disable-notifications");
//                driver = new ChromeDriver(chromeOptions);
//                break;
//
//            case FIREFOX:
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.addArguments("--start-maximized");
//                driver = new FirefoxDriver(firefoxOptions);
//                break;
//
//            case EDGE:
//                EdgeOptions edgeOptions = new EdgeOptions();
//                edgeOptions.addArguments("--start-maximized");
//                driver = new EdgeDriver(edgeOptions);
//                break;
//
//            case SAFARI:
//                SafariOptions safariOptions = new SafariOptions();
//                driver = new SafariDriver(safariOptions);
//                break;
//
//            case CHROME_HEADLESS:
//                ChromeOptions headlessChromeOptions = new ChromeOptions();
//                headlessChromeOptions.addArguments("--headless");
//                headlessChromeOptions.addArguments("--window-size=1920,1080");
//                driver = new ChromeDriver(headlessChromeOptions);
//                break;
//
//            default:
//                throw new IllegalArgumentException("Browser type not supported: " + browserType);
//        }
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().window().maximize();
//
//        driverThreadLocal.set(driver);
//        return driver;
//    }
//
//    public WebDriver getDriver() {
//        WebDriver driver = driverThreadLocal.get();
//        if (driver == null) {
//            throw new IllegalStateException("WebDriver has not been initialized. Call initializeDriver() first.");
//        }
//        return driver;
//    }
//
//    public void quitDriver() {
//        WebDriver driver = driverThreadLocal.get();
//        if (driver != null) {
//            driver.quit();
//            driverThreadLocal.remove();
//        }
//    }
//
//    public enum BrowserType {
//        CHROME,
//        FIREFOX,
//        EDGE,
//        SAFARI,
//        CHROME_HEADLESS
//    }
//}