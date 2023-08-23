package xped.automation.util.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver implements IWebDriver {

    private final ChromeOptions chromeOpt;

    public ChromeWebDriver() {
        chromeOpt = new ChromeOptions();
    }

    @Override
    public WebDriver setUpWebDriver() {
        WebDriverManager.chromedriver().setup();
        chromeOpt.addArguments("--start-maximized");
        chromeOpt.addArguments("--disable-gpu");
        chromeOpt.addArguments("--no-sandbox");
        chromeOpt.addArguments("--ignore-certificate-errors");
        chromeOpt.addArguments("--disable-popup-blocking");
        chromeOpt.addArguments("--window-size=1920,1080");
        chromeOpt.addArguments("--disable-dev-shm-usage");
        chromeOpt.addArguments("--lang=es");
        return new ChromeDriver(chromeOpt);
    }
}
