package com.itnove.trainings.startUsingWebDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseSauceLabsRemoteWebDriverTest {
    public RemoteWebDriver driver;
    public Actions hover;
    public static long timeOut = 120;
    public static LocalRemoteWebDriverWait wait;
    public static JavascriptExecutor jse;

    @BeforeMethod
    public void setUp() throws IOException {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new
                URL("http://itnove:4394d787-3244-4c03-9490-3816f2bb683b@ondemand.saucelabs.com:80/wd/hub"),
                caps);
        wait = new LocalRemoteWebDriverWait(driver, timeOut);
        hover = new Actions(driver);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(timeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
