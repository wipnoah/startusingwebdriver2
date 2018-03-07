package com.itnove.trainings.junit.startUsingWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.File;

import static junit.framework.TestCase.assertTrue;


/**
 * Unit test for simple App.
 */
public class UploadTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "logo.png");
        fileUpload.sendKeys(file.getAbsolutePath());
        WebElement buttonUpload = driver.findElement(By.id("file-submit"));
        buttonUpload.click();
        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        wait.until(ExpectedConditions.visibilityOf(uploadedFiles));
        assertTrue(uploadedFiles.isDisplayed());
    }

}