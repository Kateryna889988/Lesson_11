package org.example.Lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MakeupActions {
    private ChromeDriver driver;

    public MakeupActions(ChromeDriver сhromeDriver) {
        this.driver = сhromeDriver;
    }

    public void explicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openSite() {
        driver.get("https://makeup.com.ua/ua/");
    }

    public void implicitWait() {
        String elementForWaiting = "//div[contains(@data-popup-handler, 'auth')]";
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementForWaiting)));
    }

    public boolean isMobile() {
        int windowSize = driver.manage().window().getSize().width;
        return windowSize <= 1000;
    }

    public WebElement getUserAccountElement() {
        String xpathMobile = "//div[contains(@data-popup-handler, 'auth') and (contains(@class, 'header-office'))]";
        String xpathDesktop = "//div[contains(@data-popup-handler, 'auth') and (contains(text(),'Вхід до кабінету'))]";
        String xpath = isMobile() ? xpathMobile : xpathDesktop;
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getLoginElement() {
        return driver.findElement(By.xpath("//input[contains(@name, 'user_login')]"));
    }

    public WebElement getPasswordElement() {
        return driver.findElement(By.xpath("//input[contains(@name, 'user_pw')]"));
    }

    public WebElement getLoginButtonElement() {
        return driver.findElement(By.xpath("//button[(contains(text(),'Увійти'))]"));
    }



    public WebElement getSelectProduct() {
        return driver.findElement(By.xpath("//div[(contains(@class,'simple-slider-list__link'))]/a[contains(@href, '/ua/product/657505/')]"));
    }


    public WebElement getBuy() {
        return driver.findElement(By.xpath("//div[(contains(@data-id,'657505'))]/div/div[(contains(.,'Купити'))]"));
    }

    public WebElement goToBucket() {
        return driver.findElement(By.xpath("//div[(contains(@class,'header-basket'))]/span[(contains(.,'Кошик'))]"));
    }

    public WebElement getCheckout() {
        return driver.findElement(By.xpath("//div[(contains(@class,'align-center'))]/div[(contains(., 'Оформити замовлення'))]"));
    }

    public String getAuthorizedElement() {
        WebElement element = driver.findElement(By.xpath("//div[(contains(@class,'layout'))]/div[(contains(., 'Кабінет'))]"));
        return element.getText();
    }

    public String getСompletedPurchase() {
        WebElement element = driver.findElement(By.xpath("//h1[(contains(@class,'page-header'))]"));
        return element.getText();
    }




    public WebElement getCategorySelection() {
        return driver.findElement(By.xpath("//li[(contains(@class,'menu-list__item full'))]/a[contains(@href, '/ua/categorys/20272/')]"));
    }

    public WebElement getBrandChoice() {
        return driver.findElement(By.xpath("//li[(contains(@class,'catalog-checkbox-list__item has-action'))]/a[contains(@href, '/ua/brand/1542095/\')]"));
    }

    public WebElement getProductSelection() {
        return driver.findElement(By.xpath("//div[(contains(@class,'simple-slider-list__link'))]/a[contains(@href, '/ua/product/657505/')]"));
    }




    public WebElement getLeaveFeedback() {
        return driver.findElement(By.xpath("//div[(contains(@class,'align-center'))]/div[contains(@class, 'add-comment button-more')]"));
    }

    public WebElement getNameUser() {
        return driver.findElement(By.xpath("//div[(contains(@class,'input-wrap'))]/input[contains(@id, 'comments-name')]"));
    }

    public WebElement getEmailUser() {
        return driver.findElement(By.xpath("//div[(contains(@class,'input-wrap'))]/input[contains(@id, 'mail')]"));
    }

    public WebElement getGradeUser() {
        return driver.findElement(By.xpath("//div[(contains(@class,'stars-wrap'))]/ul[contains(@class, 'stars')]"));
    }

    public WebElement getMessageUser() {
        return driver.findElement(By.xpath("//div[(contains(@class,'input-wrap'))]/textarea[contains(@name, 'body')]"));
    }

    public WebElement getAddMessage() {
        return driver.findElement(By.xpath("//div[(contains(@class,'private-office__row status'))]/button[contains(@class, 'button')]"));
    }

    public String getFilteredProduct() {
        WebElement element = driver.findElement(By.xpath("//div[(contains(@class,'bread-crumbs'))]/ol[contains(@itemtype, 'https://schema.org/BreadcrumbList')]"));
        return element.getText();
    }

    public String getAddedFeedback() {
        WebElement element = driver.findElement(By.xpath("//div[(contains(@class,'popup__window message active'))]/div[contains(@class, 'popup-content')]"));
        return element.getText();
    }
}
