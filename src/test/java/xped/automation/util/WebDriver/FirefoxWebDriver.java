package xped.automation.util.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FirefoxWebDriver implements IWebDriver {

    private final ProfilesIni profileIni;
    private final FirefoxProfile profile;
    private final FirefoxOptions firefoxOpt;

    public FirefoxWebDriver() {
        profileIni = new ProfilesIni();
        profile = profileIni.getProfile("default");
        firefoxOpt = new FirefoxOptions();
    }

    @Override
    public WebDriver setUpWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("browser.safebrowsing.enabled", false);
        profile.setPreference("extensions.blocklist.enabled", false);
        profile.setPreference("browser.tabs.warnOnClose", false);
        profile.setPreference("browser.tabs.warnOnOpen", false);
        profile.setPreference("browser.safebrowsing.malware.enabled", false);
        profile.setPreference("webdriver_accept_untrusted_certs", true);
        profile.setPreference("webdriver_enable_native_events", true);
        profile.setPreference("webdriver_assume_untrusted_issuer", true);
        firefoxOpt.addArguments("-private");
        firefoxOpt.setProfile(profile);
        return new FirefoxDriver(firefoxOpt);
    }
}
