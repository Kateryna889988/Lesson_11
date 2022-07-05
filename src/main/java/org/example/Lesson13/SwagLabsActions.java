package org.example.Lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLabsActions {
    private ChromeDriver сhromeDriver;

    public SwagLabsActions(ChromeDriver сhromeDriver) {
        this.сhromeDriver = сhromeDriver;
    }

    public void explicitWait() {
        сhromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openSite() {
        сhromeDriver.get("https://www.saucedemo.com/");
    }

    public void implicitWait() {
        String elementForWaiting = "//input[contains(@name, 'user-name')]";
        WebElement element = (new WebDriverWait(сhromeDriver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementForWaiting)));
    }

    public WebElement getUsernameElement() {
        return сhromeDriver.findElement(By.xpath("//input[contains(@name, 'user-name')]"));
    }

    public WebElement getPasswordElement() {
        return сhromeDriver.findElement(By.xpath("//input[contains(@name, 'password')]"));
    }

    public WebElement getLoginButtonElement() {
        return сhromeDriver.findElement(By.xpath("//input[contains(@name, 'login-button')]"));
    }



    public WebElement getSelectProduct() {
        return сhromeDriver.findElement(By.xpath("//button[contains(@name, 'add-to-cart-sauce-labs-backpack')]"));
    }

    public WebElement getAddToBucket() {
        return сhromeDriver.findElement(By.xpath("//a[contains(@class, 'shopping_cart_link')]"));
    }

    public WebElement getVerify() {
        return сhromeDriver.findElement(By.xpath("//button[contains(@name, 'checkout')]"));
    }


    public WebElement getFirstName() {
        return сhromeDriver.findElement(By.xpath("//input[contains(@name, 'firstName')]"));
    }


    public WebElement getLastName() {
        return сhromeDriver.findElement(By.xpath("//input[contains(@name, 'lastName')]"));
    }


    public WebElement getPostalCode() {
        return сhromeDriver.findElement(By.xpath("//input[contains(@name, 'postalCode')]"));
    }


    public WebElement getProceed() {
        return сhromeDriver.findElement(By.xpath("//input[contains(@name, 'continue')]"));
    }

    public WebElement getFinish() {
        return сhromeDriver.findElement(By.xpath("//button[contains(@name, 'finish')]"));
    }

    public String getAuthorizedElement() {
        WebElement element = сhromeDriver.findElement(By.xpath("//span[(contains(@class,'title'))]"));
        return element.getText();
    }

    public String getСompletedPurchase() {
        WebElement element = сhromeDriver.findElement(By.xpath("//h2[(contains(@class,'complete-header'))]"));
        return element.getText();
    }
}

