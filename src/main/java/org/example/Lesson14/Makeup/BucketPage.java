package org.example.Lesson14.Makeup;

import org.example.Lesson14.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BucketPage extends BasePage {
    By BucketLocator = By.xpath("//div[(contains(@class,'header-basket'))]/span[(contains(.,'Кошик'))]");
    By CheckoutLocator = By.xpath("//div[(contains(@class,'align-center'))]/div[(contains(., 'Оформити замовлення'))]");

    public BucketPage(ChromeDriver driver) {
        super(driver);
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

    public BucketPage waitBucketPage() {
        super.implicitlyWait();
        return this;
    }

    public BucketPage waitBucket() {
        super.waitClickableElement(BucketLocator);
        return this;
    }

    public BucketPage waitCheckout() {
        super.waitClickableElement(CheckoutLocator);
        return this;
    }
}

