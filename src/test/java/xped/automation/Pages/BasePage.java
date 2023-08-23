package xped.automation.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import xped.automation.util.PropertyReader;
import xped.automation.util.WebDriver.WebDriverFactory;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final int TIMEOUT = Integer
            .parseInt(PropertyReader.getProperty("webdriver.timeout"));

    private static final int POLLING = Integer
            .parseInt(PropertyReader.getProperty("webdriver.polling"));

    /**
     * Constructor de clase en el cual se setea un wait de elementos, el WebDriver e
     * inicializa los elementos de una clase Page usando initElements de PageFactory
     */
    public BasePage() {
        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(POLLING));
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, TIMEOUT), this);
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void sendKeys(WebElement webElement, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void sendKeys(WebElement webElement, Keys key) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.sendKeys(key);
    }

    public void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public void scrollToAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Esto hará scroll hasta que el elemento esté a la vista:
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        // Una vez que el elemento está a la vista, puedes hacer click en él:
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public String getText(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public String getAttributeValue(WebElement webElement, String attributeName) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute(attributeName);
    }

    public void selectOptionByIndex(WebElement webElement, int index) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        select.selectByIndex(index);
    }

    public int getSelectedOptionIndex(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        return select.getOptions().indexOf(select.getFirstSelectedOption());
    }

    public void selectOptionByText(WebElement webElement, String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        select.selectByVisibleText(text);
    }

    public String getSelectedOptionText(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        return select.getFirstSelectedOption().getText();
    }

    public void selectOptionByValue(WebElement webElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        select.selectByValue(value);
    }

    public String getSelectedOptionValue(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        return select.getFirstSelectedOption().getAttribute("value");
    }

    public String getOptionTextByIndex(WebElement webElement, int index) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        return select.getOptions().get(index).getText();
    }

    public int getOptionIndexByText(WebElement webElement, String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        List<WebElement> optionList = select.getOptions();
        int index = -1;
        for (int i = 0; i < optionList.size(); i++) {
            if (optionList.get(i).getText().trim().contentEquals(text.trim())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void waitForElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementToBeInvisible(WebElement webElement) {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public boolean isDisplayed(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
    }

    public boolean isDisplayedAndClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement)).isDisplayed();
    }

    public static boolean isElementExist(WebDriver driver, By by) {
        return driver.findElements(by).size() > 0;
    }

    public static void esperoQueElementoDeCargaDesaparezca(String xpath, WebDriver driver) {
        boolean run = true;

        while (run) {
            try {
                WebElement elemento;

                esperar(1);
                //log.debug("esperando que spiner de carga desaparezca");

                elemento = new WebDriverWait(driver, Duration.ofSeconds(1), Duration.ofMillis(20))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

                if (!elemento.isDisplayed()) {
                    run = false;
                }
            } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
                run = false;
            }
        }
    }

    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeVisible(By by, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeVisible(By by, int timeout, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ignored) {
        }
    }

    public static WebElement waitForElementToBeVisible(WebElement element, WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisibleAndClickable(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void actionClick(WebElement element, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public static void actionMoveMouse(WebElement element, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
