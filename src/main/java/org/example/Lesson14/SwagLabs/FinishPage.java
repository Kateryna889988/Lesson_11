package org.example.Lesson14.SwagLabs;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FinishPage {
    By FinishLocator = By.xpath("//button[contains(@name, 'finish')]");


    private final ChromeDriver driver;

    public FinishPage(ChromeDriver driver) {
        this.driver = driver;
    }

    @Step()
    public FinishPage clickFinish() {
        By xpath = FinishLocator;
        driver.findElement(xpath).click();
        return this;
    }
    @Step()
    public String getСompletedPurchase() {
        WebElement element = driver.findElement(By.xpath("//h2[(contains(@class,'complete-header'))]"));
        return element.getText();
    }

    public void explicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
