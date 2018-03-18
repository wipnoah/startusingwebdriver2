package com.itnove.trainings.startUsingWebDriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Unit test for simple App.
 */
public class DropdownTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver
                .navigate().to("https://the-internet.herokuapp.com/dropdown");
        List<WebElement> options =
                driver.findElements(By.xpath(".//*[@id='dropdown']/option"));
        for (int i = 2; i <= options.size(); i++) {
            WebElement option =
                    driver.findElement(
                            By.xpath(".//*[@id='dropdown']/option[" + i + "]"));
            option.click();
        }
    }
}
