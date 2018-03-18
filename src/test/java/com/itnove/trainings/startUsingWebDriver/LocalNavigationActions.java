package com.itnove.trainings.startUsingWebDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by guillem on 14/04/15.
 */
public class LocalNavigationActions extends Locators {
    public static long timeOut = 120;
    protected final WebDriver driver;
    public final LocalRemoteWebDriverWait wait;

    public LocalNavigationActions(WebDriver driver) {
        this.driver = driver;
        this.wait =
                new LocalRemoteWebDriverWait(driver, timeOut);
    }

    public static void click(WebElement webElement) {
        webElement.click();
    }

    public static void click(WebDriver driver, String objectId) {
        driver.findElement(identifyLocationStrategy(objectId)).click();
    }

    public static WebElement getLastWebelement(WebDriver driver, String locator) {
        List<WebElement> elements = driver.findElements(identifyLocationStrategy(locator));
        return elements.get(elements.size() - 1);
    }

    public static WebElement getFirstWebelement(WebDriver driver, String locator) {
        List<WebElement> elements = driver.findElements(identifyLocationStrategy(locator));
        return elements.get(0);
    }

    public static int countElementsFromXpath(WebDriver driver, String locator) {
        List<WebElement> elements = driver.findElements(identifyLocationStrategy(locator));
        return elements.size();
    }

    public static boolean elementExists(WebDriver driver, By by) {
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static void hoverAndClick(WebDriver driver, WebElement webElement) {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).moveToElement(webElement).click(webElement).build()
                .perform();
    }

    public static void hoverAndClick(WebDriver driver, By by) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by)).click(driver.findElement(by)).build()
                .perform();
    }

    public static void hoverAndClick(WebDriver driver, String objectId) {
        Actions action = new Actions(driver);
        WebElement elem = driver.findElement(identifyLocationStrategy(objectId));
        action.moveToElement(elem).moveToElement(elem).click(elem).build().perform();
    }

    public static void hoverElement(WebDriver driver, String objectId) {
        Actions action = new Actions(driver);
        WebElement elem = driver.findElement(identifyLocationStrategy(objectId));
        action.moveToElement(elem).moveToElement(elem).perform();

    }

    public static void hoverElement(WebDriver driver, WebElement webElement) {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).moveToElement(webElement).perform();
    }

    public static WebElement getLastWebelement(WebDriver driver, List<WebElement> webElements) {
        return webElements.get(webElements.size() - 1);
    }

    public static WebElement getFirstWebelement(WebDriver driver, List<WebElement> webElements) {
        return webElements.get(0);
    }

    public static int countElementsFromXpath(WebDriver driver, List<WebElement> webElements) {
        return webElements.size();
    }

    public static boolean WebElementExists(WebDriver driver, WebElement webElement) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            webElement.isEnabled();
        } catch (NoSuchElementException e) {
            driver.manage().timeouts()
                    .implicitlyWait(timeOut,
                            TimeUnit.MILLISECONDS);
            System.out.println(e);
            return false;
        }
        driver.manage().timeouts()
                .implicitlyWait(timeOut,
                        TimeUnit.MILLISECONDS);
        return true;
    }

    public static boolean WebElementExists(WebDriver driver, WebElement webElement, boolean logInfo) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            webElement.isEnabled();
        } catch (NoSuchElementException e) {
            driver.manage().timeouts()
                    .implicitlyWait(timeOut,
                            TimeUnit.MILLISECONDS);
            if (logInfo) {
                System.out.println(e);
            }
            return false;
        }
        driver.manage().timeouts()
                .implicitlyWait(timeOut,
                        TimeUnit.MILLISECONDS);
        return true;
    }

    public static Boolean WaitForElement(WebDriver driver, WebElement element) {
        try {
            WebElement elementResponse =
                    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element));
            return WebElementExists(driver, elementResponse);
        } catch (TimeoutException TimeOut) {
            System.out.println(TimeOut);
            return false;
        }
    }

    /**
     * Method  used check if a WebElement exists and it's displayed.
     *
     * @param driver
     * @param elementToCheck
     * @return
     */
    public static boolean elementPresent(WebDriver driver, WebElement elementToCheck) {
        if (WebElementExists(driver, elementToCheck) && elementToCheck.isDisplayed()) {
            return true;
        } else
            return false;
    }

    public static boolean elementPresent(WebDriver driver, WebElement elementToCheck, boolean logInfo) {
        if (WebElementExists(driver, elementToCheck, logInfo) && elementToCheck.isDisplayed()) {
            return true;
        } else
            return false;
    }

    /**
     * This method return the Xpath location from a (Xpath)WebElement return -1 if error
     *
     * @param element
     * @return
     */
    public static String getXpathLocatorFronWebElement(WebElement element) {
        String xpahtLocation = element.toString();
        try {
            xpahtLocation =
                    xpahtLocation.substring(xpahtLocation.indexOf("//"), xpahtLocation.length() - 1)
                            .trim();
        } catch (Exception e) {
            System.out.println(e);
            xpahtLocation = "-1";
        }
        return xpahtLocation;
    }

    /**
     * this method wait for element be presents (20000)
     * return true if the elemnt is found or false
     *
     * @param driver
     * @param element
     * @param wait
     * @return
     */
    public static boolean waitForElementPresent(WebDriver driver, WebElement element,
                                                LocalRemoteWebDriverWait wait) {
        int i = 0;
        while (!WebElementExists(driver, element) && i < 20) {
            wait.pause(1000);
            i++;
        }
        return WebElementExists(driver, element);
    }

    public void listIframesFromPage(WebDriver driver) {
        final List<WebElement> iframes = driver.findElements(By.tagName("frame"));
        for (WebElement iframe : iframes) {
            System.out.println(iframe.getAttribute("id"));
            System.out.println(iframe.getAttribute("name"));
        }
    }
}