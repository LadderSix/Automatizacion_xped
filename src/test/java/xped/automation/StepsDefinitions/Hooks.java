package xped.automation.StepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import xped.automation.util.WebDriver.WebDriverFactory;

public class Hooks {

    private WebDriver driver;
    private static String nombreTest;
    protected static final Logger log = LogManager.getLogger();

    @Before
    public void openBrowser(Scenario scenario) {
        nombreTest = scenario.getName();
        log.debug("Se va a ejecutar el scenario: %s".formatted(nombreTest));
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createWebDriver(nombreTest);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            try {
                scenario.log("URL de pagina actual: %s".formatted(driver.getCurrentUrl()));
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", nombreTest);
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                log.error(somePlatformsDontSupportScreenshots.getMessage());
            }
        }

        try {
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.error("Fallo en ejecución: tearDown, Exception: %s".formatted(e.getMessage()));
        }
    }
}