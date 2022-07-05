package org.example.Lesson14.Makeup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BucketPage {
    By BucketLocator = By.xpath("//div[(contains(@class,'header-basket'))]/span[(contains(.,'Кошик'))]");
    By CheckoutLocator = By.xpath("//div[(contains(@class,'align-center'))]/div[(contains(., 'Оформити замовлення'))]");


    private final ChromeDriver driver;

    public BucketPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public BucketPage bucket() {
        By xpath = BucketLocator;
        driver.findElement(xpath).click();
        return this;
    }

    public BucketPage checkout() {
        By xpath = CheckoutLocator;
        driver.findElement(xpath).click();
        return this;
    }

    public String getСompletedPurchase() {
        WebElement element = driver.findElement(By.xpath("//h1[(contains(@class,'page-header'))]"));
        return element.getText();
    }

    public void explicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
