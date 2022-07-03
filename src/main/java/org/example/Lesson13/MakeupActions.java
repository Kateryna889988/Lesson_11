package org.example.Lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MakeupActions {
    private ChromeDriver сhromeDriver;

    public MakeupActions(ChromeDriver сhromeDriver) {
        this.сhromeDriver = сhromeDriver;
    }

    public void explicitWait() {
        сhromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openSite() {
        сhromeDriver.get("https://makeup.com.ua/ua/");
    }

    public void implicitWait() {
        String elementForWaiting = "//div[contains(@data-popup-handler, 'auth')]";
        WebElement element = (new WebDriverWait(сhromeDriver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementForWaiting)));
    }

    public boolean isMobile() {
        int windowSize = сhromeDriver.manage().window().getSize().width;
        return windowSize <= 1000;
    }

    public WebElement getUserAccountElement() {
        String xpathMobile = "//div[contains(@data-popup-handler, 'auth') and (contains(@class, 'header-office'))]";
        String xpathDesktop = "//div[contains(@data-popup-handler, 'auth') and (contains(text(),'Вхід до кабінету'))]";
        String xpath = isMobile() ? xpathMobile : xpathDesktop;
        return сhromeDriver.findElement(By.xpath(xpath));
    }

    public WebElement getLoginElement() {
        return сhromeDriver.findElement(By.xpath("//input[contains(@name, 'user_login')]"));
    }

    public WebElement getPasswordElement() {
        return сhromeDriver.findElement(By.xpath("//input[contains(@name, 'user_pw')]"));
    }

    public WebElement getLoginButtonElement() {
        return сhromeDriver.findElement(By.xpath("//button[(contains(text(),'Увійти'))]"));
    }

    public WebElement getSelectProduct() {
        return сhromeDriver.findElement(By.xpath("//div[(contains(@class,'simple-slider-list__link'))]/a[contains(@href, '/ua/product/657505/')]"));
    }

    public WebElement getBuy() {
        return сhromeDriver.findElement(By.xpath("//div[(contains(@data-id,'657505'))]/div/div[(contains(.,'Купити'))]"));
    }

    public WebElement getCheckout() {
        return сhromeDriver.findElement(By.xpath("//div[(contains(@class,'align-center'))]/div[(contains(., 'Оформити замовлення'))]"));
    }


    public String getAuthorizedElement() {
        WebElement element = сhromeDriver.findElement(By.xpath("//div[(contains(@class,'layout'))]/div[(contains(., 'Кабінет'))]"));
        return element.getText();
    }

    public String getСompletedPurchase() {
        WebElement element = сhromeDriver.findElement(By.xpath("//h1[(contains(@class,'page-header'))]"));
        return element.getText();
    }
}

