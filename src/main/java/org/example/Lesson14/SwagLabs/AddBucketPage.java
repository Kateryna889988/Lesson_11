package org.example.Lesson14.SwagLabs;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddBucketPage {
    By BucketLocator = By.xpath("//a[contains(@class, 'shopping_cart_link')]");


    private final ChromeDriver driver;


    public AddBucketPage(ChromeDriver driver) {
        this.driver = driver;
    }

    @Step()
    public VerificationPage addBucket() {
        By xpath = BucketLocator;
        driver.findElement(xpath).click();
        return new VerificationPage(driver);
    }
}
