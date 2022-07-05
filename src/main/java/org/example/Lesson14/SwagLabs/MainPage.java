package org.example.Lesson14.SwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {
    By ProductSelectionLocator = By.xpath("//button[contains(@name, 'add-to-cart-sauce-labs-backpack')]");


    private final ChromeDriver driver;

    public MainPage(ChromeDriver driver) {
        this.driver = driver;
    }


    public AddBucketPage selectionsProduct() {
        By xpath = ProductSelectionLocator;
        driver.findElement(xpath).click();
        return new AddBucketPage(driver);
    }
}
