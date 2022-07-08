package org.example.Lesson14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final ChromeDriver driver;

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
    }

    protected void waitClickableElement(By elementForWaiting) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.elementToBeClickable(elementForWaiting));
    }

    protected void implicitlyWait() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        driverWait.until(pageLoadCondition);
    }

    protected void safeClick(By elementForWaiting) {
        try {
            WebElement date = driver.findElement(elementForWaiting);
            date.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement date = driver.findElement(elementForWaiting);
            date.click();
        }
    }

    protected void safeFocusAndClick(By elementForWaiting) {
        try {
            WebElement date = driver.findElement(elementForWaiting);
            new Actions(driver).moveToElement(date).perform();
            date.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement date = driver.findElement(elementForWaiting);
            new Actions(driver).moveToElement(date).perform();
            date.click();
        }
    }
}
