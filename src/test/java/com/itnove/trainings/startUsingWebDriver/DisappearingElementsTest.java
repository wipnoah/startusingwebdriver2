package com.itnove.trainings.startUsingWebDriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Unit test for simple App.
 */
public class DisappearingElementsTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/disappearing_elements");
        for (int i = 0; i < 10; i++) {
            WebElement elementsDelMenu =
                    driver.findElement(
                            By.xpath(".//*[@id='content']/div/ul/li[last()]"));
            elementsDelMenu.click();
            driver.navigate().back();
            driver.navigate().refresh();
        }
    }
}
