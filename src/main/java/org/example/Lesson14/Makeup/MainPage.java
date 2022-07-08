package org.example.Lesson14.Makeup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    By CategorySelectionLocator = By.xpath("//li[(contains(@class,'menu-list__item full'))]/a[contains(@href, '/ua/categorys/20272/')]");
    By ProductSelectionLocator = By.xpath("//div[(contains(@class,'simple-slider-list__link'))]/a[contains(@href, '/ua/product/657505/')]");


    private final ChromeDriver driver;

    public MainPage(ChromeDriver driver) {
        this.driver = driver;
    }


    public FilterPage selectionCategory() {
        By xpath = CategorySelectionLocator;
        driver.findElement(xpath).click();
        return new FilterPage(driver);
    }

    public ProductPage selectionProduct() {
        By xpath = ProductSelectionLocator;
        driver.findElement(xpath).click();
        return new ProductPage(driver);
    }

    public MainPage implicitWait() {
        String elementForWaiting = "//div[contains(@data-popup-handler, 'auth')]";
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementForWaiting)));
        return this;
    }
}


