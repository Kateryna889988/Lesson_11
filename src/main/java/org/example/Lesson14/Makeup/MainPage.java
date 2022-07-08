package org.example.Lesson14.Makeup;

import org.example.Lesson14.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage extends BasePage {

    By BrandSelectionLocator = By.xpath("//li[(contains(@class,'menu-list__item full'))]/a[contains(@href, '/ua/brand/')]");
    By ProductSelectionLocator = By.xpath("//div[(contains(@class,'simple-slider-list__link'))]/a[contains(@href, '/ua/product/657505/')]");

    public MainPage(ChromeDriver driver) {
        super(driver);
    }

    public ProductPage selectionProduct() {
        By xpath = ProductSelectionLocator;
        driver.findElement(xpath).click();
        return new ProductPage(driver);
    }

    public MainPage waitBrandSelection() {
        super.waitClickableElement(BrandSelectionLocator);
        return this;
    }

    public FilterPage selectionBrand() {
        super.safeClick(BrandSelectionLocator);
        return new FilterPage(driver);
    }
}


