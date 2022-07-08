package org.example.Lesson14.Makeup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage {

    By BrandChoiceLocator = By.xpath("//li[(contains(@class,'catalog-checkbox-list__item has-action'))]/a[contains(@href, '/ua/brand/1542095/\')]");
    By ProductSelectionLocator = By.xpath("//div[(contains(@class,'simple-slider-list__link'))]/a[contains(@href, '/ua/product/657505/')]");


    private final ChromeDriver driver;

    public FilterPage(ChromeDriver driver) {
        this.driver = driver;
    }


    public FilterPage choiceBrand() {
        By xpath = BrandChoiceLocator;
        driver.findElement(xpath).click();
        return this;
    }

    public ProductPage selectionProduct() {
        By xpath = ProductSelectionLocator;
        driver.findElement(xpath).click();
        return new ProductPage(driver);
    }

    public String getFilteredProduct() {
        WebElement element = driver.findElement(By.xpath("//div[(contains(@class,'bread-crumbs'))]/ol[contains(@itemtype, 'https://schema.org/BreadcrumbList')]"));
        return element.getText();
    }

    public void explicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public FilterPage implicitWait() {
        String elementForWaiting = "//div[contains(@data-popup-handler, 'auth')]";
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementForWaiting)));
        return this;
    }
}
