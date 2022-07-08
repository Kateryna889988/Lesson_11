package org.example.Lesson14.SwagLabs;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationPage {

    By VerificationLocator = By.xpath("//button[contains(@name, 'checkout')]");
    By FirstNameUserLocator = By.xpath("//input[contains(@name, 'firstName')]");
    By LastNameUserLocator = By.xpath("//input[contains(@name, 'lastName')]");
    By PostalCodeUserLocator = By.xpath("//input[contains(@name, 'postalCode')]");
    By ContinueLocator = By.xpath("//input[contains(@name, 'continue')]");


    private final ChromeDriver driver;

    public VerificationPage(ChromeDriver driver) {
        this.driver = driver;
    }

    @Step()
    public VerificationPage clickCheckout() {
        By xpath = VerificationLocator;
        driver.findElement(xpath).click();
        return new VerificationPage(driver);
    }

    @Step()
    public VerificationPage completeFields(String firstName, String lastName, String postalCode) {
        By xpath1 = FirstNameUserLocator;
        By xpath2 = LastNameUserLocator;
        By xpath3 = PostalCodeUserLocator;
        driver.findElement(xpath1).sendKeys(firstName);
        driver.findElement(xpath2).sendKeys(lastName);
        driver.findElement(xpath3).sendKeys(postalCode);
        return this;
    }

    @Step()
    public FinishPage clickContinue() {
        By xpath = ContinueLocator;
        driver.findElement(xpath).click();
        return new FinishPage(driver);
    }
}


