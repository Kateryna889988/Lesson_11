package org.example.Lesson14.Makeup;

import org.example.Lesson14.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FilterPage extends BasePage {
    
    By ClickBrandChoiceLocator = By.xpath("//li[(contains(@class,'action brands__item'))]/a[contains(@href, '/ua/brand/1542095/')]");
    
    By ProductSelectionLocator = By.xpath("//div[(contains(@class,'simple-slider-list__link'))]/a[contains(@href, '/ua/product/657505/')]");

    public FilterPage(ChromeDriver driver) {
        super(driver);
    }


    public FilterPage clickChoiceBrand() {
        super.safeClick(ClickBrandChoiceLocator);
        return new FilterPage(driver);
    }

    public ProductPage selectionProduct() {
        super.safeFocusAndClick(ProductSelectionLocator);
        return new ProductPage(driver);
    }

    public String getFilteredProduct() {
        WebElement element = driver.findElement(By.xpath("//div[(contains(@class,'bread-crumbs'))]/ol[contains(@itemtype, 'https://schema.org/BreadcrumbList')]"));
        return element.getText();
    }

    public FilterPage waitFilterPage() {
        super.implicitlyWait();
        return this;
    }

    public FilterPage waitBrandChoice() {
        super.waitClickableElement(ClickBrandChoiceLocator);
        return this;
    }

    public FilterPage waitProductSelection() {
        super.waitClickableElement(ProductSelectionLocator);
        return this;
    }

    public FilterPage waitChoiceBrand() {
        super.waitClickableElement(ClickBrandChoiceLocator);
        return this;
    }
}
