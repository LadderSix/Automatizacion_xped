package xped.automation.util.WebDriver;

import org.openqa.selenium.WebDriver;
import xped.automation.util.PropertyReader;

/**
 * Clase Utilitaria que setea los drivers a utilizar para el Browser deseado según
 * el navegador definido en la propiedad de sistema "browser".
 * Por defecto el browser que se abrirá será chrome.
 */
public class WebDriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * Crea un driver específico al navegador definido en la propiedad de sistema "browser".
     * Posteriormente devuelve el driver específico al Thread desde donde se llama.
     * @param nombreTest (Opcional) Nombre del Test o Escenario para determinar el nombre en Zalenium y Docker
     * @return Devuelve un WebDriver específico para un Thread.
     */
    public WebDriver createWebDriver(String nombreTest) {

        String webDriver = System.getProperty("browser", "chrome");

        switch (webDriver) {
            case "firefox" -> {
                IWebDriver firefoxDriver = new FirefoxWebDriver();
                tlDriver.set(firefoxDriver.setUpWebDriver());
                return getDriver();
            }
            case "chrome" -> {
                IWebDriver chromeDriver = new ChromeWebDriver();
                tlDriver.set(chromeDriver.setUpWebDriver());
                return getDriver();
            }
            case "ie" -> {
                IWebDriver ieDriver = new InternetExplorerWebDriver();
                tlDriver.set(ieDriver.setUpWebDriver());
                return getDriver();
            }
            default -> throw new RuntimeException("Webdriver no soportado: " + webDriver);
        }
    }

    /**
     * Método para obtener el driver creado con el método createWebDriver()
     * @return Retorna el driver específico según el Thread que creo el Driver.
     */
    public static  WebDriver getDriver() {
        return tlDriver.get();
    }

}
