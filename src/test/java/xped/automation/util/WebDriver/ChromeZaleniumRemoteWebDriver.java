package xped.automation.util.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeZaleniumRemoteWebDriver implements IWebDriver {

    private final String testName;
    private final String url;
    private final ChromeOptions cromeZaleniumOpt;

    public ChromeZaleniumRemoteWebDriver(String testName, String url) {
        this.testName = testName;
        this.url = url;
        cromeZaleniumOpt = new ChromeOptions();
    }

    public WebDriver setUpWebDriver() {
        RemoteWebDriver remoteWebDriver = null;
        WebDriverManager.chromedriver().setup();
        cromeZaleniumOpt.addArguments("--disable-gpu");
        cromeZaleniumOpt.addArguments("--start-maximized");
        cromeZaleniumOpt.addArguments("--no-sandbox");
        cromeZaleniumOpt.addArguments("--ignore-certificate-errors");
        cromeZaleniumOpt.addArguments("--disable-popup-blocking");
        cromeZaleniumOpt.addArguments("--window-size=1920,1080");
        cromeZaleniumOpt.addArguments("--disable-dev-shm-usage");
        cromeZaleniumOpt.addArguments("--lang=es");
        cromeZaleniumOpt.setCapability("name", testName);
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(url), cromeZaleniumOpt);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return remoteWebDriver;
    }
}
