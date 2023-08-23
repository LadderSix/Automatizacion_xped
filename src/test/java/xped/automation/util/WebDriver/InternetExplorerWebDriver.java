package xped.automation.util.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class InternetExplorerWebDriver implements IWebDriver {

    InternetExplorerOptions ieo;

    public InternetExplorerWebDriver() {
        ieo = new InternetExplorerOptions();
    }

    @Override
    public WebDriver setUpWebDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver(ieo);
    }
}
