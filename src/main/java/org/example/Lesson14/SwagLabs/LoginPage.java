package org.example.Lesson14.SwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPage {
    By userLoginLocator = By.xpath("//input[contains(@name, 'user-name')]");
    By userPasswordLocator = By.xpath("//input[contains(@name, 'password')]");
    By loginButtonLocator = By.xpath("//input[contains(@name, 'login-button')]");


    private final ChromeDriver driver;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }


    public LoginPage userLogin(String login) {
        By xpath = userLoginLocator;
        driver.findElement(xpath).sendKeys(login);
        return this;
    }

    public LoginPage userPassword(String password) {
        By xpath = userPasswordLocator;
        driver.findElement(xpath).sendKeys(password);
        return this;
    }

    public MainPage clickLoginButton() {
        By xpath = loginButtonLocator;
        driver.findElement(xpath).click();
        return new MainPage(driver);
    }

    public String getAuthorizedElement() {
        WebElement element = driver.findElement(By.xpath("//span[(contains(@class,'title'))]"));
        return element.getText();
    }

    public void explicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public LoginPage openSite() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }
}
