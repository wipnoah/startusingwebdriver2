package com.itnove.trainings.startUsingWebDriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNull;

public class CheckBoxesTest extends BaseTest {
    @Test
    public void testApp() {
        //1
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        //2
        WebElement checkbox2 =
                driver.findElement(By.xpath(".//*[@id='checkboxes']/input[2]"));
        assertTrue(checkbox2.getAttribute("checked").equals("true"));
        //2.1
        WebElement checkbox1 =
                driver.findElement(By.xpath(".//*[@id='checkboxes']/input[1]"));
        assertNull(checkbox1.getAttribute("checked"));
        //3
        checkbox1.click();
        //4
        assertTrue(checkbox1.getAttribute("checked").equals("true"));
    }
}
